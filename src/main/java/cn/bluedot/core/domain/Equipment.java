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
	private long equipmentID;
	
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
	private int workState;
	
	/**
	 * ������
	 */
	private String pigstyNo;
	
	/**
	 * �������
	 */
	private String hogcoteNo;
	
	/**
	 * �������ռ�����ʱ����
	 */
	private int timeInterval;
	
	/**
	 * �����豸����,�¶�,ʪ��...
	 */
	private String controlType;
	
	/**
	 * �����豸��ֵ
	 */
	private String controlThreshold;

	public long getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(long equipmentID) {
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

	public int getWorkState() {
		return workState;
	}

	public void setWorkState(int workState) {
		this.workState = workState;
	}

	public String getPigstyNo() {
		return pigstyNo;
	}

	public void setPigstyNo(String pigstyNo) {
		this.pigstyNo = pigstyNo;
	}

	public String getHogcoteNo() {
		return hogcoteNo;
	}

	public void setHogcoteNo(String hogcoteNo) {
		this.hogcoteNo = hogcoteNo;
	}

	public int getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(int timeInterval) {
		this.timeInterval = timeInterval;
	}

	public String getControlType() {
		return controlType;
	}

	public void setControlType(String controlType) {
		this.controlType = controlType;
	}

	public String getControlThreshold() {
		return controlThreshold;
	}

	public void setControlThreshold(String controlThreshold) {
		this.controlThreshold = controlThreshold;
	}
	
	
}
