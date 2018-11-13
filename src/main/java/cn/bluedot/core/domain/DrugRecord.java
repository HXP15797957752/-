package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����3:21:07
 */
public class DrugRecord {
	/**
	 * ҩ���¼ID
	 */
	private int durgRecordID;
	
	/**
	 * ҩ������ID
	 */
	private int drugTypeID;
	
	/**
	 * ��������
	 */
	private Date createTime;
	
	/**
	 * ��Ч��
	 */
	private Date effectiveTime;
	
	/**
	 * ��ǰ�����
	 */
	private int curNumber;
	
	/**
	 * ��ҩ������λ
	 */
	private String unit;
	
	/**
	 * �Ƿ�Ϊ������,0:��  1:��
	 */
	private int isWarehousing;
	
	/**
	 * �����ʱ��
	 */
	private Date time;
	
	/**
	 * ���������
	 */
	private int number;
	
	/**
	 * ҩ�۸�
	 */
	private float price;

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getEffectiveTime() {
		return effectiveTime;
	}

	public void setEffectiveTime(Date effectiveTime) {
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

	public int getIsWarehousing() {
		return isWarehousing;
	}

	public void setIsWarehousing(int isWarehousing) {
		this.isWarehousing = isWarehousing;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
