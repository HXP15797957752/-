package cn.bluedot.core.domain;
public class InoculationSet{
    /** */
    private Integer inoculationSetID;
    /**药种类*/
    private Integer drugTypeID;
    /**接种时间*/
    private java.util.Date inoculationTime;
    /**单位*/
    private String unit;
    /**用量*/
    private Integer useCount;
    /**接种人ID*/
    private String inoculationUserNo;
    /**猪舍编号*/
    private String pigstyNo;
    /**创建时间*/
    private java.util.Date createTime;
    /**描述*/
    private String description;
    public void setInoculationSetID(Integer inoculationSetID){
        this.inoculationSetID = inoculationSetID;
    }
    public Integer getInoculationSetID(){
        return this.inoculationSetID;
    }
    public void setDrugTypeID(Integer drugTypeID){
        this.drugTypeID = drugTypeID;
    }
    public Integer getDrugTypeID(){
        return this.drugTypeID;
    }
    public void setInoculationTime(java.util.Date inoculationTime){
        this.inoculationTime = inoculationTime;
    }
    public java.util.Date getInoculationTime(){
        return this.inoculationTime;
    }
    public void setUnit(String unit){
        this.unit = unit;
    }
    public String getUnit(){
        return this.unit;
    }
    public void setUseCount(Integer useCount){
        this.useCount = useCount;
    }
    public Integer getUseCount(){
        return this.useCount;
    }
    public void setInoculationUserNo(String inoculationUserNo){
        this.inoculationUserNo = inoculationUserNo;
    }
    public String getInoculationUserNo(){
        return this.inoculationUserNo;
    }
    public void setPigstyNo(String pigstyNo){
        this.pigstyNo = pigstyNo;
    }
    public String getPigstyNo(){
        return this.pigstyNo;
    }
    public void setCreateTime(java.util.Date createTime){
        this.createTime = createTime;
    }
    public java.util.Date getCreateTime(){
        return this.createTime;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
}