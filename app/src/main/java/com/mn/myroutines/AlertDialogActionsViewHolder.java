package com.mn.myroutines;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AlertDialogActionsViewHolder  extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textView;
    String [] names;


    public AlertDialogActionsViewHolder(@NonNull View itemView) {
        super(itemView);




        this.textView = (TextView) itemView.findViewById(R.id.textViewActionDialog);
        this.imageView = (ImageView) itemView.findViewById(R.id.imageViewDialog);
    }
}
