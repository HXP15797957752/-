package cn.bluedot.core.util;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.bluedot.core.service.LogManage;
import cn.bluedot.core.service.PowerManage;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class LogProxy implements MethodInterceptor{
    //ipAddress trueName 为了记录日志使用
    private String ipAddress;
    private String trueName;
    private Enhancer enhancer = new Enhancer();
    public LogProxy() {}
    public LogProxy(String ipAddress, String trueName) {
        super();
        this.ipAddress = ipAddress;
        this.trueName = trueName;
    }
    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //前置代理 记录日志
       Map hashMap = new HashMap();
       /** 记录日志
         * 1记录操作日期  2记录操作人 3操作名称即业务方法 4ip地址
         * */
        hashMap.put("time", new Date());
        hashMap.put("trueName", trueName);
        hashMap.put("operationName", method.getName());
        hashMap.put("ipAddress", ipAddress);       
        new LogManage().addLog(hashMap);
         
        Object result  = methodProxy.invokeSuper(o, objects);
        //后置代理       
        
        return result;
    }
   
}
