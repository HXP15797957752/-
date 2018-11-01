package cn.bluedot.framemarker.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.bluedot.framemarker.dao.DaoException;

public class ParseHQL {

    public static void main(String[] args) {
        String hql = "TestBo|sex=?";
        //parse(hql, "女");
        
    }
    private final static ObjectParse op = new ObjectParse();
    /**
     * HQL,
	 * BOSimpleName|条件1=?[, 条件2=<?,?>][| limit ?,?]
     * POSimpleName|条件1=?[, 条件2=<?,?>][| limit ?,?]
     * @param HQL
     * @return
     */
    public List<Object> parse(String hql, Object... os) {
        // 检查HQL
        if (hql == null || "".equals(hql.trim())) {
            throw new DaoException("HQL语句不能为空!");
        }
        // 取出HQL中的所有的 空格
        hql = hql.replaceAll(" ", "");
        
        // 得到根据 hql 分隔的
        String[] parts = hql.split("\\"+SEPARATE_S);
        
        String simpleName = null;
        // 返回的参数Map
        Map<String, Object> params = new HashMap<>();
        int os_index = 0;
        try {
            //得到simpleName 
            simpleName = parts[0];
            
            for(int i = 1;i < parts.length;i++) {
                String part = parts[i];
                //处理不是limit的情况
                if(!part.contains("limit")) {
                    String[] conditions = part.split(SEPARATE_D);
                    for(int j = 0;j < conditions.length;j++) {
                        String con = conditions[j];
                        if(!con.contains(SEPARATE_E)) {
                            continue;
                        }
                        //字段名, po字段名或者是bo的字段名
                        String fieldName = con.substring(0, con.indexOf(SEPARATE_E));
                        if(con.contains(SEPARATE_L)) {
                            params.put(fieldName, new XValue(os[os_index++], os[os_index++]));
                        }else {
                            //没有范围
                            params.put(fieldName, os[os_index++]);
                        }
                        
                    }
                }else if(part.contains(SEPARATE_D)){
                    params.put("limit", new XValue(os[os_index++], os[os_index++]));
                }else {
                    params.put("limit", new XValue(os[os_index++], null));
                }
            }
            
        }catch(Exception e) {
            e.printStackTrace();
            throw new DaoException("HQL Error:" + hql);
        }
        
        List<Object> lists = null;
        try {
            
            lists = op.selectparsetoSQL(simpleName, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lists;
    }
    /**
     * 区域分隔:|
     */
    private static String SEPARATE_S = "|";
    /**
     * 逗号:,
     */
    private static String SEPARATE_D = ",";
    /**
     * 等号:=
     */
    private static String SEPARATE_E = "=";
    /**
     * <
     */
    private static String SEPARATE_L = "<";
}
