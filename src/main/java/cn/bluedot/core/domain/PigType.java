package cn.bluedot.core.domain;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����6:07:17
 */
public class PigType {
	/**
	 * Ʒ��ID
	 */
	private int pigTypeID;
	
	/**
	 * Ʒ������
	 */
	private String name;
	
	/**
	 * ����
	 */
	private String description;

	public int getPigTypeID() {
		return pigTypeID;
	}

	public void setPigTypeID(int pigTypeID) {
		this.pigTypeID = pigTypeID;
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
