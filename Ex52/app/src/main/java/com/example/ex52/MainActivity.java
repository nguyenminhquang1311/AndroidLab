package com.example.ex52;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends Activity {
    Button btntieptuc, btngiai, btnthoat;
    EditText edita, editb, editc;
    TextView txtKQ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btntieptuc = findViewById(R.id.btntieptuc);
        btngiai = findViewById(R.id.btngiai);
        btnthoat = findViewById(R.id.btnthoat);

        edita = findViewById(R.id.edita);
        editb = findViewById(R.id.editb);
        editc = findViewById(R.id.editc);
        txtKQ = findViewById(R.id.txtKQ);

        DecimalFormat dcf = new DecimalFormat("0.00");

        btngiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sa = edita.getText().toString();
                String sb = editb.getText().toString();
                String sc = editc.getText().toString();

                int a = Integer.parseInt(sa);
                int b = Integer.parseInt(sb);
                int c = Integer.parseInt(sc);

                String kq = "";

                if (a == 0) {
                    if (b == 0) {
                        if (c == 0)
                            kq = "PT vô số nghiệm";
                        else
                            kq = "PT vô nghiệm";
                    } else {
                        kq = "PT có 1 nghiệm, x = " + dcf.format((double) -c / b);
                    }
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta < 0)
                        kq = "PT vô nghiệm";
                    else if (delta == 0)
                        kq = "Pt có nghiệm kép: x1 = x2 = " + dcf.format(-b / (2.0 * a));
                    else {
                        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                        kq = "Pt có 2 nghiệm: x1 = " + dcf.format(x1) + "; x2 = " + dcf.format(x2);
                    }
                }

                txtKQ.setText(kq);
            }
        });

        btntieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edita.setText("");
                editb.setText("");
                editc.setText("");
                txtKQ.setText("");
                edita.requestFocus();
            }
        });

        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}