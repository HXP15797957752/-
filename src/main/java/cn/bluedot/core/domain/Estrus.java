package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����4:11:59
 */
public class Estrus {
	/**
	 * �����¼
	 */
	private long estrusID;
	
	/**
	 * �����
	 */
	private String pigNo;
	
	/**
	 * Ԥ����
	 */
	private Date preBirthDate;
	
	/**
	 * �ѷ���ȴδ����
	 */
	private int rtLove;
	
	/**
	 * ��ȡ��ʩ
	 */
	private String measures;

	public long getEstrusID() {
		return estrusID;
	}

	public void setEstrusID(long estrusID) {
		this.estrusID = estrusID;
	}

	public String getPigNo() {
		return pigNo;
	}

	public void setPigNo(String pigNo) {
		this.pigNo = pigNo;
	}

	public Date getPreBirthDate() {
		return preBirthDate;
	}

	public void setPreBirthDate(Date preBirthDate) {
		this.preBirthDate = preBirthDate;
	}

	public int getRtLove() {
		return rtLove;
	}

	public void setRtLove(int rtLove) {
		this.rtLove = rtLove;
	}

	public String getMeasures() {
		return measures;
	}

	public void setMeasures(String measures) {
		this.measures = measures;
	}
	
	
}
