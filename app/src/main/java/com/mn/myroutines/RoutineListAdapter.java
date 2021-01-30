package com.mn.myroutines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RoutineListAdapter extends RecyclerView.Adapter<RoutineViewHolder> {
    // decalrtion of Object;
    RoutineManager routineManager;
    Context context;

    public RoutineListAdapter(RoutineManager routineManager, Context context) {
        this.routineManager = routineManager;
        this.context = context;

    }
    private onitemclickListener listener;

    @NonNull
    @Override
    public RoutineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate Layout
        return new RoutineViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.routine_row, parent, false),listener);
    }

    @Override
    public void onBindViewHolder(@NonNull final RoutineViewHolder holder, int position) {
        // get Routine from Routine Manger with the position
        final Routine routine = routineManager.routineList.get(position);

        // set name
        holder.textViewRoutineHeadline.setText(routine.getRoutineName());

        holder.imageViewPlayRoutine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               RoutineActionManager routineActionManager = new RoutineActionManager(context);
               routineActionManager.startRoutine(routine);


            }
        });

        // set Remove Button

        holder.deleteRoutine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // remove the Routine
                routineManager.removeRoutine(routine);
                // update the Adapter with the position
                notifyItemRemoved(holder.getAdapterPosition());

            }
        });

    }

    protected interface onitemclickListener {

        void onitemclick(int position, Routine routine);
    }

    protected void SetOnItemclickListener(onitemclickListener listener) {
        this.listener = listener;

    }


    @Override
    public int getItemCount() {
        return routineManager.routineList.size();
    }
}
