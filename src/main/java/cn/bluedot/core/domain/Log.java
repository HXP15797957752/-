package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����5:43:44
 */
public class Log {
	/**
	 * ��־ID
	 */
	private long logID;
	
	/**
	 * ��������
	 */
	private Date time;
	
	/**
	 * ������
	 */
	private String userNo;
	
	/**
	 * Ȩ��ID
	 */
	private int powerID;
	
	/**
	 * ��������
	 */
	private String operationName;
	
	/**
	 * ip��ַ
	 */
	private String ipAddress;

	public long getLogID() {
		return logID;
	}

	public void setLogID(long logID) {
		this.logID = logID;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public int getPowerID() {
		return powerID;
	}

	public void setPowerID(int powerID) {
		this.powerID = powerID;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	
}
