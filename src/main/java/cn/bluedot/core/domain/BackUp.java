package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����2:56:54
 */
public class BackUp {
	/**
	 * ��������
	 */
	private int backupID;
	
	/**
	 * �����ļ�����
	 */
	private String backupFileName;
	
	/**
	 * �����ļ���������
	 */
	private Date createTime;
	
	/**
	 * �����ļ�����·��
	 */
	private String savePath;
	
	/**
	 * ���������ļ���Ϣ
	 */
	private String description;

	public int getBackupID() {
		return backupID;
	}

	public void setBackupID(int backupID) {
		this.backupID = backupID;
	}

	public String getBackupFileName() {
		return backupFileName;
	}

	public void setBackupFileName(String backupFileName) {
		this.backupFileName = backupFileName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
