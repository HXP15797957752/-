package cn.bluedot.core.bo;

import java.util.Date;

public class PigBo {
    //pig
    private String pigNo;
    private Integer sex;
    private Integer age;
    private Date birthTime;
    private Integer state;
    private String orignPlace;
    private String hogcoteNo;
    private String fatherNo;
    private String motherNo;
    
    //pigtype
    private int pigTypeID;
    private String typeName;
    
    //growthstate
    private int growthStateID;
    private String growthName;
    public String getPigNo() {
        return pigNo;
    }
    public void setPigNo(String pigNo) {
        this.pigNo = pigNo;
    }
    public String getSex() {
        if(sex == 0){
            return "公猪";
        }else{
            return "母猪";
        }
    }
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Date getBirthTime() {
        return birthTime;
    }
    public void setBirthTime(Date birthTime) {
        this.birthTime = birthTime;
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    public String getOrignPlace() {
        return orignPlace;
    }
    public void setOrignPlace(String orignPlace) {
        this.orignPlace = orignPlace;
    }
    public String getHogcoteNo() {
        return hogcoteNo;
    }
    public void setHogcoteNo(String hogcoteNo) {
        this.hogcoteNo = hogcoteNo;
    }
    public int getPigTypeID() {
        return pigTypeID;
    }
    public void setPigTypeID(int pigTypeID) {
        this.pigTypeID = pigTypeID;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public int getGrowthStateID() {
        return growthStateID;
    }
    public void setGrowthStateID(int growthStateID) {
        this.growthStateID = growthStateID;
    }
    public String getGrowthName() {
        return growthName;
    }
    public void setGrowthName(String growthName) {
        this.growthName = growthName;
    }
    public String getFatherNo() {
        return fatherNo;
    }
    public void setFatherNo(String fatherNo) {
        this.fatherNo = fatherNo;
    }
    public String getMotherNo() {
        return motherNo;
    }
    public void setMotherNo(String motherNo) {
        this.motherNo = motherNo;
    }
}
