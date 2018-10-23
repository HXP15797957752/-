package cn.bluedot.core.domain;
public class Pigsty{
    /**猪舍编号*/
    private String pigstyNo;
    /**猪舍的类型,比如有公猪舍,...*/
    private String type;
    /**猪栏数量*/
    private Integer number;
    /**面积*/
    private java.math.BigDecimal area;
    /**当前猪舍所在猪场*/
    private String piggeryNo;
    /** */
    private Integer pigTypeID;
    /** */
    private Integer growthStageID;
    public void setPigstyNo(String pigstyNo){
        this.pigstyNo = pigstyNo;
    }
    public String getPigstyNo(){
        return this.pigstyNo;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setNumber(Integer number){
        this.number = number;
    }
    public Integer getNumber(){
        return this.number;
    }
    public void setArea(java.math.BigDecimal area){
        this.area = area;
    }
    public java.math.BigDecimal getArea(){
        return this.area;
    }
    public void setPiggeryNo(String piggeryNo){
        this.piggeryNo = piggeryNo;
    }
    public String getPiggeryNo(){
        return this.piggeryNo;
    }
    public void setPigTypeID(Integer pigTypeID){
        this.pigTypeID = pigTypeID;
    }
    public Integer getPigTypeID(){
        return this.pigTypeID;
    }
    public void setGrowthStageID(Integer growthStageID){
        this.growthStageID = growthStageID;
    }
    public Integer getGrowthStageID(){
        return this.growthStageID;
    }
}