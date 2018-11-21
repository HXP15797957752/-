package cn.bluedot.core.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


import cn.bluedot.core.domain.Log;
import cn.bluedot.core.util.MyBeanUtils;
import cn.bluedot.framemarker.common.BoSuper;
import net.sf.json.JSONArray;

/***
 * 日志管理
 * @author hxp
 * 2018年9月4日 下午8:08:17
 */

public class LogManage implements Service{
    /*
     * 添加日志，在调用业务方法之前调用此方法记录日志
     * */
    public  boolean addLog(Map<String,Object> map) {
        Log log = MyBeanUtils.toBean(map, Log.class);
        try {
            superDao.save(log);
        } catch (SQLException e) {
            System.out.println("保存日志失败！");
            e.printStackTrace();
        }
        return true;       
    } 
   
    /*
     * 列表显示日志信息
     * */
    private String queryList(Map map){
        Map<String, Object> viewmap =new LinkedHashMap<>();
        
        initLogTable(viewmap);
        // 存放表头的map
        List<Map> vot = new LinkedList<>() ;
        vot.add(viewmap);    
        //存放表内容
        List<Object> vos = new LinkedList<>();
        vos.addAll(superDao.HQLQuery("Log"));               
        List vo = new LinkedList<>();
        vo.add(vot);
        vo.add(vos);
        
        return "a^" + JSONArray.fromObject(vo).toString();
    }
    /*
     * 条件查询日志信息
     * */
    private String  queryByCondition(Map map){
        Map<String, Object> viewmap =new LinkedHashMap<>();
                
                initLogTable(viewmap);
                // 存放表头的map
                List<Map> vot = new LinkedList<>() ;
                vot.add(viewmap);    
                //存放表内容
                List<Object> vos = new LinkedList<>();
                vos.addAll(superDao.HQLQuery("Log"));               
                List vo = new LinkedList<>();
                vo.add(vot);
                vo.add(vos);
                
                return "a^" + JSONArray.fromObject(vo).toString();
        
        /*try {
           // list = superDao.query(Log.class, map);
            list = superDao.HQLQuery("Log");
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        JSONArray view = JSONArray.fromObject(list);
        return view.toString();*/
    }

    private void initLogTable(Map<String, Object> viewmap) {
        viewmap.put("logID", "日志ID");
        viewmap.put("time", "时间");
        viewmap.put("trueName", "真实姓名");
        viewmap.put("operationName", "操作名称");
        viewmap.put("ipAddress", "IP地址");
        
    }


  
}
