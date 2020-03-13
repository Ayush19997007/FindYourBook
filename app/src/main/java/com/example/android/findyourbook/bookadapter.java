package com.example.android.findyourbook;


import android.app.Activity;
import android.icu.text.DecimalFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class bookadapter extends ArrayAdapter<four_data> {
    public bookadapter(Activity activity, ArrayList<four_data> passes_arraylist) {
        super(activity, 0, passes_arraylist);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.preview, parent, false);
        }
        four_data object = getItem(position);

        TextView textView1 = (TextView) view.findViewById(R.id.titleOfBook);
        //textView1.setText(object.bookTitle());
        textView1.setText("BOOK title is :" +object.bookTitle());
        TextView textView2 = (TextView) view.findViewById(R.id.publisherName);
        textView2.setText("PUBLISHER is "+(object.publisherName()));
        TextView textView3 = (TextView) view.findViewById(R.id.NoOfPages);
        textView3.setText("number of pages "+(object.noOfPages()));


        return view;
    }
}