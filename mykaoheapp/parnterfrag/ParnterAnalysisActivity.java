package com.example.mykaoheapp.parnterfrag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.mykaoheapp.R;
import com.example.mykaoheapp.utils.AssetsUtils;
import com.example.mykaoheapp.utils.HttpUtils;
import com.example.mykaoheapp.utils.URLContent;
import com.google.gson.Gson;

import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class ParnterAnalysisActivity extends AppCompatActivity {
    TextView manTv,womanTv,peiduiTv,vsTv,pingfenTv,bizhongTv,jiexiTv,zhiyiTv;
    TextView titleTv;
    CircleImageView manIv,womanIv;
    ImageView backIv;
    ScrollView mySv;
    private String man_name,man_logoname;
    private String woman_name,woman_logoname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parnter_analysis);
        initView();
        //接收上一个页面传递的数值
        getLastData();

        //获取网络的路径地址
        String parnterURL = URLContent.getParnterURL(man_name,woman_name);
        //开一个子线程执行网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                //封装了一步网络请求，这里直接得到json数据
                String json = HttpUtils.getJSONfromNet(parnterURL);

                if(!TextUtils.isEmpty(json)){//判断不为空
                    //对gson进行反序列化
                   ParnterAnalysisBean analysisBean = new Gson().fromJson(json,ParnterAnalysisBean.class);
                   ParnterAnalysisBean.ResultBean resultBean = analysisBean.getResult();
                   runOnUiThread(new Runnable() {
                        @Override
                        public void run() { // 切换主线程
                            pingfenTv.setText("配对评分: " + resultBean.getZhishu()+" "+resultBean.getJieguo());
                            bizhongTv.setText("星座比重: "+resultBean.getBizhong());
                            jiexiTv.setText("解析:\n"+resultBean.getLianai());
                            zhiyiTv.setText("注意事项:\n"+resultBean.getZhuyi());
                        }
                   });
                }
            }
        }).start();
    }

    private void getLastData() {
        Intent in = getIntent();
        man_name = in.getStringExtra("man_name");
        man_logoname = in.getStringExtra("man_logoname");
        woman_name = in.getStringExtra("woman_name");
        woman_logoname = in.getStringExtra("woman_logoname");
        //设置不用联网就能显示的数据
        Map<String, Bitmap> contentlogoImgMap = AssetsUtils.getContentlogoImgMap();
        Bitmap manBitmap = contentlogoImgMap.get(man_logoname);
        manIv.setImageBitmap(manBitmap);
        Bitmap womanBitmap = contentlogoImgMap.get(woman_logoname);
        womanIv.setImageBitmap(womanBitmap);

        manTv.setText(man_name);
        womanTv.setText(woman_name);
        peiduiTv.setText("星座配对-"+man_name+"和"+woman_name+"配对~");
        vsTv.setText(man_name+" vs "+woman_name);
    }

    private void initView() {
        manIv = findViewById(R.id.parnteranalysis_iv_man);
        womanIv = findViewById(R.id.parnteranalysis_iv_woman);
        backIv = findViewById(R.id.title_iv_back);
        manTv = findViewById(R.id.parnteranalysis_tv_man);
        womanTv = findViewById(R.id.parnteranalysis_tv_woman);
        peiduiTv = findViewById(R.id.parnteranalysis_tv_pd);
        vsTv = findViewById(R.id.parnteranalysis_tv_vs);
        pingfenTv = findViewById(R.id.parnteranalysis_tv_pf);
        bizhongTv = findViewById(R.id.parnteranalysis_tv_bz);
        jiexiTv = findViewById(R.id.parnteranalysis_tv_jx);
        zhiyiTv = findViewById(R.id.parnteranalysis_tv_zy);
        titleTv = findViewById(R.id.title_tv);
        mySv = findViewById(R.id.parnteralalysis_sv);
    }
}