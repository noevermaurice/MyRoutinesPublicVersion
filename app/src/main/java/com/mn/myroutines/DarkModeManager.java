package com.mn.myroutines;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatDelegate;

public class DarkModeManager {
    public static final int DAY = 1;
    public static final int DAY_NIGHT = -1;
    public static final int NIGHT = 2;
    SharedPreferences sharedPreferences;

    public DarkModeManager(Context context) {
        this.sharedPreferences = context.getSharedPreferences("DarkMode", 0);
        setMode(getMode());
    }

    public void setMode(int mode) {
        AppCompatDelegate.setDefaultNightMode(mode);
        this.sharedPreferences.edit().putInt("mode", mode).apply();
    }

    public int getMode() {
        return this.sharedPreferences.getInt("mode", 1);
    }
}
