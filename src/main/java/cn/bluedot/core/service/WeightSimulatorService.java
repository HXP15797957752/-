package cn.bluedot.core.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import cn.bluedot.core.domain.AddWeight;
import cn.bluedot.core.domain.PigStandard;
import cn.bluedot.core.util.Base64Util;

public class WeightSimulatorService implements Service{
    
    /**
     * 记录传感器传过来的体重信息
     * @param params
     */
    public void record(Map<String, String[]> params){
        double weight = Double.parseDouble(params.get("weight")[0]);
        String growth = params.get("growthStateId")[0];
        String pigType = params.get("pigtypeId")[0];
        String pigNo = params.get("pig_No")[0];
        String sex = params.get("sex")[0];
        
        AddWeight addWeight = new AddWeight();
        addWeight.setPig_No(pigNo);
        addWeight.setWeight(weight);
        addWeight.setDate("2016-10-12 12:45:32");
        addWeight.setGrowthStateId(Integer.parseInt(growth));
        addWeight.setPigtypeId(Integer.parseInt(pigType));
        addWeight.setSex(Integer.parseInt(sex));
        
        PigStandard ps = PigGrowthService.setMap.get(Base64Util.encode(pigType + ":" + growth + ":" + sex));
    
        if(ps == null){
            addWeight.setIsException(0);
        }else{
            System.out.println((ps.getUpperLimit() +ps.getAddWeight())+"::::::::"+(ps.getAddWeight() - ps.getLowerLimit()));
            if(weight >= ps.getAddWeight() - ps.getLowerLimit() && weight <= ps.getUpperLimit() +ps.getAddWeight()){
                addWeight.setIsException(0);
            }else{
                addWeight.setIsException(1);
            }
        }
        
        try {
            superDao.save(addWeight);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
