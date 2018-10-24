package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����6:13:28
 */
public class PreHurdleRecord {
	/**
	 * ת����¼ID
	 */
	private long preHurdleRecordID;
	
	/**
	 * �����
	 */
	private String pigNo;
	
	/**
	 * ת��ʱ��
	 */
	private Date time;
	
	/**
	 * �������
	 */
	private String startPigstyNo;
	
	/**
	 * �������
	 */
	private String startHogcoteNo;
	
	/**
	 * �յ�����
	 */
	private String endPigstyNo;
	
	/**
	 * �յ�����
	 */
	private String endHogcoteNo;
	
	/**
	 * ������
	 */
	private String operatorUserNo;

	public long getPreHurdleRecordID() {
		return preHurdleRecordID;
	}

	public void setPreHurdleRecordID(long preHurdleRecordID) {
		this.preHurdleRecordID = preHurdleRecordID;
	}

	public String getPigNo() {
		return pigNo;
	}

	public void setPigNo(String pigNo) {
		this.pigNo = pigNo;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getStartPigstyNo() {
		return startPigstyNo;
	}

	public void setStartPigstyNo(String startPigstyNo) {
		this.startPigstyNo = startPigstyNo;
	}

	public String getStartHogcoteNo() {
		return startHogcoteNo;
	}

	public void setStartHogcoteNo(String startHogcoteNo) {
		this.startHogcoteNo = startHogcoteNo;
	}

	public String getEndPigstyNo() {
		return endPigstyNo;
	}

	public void setEndPigstyNo(String endPigstyNo) {
		this.endPigstyNo = endPigstyNo;
	}

	public String getEndHogcoteNo() {
		return endHogcoteNo;
	}

	public void setEndHogcoteNo(String endHogcoteNo) {
		this.endHogcoteNo = endHogcoteNo;
	}

	public String getOperatorUserNo() {
		return operatorUserNo;
	}

	public void setOperatorUserNo(String operatorUserNo) {
		this.operatorUserNo = operatorUserNo;
	}
	
	
}
