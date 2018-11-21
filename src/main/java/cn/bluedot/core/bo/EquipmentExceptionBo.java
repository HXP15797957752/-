package cn.bluedot.core.bo;

import java.util.Date;

/**
 *
 * @author 余聪
 * @time:2018年11月11日下午6:19:07
 *
 */
public class EquipmentExceptionBo {
	private Integer exceptionID;
	private Integer equipmentID;
	private Integer pigstyID;
	private Integer hogcoteID;
	private String etype;
	private String ename;
	private String processingMethod;
	private Date time;
	private String processUserNo;
	public Integer getExceptionID() {
		return exceptionID;
	}
	public void setExceptionID(Integer exceptionID) {
		this.exceptionID = exceptionID;
	}
	
	public Integer getEquipmentID() {
		return equipmentID;
	}
	public void setEquipmentID(Integer equipmentID) {
		this.equipmentID = equipmentID;
	}
	public Integer getPigstyID() {
		return pigstyID;
	}
	public void setPigstyID(Integer pigstyID) {
		this.pigstyID = pigstyID;
	}
	public Integer getHogcoteID() {
		return hogcoteID;
	}
	public void setHogcoteID(Integer hogcoteID) {
		this.hogcoteID = hogcoteID;
	}
	public String getEtype() {
		return etype;
	}
	public void setEtype(String etype) {
		this.etype = etype;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getProcessingMethod() {
		return processingMethod;
	}
	public void setProcessingMethod(String processingMethod) {
		this.processingMethod = processingMethod;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getProcessUserNo() {
		return processUserNo;
	}
	public void setProcessUserNo(String processUserNo) {
		this.processUserNo = processUserNo;
	}
	@Override
	public String toString() {
		return "EquipmentExceptionBo [exceptionID=" + exceptionID
				+ ", pigstyID=" + pigstyID + ", hogcoteID=" + hogcoteID
				+ ", etype=" + etype + ", ename=" + ename
				+ ", processingMethod=" + processingMethod + ", time=" + time
				+ ", processUserNo=" + processUserNo + "]";
	}
	
//    viewmap.put("equipmentID", "设备ID");
//	viewmap.put("pigstyID", "猪舍ID");
//	viewmap.put("hogcoteID", "猪栏ID");
//	viewmap.put("etype", "设备类型");
//    viewmap.put("ename", "设备名称");
//    viewmap.put("processingMethod", "处理方式");
//    viewmap.put("time", "异常时间");
//    viewmap.put("processUserNo", "处理人");
}
