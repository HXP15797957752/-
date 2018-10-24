package cn.bluedot.core.domain;
public class EquipmentData{
    /** */
    private Integer equipmentDataID;
    /** */
    private String data;
    /** */
    private Integer equipmentID;
    /**数据接受时间*/
    private java.util.Date time;
    public void setEquipmentDataID(Integer equipmentDataID){
        this.equipmentDataID = equipmentDataID;
    }
    public Integer getEquipmentDataID(){
        return this.equipmentDataID;
    }
    public void setData(String data){
        this.data = data;
    }
    public String getData(){
        return this.data;
    }
    public void setEquipmentID(Integer equipmentID){
        this.equipmentID = equipmentID;
    }
    public Integer getEquipmentID(){
        return this.equipmentID;
    }
    public void setTime(java.util.Date time){
        this.time = time;
    }
    public java.util.Date getTime(){
        return this.time;
    }
}