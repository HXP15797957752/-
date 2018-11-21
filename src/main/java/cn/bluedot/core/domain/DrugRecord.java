package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����3:21:07
 */
public class DrugRecord {
	/**
	 * ID
	 */
	private int durgRecordID;
	
	/**
	 * 药品种类id
	 */
	private int drugTypeID;
	
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
	private double price;

	public int getDurgRecordID() {
		return durgRecordID;
	}

	public void setDurgRecordID(int durgRecordID) {
		this.durgRecordID = durgRecordID;
	}

	public int getDrugTypeID() {
		return drugTypeID;
	}

	public void setDrugTypeID(int drugTypeID) {
		this.drugTypeID = drugTypeID;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
