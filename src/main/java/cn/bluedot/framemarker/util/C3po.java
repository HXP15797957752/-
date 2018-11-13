package cn.bluedot.framemarker.util;
/**
 * @author：游斌平、余聪
 *
 */
public class C3po {
	
	/**
	 * 获取c3po-congif.xml配置文件信息，来初始化该类用来进行获取数据库连接的数据
	 */
	private static String jdbcUrl;
	private static String driverClass;
	private static String user;
	private static String password;
	private static String maxUseCount;
	private static String initialPoolSize;
	private static String minPoolSize;
	private static String maxPoolSize;
	public static String getJdbcUrl() {
		return jdbcUrl;
	}
	public static void setJdbcUrl(String jdbcUrl) {
		C3po.jdbcUrl = jdbcUrl;
	}
	public static String getDriverClass() {
		return driverClass;
	}
	public static void setDriverClass(String driverClass) {
		C3po.driverClass = driverClass;
	}
	public static String getUser() {
		return user;
	}
	public static void setUser(String user) {
		C3po.user = user;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		C3po.password = password;
	}
	
	public static String getMaxUseCount() {
		return maxUseCount;
	}
	public static void setMaxUseCount(String maxUseCount) {
		C3po.maxUseCount = maxUseCount;
	}
	public static String getInitialPoolSize() {
		return initialPoolSize;
	}
	public static void setInitialPoolSize(String initialPoolSize) {
		C3po.initialPoolSize = initialPoolSize;
	}
	public static String getMinPoolSize() {
		return minPoolSize;
	}
	public static void setMinPoolSize(String minPoolSize) {
		C3po.minPoolSize = minPoolSize;
	}
	public static String getMaxPoolSize() {
		return maxPoolSize;
	}
	public static void setMaxPoolSize(String maxPoolSize) {
		C3po.maxPoolSize = maxPoolSize;
	}

	/**
	 * 
	 */
	public static void Sysout() {
		// TODO Auto-generated method stub
		System.out.println(jdbcUrl+" "+driverClass+" "+user+" "+password+" "+maxUseCount+" "+initialPoolSize+" "+minPoolSize+" "+maxPoolSize);
	}
	

}
