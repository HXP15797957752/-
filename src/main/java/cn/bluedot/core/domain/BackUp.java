package cn.bluedot.core.domain;
public class Backup{
    /**备份表主键，自增*/
    private Integer backupID;
    /**备份文件名称*/
    private String backupFileName;
    /**备份文件创建日期*/
    private java.util.Date createTime;
    /**备份文件存储的路径*/
    private String savePath;
    /**描述备份文件的信息*/
    private String description;
    public void setBackupID(Integer backupID){
        this.backupID = backupID;
    }
    public Integer getBackupID(){
        return this.backupID;
    }
    public void setBackupFileName(String backupFileName){
        this.backupFileName = backupFileName;
    }
    public String getBackupFileName(){
        return this.backupFileName;
    }
    public void setCreateTime(java.util.Date createTime){
        this.createTime = createTime;
    }
    public java.util.Date getCreateTime(){
        return this.createTime;
    }
    public void setSavePath(String savePath){
        this.savePath = savePath;
    }
    public String getSavePath(){
        return this.savePath;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
}