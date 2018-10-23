package cn.bluedot.core.domain;
public class Eliminate{
    /** */
    private Integer eliminateID;
    /** */
    private String pigNo;
    /**淘汰理由*/
    private String reason;
    /**日期，精确到天*/
    private java.util.Date date;
    public void setEliminateID(Integer eliminateID){
        this.eliminateID = eliminateID;
    }
    public Integer getEliminateID(){
        return this.eliminateID;
    }
    public void setPigNo(String pigNo){
        this.pigNo = pigNo;
    }
    public String getPigNo(){
        return this.pigNo;
    }
    public void setReason(String reason){
        this.reason = reason;
    }
    public String getReason(){
        return this.reason;
    }
    public void setDate(java.util.Date date){
        this.date = date;
    }
    public java.util.Date getDate(){
        return this.date;
    }
}