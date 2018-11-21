package cn.bluedot.core.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.collections.MapUtils;

import cn.bluedot.core.bo.DoubtfulIllBo;
import cn.bluedot.core.bo.GrowthStandardBo;
import cn.bluedot.core.bo.InoculationSetBo;
import cn.bluedot.core.bo.SetFormulsaBo;
import cn.bluedot.core.domain.Formula;
import cn.bluedot.core.domain.InoculationSet;
import cn.bluedot.core.domain.Pig;
import cn.bluedot.core.domain.PigStandard;
import cn.bluedot.core.domain.WillDestroy;
import cn.bluedot.core.util.Base64Util;
import cn.bluedot.core.util.MyBeanUtils;
import cn.bluedot.framemarker.common.BoSuper;
import cn.bluedot.framemarker.dao.SuperDao;
import cn.bluedot.framemarker.parse.Config;
import net.sf.json.JSONArray;


public class PigService  extends RequestWare implements Service{
    /**
     * 测试用dao
     */
    
    /**为正常为为为深刻搭街坊回家萨的客户反馈就是大啊大家撒扩大和阿斯对哦
     * 1异常
     * 猪只状态2为疑似生病
     * 3为生病
     *
     */
    SuperDao sd = new SuperDao();
    
    //
    private Map<String, Object> setMap = new ConcurrentHashMap<>();
    
    public PigService(){
        
    }
    
    Vector<Integer> vector = new Vector<>();
    
    /**
     * 该函数是建立一个公共的json字串
     * @param vos
     * @return json的字符串形式
     */
    protected String comment(Class clazz, Map viewmap){
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
    
    
    
    /**
     * 
     * @param 生长情况设置显示
     * @return
     */
    
    
   
    /**
     * 
     * @param args
     */
    private void initSetFormula(Map<String, Object> viewmap){
        
    }

    public static void main(String []args){
//      PigService ps = new PigService();
      //ps.setGrowthStandard(null);
//        
//      Map<String, String[]> map = new HashMap<>();
//        
//      String []pig = {"1"};
//      String []userNo = {"1"};
//      String []reson = {"猪只生病"};
//      map.put("pigNo", pig);
//      map.put("userNo", userNo);
//      map.put("reason", reson);
//      ps.eliminatePig(map);
//        
        System.out.println(Base64Util.encode("WeightSimulatorService:record"));
//      String sql="Pig";
//      System.out.println(ps.sd.HQLQuery(sql, 2));
        String []Str = {"1"};
       
//        
//        System.out.println((String)((Object)Str)); 
    }
    
    /**
     * 查询猪只
     */
    private String growthCircumStance(Map<String, String[]> params){
        return null;
        
    }
    
    private String addGrouth(Map map){
        PigStandard ps = MyBeanUtils.toBean(map, PigStandard.class);
        
        add(ps);
        
        return null;
    }
    
    private void add(Object object){
        
        
        if(setMap.containsKey(Base64Util.encode(object.toString()))){
           System.out.println("该设置已经存在"); 
           
        }else{ 
            try {
                sd.save(object);
                
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            setMap.put(Base64Util.encode(object.toString()), sd);
        }
       
    }
    
    /**
     * 病猪确认
     */
    private String confirmIllPig(Map<String, String[]> params){
        return null;//updata(params, 2);
    }
    
    protected String updata_delete_Operation(Class clazz, Map<String, Object> condition, int operation){
        String clazzname = clazz.getName();
        String []strs = (String [])condition.get(Config.getKey(clazzname.substring(clazzname.lastIndexOf(".") + 1)));
        condition.remove(strs);
        
        if(strs != null){
            for(String primykey : strs){
                
                Object obj = MyBeanUtils.toBean(condition, clazz);
                
                try{
                    if(operation == DELETE){
                        sd.delete(obj);
                    }else if(operation == UPDATA){
                        sd.update(obj);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        
        
        
        return null;
    }
    
    
    public static String getOneUpString(String name){
        return name.substring(0,1).toUpperCase()+name.substring(1);
    }

    /**
     * 饲喂设置
     */
    
    
   
    
    private String addFeet(Map<String, Object> viewmap){
        PigStandard ps = MyBeanUtils.toBean(viewmap, PigStandard.class);
        
        add(ps);
        
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
        Pig pig = MyBeanUtils.toBean(params, Pig.class);
        
        try {
            sd.save(pig);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        return null;
    }
    
    /**
     * 修改猪只信息
     */
    private String updataPig(Map<String, String[]> params){
        Pig pig = MyBeanUtils.toBean(params, Pig.class);
        sd.update(pig);
        return null;
    }
    
    /**
     * 疫苗提醒
     */
    private String remind(Map<String, String[]> params){
        InoculationSet is = MyBeanUtils.toBean(params, InoculationSet.class); 
        try {
            sd.save(is);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
    
    public static final int UPDATA = 0;
    public static final int DELETE = 1;
}