package com.mn.myroutines;

import android.content.Context;
import android.content.SharedPreferences;

public class RoutineSettingsManager {
    long appTime;
    Context context;
    SharedPreferences sharedPreferences;
    long standardappTime = 7000;

    public RoutineSettingsManager(Context context2) {
        this.context = context2;
        this.sharedPreferences = context2.getSharedPreferences("appTime", 0);
        setAppTime(getAppTime());
    }

    public void setAppTime(long appTimethis) {
        this.appTime = appTimethis;
        this.sharedPreferences.edit().putLong("appTime", appTimethis).apply();
    }

    public long getAppTime() {
        return this.sharedPreferences.getLong("appTime", this.standardappTime);
    }
}
