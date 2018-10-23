package cn.bluedot.core.domain;
public class Algorithm{
    /**算法主键，自增*/
    private Integer algorithmID;
    /**算法名称*/
    private String name;
    /**0:预处理算法  1:分析算法*/
    private Integer type;
    /**系统管理员对此算法的描述*/
    private String description;
    /**上传时间,以****-**-** **:**:** 此种格式为标准存入，精确到秒*/
    private java.util.Date uploadTime;
    /** */
    private Integer state;
    /**' COMMENT '算法存储路径*/
    private String savePath;
    /**上传算法的用户*/
    private String uploadUserNo;
    /**用户下载次数*/
    private Integer downloadCount;
    public void setAlgorithmID(Integer algorithmID){
        this.algorithmID = algorithmID;
    }
    public Integer getAlgorithmID(){
        return this.algorithmID;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setType(Integer type){
        this.type = type;
    }
    public Integer getType(){
        return this.type;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setUploadTime(java.util.Date uploadTime){
        this.uploadTime = uploadTime;
    }
    public java.util.Date getUploadTime(){
        return this.uploadTime;
    }
    public void setState(Integer state){
        this.state = state;
    }
    public Integer getState(){
        return this.state;
    }
    public void setSavePath(String savePath){
        this.savePath = savePath;
    }
    public String getSavePath(){
        return this.savePath;
    }
    public void setUploadUserNo(String uploadUserNo){
        this.uploadUserNo = uploadUserNo;
    }
    public String getUploadUserNo(){
        return this.uploadUserNo;
    }
    public void setDownloadCount(Integer downloadCount){
        this.downloadCount = downloadCount;
    }
    public Integer getDownloadCount(){
        return this.downloadCount;
    }
}