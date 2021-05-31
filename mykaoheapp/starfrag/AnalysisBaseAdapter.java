package com.example.mykaoheapp.starfrag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mykaoheapp.R;

import java.util.List;

public class AnalysisBaseAdapter extends BaseAdapter {
    List<StarAnalysisBean> mDatas;
    Context context;

    public AnalysisBaseAdapter(List<StarAnalysisBean> mDatas, Context context) {
        this.mDatas = mDatas;
        this.context = context;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_star_analysis,null);
            //把这个布局加入到缓存
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();
        StarAnalysisBean bean = mDatas.get(position);
        holder.titleTv.setText(bean.getTitle());
        holder.contentTv.setText(bean.getContent());
        holder.contentTv.setBackgroundResource(bean.getColor());
        return convertView;
    }
    class ViewHolder{
        TextView titleTv,contentTv;
        public ViewHolder(View view){
            titleTv = view.findViewById(R.id.itemstar_tv_title);
            contentTv = view.findViewById(R.id.itemstar_tv_content);

        }
    }
}
