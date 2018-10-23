package cn.bluedot.core.domain;
public class Piggery{
    /**猪场编号*/
    private String piggeryNo;
    /** */
    private String name;
    /** */
    private String description;
    public void setPiggeryNo(String piggeryNo){
        this.piggeryNo = piggeryNo;
    }
    public String getPiggeryNo(){
        return this.piggeryNo;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
}