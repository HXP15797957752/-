package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����3:03:42
 */
public class BirthRecord {
	/**
	 * ������¼���
	 */
	private int birthRecordID;
	
	/**
	 * ĸ����
	 */
	private String pigNo;
	
	/**
	 * ����ʱ��
	 */
	private Date dateTime;
	
	/**
	 * ��������
	 */
	private int babyCount;

	public int getBirthRecordID() {
		return birthRecordID;
	}

	public void setBirthRecordID(int birthRecordID) {
		this.birthRecordID = birthRecordID;
	}

	public String getPigNo() {
		return pigNo;
	}

	public void setPigNo(String pigNo) {
		this.pigNo = pigNo;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getBabyCount() {
		return babyCount;
	}

	public void setBabyCount(int babyCount) {
		this.babyCount = babyCount;
	}
	
}
