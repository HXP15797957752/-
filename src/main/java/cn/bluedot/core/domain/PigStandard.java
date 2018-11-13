package cn.bluedot.core.domain;

import java.util.Date;

/**
 * 
 * @author hxp
 * 2018��8��7�� ����5:57:15
 */
public class PigStandard {
	/**
	 * ���׼ID
	 */
	private Integer pigStandardID;
	
	/**
	 * ���Ա�
	 */
	private Integer sex;
	
	/**
	 * ��Ʒ��
	 */
	private Integer pigTypeID;
	
	/**
	 * �������׶�
	 */
	private Integer growthStateID;
	
	/**
	 * ������
	 */
	private Integer addWeight;
	
	/**
	 * ����
	 */
	private Integer upperLimit;
	
	/**
	 * ����
	 */
	private Integer lowerLimit;
	
	/**
	 * ����
	 */
	private Date date;
	
	/**
	 * ʱ����
	 */
	private Integer timeInterval;

    public Integer getPigStandardID() {
        return pigStandardID;
    }

    public void setPigStandardID(Integer pigStandardID) {
        this.pigStandardID = pigStandardID;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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

    public Integer getAddWeight() {
        return addWeight;
    }

    public void setAddWeight(Integer addWeight) {
        this.addWeight = addWeight;
    }

    public Integer getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Integer upperLimit) {
        this.upperLimit = upperLimit;
    }

    public Integer getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(Integer lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(Integer timeInterval) {
        this.timeInterval = timeInterval;
    }

	
	@Override
	public String toString() {
	   return pigTypeID + ":" + growthStateID + ":" +sex;
	}
}
