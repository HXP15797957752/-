package cn.bluedot.core.domain;
public class Drugtype{
    /** */
    private Integer drugTypeID;
    /**药类型名称*/
    private String name;
    public void setDrugTypeID(Integer drugTypeID){
        this.drugTypeID = drugTypeID;
    }
    public Integer getDrugTypeID(){
        return this.drugTypeID;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}