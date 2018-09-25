package cn.bluedot.core.service;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class RequestWare {
    private HttpServletRequest request;
    public HttpServletRequest getRequest() {
        return request;
    }
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
    
    /**
     * 对于文件上传解析的通用工具
     * @param request
     * @param params 返回表单其他非文件的键值对
     * @return  获取上传文件的输入流
     */
    public InputStream parseUpload(HttpServletRequest request, Map<String, String> params) {
		InputStream is =null;
		try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 设置上传文件的大小限制为10M
            factory.setSizeThreshold(1024 * 10240);
             
            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (!item.isFormField()) {
                    // item.getInputStream() 获取上传文件的输入流
                    is = item.getInputStream();
                } else {
                	String paramName = item.getFieldName();
                	String paramValue = item.getString();
                	paramValue = new String(paramValue.getBytes("ISO-8859-1"), "UTF-8");
                	params.put(paramName, paramValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return is;
	}

}
