package cn.bluedot.core.domain;

import java.util.Date;

/**
 * @author : 游斌平
 *
 */
public class Payment {
	/**
	 * 付款单编号
	 */
	private Integer  paymentID;
	/**
	 * 付款的类型
	 */
	private String paymentType;
	/**
	 * 付款时间
	 */
	private Date paymentDate;
	/**
	 * 物品订单号
	 */
	private Integer orderNumber;
	/**
	 * 金额
	 */
	private Double money;
	/**
	 * 付款流水号
	 */
	private String serialNumber;
	/**
	 * 付款原因
	 */
	private String paymentReason;
	/**
	 * 订单申请人员
	 */
	private String applicant;
	/**
	 * 处理人员
	 */
	private String manager;
	public Integer getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(Integer paymentID) {
		this.paymentID = paymentID;
	}
	
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getPaymentReason() {
		return paymentReason;
	}
	public void setPaymentReason(String paymentReason) {
		this.paymentReason = paymentReason;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "Payment [paymentID=" + paymentID + ", paymentType=" + paymentType + ", paymentDate=" + paymentDate
				+ ", orderNumber=" + orderNumber + ", money=" + money + ", serialNumber=" + serialNumber
				+ ", paymentReason=" + paymentReason + ", applicant=" + applicant + ", manager=" + manager + "]";
	}
	
	
	
	
}
