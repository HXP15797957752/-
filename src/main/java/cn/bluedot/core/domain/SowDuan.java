package cn.bluedot.core.domain;
/** 
* @author 作者 zg
* @version 创建时间：2018年10月28日 下午2:30:05 
*/

/*
 * 母猪断奶管理
 */

public class SowDuan {
	
	/*
	 * 母猪耳号
	 */
	private String sowNo;
	
	/*
	 * 断奶日期
	 */
	private String duanDate;
	
	/*
	 * 母猪断奶时体重
	 */
   private String duanWeight;
   
   /*
    * 去向猪舍
    */
   private String pigstyNo;
   
   /*
    * 所在猪栏
    */
   private String hogcoteNo;
   
   /*
    * 备注
    */
   private String remark;

public String getSowNo() {
	return sowNo;
}

public void setSowNo(String sowNo) {
	this.sowNo = sowNo;
}

public String getDuanDate() {
	return duanDate;
}

public void setDuanDate(String duanDate) {
	this.duanDate = duanDate;
}

public String getDuanWeight() {
	return duanWeight;
}

public void setDuanWeight(String duanWeight) {
	this.duanWeight = duanWeight;
}

public String getPigstyNo() {
	return pigstyNo;
}

public void setPigstyNo(String pigstyNo) {
	this.pigstyNo = pigstyNo;
}

public String getHogcoteNo() {
	return hogcoteNo;
}

public void setHogcoteNo(String hogcoteNo) {
	this.hogcoteNo = hogcoteNo;
}

public String getRemark() {
	return remark;
}

public void setRemark(String remark) {
	this.remark = remark;
}
   
   
}
