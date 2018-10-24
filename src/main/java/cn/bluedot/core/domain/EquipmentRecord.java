package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����3:51:13
 */
public class EquipmentRecord {
	/**
	 * �豸��¼ID
	 */
	private long equipmentRecordID;
	
	/**
	 * �豸ID
	 */
	private long equipmentID;
	
	/**
	 * ��Ч����
	 */
	private Date effectiveDate;
	
	/**
	 * ��������
	 */
	private Date createDate;
	
	/**
	 * ���ݴ���ʱ��
	 */
	private Date date;
	
	/**
	 * �ɹ��۸�
	 */
	private float price;
	
	/**
	 * ʹ��״̬
	 */
	private int useState;

	public long getEquipmentRecordID() {
		return equipmentRecordID;
	}

	public void setEquipmentRecordID(long equipmentRecordID) {
		this.equipmentRecordID = equipmentRecordID;
	}

	public long getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(long equipmentID) {
		this.equipmentID = equipmentID;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getUseState() {
		return useState;
	}

	public void setUseState(int useState) {
		this.useState = useState;
	}
	
	
}
