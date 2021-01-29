package com.mn.myroutines;

import android.content.Context;

import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;

public class RoutineManager {

    ArrayList<Routine> routineList;

    public RoutineManager(Context context){
        Hawk.init(context).build();
        loadRoutineList();
    }

    public void addRoutine(Routine routine){
        // add new Routine to RoutineArraylist
        routineList.add(routine);
        // save changes of routineList
        saveRoutineList();
    }

    public void removeRoutine(Routine routine){
        // remove the Routine from the list
        routineList.remove(routine);
        // save changes of routineList
        saveRoutineList();
    }

    public ArrayList<Routine> getRoutineList(){
        return routineList;

    }

    public void saveRoutineList(){
        // save aray list
        Hawk.put("routineList", routineList);
    }

    public void loadRoutineList(){
        // load arraylist
        routineList = Hawk.get("routineList", new ArrayList<Routine>());
    }


}
