package cn.bluedot.core.domain;
public class GrowthState{
    /** */
    private Integer growthStateID;
    /** */
    private String name;
    /** */
    private String description;
    public void setGrowthStateID(Integer growthStateID){
        this.growthStateID = growthStateID;
    }
    public Integer getGrowthStateID(){
        return this.growthStateID;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
}