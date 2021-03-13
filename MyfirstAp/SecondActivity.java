package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private TextView mtv4;
    private TextView mtv5;
    private TextView mtv6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        mtv4 = (TextView) findViewById(R.id.tv_4);
        mtv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        mtv4.getPaint().setAntiAlias(true);

        mtv5 = findViewById(R.id.tv_5);
        mtv5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        mtv6 = (TextView) findViewById(R.id.tv_6);
        mtv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this,"文字6被点击了",Toast.LENGTH_SHORT);
            }
        });
    }
}