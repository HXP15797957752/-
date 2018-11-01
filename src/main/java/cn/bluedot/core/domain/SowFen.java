package cn.bluedot.core.domain;
/** 
* @author 作者 zg
* @version 创建时间：2018年10月28日 下午3:08:55 
*/

/*
 * 母猪分娩管理
 */
public class SowFen {
	

	/*
	 * 母猪耳号
	 */
	private String sowNo;
	
	/*
	 * 分娩时期
	 */
	private String fenDate;
	
	/*
	 * 所在猪舍
	 */
	private String pigstyNo;
	
	/*
	 * 所在猪栏
	 */
	private String hogcoteNo;
	
	/*
	 * 母猪分娩状态
	 */
	private String state;
	
	/*
	 * 分娩了多少小时
	 */
	private String fendate;
	
	/*
	 * 产仔数量
	 */
	private String number;
	
	/*
	 * 仔健康数量
	 */
	private String healthpig;
	
	/*
	 * 不健康仔数量
	 */
	private String nhealthpig;

	public String getSowNo() {
		return sowNo;
	}

	public void setSowNo(String sowNo) {
		this.sowNo = sowNo;
	}

	public String getFenDate() {
		return fenDate;
	}

	public void setFenDate(String fenDate) {
		this.fenDate = fenDate;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFendate() {
		return fendate;
	}

	public void setFendate(String fendate) {
		this.fendate = fendate;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getHealthpig() {
		return healthpig;
	}

	public void setHealthpig(String healthpig) {
		this.healthpig = healthpig;
	}

	public String getNhealthpig() {
		return nhealthpig;
	}

	public void setNhealthpig(String nhealthpig) {
		this.nhealthpig = nhealthpig;
	}
	
	

}
