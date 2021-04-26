package com.example.next_studymain;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private List<Food> mFoodList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView foodImage;
        TextView foodName;
        public ViewHolder(View view){
            super(view);
            foodImage = view.findViewById(R.id.food_image);
            foodName = view.findViewById(R.id.food_name);
        }
    }

    public FoodAdapter(List<Food> foodList){
        mFoodList = foodList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food food = mFoodList.get(position);
        holder.foodImage.setImageResource(food.getImageId());       //这里是food类的属性和方法
        holder.foodName.setText(food.getName());
    }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    }
}
