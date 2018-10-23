package cn.bluedot.core.domain;
public class Equipmentrecord{
    /** */
    private Integer equipmentRecordID;
    /**设备ID*/
    private Integer equipmentID;
    /**有效日期*/
    private java.util.Date effectiveDate;
    /**生产日期*/
    private java.util.Date createDate;
    /** */
    private java.util.Date date;
    /**采购价格*/
    private java.math.BigDecimal price;
    /**使用状态*/
    private Integer useState;
    public void setEquipmentRecordID(Integer equipmentRecordID){
        this.equipmentRecordID = equipmentRecordID;
    }
    public Integer getEquipmentRecordID(){
        return this.equipmentRecordID;
    }
    public void setEquipmentID(Integer equipmentID){
        this.equipmentID = equipmentID;
    }
    public Integer getEquipmentID(){
        return this.equipmentID;
    }
    public void setEffectiveDate(java.util.Date effectiveDate){
        this.effectiveDate = effectiveDate;
    }
    public java.util.Date getEffectiveDate(){
        return this.effectiveDate;
    }
    public void setCreateDate(java.util.Date createDate){
        this.createDate = createDate;
    }
    public java.util.Date getCreateDate(){
        return this.createDate;
    }
    public void setDate(java.util.Date date){
        this.date = date;
    }
    public java.util.Date getDate(){
        return this.date;
    }
    public void setPrice(java.math.BigDecimal price){
        this.price = price;
    }
    public java.math.BigDecimal getPrice(){
        return this.price;
    }
    public void setUseState(Integer useState){
        this.useState = useState;
    }
    public Integer getUseState(){
        return this.useState;
    }
}