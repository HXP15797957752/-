package cn.bluedot.core.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import cn.bluedot.core.bo.PigBo;

public class PigInformation extends PigService{
    /**
     * 猪只生长设置界面字段
     * @param viewmap
     */
    private void initPigInformation(Map<String, Object> viewmap) {
        System.out.println(viewmap.size() + "," );
        viewmap.put("pigNo", "猪种");
        viewmap.put("sex", "猪性别");
        viewmap.put("typeName", "猪种");
        viewmap.put("growthName", "生长期");
        viewmap.put("age", "猪龄");
        viewmap.put("birthTime", "出生日期");
        viewmap.put("state", "状态");
        viewmap.put("orignPlace", "出生产地");
        viewmap.put("hogcoteNo", "所在猪舍");
        viewmap.put("fatherNo", "父耳号");
        viewmap.put("motherNo", "母耳号");
    }
    
    /**
     * 猪只信息
     */
    public String pigInformation(Map<String, Object> params){
        System.out.println("okokok" + params.size());
        Map<String, Object> viewmap =new HashMap<>();
        
        initPigInformation(viewmap);
        
        return comment(PigBo.class, viewmap);
    }
}
