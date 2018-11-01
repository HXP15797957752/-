package cn.bluedot.framemarker.common;

public class User {
    private Integer id;
    private String name;
    private String sex;
    private Integer classesid;
    private Integer roleid;
    
    
    public Integer getClassesid() {
        return classesid;
    }
    public void setClassesid(Integer classesid) {
        this.classesid = classesid;
    }
    public Integer getRoleid() {
        return roleid;
    }
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
}
