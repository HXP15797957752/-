package cn.bluedot.core.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import cn.bluedot.core.bo.FeedSetBo;
import cn.bluedot.core.bo.SetFormulsaBo;
import cn.bluedot.core.domain.FeedSet;
import cn.bluedot.core.util.MyBeanUtils;

public class PigFeedSetService extends PigService{
    private Map<String, Object> setFeedMap = new HashMap<>();
    /**
     * 饲喂设置表头
     * @param viewmap
     */
    private void initsetFeeding(Map<String, Object> viewmap) {
        viewmap.put("typeName","猪种类");
        viewmap.put("growthName", "生长期");
        viewmap.put("putNumber", "投放量");
        viewmap.put("putTime", "投放时间");
        viewmap.put("timeInterval", "间隔时间");
        viewmap.put("formulaName", "使用配方");
        
    }
    
    private String setFeeding(Map<String, String[]> params){
        Map<String, Object> viewmap =new TreeMap<>();
        
        initsetFeeding(viewmap);
        
        return comment(SetFormulsaBo.class, viewmap);

    }
    
    /**
     * 删除饲喂设置
     */
    private String deleteFeedSet(Map<String, Object> params){
        
        return null;
    }
    
    /**
     * 增加饲喂控制
     */
    private String addFeedSet(Map<String, Object> params){
        String typeName = (String)params.get("pigTypeID");
        String growthName = (String)params.get("growthStateID");
        String content = typeName + growthName;
        FeedSet fs = new FeedSet();
       
        
        if(setFeedMap.containsKey(content)){
            FeedSetBo feedset = (FeedSetBo)setFeedMap.get(content);
            fs.setFeedSetID(feedset.getFeedSetID());
            fs.setFormulaID(feedset.getFormulaID());
            fs.setPutNumber(feedset.getPutNumber());
            fs.setTimeInterval(feedset.getTimeInterval());
            
            if(feedset.getFormulaID() == Integer.parseInt((String)params.get("formulaID")) &&
                    feedset.getPutNumber() == Integer.parseInt((String)params.get("putNumber")) &&
                    feedset.getTimeInterval() == Integer.parseInt((String)params.get("timeInterval"))){
                System.out.println("该种情况已经设置");
            }else{
                
                
                sd.update(fs);
            }
        }else{
            
            FeedSet feed = MyBeanUtils.toBean(params, FeedSet.class);
            try {
                sd.save(feed);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
       
        return null;
    }
}
