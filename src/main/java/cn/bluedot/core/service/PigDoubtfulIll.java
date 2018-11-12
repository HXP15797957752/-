package cn.bluedot.core.service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import cn.bluedot.core.bo.DoubtfulIllBo;
import cn.bluedot.core.domain.Pig;

public class PigDoubtfulIll extends PigService{
    /**
     * 疑似生病统计界面设置
     * @param viewmap
     */
    private void initDoubtfulIll(Map<String, Object> viewmap){
        viewmap.put("pigNo", "耳号");
        viewmap.put("pigSex", "猪性别");
        viewmap.put("growthStandard", "生长期");
        viewmap.put("pigType", "猪种");
        viewmap.put("pigHouse", "猪舍");
        viewmap.put("pigColumn", "猪栏");
        viewmap.put("date", "日期");
        viewmap.put("temperature", "体温");
    }
    
    /**
     * 初始化疑似生病信息
     * @param viewmap
     * @return
     */
    private String doubtfulIll(Map<String, Object> shezhi){
        Map<String, Object> viewmap =new TreeMap<>();
        
        initDoubtfulIll(viewmap);
        
        return comment(DoubtfulIllBo.class, viewmap);
    }
    
    /**
     * 病猪确认
     */
    private String illCommit(Map<String, Object> shezhi){
        String []strs = (String [])shezhi.get("pigNo");
        
        for(String str : strs){
            
            if(sd.HQLQuery("Pig|pigNo=?,state=?", str, 1).size() == 0){
                System.out.println("有猪只的异常状态不符合病猪确认");
                return null;
            }
        }
        
        shezhi.put("state", 2);
        updata_delete_Operation(Pig.class, shezhi, PigService.UPDATA);
        System.out.println("猪只操作完毕，没有问题");
        
        return null;
    }
    
    public static void main(String []args){
        PigDoubtfulIll pdf = new PigDoubtfulIll();
        Map<String, Object> map = new HashMap<>();
        String []str = {"1"};
        map.put("pigNo",str);
        pdf.illCommit(map);
    }
    
    /**
     * 解除疑似生病警报
     */
    private String relieveAlter(Map<String, Object> params){
        String []strs = (String [])params.get("pigNo");
        
        for(String str : strs){
            
            if(sd.HQLQuery("Pig|pigNo=?", str).size() == 0){
                System.out.println("猪只不存在");
                return null;
            }
        }
        
        params.put("state", 1);
        updata_delete_Operation(Pig.class, params, PigService.UPDATA);
        System.out.println("猪只操作完毕，没有问题");
        return null;//updata(params, 0);
    }
}
