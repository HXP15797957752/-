package cn.bluedot.core.domain;
public class Feedrecord{
    /** */
    private Integer feedRecordID;
    /** */
    private java.util.Date createTime;
    /** */
    private java.util.Date effectiveTime;
    /** */
    private Integer curNumber;
    /** */
    private String unit;
    /** */
    private Integer isWarehousing;
    /** */
    private java.util.Date time;
    /** */
    private Integer number;
    /** */
    private java.math.BigDecimal price;
    public void setFeedRecordID(Integer feedRecordID){
        this.feedRecordID = feedRecordID;
    }
    public Integer getFeedRecordID(){
        return this.feedRecordID;
    }
    public void setCreateTime(java.util.Date createTime){
        this.createTime = createTime;
    }
    public java.util.Date getCreateTime(){
        return this.createTime;
    }
    public void setEffectiveTime(java.util.Date effectiveTime){
        this.effectiveTime = effectiveTime;
    }
    public java.util.Date getEffectiveTime(){
        return this.effectiveTime;
    }
    public void setCurNumber(Integer curNumber){
        this.curNumber = curNumber;
    }
    public Integer getCurNumber(){
        return this.curNumber;
    }
    public void setUnit(String unit){
        this.unit = unit;
    }
    public String getUnit(){
        return this.unit;
    }
    public void setIsWarehousing(Integer isWarehousing){
        this.isWarehousing = isWarehousing;
    }
    public Integer getIsWarehousing(){
        return this.isWarehousing;
    }
    public void setTime(java.util.Date time){
        this.time = time;
    }
    public java.util.Date getTime(){
        return this.time;
    }
    public void setNumber(Integer number){
        this.number = number;
    }
    public Integer getNumber(){
        return this.number;
    }
    public void setPrice(java.math.BigDecimal price){
        this.price = price;
    }
    public java.math.BigDecimal getPrice(){
        return this.price;
    }
}