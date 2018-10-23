package cn.bluedot.core.domain;
public class Power{
    /** */
    private Integer powerID;
    /** */
    private String name;
    /**权限类型*/
    private String powerType;
    public void setPowerID(Integer powerID){
        this.powerID = powerID;
    }
    public Integer getPowerID(){
        return this.powerID;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setPowerType(String powerType){
        this.powerType = powerType;
    }
    public String getPowerType(){
        return this.powerType;
    }
}