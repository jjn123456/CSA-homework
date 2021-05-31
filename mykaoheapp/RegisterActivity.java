package com.example.mykaoheapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        signup = findViewById(R.id.Register_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = ((EditText)findViewById(R.id.zhuce_id)).getText().toString();
                String secret = ((EditText)findViewById(R.id.zhuce_secret)).getText().toString();
                if(id.length()<6||secret.length()<6){
                    Toast.makeText(RegisterActivity.this,"账号或者密码长度不够",Toast.LENGTH_LONG).show();
                }else{
                    Data.getInstance().putUser(id,secret);
                    Log.d("Register", "账号:"+id+"密码"+secret+"数组："+String.valueOf(Data.getInstance().size));
                    Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}