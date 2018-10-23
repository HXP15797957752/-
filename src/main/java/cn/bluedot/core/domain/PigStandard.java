package cn.bluedot.core.domain;
public class Pigstandard{
    /** */
    private Integer pigStandardID;
    /** */
    private Integer sex;
    /** */
    private Integer pigTypeID;
    /** */
    private Integer growthStateID;
    /**日增重*/
    private Integer addWeight;
    /** */
    private Integer upperLimit;
    /**下限*/
    private Integer lowerLimit;
    /** */
    private java.util.Date date;
    /**时间间隔*/
    private Integer timeInterval;
    public void setPigStandardID(Integer pigStandardID){
        this.pigStandardID = pigStandardID;
    }
    public Integer getPigStandardID(){
        return this.pigStandardID;
    }
    public void setSex(Integer sex){
        this.sex = sex;
    }
    public Integer getSex(){
        return this.sex;
    }
    public void setPigTypeID(Integer pigTypeID){
        this.pigTypeID = pigTypeID;
    }
    public Integer getPigTypeID(){
        return this.pigTypeID;
    }
    public void setGrowthStateID(Integer growthStateID){
        this.growthStateID = growthStateID;
    }
    public Integer getGrowthStateID(){
        return this.growthStateID;
    }
    public void setAddWeight(Integer addWeight){
        this.addWeight = addWeight;
    }
    public Integer getAddWeight(){
        return this.addWeight;
    }
    public void setUpperLimit(Integer upperLimit){
        this.upperLimit = upperLimit;
    }
    public Integer getUpperLimit(){
        return this.upperLimit;
    }
    public void setLowerLimit(Integer lowerLimit){
        this.lowerLimit = lowerLimit;
    }
    public Integer getLowerLimit(){
        return this.lowerLimit;
    }
    public void setDate(java.util.Date date){
        this.date = date;
    }
    public java.util.Date getDate(){
        return this.date;
    }
    public void setTimeInterval(Integer timeInterval){
        this.timeInterval = timeInterval;
    }
    public Integer getTimeInterval(){
        return this.timeInterval;
    }
}