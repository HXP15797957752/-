package cn.bluedot.core.service;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cn.bluedot.core.domain.EquipmentRecord;
import cn.bluedot.core.domain.SowFen;
import net.sf.json.JSONArray;

/** 
* @author 作者 zg
* @version 创建时间：2018年11月12日 下午8:53:59 
*/
public class EquipmentRecordService implements Service{
	
	 private void initSetEquipmentRecord(Map<String, Object> viewmap) {
		  viewmap.put("equipmentRecordID","设备库存记录ID");
	        viewmap.put("equipmentID","设备ID");
	        viewmap.put("effectiveDate","有效日期");
	        viewmap.put("createDate","生产日期");
	        viewmap.put("price","采购价格");
	        viewmap.put("useState","使用状态");    
	    }
	 
	  private String setEquipmentRecord(Map<String, Object[]> sowStartard){
	        Map<String, Object> viewmap =new LinkedHashMap<>();	            
	        initSetEquipmentRecord(viewmap);
	        
	        return equipmentRecord(EquipmentRecord.class, viewmap);
	    }
	    
	
	     public String equipmentRecord(Class clazz,Map<String,Object> viewmap) {
	    	 List  vos = new LinkedList<>() ;
	    	  
	    	// 根据map字段参数生成PigType查询条件
	 	//	PigType pigType = MyBeanUtils.toBean(viewmap, PigType.class);
	 		
	 		// hql语句
	 		String hql = "EquipmentRecord";
	 		
	 		// 查询结果
	 		try {
	 		
	 		 vos.addAll(superDao.HQLQuery(hql, null));
	 		}catch(Exception e) {
	 			e.printStackTrace();
	 		}
	 		List<Map> vot = new LinkedList<>() ;
	        vot.add(viewmap);
	        List vo = new LinkedList<>();
	        vo.add(vot);
	        vo.add(vos);
	 		System.out.println(vo);
	 		
	 		
	 		// 转化为json
	 		JSONArray View = JSONArray.fromObject(vo);
	 		
	 		// 以字符串形式返回给控制层
	 		return "a^"+View.toString();
	     }
    

}
