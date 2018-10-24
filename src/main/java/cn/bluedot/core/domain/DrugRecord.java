package cn.bluedot.core.domain;
public class DrugRecord{
    /** */
    private Integer drugRecordID;
    /** */
    private Integer drugTypeID;
    /**生产日期*/
    private java.util.Date createTime;
    /**有效期*/
    private java.util.Date effectiveTime;
    /**当前库存量*/
    private Integer curNumber;
    /** */
    private String unit;
    /**是否为入库操作,0:否  1:是*/
    private Integer isWarehousing;
    /**出入库时间*/
    private java.util.Date time;
    /**出入库数量*/
    private Integer number;
    /**药价格*/
    private java.math.BigDecimal price;
    public void setDrugRecordID(Integer drugRecordID){
        this.drugRecordID = drugRecordID;
    }
    public Integer getDrugRecordID(){
        return this.drugRecordID;
    }
    public void setDrugTypeID(Integer drugTypeID){
        this.drugTypeID = drugTypeID;
    }
    public Integer getDrugTypeID(){
        return this.drugTypeID;
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