package com.mn.myroutines;

import android.content.Context;
import android.widget.ListView;

public class RoutineSlotManager {
    // Objects Deklartation
    ListView listView;
    Context context;
    ListviewAdapterRoutine listviewAdapterRoutine;
    public String ArrayListSlotDefault;
    int listviewItemPosition;
    public RoutineSlotManager(Context context,ListView listView, ListviewAdapterRoutine listviewAdapterRoutine, String ArrayListSlotDefault,int listviewItemPosition){
        //
        this.context = context;
        this.listView = listView;
        this.listviewAdapterRoutine = listviewAdapterRoutine;
        this.ArrayListSlotDefault = ArrayListSlotDefault;
        this.listviewItemPosition= listviewItemPosition;
    }

    public void setDefaultSlots(){
        // add Dedault array list
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listView.setAdapter(listviewAdapterRoutine);
    }

    public void setRoutineSlots(){




    }
}
