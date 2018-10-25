package cn.bluedot.core.bo;

import java.util.Date;

public class willDestroyBo {
    //willdestroy
    private Integer willDestroyID;
    private Date commitTime;
    private String reason;
    private Integer isAgree;
    
    //user
    private String chechUserNo;
    private String username;
    
    //user
    private String pigNo;

    public Integer getWillDestroyID() {
        return willDestroyID;
    }

    public void setWillDestroyID(Integer willDestroyID) {
        this.willDestroyID = willDestroyID;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(Integer isAgree) {
        this.isAgree = isAgree;
    }

    public String getChechUserNo() {
        return chechUserNo;
    }

    public void setChechUserNo(String chechUserNo) {
        this.chechUserNo = chechUserNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPigNo() {
        return pigNo;
    }

    public void setPigNo(String pigNo) {
        this.pigNo = pigNo;
    }
    
}
