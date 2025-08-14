package com.example.ex133;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<com.example.ex132customlistview.phone> {
    Activity context;
    int IdLayout;
    ArrayList<com.example.ex132customlistview.phone> mylist;

    public MyArrayAdapter(Activity context, int IdLayout, ArrayList<com.example.ex132customlistview.phone> mylist) {
        super(context, IdLayout, mylist);
        this.context = context;
        this.IdLayout = IdLayout;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(IdLayout, null);

        ImageView imageView = convertView.findViewById(R.id.imgphone);
        imageView.setImageResource(mylist.get(position).getImagephone());

        TextView txtname = convertView.findViewById(R.id.txtnamephone);
        txtname.setText(mylist.get(position).getNamephone());

        return convertView;
    }
}