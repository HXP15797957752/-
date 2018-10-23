package cn.bluedot.core.domain;
public class Hogcote{
    /** */
    private String hogcoteNo;
    /** */
    private Integer upperLimit;
    /** */
    private java.math.BigDecimal area;
    /** */
    private Integer curPigNumber;
    /** */
    private String pigstyNo;
    public void setHogcoteNo(String hogcoteNo){
        this.hogcoteNo = hogcoteNo;
    }
    public String getHogcoteNo(){
        return this.hogcoteNo;
    }
    public void setUpperLimit(Integer upperLimit){
        this.upperLimit = upperLimit;
    }
    public Integer getUpperLimit(){
        return this.upperLimit;
    }
    public void setArea(java.math.BigDecimal area){
        this.area = area;
    }
    public java.math.BigDecimal getArea(){
        return this.area;
    }
    public void setCurPigNumber(Integer curPigNumber){
        this.curPigNumber = curPigNumber;
    }
    public Integer getCurPigNumber(){
        return this.curPigNumber;
    }
    public void setPigstyNo(String pigstyNo){
        this.pigstyNo = pigstyNo;
    }
    public String getPigstyNo(){
        return this.pigstyNo;
    }
}