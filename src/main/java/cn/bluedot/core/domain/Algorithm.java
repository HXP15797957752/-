package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����2:32:54
 * @
 */
public class Algorithm {
	/**
	 * �㷨����������
	 */
	private int algorithmID;
	
	/**
	 * �㷨����
	 */
	private String name;
	
	/**
	 * �㷨����  0��Ԥ�����㷨  1�������㷨
	 */
	private int type;
	
	/**
	 * �㷨����
	 */
	private String description;
	
	/**
	 * �ϴ�ʱ��
	 */
	private String dateTime;
	
	/**
	 * ״̬
	 */
	private int state;
	
	/**
	 * �㷨����·��
	 */
	private String savePath;
	
	/**
	 * �ϴ��㷨���û�
	 */
	private String uploadUserNo;
	
	/**
	 * �û����ش���
	 */
	private int downloadCount;

	public int getAlgorithmID() {
		return algorithmID;
	}

	public void setAlgorithmID(int algorithmID) {
		this.algorithmID = algorithmID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getUploadUserNo() {
		return uploadUserNo;
	}

	public void setUploadUserNo(String uploadUserNo) {
		this.uploadUserNo = uploadUserNo;
	}

	public int getDownloadCount() {
		return downloadCount;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}
	
	
	
	
}
