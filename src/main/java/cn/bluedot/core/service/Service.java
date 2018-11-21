package cn.bluedot.core.service;

import cn.bluedot.framemarker.dao.SuperDao;

/**
 * 所有的service类继承此类
 * */
public interface Service {
    SuperDao superDao=new SuperDao();
}


