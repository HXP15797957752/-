package cn.bluedot.core.domain;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����3:32:34
 */
public class EatRecord {
	/**
	 * ��ʳ��¼ID
	 */
	private long eatRecordID;
	
	/**
	 * �����
	 */
	private String pigNo;
	
	/**
	 * �����׶�
	 */
	private int growthStateID;
	
	/**
	 * ƽ��ʣ����
	 */
	private int surplus;
	
	/**
	 * ƽ����ʳ��
	 */
	private int eatCount;

	public long getEatRecordID() {
		return eatRecordID;
	}

	public void setEatRecordID(long eatRecordID) {
		this.eatRecordID = eatRecordID;
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

	public int getSurplus() {
		return surplus;
	}

	public void setSurplus(int surplus) {
		this.surplus = surplus;
	}

	public int getEatCount() {
		return eatCount;
	}

	public void setEatCount(int eatCount) {
		this.eatCount = eatCount;
	}
	
}
