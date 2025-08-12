package com.example.temperaturechange;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edtdoC, edtdoF;
    Button btncf, btnfc, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần từ layout XML
        edtdoC = findViewById(R.id.edtdoC);
        edtdoF = findViewById(R.id.edtdoF);
        btncf = findViewById(R.id.btncf);       // Celsius -> Fahrenheit
        btnfc = findViewById(R.id.btnfc);       // Fahrenheit -> Celsius
        btnClear = findViewById(R.id.btnClear); // Xoá dữ liệu

        // Sự kiện chuyển từ độ C sang độ F
        btncf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00"); // Định dạng kết quả
                String doC = edtdoC.getText().toString(); // Lấy chuỗi nhập vào
                if (!doC.isEmpty()) {
                    int c = Integer.parseInt(doC); // Chuyển sang số nguyên
                    double f = c * 1.8 + 32;       // Công thức đổi C -> F
                    edtdoF.setText(dcf.format(f)); // Hiển thị kết quả
                }
            }
        });

        // Sự kiện chuyển từ độ F sang độ C
        btnfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                String doF = edtdoF.getText().toString();
                if (!doF.isEmpty()) {
                    int f = Integer.parseInt(doF);
                    double c = (f - 32) / 1.8; // Công thức đổi F -> C
                    edtdoC.setText(dcf.format(c));
                }
            }
        });

        // Sự kiện nút xóa cả hai ô nhập
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtdoC.setText("");
                edtdoF.setText("");
            }
        });
    }
}