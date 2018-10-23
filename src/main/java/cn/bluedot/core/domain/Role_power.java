package cn.bluedot.core.domain;
public class Role_power{
    /** */
    private Integer ID;
    /** */
    private Integer roleID;
    /** */
    private Integer powerID;
    public void setID(Integer ID){
        this.ID = ID;
    }
    public Integer getID(){
        return this.ID;
    }
    public void setRoleID(Integer roleID){
        this.roleID = roleID;
    }
    public Integer getRoleID(){
        return this.roleID;
    }
    public void setPowerID(Integer powerID){
        this.powerID = powerID;
    }
    public Integer getPowerID(){
        return this.powerID;
    }
}