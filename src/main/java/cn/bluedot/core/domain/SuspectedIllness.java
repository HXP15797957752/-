package cn.bluedot.core.domain;
public class SuspectedIllness{
    /** */
    private Integer ID;
    /**可疑生病ID,主键,自增*/
    private String pigNo;
    /** */
    private java.util.Date date;
    /** */
    private Integer temperature;
    public void setID(Integer ID){
        this.ID = ID;
    }
    public Integer getID(){
        return this.ID;
    }
    public void setPigNo(String pigNo){
        this.pigNo = pigNo;
    }
    public String getPigNo(){
        return this.pigNo;
    }
    public void setDate(java.util.Date date){
        this.date = date;
    }
    public java.util.Date getDate(){
        return this.date;
    }
    public void setTemperature(Integer temperature){
        this.temperature = temperature;
    }
    public Integer getTemperature(){
        return this.temperature;
    }
}