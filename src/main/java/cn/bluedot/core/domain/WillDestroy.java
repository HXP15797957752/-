package cn.bluedot.core.domain;

import java.math.BigInteger;
import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����6:39:00
 */
public class WillDestroy {
	/**
	 * ������ID
	 */
	private BigInteger willDestroyID;
	
	/**
	 * �����
	 */
	private String pigNo;
	
	/**
	 * �����ύ����
	 */
	private Date commitTime;
	
	/**
	 * ԭ��
	 */
	private String reason;
	
	/**
	 * �����
	 */
	private String checkUserNo;
	
	/**
	 * �Ƿ���׼
	 */
	private int isAgree;

	public BigInteger getWillDestroyID() {
		return willDestroyID;
	}

	public void setWillDestroyID(BigInteger willDestroyID) {
		this.willDestroyID = willDestroyID;
	}

	public String getPigNo() {
		return pigNo;
	}

	public void setPigNo(String pigNo) {
		this.pigNo = pigNo;
	}

	public Date getCommitTime() {
		return commitTime;
	}

	public void setCommitTime(Date commitTime) {
		this.commitTime = commitTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCheckUserNo() {
		return checkUserNo;
	}

	public void setCheckUserNo(String checkUserNo) {
		this.checkUserNo = checkUserNo;
	}

	public int getIsAgree() {
		return isAgree;
	}

	public void setIsAgree(int isAgree) {
		this.isAgree = isAgree;
	}
	
	
}
