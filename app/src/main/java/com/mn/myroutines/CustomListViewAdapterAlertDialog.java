package com.mn.myroutines;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomListViewAdapterAlertDialog extends RecyclerView.Adapter<AlertDialogActionsViewHolder> {

    Context context;
    ArrayList<SingleAlertDialogRow> stringArrayList;




    public CustomListViewAdapterAlertDialog(Context context, ArrayList<SingleAlertDialogRow> arrayList ){

        int[] images = {R.drawable.ic_baseline_not_interested_24,R.drawable.ic_baseline_bluetooth_disabled_24, R.drawable.ic_baseline_bluetooth_24, R.drawable.ic_baseline_volume_mute_24, R.drawable.ic_baseline_volume_up_24, R.drawable.ic_baseline_volume_mute_24, R.drawable.ic_baseline_volume_up_24, R.drawable.ic_baseline_vibration_24, R.drawable.ic_baseline_volume_up_24, R.drawable.ic_baseline_apps_24, R.drawable.ic_baseline_timer_24, R.drawable.ic_baseline_wifi_off_24, R.drawable.ic_baseline_wifi_24 };
                this.context = context;
               this.stringArrayList = arrayList;

               Log.d("t", "in list" + stringArrayList.size());













    }


    @NonNull
    @Override
    public AlertDialogActionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AlertDialogActionsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_view_row_dialog, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AlertDialogActionsViewHolder holder, int position) {

        SingleAlertDialogRow singleAlertDialogRow =  stringArrayList.get(holder.getAdapterPosition());



        holder.textView.setText(singleAlertDialogRow.string);
        holder.imageView.setImageResource(singleAlertDialogRow.images);






    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return stringArrayList.size();
    }

   /* @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.custom_list_view_row_dialog, null);
        TextView textView = view.findViewById(R.id.textViewActionDialog);
        ImageView imageView = view.findViewById(R.id.imageViewDialog);
        SingleAlertDialogRow singleAlertDialogRow =  stringArrayList.get(position);
        textView.setText(singleAlertDialogRow.string);
        imageView.setImageResource(singleAlertDialogRow.images);


        return view;
    }

    */
}
