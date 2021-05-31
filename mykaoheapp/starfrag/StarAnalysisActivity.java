package com.example.mykaoheapp.starfrag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mykaoheapp.R;
import com.example.mykaoheapp.bean.StarInfoBean;
import com.example.mykaoheapp.utils.AssetsUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class StarAnalysisActivity extends AppCompatActivity implements View.OnClickListener{
    TextView titleTv;
    ImageView backIv;
    CircleImageView iconTv;
    TextView nameTv,dataTv;
    ListView analysisLv;
    StarInfoBean.StarinfoBean bean;
    private Map<String, Bitmap> contentlogoImgMap;
    private TextView footertv;//list底部布局中需要改变的
    private AnalysisBaseAdapter adapter;
    List<StarAnalysisBean>mDatas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_analysis);
        //获取上一级界面传入的数据
        Intent intent = getIntent();
        bean = (StarInfoBean.StarinfoBean) intent.getSerializableExtra("star");
        initView();
        //初始化显示listview
        mDatas = new ArrayList<>();
        adapter = new AnalysisBaseAdapter(mDatas,this);
        analysisLv.setAdapter(adapter);
        //添加数据到集合当中
        addDataToList();
    }

    private void addDataToList() {
        StarAnalysisBean sab1 = new StarAnalysisBean("性格特点:",bean.getTd(),R.color.blue);
        StarAnalysisBean sab2 = new StarAnalysisBean("掌管宫位:",bean.getGw(),R.color.pink);
        StarAnalysisBean sab3 = new StarAnalysisBean("显阴阳性:",bean.getYy(), R.color.teal_200);
        StarAnalysisBean sab9 = new StarAnalysisBean("最大特征:",bean.getTz(), R.color.lightred);
        StarAnalysisBean sab4 = new StarAnalysisBean("主管星球:",bean.getZg(), R.color.purple_200);
        StarAnalysisBean sab5 = new StarAnalysisBean("幸运颜色:",bean.getYs(), R.color.lightgreen);
        StarAnalysisBean sab6 = new StarAnalysisBean("搭配珠宝:",bean.getZb(), R.color.orange);
        StarAnalysisBean sab7 = new StarAnalysisBean("幸运号码:",bean.getHm(), android.R.color.holo_purple);
        StarAnalysisBean sab8 = new StarAnalysisBean("相配金属:",bean.getJs(), R.color.lightblue);
        mDatas.add(sab1);
        mDatas.add(sab2);
        mDatas.add(sab3);
        mDatas.add(sab4);
        mDatas.add(sab5);
        mDatas.add(sab6);
        mDatas.add(sab7);
        mDatas.add(sab8);
        mDatas.add(sab9);
        //数据源发生了变化，提示适配器更新
        adapter.notifyDataSetChanged();
    }

    private void initView(){
        titleTv = findViewById(R.id.title_tv);
        backIv = findViewById(R.id.title_iv_back);
        iconTv = findViewById(R.id.staranalysis_iv);
        nameTv = findViewById(R.id.staranalysis_tv_name);
        dataTv = findViewById(R.id.staranalysis_tv_data);
        analysisLv = findViewById(R.id.staranalysis_lv);

        //位listview添加了底部布局
        View footerView = LayoutInflater.from(this).inflate(R.layout.footer_star_analysis,null);
        analysisLv.addFooterView(footerView);
        footertv = footerView.findViewById(R.id.footerstar_tv_info);
        //将数据进行显示

        titleTv.setText("星座详情");
        backIv.setOnClickListener(this);
        nameTv.setText(bean.getName());
        dataTv.setText(bean.getDate());
        contentlogoImgMap = AssetsUtils.getContentlogoImgMap();
        Bitmap bitmap = contentlogoImgMap.get(bean.getLogoname());
        iconTv.setImageBitmap(bitmap);
        footertv.setText(bean.getInfo());
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}