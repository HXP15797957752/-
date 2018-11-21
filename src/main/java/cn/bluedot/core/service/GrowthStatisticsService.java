package cn.bluedot.core.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bluedot.core.bo.PigGrowthBo;
import cn.bluedot.core.domain.AddWeight;
import cn.bluedot.core.domain.WeightBar;
import cn.bluedot.core.domain.WillDestroy;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GrowthStatisticsService extends PigService{
    private String growthStatistucs(Map<String, Object[]> map){
        Map<String, Object> viewmap =new LinkedHashMap<>();
        
        initGrowthStatistics(viewmap);
        
        return comment(PigGrowthBo.class, viewmap);
    }
    @SuppressWarnings({ "unused" })
	private String growthStatisticsShow(Map<String, Object[]> map) throws IOException{ 
    	HttpServletRequest request = (HttpServletRequest) req_rep.get("request");
    	HttpServletResponse response = (HttpServletResponse) req_rep.get("response");
    	String ID = request.getParameter("ID");
		 String hql = "AddWeight|pig_No=?";
		 WeightBar weightBar= null;
		 AddWeight payment = null; 
		 List<Object> vos = superDao.HQLQuery(hql,ID);
		 List<WeightBar> data = new ArrayList<WeightBar>();
		 for (Object object : vos) {
			 payment = (AddWeight)object;
			 weightBar = new WeightBar();
			 weightBar.setDate(payment.getDate());
			 weightBar.setWeight(payment.getWeight());
			 data.add(weightBar); 
		}
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("categorys",data);
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);   
        return "a^"+jsonArray.toString();
    }
    private void initGrowthStatistics(Map<String, Object> viewmap) {

        viewmap.put("pigNo", "猪耳号");
        viewmap.put("typeName", "猪种");
        viewmap.put("sex", "猪只性别");
        viewmap.put("growthName", "生长期");
        viewmap.put("pigstyNo", "猪舍号");
        viewmap.put("hogcoteNo", "猪场号");
        viewmap.put("state", "状态");
    }
    
    /**
     * 淘汰猪只
     */
    private String eliminatePig(Map<String, String[]> params){
        //获得猪耳号
        String pigNo = params.get("pigNo")[0];
        System.out.println(12);
        //先判断该猪只是否有异常时期
        if(pigNo == null){
            System.out.println("该猪只不存在");
        }
        
        if(!(sd.HQLQuery("AddWeight|pig_No=?,isException=?", pigNo, 1) == null)){
             
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
        }else{
            System.out.println("不可以淘汰该猪只，该猪只没有发生过异常情况");
        }
        
        return null;
        
    }
}
