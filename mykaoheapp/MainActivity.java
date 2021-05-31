package com.example.mykaoheapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.mykaoheapp.bean.StarInfoBean;
import com.example.mykaoheapp.parnterfrag.ParnterFragment;
import com.example.mykaoheapp.starfrag.StarFragment;
import com.example.mykaoheapp.utils.AssetsUtils;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    RadioGroup mainRg;
    private FragmentManager manager;
    Fragment starFrag,parnterFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainRg = findViewById(R.id.main_rg);
        //设置点击事件的监听
        mainRg.setOnCheckedChangeListener(this);
        /*加载星座相关的数据assets/xzcontent/xzcontent.json */
        StarInfoBean infoBean = loadData();
        Bundle bundle = new Bundle();
        bundle.putSerializable("info",infoBean);

        //TODO: 创建fragment对象 创建待添加的碎片实例
        starFrag = new StarFragment();
        starFrag.setArguments(bundle);
        parnterFrag = new ParnterFragment();
        parnterFrag.setArguments(bundle);
        //将四个fragment进行动态加载，一起加载到布局中
        addFragment();
    }
//  读取Assets文件下的xzcontent文件夹下的xzcontent.json
    private StarInfoBean loadData() {
        String json = AssetsUtils.getJsonFromAssets(this,"xzcontent/xzcontent.json");
        Gson gson = new Gson();
        StarInfoBean infoBean = gson.fromJson(json,StarInfoBean.class);
        AssetsUtils.saveBitmapFromAssets(this,infoBean);
        return infoBean;
    }

    // *将主页当中的碎片一起加载进入布局，有用的显示，无用的隐藏*/
    private void addFragment() {
        //TODO: 获取FragmentManager，直接调用getSupportFragmentManager()方法
        manager = getSupportFragmentManager();
        //TODO: 开启一个事务，通过调用beginTransaction
        FragmentTransaction transaction = manager.beginTransaction();
        //3.将2个Fragment统一的添加到main布局中的线性布局中
        transaction.add(R.id.main_layout_center,starFrag);
        transaction.add(R.id.main_layout_center,parnterFrag);
        //4.隐藏后面的1个gragment
        transaction.hide(parnterFrag);
        //TODO: 提交碎片改变后的事物
        transaction.commit();
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = manager.beginTransaction();
        switch(checkedId){
            case R.id.main_rb_star:
                transaction.hide(parnterFrag);
                transaction.show(starFrag);
                break;
            case R.id.main_rb_parnter:
                transaction.hide(starFrag);
                transaction.show(parnterFrag);
                break;
        }
        transaction.commit();
    }
}