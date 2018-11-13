package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����3:51:13
 */
public class EquipmentRecord {
	/**
	 * 设备库存记录ID
	 */
	private int equipmentRecordID;
	
	/**
	 * 设备ID
	 */
	private String equipmentID;
	
	/**
	 * 有效日期
	 */
	private String effectiveDate;
	
	/**
	 *生产日期
	 */
	private String createDate;
	
	/**
	 * 采购价格
	 */
	private Double price;
	
	/**
	 * useState״̬
	 */
	private String useState;

	public int getEquipmentRecordID() {
		return equipmentRecordID;
	}

	public void setEquipmentRecordID(int equipmentRecordID) {
		this.equipmentRecordID = equipmentRecordID;
	}

	
	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}

	public String getUseState() {
		return useState;
	}

	public void setUseState(String useState) {
		this.useState = useState;
	}

	

	
	
}
