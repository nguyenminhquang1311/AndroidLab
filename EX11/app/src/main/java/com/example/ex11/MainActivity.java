package com.example.ex11;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ex11.SecondActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextInput;
    private Button btnGoToSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editTextInput);
        btnGoToSecond = findViewById(R.id.btnGoToSecond);

        btnGoToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editTextInput.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("userInput", inputText);
                startActivity(intent);
            }
        });
    }
}