package cn.bluedot.core.domain;
public class FetalStructure{
    /**胎次结构ID,主键*/
    private Integer fetalStructureID;
    /**母猪耳号*/
    private String pigNo;
    /**母猪总产子数*/
    private Integer totalNumber;
    /**存活数*/
    private Integer survivalNumber;
    /**30天受胎率*/
    private java.math.BigDecimal pregnancyRate;
    /**分娩率*/
    private java.math.BigDecimal deliveryRate;
    public void setFetalStructureID(Integer fetalStructureID){
        this.fetalStructureID = fetalStructureID;
    }
    public Integer getFetalStructureID(){
        return this.fetalStructureID;
    }
    public void setPigNo(String pigNo){
        this.pigNo = pigNo;
    }
    public String getPigNo(){
        return this.pigNo;
    }
    public void setTotalNumber(Integer totalNumber){
        this.totalNumber = totalNumber;
    }
    public Integer getTotalNumber(){
        return this.totalNumber;
    }
    public void setSurvivalNumber(Integer survivalNumber){
        this.survivalNumber = survivalNumber;
    }
    public Integer getSurvivalNumber(){
        return this.survivalNumber;
    }
    public void setPregnancyRate(java.math.BigDecimal pregnancyRate){
        this.pregnancyRate = pregnancyRate;
    }
    public java.math.BigDecimal getPregnancyRate(){
        return this.pregnancyRate;
    }
    public void setDeliveryRate(java.math.BigDecimal deliveryRate){
        this.deliveryRate = deliveryRate;
    }
    public java.math.BigDecimal getDeliveryRate(){
        return this.deliveryRate;
    }
}