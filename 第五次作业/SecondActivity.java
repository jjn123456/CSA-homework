package com.example.next_studymain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button2 = findViewById(R.id.Secondbtn1);
        button2.setOnClickListener(new View.OnClickListener() { //通过一个匿名类来实现这个接口
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return","Hello FirstActivity!");
                setResult(RESULT_OK,intent);    //将数据传回去
                finish();
            }
        });

    }
}