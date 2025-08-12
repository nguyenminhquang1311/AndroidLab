package com.example.ex72;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edta, edtb;
    Button btnkq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edta = findViewById(R.id.txta);
        edtb = findViewById(R.id.txtb);
        btnkq = findViewById(R.id.btnketqua);

        btnkq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edta.getText().toString().isEmpty() || edtb.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập a và b", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    int a = Integer.parseInt(edta.getText().toString());
                    int b = Integer.parseInt(edtb.getText().toString());
                    Intent myintent = new Intent(MainActivity.this, com.example.learnbundle.ResultActivity.class);
                    Bundle bundle1 = new Bundle();
                    bundle1.putInt("soa", a);
                    bundle1.putInt("sob", b);
                    myintent.putExtra("mybackage", bundle1);
                    startActivity(myintent);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}