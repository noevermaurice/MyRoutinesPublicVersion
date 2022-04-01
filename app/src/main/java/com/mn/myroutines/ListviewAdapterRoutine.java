package com.mn.myroutines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class ListviewAdapterRoutine extends ArrayAdapter<String> {
    ArrayList<String> arrayListSlots = new ArrayList<>();
    Context context;
    DarkModeManager darkModeManager;

    ListviewAdapterRoutine(Context context2, ArrayList<String> arrayListSlots2, DarkModeManager darkModeManager2) {
        super(context2, (int) R.layout.custom_list_view_row, (int) R.id.textViewAction, arrayListSlots2);
        this.context = context2;
        this.darkModeManager = darkModeManager2;
        this.arrayListSlots = arrayListSlots2;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        this.darkModeManager = new DarkModeManager(getContext());
        View row = ((LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custom_list_view_row, parent, false);
        TextView textView = (TextView) row.findViewById(R.id.textViewAction);
        textView.setText(this.arrayListSlots.get(position));
        if (this.darkModeManager.getMode() == 1) {
            textView.setTextColor(getContext().getResources().getColor(R.color.black_white));
            notifyDataSetChanged();
        } else if (this.darkModeManager.getMode() == 2) {
            textView.setTextColor(getContext().getResources().getColor(R.color.white_black));
            notifyDataSetChanged();
        }
        return row;
    }
}
