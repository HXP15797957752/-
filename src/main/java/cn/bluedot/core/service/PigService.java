package cn.bluedot.core.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import cn.bluedot.core.bo.DoubtfulIllBo;
import cn.bluedot.core.bo.GrowthStandardBo;
import cn.bluedot.core.domain.Pig;
import cn.bluedot.core.domain.WillDestroy;
import cn.bluedot.framemarker.common.BoSuper;
import cn.bluedot.framemarker.dao.SuperDao;
import net.sf.json.JSONArray;


public class PigService implements Service{
    /**
     * 测试用dao
     */
    SuperDao sd = new SuperDao();
    
    public PigService(){
        
    }
    
    Vector<Integer> vector = new Vector<>();
    
    /**
     * 该函数是建立一个公共的json字串
     * @param vos
     * @return json的字符串形式
     */
    private String comment(Class clazz, Map viewmap){
        List<BoSuper> vos = new LinkedList<>() ;
        
        try {
            vos.addAll(sd.query(clazz, null));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            
            e.printStackTrace();
        }
        
        List<Map> vot = new LinkedList<>() ;
        vot.add(viewmap);
             
        List vo = new LinkedList<>();
        vo.add(vot);
        vo.add(vos);
        
        JSONArray View = JSONArray.fromObject(vo);
        return "a^"+View.toString();
    }
    
//    private String pigGrowthStatistic(Map<String, Object[]> params){
//        Map<String, Object> viewmap =new TreeMap<>();
//        
//        initMapSetGrowthStandard(viewmap);
//    }
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
     * 
     * @param 生长情况设置显示
     * @return
     */
    private String setGrowthStandard(Map<String, Object[]> shezhi){
        Map<String, Object> viewmap =new TreeMap<>();
       
        initsetGrowthStandard(viewmap);
        
        return comment(GrowthStandardBo.class, viewmap);
    }
    
    /**
     * 猪只生长统计
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
    
    /**
     * 猪只生长设置界面字段
     * @param viewmap
     */
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
     * 淘汰猪只页面设置
     * @param args
     */
    private void initEliminatePig(Map<String, Object> viewmap){
        viewmap.put("pigNo", "耳号");
        viewmap.put("pigSex", "猪性别");
        viewmap.put("growthStandard", "生长期");
        viewmap.put("pigType", "猪种");
        viewmap.put("pigHouse", "猪舍");
        viewmap.put("pigColumn", "猪栏");
        viewmap.put("weight", "重量");
        viewmap.put("reason", "原因");
        viewmap.put("date", "日期");
    }
    
    /**
     * 
     * @param args
     */
    private void initSetFormula(Map<String, Object> viewmap){
        viewmap.put("formula", "耳号");
        viewmap.put("pigSex", "猪性别");
        viewmap.put("growthStandard", "生长期");
        viewmap.put("pigType", "猪种");
        viewmap.put("pigHouse", "猪舍");
        viewmap.put("pigColumn", "猪栏");
        viewmap.put("weight", "重量");
        viewmap.put("reason", "原因");
        viewmap.put("date", "日期");
    }

    public static void main(String []args){
        PigService ps = new PigService();
        //ps.setGrowthStandard(null);
        
//        Map<String, String[]> map = new HashMap<>();
//        
//        String []pig = {"1"};
//        String []userNo = {"1"};
//        String []reson = {"猪只生病"};
//        map.put("pigNo", pig);
//        map.put("userNo", userNo);
//        map.put("reason", reson);
//        ps.eliminatePig(map);
        
        //System.out.println(ps.DoubtfulIll(null));
        String sql="Pig";
        System.out.println(ps.sd.HQLQuery(sql, 2));
        System.out.println(new sun.misc.BASE64Encoder().encode("PigService:doubtfulIll".getBytes())); 
    }
    
    /**
     * 查询猪只
     */
    private String growthCircumStance(Map<String, String[]> params){
        return null;
        
    }
    
    /**
     * 淘汰猪只
     */
    private String eliminatePig(Map<String, String[]> params){
        //获得猪耳号
        String pigNo = params.get("pigNo")[0];
        System.out.println(12);
        //先判断该猪只是否有异常时期
        if(pigNo != null && !(sd.HQLQuery("AddWeight|pig_No=?,isException=?", pigNo, 1) == null)){
             
             WillDestroy wd = new WillDestroy();
             wd.setPigNo(pigNo);
             wd.setReason(params.get("reason")[0]);
             wd.setCommitTime(new Date());
             //是否同意，1为同意，0为不同意
             wd.setIsAgree(0);
             wd.setCheckUserNo(params.get("userNo")[0]);
             try {
                sd.save(wd);
             } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return null;
        
    }
    
    /**
     * 病猪确认
     */
    private String confirmIllPig(Map<String, String[]> params){
        return null;
        
    }
    
    /**
     * 解除疑似生病警报
     */
    private String relieveAlter(Map<String, String[]> params){
        return null;
        
    }
    
    /**
     * 设置配方
     */
    private String setFormula(Map<String, String[]> params){
        return null;
        
    }
    
    /**
     * 饲喂设置
     */
    private String setFeeding(Map<String, String[]> params){
        return null;
    }
    
    /**
     * 删除饲喂设置
     */
    private String deleteFeeding(Map<String, String[]> params){
        return null;
    }
    
    /**
     * 修改饲喂调控
     */
    private String updataFeeding(Map<String, String[]> params){
        return null;
    }
    
    /**
     * 增加猪只信息
     */
    private String addPig(Map<String, String[]> params){
        return null;
    }
    
    /**
     * 修改猪只信息
     */
    private String updataPig(Map<String, String[]> params){
        return null;
    }
    
    /**
     * 疫苗提醒
     */
    private String remind(Map<String, String[]> params){
        return null;
    }
    
    /**
     * 修改提醒
     */
    private String updataRemind(Map<String, String[]> params){
        return null;
    }
    
    /**
     * 登记生病
     */
    private String RegisterIll(Map<String, String[]> params){
        return null;
    }
    
    /**
     * 回栏操作
     */
    private String returnHome(Map<String, String[]> params){
        return null;
    }
    
    /**
     * 销毁操作
     */
    private String removePig(Map<String, String[]> params){
        return null;
    }
    
    /**
     * 入栏操作
     */
    private String pushHome(Map<String, String[]> params){
        return null;
    }
    
    /**
     * 出栏操作
     */
    private String popHome(Map<String, String[]> params){
        return null;
    }
    
    /**
     * 专栏操作
     */
    private String exchangeHome(Map<String, String[]> params){
        return null;
    }
}