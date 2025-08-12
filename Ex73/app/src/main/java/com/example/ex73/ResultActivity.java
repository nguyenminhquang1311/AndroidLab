package com.example.ex73;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {
    EditText edtAA, edtBB;
    Button btnsendtong, btnsendhieu;
    Intent myintent;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        edtAA = findViewById(R.id.edtAA);
        edtBB = findViewById(R.id.edtBB);
        btnsendtong = findViewById(R.id.btnsendtong);
        btnsendhieu = findViewById(R.id.btnsendhieu);

        // Nhận intent
        myintent = getIntent();
        int a = myintent.getIntExtra("soa", 0);
        int b = myintent.getIntExtra("sob", 0);

        // Hiển thị lại số để xác nhận
        edtAA.setText(String.valueOf(a));
        edtBB.setText(String.valueOf(b));

        // Trả về tổng
        btnsendtong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = a + b;
                myintent.putExtra("kq", sum);
                setResult(33, myintent);
                finish();
            }
        });

        // Trả về hiệu
        btnsendhieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sub = a - b;
                myintent.putExtra("kq", sub);
                setResult(34, myintent);
                finish();
            }
        });
    }
}