package com.mn.myroutines;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RoutineViewHolder extends RecyclerView.ViewHolder{
        // decaltration of Objects
    TextView textViewRoutineHeadline;
    TextView textViewRoutineDecsription;
    ImageView imageViewPlayRoutine;
    ImageView deleteRoutine;
    RoutineManager routineManager;

    public RoutineViewHolder(@NonNull View itemView, final RoutineListAdapter.onitemclickListener listener) {
        super(itemView);
            routineManager = new RoutineManager(itemView.getContext());
        // search for views with id
        textViewRoutineHeadline = itemView.findViewById(R.id.textViewRoutineHeadline);
        textViewRoutineDecsription = itemView.findViewById(R.id.textViewRoutineDecsription);
        imageViewPlayRoutine =itemView.findViewById(R.id.imageViewPlayRoutine);
        deleteRoutine = itemView.findViewById(R.id.delteRoutine);

        textViewRoutineHeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener !=null){
                    if (getAdapterPosition()!= RecyclerView.NO_POSITION){
                        listener.onitemclick(routineManager.routineList.indexOf(routineManager.getRoutineList().get(getAdapterPosition())), routineManager.getRoutineList().get(getAdapterPosition()));
                    }
                }

            }

        });



    }
}
