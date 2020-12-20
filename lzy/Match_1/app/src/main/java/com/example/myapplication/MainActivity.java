package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import SQL.SQL;

public class MainActivity extends AppCompatActivity {
Button button1,button2;
TextView textView;
EditText editText1,editText2;
SQLiteDatabase db2;
SQLiteOpenHelper sq1;
private EditText yhm;
private EditText mm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initid();
        initzc();
        initdl();
        initwjmm();
    }

    private void initdl() {
        String q = yhm.getText().toString();
        if (TextUtils.isEmpty(q)) {
            Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String w = mm.getText().toString();
        if (TextUtils.isEmpty(w)) {
            Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }else{
            intcg(q,w);
        }
    }

    private void intcg(final String q, final String w) {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq1 = new SQL(MainActivity.this,"user_info.db",null,1);  //实例化数据库
                db2 = sq1.getReadableDatabase(); //实例化获取
                Cursor cursor = db2.rawQuery("select * from user_info where user_name = ?",new String[]{q});//查询数据库内的值
                while (cursor.moveToNext()){      //判断数据与获取的密码是否正确
                    String pds = cursor.getString(cursor.getColumnIndex("user_pad"));
                    if (w.equals(pds)){
                        Intent intent =new Intent(MainActivity.this,MainActivity3.class);
                        startActivity(intent);
                    }else{
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("提示")
                                .setMessage("同志！你的账户或密码错误")
                                .setPositiveButton("知道了",null)
                                .show();
                    }
                }
            }
        });
    }

    private void initwjmm() {
        textView=findViewById(R.id.wjmm);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"忘记密码请联系管理员",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initzc() {
        button2=findViewById(R.id.zc);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    private void initid() {
        button1 = findViewById(R.id.dl);
        button2 = findViewById(R.id.zc);
        yhm = (EditText) findViewById(R.id.yhm);
        mm = (EditText) findViewById(R.id.mm);
    }
}
