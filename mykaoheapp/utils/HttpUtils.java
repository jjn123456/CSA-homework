package com.example.mykaoheapp.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {
    public static String getJSONfromNet(String path){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String json = "";
        //将路径转换为url对象
        try{
            URL url = new URL(path);
            //获取网络连接对象
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(8000);
            conn.setReadTimeout(8000);
            conn.connect();
            //读取输入流对象
            InputStream is = conn.getInputStream();
            //读取流
            int hasRead = 0;
            byte[] buf = new byte[1024];
            while (true){
                hasRead = is.read(buf);
                if (hasRead==-1)
                    break;
                baos.write(buf,0,hasRead);
            }
            is.close();
            json = baos.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return json;
    }
}
