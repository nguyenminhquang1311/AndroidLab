package com.example.ex72;

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
    EditText edtkq;
    Button btnback;
    TextView txtketqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.acitivty_result);

        // Áp dụng padding cho các khu vực inset
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Khởi tạo các thành phần giao diện
        edtkq = findViewById(R.id.edtkq); // EditText để hiển thị kết quả
        btnback = findViewById(R.id.btnback);
        txtketqua = findViewById(R.id.txtketqua);

        // Lấy dữ liệu từ Intent
        Intent yourintent = getIntent();
        Bundle yourbundle = yourintent.getBundleExtra("mybackage");
        if (yourbundle != null) {
            int a = yourbundle.getInt("soa");
            int b = yourbundle.getInt("sob");
            String kq = "";
            if (a == 0 && b == 0) {
                kq = "Vô số nghiệm";
            } else if (a == 0 && b != 0) {
                kq = "Vô nghiệm";
            } else {
                DecimalFormat dc = new DecimalFormat("0.##");
                kq = dc.format(-b * 1.0 / a);
            }
            edtkq.setText(kq); // Hiển thị kết quả trong EditText
        }

        // Xử lý sự kiện nút Back
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Quay lại MainActivity
            }
        });
    }
}