package cn.bluedot.core.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cn.bluedot.framemarker.common.BoSuper;
import net.sf.json.JSONArray;

public class PigViewService {
    private String pigGrowthStatistic(Map<String, Object[]> params){
        Map<String, Object> viewmap =new TreeMap<>();
        
        initMapSetGrowthStandard(viewmap);
        List<Map> vot = new LinkedList<>() ;
        vot.add(viewmap);
            
        List<BoSuper> vos = new LinkedList<>() ;
        
          
        List vo = new LinkedList<>();
        vo.add(vot);
        vo.add(vos);
        
        JSONArray View = JSONArray.fromObject(vo);
        return "a^"+View.toString();
    }
    
    private void initMapSetGrowthStandard(Map<String, Object> viewmap) {
        viewmap.put("pigType", "猪种");
        viewmap.put("pigSex", "猪性别");
        viewmap.put("growthStandard", "生长期");
        viewmap.put("dayWeight", "日增重量");
        viewmap.put("upData", "上限");
        viewmap.put("lowData", "下限");
        viewmap.put("date", "日期");
        viewmap.put("timeGap", "提示间隔");
    }
}
