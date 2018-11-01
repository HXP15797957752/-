package cn.bluedot.core.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.bluedot.core.domain.Gathering;
import cn.bluedot.core.domain.Payment;
import cn.bluedot.core.util.MyBeanUtils;

/**
 * @author : 游斌平
 *
 */
public class GetService implements Service{
	/**
	 * R2V0U2VydmljZTppbnNlcnRHZXRJbmZvcm1hdGlvbg==
	 * 插入收入
	 * @param data
	 * @return
	 */
	public String insertGetInformation(Map data) {
		Gathering gathering = MyBeanUtils.toBean(data, Gathering.class); 
		try {
			superDao.save(gathering);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "a^插入成功";
	}
	/**
	 * R2V0U2VydmljZTpkZWxldGVHZXRJbmZvcm1tYXRpb24=
	 * 删除收入
	 * @param data :传输过来的边界类的数据
	 * @return  执行情况，代表转发页面、数据
	 */
	public String deleteGetInformmation(Map data) {
		Gathering gathering = MyBeanUtils.toBean(data, Gathering.class);
		try {
			superDao.delete(gathering);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "a^删除成功";
	}
	/**
	 * R2V0U2VydmljZTp1cGRhdGVHZXRJbmZvcm1hdGlvbg==
	 * 更新收入
	 * @param data:传输过来的边界类的数据
	 * @return  :执行情况，代表转发页面、数据
	 */
	public String updateGetInformation(Map data) {
		Gathering gathering = MyBeanUtils.toBean(data, Gathering.class);
		superDao.update(gathering);
		return "a^更新成功";
	}
	/**
	 * 查找收入
     * @param data:传输过来的边界类的数据
	 * @return  :执行情况，代表转发页面、数据
	 */
	public String searchGetInformation(Map<String, String[]> data) {
		Gathering gathering = MyBeanUtils.toBean(data, Gathering.class);
		String hql = "Gathering|gatheringID=?";
		List<Object> gatherings = superDao.HQLQuery(hql, gathering.getGatheringID());
		System.out.println(gatherings.toString());
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
}
