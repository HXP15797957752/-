package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����3:15:57
 */
public class DiseaseTreatment {
	/**
	 * ��������ID
	 */
	private int diseaseTreatmentID;
	
	/**
	 * �����
	 */
	private String pigNo;
	
	/**
	 * ҩ������ID
	 */
	private int drugTypeID;
	
	/**
	 * ��ҩʱ��
	 */
	private Date eatTime;
	
	/**
	 * ��ҩ������
	 */
	private int useCouont;
	
	/**
	 * ����ʱ��
	 */
	private Date illTime;
	
	/**
	 * ��������
	 */
	private String illDescription;

	public int getDiseaseTreatmentID() {
		return diseaseTreatmentID;
	}

	public void setDiseaseTreatmentID(int diseaseTreatmentID) {
		this.diseaseTreatmentID = diseaseTreatmentID;
	}

	public String getPigNo() {
		return pigNo;
	}

	public void setPigNo(String pigNo) {
		this.pigNo = pigNo;
	}

	public int getDrugTypeID() {
		return drugTypeID;
	}

	public void setDrugTypeID(int drugTypeID) {
		this.drugTypeID = drugTypeID;
	}

	public Date getEatTime() {
		return eatTime;
	}

	public void setEatTime(Date eatTime) {
		this.eatTime = eatTime;
	}

	public int getUseCouont() {
		return useCouont;
	}

	public void setUseCouont(int useCouont) {
		this.useCouont = useCouont;
	}

	public Date getIllTime() {
		return illTime;
	}

	public void setIllTime(Date illTime) {
		this.illTime = illTime;
	}

	public String getIllDescription() {
		return illDescription;
	}

	public void setIllDescription(String illDescription) {
		this.illDescription = illDescription;
	}
	
}
