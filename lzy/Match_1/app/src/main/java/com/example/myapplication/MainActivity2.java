package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import SQL.SQL;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private EditText zcyhm;
    private EditText zcmm;
    private EditText zcqrmm;
    private EditText zcqq;
    private EditText zcsjh;
    private Button zc;
    private SQLiteOpenHelper sq1;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sq1 = new SQL(MainActivity2.this,"user_info",null,1);
        initView();
    }

    private void initView() {
        zcyhm = (EditText) findViewById(R.id.zcyhm);
        zcmm = (EditText) findViewById(R.id.zcmm);
        zcqrmm = (EditText) findViewById(R.id.zcqrmm);
        zcsjh = (EditText) findViewById(R.id.zcsjh);
        zc = (Button) findViewById(R.id.zc);
        zc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zc:
                submit();
                break;
        }
    }

    private void inittz(String zcyhmStrings, String zcmmStrings) {
            db=sq1.getReadableDatabase();
            ContentValues values =new ContentValues();
            values.put("user_name",zcyhmStrings);
            values.put("user_pad",zcmmStrings);
            db.insert("user_info",null,values);
            initcg();
        }

        private void initcg() {
            new AlertDialog.Builder(this)
                    .setTitle("提示")
                    .setMessage("注册成功")
                    .setPositiveButton("确定", new DatePickerDialog.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).show();
        }
    private void submit() {
        String zcyhmString = zcyhm.getText().toString().trim();
        if (TextUtils.isEmpty(zcyhmString)) {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String zcmmString = zcmm.getText().toString().trim();
        if (TextUtils.isEmpty(zcmmString)) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String zcsjhString = zcsjh.getText().toString().trim();
        if (TextUtils.isEmpty(zcsjhString)) {
            Toast.makeText(this, "QQ账号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String zcString = zc.getText().toString().trim();
        if (TextUtils.isEmpty(zcString)) {
            Toast.makeText(this, "手机号码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String zcqrmmString = zcqrmm.getText().toString().trim();
        if (TextUtils.isEmpty(zcqrmmString)) {
            Toast.makeText(this, "确认密码不能为空", Toast.LENGTH_SHORT).show();
        }else{
            String zcyhmStrings = zcqrmm.getText().toString().trim();
            String zcmmStrings = zcmm.getText().toString().trim();
            if (!zcyhmStrings.equals(zcmmStrings)){
                Toast.makeText(this, "密码不一致", Toast.LENGTH_SHORT).show();
            }else{
                inittz(zcyhmStrings,zcmmStrings);
            }

        }
    }
}