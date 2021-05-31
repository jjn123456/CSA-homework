package com.example.mykaoheapp.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLContent {
    public static String getParnterURL(String man,String woman){
        man = man.replace("座","");
        woman = woman.replace("座","");
        try {
            man = URLEncoder.encode(man,"UTF-8");
            woman = URLEncoder.encode(woman,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String url = "http://apis.juhe.cn/xzpd/query?men="+man+"&women="+woman+"&key=d74c4a755ba1e4b0f88bae49a236426a";
        return url;
    }
}
