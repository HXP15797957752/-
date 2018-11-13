package cn.bluedot.core.domain;

/**
 * @author wangxin;
 *
 */
public class AddWeight{
    //
    private int id;

    //
    private String pig_No;

    //
    private double weight;

    //
    private String date;

    //
    private int isException;
    //
    private int growthStateId;
    
    private int pigtypeId;
    
    private int sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPig_No() {
        return pig_No;
    }

    public void setPig_No(String pig_No) {
        this.pig_No = pig_No;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIsException() {
        return isException;
    }

    public void setIsException(int isException) {
        this.isException = isException;
    }

    public int getGrowthStateId() {
        return growthStateId;
    }

    public void setGrowthStateId(int growthStateId) {
        this.growthStateId = growthStateId;
    }

    public int getPigtypeId() {
        return pigtypeId;
    }

    public void setPigtypeId(int pigtypeId) {
        this.pigtypeId = pigtypeId;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
    
    
}