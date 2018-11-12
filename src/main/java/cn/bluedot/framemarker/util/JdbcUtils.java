package cn.bluedot.framemarker.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * 
 * 2018-8-14
 * 
 * @author ：游斌平、余聪
 * 
 */
public final class JdbcUtils {
	private static DataSource myDataSource2 = null;
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	private JdbcUtils() {
	}
	/**
	 * 获取连接驱动，初始化连接池
	 * @throws SQLException 
	 */
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 myDataSource2 = new MyDataSource2();
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	/**
	 * 获取连接池
	 * @throws SQLException 
	 */
	public static DataSource getDataSource() {
		return myDataSource2;
	}
	/**
	 * 获取连接
	 * @throws SQLException 
	 */
	public synchronized static Connection getConnection() throws SQLException {
		return myDataSource2.getConnection();
	}
	
	/**
	 * 开启事务
	 * @throws SQLException 
	 */
	public synchronized static void beginTransaction() throws SQLException {
		Connection con = tl.get();//获取当前线程的事务连接
		if(con != null) throw new SQLException("已经开启了事务，不能重复开启！");
		con = myDataSource2.getConnection();//给con赋值，表示开启了事务
		con.setAutoCommit(false);//设置为手动提交
		tl.set(con);//把当前事务连接放到tl中
	}

	/**
	 * 提交事务
	 * @throws SQLException 
	 */
	public synchronized static void commitTransaction() throws SQLException {
		Connection con = tl.get();//获取当前线程的事务连接
		if(con == null) throw new SQLException("没有事务不能提交！");
		con.commit();//提交事务
		con.close();//关闭连接
		con = null;//表示事务结束！
		tl.remove();
	}
	
	/**
	 * 回滚事务
	 * @throws SQLException 
	 */
	public synchronized static void rollbackTransaction() throws SQLException {
		Connection con = tl.get();//获取当前线程的事务连接
		if(con == null) throw new SQLException("没有事务不能回滚！");
		con.rollback();
		con.close();
		con = null;
		tl.remove();
	}
	/**
	 * 释放数据库结果集和connection
	 */
	public synchronized static void free(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					 st.close();
			} catch (SQLException e) {
				  e.printStackTrace();
			} finally {
				if(conn!=null) {
						try {
							conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
