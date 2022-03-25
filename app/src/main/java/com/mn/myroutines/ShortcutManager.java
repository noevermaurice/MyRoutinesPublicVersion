package com.mn.myroutines;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.io.Serializable;
import java.util.Random;

public class ShortcutManager {
    Activity activity;
    Context context;
    public boolean isSave;
    int randemID;
    Random random = new Random();
    Routine routine;
    RoutineManager routineManager;
    int routinePosition;
    String shotcutName;

    public ShortcutManager(Context context2, Activity activity2) {
        this.context = context2;
        this.activity = activity2;
        this.routineManager = new RoutineManager(context2);
    }

    public void AddShotcut(String shotcutName2, Routine routine2) {
        this.shotcutName = shotcutName2;
        this.routine = routine2;
        if (this.routineManager.getRoutineCount() != 0) {
            this.routinePosition = this.routineManager.routineList.size();
        } else {
            this.routinePosition = 0;
        }
        this.randemID = this.random.nextInt(this.routineManager.getRoutineCount() + 7759);
        int routinePosition2 = routine2.getRoutinePosition();
        Intent intent = new Intent(this.context, MainActivity.class).setAction("android.intent.action.MAIN");
        intent.putExtra("isShortcut", (Serializable) true);
        intent.putExtra("ShortcutPosition", routinePosition2);
        if (ShortcutManagerCompat.isRequestPinShortcutSupported(this.context)) {
            ShortcutManagerCompat.requestPinShortcut(this.context, new ShortcutInfoCompat.Builder(this.context, String.valueOf(this.randemID)).setIntent(intent).setShortLabel(shotcutName2).setIcon(IconCompat.createWithResource(this.context, R.drawable.ic_baseline_play_arrow_24)).build(), null);
            this.isSave = true;
            Context context2 = this.context;
            Toast.makeText(context2, context2.getString(R.string.AddRoutineToHomeScreen), Toast.LENGTH_SHORT).show();
            this.activity.finish();
        }
    }
}
