package cn.bluedot.core.domain;
public class EatRecord{
    /** */
    private Integer eatRecordID;
    /** */
    private String pigNo;
    /**生长阶段*/
    private Integer growthStateID;
    /**平均剩余量*/
    private Integer surplus;
    /**平均食用量*/
    private Integer eatCount;
    public void setEatRecordID(Integer eatRecordID){
        this.eatRecordID = eatRecordID;
    }
    public Integer getEatRecordID(){
        return this.eatRecordID;
    }
    public void setPigNo(String pigNo){
        this.pigNo = pigNo;
    }
    public String getPigNo(){
        return this.pigNo;
    }
    public void setGrowthStateID(Integer growthStateID){
        this.growthStateID = growthStateID;
    }
    public Integer getGrowthStateID(){
        return this.growthStateID;
    }
    public void setSurplus(Integer surplus){
        this.surplus = surplus;
    }
    public Integer getSurplus(){
        return this.surplus;
    }
    public void setEatCount(Integer eatCount){
        this.eatCount = eatCount;
    }
    public Integer getEatCount(){
        return this.eatCount;
    }
}