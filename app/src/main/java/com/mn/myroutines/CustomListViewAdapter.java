package com.mn.myroutines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomListViewAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> stringArrayList;
    int images[];
    LayoutInflater inflater;


    public CustomListViewAdapter(Context context, ArrayList<String> stringArrayList, int [] images){

                this.context = context;
                this.stringArrayList = stringArrayList;
                this.images = images;
                this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return stringArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.custom_list_view_row, null);
        TextView textView = view.findViewById(R.id.textViewAction);
        ImageView imageView = view.findViewById(R.id.imageViewSlot);
        textView.setText(stringArrayList.get(0));
        imageView.setImageResource(images[0]);
        return view;
    }
}
