package cn.bluedot.core.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cn.bluedot.core.domain.User;
import cn.bluedot.core.util.MyBeanUtils;
import cn.bluedot.framemarker.dao.SuperDao;
import net.sf.json.JSONArray;

/**
 * 用户管理业务
 * @author renzhijiang
 *
 */
public class UserService implements Service{
    public static void main(String[] args) {
        Map<String, String[]> map=new HashMap<>();
        map.put("userNo", new String[]{"232323"});
        map.put("state", new String[]{"1"});
        String ret = new UserService().userAudit(map);
        System.out.println(ret);
    }
    /**
     * 加载用户审核信息
     * /IntelligentSystem/api/VXNlclNlcnZpY2U6bG9hZFVzZXJzQXVkaXQ=
     */
    public String loadUsersAudit(Map<String, String[]> map) {
        
        Map<String, Object> viewmap =new LinkedHashMap<>();
        
        initUsersAudit(viewmap);
        // 存放头的map
        List<Map> vot = new LinkedList<>() ;
        vot.add(viewmap);
        
        List<Object> vos = new LinkedList<>();
        // 所有未被审核的...
        vos.addAll(sd.HQLQuery("User|state=?", 0));
        
        List vo = new LinkedList<>();
        vo.add(vot);
        vo.add(vos);
        
        return "a^" + JSONArray.fromObject(vo).toString();
    }
    private void initUsersAudit(Map<String, Object> viewmap) {
        viewmap.put("userNo", "用户账号");
        viewmap.put("phoneNumber", "电话号码");
        viewmap.put("IDCard", "身份证号");
        viewmap.put("createDate", "申请日期");
        viewmap.put("state", "审核状态");
    }
    /**
     * 处理用户审核
     * @param map
     * @return
     */
    public String userAudit(Map<String, String[]> map) {
        User recUser = MyBeanUtils.toBean(map, User.class);
        List list = sd.HQLQuery("User|userNo=?", recUser.getUserNo());
        if (list.isEmpty()) {
            //没有这个用户
            return null;
        }
        // 0->1 或者是0->2
        try {
            User user = (User)list.get(0);
            String[]ss = map.get("state");
            int k = -1;
            if (ss != null && ss.length == 1) {
                k = Integer.parseInt(ss[0]);
            }
            if (k != -1 && k == 1 || k == 2) {
                //通过
                user.setState(k);
                sd.update(user);
            }
        }catch(NumberFormatException e) {
            
        }    
        return null;
    }
    /**
     * 用户注销
     * @param map
     * @return
     */
    public String cancellation(Map<String, String[]> map) {
        User recUser = MyBeanUtils.toBean(map, User.class);
        List list = sd.HQLQuery("User|userNo=?", recUser.getUserNo());
        if (list.isEmpty()) {
            //没有这个用户,无法注销
            return null;
        }
        // 0->1 或者是0->2
        try {
            User user = (User)list.get(0);
            if (user.getState() == 1) {
                user.setState(3);
                sd.update(user);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }    
        return null;
    }
    
    
    private SuperDao sd = new SuperDao();
}
