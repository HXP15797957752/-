package cn.bluedot.core.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;


import cn.bluedot.core.bo.EquipmentExceptionBo;
import cn.bluedot.core.bo.SensorDataBo;
import cn.bluedot.core.domain.Equipment;
import cn.bluedot.core.domain.Threshold;
import cn.bluedot.framemarker.dao.SuperDao;
import net.sf.json.JSONArray;

/**
 *
 * @author 余聪
 * @time:2018年9月12日上午10:35:44
 *
 */
public class EquipmentManageService extends RequestWare implements Service{
	private SuperDao sd = new SuperDao();
	/*
	 * 设备运行控制，map里包含具体定位到哪个设备的信息
	 * 以及该设备的运行状态，关闭（0）、启动（1）、重启（2）
	 * 然后将该map转成String并返回
	 */
//	@Test
//	public void test1(){
//		Map<String, String[]> map = new HashMap<String, String[]>();
//		String[] start = {"0"};
//		String[] num = {"3"};
//		map.put("start", start);
//		map.put("num", num);
//		String result = queryEquipmentState(map);
//		System.out.println("@@@@"+result);
//	}
	
//	@Test
//	public void test2(){
//		System.out.println("########");
//		Map<String, String[]> map = new HashMap<String, String[]>();
//		map.put("equipmentID", new String[]{"1"});
//		map.put("workState", new String[]{"1"});
//		changeEquipmentState(map);
//	}

	/*
	 * 修改设备运行状态，map包含设备ID,需要改变的状态，workState:关闭（0）、启动（1）、重启（2）
	 */
	public void changeEquipmentState(Map<String, String[]> map){
		String equipmentID = map.get("equipmentID")[0];
//		Integer workState = (Integer) map.get("workState");
		Integer workState = Integer.parseInt(map.get("workState")[0]);
		List list = sd.HQLQuery("Equipment|equipmentID=?",equipmentID);
		Equipment eq = (Equipment) list.get(0);
		if(workState == null){
			workState = (eq.getWorkState()+1)%2;
		}
		eq.setWorkState(workState);
		sd.update(eq);
		System.out.println("##");
		
		HttpServletResponse response = (HttpServletResponse) req_rep.get("response");
		try {
			response.getWriter().print(workState);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 查询设备状态
	 */
	public String queryEquipmentState(Map<String, String[]> map){
		
		Integer start = Integer.parseInt(map.get("start")[0]);
		Integer num = Integer.parseInt(map.get("num")[0]);
//		Integer start = 0;
//		Integer num = 3;
        Map<String, Object> viewmap =new LinkedHashMap<>();
        
        initEquipmentHead(viewmap);
//        String result = toJSON(Equipment.class, viewmap, start, num);
//		result = result.replaceAll("\"workState\":0", "\"workState\":关闭");
//		result = result.replaceAll("\"workState\":1", "\"workState\":启动");
//        String s1 = toJSON(Equipment.class, viewmap, start, num);
//        String s2 = toJSON(Equipment.class, viewmap, start, num).replaceAll("\"workState\":0", "\"workState\":关闭").replaceAll("\"workState\":0", "\"workState\":关闭");
//        System.out.println("1##"+s1);
//        System.out.println("2##"+s2);
        return toJSON(Equipment.class, viewmap, start, num).replaceAll("\"workState\":0", "\"workState\":\"关闭\"").replaceAll("\"workState\":1", "\"workState\":\"启动\"");
	}
    
//	@Test
//	public void testa(){
//		System.out.println(toJSON(Equipment.class, null, 0, 3));
//	}
	/*
	 * 将表头viewmap和记录转换成JSON，从第start条记录开始，取num条。start从0开始，当start=null时，默认为0。
	 */
    private String toJSON(Class clazz, Map viewmap, Integer start, Integer num){
    	String className = clazz.getName();
    	className = className.substring(className.lastIndexOf(".")+1);
    	System.out.println("98:tojson"+":"+start+":"+num);
    	LinkedList<Object> vos = new LinkedList<>() ;
        try {
        	if(start == null){
        		vos.addAll(sd.HQLQuery(className+"|limit ?,?",0,num));
        	}else{
        		vos.addAll(sd.HQLQuery(className+"|limit ?,?",start,num));
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        List<Map> vot = new LinkedList<>() ;
        vot.add(viewmap);
             
        List vo = new LinkedList<>();
        vo.add(vot);
        vo.add(vos);
        
        JSONArray View = JSONArray.fromObject(vo);
        System.out.println(View.toString());
        return "a^"+View.toString();
    }
    
    /*
     * 初始化设备状态信息头
     */
    private void initEquipmentHead(Map<String, Object> viewmap){
        viewmap.put("equipmentID", "设备ID");
        viewmap.put("pigstyID", "猪舍ID");
        viewmap.put("hogcoteID", "猪栏ID");
        viewmap.put("etype", "设备类型");
        viewmap.put("ename", "设备名称");
        viewmap.put("workState", "工作状态");
    }

    private void initSensorDataHead(Map<String, Object> viewmap){
        viewmap.put("ename", "设备名称");
        viewmap.put("etype", "设备类型");
        viewmap.put("pigstyID", "猪舍ID");
        viewmap.put("hogcoteID", "猪栏ID");
        viewmap.put("data", "采集数据");
        viewmap.put("time", "采集时间");
    }
    private void initThresholdHead(Map<String, Object> viewmap){
    	viewmap.put("piggeryNo", "猪舍ID");
    	viewmap.put("controlType", "环控类型");
        viewmap.put("minThreshold", "最小阈值");
        viewmap.put("maxThreshold", "最大阈值");
    }
    private void initExceptionHead(Map<String, Object> viewmap){
    	viewmap.put("equipmentID", "设备ID");
    	viewmap.put("pigstyID", "猪舍ID");
    	viewmap.put("hogcoteID", "猪栏ID");
    	viewmap.put("etype", "设备类型");
        viewmap.put("ename", "设备名称");
        viewmap.put("processingMethod", "处理方式");
        viewmap.put("time", "异常时间");
        viewmap.put("processUserNo", "处理人");
    }
    public String queryThreshold(Map<String, String[]> map){
    	Integer start = Integer.parseInt(map.get("start")[0]);
		Integer num = Integer.parseInt(map.get("num")[0]);
        Map<String, Object> viewmap =new LinkedHashMap<>();
        
        initThresholdHead(viewmap);
        return toJSON(Threshold.class, viewmap, start, num);
    }
    public String queryException(Map<String, String[]> map){
    	Integer start = Integer.parseInt(map.get("start")[0]);
		Integer num = Integer.parseInt(map.get("num")[0]);
//		Integer start = 0;
//		Integer num = 3;
        Map<String, Object> viewmap =new LinkedHashMap<>();
        
        initExceptionHead(viewmap);
//        String result = toJSON(Equipment.class, viewmap, start, num);
//		result = result.replaceAll("\"workState\":0", "\"workState\":关闭");
//		result = result.replaceAll("\"workState\":1", "\"workState\":启动");
//        String s1 = toJSON(Equipment.class, viewmap, start, num);
//        String s2 = toJSON(Equipment.class, viewmap, start, num).replaceAll("\"workState\":0", "\"workState\":关闭").replaceAll("\"workState\":0", "\"workState\":关闭");
//        System.out.println("1##"+s1);
//        System.out.println("2##"+s2);
        return toJSON(EquipmentExceptionBo.class, viewmap, start, num);
    }
	/*
	 * 查询传感器采集数据，条件以map传入，结果集转换成String并返回
	 */
	public String querySensorData(Map<String, String[]> map){
		Integer start = Integer.parseInt(map.get("start")[0]);
		Integer num = Integer.parseInt(map.get("num")[0]);
//		Integer start = 0;
//		Integer num = 3;
        Map<String, Object> viewmap =new LinkedHashMap<>();
        
        initSensorDataHead(viewmap);
//        String result = toJSON(Equipment.class, viewmap, start, num);
//		result = result.replaceAll("\"workState\":0", "\"workState\":关闭");
//		result = result.replaceAll("\"workState\":1", "\"workState\":启动");
//        String s1 = toJSON(Equipment.class, viewmap, start, num);
//        String s2 = toJSON(Equipment.class, viewmap, start, num).replaceAll("\"workState\":0", "\"workState\":关闭").replaceAll("\"workState\":0", "\"workState\":关闭");
//        System.out.println("1##"+s1);
//        System.out.println("2##"+s2);
        return toJSON(SensorDataBo.class, viewmap, start, num);
	}
//	@Test
//	public void test3(){
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("equipmentID", "1");
//		map.put("timeInterval", "5");
//		setCollectTime(map);
//	}
	/*
	 * 设置传感器采集时间间隔，条件以map传入,里面包含设备ID以及采集间隔时间
	 */
	public void setCollectTime(Map map){
		String equipmentID = (String)map.get("equipmentID");
		Integer timeInterval = Integer.parseInt((String)map.get("timeInterval"));
		List list = sd.HQLQuery("Equipment|equipmentID=?",equipmentID);
		Equipment eq = (Equipment) list.get(0);
		if(timeInterval == null){
			timeInterval = 5;
		}
		eq.setTimeInterval(timeInterval);
		sd.update(eq);
		HttpServletResponse response = (HttpServletResponse) req_rep.get("response");
		try {
			response.getWriter().print(timeInterval);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void test4(){
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("equipmentID", "1");
//		map.put("isAutoHandle", "0");
//		setAutoHandleException(map);
//	}
	/*
	 * 设置传感器是否自动进行异常处理，map中包含设备ID以及是否自动处理异常isAutoHandle，0为否，1为是
	 */
	public void setAutoHandleException(Map map){
		String equipmentID = (String)map.get("equipmentID");
		Integer isAutoHandle = Integer.parseInt((String) map.get("isAutoHandle"));
		if(isAutoHandle == null){
			isAutoHandle = 0;
		}
		List list = sd.HQLQuery("Equipment|equipmentID=?",equipmentID);
		Equipment eq = (Equipment) list.get(0);
		eq.setIsAutoHandle(isAutoHandle);
		sd.update(eq);
		HttpServletResponse response = (HttpServletResponse) req_rep.get("response");
		try {
			response.getWriter().print(isAutoHandle);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void test5(){
		Map map = new HashMap<String,Object>();
//		map.put("thresholdID", "1");
		map.put("piggeryNo", "1");
		map.put("controlType", "光照强度");
		map.put("minThreshold", "100");
		map.put("maxThreshold", "20");
		setThreshold(map);
	}
	
	/*
	 * 设置环控设备阈值，包含猪舍ID，环控类型，阈值最小值（默认0）、最大值。
	 */
	public void setThreshold(Map map){
		System.out.println(111111111);
		String thresholdID = (String)map.get("thresholdID");
		String piggeryNo = (String)map.get("piggeryNo");
		String controlType = (String)map.get("controlType");
		String min = (String)map.get("minThreshold");
		String max = (String)map.get("maxThreshold");
		if(min == null){
			min = "0";
		}
		if(max == null){
			max = "0";
		}
		Double minThreshold = Double.parseDouble(min);
		Double maxThreshold = Double.parseDouble(max);
		Threshold ts = new Threshold();
		if(thresholdID!=null){
			ts = (Threshold) sd.HQLQuery("Threshold|thresholdID=?",Integer.parseInt(thresholdID)).get(0);
			if(ts != null){
				ts.setMinThreshold(minThreshold);
				ts.setMaxThreshold(maxThreshold);
				sd.update(ts);
				return;
			}
		}
		List list = sd.HQLQuery("Threshold|piggeryNo=?,controlType=?",piggeryNo,controlType);
		try {
			if(list.size()>0){
				Threshold tsTemp = (Threshold) list.get(0);
				tsTemp.setMinThreshold(minThreshold);
				tsTemp.setMaxThreshold(maxThreshold);
				sd.update(tsTemp);
			}else{
				ts.setPiggeryNo(piggeryNo);
				ts.setControlType(controlType);
				ts.setMinThreshold(minThreshold);
				ts.setMaxThreshold(maxThreshold);		
				sd.save(ts);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		HttpServletResponse response = (HttpServletResponse) req_rep.get("response");
//		try {
//			response.getWriter().print(minThreshold+"&&"+maxThreshold);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
//	@Test
//	public void test6(){
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("equipmentID", "1");
//		map.put("isAutoControl", "1");
//		setAutoControlEnvironment(map);
//	}
	/*
	 * 设置环控设备是否自动控制环境，map中包含设备ID以及是否自动处理异常isAutoControl，0为否，1为是
	 */
	public void setAutoControlEnvironment(Map map){
		String equipmentID = (String)map.get("equipmentID");
		Integer isAutoControl = Integer.parseInt((String) map.get("isAutoControl"));
		if(isAutoControl == null){
			isAutoControl = 0;
		}
		List list = sd.HQLQuery("Equipment|equipmentID=?",equipmentID);
		Equipment eq = (Equipment) list.get(0);
		eq.setIsAutoControl(isAutoControl);
		sd.update(eq);
		HttpServletResponse response = (HttpServletResponse) req_rep.get("response");
		try {
			response.getWriter().print(isAutoControl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 设置是否自动进行传感器异常处理，条件以map传入，结果返回true或false
	 */
	public boolean isAutoHandleSensor(Map map){
		return false;
	}
	
	/*
	 * 设置环控设备的阈值,条件以map传入，结果返回成功或者失败
	 */
	public boolean setRange(Map map){
		return false;
	}
	
	/*
	 * 设置是否自动控制环控设备的运行状态，条件以map传入，结果返回成功或者失败
	 */
	public boolean isAutoHandleDivice(Map map){
		return false;
	}
	
	/*
	 * 查询传感器异常信息，条件以map传入，结果集转成String并返回
	 */
	public String querySensorExceptionInfo(Map map){
		return null;
	}
	
	/*
	 * 查询环控设备异常信息，条件以map传入，结果集转成String并返回
	 */
	public String queryDiviceExceptionInfo(Map map){
		return null;
	}
	
	/*
	 * 查询监控设备异常信息，条件以map传入，结果集转成String并返回
	 */
	public String queryMonitorExceptionInfo(Map map){
		return null;
	}
	
	/*
	 * 查询饲喂设备异常信息，条件以map传入，结果集转成String并返回
	 */
	public String queryFeedExceptionInfo(Map map){
		return null;
	}
//	public static void main(String[] args) {
//		String hql = "Equipment||limit ?,?";
//		List<Object> list = new SuperDao().HQLQuery(hql, 0, 3);
//		System.out.println(list.size());
//	}
}
