package cn.bluedot.core.domain;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����4:31:12
 */
public class FetalStructure {
	/**
	 * ̥�νṹID
	 */
	private long fetalStructureID;
	
	/**
	 * �����
	 */
	private String pigNo;
	
	/**
	 * ĸ���ܲ�����
	 */
	private int totalNumber;
	
	/**
	 * �����
	 */
	private int survivalNumber;
	
	/**
	 * 30����̥��
	 */
	private long pregnacyRate;
	
	/**
	 * ������
	 */
	private long deliveryRate;

	public long getFetalStructureID() {
		return fetalStructureID;
	}

	public void setFetalStructureID(long fetalStructureID) {
		this.fetalStructureID = fetalStructureID;
	}

	public String getPigNo() {
		return pigNo;
	}

	public void setPigNo(String pigNo) {
		this.pigNo = pigNo;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public int getSurvivalNumber() {
		return survivalNumber;
	}

	public void setSurvivalNumber(int survivalNumber) {
		this.survivalNumber = survivalNumber;
	}

	public long getPregnacyRate() {
		return pregnacyRate;
	}

	public void setPregnacyRate(long pregnacyRate) {
		this.pregnacyRate = pregnacyRate;
	}

	public long getDeliveryRate() {
		return deliveryRate;
	}

	public void setDeliveryRate(long deliveryRate) {
		this.deliveryRate = deliveryRate;
	}
	
	
}
