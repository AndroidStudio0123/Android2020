package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.qrcode.QRCodeReader;

public class MainActivity extends AppCompatActivity {
    private EditText text;
    private Button button;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text =  findViewById(R.id.text);
        button = findViewById(R.id.button);
        image =  findViewById(R.id.image);
    }
    public void onclick (View view){
        String conmst = text.getText().toString();
        if (TextUtils.isEmpty(conmst)){
            Toast.makeText(MainActivity.this,"请输入文字",Toast.LENGTH_SHORT).show();
        }
        GenerateQrCode generateQrCode = new GenerateQrCode();
        Bitmap bitmap = generateQrCode.getBitmap(conmst);
        image.setImageBitmap(bitmap);

    }
}