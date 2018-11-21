package cn.bluedot.core.service;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cn.bluedot.core.domain.Gathering;
import cn.bluedot.core.domain.Payment;
import cn.bluedot.core.util.MyBeanUtils;
import net.sf.json.JSONArray;

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
	 * R2V0U2VydmljZTpzZWFyY2hHZXRJbmZvcm1hdGlvbg==
	 * 查找收入
     * @param data:传输过来的边界类的数据
	 * @return  :执行情况，代表转发页面、数据
	 */
	public String searchGetInformation(Map<String, String[]> data) {
		Map<String, Object> viewmap = new LinkedHashMap<>();
		initGathering(viewmap);
		Gathering gathering = MyBeanUtils.toBean(data, Gathering.class);
		String hql = "Gathering";
		List<Object> vos = superDao.HQLQuery(hql, gathering.getGatheringID());
		List<Map> vot = new LinkedList<>() ;
        vot.add(viewmap);
             
        List vo = new LinkedList<>();
        vo.add(vot);
        vo.add(vos);
        JSONArray View = JSONArray.fromObject(vo);
        return "a^"+View.toString();
	}
	/**
	 * 收款视图
	 * @param viewmap
	 */
	private void initGathering(Map<String, Object> viewmap) {
        viewmap.put("gatheringID", "收款单号");
        viewmap.put("gatheringType", "收款类型");
        viewmap.put("money", "金额");
        viewmap.put("gatherReason", "收款的流水号");
        viewmap.put("serialNumber", "物品订单号");
        viewmap.put("orderNumber", "付款原因");
        viewmap.put("payer", "付款人员");
        viewmap.put("receiver", "收款人员");
        viewmap.put("gatherDate", "收款时间");
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
