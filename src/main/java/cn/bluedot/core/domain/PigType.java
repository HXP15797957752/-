package cn.bluedot.core.domain;
public class Pigtype{
    /** */
    private Integer pigTypeID;
    /** */
    private String name;
    /** */
    private String description;
    public void setPigTypeID(Integer pigTypeID){
        this.pigTypeID = pigTypeID;
    }
    public Integer getPigTypeID(){
        return this.pigTypeID;
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