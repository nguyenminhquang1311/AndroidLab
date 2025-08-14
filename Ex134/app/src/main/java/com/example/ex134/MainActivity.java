package com.example.ex134;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ex134.MyArrayAdapter;
import com.example.ex134.subActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static String[] arrayName = {"Ảnh 1", "Ảnh 2", "Ảnh 3", "Ảnh 4", "Ảnh 5", "Ảnh 6", "Ảnh 7", "Ảnh 8", "Ảnh 9", "Ảnh 10", "Ảnh 11", "Ảnh 12"};
    public static int[] imageName = {R.drawable.sample_image, R.drawable.sample_image, R.drawable.sample_image, R.drawable.sample_image, R.drawable.sample_image, R.drawable.sample_image, R.drawable.sample_image, R.drawable.sample_image, R.drawable.sample_image, R.drawable.sample_image, R.drawable.sample_image, R.drawable.sample_image};

    GridView gridViewDemo;
    //Sử dụng MyArrayAdapter thay thì ArrayAdapter
    MyArrayAdapter adapterDanhSach;
    ArrayList<Image> arrimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridViewDemo = (GridView) findViewById(R.id.gridView);
        arrimage = new ArrayList<Image>();
        //Khởi tạo đối tượng adapter và gán Data source
        adapterDanhSach = new MyArrayAdapter(MainActivity.this,
                R.layout.list_item, // lấy custom layout
                arrimage); //thiết lập data source

        gridViewDemo.setAdapter(adapterDanhSach);
        //Duyệt danh sách mảng dữ liệu
        for (int i = 0; i < imageName.length; i++) {
            Image myimage = new Image();
            myimage.setName(arrayName[i]);
            myimage.setImg(imageName[i]);
            arrimage.add(myimage);
            //gọi hàm cập nhật giao diện
            adapterDanhSach.notifyDataSetChanged();
        }

        //Viết sự kiện khi click vào đối tượng trong GridView
        gridViewDemo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                // TODO Auto-generated method stub
                //Khai báo Intent
                Intent intent1 = new Intent(MainActivity.this, subActivity.class);
                //Khai báo bundle và đưa dữ liệu vào Bundle, tham số arg2 chứa vị trí của phần tử
                //mà chúng ta click trong GridView
                Bundle bundle = new Bundle();
                bundle.putInt("TITHE", position);
                intent1.putExtras(bundle);
                startActivity(intent1);
            }
        });
    }
}