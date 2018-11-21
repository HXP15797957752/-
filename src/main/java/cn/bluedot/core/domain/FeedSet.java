package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����4:25:52
 */
public class FeedSet {
	/**
	 * ��ι�趨
	 */
	private int feedSetID;
	
	/**
	 * ������ID
	 */
	private int pigTypeID;
	
	/**
	 * �����׶�ID
	 */
	private int growthStateID;
	
	/**
	 * �䷽ID
	 */
	private int formulaID;
	
	/**
	 * Ͷ����
	 */
	private int  putNumber;
	
	/**
	 * Ͷ��ʱ��
	 */
	private  Date putTime;
	
	/**
	 * ʱ����
	 */
	private int timeInterval;

	public int getFeedSetID() {
		return feedSetID;
	}

	public void setFeedSetID(int feedSetID) {
		this.feedSetID = feedSetID;
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

	public int getFormulaID() {
		return formulaID;
	}

	public void setFormulaID(int formulaID) {
		this.formulaID = formulaID;
	}

	public int getPutNumber() {
		return putNumber;
	}

	public void setPutNumber(int putNumber) {
		this.putNumber = putNumber;
	}

	public Date getPutTime() {
		return putTime;
	}

	public void setPutTime(Date putTime) {
		this.putTime = putTime;
	}

	public int getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(int timeInterval) {
		this.timeInterval = timeInterval;
	}
	
	
}
