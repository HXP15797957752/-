package cn.bluedot.core.domain;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����4:46:33
 */
public class HogCote {
	/**
	 * ������
	 */
	private String hogcoteNo;
	
	/**
	 * ����޶�
	 */
	private int upperLimit;
	
	/**
	 * ���
	 */
	private long area;
	
	/**
	 * ��ǰ������
	 */
	private int curPigNumber;
	
	/**
	 * ������
	 */
	private String pigstyNo;

	public String getHogcoteNo() {
		return hogcoteNo;
	}

	public void setHogcoteNo(String hogcoteNo) {
		this.hogcoteNo = hogcoteNo;
	}

	public int getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}

	public long getArea() {
		return area;
	}

	public void setArea(long area) {
		this.area = area;
	}

	public int getCurPigNumber() {
		return curPigNumber;
	}

	public void setCurPigNumber(int curPigNumber) {
		this.curPigNumber = curPigNumber;
	}

	public String getPigstyNo() {
		return pigstyNo;
	}

	public void setPigstyNo(String pigstyNo) {
		this.pigstyNo = pigstyNo;
	}
	
	
} 
