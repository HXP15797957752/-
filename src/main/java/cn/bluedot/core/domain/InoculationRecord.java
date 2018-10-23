package cn.bluedot.core.domain;
public class Inoculationrecord{
    /**接种记录*/
    private Integer inoculationRecordID;
    /**接种设定ID*/
    private Integer inoculationSetID;
    /** */
    private String pigNo;
    /** */
    private java.util.Date time;
    /**是否已经接种*/
    private Integer isInoculate;
    /** */
    private String description;
    public void setInoculationRecordID(Integer inoculationRecordID){
        this.inoculationRecordID = inoculationRecordID;
    }
    public Integer getInoculationRecordID(){
        return this.inoculationRecordID;
    }
    public void setInoculationSetID(Integer inoculationSetID){
        this.inoculationSetID = inoculationSetID;
    }
    public Integer getInoculationSetID(){
        return this.inoculationSetID;
    }
    public void setPigNo(String pigNo){
        this.pigNo = pigNo;
    }
    public String getPigNo(){
        return this.pigNo;
    }
    public void setTime(java.util.Date time){
        this.time = time;
    }
    public java.util.Date getTime(){
        return this.time;
    }
    public void setIsInoculate(Integer isInoculate){
        this.isInoculate = isInoculate;
    }
    public Integer getIsInoculate(){
        return this.isInoculate;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
}