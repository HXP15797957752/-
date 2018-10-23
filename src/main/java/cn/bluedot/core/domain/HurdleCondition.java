package cn.bluedot.core.domain;
public class Hurdlecondition{
    /** */
    private Integer hurdleConditionID;
    /** */
    private Integer growthStateID;
    /**天数*/
    private Integer days;
    public void setHurdleConditionID(Integer hurdleConditionID){
        this.hurdleConditionID = hurdleConditionID;
    }
    public Integer getHurdleConditionID(){
        return this.hurdleConditionID;
    }
    public void setGrowthStateID(Integer growthStateID){
        this.growthStateID = growthStateID;
    }
    public Integer getGrowthStateID(){
        return this.growthStateID;
    }
    public void setDays(Integer days){
        this.days = days;
    }
    public Integer getDays(){
        return this.days;
    }
}