package cn.bluedot.core.domain;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����4:50:35
 */
public class HurdleCondition {
	/**
	 * ת������
	 */
	private int hurdleConditionID;
	
	/**
	 * ������
	 */
	private int growthStateID;
	
	/**
	 * ��Ӧת������
	 */
	private int days;

	public int getHurdleConditionID() {
		return hurdleConditionID;
	}

	public void setHurdleConditionID(int hurdleConditionID) {
		this.hurdleConditionID = hurdleConditionID;
	}

	public int getGrowthStateID() {
		return growthStateID;
	}

	public void setGrowthStateID(int growthStateID) {
		this.growthStateID = growthStateID;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	
	
}
