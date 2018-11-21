package cn.bluedot.core.service;

import java.util.List;
import java.util.Map;

/**
 * 数据库备份与恢复
 * @author hxp
 * 2018年9月4日 下午8:38:48
 */
public class BackupAndRecovery implements Service{
    /*
     * 查询数据库信息列表
     * */
    private List queryDBMessage() {
        return null;
    }
    /*
     * 条件查询数据库信息列表
     * */
    private List queryDBMessageByCondition(Map map) {
        return null;
    }
    /*
     * 备份
     * */
    private void Backup() {}
    /*
     * 恢复
     * */
    private Boolean Recovery() {
        return false;
    }
}
