package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����3:36:43
 */
public class Eliminate {
	/**
	 * ��̭ID
	 */
	private long eliminateID;
	
	/**
	 * �����
	 */
	private String pigNo;
	
	/**
	 * ��̭ԭ��
	 */
	private String reason;
	
	/**
	 * ����,��ȷ����
	 */
	private Date date;

	public long getEliminateID() {
		return eliminateID;
	}

	public void setEliminateID(long eliminateID) {
		this.eliminateID = eliminateID;
	}

	public String getPigNo() {
		return pigNo;
	}

	public void setPigNo(String pigNo) {
		this.pigNo = pigNo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
