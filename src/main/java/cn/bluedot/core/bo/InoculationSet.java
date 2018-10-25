package cn.bluedot.core.bo;

import java.util.Date;

public class InoculationSet {
    //inoculationSet
    private Integer inoculationSetID;
    private Date inoculationTime;
    private String unit;
    private String useCount;
    private String pigstyNo;
    private Date createTime;
    private String description;
    //drugtype
    private Integer drugTypeID;
    private String drugName;
    
    //user
    private String inoculationUserNo;
    private String username;
    public Integer getInoculationSetID() {
        return inoculationSetID;
    }
    public void setInoculationSetID(Integer inoculationSetID) {
        this.inoculationSetID = inoculationSetID;
    }
    public Date getInoculationTime() {
        return inoculationTime;
    }
    public void setInoculationTime(Date inoculationTime) {
        this.inoculationTime = inoculationTime;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getUseCount() {
        return useCount;
    }
    public void setUseCount(String useCount) {
        this.useCount = useCount;
    }
    public String getPigstyNo() {
        return pigstyNo;
    }
    public void setPigstyNo(String pigstyNo) {
        this.pigstyNo = pigstyNo;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
    public String getInoculationUserNo() {
        return inoculationUserNo;
    }
    public void setInoculationUserNo(String inoculationUserNo) {
        this.inoculationUserNo = inoculationUserNo;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
