package cn.bluedot.core.domain;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����6:02:28
 */
public class Pigsty {
	/**
	 * ������
	 */
	private String pigstyNo;
	
	/**
	 * �������ͣ������ᡣ������
	 */
	private String type;
	
	/**
	 * ��������
	 */
	private int number;
	
	/**
	 * �������
	 */
	private float area;
	
	/**
	 * ������
	 */
	private String piggeryNo;
	
	/**
	 * ��ǰ����
	 */
	private int pigTypeId;
	
	/**
	 * ��ǰ�����׶�
	 */
	private int growthStateID;

	public String getPigstyNo() {
		return pigstyNo;
	}

	public void setPigstyNo(String pigstyNo) {
		this.pigstyNo = pigstyNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public String getPiggeryNo() {
		return piggeryNo;
	}

	public void setPiggeryNo(String piggeryNo) {
		this.piggeryNo = piggeryNo;
	}

	public int getPigTypeId() {
		return pigTypeId;
	}

	public void setPigTypeId(int pigTypeId) {
		this.pigTypeId = pigTypeId;
	}

	public int getGrowthStateID() {
		return growthStateID;
	}

	public void setGrowthStateID(int growthStateID) {
		this.growthStateID = growthStateID;
	}
	
}
