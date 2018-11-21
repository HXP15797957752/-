package cn.bluedot.core.service;

import java.util.Map;
import java.util.TreeMap;

import cn.bluedot.core.bo.SetFormulsaBo;

public class PigFeedFormulaService extends PigService{
    
    private void initsetFormula(Map<String, Object> viewmap) {
        // TODO Auto-generated method stub
        viewmap.put("formulaName", "配方名称");
        viewmap.put("waterProportion", "水比例(%)");
        viewmap.put("drugProportion", "药比例(%)");
        viewmap.put("feedProportion","饲料比例(%)");
        viewmap.put("season", "适用季节");
        viewmap.put("createTime", "创建时间");
        viewmap.put("description", "配方描述");
        viewmap.put("typename", "药种类");
        viewmap.put("userName", "操作员");
    }
    
    /**
     * 设置配方数据
     */
    private String setFormula(Map<String, String[]> params){
        Map<String, Object> viewmap =new TreeMap<>();
        
        initsetFormula(viewmap);
        
        return comment(SetFormulsaBo.class, viewmap);
    }
    
    
}
