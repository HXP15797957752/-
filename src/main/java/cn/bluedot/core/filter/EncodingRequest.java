package cn.bluedot.core.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 装饰reqeust
 *
 */
public class EncodingRequest extends HttpServletRequestWrapper {
								//装饰者模式
	private HttpServletRequest req;
	
	public EncodingRequest(HttpServletRequest request) {
		super(request);
		this.req = request;
	}

	//替换原来request的getParameter方法
	public String getParameter(String name) {
		String value = req.getParameter(name);
		if(value!=null&&!value.trim().isEmpty())
		{
			// 处理编码问题
			try {
				value = new String(value.getBytes("iso-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}
		
		
		return value;
	}
}
