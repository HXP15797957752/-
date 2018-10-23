package cn.bluedot.core.domain;
public class Payment{
    /**付款单编号*/
    private Integer paymentID;
    /**付款的类型*/
    private String paymentType;
    /**付款时间*/
    private java.util.Date paymentDate;
    /**物品订单号*/
    private Integer orderNumber;
    /**金额*/
    private double money;
    /**付款流水号*/
    private String serialNumber;
    /**付款原因*/
    private String paymentReason;
    /**订单申请人员*/
    private String applicant;
    /**处理人员*/
    private String manager;
    public void setPaymentID(Integer paymentID){
        this.paymentID = paymentID;
    }
    public Integer getPaymentID(){
        return this.paymentID;
    }
    public void setPaymentType(String paymentType){
        this.paymentType = paymentType;
    }
    public String getPaymentType(){
        return this.paymentType;
    }
    public void setPaymentDate(java.util.Date paymentDate){
        this.paymentDate = paymentDate;
    }
    public java.util.Date getPaymentDate(){
        return this.paymentDate;
    }
    public void setOrderNumber(Integer orderNumber){
        this.orderNumber = orderNumber;
    }
    public Integer getOrderNumber(){
        return this.orderNumber;
    }
    public void setMoney(double money){
        this.money = money;
    }
    public double getMoney(){
        return this.money;
    }
    public void setSerialNumber(String serialNumber){
        this.serialNumber = serialNumber;
    }
    public String getSerialNumber(){
        return this.serialNumber;
    }
    public void setPaymentReason(String paymentReason){
        this.paymentReason = paymentReason;
    }
    public String getPaymentReason(){
        return this.paymentReason;
    }
    public void setApplicant(String applicant){
        this.applicant = applicant;
    }
    public String getApplicant(){
        return this.applicant;
    }
    public void setManager(String manager){
        this.manager = manager;
    }
    public String getManager(){
        return this.manager;
    }
}