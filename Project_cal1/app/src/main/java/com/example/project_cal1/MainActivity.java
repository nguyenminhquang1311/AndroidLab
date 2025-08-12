package com.example.project_cal1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.project_cal1.R;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2;
    EditText edt3;
    Button btncong, btntru, btnnhan, btnchia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần giao diện
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        btncong = findViewById(R.id.btncong);
        btntru = findViewById(R.id.btntru);
        btnnhan = findViewById(R.id.btnnhan);
        btnchia = findViewById(R.id.btnchia);

        // Xử lý nút cộng
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0" + edt1.getText().toString());
                int b = Integer.parseInt("0" + edt2.getText().toString());
                edt3.setText("a + b = " + (a + b));
            }
        });

        // Xử lý nút trừ
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0" + edt1.getText().toString());
                int b = Integer.parseInt("0" + edt2.getText().toString());
                edt3.setText("a - b = " + (a - b));
            }
        });

        // Xử lý nút nhân
        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0" + edt1.getText().toString());
                int b = Integer.parseInt("0" + edt2.getText().toString());
                edt3.setText("a * b = " + (a * b));
            }
        });

        // Xử lý nút chia
        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0" + edt1.getText().toString());
                int b = Integer.parseInt("0" + edt2.getText().toString());
                if (b == 0) {
                    edt3.setText("B phải khác 0");
                } else {
                    edt3.setText("a / b = " + ((float) a / b));
                }
            }
        });
    }
}