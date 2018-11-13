package cn.bluedot.core.domain;

import java.util.Date;

/**
 * @author : 游斌平
 *
 */
public class Gathering {
	/**
	 * 收款单号
	 */
	private Integer gatheringID;
	/**
	 * 收款类型
	 */
	private Integer gatheringType;
	/**
	 * 收款时间
	 */
	private Date gatherDate;
	/**
	 * 金额
	 */
	private Double money;
	/**
	 * 收款的流水号
	 */
	private String serialNumber;
	/**
	 * 收款原因
	 */
	private String gatherReason;
	/**
	 * 物品订单号
	 */
	private String orderNumber;
	/**
	 * 付款人员
	 */
	private String  payer;
	/**
	 * 收款人员
	 */
	private String receiver;
	public Integer getGatheringID() {
		return gatheringID;
	}
	public void setGatheringID(Integer gatheringID) {
		this.gatheringID = gatheringID;
	}
	
	public Integer getGatheringType() {
		return gatheringType;
	}
	public void setGatheringType(Integer gatheringType) {
		this.gatheringType = gatheringType;
	}
	public Date getGatherDate() {
		return gatherDate;
	}
	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
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
	public String getGatherReason() {
		return gatherReason;
	}
	public void setGatherReason(String gatherReason) {
		this.gatherReason = gatherReason;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	@Override
	public String toString() {
		return "Gathering [gatheringID=" + gatheringID + ", gatheringType=" + gatheringType + ", gatherDate="
				+ gatherDate + ", money=" + money + ", serialNumber=" + serialNumber + ", gatherReason=" + gatherReason
				+ ", orderNumber=" + orderNumber + ", payer=" + payer + ", receiver=" + receiver + "]";
	}
	
	
	
}
