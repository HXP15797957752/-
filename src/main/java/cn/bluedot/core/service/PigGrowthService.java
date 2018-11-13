package cn.bluedot.core.service;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import cn.bluedot.core.bo.GrowthStandardBo;
import cn.bluedot.core.domain.AddWeight;
import cn.bluedot.core.domain.PigStandard;

public class PigGrowthService extends PigService{
    public static Map<String, PigStandard> setMap = new ConcurrentHashMap<>();
    /**
     * 获取页面
     * @param shezhi
     * @return
     */
    private String setGrowthStandard(Map<String, Object[]> shezhi){
        Map<String, Object> viewmap =new LinkedHashMap<>();
       
        initsetGrowthStandard(viewmap);
        
        return comment(GrowthStandardBo.class, viewmap);
    }
    
    /**
     * 猪只生长设置界面字段
     * @param viewmap
     */
    private void initsetGrowthStandard(Map<String, Object> viewmap) {
        viewmap.put("typeName", "猪种");
        viewmap.put("sex", "猪性别");
        viewmap.put("growthName", "生长期");
        viewmap.put("addWeight", "日增重量");
        viewmap.put("upperLimit", "上限");
        viewmap.put("lowerLimit", "下限");
        viewmap.put("date", "日期");
        viewmap.put("timeInterval", "提示间隔");
    }
    
    public static void main(String []args){
        PigGrowthService pg = new PigGrowthService();
        
        String []no = {"1","2"};
        
        Map map = new HashMap<>();
        map.put("btSelectItem", no);
        
    }
    
    /**
     * 删除猪只设置
     */
    private String onlyRemove(Map<String, Object[]> params){
        
        /**
         * 在此校验数据
         */
        System.out.println(params.get("pigStandardID"));
       
        return setGrowthStandard(params);
//        for(String select : selectItem){
//            if(Pattern.matches("^[0-9]+$",select)){
//                PigStandard ps = new PigStandard();
//                ps.setPigStandardID(Integer.parseInt(select));
//                
//                try {
//                    sd.delete(ps);
//                } catch (SQLException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }else{
//                System.out.println("含有非法字符");
//            }
//        }
    }
}
