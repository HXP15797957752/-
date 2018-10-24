package cn.bluedot.core.domain;
public class DiseaseTreatment{
    /**疾病治疗ID*/
    private Integer diseaseTreatmentID;
    /**猪耳号*/
    private String pigNo;
    /** */
    private Integer drugTypeID;
    /**服药时间*/
    private java.util.Date eatTime;
    /**用药总用量*/
    private Integer useCount;
    /**生病时间*/
    private java.util.Date illTime;
    /**病情描述*/
    private String illDescription;
    public void setDiseaseTreatmentID(Integer diseaseTreatmentID){
        this.diseaseTreatmentID = diseaseTreatmentID;
    }
    public Integer getDiseaseTreatmentID(){
        return this.diseaseTreatmentID;
    }
    public void setPigNo(String pigNo){
        this.pigNo = pigNo;
    }
    public String getPigNo(){
        return this.pigNo;
    }
    public void setDrugTypeID(Integer drugTypeID){
        this.drugTypeID = drugTypeID;
    }
    public Integer getDrugTypeID(){
        return this.drugTypeID;
    }
    public void setEatTime(java.util.Date eatTime){
        this.eatTime = eatTime;
    }
    public java.util.Date getEatTime(){
        return this.eatTime;
    }
    public void setUseCount(Integer useCount){
        this.useCount = useCount;
    }
    public Integer getUseCount(){
        return this.useCount;
    }
    public void setIllTime(java.util.Date illTime){
        this.illTime = illTime;
    }
    public java.util.Date getIllTime(){
        return this.illTime;
    }
    public void setIllDescription(String illDescription){
        this.illDescription = illDescription;
    }
    public String getIllDescription(){
        return this.illDescription;
    }
}