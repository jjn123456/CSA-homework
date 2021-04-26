package com.example.next_studymain;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Food> foodList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFoods();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LayoutManager);   //把上面这个实例传进来
        FoodAdapter adapter1 = new FoodAdapter(foodList);
        recyclerView.setAdapter(adapter1);              //关联数据
    }
    private void initFoods(){
        for(int i=0;i<2;i++){       //循环两次相当于有16个
            Food doughnut = new Food("Doughnut",R.drawable.doughnut);
            foodList.add(doughnut);
            Food cake = new Food("Cake",R.drawable.cake);
            foodList.add(cake);
            Food humburger = new Food("Humburger",R.drawable.humburger);
            foodList.add(humburger);
            Food drumstick = new Food("Drumstick",R.drawable.drumstick);
            foodList.add(drumstick);
            Food beer = new Food("Beer",R.drawable.beer);
            foodList.add(beer);
            Food cookie = new Food("Cookie",R.drawable.cookie);
            foodList.add(cookie);
            Food icecream = new Food("Ice-cream",R.drawable.icecream);
            foodList.add(icecream);
            Food snowcream = new Food("Snowcream",R.drawable.snowcream);
            foodList.add(snowcream);
        }
    }
}