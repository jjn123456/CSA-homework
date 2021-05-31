package com.example.mykaoheapp;

// TODO: 2021/5/22 管理用户注册信息的工具类
public class Data {
    String[] userIDs = new String[100];//最多100次注册
    String[] passwords = new String[100];
    int size = 0;
    //注册方法
    public void putUser(String u,String p){
        userIDs[size] = u;
        passwords[size] = p;
        size++;
    }
    //登录判断方法
    public boolean login(String userID,String password){
        for(int i=0;i<size;i++){
            if((userIDs[i].equals(userID))&&(passwords[i].equals(password)) ){
                return true;
            }
        }
        return false;
    }
    private Data(){}//隐藏构造方法
    //变为一个静态类,然后再对外提供接口
    private static Data instance;
    public static Data getInstance(){
        if(instance == null){
            instance = new Data();
        }
        return instance;
    }
}
