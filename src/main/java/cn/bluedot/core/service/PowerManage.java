package cn.bluedot.core.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cn.bluedot.core.domain.Menu;
import cn.bluedot.core.domain.MenuBo;
import cn.bluedot.core.domain.Menuitem;
import cn.bluedot.core.domain.Power;
import cn.bluedot.core.util.MyBeanUtils;
import net.sf.json.JSONArray;

/**
 * 权限管理类
 * @author hxp
 * 2018年9月4日 下午8:21:51
 */
public class PowerManage implements Service{
    /*
     * 根据权限动态加载页面
     * */
    public List loadPage(Map paramsMap) {
        List menus = new ArrayList();
        
        try {
            menus = superDao.query(MenuBo.class, paramsMap);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return menus;
    }
    /*
     * 分配权限
     * */
    public void distributePower(Map paramsMap) {
        //将分配的权限存入到数据库中
        Menuitem menuitem = MyBeanUtils.toBean(paramsMap, Menuitem.class);
        try {
            superDao.save(menuitem);
        } catch (SQLException e) {
            System.out.println("分配权限失败");
            e.printStackTrace();
        }      
    }
    
    /*
     * 显示所有待分配权限用户信息列表
     * */
    public String showUser(Map paramsMap){
        Map<String, Object> viewmap =new LinkedHashMap<>();
        
        initPoweerTable(viewmap);
        // 存放表头的map
        List<Map> vot = new LinkedList<>() ;
        vot.add(viewmap);    
        //存放表内容
        List<Object> vos = new LinkedList<>();
        vos.addAll(superDao.HQLQuery("User"));               
        List vo = new LinkedList<>();
        vo.add(vot);
        vo.add(vos);
        
        return "a^" + JSONArray.fromObject(vo).toString();
    }
    
    private void initPoweerTable(Map<String, Object> viewmap) {
        viewmap.put("userNo", "用户编号");
        viewmap.put("trueName", "真实姓名");        
    }

    public static void main(String[] args) {
        PowerManage powerManage= new PowerManage();
        Map map  = new HashMap();
        //map.put("userNo", "111111");
        System.out.println(powerManage.showUser(map));
    }
}
