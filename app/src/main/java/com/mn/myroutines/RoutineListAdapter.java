package com.mn.myroutines;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

public class RoutineListAdapter extends RecyclerView.Adapter<RoutineViewHolder> {
    Context context;
    private onitemclickListener listener;
    MainActivity mainActivity;
    RoutineManager routineManager;

    /* access modifiers changed from: protected */
    public interface onitemclickListener {
        void onitemclick(int i, Routine routine);
    }

    public RoutineListAdapter(RoutineManager routineManager2, Context context2, MainActivity mainActivity2) {
        this.routineManager = routineManager2;
        this.context = context2;
        this.mainActivity = mainActivity2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RoutineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RoutineViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.routine_row, parent, false), this.listener);
    }

    public void onBindViewHolder(final RoutineViewHolder holder, int position) {
        final Routine routine = this.routineManager.routineList.get(position);
        holder.textViewRoutineHeadline.setText(routine.getRoutineName());
        holder.textViewRoutineDecsription.setText(routine.getDescriptionText());
        holder.imageViewNotification.setVisibility(4);
        Log.d("RoutineListAdapter", "routine alarm date" + routine.getRoutineAlarmDate());
        if (routine.getIsNotification()) {
            holder.imageViewNotification.setVisibility(0);
            holder.textViewAlarmDate.setVisibility(0);
            holder.textViewAlarmDate.setText(routine.getRoutineAlarmDate());
        } else {
            holder.imageViewNotification.setVisibility(4);
            holder.textViewAlarmDate.setVisibility(4);
        }
        holder.imageViewPlayRoutine.setOnClickListener(new View.OnClickListener() {
            /* class com.mn.myroutines.RoutineListAdapter.AnonymousClass1 */

            public void onClick(View view) {
                new RoutineActionManager(RoutineListAdapter.this.context, RoutineListAdapter.this.mainActivity).startRoutine(routine);
                Toast.makeText(RoutineListAdapter.this.context, RoutineListAdapter.this.context.getString(R.string.RoutineRun), 0).show();
            }
        });
        holder.deleteRoutine.setOnClickListener(new View.OnClickListener() {
            /* class com.mn.myroutines.RoutineListAdapter.AnonymousClass2 */

            public void onClick(View view) {
                RoutineListAdapter.this.routineManager.removeRoutine(routine);
                RoutineListAdapter.this.notifyItemRemoved(holder.getAdapterPosition());
            }
        });
    }

    /* access modifiers changed from: protected */
    public void SetOnItemclickListener(onitemclickListener listener2) {
        this.listener = listener2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.routineManager.routineList.size();
    }
}
