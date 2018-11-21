package cn.bluedot.core.bo;

import java.util.Date;

/**
 *
 * @author 余聪
 * @time:2018年11月11日下午12:51:01
 *
 */
public class SensorDataBo {
	private Integer equipmentDataID;
	private Integer equipmentID;
	private String ename;
	private String etype;
	private Integer pigstyID;
	private Integer hogcoteID;
	private Double data;
	private Date time;
	@Override
	public String toString() {
		return "SensorDataBo [equipmentDataID=" + equipmentDataID
				+ ", equipmentID=" + equipmentID + ", ename=" + ename
				+ ", etype=" + etype + ", pigstyID=" + pigstyID
				+ ", hogcoteID=" + hogcoteID + ", data=" + data + ", time="
				+ time + "]";
	}

	public Integer getEquipmentDataID() {
		return equipmentDataID;
	}

	public void setEquipmentDataID(Integer equipmentDataID) {
		this.equipmentDataID = equipmentDataID;
	}

	public Integer getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(Integer equipmentID) {
		this.equipmentID = equipmentID;
	}

	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEtype() {
		return etype;
	}
	public void setEtype(String etype) {
		this.etype = etype;
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

	public String getData() {
		
		switch(ename){
			case "温度传感器":
				return data+"℃";
			case "湿度传感器":
				return data+"%";
			case "氨气传感器":
				return data+"ml/m3";
		}
		return data+"";
	}

	public void setData(Double data) {
		this.data = data;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
//    viewmap.put("ename", "设备名称");
//    viewmap.put("etype", "设备类型");
//    viewmap.put("pigstyID", "猪舍ID");
//    viewmap.put("hogcoteID", "猪栏ID");
//    viewmap.put("data", "采集数据");
//    viewmap.put("time", "采集时间");
}
