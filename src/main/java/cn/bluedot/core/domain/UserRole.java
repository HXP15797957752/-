package cn.bluedot.core.domain;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����6:37:03
 */
public class UserRole {
	/**
	 * ID
	 */
	private int ID;
	
	/**
	 * �û�ID
	 */
	private String userNo;
	
	/**
	 * ��ɫID
	 */
	private String roleID;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
	
	
}
