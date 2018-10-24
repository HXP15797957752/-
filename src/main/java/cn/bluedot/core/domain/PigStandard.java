package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����5:57:15
 */
public class PigStandard {
	/**
	 * ���׼ID
	 */
	private int pigStandardID;
	
	/**
	 * ���Ա�
	 */
	private int sex;
	
	/**
	 * ��Ʒ��
	 */
	private int pigTypeID;
	
	/**
	 * �������׶�
	 */
	private int growthStateID;
	
	/**
	 * ������
	 */
	private int addWeight;
	
	/**
	 * ����
	 */
	private int upperLimit;
	
	/**
	 * ����
	 */
	private int lowerLimit;
	
	/**
	 * ����
	 */
	private Date date;
	
	/**
	 * ʱ����
	 */
	private int timeInterval;

	public int getPigStandardID() {
		return pigStandardID;
	}

	public void setPigStandardID(int pigStandardID) {
		this.pigStandardID = pigStandardID;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getPigTypeID() {
		return pigTypeID;
	}

	public void setPigTypeID(int pigTypeID) {
		this.pigTypeID = pigTypeID;
	}

	public int getGrowthStateID() {
		return growthStateID;
	}

	public void setGrowthStateID(int growthStateID) {
		this.growthStateID = growthStateID;
	}

	public int getAddWeight() {
		return addWeight;
	}

	public void setAddWeight(int addWeight) {
		this.addWeight = addWeight;
	}

	public int getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}

	public int getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(int lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(int timeInterval) {
		this.timeInterval = timeInterval;
	}
	
	
}
