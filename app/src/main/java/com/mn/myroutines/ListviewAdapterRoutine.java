package com.mn.myroutines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListviewAdapterRoutine extends ArrayAdapter<String> {
    Context context;
   ArrayList<String> arrayListSlots = new ArrayList<>();


    ListviewAdapterRoutine(Context context, ArrayList<String> arrayListSlots ){
        super(context, R.layout.listview_action_row, R.id.listViewTitle, arrayListSlots);
        this.context = context;
      this.arrayListSlots = arrayListSlots;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.listview_action_row, parent, false);

        TextView textView = row.findViewById(R.id.listViewTitle);
        textView.setText(arrayListSlots.get(position));




        return row;
    }


}
