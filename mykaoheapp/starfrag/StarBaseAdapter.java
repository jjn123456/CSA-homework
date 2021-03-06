package com.example.mykaoheapp.starfrag;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mykaoheapp.R;
import com.example.mykaoheapp.bean.StarInfoBean;
import com.example.mykaoheapp.utils.AssetsUtils;

import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class StarBaseAdapter extends BaseAdapter {
    Context context;
    List<StarInfoBean.StarinfoBean> mDatas;
    Map<String, Bitmap> logoMap;
    public StarBaseAdapter(Context context,List<StarInfoBean.StarinfoBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        logoMap = AssetsUtils.getLogoImgMap();
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_star_gv,null);
            //将xml布局转换为view对象
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            //然后交给自己写的Viewholder
            holder = (ViewHolder) convertView.getTag();

        }
        //获取指定位置的数据
        StarInfoBean.StarinfoBean bean = mDatas.get(position);
        holder.tv.setText(bean.getName());
        //获得图片的名称，根据名称在内存中进行查找
        String logoname = bean.getLogoname();
        Bitmap bitmap = logoMap.get(logoname);
        holder.iv.setImageBitmap(bitmap);
        return convertView;
    }

    class ViewHolder{
        CircleImageView iv;
        TextView tv;
        public ViewHolder(View view){
            //利用converview对象，找到布局中的组件,
            iv = view.findViewById(R.id.item_star_iv);
            tv = view.findViewById(R.id.item_star_tv);
        }
    }
}
