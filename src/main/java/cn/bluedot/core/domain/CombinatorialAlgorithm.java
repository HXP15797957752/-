package cn.bluedot.core.domain;
public class CombinatorialAlgorithm{
    /**主键，自增*/
    private Integer combinatorialAlgorithmID;
    /**组合算法名称*/
    private String name;
    /** */
    private String combinatorialUserNo;
    /**该组合算法的功能*/
    private String function;
    /** */
    private Integer preAlgoID;
    /** */
    private Integer analysisAlgoID;
    /**组合算法创建时间,例如2016-12-12 22:22:22*/
    private java.util.Date createTime;
    /**是否公开*/
    private Integer state;
    public void setCombinatorialAlgorithmID(Integer combinatorialAlgorithmID){
        this.combinatorialAlgorithmID = combinatorialAlgorithmID;
    }
    public Integer getCombinatorialAlgorithmID(){
        return this.combinatorialAlgorithmID;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setCombinatorialUserNo(String combinatorialUserNo){
        this.combinatorialUserNo = combinatorialUserNo;
    }
    public String getCombinatorialUserNo(){
        return this.combinatorialUserNo;
    }
    public void setFunction(String function){
        this.function = function;
    }
    public String getFunction(){
        return this.function;
    }
    public void setPreAlgoID(Integer preAlgoID){
        this.preAlgoID = preAlgoID;
    }
    public Integer getPreAlgoID(){
        return this.preAlgoID;
    }
    public void setAnalysisAlgoID(Integer analysisAlgoID){
        this.analysisAlgoID = analysisAlgoID;
    }
    public Integer getAnalysisAlgoID(){
        return this.analysisAlgoID;
    }
    public void setCreateTime(java.util.Date createTime){
        this.createTime = createTime;
    }
    public java.util.Date getCreateTime(){
        return this.createTime;
    }
    public void setState(Integer state){
        this.state = state;
    }
    public Integer getState(){
        return this.state;
    }
}