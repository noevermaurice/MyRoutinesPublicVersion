package com.mn.myroutines;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomListViewAdapterAlertDialog extends RecyclerView.Adapter<RoutineViewHolder> {

    Context context;
    ArrayList<SingleAlertDialogRow> stringArrayList;


    public CustomListViewAdapterAlertDialog(Context context ){

                this.context = context;
                stringArrayList = new ArrayList<>();

        Resources resources = context.getResources();
        String[] names = resources.getStringArray(R.array.alertDialogActions);
        int[] images = {R.drawable.ic_baseline_not_interested_24,R.drawable.ic_baseline_bluetooth_disabled_24, R.drawable.ic_baseline_bluetooth_24, R.drawable.ic_baseline_volume_mute_24, R.drawable.ic_baseline_volume_up_24, R.drawable.ic_baseline_volume_mute_24, R.drawable.ic_baseline_volume_up_24, R.drawable.ic_baseline_vibration_24, R.drawable.ic_baseline_volume_up_24, R.drawable.ic_baseline_apps_24, R.drawable.ic_baseline_timer_24, R.drawable.ic_baseline_wifi_off_24, R.drawable.ic_baseline_wifi_24 };


        for (int i = 0; i<names.length; i++){
            stringArrayList.add(new SingleAlertDialogRow(names[i], images[i]));
        }
    }



    @NonNull
    @Override
    public RoutineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RoutineViewHolder holder, int position) {

    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return 0;
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
