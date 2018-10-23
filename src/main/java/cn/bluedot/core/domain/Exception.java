package cn.bluedot.core.domain;
public class Exception{
    /** */
    private Integer exceptionID;
    /** */
    private Integer equipmentID;
    /** */
    private java.util.Date time;
    /** */
    private String processingMethod;
    /** */
    private String processUserNo;
    public void setExceptionID(Integer exceptionID){
        this.exceptionID = exceptionID;
    }
    public Integer getExceptionID(){
        return this.exceptionID;
    }
    public void setEquipmentID(Integer equipmentID){
        this.equipmentID = equipmentID;
    }
    public Integer getEquipmentID(){
        return this.equipmentID;
    }
    public void setTime(java.util.Date time){
        this.time = time;
    }
    public java.util.Date getTime(){
        return this.time;
    }
    public void setProcessingMethod(String processingMethod){
        this.processingMethod = processingMethod;
    }
    public String getProcessingMethod(){
        return this.processingMethod;
    }
    public void setProcessUserNo(String processUserNo){
        this.processUserNo = processUserNo;
    }
    public String getProcessUserNo(){
        return this.processUserNo;
    }
}