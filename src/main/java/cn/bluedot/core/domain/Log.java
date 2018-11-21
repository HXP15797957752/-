package cn.bluedot.core.domain;

import java.util.Date;

import cn.bluedot.framemarker.common.BoSuper;

/**
 * 
 * @author hxp
 * 2018年10月25日 上午11:28:58
 */
public class Log implements BoSuper{
    /**
     *日志ID
     */
    private long logID;
    
    /**
     * 操作时间
     */
    private Date time;
    
    /**
     * 用户真实姓名
     */
    private String trueName;
    
    /**
     * 操作名称
     */
    private String operationName;
    
    /**
     * ip地址ַ
     */
    private String ipAddress;

    public long getLogID() {
        return logID;
    }

    public void setLogID(long logID) {
        this.logID = logID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "Log [logID=" + logID + ", time=" + time + ", trueName=" + trueName + ", operationName=" + operationName
                + ", ipAddress=" + ipAddress + "]";
    }

    
    
}
