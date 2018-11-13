package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����4:36:02
 */
public class Formula {
	/**
	 * �䷽ID
	 */
	private int formulaID;
	
	/**
	 * �䷽����
	 */
	private String name;
	
	/**
	 * ˮ����
	 */
	private int waterProportion;
	
	/**
	 * ҩ����
	 */
	private int drugProportion;
	
	/**
	 * ���ϱ���
	 */
	private int feedProportion;
	
	/**
	 * ҩ����ID
	 */
	private int drugTypeID;
	
	/**
	 * ����
	 */
	private char season;
	
	/**
	 * ����ʱ��
	 */
	private Date createTime;
	
	/**
	 * ������
	 */
	private String createUserNo;
	
	/**
	 * ��ע
	 */
	private String description;

	public int getFormulaID() {
		return formulaID;
	}

	public void setFormulaID(int formulaID) {
		this.formulaID = formulaID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWaterProportion() {
		return waterProportion;
	}

	public void setWaterProportion(int waterProportion) {
		this.waterProportion = waterProportion;
	}

	public int getDrugProportion() {
		return drugProportion;
	}

	public void setDrugProportion(int drugProportion) {
		this.drugProportion = drugProportion;
	}

	public int getFeedProportion() {
		return feedProportion;
	}

	public void setFeedProportion(int feedProportion) {
		this.feedProportion = feedProportion;
	}

	public int getDrugTypeID() {
		return drugTypeID;
	}

	public void setDrugTypeID(int drugTypeID) {
		this.drugTypeID = drugTypeID;
	}

	public char getSeason() {
		return season;
	}

	public void setSeason(char season) {
		this.season = season;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserNo() {
		return createUserNo;
	}

	public void setCreateUserNo(String createUserNo) {
		this.createUserNo = createUserNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
