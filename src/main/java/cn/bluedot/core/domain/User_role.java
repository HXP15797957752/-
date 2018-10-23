package cn.bluedot.core.domain;
public class User_role{
    /** */
    private Integer ID;
    /** */
    private String userNo;
    /** */
    private Integer roleID;
    public void setID(Integer ID){
        this.ID = ID;
    }
    public Integer getID(){
        return this.ID;
    }
    public void setUserNo(String userNo){
        this.userNo = userNo;
    }
    public String getUserNo(){
        return this.userNo;
    }
    public void setRoleID(Integer roleID){
        this.roleID = roleID;
    }
    public Integer getRoleID(){
        return this.roleID;
    }
}