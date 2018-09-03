package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����5:33:19
 */
public class InoculationRecord {
	/**
	 * ���ּ�¼ID
	 */
	private long inoculationRecordID;
	
	/**
	 * �����趨ID
	 */
	private long inoculationSetID;
	
	/**
	 * �����
	 */
	private String pigNo;
	
	/**
	 *ʱ�� 
	 */
	private Date time;
	
	/**
	 * �Ƿ����
	 */
	private int isInoculate;
	
	/**
	 * ����
	 */
	private String description;

	public long getInoculationRecordID() {
		return inoculationRecordID;
	}

	public void setInoculationRecordID(long inoculationRecordID) {
		this.inoculationRecordID = inoculationRecordID;
	}

	public long getInoculationSetID() {
		return inoculationSetID;
	}

	public void setInoculationSetID(long inoculationSetID) {
		this.inoculationSetID = inoculationSetID;
	}

	public String getPigNo() {
		return pigNo;
	}

	public void setPigNo(String pigNo) {
		this.pigNo = pigNo;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getIsInoculate() {
		return isInoculate;
	}

	public void setIsInoculate(int isInoculate) {
		this.isInoculate = isInoculate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
