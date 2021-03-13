package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThridActivity extends AppCompatActivity {

    private Button btnthrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thrid_layout);
        btnthrid = findViewById(R.id.bthrid_1);
        btnthrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThridActivity.this,"注册成功!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}