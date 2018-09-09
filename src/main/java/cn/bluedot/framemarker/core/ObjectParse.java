package cn.bluedot.framemarker.core;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.bluedot.framemarker.common.BoSuper;
import cn.bluedot.framemarker.common.TestBo;
import cn.bluedot.framemarker.parse.BoConfig;
import cn.bluedot.framemarker.parse.Config;
import cn.bluedot.framemarker.parse.FieldConfig;
import cn.bluedot.framemarker.parse.PoConfig;
import cn.bluedot.framemarker.parse.Ref;

/**
 * 将po对象的相关操作翻译成SQL
 * @author asus
 *
 */
public class ObjectParse {
    
    private static final int INSERT_VIEW = 1;
    private static final int WHERE_CONDITION = 2;
    private static final int SET_VALUE = 3;
    private static final int SET_KEY = 4;
    private static final BaseDao bd = new BaseDao();
    
    /**
     * 
     * @param clazz 类的class
     * @return 返回该类对应的表名
     */
    private static String getTableName(Class clazz){
        //System.out.println(clazz);
        String ClassName = clazz.getName(); 
        return ClassName.substring(ClassName.lastIndexOf(".") + 1);
    }
    
    /**
     * 
     * @param obj      进行操作的对象
     * @param list     装载操作的数据
     * @param notwhere 进行哪种形式的操作
     * @return 返回sql语句的数据条件区，或者返回sql语句的显示区。只适用于增删改
     */
    
    private String getParaName(Object obj, List<Object> list, int notwhere){
        Class clazz = obj.getClass();
        Field []fields = clazz.getDeclaredFields();
        String str = "";

        for(Field field : fields){
            String fieldName = field.getName();
            
            try {
                Object o = clazz.getDeclaredMethod("get"+ getOneUpString(fieldName)).invoke(obj);
                if(o != null){
                    list.add(o);
                    if(notwhere == ObjectParse.INSERT_VIEW){        
                        str += ","+ fieldName;
                      
                    }else if(notwhere == ObjectParse.WHERE_CONDITION){
                        str += " and "+ fieldName+ "=?"; 
               
                    }else if(notwhere == ObjectParse.SET_VALUE){
                        str += ","+ fieldName+ "=?";
                    }else if(notwhere == ObjectParse.SET_KEY){
                        if(!Config.getKey(clazz.getName()).equals(fieldName)){
                            str += ","+ fieldName+ "=?";
                        }
                    }
                }
            } catch(Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           
        }
        
        return str;
    }
    
    /**
     * 
     * @param name   需要转换的字符串
     * @return  首字母大写其他字母小写的字符串
     */
    public static String getOneUpString(String name){
        return name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
    }
    
    /**
     * 
     * @param obj   需要插入到数据库的对象
     * @return      是否插入成功
     * @throws SQLException 
     */
    public int insertparsetoSQL(Object obj) throws SQLException{ 
        StringBuilder sql = new StringBuilder("insert into");
        Class clazz = obj.getClass();
        
        List<Object> list = new ArrayList<>();
        
        sql.append(" " + getTableName(clazz) + "(");
        sql.append(getParaName(obj, list, ObjectParse.INSERT_VIEW).substring(1));
        
        sql.append(")");
        sql.append(" values (");
        System.out.println(list);
        for(int i = 0 ; i < list.size() ; i++){
            if(i != 0){
                sql.append(",?");
            }else{
                sql.append("?");
            }
        }
        
        sql.append(")");
        
        SqlResult sr = new SqlResult(sql.toString(),list);
        
        bd.update(sr);
        
        return 0;
    }
    
    /**
     * 
     * @param obj    需要删除的数据（在对象中的数据代表删除条件）
     * @return       是否删除成功
     * @throws SQLException 
     */
    public int deleteparsetoSQL(Object obj) throws SQLException{
        StringBuilder sql = new StringBuilder("delete from");
        List<Object> list = new ArrayList<>();
        Class clazz = obj.getClass();
        
        sql.append(" " + getTableName(clazz) + " where ");
        sql.append(getParaName(obj, list, ObjectParse.WHERE_CONDITION).substring(5));
        
        bd.update(new SqlResult(sql.toString(),list));
        
        return 0;
    }
    
    /**
     * 
     * @param obj 要更新的对象，其中对象中的值代表更新的值
     * @param params 更新的条件
     * @return 是否更新成功
     */
    public int updateparsetoSQL(Object obj, Map<String, Object> params){
        StringBuilder sql = new StringBuilder("update");
        List<Object> list = new ArrayList<>();
        Class clazz = obj.getClass();
        
        String className = getTableName(clazz);
        
        sql.append(" " + className + " set ");
        
        
        if(params == null){
            sql.append(getParaName(obj, list, 4).substring(1));
            sql.append(" where ");
            sql.append(Config.getKey(className)).append("=?");
        }else{
            sql.append(getParaName(obj, list, ObjectParse.SET_VALUE).substring(1));
            sql.append(" where ");
            sql.append(getParaName(obj, list, ObjectParse.WHERE_CONDITION).substring(5));
        }
        new SqlResult(sql.toString(),list);
        return 0;
    }
    
    
    /**
     * 
     * @param clazz    要查询po对象的class
     * @param params   查询的条件
     * @return         po对象的集合
     */
    public List<Object> queryparsetoSQL(Class clazz, Map<String, Object> params){
        StringBuilder sql = new StringBuilder("select ");
        List<Object> list = new ArrayList<>();
        
        Object object = null;
        
        try {
            object = clazz.newInstance();
        } catch (InstantiationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        String className = getTableName(clazz);
    
        String content = "";
        String fanweitiaojian = "";
        StringBuilder whereOption = new StringBuilder("");
        
        for(Field field : clazz.getDeclaredFields()){
            String fieldName = field.getName();
            content += "," + fieldName;
        }
        
        sql.append(content.substring(1));
        
        sql.append(" from ").append(className).append(" where ");
        
        for(String str : params.keySet()){
            if(params.containsKey("limit")){
                continue;
            }
            Object parmObject = params.get(str); 
            whereString(parmObject, str, whereOption, list, "");
        }
        
        sql.append(whereOption.substring(5));
        
        XValue obj = (XValue)params.get("limit");
        
        limitString(obj, sql, list);
        
        List<Object> result = null;
        
        System.out.println(sql + "," + list);
        try {
            result = bd.query(new SqlResult(sql.toString(), list, object));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        return result;
    }
    
    /**
     * 
     * @param obj  limit条件范围对象
     * @param sql  构建的sql语句
     * @param list sql语句中值的封装
     */
    private void limitString(XValue obj, StringBuilder sql, List<Object> list){
        if(obj != null){
            list.add(obj.left);
            if(obj.right == null)
                sql.append(" limit ?") ;
            else{
                sql.append(" limit ?,?") ;
                list.add(obj.right);
            }
                
        }
    }
    
    /**
     * 构建查询条件
     * @param parmObject  条件对象
     * @param str         表中所代表的字段
     * @param wheresb     构建的sql语句
     * @param list        sql语句中值的封装
     * @param tableName   表名，如果是查询po对象sql语句的构建，则参数为""。
     *                        如果是查询bo对象sql语句的构建，则参数为".<表名>"
     */
    private void whereString(Object parmObject, String str, StringBuilder wheresb, List<Object> list, String tableName){ 
            
        if(parmObject instanceof XValue){
            XValue xv = (XValue)parmObject;
            
            list.add(xv.left);
            
            if(xv.right == null){
                wheresb.append(" and " + tableName + str + ">=?");
               
            }else{
                wheresb.append(" and " + tableName + str + ">=? and " + tableName + str + "<=?");
               
                list.add(xv.right);
            }
            
           return ;
        }
        
        list.add(parmObject);
        wheresb.append(" and " + tableName + str + "=?");
    }
    
    /**
     * 构建查询bo的sql语句
     * @param map   装载构建bo中所有的po对象所有的容器
     * @param sql   构建的sql语句
     * @param list  sql语句中值的封装
     * @param params 查询条件
     */
    private void fengzhung(Map<String, PoConfig> map, StringBuilder sql, List<Object> list, Map<String, Object> params){
        String content = "";
        String tableNames = "";
        StringBuilder whereoption = new StringBuilder("");
        
        for(String pokey : map.keySet()){
            PoConfig pc = map.get(pokey);
            String tableName = pc.getTableName();
            
            Map<String, FieldConfig> fieldMap = pc.getFields();
            
            for(String fieldkey : fieldMap.keySet()){
                
                FieldConfig field = fieldMap.get(fieldkey);
                content += "," + tableName + "." + field.getColumnname() + " as " +field.getAttrname();
               
                String columName = field.getColumnname();
                
                if(params.containsKey(field.getAttrname())){
                    Object object = params.get(field.getAttrname());
                    
                    whereString(object, columName, whereoption, list, tableName+".");
                }
            }
            
            tableNames += ","+tableName;
        }
        sql.append(" " + content.substring(1)).append(" from ").append(tableNames.substring(1));
        if(!whereoption.toString() .equals("")){
            sql.append(" where ").append(whereoption.substring(5));
        } 
    }
    
    /**
     * 
     * @param clazz    查询bo的class对象
     * @param params   查询bo的查询条件
     * @return         所有符合条件的bo对象
     * @throws Exception
     */
    public List<Object> selectparsetoSQL(Class clazz, Map<String, Object> params) throws Exception{
        
        String className = getTableName(clazz);

        BoConfig bc = Config.getBoconfig(className);
        
        
        Map<String, Ref> refs = bc.getRefs();
        StringBuilder sb = new StringBuilder("select");
        List<Object> list = new ArrayList<>();
       
        Map<String, PoConfig> isList = bc.getIsListPoConfigs();
        Map<String, PoConfig> notList = bc.getNotListPoConfig();
        
        fengzhung(notList, sb, list, params);
        
        String waijian = "";
        
        for(String key : refs.keySet()){
            Ref ref = refs.get(key);
            // not list user,role,classes
            if(notList.containsKey(ref.getPotablename()) && notList.containsKey(ref.getRefpotablename())){
                waijian += " and " + ref.getPotablename() + "." + ref.getColumnname() + "=" + ref.getRefpotablename() + "." + ref.getRefname(); 
            }
        }
        
        sb.append(waijian);
        
        XValue xvlimit = (XValue)params.get("limit");
        
        limitString(xvlimit, sb, list);
        
        
        
        SqlResult sr = new SqlResult(sb.toString(),list);
        Object obj11 = clazz.newInstance();
        sr.setObj(obj11);
        System.out.println(sb);
        List<Object> bolist = bd.query(sr);
        for(Object obj : bolist){
            //System.out.println("322====="+((TestBo)obj));
            Class quclazz = obj.getClass();
            StringBuilder sbsql = new StringBuilder();
            sbsql.append("select ");
            List<Object> childlist = new ArrayList<>();
           
            for(String strs : isList.keySet()){
                PoConfig po = isList.get(strs);
                Map<String, FieldConfig> childfield = po.getFields();
                String childContent = "";
                StringBuilder childwhereoption = new StringBuilder("");
                String childtableName = strs+",";
                String bostr = quclazz.getName();
                String boref = bostr.substring(bostr.lastIndexOf(".")+1);
               
                for(String fieldstr : childfield.keySet()){
                    FieldConfig fc = childfield.get(fieldstr);
                    String columName = fc.getColumnname();
                   
                    childContent += "," + strs + "." + columName + " as " + columName;
                   
                    if(params.containsKey(strs+"."+fc.getAttrname())){
                        Object object = params.get(strs+"."+fc.getAttrname());                    
                        whereString(object, columName, childwhereoption, childlist, strs+".");
                    }
                }
               
                String childwaijian = "";
                String childkey ="";
                for(String key : refs.keySet()){
                    Ref ref = refs.get(key);
                   // not list user,role,classes
                    if(!notList.containsKey(ref.getPotablename())){
                        childwaijian += " and " + ref.getPotablename() + "." + ref.getColumnname() + "=" + ref.getRefpotablename() + "." + ref.getRefname();
                        childtableName += ref.getRefpotablename();
                        childkey += ref.getRefpotablename() + "." + ref.getRefname();
                       
                        childlist.add(quclazz.getDeclaredMethod("get"+getOneUpString(Config.getBoKeyAttrNameByListPoSimName(boref, strs))).invoke(obj));
                    }
                }
               
                sbsql.append(childContent.substring(1)).append(" from ").append(childtableName).append(" where ");
               
                if(!childwhereoption.toString().equals("")){
                    sbsql.append(childwhereoption.substring(5));
                }
               
                sbsql.append(childkey+"=?");
                sbsql.append(childwaijian);
               
                Object childobj = Class.forName(Config.getpoclassName(getOneUpString(strs))).newInstance();
                List<Object> polist = bd.query(new SqlResult(sbsql.toString(), childlist, childobj));
                quclazz.getDeclaredMethod("set"+getOneUpString(po.getListname()), List.class).invoke(obj, polist);
               // System.out.println("402====="+((TestBo)obj));
            }
        }
        
        return bolist;
    }
    
    /**
     * 
     * @param simpleName  bo类的名字
     * @param params      查询条件
     * @return  
     * @throws Exception
     */
    public List<Object> selectparsetoSQL(String simpleName, Map<String, Object> params) throws Exception{
        BoConfig bc = Config.getBoconfig(simpleName);
        Class clazz = null;
        //SqlResult sr = null;
        if(bc == null){
            clazz = Class.forName(Config.getpoclassName(simpleName));
            return queryparsetoSQL(clazz, params);
        }else{
            clazz = Class.forName(bc.getClassName());
            return selectparsetoSQL(clazz, params);
        }
    }
}