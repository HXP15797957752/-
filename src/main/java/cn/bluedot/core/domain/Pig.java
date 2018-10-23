package cn.bluedot.core.domain;
public class Pig{
    /** */
    private String pigNo;
    /** */
    private Integer sex;
    /** */
    private Integer age;
    /** */
    private java.util.Date birthTime;
    /** */
    private Integer pigTypeID;
    /** */
    private Integer growthStateID;
    /** */
    private Integer state;
    /** */
    private String fatherNo;
    /** */
    private String motherNo;
    /**产地*/
    private String orignPlace;
    /**当前所在猪栏*/
    private String hogcoteNo;
    public void setPigNo(String pigNo){
        this.pigNo = pigNo;
    }
    public String getPigNo(){
        return this.pigNo;
    }
    public void setSex(Integer sex){
        this.sex = sex;
    }
    public Integer getSex(){
        return this.sex;
    }
    public void setAge(Integer age){
        this.age = age;
    }
    public Integer getAge(){
        return this.age;
    }
    public void setBirthTime(java.util.Date birthTime){
        this.birthTime = birthTime;
    }
    public java.util.Date getBirthTime(){
        return this.birthTime;
    }
    public void setPigTypeID(Integer pigTypeID){
        this.pigTypeID = pigTypeID;
    }
    public Integer getPigTypeID(){
        return this.pigTypeID;
    }
    public void setGrowthStateID(Integer growthStateID){
        this.growthStateID = growthStateID;
    }
    public Integer getGrowthStateID(){
        return this.growthStateID;
    }
    public void setState(Integer state){
        this.state = state;
    }
    public Integer getState(){
        return this.state;
    }
    public void setFatherNo(String fatherNo){
        this.fatherNo = fatherNo;
    }
    public String getFatherNo(){
        return this.fatherNo;
    }
    public void setMotherNo(String motherNo){
        this.motherNo = motherNo;
    }
    public String getMotherNo(){
        return this.motherNo;
    }
    public void setOrignPlace(String orignPlace){
        this.orignPlace = orignPlace;
    }
    public String getOrignPlace(){
        return this.orignPlace;
    }
    public void setHogcoteNo(String hogcoteNo){
        this.hogcoteNo = hogcoteNo;
    }
    public String getHogcoteNo(){
        return this.hogcoteNo;
    }
}