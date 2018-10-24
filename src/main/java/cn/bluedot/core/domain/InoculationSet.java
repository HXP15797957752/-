package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����5:38:06
 */
public class InoculationSet {
	/**
	 * �����趨ID
	 */
	private long inoculationSetID;
	
	/**
	 * ҩƷ����ID
	 */
	private int drugTypeID;
	
	/**
	 * ����ʱ��
	 */
	private Date inoculationTime;
	
	/**
	 * ��λ
	 */
	private String unit;
	
	/**
	 * ����
	 */
	private int useCount;
	
	/**
	 * ������
	 */
	private String inoculationUserNo;
	
	/**
	 * ������
	 */
	private String pipgstyNo;
	
	/**
	 * ����ʱ��
	 */
	private Date createTime;
	
	/**
	 * ����˵��
	 */
	private String description;

	public long getInoculationSetID() {
		return inoculationSetID;
	}

	public void setInoculationSetID(long inoculationSetID) {
		this.inoculationSetID = inoculationSetID;
	}

	public int getDrugTypeID() {
		return drugTypeID;
	}

	public void setDrugTypeID(int drugTypeID) {
		this.drugTypeID = drugTypeID;
	}

	public Date getInoculationTime() {
		return inoculationTime;
	}

	public void setInoculationTime(Date inoculationTime) {
		this.inoculationTime = inoculationTime;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getUseCount() {
		return useCount;
	}

	public void setUseCount(int useCount) {
		this.useCount = useCount;
	}

	public String getInoculationUserNo() {
		return inoculationUserNo;
	}

	public void setInoculationUserNo(String inoculationUserNo) {
		this.inoculationUserNo = inoculationUserNo;
	}

	public String getPipgstyNo() {
		return pipgstyNo;
	}

	public void setPipgstyNo(String pipgstyNo) {
		this.pipgstyNo = pipgstyNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
