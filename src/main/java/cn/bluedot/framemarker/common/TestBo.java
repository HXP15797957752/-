package cn.bluedot.framemarker.common;

import java.util.List;

public class TestBo implements BoSuper{
    private Integer userid;
    private String username;
    private String sex;
    private Integer roleid;
    public Integer getRoleid() {
        return roleid;
    }
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
    private String roleName;
    private List<Book> bookes;
    private String className;
    private Integer classID;
    
    public Integer getClassID() {
        return classID;
    }
    public void setClassID(Integer classID) {
        this.classID = classID;
    }
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public List<Book> getBooks() {
        return bookes;
    }
    public void setBookes(List<Book> bookes) {
        this.bookes = bookes;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    @Override
    public String toString() {
        return "TestBo [userid=" + userid + ", username=" + username + ", sex=" + sex + ", roleid=" + roleid
                + ", roleName=" + roleName + ", bookes=" + bookes + ", className=" + className + ", classID=" + classID
                + "]";
    }
    
}
