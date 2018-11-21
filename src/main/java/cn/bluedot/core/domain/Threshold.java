package cn.bluedot.core.domain;
/**
 *
 * @author 余聪
 * @time:2018年10月28日下午3:22:50
 *
 */
public class Threshold {
	private Integer thresholdID;
	private String piggeryNo;
	private String controlType;
	private Double minThreshold;
	private Double maxThreshold;
	public Integer getThresholdID() {
		return thresholdID;
	}
	public void setThresholdID(Integer thresholdID) {
		this.thresholdID = thresholdID;
	}
	public String getPiggeryNo() {
		return piggeryNo;
	}
	public void setPiggeryNo(String piggeryNo) {
		this.piggeryNo = piggeryNo;
	}
	public String getControlType() {
		return controlType;
	}
	public void setControlType(String controlType) {
		this.controlType = controlType;
	}
	public String getMinThreshold() {
		switch(controlType){
			case "温度":
				return minThreshold+"℃";
			case "湿度":
			case "CO2":
				return minThreshold+"%";
			case "SO2":
			case "氨气":
				return minThreshold+"ml/m3";
			case "噪声":
				return minThreshold+"dB";
			case "光照强度":
				return minThreshold+"LUX";
		}
		return null;
	}
	public void setMinThreshold(Double minThreshold) {
		this.minThreshold = minThreshold;
	}
	public String getMaxThreshold() {
		switch(controlType){
		case "温度":
			return maxThreshold+"℃";
		case "湿度":
		case "CO2":
			return maxThreshold+"%";
		case "SO2":
		case "氨气":
			return maxThreshold+"ml/m3";
		case "噪声":
			return maxThreshold+"dB";
		case "光照强度":
			return minThreshold+"LUX";
		}
		return null;
	}
	public void setMaxThreshold(Double maxThreshold) {
		this.maxThreshold = maxThreshold;
	}
	
}
