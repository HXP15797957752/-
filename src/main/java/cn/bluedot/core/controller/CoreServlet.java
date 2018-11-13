package cn.bluedot.core.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import cn.bluedot.core.domain.User;
import cn.bluedot.core.service.RequestWare;
import cn.bluedot.core.service.Service;
import cn.bluedot.core.util.Base64Util;
import cn.bluedot.core.util.LogProxy;

/**
 * Servlet implementation class CoreServlet
 */
@WebServlet("/api/*")
public class CoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 假定所有的请求都是需要传入管道的
        // 经过一系列解析, 假定得到 真实的 业务对象,但是不能在这个线程执行
        // 需要放入管道
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;
        Map<String, String[]> mapParams = request.getParameterMap();
        User user= (User) request.getSession().getAttribute("user");
        String ipAddress = request.getRemoteAddr();
        System.out.println("ipAddress==="+ipAddress);
        System.out.println("user==="+user);
        Map<String, Object> req_rep = new HashMap<String, Object>();
        // .../api/类名!methodnmae
            
        String ID = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        System.out.println(ID);
        /**
         * 1. 获取method参数，它是用户想调用的方法
         */
        String[] params = Base64Util.decodeID(ID);
        String modelName = "cn.bluedot.core.service." + params[0];
        String actionName = params[1];
        System.out.println(modelName);
        Class<?> serviceClass = null;
        Method method = null;

        /**
         * 2. 通过方法名称获取Method对象
         */
        try {
            serviceClass = Class.forName(modelName);
            method = serviceClass.getDeclaredMethod(actionName, Map.class);
            method.setAccessible(true);

        } catch (Exception e) {
            throw new RuntimeException("您要调用的方法：" + actionName + "它不存在！", e);
        }
                // 放入管道
        Future<Object> future = null;
        System.out.println(Thread.currentThread().getName());
        try {
            // ??...
          //Service service = (Service) serviceClass.newInstance();
            //修改为利用自定义动态代理生成service，以便记录日志
            LogProxy logProxy = new LogProxy(ipAddress,user.getTrueName());
            Service service  = (Service)logProxy.getProxy(serviceClass);
            //需要用到req 和 rep的模块
          if (service instanceof RequestWare) {
        	  req_rep.put("request", request);
        	  req_rep.put("response", response);
              ((RequestWare)service).setReq_rep(req_rep);
          }

         future = CSConduit.getIntance().exeTask
                    (new ServiceWrap(service, method, mapParams));
        } catch (Exception e1) {
            e1.printStackTrace();
        } 
        // 取出结果
        String result = null;
        try {
            result = (String) future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        
        // 得到业务处理结果, 进行下一步操作
        System.out.println("result:"+result);
        // 如果请求处理方法返回不为空
        if (result != null && !result.trim().isEmpty()) {
            // 获取第一个冒号的位置
            int index = result.indexOf("^");
            // 如果没有冒号，使用ajax
            if (index == -1) {
                response.getWriter().print(result);
            } else {// 如果存在冒号
                // 分割出前缀
                String start = result.substring(0, index);
                // 分割出路径
                String path = result.substring(index + 1);
                if (start.equals("f")) {// 前缀为f表示转发
                    request.getRequestDispatcher(path).forward(request, response);
                } else if (start.equals("r")) {// 前缀为r表示重定向
                    response.sendRedirect(request.getContextPath() + path);
                } else if (start.equals("a")) {// 使用ajax
                	String str=result.substring(2);
/*                	result = URLDecoder.decode(str, "utf-8");*/
                	System.out.println(str);
                    response.getWriter().print(str);
                }
            }
        }
    }
 
	

}
