package com.example.mykaoheapp.starfrag;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.mykaoheapp.R;
import com.example.mykaoheapp.bean.StarInfoBean;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

// TODO: 2021/5/20
//星座Fragment包括viewpager 和 Gridview
public class StarFragment extends Fragment {
    ViewPager starVp;
    GridView starGv;
    LinearLayout pointLayout;
    private List<StarInfoBean.StarinfoBean> mDatas;
    private StarBaseAdapter starBaseAdapter;
    private StarPagerAdapter starPagerAdapter;
    int[] imgIds = {R.mipmap.xingzhuo,R.mipmap.zuozhe};
    List<ImageView> ivList;
    List<ImageView> pointList;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what==1){
                int currentItem = starVp.getCurrentItem();
                if(currentItem==ivList.size()-1){
                    starVp.setCurrentItem(0);
                }else{
                    currentItem++;
                    starVp.setCurrentItem(currentItem);
                }
            }
            //上面只形成了 图片的循环，所以说下面来实现消息的循环
            handler.sendEmptyMessageDelayed(1,5000);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_star, container, false);
        initView(view);
        Bundle bundle = getArguments();
        StarInfoBean infoBean = (StarInfoBean) bundle.getSerializable("info");
        //获取关于星座信息的集合数据
        mDatas =  infoBean.getStarinfo();
        //创建适配器
        starBaseAdapter = new StarBaseAdapter(getContext(),mDatas);
        starGv.setAdapter(starBaseAdapter);
        initPager();
        setVPListener();
        setGVListener();
        handler.sendEmptyMessageDelayed(1,5000);
        return view;
    }
    //设置Gridview的监听事件函数
    private void setGVListener() {
        starGv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StarInfoBean.StarinfoBean bean = mDatas.get(position);
                Intent in = new Intent(getContext(),StarAnalysisActivity.class);
                in.putExtra("star",bean);
                startActivity(in);
            }
        });
    }

    private void initPager(){
        ivList = new ArrayList<>();
        pointList = new ArrayList<>();
        for (int i=0;i<imgIds.length;i++){
            ImageView iv = new ImageView(getContext());
            iv.setImageResource(imgIds[i]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            //设置图片view的宽高
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
            iv.setLayoutParams(lp);
            ivList.add(iv);

            //创建图片对应的指示器小圆点
            ImageView piv = new ImageView(getContext());
            piv.setImageResource(R.mipmap.point_normal);
            LinearLayout.LayoutParams plp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            plp.setMargins(20,0,0,0);
            piv.setLayoutParams(plp);
            //将小圆点添加到布局当中
            pointLayout.addView(piv);
            //为了便于操作，将小圆点添加到统一的管理集合中
            pointList.add(piv);
        }
        pointList.get(0).setImageResource(R.mipmap.point_focus);
        starPagerAdapter = new StarPagerAdapter(getContext(),ivList);
        starVp.setAdapter(starPagerAdapter);
    }
    /*设置viewpager的监听器函数*/
    private void setVPListener(){
        starVp.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                for (int i=0;i<pointList.size();i++){
                    pointList.get(i).setImageResource(R.mipmap.point_normal);
                }
                pointList.get(position).setImageResource(R.mipmap.point_focus);
            }
        });
    }

    private void initView(View view) {//初始化控件操作
        starVp = (ViewPager)view.findViewById(R.id.starfrag_vp);
        starGv = (GridView)view.findViewById(R.id.starfrag_gv);
        pointLayout = view.findViewById(R.id.starfrag_layout);
    }
}