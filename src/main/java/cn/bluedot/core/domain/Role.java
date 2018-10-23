package cn.bluedot.core.domain;
public class Role{
    /** */
    private Integer roleID;
    /** */
    private String roleName;
    /** */
    private String description;
    public void setRoleID(Integer roleID){
        this.roleID = roleID;
    }
    public Integer getRoleID(){
        return this.roleID;
    }
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }
    public String getRoleName(){
        return this.roleName;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
}