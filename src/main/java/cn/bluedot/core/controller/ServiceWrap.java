package cn.bluedot.core.controller;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.Callable;

import cn.bluedot.core.service.Service;

public class ServiceWrap implements Callable<Object>{
    private Service service;
    private Method mt;
    private Map<String, String[]> args;
    public ServiceWrap(Service service, Method method, Map<String, String[]> args) {
       this.service = service;
       this.mt = method;
       this.args = args;
    }
    
    @Override
    public final Object call() throws Exception {
        
        return mt.invoke(service, args);
    }
    
}
