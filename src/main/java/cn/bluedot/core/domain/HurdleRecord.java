package cn.bluedot.core.domain;
public class HurdleRecord{
    /** */
    private Integer hurdleRecordID;
    /**转栏时间*/
    private java.util.Date time;
    /** */
    private String pigNo;
    /** */
    private Integer growthStateID;
    /** */
    private String inHogcoteNo;
    /** */
    private String outHogcoteNo;
    /**操作人*/
    private String userNo;
    /**注释*/
    private String description;
    /**如果是出栏出售,此处为出栏价格*/
    private java.math.BigDecimal outPrice;
    /**如果是出栏出售,此处记录出售地*/
    private String outPlace;
    public void setHurdleRecordID(Integer hurdleRecordID){
        this.hurdleRecordID = hurdleRecordID;
    }
    public Integer getHurdleRecordID(){
        return this.hurdleRecordID;
    }
    public void setTime(java.util.Date time){
        this.time = time;
    }
    public java.util.Date getTime(){
        return this.time;
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
    public void setInHogcoteNo(String inHogcoteNo){
        this.inHogcoteNo = inHogcoteNo;
    }
    public String getInHogcoteNo(){
        return this.inHogcoteNo;
    }
    public void setOutHogcoteNo(String outHogcoteNo){
        this.outHogcoteNo = outHogcoteNo;
    }
    public String getOutHogcoteNo(){
        return this.outHogcoteNo;
    }
    public void setUserNo(String userNo){
        this.userNo = userNo;
    }
    public String getUserNo(){
        return this.userNo;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setOutPrice(java.math.BigDecimal outPrice){
        this.outPrice = outPrice;
    }
    public java.math.BigDecimal getOutPrice(){
        return this.outPrice;
    }
    public void setOutPlace(String outPlace){
        this.outPlace = outPlace;
    }
    public String getOutPlace(){
        return this.outPlace;
    }
}