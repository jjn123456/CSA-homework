package com.example.mykaoheapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LaunchActivity extends AppCompatActivity {
    Button launchbtn;
    Button registrebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launchactivity);
        launchbtn = findViewById(R.id.launch_btn);
        launchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(Data.getInstance().login(((EditText)findViewById(R.id.launch_id)).getText().toString(),
                        ((EditText)findViewById(R.id.launch_secret)).getText().toString()) ){
                    Intent in = new Intent(LaunchActivity.this,MainActivity.class);
                    Toast.makeText(LaunchActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                    startActivity(in);//跳转
                } */
                /*else {
                    Toast.makeText(LaunchActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                }*/
                if(Data.getInstance().login( ((EditText)findViewById(R.id.launch_id)).getText().toString(),
                        ((EditText)findViewById(R.id.launch_secret)).getText().toString()) ){
                    Intent in = new Intent(LaunchActivity.this,MainActivity.class);
                    Toast.makeText(LaunchActivity.this,"成功登录",Toast.LENGTH_SHORT).show();
                    startActivity(in);
                    Log.d("mmmmmMain", String.valueOf(Data.getInstance().size));
                }else{
                    Toast.makeText(LaunchActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
        registrebtn = findViewById(R.id.register_btn);
        registrebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LaunchActivity.this,"开始注册~",Toast.LENGTH_SHORT).show();
                Intent in = new Intent(LaunchActivity.this,RegisterActivity.class);
                startActivity(in);
            }
        });
    }

}

