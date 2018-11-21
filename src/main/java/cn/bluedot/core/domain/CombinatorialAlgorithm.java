package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����3:09:00
 */
public class CombinatorialAlgorithm {
	/**
	 * ����㷨ID
	 */
	private int combinatorialAlgoritmID;
	
	/**
	 * ����㷨����
	 */
	private String name;
	
	/**
	 * ����û����
	 */
	private String combianatorialUserNo;
	
	/**
	 * ����㷨����
	 */
	private String function;
	
	/**
	 * Ԥ�����㷨ID
	 */
	private int preAlgoID;
	
	/**
	 * �����㷨ID
	 */
	private int analysisAlgoID;
	
	/**
	 * ����ʱ��
	 */
	private Date createTime;
	
	/**
	 * ״̬:�Ƿ񹫿�
	 */
	private int state;

	public int getCombinatorialAlgoritmID() {
		return combinatorialAlgoritmID;
	}

	public void setCombinatorialAlgoritmID(int combinatorialAlgoritmID) {
		this.combinatorialAlgoritmID = combinatorialAlgoritmID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCombianatorialUserNo() {
		return combianatorialUserNo;
	}

	public void setCombianatorialUserNo(String combianatorialUserNo) {
		this.combianatorialUserNo = combianatorialUserNo;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public int getPreAlgoID() {
		return preAlgoID;
	}

	public void setPreAlgoID(int preAlgoID) {
		this.preAlgoID = preAlgoID;
	}

	public int getAnalysisAlgoID() {
		return analysisAlgoID;
	}

	public void setAnalysisAlgoID(int analysisAlgoID) {
		this.analysisAlgoID = analysisAlgoID;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
}
