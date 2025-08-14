package com.example.ex134;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Image> {
    Activity context = null;
    ArrayList<Image> myArray = null;
    int LayoutId;

    /**
     * Constructor này dùng để khởi tạo các giá trị từ MainActivity truyền vào
     * @param context : là Activity từ Main
     * @param LayoutId: là layout custom do ta tạo (listitem.xml)
     * @param arr : Danh sách đối tượng truyền từ Main
     */
    public MyArrayAdapter(Activity context, int LayoutId, ArrayList<Image> arr) {
        super(context, LayoutId, arr);
        this.context = context;
        this.LayoutId = LayoutId;
        this.myArray = arr;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(LayoutId, null);

        final Image myimage = myArray.get(position);

        // Dòng lệnh lấy ImageView ra để hiển thị hình ảnh
        final ImageView imgitem = (ImageView) convertView.findViewById(R.id.imageView);
        imgitem.setImageResource(myimage.getImg());

        // Dòng lệnh lấy TextView ra để hiển thị tên ảnh
        final TextView myname = (TextView) convertView.findViewById(R.id.textView);
        myname.setText(myimage.getName());

        return convertView;
    }
}