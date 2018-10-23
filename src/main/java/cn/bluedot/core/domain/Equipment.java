package cn.bluedot.core.domain;
public class Equipment{
    /** */
    private Integer equipmentID;
    /** */
    private String ename;
    /** */
    private String etype;
    /** */
    private Integer workState;
    /**猪舍编号*/
    private String pigstyNo;
    /**猪栏编号*/
    private String hogcoteNo;
    /**传感器收集数据时间间隔,*/
    private Integer timeInterval;
    /**环控设备类型,温度,湿度...*/
    private String controlType;
    /**环控设备阈值*/
    private String controlThreshold;
    public void setEquipmentID(Integer equipmentID){
        this.equipmentID = equipmentID;
    }
    public Integer getEquipmentID(){
        return this.equipmentID;
    }
    public void setEname(String ename){
        this.ename = ename;
    }
    public String getEname(){
        return this.ename;
    }
    public void setEtype(String etype){
        this.etype = etype;
    }
    public String getEtype(){
        return this.etype;
    }
    public void setWorkState(Integer workState){
        this.workState = workState;
    }
    public Integer getWorkState(){
        return this.workState;
    }
    public void setPigstyNo(String pigstyNo){
        this.pigstyNo = pigstyNo;
    }
    public String getPigstyNo(){
        return this.pigstyNo;
    }
    public void setHogcoteNo(String hogcoteNo){
        this.hogcoteNo = hogcoteNo;
    }
    public String getHogcoteNo(){
        return this.hogcoteNo;
    }
    public void setTimeInterval(Integer timeInterval){
        this.timeInterval = timeInterval;
    }
    public Integer getTimeInterval(){
        return this.timeInterval;
    }
    public void setControlType(String controlType){
        this.controlType = controlType;
    }
    public String getControlType(){
        return this.controlType;
    }
    public void setControlThreshold(String controlThreshold){
        this.controlThreshold = controlThreshold;
    }
    public String getControlThreshold(){
        return this.controlThreshold;
    }
}