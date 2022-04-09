package com.mn.myroutines;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlertDialogActionsViewHolder  extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textView;
    String [] names;
    ArrayList<SingleAlertDialogRow> arrayList;
    int i;


    public AlertDialogActionsViewHolder(@NonNull View itemView, final CustomListViewAdapterAlertDialog.onitemclickListener listener, ArrayList<SingleAlertDialogRow> arrayList) {
        super(itemView);




        this.textView = (TextView) itemView.findViewById(R.id.textViewActionDialog);
        this.imageView = (ImageView) itemView.findViewById(R.id.imageViewDialog);

        itemView.setOnClickListener(view -> {
            listener.onitemclick(arrayList.get(getAdapterPosition()), getAdapterPosition());
        });


    }


}
