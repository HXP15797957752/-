package cn.blue.core.simulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

import cn.bluedot.core.service.Service;

public class AddWeightSimulator{
    public static void main(String []args){
        URLConnection connection = null;
        
        String result = "";
        PrintWriter out = null;
        BufferedReader in = null;
        
        try {
            connection = new URL("http://localhost:8080/IntelligentSystem/api/V2VpZ2h0U2ltdWxhdG9yU2VydmljZTpyZWNvcmQ").openConnection();
            
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        HttpURLConnection conn = (HttpURLConnection)connection;
       
        // 5秒后超时
        conn.setConnectTimeout(5000);

        // 设置通用的属性
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "keep-Alive");
        conn.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1");
       
        
        // post请求必须有下面两行
        conn.setDoOutput(true);
        conn.setDoInput(true);
        // post请求不应该使用cache
        conn.setUseCaches(false);

        // 获取URLConnection对象对应的输出流
        PrintWriter printWriter = null;
        try {
            conn.setRequestMethod("POST");
            printWriter = new PrintWriter(conn.getOutputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 发送请求参数
        printWriter.write("weight=1.5&growthStateId=1&pigtypeId=1&pig_No=1&sex=0");//post的参数 xx=xx&yy=yy
        // flush输出流的缓冲
        printWriter.flush();

        //显式地设置为POST，默认为GET
        try {
            

            conn.connect();
            conn.getResponseCode();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }
}
