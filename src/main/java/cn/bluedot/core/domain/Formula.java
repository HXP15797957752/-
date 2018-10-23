package cn.bluedot.core.domain;
public class Formula{
    /**配方*/
    private Integer formulaID;
    /** */
    private String name;
    /**水比例*/
    private Integer waterProportion;
    /** */
    private Integer drugProportion;
    /** */
    private Integer feedProportion;
    /** */
    private Integer drugTypeID;
    /**季节*/
    private String season;
    /** */
    private java.util.Date createTime;
    /** */
    private String createUserNo;
    /** */
    private String description;
    public void setFormulaID(Integer formulaID){
        this.formulaID = formulaID;
    }
    public Integer getFormulaID(){
        return this.formulaID;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setWaterProportion(Integer waterProportion){
        this.waterProportion = waterProportion;
    }
    public Integer getWaterProportion(){
        return this.waterProportion;
    }
    public void setDrugProportion(Integer drugProportion){
        this.drugProportion = drugProportion;
    }
    public Integer getDrugProportion(){
        return this.drugProportion;
    }
    public void setFeedProportion(Integer feedProportion){
        this.feedProportion = feedProportion;
    }
    public Integer getFeedProportion(){
        return this.feedProportion;
    }
    public void setDrugTypeID(Integer drugTypeID){
        this.drugTypeID = drugTypeID;
    }
    public Integer getDrugTypeID(){
        return this.drugTypeID;
    }
    public void setSeason(String season){
        this.season = season;
    }
    public String getSeason(){
        return this.season;
    }
    public void setCreateTime(java.util.Date createTime){
        this.createTime = createTime;
    }
    public java.util.Date getCreateTime(){
        return this.createTime;
    }
    public void setCreateUserNo(String createUserNo){
        this.createUserNo = createUserNo;
    }
    public String getCreateUserNo(){
        return this.createUserNo;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
}