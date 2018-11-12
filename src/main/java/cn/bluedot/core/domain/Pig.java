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
	private Integer sex;
	
	/**
	 * ����
	 */
	private Integer age;
	
	/**
	 * ��������
	 */
	private Date birthTime;
	
	/**
	 * Ʒ��
	 */
	private Integer pigTypeID;
	
	/**
	 * �����׶�
	 */
	private Integer growthStateID;
	
	/**
	 * ״̬
	 */
	private Integer state;
	
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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthTime() {
		return birthTime;
	}

	public void setBirthTime(Date birthTime) {
		this.birthTime = birthTime;
	}

	public Integer getPigTypeID() {
		return pigTypeID;
	}

	public void setPigTypeID(Integer pigTypeID) {
		this.pigTypeID = pigTypeID;
	}

	public Integer getGrowthStateID() {
		return growthStateID;
	}

	public void setGrowthStateID(Integer growthStateID) {
		this.growthStateID = growthStateID;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
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
