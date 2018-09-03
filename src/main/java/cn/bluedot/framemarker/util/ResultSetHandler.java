package cn.bluedot.framemarker.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.bluedot.framemarker.core.SqlResult;

public class ResultSetHandler {
    
    /**
     * 处理结果集封装成PO对象
     * */
    public static <T> List<T> RsToList(ResultSet rs,SqlResult sr){
        
        List<T> list = new ArrayList<T>();
        try {
            //通过反射获取对象的实例
            Class clazz = sr.getObj().getClass();
            
            
            //获取resultset的列的信息
            ResultSetMetaData metaData = rs.getMetaData();
            
            //遍历resultSet
            while(rs.next()) {
                T t = (T) clazz.getConstructor().newInstance();
                //遍历每一列
                for(int i = 0;i<metaData.getColumnCount();i++) {
                    //获取列对应的名字
                    String fName = metaData.getColumnLabel(i+1);
                    //截取列的第一个字母
                    String firstName = fName.substring(0,1).toUpperCase();
                    //因为列的名字和PO类中的属性名一样，通过列名获取破中的属性
                    Field field = clazz.getDeclaredField(fName);
                    //获取所有属性对应的set方法，方法名为set+属性名首字母大写
                    String setName ="set"+firstName.toUpperCase()+fName.substring(1);
                    //属性类型与set方法参数类型一致，所以获得set方法
                    Method setMethod =  clazz.getMethod(setName, field.getType());
                    //执行set方法，将resultset的值设置到破属性中
                    setMethod.invoke(t, rs.getObject(fName));
                }
                //添加po到list
                list.add(t);
            }
        }catch(Exception e) {
            
            e.printStackTrace();
        }
        
        return list;
    }
    
    
}

