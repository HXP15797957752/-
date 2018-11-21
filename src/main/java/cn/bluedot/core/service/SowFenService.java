package cn.bluedot.core.service;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cn.bluedot.core.domain.SowDuan;
import cn.bluedot.core.domain.SowFen;
import net.sf.json.JSONArray;

/** 
* @author 作者 zg
* @version 创建时间：2018年10月28日 下午3:09:10 
*/
public class SowFenService implements Service{

	 private void initSetSow(Map<String, Object> viewmap) {
	        viewmap.put("sowNo", "母猪耳号");
	        viewmap.put("fenDate", "分娩时期");
	        viewmap.put("pigstyNo", "所在猪舍");
	        viewmap.put("hogcoteNo", "所在猪栏");
	        viewmap.put("state", "分娩状态");
	        viewmap.put("fendate", "分娩时长");
	        viewmap.put("number", "产仔数量");
	        viewmap.put("healthpig", "仔健康数量");
	        viewmap.put("nhealthpig", "不健康仔数量");
	      
	    }
	  private String setSowFen(Map<String, Object[]> sowStartard){
	        Map<String, Object> viewmap =new LinkedHashMap<>();	            
	        initSetSow(viewmap);
	        
	        return sowFen(SowFen.class, viewmap);
	    }
	    
	
	     public String sowFen(Class clazz,Map<String,Object> viewmap) {
	    	 List  vos = new LinkedList<>() ;
	    	  
	    	// 根据map字段参数生成PigType查询条件
	 	//	PigType pigType = MyBeanUtils.toBean(viewmap, PigType.class);
	 		
	 		// hql语句
	 		String hql = "SowFen";
	 		
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
