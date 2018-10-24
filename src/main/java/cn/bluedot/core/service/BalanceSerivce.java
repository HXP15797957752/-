package cn.bluedot.core.service;

import java.sql.SQLException;
import java.util.Map;

import cn.bluedot.core.domain.Payment;
import cn.bluedot.core.util.MyBeanUtils;

/**
 * @author : 游斌平
 *
 */
public class BalanceSerivce implements Service{
	/**
	 * 插入收入
	 * @param data
	 * @return
	 */
	public String insertGetInformation(Map data) {
		Payment payment = MyBeanUtils.toBean(data, Payment.class);
		try {
			superDao.save(payment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "a^算法组合成功";
	}
	/**
	 * 删除收入
	 * @param data :传输过来的边界类的数据
	 * @return  执行情况，代表转发页面、数据
	 */
	public String deleteGetInformmation(Map data) {
		return null;
	}
	/**
	 * 更新收入
	 * @param data:传输过来的边界类的数据
	 * @return  :执行情况，代表转发页面、数据
	 */
	public String updateGetInformation(Map<String, String[]> data) {
		return null;
	}
	/**
	 * 查找收入
     * @param data:传输过来的边界类的数据
	 * @return  :执行情况，代表转发页面、数据
	 */
	public String searchGetInformation(Map<String, String[]> data) {
		return null;
	}
	/**
	 *收入数据显示
	 * @param data:传输过来的边界类的数据
	 * @return  :执行情况，代表转发页面、数据
	 */
	public String showPayData(Map<String, String[]> data) {
		return null;
	}
	/**
	 * 导入
	 * @param data:传输过来的边界类的数据
	 * @return  :执行情况，代表转发页面、数据
	 */
	public String toLead(Map<String, String[]> data) {
		return null;
	}
	/**
	 * 导出
	 * @param data:传输过来的边界类的数据
	 * @return  :执行情况，代表转发页面、数据
	 */
	public String export(Map<String, String[]> data) {
		return null;
	}
	/**
	 * 转账
	 * @param data:传输过来的边界类的数据
	 * @return  :执行情况，代表转发页面、数据
	 */
	public String transferAccounts(Map<String, String[]> data) {
		return null;
	}
}
