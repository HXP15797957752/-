package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����4:15:47
 */
public class Exception {
	/**
	 * �������쳣ID
	 */
	private long exceptionID;
	
	/**
	 * �豸ID
	 */
	private long equipmentID;
	
	/**
	 * ʱ��
	 */
	private Date time;
	
	/**
	 * ������
	 */
	private String processingMethod;
	
	/**
	 * ������
	 */
	private String processUserNo;

	public long getExceptionID() {
		return exceptionID;
	}

	public void setExceptionID(long exceptionID) {
		this.exceptionID = exceptionID;
	}

	public long getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(long equipmentID) {
		this.equipmentID = equipmentID;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getProcessingMethod() {
		return processingMethod;
	}

	public void setProcessingMethod(String processingMethod) {
		this.processingMethod = processingMethod;
	}

	public String getProcessUserNo() {
		return processUserNo;
	}

	public void setProcessUserNo(String processUserNo) {
		this.processUserNo = processUserNo;
	}
	
}
