package cn.bluedot.core.bo;

import cn.bluedot.framemarker.common.BoSuper;

public class DoubtfulIllBo implements BoSuper{
    //pig
    private String pigNo;
    private Integer sex;
    private Integer state;
    private String hogcoteNo;
    
    //pigType
    private Integer pigTypeID;
    private String typeName;
    
    //growthState
    private Integer growthStateID;
    private String growthName;
    
    //hogcote
    private String hhogcoteNo;
    private String pigstyNo;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getHogcoteNo() {
        return hogcoteNo;
    }

    public void setHogcoteNo(String hogcoteNo) {
        this.hogcoteNo = hogcoteNo;
    }

    public Integer getPigTypeID() {
        return pigTypeID;
    }

    public void setPigTypeID(Integer pigTypeID) {
        this.pigTypeID = pigTypeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getGrowthStateID() {
        return growthStateID;
    }

    public void setGrowthStateID(Integer growthStateID) {
        this.growthStateID = growthStateID;
    }

    public String getGrowthName() {
        return growthName;
    }

    public void setGrowthName(String growthName) {
        this.growthName = growthName;
    }

    public String getPigstyNo() {
        return pigstyNo;
    }

    public void setPigstyNo(String pigstyNo) {
        this.pigstyNo = pigstyNo;
    }

    public String getHhogcoteNo() {
        return hhogcoteNo;
    }

    public void setHhogcoteNo(String hhogcoteNo) {
        this.hhogcoteNo = hhogcoteNo;
    }
}
