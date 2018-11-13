package cn.bluedot.core.service;

import java.util.Map;

public class TestBaseService {
    
    public String hello(Map<String, String[]> map) {
        System.out.println("hello");
        try {
            Thread.sleep(8000);
        }catch(Exception e) {
            
        }
        System.out.println("over");
        return "r^/abc.jsp";
    }
    public String word(Map<String, String[]> map) {
        System.out.println("word");
        try {
            Thread.sleep(8000);
        }catch(Exception e) {
            
        }
        System.out.println("word");
        return "r^/abc.jsp";
    }
    
}
