package cn.bluedot.core.service;

import javax.servlet.http.HttpServletRequest;

public class RequestWare {
    public void requestWare(HttpServletRequest request) {
        this.request = request;  
    }
    private HttpServletRequest request;
    public HttpServletRequest getRequest() {
        return request;
    }
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
    
}
