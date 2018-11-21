package cn.bluedot.core.domain;

import java.util.Date;

/**
 * @author : 游斌平
 *
 */
public class WeightBar {
	private String date;
	private Double weight;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "WeightBar [date=" + date + ", weight=" + weight + "]";
	}
	
}
