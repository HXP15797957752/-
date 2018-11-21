package cn.bluedot.core.moni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import cn.bluedot.core.domain.Pig;
import cn.bluedot.framemarker.dao.SuperDao;

public class AddWeightSimulator{
    public static void main(String []args){
        
        Map<String, String> setMap = new HashMap<>();
        SuperDao sd = new SuperDao();
        
        
        
         new Thread(){       
            public void run(){   
                try {
                    while(true){
                        Thread.sleep(2000);
                        System.out.println(">>>>>>>>>>>>>>>>>>>>");
                        List<Object> list = sd.HQLQuery("Pig");
                        for (Object obj : list){
                            Pig pig = (Pig)obj;
                            java.util.Random r=new java.util.Random(); 
                            int aweight = r.nextInt() % 3 + 4;
                            setMap.put("weight", "" + aweight);
                            setMap.put("growthStateId", "" + pig.getGrowthStateID());
                            setMap.put("pigtypeId", "" + pig.getPigTypeID());
                            setMap.put("pig_No", pig.getPigNo());
                            setMap.put("sex", pig.getSex() + "");
                            try {
                                sendMessage(setMap);
                            } catch (Exception e) {
                                System.out.println("服务器异常");
                                break;
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            } 
         }.start();
        
    }

    public static void sendMessage(Map<String, String> setMap) throws Exception{
        URLConnection connection = null;
        
        
        
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
            System.out.println(printWriter);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 发送请求参数
        printWriter.write("weight="+ setMap.get("weight") +"&growthStateId="+ setMap.get("growthStateId") + "&pigtypeId="+ setMap.get("pigtypeId") +"&pig_No="+ setMap.get("pig_No") +"&sex=" + setMap.get("sex"));//post的参数 xx=xx&yy=yy
        // flush输出流的缓冲
        printWriter.flush();

        //显式地设置为POST，默认为GET
        try {
            
            //建立连接
            conn.connect();
            System.out.println("111111111111111111111111");
            conn.getResponseCode();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            throw new Exception();
        }
        
        
        printWriter.close();
    }
    
}
