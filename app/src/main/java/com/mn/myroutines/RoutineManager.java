package com.mn.myroutines;

import android.content.Context;
import com.orhanobut.hawk.Hawk;
import java.util.ArrayList;

public class RoutineManager {
    ArrayList<Routine> routineList;

    public RoutineManager(Context context) {
        Hawk.init(context).build();
        loadRoutineList();
    }

    public void addRoutine(Routine routine) {
        this.routineList.add(routine);
        saveRoutineList();
    }

    public void removeRoutine(Routine routine) {
        this.routineList.remove(routine);
        saveRoutineList();
    }

    public ArrayList<Routine> getRoutineList() {
        return this.routineList;
    }

    public void saveRoutineList() {
        Hawk.put("routineList", this.routineList);
    }

    public void loadRoutineList() {
        this.routineList = (ArrayList) Hawk.get("routineList", new ArrayList());
    }

    public int getRoutineCount() {
        return this.routineList.size();
    }
}
