package cn.bluedot.framemarker.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.bluedot.framemarker.common.BoSuper;
import cn.bluedot.framemarker.core.ObjectParse;
import cn.bluedot.framemarker.core.ParseHQL;

/**
 * 作为service同一调度的抽象类
 * @author asus
 *
 */
public class SuperDao {
    private static final ObjectParse op = new ObjectParse();
    private static final ParseHQL ph = new ParseHQL();
    /**
     * 存储一个Po对象
     * @param poObj
     * @throws SQLException 
     */
    public int save(Object poObj) throws SQLException{
        op.insertparsetoSQL(poObj);
        return 1;
    }
    
    public int save(List<Object> poObjs) throws SQLException{
        int i = 0;
        
        for(Object obj : poObjs){
            op.insertparsetoSQL(obj);
            i++;
        }
        
        return i;
    }
    
    /**
     * 修改一个PO对象，po对象的主键属性必须存在
     * @param poObje
     */
   public int update(Object poObj){
       op.updateparsetoSQL(poObj, null);
       
       return 1;
   }
   public int update(List<Object> poObjs){
       int i = 0;
       for(Object poObj : poObjs){
           op.updateparsetoSQL(poObj, null);
           i++;
       }
       
       return i;
   }
   /**
    * 批量更新使用
    * @param map
    * @return
    */
   public int update(Object poClass, Map<String, Object> map){
       op.updateparsetoSQL(poClass, map);
       
       return 1;
   }
   /**
    * 删除一个po对象
    * @param poObj
 * @throws SQLException 
    */
   public int delete(Object poObj) throws SQLException{
       op.deleteparsetoSQL(poObj);
       
       return 1;
   }
   public int delete(List<Object> poObjs) throws SQLException{
       int i = 0;
       for(Object poObj : poObjs){
           op.deleteparsetoSQL(poObj);
           i++;
       }
       
       return i;
   }
   
   /**
    * 查询bo
    * @param clazz
    * @param params
    * @return
 * @throws Exception 
    */
   public List<BoSuper> query(Class clazz, Map<String, Object> params) throws Exception{
       
       return (List<BoSuper>)(List)op.selectparsetoSQL(clazz, params);
   }
   
   /**
    * 通过hql 查询
    * @param hql
    * @return
    */
   public List<Object> HQLQuery(String hql, Object...os){
       return ph.parse(hql, os);
   }
}
