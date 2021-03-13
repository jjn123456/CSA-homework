package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    private Button btn3;
    private Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
         btn2 = (Button) findViewById(R.id.bt_2);
         btn2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(FirstActivity.this,"登录成功😀",Toast.LENGTH_SHORT).show();
                 Intent in = new Intent(FirstActivity.this,SecondActivity.class);
                 startActivity(in);
             }
         });

         btn3 = (Button) findViewById(R.id.bt_3);
         btn3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(FirstActivity.this,"开始注册~",Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(FirstActivity.this,ThridActivity.class);
                 startActivity(intent);
             }
         });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"这只是个简单的app界面",Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"好好享受自己的年轻岁月吧",Toast.LENGTH_LONG).show();
                break;
            default:
        }
        return true;
    }
}