package cn.bluedot.core.domain;

/**
 * @author wangxin;
 *
 */
public class AddWeight{
    //
    private Integer id;

    //
    private String pig_No;

    //
    private Double weight;

    //
    private String date;

    //
    private Integer isException;
    //
    private Integer growthStateId;
    
    private Integer pigtypeId;
    
    private Integer sex;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPig_No() {
		return pig_No;
	}

	public void setPig_No(String pig_No) {
		this.pig_No = pig_No;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getIsException() {
		return isException;
	}

	public void setIsException(Integer isException) {
		this.isException = isException;
	}

	public Integer getGrowthStateId() {
		return growthStateId;
	}

	public void setGrowthStateId(Integer growthStateId) {
		this.growthStateId = growthStateId;
	}

	public Integer getPigtypeId() {
		return pigtypeId;
	}

	public void setPigtypeId(Integer pigtypeId) {
		this.pigtypeId = pigtypeId;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "AddWeight [id=" + id + ", pig_No=" + pig_No + ", weight=" + weight + ", date=" + date + ", isException="
				+ isException + ", growthStateId=" + growthStateId + ", pigtypeId=" + pigtypeId + ", sex=" + sex + "]";
	}

    
    
}