package cn.bluedot.core.service;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.bluedot.core.bo.DiseaseTreatmentBo;
import cn.bluedot.core.bo.InoculationSetBo;

public class DiseaseTreatmentService extends PigService{
    
    private void initDiseaseTreatmentService(Map<String, Object> viewmap){
        viewmap.put("eatTime", "使用时间");
        viewmap.put("illTime", "生病时间");
        viewmap.put("useCount", "使用量");
        viewmap.put("illDescription", "生病描述");
        viewmap.put("pigNo", "猪只号");
        viewmap.put("drugName", "服用药物");
    }
    
    private String diseaseTreatment(Map<String, Object> params){
        Map<String, Object> viewmap =new LinkedHashMap<>();
        
        initDiseaseTreatmentService(viewmap);
        
        return comment(DiseaseTreatmentBo.class, viewmap);

    }
}
