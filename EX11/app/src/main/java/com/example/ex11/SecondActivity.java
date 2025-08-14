package com.example.ex11;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView textViewResult;
    private Button btnOpenBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewResult = findViewById(R.id.textViewResult);
        btnOpenBrowser = findViewById(R.id.btnOpenBrowser);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String userInput = intent.getStringExtra("userInput");
        if (userInput != null) {
            textViewResult.setText("Dữ liệu từ MainActivity: " + userInput);
        }

        // Xử lý Intent Implicit để mở trình duyệt
        btnOpenBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(browserIntent);
            }
        });
    }
}