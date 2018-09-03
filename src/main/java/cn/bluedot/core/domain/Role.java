package cn.bluedot.core.domain;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����6:19:47
 */
public class Role {
	/**
	 * ��ɫID
	 */
	private int roleID;
	
	/**
	 * ��ɫ����
	 */
	private String roleName;
	
	/**
	 * ��ɫ����
	 */
	private String description;

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
