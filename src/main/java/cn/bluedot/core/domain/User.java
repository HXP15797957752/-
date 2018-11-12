package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����6:28:18
 */
public class User {
	/**
	 * �û���ţ����ţ�
	 */
	private String userNo;
	
	/**
	 * ����
	 */
	private String email;
	
	/**
	 * �ֻ���
	 */
	private char phoneNumber;
	
	/**
	 * ����
	 */
	private String password;
	
	/**
	 * ��ʵ����
	 */
	private String trueName;
	
	/**
	 * �Ա�
	 */
	private int sex;
	
	/**
	 * ���֤
	 */
	private char IDCard;
	
	/**
	 * ͷ��url
	 */
	private String headPotraitUrl;
	
	/**
	 * ע������
	 */
	private Date createDate;
	
	/**
	 * ��Ч����
	 */
	private Date effectiveDate;
	
	/**
	 * ���˼��
	 */
	private String personalProfile;
	
	/**
	 * �ܱ�����
	 */
	private String question;
	
	/**
	 * �ܱ���
	 */
	private String answer;
	
	/**
	 * ���״̬��Ĭ��Ϊ����ˣ�
	 */
	private int state;
	
	/**
	 * �����ע
	 */
	private String reviewAnnotation;

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(char phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public char getIDCard() {
		return IDCard;
	}

	public void setIDCard(char iDCard) {
		IDCard = iDCard;
	}

	public String getHeadPotraitUrl() {
		return headPotraitUrl;
	}

	public void setHeadPotraitUrl(String headPotraitUrl) {
		this.headPotraitUrl = headPotraitUrl;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getPersonalProfile() {
		return personalProfile;
	}

	public void setPersonalProfile(String personalProfile) {
		this.personalProfile = personalProfile;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getReviewAnnotation() {
		return reviewAnnotation;
	}

	public void setReviewAnnotation(String reviewAnnotation) {
		this.reviewAnnotation = reviewAnnotation;
	}
	
}
