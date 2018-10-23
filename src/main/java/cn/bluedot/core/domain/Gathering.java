package cn.bluedot.core.domain;
public class Gathering{
    /**收款单号*/
    private Integer gatheringID;
    /**收款的类型*/
    private String gatheringType;
    /**收款时间*/
    private java.util.Date gatherDate;
    /**金额*/
    private double money;
    /**收款的流水号*/
    private String serialNumber;
    /**收款原因*/
    private String gatherReason;
    /**物品订单号*/
    private String orderNumber;
    /**付款人员*/
    private String payer;
    /**收款人员*/
    private String receiver;
    public void setGatheringID(Integer gatheringID){
        this.gatheringID = gatheringID;
    }
    public Integer getGatheringID(){
        return this.gatheringID;
    }
    public void setGatheringType(String gatheringType){
        this.gatheringType = gatheringType;
    }
    public String getGatheringType(){
        return this.gatheringType;
    }
    public void setGatherDate(java.util.Date gatherDate){
        this.gatherDate = gatherDate;
    }
    public java.util.Date getGatherDate(){
        return this.gatherDate;
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
    public void setGatherReason(String gatherReason){
        this.gatherReason = gatherReason;
    }
    public String getGatherReason(){
        return this.gatherReason;
    }
    public void setOrderNumber(String orderNumber){
        this.orderNumber = orderNumber;
    }
    public String getOrderNumber(){
        return this.orderNumber;
    }
    public void setPayer(String payer){
        this.payer = payer;
    }
    public String getPayer(){
        return this.payer;
    }
    public void setReceiver(String receiver){
        this.receiver = receiver;
    }
    public String getReceiver(){
        return this.receiver;
    }
}