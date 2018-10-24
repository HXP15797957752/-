package cn.bluedot.framemarker.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.bluedot.framemarker.common.BoSuper;
import cn.bluedot.framemarker.dao.Transaction;
import cn.bluedot.framemarker.util.JdbcUtils;
import cn.bluedot.framemarker.util.ResultSetHandler;

/**
 * 最底层访问数据库的调用
 * @author hxp
 * 2018年8月14日 下午7:26:30
 */
public class BaseDao {
    /**
     * 数据库更新（增删改），供SuperDao调用
     * @throws SQLException 
     * */
    public int update(SqlResult sr) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            conn = JdbcUtils.getConnection();
            Transaction.beginTransaction();
            pstmt = conn.prepareStatement(sr.getSql());
            for(int i = 0;i<sr.getParams().size();i++) {
            	System.out.println(sr.getParams().get(i));
                pstmt.setObject(i + 1, sr.getParams().get(i));
            }
            result = pstmt.executeUpdate(); 
            System.out.println("test"+result);
            Transaction.commitTransaction();
        } catch (SQLException e) {
            Transaction.rollbackTransaction();
            e.printStackTrace();
        }finally {
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }   
            if(pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    
    /**
     * 查询数据库时返回查询结果，结果可能是一个或多个，用List封装，供SuperDao调用
     * @throws SQLException 
     * */
    public List<Object> query(SqlResult sr) throws SQLException{
       
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        List<Object> list = null;
        try {
            
            conn = JdbcUtils.getConnection();
            
            Transaction.beginTransaction();
            
            pstmt = conn.prepareStatement(sr.getSql());
         
            for(int i = 0;i<sr.getParams().size();i++) {
                pstmt.setObject(i + 1,sr.getParams().get(i));
            }
            rs = pstmt.executeQuery(); 
           list = ResultSetHandler.RsToList(rs,sr);
            Transaction.commitTransaction();
            
        }catch(SQLException e) {
           
            Transaction.rollbackTransaction();
            e.printStackTrace();
        }finally {
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
//            JdbcUtils.free(rs, pstmt, null);
        }
        return list;
    }
    
    
}