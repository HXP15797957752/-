package cn.bluedot.core.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.bluedot.core.domain.Payment;
import cn.bluedot.core.util.MyBeanUtils;

/**
 * @author : 游斌平
 *
 */
public class PayService implements Service{
	/**
	 * 插入支付
	 * UGF5U2VydmljZTppbnNlcnRQYXlJbmZvcm1hdGlvbg==
	 * @param data:传输过来的边界类的数据
	 * @return  :执行情况，代表转发页面、数据
	 */
	public String insertPayInformation(Map data) {
		Payment payment = MyBeanUtils.toBean(data, Payment.class);
		try {
			superDao.save(payment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "a^插入成功";
	}
	/**
	 * UGF5U2VydmljZTpkZWxldGVQYXlJbmZvcm1tYXRpb24=
	 * 删除支付
	 * @param data :传输过来的边界类的数据
	 * @return  执行情况，代表转发页面、数据
	 */
	public String deletePayInformmation(Map data) {
		Payment payment = MyBeanUtils.toBean(data, Payment.class);
		try {
			superDao.delete(payment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "a^删除成功";
	}
	/**
	 *UGF5U2VydmljZTp1cGRhdGVQYXlJbmZvcm1hdGlvbg==
	 * 更新支付
	 * @param data:传输过来的边界类的数据
	 * @return  :执行情况，代表转发页面、数据
	 */
	public String updatePayInformation(Map data) {
		Payment payment = MyBeanUtils.toBean(data, Payment.class);
		superDao.update(payment);
		return "a^更新成功";
	}
	/**
	 * 
	 * UGF5U2VydmljZTpzZWFyY2hQYXlJbmZvcm1hdGlvbg==
	 * 查找支付
     * @param data:传输过来的边界类的数据
	 * @return  :执行情况，代表转发页面、数据
	 */
	public String searchPayInformation(Map data) {
		try {
			Payment payment = MyBeanUtils.toBean(data, Payment.class);
			// hql语句
			String hql = "Payment|paymentID=?";
			List<Object> payments= superDao.HQLQuery(hql, 2);
			System.out.println(payments.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
}
