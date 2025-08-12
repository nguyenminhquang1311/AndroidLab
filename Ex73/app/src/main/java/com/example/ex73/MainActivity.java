package com.example.ex73;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtKQ;
    Button btnrequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKQ);
        btnrequest = findViewById(R.id.btnrequest);

        btnrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo intent
                Intent myintent = new Intent(MainActivity.this, ResultActivity.class);

                // Lấy dữ liệu
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());

                // Truyền dữ liệu
                myintent.putExtra("soa", a);
                myintent.putExtra("sob", b);

                // Gửi và chờ kết quả trả về
                startActivityForResult(myintent, 99);
            }
        });
    }

    // Nhận kết quả trả về
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 99) {
            if (resultCode == 33) {
                int sum = data.getIntExtra("kq", 0);
                edtKQ.setText("Tổng 2 số là: " + sum);
            }
            if (resultCode == 34) {
                int sub = data.getIntExtra("kq", 0);
                edtKQ.setText("Hiệu 2 số là: " + sub);
            }
        }
    }
}