package cn.bluedot.core.bo;

import java.util.Date;

import cn.bluedot.framemarker.common.BoSuper;

public class GrowthStandardBo implements BoSuper{
    private int pigStandardID;
    private int sex;
    private int addWeight;
    private int upperLimit;
    private int lowerLimit;
    private Date date;
    private int timeInterval;
    
    private int pigTypeID;
    private String typeName;
    
    private int growthStateID;
    private String growthName;
    
    
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getPigStandardID() {
        return pigStandardID;
    }
    public void setPigStandardID(int pigStandardID) {
        this.pigStandardID = pigStandardID;
    }
    public String getSex() {
        if(sex == 0){
            return "公猪";
        }else{
            return "母猪";
        }
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public int getAddWeight() {
        return addWeight;
    }
    public void setAddWeight(int addWeight) {
        this.addWeight = addWeight;
    }
    public int getUpperLimit() {
        return upperLimit;
    }
    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }
    public int getLowerLimit() {
        return lowerLimit;
    }
    public void setLowerLimit(int lowerLimit) {
        this.lowerLimit = lowerLimit;
    }
//    public Date getDate() {
//        return date;
//    }
//    public void setDate(Date date) {
//        this.date = date;
//    }
    public int getTimeInterval() {
        return timeInterval;
    }
    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }
    public int getPigTypeID() {
        return pigTypeID;
    }
    public void setPigTypeID(int pigTypeID) {
        this.pigTypeID = pigTypeID;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public int getGrowthStateID() {
        return growthStateID;
    }
    public void setGrowthStateID(int growthStateID) {
        this.growthStateID = growthStateID;
    }
    public String getGrowthName() {
        return growthName;
    }
    public void setGrowthName(String growthName) {
        this.growthName = growthName;
    }
    
    
}
