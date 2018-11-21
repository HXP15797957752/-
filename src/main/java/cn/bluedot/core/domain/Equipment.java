package cn.bluedot.core.domain;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����3:39:57
 */
public class Equipment {
	/**
	 * �豸ID
	 */
	private Long equipmentID;
	
	/**
	 * �豸����
	 */
	private String ename;
	
	/**
	 * �豸����
	 */
	private String etype;
	
	/**
	 * ����״̬
	 */
	private Integer workState;
	
	/**
	 * ������
	 */
	private Integer pigstyID;
	
	/**
	 * �������
	 */
	private Integer hogcoteID;
	
	/**
	 * �������ռ�����ʱ����
	 */
	private Integer timeInterval;
	
	/**
	 * �����豸����,�¶�,ʪ��...
	 */
	private String controlType;
	
	private int isAutoControl;
	private int isAutoHandle;
	public Long getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(Long equipmentID) {
		this.equipmentID = equipmentID;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEtype() {
		return etype;
	}

	public void setEtype(String etype) {
		this.etype = etype;
	}

	public Integer getWorkState() {
		return workState;
	}

	public void setWorkState(Integer workState) {
		this.workState = workState;
	}

	public Integer getPigstyID() {
		return pigstyID;
	}

	public void setPigstyID(Integer pigstyID) {
		this.pigstyID = pigstyID;
	}

	public Integer getHogcoteID() {
		return hogcoteID;
	}

	public void setHogcoteID(Integer hogcoteID) {
		this.hogcoteID = hogcoteID;
	}

	public Integer getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(Integer timeInterval) {
		this.timeInterval = timeInterval;
	}

	public String getControlType() {
		return controlType;
	}

	public void setControlType(String controlType) {
		this.controlType = controlType;
	}


	public int getIsAutoHandle() {
		return isAutoHandle;
	}

	public int getIsAutoControl() {
		return isAutoControl;
	}

	public void setIsAutoControl(int isAutoControl) {
		this.isAutoControl = isAutoControl;
	}

	public void setIsAutoHandle(int isAutoHandle) {
		this.isAutoHandle = isAutoHandle;
	}
	
	
}
