package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����6:25:42
 */
public class SuspectedIllness {
	/**
	 * ��������ID
	 */
	private long ID;
	
	/**
	 * �����
	 */
	private String pigNO;
	
	/**
	 * ����
	 */
	private Date date;
	
	/**
	 * ����
	 */
	private int temperature;

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getPigNO() {
		return pigNO;
	}

	public void setPigNO(String pigNO) {
		this.pigNO = pigNO;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	
	
}
