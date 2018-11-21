package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����4:20:10
 */
public class FeedRecord {
	/**
	 * ID
	 */
	private String feedRecordID;
	
	/**
	 * 生产日期
	 */
	private String createTime;
	
	/**
	 * 有效期
	 */
	private String effectiveTime;
	
	/**
	 * 当前库存量
	 */
	private int curNumber;
	
	/**
	 * 计量单位
	 */
	private String unit;
		
	/**
	 * 采购价格
	 */
	private Double price;

	public String getFeedRecordID() {
		return feedRecordID;
	}

	public void setFeedRecordID(String feedRecordID) {
		this.feedRecordID = feedRecordID;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getEffectiveTime() {
		return effectiveTime;
	}

	public void setEffectiveTime(String effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	public int getCurNumber() {
		return curNumber;
	}

	public void setCurNumber(int curNumber) {
		this.curNumber = curNumber;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
}
