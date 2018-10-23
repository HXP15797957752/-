package cn.bluedot.core.domain;
public class Estrus{
    /**发情记录*/
    private Integer estrusID;
    /** */
    private String pigNo;
    /**预产期*/
    private java.util.Date preBirthDate;
    /**已返情却未怀孕*/
    private Integer rtLove;
    /**采取措施*/
    private String measures;
    public void setEstrusID(Integer estrusID){
        this.estrusID = estrusID;
    }
    public Integer getEstrusID(){
        return this.estrusID;
    }
    public void setPigNo(String pigNo){
        this.pigNo = pigNo;
    }
    public String getPigNo(){
        return this.pigNo;
    }
    public void setPreBirthDate(java.util.Date preBirthDate){
        this.preBirthDate = preBirthDate;
    }
    public java.util.Date getPreBirthDate(){
        return this.preBirthDate;
    }
    public void setRtLove(Integer rtLove){
        this.rtLove = rtLove;
    }
    public Integer getRtLove(){
        return this.rtLove;
    }
    public void setMeasures(String measures){
        this.measures = measures;
    }
    public String getMeasures(){
        return this.measures;
    }
}