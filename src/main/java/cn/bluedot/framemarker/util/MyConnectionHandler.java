package cn.bluedot.framemarker.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;


/**
 * 
 * 2018-8-14
 * @author ：游斌平、余聪
 */
class MyConnectionHandler implements InvocationHandler {
	private Connection realConnection;
	private Connection warpedConnection;
	private MyDataSource2 dataSource;
	private int maxUseCount =Integer.parseInt(C3po.getMaxUseCount());
	private int currentUserCount = 0;
	/**
	 * 初始化数据源
	 */
	MyConnectionHandler(MyDataSource2 dataSource) {
		this.dataSource = dataSource;
	}
	/**
	 * 获取连接
	 */
	Connection bind(Connection realConn) {
		this.realConnection = realConn;
		this.warpedConnection = (Connection) Proxy.newProxyInstance(this
				.getClass().getClassLoader(), new Class[] { Connection.class },
				this);
		return warpedConnection;
	}
	/**
	 * 实现connection的动态代理
	 */
	public  Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		synchronized (this) {
			if ("close".equals(method.getName())) {
				this.currentUserCount++;
				if (this.currentUserCount <this.maxUseCount)
				{
						this.dataSource.connectionsPool.put(this.warpedConnection);
						this.dataSource.currentCount++;
				}
				else {
					this.realConnection.close();
					this.dataSource.currentCount--;
				}
				return null;//防止客户端creatStatement出现错误
			}
			return method.invoke(this.realConnection, args);
		}
	}

}
