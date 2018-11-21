package cn.bluedot.core.service;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cn.bluedot.core.domain.DrugRecord;
import cn.bluedot.core.domain.FeedRecord;
import net.sf.json.JSONArray;

/** 
* @author 作者 zg
* @version 创建时间：2018年11月14日 下午7:12:40 
*/
public class DrugRecordService implements Service {
	
	 private void initSetDrugRecord(Map<String, Object> viewmap) {
	        viewmap.put("durgRecordID", "ID");
	        viewmap.put("drugTypeID", "药品种类id");
	        viewmap.put("createTime", "生产日期");
	        viewmap.put("effectiveTime", "有效期");
	        viewmap.put("curNumber", "当前库存量");
	        viewmap.put("unit", "计量单位");
	        viewmap.put("price", "采购价格");
	      
	    }
	  private String setDrugRecord(Map<String, Object[]> sowStartard){
	        Map<String, Object> viewmap =new LinkedHashMap<>();	            
	        initSetDrugRecord(viewmap);
	        
	        return drugRecord(DrugRecord.class, viewmap);
	    }
	    
	     public String drugRecord(Class clazz,Map<String,Object> viewmap) {
	    	 List  vos = new LinkedList<>() ;
	    	  
	    	// 根据map字段参数生成PigType查询条件
	 	//	PigType pigType = MyBeanUtils.toBean(viewmap, PigType.class);
	 		
	 		// hql语句
	 		String hql = "DurgRecord";
	 		
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
