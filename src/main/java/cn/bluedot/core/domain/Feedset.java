package cn.bluedot.core.domain;
public class Feedset{
    /**饲喂设定*/
    private Integer feedSetID;
    /** */
    private Integer pigTypeID;
    /** */
    private Integer growthStateID;
    /** */
    private Integer formulaID;
    /**投放量*/
    private Integer putNumber;
    /** */
    private java.util.Date putTime;
    /**时间间隔*/
    private Integer timeInterval;
    public void setFeedSetID(Integer feedSetID){
        this.feedSetID = feedSetID;
    }
    public Integer getFeedSetID(){
        return this.feedSetID;
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
    public void setFormulaID(Integer formulaID){
        this.formulaID = formulaID;
    }
    public Integer getFormulaID(){
        return this.formulaID;
    }
    public void setPutNumber(Integer putNumber){
        this.putNumber = putNumber;
    }
    public Integer getPutNumber(){
        return this.putNumber;
    }
    public void setPutTime(java.util.Date putTime){
        this.putTime = putTime;
    }
    public java.util.Date getPutTime(){
        return this.putTime;
    }
    public void setTimeInterval(Integer timeInterval){
        this.timeInterval = timeInterval;
    }
    public Integer getTimeInterval(){
        return this.timeInterval;
    }
}