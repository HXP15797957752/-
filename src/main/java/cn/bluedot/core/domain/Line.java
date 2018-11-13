package cn.bluedot.core.domain;

import java.util.List;
/**
 * @author : 游斌平
 *
 */
public class Line {
	String[] xcontent ;
	List<JsonData> data;
	public String[] getXcontent() {
		return xcontent;
	}
	public void setXcontent(String[] xcontent) {
		this.xcontent = xcontent;
	}
	public List<JsonData> getData() {
		return data;
	}
	public void setData(List<JsonData> data) {
		this.data = data;
	}
	
}