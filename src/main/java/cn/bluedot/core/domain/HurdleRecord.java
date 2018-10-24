package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����4:55:28
 */
public class HurdleRecord {
	/**
	 * ת����¼
	 */
	private long hurdleRecordID;
	
	/**
	 * ת��ʱ��
	 */
	private Date time;
	
	/**
	 * �����
	 */
	private String pigNo;
	
	/**
	 * ������
	 */
	private int growthStateID;
	
	/**
	 * ���������
	 */
	private String inHogcoteNo;
	
	/**
	 * ���������
	 */
	private String outHogcoteNo;
	
	/**
	 * ������
	 */
	private String userNo;
	
	/**
	 * ��ע
	 */
	private String description;
	
	/**
	 * �����۸�
	 */
	private float outPrice;
	
	/**
	 * ���۵�
	 */
	private String outPlace;

	public long getHurdleRecordID() {
		return hurdleRecordID;
	}

	public void setHurdleRecordID(long hurdleRecordID) {
		this.hurdleRecordID = hurdleRecordID;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getPigNo() {
		return pigNo;
	}

	public void setPigNo(String pigNo) {
		this.pigNo = pigNo;
	}

	public int getGrowthStateID() {
		return growthStateID;
	}

	public void setGrowthStateID(int growthStateID) {
		this.growthStateID = growthStateID;
	}

	public String getInHogcoteNo() {
		return inHogcoteNo;
	}

	public void setInHogcoteNo(String inHogcoteNo) {
		this.inHogcoteNo = inHogcoteNo;
	}

	public String getOutHogcoteNo() {
		return outHogcoteNo;
	}

	public void setOutHogcoteNo(String outHogcoteNo) {
		this.outHogcoteNo = outHogcoteNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getOutPrice() {
		return outPrice;
	}

	public void setOutPrice(float outPrice) {
		this.outPrice = outPrice;
	}

	public String getOutPlace() {
		return outPlace;
	}

	public void setOutPlace(String outPlace) {
		this.outPlace = outPlace;
	}
	
	
}
