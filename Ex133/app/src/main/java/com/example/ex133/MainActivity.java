package com.example.ex133;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<com.example.ex132customlistview.phone> mylist;
    com.example.ex132customlistview.MyArrayAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        mylist = new ArrayList<>();

        mylist.add(new com.example.ex132customlistview.phone("Điện thoại Iphone", R.drawable.cellphone));
        mylist.add(new com.example.ex132customlistview.phone("Điện thoại SamSung", R.drawable.cellphone));
        mylist.add(new com.example.ex132customlistview.phone("Điện thoại Nokia", R.drawable.cellphone));
        mylist.add(new com.example.ex132customlistview.phone("Điện thoại HTC", R.drawable.cellphone));
        mylist.add(new com.example.ex132customlistview.phone("Điện thoại LG", R.drawable.cellphone));
        mylist.add(new com.example.ex132customlistview.phone("Điện thoại Sky", R.drawable.cellphone));
        mylist.add(new com.example.ex132customlistview.phone("Điện thoại WP", R.drawable.cellphone));

        myadapter = new com.example.ex132customlistview.MyArrayAdapter(MainActivity.this, R.layout.layout_listview, mylist);
        listView.setAdapter(myadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, com.example.ex132customlistview.subActivity.class);
                intent.putExtra("name", mylist.get(position).getNamephone());
                startActivity(intent);
            }
        });
    }
}