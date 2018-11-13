package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����5:47:22
 */
public class Pig {
	/**
	 * �����
	 */
	private String pigNo;
	
	/**
	 * �Ա�
	 */
	private int sex;
	
	/**
	 * ����
	 */
	private int age;
	
	/**
	 * ��������
	 */
	private Date birthTime;
	
	/**
	 * Ʒ��
	 */
	private int pigTypeID;
	
	/**
	 * �����׶�
	 */
	private int growthStateID;
	
	/**
	 * ״̬
	 */
	private int state;
	
	/**
	 * ������
	 */
	private String fatherNo;
	
	/**
	 * ĸ����
	 */
	private String motherNo;
	
	/**
	 * ����
	 */
	private String orignPlace;
	
	/**
	 * ��ǰ�����������
	 */
	private String hogcoteNo;

	public String getPigNo() {
		return pigNo;
	}

	public void setPigNo(String pigNo) {
		this.pigNo = pigNo;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthTime() {
		return birthTime;
	}

	public void setBirthTime(Date birthTime) {
		this.birthTime = birthTime;
	}

	public int getPigTypeID() {
		return pigTypeID;
	}

	public void setPigTypeID(int pigTypeID) {
		this.pigTypeID = pigTypeID;
	}

	public int getGrowthStateID() {
		return growthStateID;
	}

	public void setGrowthStateID(int growthStateID) {
		this.growthStateID = growthStateID;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getFatherNo() {
		return fatherNo;
	}

	public void setFatherNo(String fatherNo) {
		this.fatherNo = fatherNo;
	}

	public String getMotherNo() {
		return motherNo;
	}

	public void setMotherNo(String motherNo) {
		this.motherNo = motherNo;
	}

	public String getOrignPlace() {
		return orignPlace;
	}

	public void setOrignPlace(String orignPlace) {
		this.orignPlace = orignPlace;
	}

	public String getHogcoteNo() {
		return hogcoteNo;
	}

	public void setHogcoteNo(String hogcoteNo) {
		this.hogcoteNo = hogcoteNo;
	}
	
}
