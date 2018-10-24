package cn.bluedot.core.domain;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����6:09:52
 */
public class Power {
	/**
	 * Ȩ��ID
	 */
	private int powerID;
	
	/**
	 * Ȩ������
	 */
	private String name;
	
	/**
	 * Ȩ������
	 */
	private String powerType;

	public int getPowerID() {
		return powerID;
	}

	public void setPowerID(int powerID) {
		this.powerID = powerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPowerType() {
		return powerType;
	}

	public void setPowerType(String powerType) {
		this.powerType = powerType;
	}
	
	
}
