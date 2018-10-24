package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����3:46:19
 */
public class EquipmentData {
	/**
	 * �豸����ID
	 */
	private long equipmentDataID;
	
	/**
	 * ����
	 */
	private String data;
	
	/**
	 * �豸ID
	 */
	private long equipmentID;
	
	/**
	 * ���ݽ���ʱ��
	 */
	private Date time;

	public long getEquipmentDataID() {
		return equipmentDataID;
	}

	public void setEquipmentDataID(long equipmentDataID) {
		this.equipmentDataID = equipmentDataID;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public long getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(long equipmentID) {
		this.equipmentID = equipmentID;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
}
