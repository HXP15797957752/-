package cn.bluedot.core.domain;

/**
 * @author : 游斌平
 *
 */
public class DataShow {
	private String type;
	private float money;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "DataShow [type=" + type + ", money=" + money + "]";
	}
	 
}
