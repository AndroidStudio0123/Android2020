package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
PopupWindow popupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void initss (View v){
        View xianshi = getLayoutInflater().inflate(R.layout.xcd,null,false);
        popupWindow = new PopupWindow(xianshi, ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT,true);
        popupWindow.showAsDropDown(findViewById(R.id.button111));
        Button button1 = xianshi.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"你点击了发起群聊",Toast.LENGTH_SHORT).show();
            }
        });
        Button button2 = xianshi.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"你点击了添加好友",Toast.LENGTH_SHORT).show();
            }
        });
        Button button3 = xianshi.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"你点击了扫一扫",Toast.LENGTH_SHORT).show();
            }
        });
        Button button4 = xianshi.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"你点击了收付款",Toast.LENGTH_SHORT).show();
            }
        });
        Button button5 = xianshi.findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"你点击了帮助与反馈",Toast.LENGTH_SHORT).show();
            }
        });
        Button button6 = xianshi.findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"你点击了时间选择提醒设置",Toast.LENGTH_SHORT).show();
            }
        });

    }
}