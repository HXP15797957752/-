package cn.bluedot.framemarker.test;

import java.awt.List;
import java.util.HashMap;
import java.util.Map;

import cn.bluedot.framemarker.common.BoSuper;
import cn.bluedot.framemarker.common.TestBo;
import cn.bluedot.framemarker.common.User;
import cn.bluedot.framemarker.core.ObjectParse;
import cn.bluedot.framemarker.core.XValue;
import cn.bluedot.framemarker.dao.SuperDao;

public class ServiceTest {
    public static void main(String []args) throws Exception{
        BoSuper bs = new TestBo();
        Map<String, Object> map = new HashMap<>();    
      map.put("classID", 1);           
     XValue xv = new XValue(1,4);
   
       map.put("userid", xv);
               
       SuperDao sd = new SuperDao();
      java.util.List<BoSuper> list= sd.query(bs.getClass(), map);
        User u = new User();
        u.setId(4);
        System.out.println("111");
        System.out.println(list);
    }
}   
