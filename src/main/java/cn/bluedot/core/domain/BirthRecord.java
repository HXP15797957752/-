package cn.bluedot.core.domain;
public class BirthRecord{
    /**出生记录编号*/
    private Integer birthRecordID;
    /** */
    private String pigNo;
    /**出生时间*/
    private java.util.Date birthTime;
    /**子猪数量*/
    private Integer babyCount;
    public void setBirthRecordID(Integer birthRecordID){
        this.birthRecordID = birthRecordID;
    }
    public Integer getBirthRecordID(){
        return this.birthRecordID;
    }
    public void setPigNo(String pigNo){
        this.pigNo = pigNo;
    }
    public String getPigNo(){
        return this.pigNo;
    }
    public void setBirthTime(java.util.Date birthTime){
        this.birthTime = birthTime;
    }
    public java.util.Date getBirthTime(){
        return this.birthTime;
    }
    public void setBabyCount(Integer babyCount){
        this.babyCount = babyCount;
    }
    public Integer getBabyCount(){
        return this.babyCount;
    }
}