package cn.bluedot.core.bo;

import java.util.Date;

public class diseaseTreatment {
    //diseaseTreatment
    private Integer ID;
    private Date eatTime;
    private Integer useCount;
    private Date illTime;
    private String illDescription;
    
    //pig
    private String pigNo;
    
    //drugtype
    private Integer drugTypeID;
    private String drugName;
    public Integer getID() {
        return ID;
    }
    public void setID(Integer iD) {
        ID = iD;
    }
    public Date getEatTime() {
        return eatTime;
    }
    public void setEatTime(Date eatTime) {
        this.eatTime = eatTime;
    }
    public Integer getUseCount() {
        return useCount;
    }
    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }
    public Date getIllTime() {
        return illTime;
    }
    public void setIllTime(Date illTime) {
        this.illTime = illTime;
    }
    public String getIllDescription() {
        return illDescription;
    }
    public void setIllDescription(String illDescription) {
        this.illDescription = illDescription;
    }
    public String getPigNo() {
        return pigNo;
    }
    public void setPigNo(String pigNo) {
        this.pigNo = pigNo;
    }
    public Integer getDrugTypeID() {
        return drugTypeID;
    }
    public void setDrugTypeID(Integer drugTypeID) {
        this.drugTypeID = drugTypeID;
    }
    public String getDrugName() {
        return drugName;
    }
    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }
}