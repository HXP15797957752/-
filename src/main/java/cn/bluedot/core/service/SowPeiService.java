package cn.bluedot.core.service;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/*
 * 母猪管理
 */
import java.util.TreeMap;

import cn.bluedot.core.domain.Algorithm;
import cn.bluedot.core.domain.PigType;
import cn.bluedot.core.domain.SowPei;
import cn.bluedot.core.util.MyBeanUtils;
import cn.bluedot.framemarker.common.BoSuper;
import net.sf.json.JSONArray;


/*
 * 母猪配种管理
 */
public class SowPeiService implements Service{

	 private void initSetSow(Map<String, Object> viewmap) {
	        viewmap.put("sowNo", "母猪耳号");
	        viewmap.put("semenDate", "输精日期");
	        viewmap.put("pigstyNo", "所在舍");
	        viewmap.put("hogcoteNo", "所在栏");
	        viewmap.put("boarNo", "与配公猪");
	        viewmap.put("method", "输精方式");
	      
	    }
	  private String setSowPei(Map<String, Object[]> sowStartard){
	        Map<String, Object> viewmap =new LinkedHashMap<>();	            
	        initSetSow(viewmap);
	        
	        return sowPei(SowPei.class, viewmap);
	    }
	    
	
	     public String sowPei(Class clazz,Map<String,Object> viewmap) {
	    	 List  vos = new LinkedList<>() ;
	    	  
	    	// 根据map字段参数生成PigType查询条件
	 	//	PigType pigType = MyBeanUtils.toBean(viewmap, PigType.class);
	 		
	 		// hql语句
	 		String hql = "SowPei";
	 		
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
