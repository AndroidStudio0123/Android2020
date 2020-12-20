package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.SimpleFormatter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox checkBox;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private Button tj;
    private List<CheckBox> checkList =new ArrayList<CheckBox>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkList.add(checkBox);
        checkList.add(checkBox2);
        checkList.add(checkBox3);
        checkList.add(checkBox4);
        tj = (Button) findViewById(R.id.tj);
        tj.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tj:
                StringBuffer stringBuffer = new StringBuffer();
                for (CheckBox checkBox : checkList){
                if (checkBox.isChecked()){
                    stringBuffer.append(checkBox.getText().toString());
                    Toast.makeText(getApplicationContext(), stringBuffer.toString(), Toast.LENGTH_SHORT).show();
                }
                }
                break;
        }
    }
}