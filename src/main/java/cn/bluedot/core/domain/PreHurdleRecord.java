package cn.bluedot.core.domain;
public class PrehurdleRecord{
    /**转栏ID，主键，自增*/
    private Integer preHurdleRecordID;
    /** */
    private String pigNo;
    /**转栏时间*/
    private java.util.Date time;
    /** */
    private String startPigstyNo;
    /** */
    private String startHogcoteNo;
    /** */
    private String endPigstyNo;
    /** */
    private String endHogcoteNo;
    /**操作人No*/
    private String operatorUserNo;
    public void setPreHurdleRecordID(Integer preHurdleRecordID){
        this.preHurdleRecordID = preHurdleRecordID;
    }
    public Integer getPreHurdleRecordID(){
        return this.preHurdleRecordID;
    }
    public void setPigNo(String pigNo){
        this.pigNo = pigNo;
    }
    public String getPigNo(){
        return this.pigNo;
    }
    public void setTime(java.util.Date time){
        this.time = time;
    }
    public java.util.Date getTime(){
        return this.time;
    }
    public void setStartPigstyNo(String startPigstyNo){
        this.startPigstyNo = startPigstyNo;
    }
    public String getStartPigstyNo(){
        return this.startPigstyNo;
    }
    public void setStartHogcoteNo(String startHogcoteNo){
        this.startHogcoteNo = startHogcoteNo;
    }
    public String getStartHogcoteNo(){
        return this.startHogcoteNo;
    }
    public void setEndPigstyNo(String endPigstyNo){
        this.endPigstyNo = endPigstyNo;
    }
    public String getEndPigstyNo(){
        return this.endPigstyNo;
    }
    public void setEndHogcoteNo(String endHogcoteNo){
        this.endHogcoteNo = endHogcoteNo;
    }
    public String getEndHogcoteNo(){
        return this.endHogcoteNo;
    }
    public void setOperatorUserNo(String operatorUserNo){
        this.operatorUserNo = operatorUserNo;
    }
    public String getOperatorUserNo(){
        return this.operatorUserNo;
    }
}