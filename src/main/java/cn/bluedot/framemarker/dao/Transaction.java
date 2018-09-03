package cn.bluedot.framemarker.dao;

import java.sql.SQLException;

import cn.bluedot.framemarker.util.JdbcUtils;
/**
 * 作为业务层进行事物操作
 * @author asus
 *
 */
public class Transaction {
    public static void beginTransaction() throws SQLException{
        JdbcUtils.beginTransaction();
    }
    public static void commitTransaction() throws SQLException{
        JdbcUtils.commitTransaction();
    }
    public static void rollbackTransaction() throws SQLException{
        JdbcUtils.rollbackTransaction();
    }
}
