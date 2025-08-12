package com.example.ex6;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtten, edtCMND, edtBosung;
    CheckBox chkdoba, chkdosach, chkdocode;
    Button btnsend;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtten = findViewById(R.id.edtten);
        edtCMND = findViewById(R.id.edtcmnd);
        edtBosung = findViewById(R.id.edtbosung);
        chkdoba = findViewById(R.id.chkdoba);
        chkdosach = findViewById(R.id.chkdosach);
        chkdocode = findViewById(R.id.chkdocode);
        btnsend = findViewById(R.id.btnsend);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInformation();
            }
        });
        group = findViewById(R.id.idgroup);

        // Cấu hình OnBackPressedDispatcher
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Question");
                builder.setMessage("Are you sure you want to exit?");
                builder.setPositiveButton("Yes", (dialog, which) -> finish());
                builder.setNegativeButton("No", (dialog, which) -> dialog.cancel());
                builder.create().show();
            }
        });
    }

    public void showInformation() {
        String ten_hop_le = edtten.getText().toString().trim();
        if (ten_hop_le.length() < 3) {
            edtten.requestFocus();
            Toast.makeText(this, "Tên phải > 3 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        String cmnd_hop_le = edtCMND.getText().toString().trim();
        if (cmnd_hop_le.length() != 9) {
            edtCMND.requestFocus();
            Toast.makeText(this, "CMND phải đúng 9 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        String bang_cap = "";
        int id = group.getCheckedRadioButtonId();
        if (id != -1) {
            RadioButton rad = findViewById(id);
            bang_cap = rad.getText().toString().trim();
            if (chkdoba.isChecked()) bang_cap += "\n" + "Đọc báo";
            if (chkdosach.isChecked()) bang_cap += "\n" + "Đọc sách";
            if (chkdocode.isChecked()) bang_cap += "\n" + "Đọc coding";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", (dialog, which) -> dialog.cancel());
        builder.setMessage("Tên: " + ten_hop_le + "\n" +
                "CMND: " + cmnd_hop_le + "\n" +
                "Bằng cấp: " + bang_cap + "\n" +
                "Thông tin bổ sung: " + edtBosung.getText().toString().trim());
        builder.create().show();
    }
}