package cn.bluedot.core.bo;

import java.util.Date;

public class SetFormulsaBo {
    //formulsa
    private Integer formulaID;
    private String formulaName;
    private Integer waterProportion;
    private Integer drugProportion;
    private Integer feedProportion;
    private String season;
    private Date createTime;
    private String description;
    
    //drugtype
    private Integer drugTypeID;
    private String typename;
    
    //user
    private String createUserNo;
    private String userName;
    public Integer getFormulaID() {
        return formulaID;
    }
    public void setFormulaID(Integer formulaID) {
        this.formulaID = formulaID;
    }
    public String getFormulaName() {
        return formulaName;
    }
    public void setFormulaName(String formulaName) {
        this.formulaName = formulaName;
    }
    public Integer getWaterProportion() {
        return waterProportion;
    }
    public void setWaterProportion(Integer waterProportion) {
        this.waterProportion = waterProportion;
    }
    public Integer getDrugProportion() {
        return drugProportion;
    }
    public void setDrugProportion(Integer drugProportion) {
        this.drugProportion = drugProportion;
    }
    public Integer getFeedProportion() {
        return feedProportion;
    }
    public void setFeedProportion(Integer feedProportion) {
        this.feedProportion = feedProportion;
    }
    public String getSeason() {
        return season;
    }
    public void setSeason(String season) {
        this.season = season;
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
    public String getTypename() {
        return typename;
    }
    public void setTypename(String typename) {
        this.typename = typename;
    }
    public String getCreateUserNo() {
        return createUserNo;
    }
    public void setCreateUserNo(String createUserNo) {
        this.createUserNo = createUserNo;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
