package com.mn.myroutines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class ListviewAdapterRoutine extends ArrayAdapter<String> {
    ArrayList<String> arrayListSlots = new ArrayList<>();
    Context context;
    DarkModeManager darkModeManager;
    int images[];

    ListviewAdapterRoutine(Context context2, ArrayList<String> arrayListSlots2, DarkModeManager darkModeManager2, int [] images) {
        super(context2, (int) R.layout.custom_list_view_row, (int) R.id.textViewAction, arrayListSlots2);
        this.context = context2;
        this.darkModeManager = darkModeManager2;
        this.arrayListSlots = arrayListSlots2;
        this.images = images;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        this.darkModeManager = new DarkModeManager(getContext());
        View row = ((LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custom_list_view_row, parent, false);
        TextView textView = (TextView) row.findViewById(R.id.textViewAction);
        ImageView imageView = (ImageView) row.findViewById(R.id.imageViewSlot);
        textView.setText(this.arrayListSlots.get(position));
        imageView.setImageResource(images[0]);
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
