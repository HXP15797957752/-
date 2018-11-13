package cn.bluedot.framemarker.util;



import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Logger;

import javax.sql.DataSource;
/**
 * @author ：游斌平、余聪
 * 
 */
public class MyDataSource2 implements DataSource{
	@SuppressWarnings("unused")
	private static Tool tool=new Tool();
	private static String url = C3po.getJdbcUrl();
	private static String user = C3po.getUser();
	private static String password = C3po.getPassword();
	private static int initCount = Integer.parseInt(C3po.getInitialPoolSize());
	private static int maxCount =Integer.parseInt(C3po.getMaxPoolSize());
	private static int minPoolSize=Integer.parseInt(C3po.getMinPoolSize());
	public  int currentCount = 0;

	public  BlockingDeque<Connection> connectionsPool = new LinkedBlockingDeque<Connection>();
	/**
	 * 创建数据库连接池
	 */
	public MyDataSource2() {
		try {
			for (int i = 0; i < initCount; i++) {
				try {
					this.currentCount++;
					connectionsPool.put(this.createConnection());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	/**
	 * 获取connection
	 */
	@SuppressWarnings("static-access")
	public Connection getConnection() throws SQLException{
		
		if(connectionsPool.size()<=minPoolSize&&currentCount<maxCount) {
			this.currentCount++;
			return this.createConnection();
		}else {
			this.currentCount--;
			try {
				return this.connectionsPool.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return null;
			}
		}
	}
	/**
	 * 释放连接
	 */
	public void free(Connection conn) throws Exception {
		connectionsPool.put(conn);
	}
	/**
	 * 通过动态代理创建连接
	 */
	private  Connection createConnection() throws SQLException {
		Connection realConn = DriverManager.getConnection(url, user, password);
		MyConnectionHandler proxy = new MyConnectionHandler(this);
		return proxy.bind(realConn);
	}

	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.sql.CommonDataSource#getParentLogger()
	 */
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Wrapper#unwrap(java.lang.Class)
	 */
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Wrapper#isWrapperFor(java.lang.Class)
	 */
	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}

