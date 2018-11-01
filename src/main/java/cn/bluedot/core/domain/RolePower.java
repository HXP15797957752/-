package cn.bluedot.core.domain;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����6:21:55
 */
public class RolePower {
	/**
	 * ID
	 */
	private int ID;
	
	/**
	 * ��ɫID
	 */
	private int roleID;
	
	/**
	 * Ȩ��ID
	 */
	private int powerID;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public int getPowerID() {
		return powerID;
	}

	public void setPowerID(int powerID) {
		this.powerID = powerID;
	}
	
	
}
