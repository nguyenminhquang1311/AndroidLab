package com.example.bmi_caculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends Activity {
    EditText editten, editchieucao, editcannang, editBMI, editChandoan;
    Button btnTinhBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // liên kết giao diện XML

        // Ánh xạ các thành phần trong layout vào biến Java
        editten = findViewById(R.id.editten);
        editchieucao = findViewById(R.id.editchieucao);
        editcannang = findViewById(R.id.editcannang);
        editBMI = findViewById(R.id.editBMI);
        editChandoan = findViewById(R.id.editChandoan);
        btnTinhBMI = findViewById(R.id.btnTinhBMI);

        // Bắt sự kiện click vào nút "Tính BMI"
        btnTinhBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy chiều cao và cân nặng từ EditText và chuyển sang kiểu double
                double H = Double.parseDouble(editchieucao.getText().toString());
                double W = Double.parseDouble(editcannang.getText().toString());

                // Tính BMI theo công thức: BMI = W / (H^2)
                double BMI = W / Math.pow(H, 2);
                String chandoan = "";

                // Phân loại kết quả BMI
                if (BMI < 18) {
                    chandoan = "Bạn gầy";
                } else if (BMI <= 24.9) {
                    chandoan = "Bạn bình thường";
                } else if (BMI <= 29.9) {
                    chandoan = "Bạn béo phì độ 1";
                } else if (BMI <= 34.9) {
                    chandoan = "Bạn béo phì độ 2";
                } else {
                    chandoan = "Bạn béo phì độ 3";
                }

                // Định dạng và hiển thị kết quả
                DecimalFormat dcf = new DecimalFormat("#.0");
                editBMI.setText(dcf.format(BMI));
                editChandoan.setText(chandoan);
            }
        });
    }
}