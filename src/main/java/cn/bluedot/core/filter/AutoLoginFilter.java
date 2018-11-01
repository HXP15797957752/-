package cn.bluedot.core.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import cn.bluedot.framemarker.dao.SuperDao;

@WebFilter("/index.html")
public class AutoLoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    HttpServletRequest req = (HttpServletRequest)request;
	    if (req.getSession().getAttribute("user") == null) {
	        // 尝试自动登陆
	         Cookie []cs = req.getCookies();
	         if (cs != null) {
	             String cname = null;
	             String cps = null;
	             for (Cookie cookie : cs) {
	                 if ("cname".equals(cookie.getName())) {
	                     cname = cookie.getValue();
	                 }else if("cps".equals(cookie.getName())) {
	                     cps = cookie.getValue();
	                 }
	             }
	             if (cname != null && cps != null) {
	                 List<Object> list = new SuperDao().HQLQuery("User|userNo=?, password=?", cname, cps);
	                 if (!list.isEmpty()) {
	                     req.getSession().setAttribute("user", list.get(0));
	                 }
	             }
	         }
	    }
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
