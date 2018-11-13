package cn.bluedot.core.service;

import java.util.List;
import java.util.Map;

import cn.bluedot.core.domain.Power;

/**
 * 权限管理类
 * @author hxp
 * 2018年9月4日 下午8:21:51
 */
public class PowerManage implements Service{
    /*
     * 分配权限
     * */
    private void distributePower() {}
    /*
     * 审核权限：通过，拒绝
     * */
    private boolean auditingPower() {
        return false;
    }
    /*
     * 查看权限审核信息
     * */
    private Map queryAuditingMessage() {
        return null;
    }
    /*
     * 显示所有权限信息列表
     * */
    private List<Power> queryPowerList(){
        return null;
    }
    /*
     * 显示列表:待审核、通过、拒绝
     * */
    private List<Power> queryPowerByCondition(Map map){
        return null;
    }
    
}
