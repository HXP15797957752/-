package cn.bluedot.core.service;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.bluedot.core.bo.GrowthStandardBo;
import cn.bluedot.core.bo.InoculationSetBo;

public class PigSafeManageService extends PigService{
    private String inoculationSet(Map<String, Object> params){
        Map<String, Object> viewmap =new LinkedHashMap<>();
        
        initinoculationSet(viewmap);
        
        return comment(InoculationSetBo.class, viewmap);
    }
    
    private void initinoculationSet(Map<String, Object> viewmap) {

        viewmap.put("pigstyNo", "猪舍号");
        viewmap.put("drugName", "疫苗种类");
        viewmap.put("useCount", "使用量");
        viewmap.put("unit", "单位");
        viewmap.put("inoculationTime", "接种时间");
        viewmap.put("description", "描述");
        viewmap.put("username", "操作人");
        viewmap.put("createTime", "创建时间");
    }
    
    
}
