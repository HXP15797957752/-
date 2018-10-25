package cn.bluedot.core.bo;

import java.util.Date;

import cn.bluedot.framemarker.common.BoSuper;

public class FeedSetBo implements BoSuper{
    //feedSet
    private Integer feedSetID;
    private Integer putNumber;
    private Date putTime;
    private Integer timeInterval; 
    
    //pigType
    private Integer pigTypeID;
    private String typeName;
    
    //growthState
    private Integer growthStateID;
    private String growthName;
    
    //formula
    private Integer formulaID;
    private String formulaName;
    public Integer getFeedSetID() {
        return feedSetID;
    }
    public void setFeedSetID(Integer feedSetID) {
        this.feedSetID = feedSetID;
    }
    public Integer getPutNumber() {
        return putNumber;
    }
    public void setPutNumber(Integer putNumber) {
        this.putNumber = putNumber;
    }
    public Date getPutTime() {
        return putTime;
    }
    public void setPutTime(Date putTime) {
        this.putTime = putTime;
    }
    public Integer getTimeInterval() {
        return timeInterval;
    }
    public void setTimeInterval(Integer timeInterval) {
        this.timeInterval = timeInterval;
    }
    public Integer getPigTypeID() {
        return pigTypeID;
    }
    public void setPigTypeID(Integer pigTypeID) {
        this.pigTypeID = pigTypeID;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public Integer getGrowthStateID() {
        return growthStateID;
    }
    public void setGrowthStateID(Integer growthStateID) {
        this.growthStateID = growthStateID;
    }
    public String getGrowthName() {
        return growthName;
    }
    public void setGrowthName(String growthName) {
        this.growthName = growthName;
    }
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
}
