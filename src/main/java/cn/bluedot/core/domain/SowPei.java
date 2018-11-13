package cn.bluedot.core.domain;
/** 
* @author 作者 zg
* @version 创建时间：2018年10月28日 上午10:58:32 
*/
public class SowPei {
   /*
    * 母猪耳号
    */
	private String sowNo;
	
	/*
	 * 母猪授精时间
	 */
	private String semenDate;
	
	/*
	 * 母猪所在猪舍编号
	 */
	private String pigstyNo;
	
	/*
	 * 母猪所在猪栏编号
	 */
	private String hogcoteNo;
	
	/*
	 * 配种公主耳号
	 */
	private String boarNo;
	
	/*
	 * 母猪授精方式
	 */
	private String method;

	public String getSowNo() {
		return sowNo;
	}

	public void setSowNo(String sowNo) {
		this.sowNo = sowNo;
	}

	public String getSemenDate() {
		return semenDate;
	}

	public void setSemenDate(String semenDate) {
		this.semenDate = semenDate;
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

	public String getBoarNo() {
		return boarNo;
	}

	public void setBoarNo(String boarNo) {
		this.boarNo = boarNo;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	
}
