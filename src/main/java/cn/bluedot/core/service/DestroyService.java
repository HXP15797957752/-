package cn.bluedot.core.service;

import java.util.LinkedHashMap;
import java.util.Map;
import cn.bluedot.core.bo.willDestroyBo;

public class DestroyService extends PigService{
    
    private String willDestroy(Map<String, Object> map){
        Map<String, Object> viewmap =new LinkedHashMap<>();
        
        initwillDestroy(viewmap);
        
        return comment(willDestroyBo.class, viewmap);

    }
    
    private void initwillDestroy(Map<String, Object> viewmap){
        viewmap.put("commitTime", "生病时间");
        viewmap.put("reason", "生病原因");
        viewmap.put("isAgree", "是否同意");
        viewmap.put("username", "批准人");
        viewmap.put("pigNo", "猪只号");
    }
}
