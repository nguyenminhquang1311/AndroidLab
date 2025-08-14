package com.example.ex133customgridview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ex134.MainActivity;

public class subActivity extends Activity {
    private Bundle extra;
    TextView txtname2;
    ImageView img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_layout);

        txtname2 = (TextView) findViewById(R.id.textName);
        img2 = (ImageView) findViewById(R.id.imgDetail);
        extra = getIntent().getExtras();
        int position = extra.getInt("TITHE");

        txtname2.setText(MainActivity.arrayName[position]);
        img2.setImageResource(MainActivity.imageName[position]);
    }
}