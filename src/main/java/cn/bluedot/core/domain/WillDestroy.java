package cn.bluedot.core.domain;
public class WillDestroy{
    /**销毁ID,主键，自增*/
    private Integer willDestroyID;
    /** */
    private String pigNo;
    /**申请销毁提交时间*/
    private java.util.Date commitTime;
    /** */
    private String reason;
    /**审核人*/
    private String checkUserNo;
    /**是否同意*/
    private Integer isAgree;
    public void setWillDestroyID(Integer willDestroyID){
        this.willDestroyID = willDestroyID;
    }
    public Integer getWillDestroyID(){
        return this.willDestroyID;
    }
    public void setPigNo(String pigNo){
        this.pigNo = pigNo;
    }
    public String getPigNo(){
        return this.pigNo;
    }
    public void setCommitTime(java.util.Date commitTime){
        this.commitTime = commitTime;
    }
    public java.util.Date getCommitTime(){
        return this.commitTime;
    }
    public void setReason(String reason){
        this.reason = reason;
    }
    public String getReason(){
        return this.reason;
    }
    public void setCheckUserNo(String checkUserNo){
        this.checkUserNo = checkUserNo;
    }
    public String getCheckUserNo(){
        return this.checkUserNo;
    }
    public void setIsAgree(Integer isAgree){
        this.isAgree = isAgree;
    }
    public Integer getIsAgree(){
        return this.isAgree;
    }
}