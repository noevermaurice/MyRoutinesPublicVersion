package com.mn.myroutines;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mn.myroutines.RoutineListAdapter;

public class RoutineViewHolder extends RecyclerView.ViewHolder {
    ImageView deleteRoutine;
    ImageView imageViewNotification;
    ImageView imageViewPlayRoutine;
    RoutineManager routineManager;
    TextView textViewAlarmDate;
    TextView textViewRoutineDecsription;
    TextView textViewRoutineHeadline;

    public RoutineViewHolder(View itemView, final RoutineListAdapter.onitemclickListener listener) {
        super(itemView);
        this.routineManager = new RoutineManager(itemView.getContext());
        this.textViewRoutineHeadline = (TextView) itemView.findViewById(R.id.textViewRoutineHeadline);
        this.textViewRoutineDecsription = (TextView) itemView.findViewById(R.id.textViewRoutineDecsription);
        this.textViewAlarmDate = (TextView) itemView.findViewById(R.id.textViewAarmDate);
        this.imageViewPlayRoutine = (ImageView) itemView.findViewById(R.id.imageViewPlayRoutine);
        this.deleteRoutine = (ImageView) itemView.findViewById(R.id.delteRoutine);
        this.imageViewNotification = (ImageView) itemView.findViewById(R.id.notifactionIcon);
        this.textViewRoutineHeadline.setOnClickListener(new View.OnClickListener() {
            /* class com.mn.myroutines.RoutineViewHolder.AnonymousClass1 */

            public void onClick(View v) {
                if (listener != null && RoutineViewHolder.this.getAdapterPosition() != -1) {
                    listener.onitemclick(RoutineViewHolder.this.routineManager.routineList.indexOf(RoutineViewHolder.this.routineManager.getRoutineList().get(RoutineViewHolder.this.getAdapterPosition())), RoutineViewHolder.this.routineManager.getRoutineList().get(RoutineViewHolder.this.getAdapterPosition()));
                }
            }
        });
    }
}
