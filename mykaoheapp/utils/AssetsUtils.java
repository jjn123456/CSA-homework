package com.example.mykaoheapp.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.mykaoheapp.bean.StarInfoBean;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//工具类，读取Assets文件夹中的数据工具类
public class AssetsUtils {
    private static Map<String,Bitmap> logoImgMap;//强引用
    private static Map<String,Bitmap> contentlogoImgMap;

    /*读取assets文件夹中的内容，存放到字符串中*/
    public static String getJsonFromAssets(Context context,String filename){
        /*1.获取assets文件夹管理器*/
        AssetManager am = context.getResources().getAssets();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        /*2.获得输入流*/
        try{
            InputStream is = am.open(filename);
            //读取内容存放到内存流中
            int hasRead = 0;
            byte[] buf = new byte[1024];
            while (true){
                hasRead = is.read(buf);
                if (hasRead == -1){
                    break;
                }
                baos.write(buf,0,hasRead);
            }
            String msg = baos.toString();
            is.close();//关闭内存流
            return msg;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
//    读取Assets文件夹下的图片，返回Bitmap
    public static Bitmap getBitmapFromAssets(Context context,String filename){
        Bitmap bitmap = null;
        AssetManager am = context.getResources().getAssets();
        try{
            InputStream is = am.open(filename);
          /*通过位图管理器，将输入流转换成位图对象*/
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }
/*
* 将Assets文件夹当中的图片一起读取，放置到内存中，便于管理
*
* */
public static void saveBitmapFromAssets(Context context, StarInfoBean starInfoBean){
    logoImgMap = new HashMap<>();
    contentlogoImgMap = new HashMap<>();

    List<StarInfoBean.StarinfoBean> starlist = starInfoBean.getStarinfo();
    for (int i=0;i<starlist.size();i++){
        String logoname = starlist.get(i).getLogoname();
        String filename = "xzlogo/"+logoname+".png";
        Bitmap logoBm = getBitmapFromAssets(context,filename);
        logoImgMap.put(logoname,logoBm);
        String contentName = "xzcontentlogo/"+logoname+".png";
        Bitmap bitmap = getBitmapFromAssets(context,contentName);
        contentlogoImgMap.put(logoname,bitmap);//强访问
    }
}
//  公共的访问方式
    public static Map<String, Bitmap> getLogoImgMap() {
        return logoImgMap;
    }

    public static Map<String, Bitmap> getContentlogoImgMap() {
        return contentlogoImgMap;
    }
}
