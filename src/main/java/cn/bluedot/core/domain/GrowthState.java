package cn.bluedot.core.domain;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����4:43:14
 */
public class GrowthState {
	/**
	 * �����׶�ID
	 */
	private int growthID;
	
	/**
	 * ����
	 */
	private String name;
	
	/**
	 * ����
	 */
	private String description;

	public int getGrowthID() {
		return growthID;
	}

	public void setGrowthID(int growthID) {
		this.growthID = growthID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
