package cn.bluedot.core.domain;
public class Log{
    /** */
    private Integer logID;
    /**操作时间*/
    private java.util.Date time;
    /**操作人*/
    private String userNo;
    /** */
    private Integer powerID;
    /** */
    private String operationName;
    /** */
    private String ipAddress;
    public void setLogID(Integer logID){
        this.logID = logID;
    }
    public Integer getLogID(){
        return this.logID;
    }
    public void setTime(java.util.Date time){
        this.time = time;
    }
    public java.util.Date getTime(){
        return this.time;
    }
    public void setUserNo(String userNo){
        this.userNo = userNo;
    }
    public String getUserNo(){
        return this.userNo;
    }
    public void setPowerID(Integer powerID){
        this.powerID = powerID;
    }
    public Integer getPowerID(){
        return this.powerID;
    }
    public void setOperationName(String operationName){
        this.operationName = operationName;
    }
    public String getOperationName(){
        return this.operationName;
    }
    public void setIpAddress(String ipAddress){
        this.ipAddress = ipAddress;
    }
    public String getIpAddress(){
        return this.ipAddress;
    }
}