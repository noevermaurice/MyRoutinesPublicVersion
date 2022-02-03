package com.mn.myroutines;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.CountDownTimer;

public class RoutineActionManager {
    Context context;
    MainActivity mainActivity;
    RoutineSettingsManager routineSettingsManager;

    public RoutineActionManager(Context context2, MainActivity mainActivity2) {
        this.context = context2;
        this.mainActivity = mainActivity2;
        this.routineSettingsManager = new RoutineSettingsManager(context2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v1, resolved type: android.media.AudioManager */
    /* JADX DEBUG: Multi-variable search result rejected for r0v31, resolved type: android.net.wifi.WifiManager */
    /* JADX DEBUG: Multi-variable search result rejected for r0v82, resolved type: android.net.wifi.WifiManager */
    /* JADX DEBUG: Multi-variable search result rejected for r0v131, resolved type: android.net.wifi.WifiManager */
    /* JADX DEBUG: Multi-variable search result rejected for r0v180, resolved type: android.net.wifi.WifiManager */
    /* JADX DEBUG: Multi-variable search result rejected for r0v229, resolved type: android.net.wifi.WifiManager */
    /* JADX DEBUG: Multi-variable search result rejected for r0v278, resolved type: android.net.wifi.WifiManager */
    /* JADX DEBUG: Multi-variable search result rejected for r0v327, resolved type: android.net.wifi.WifiManager */
    /* JADX DEBUG: Multi-variable search result rejected for r0v376, resolved type: android.net.wifi.WifiManager */
    /* JADX DEBUG: Multi-variable search result rejected for r0v425, resolved type: android.net.wifi.WifiManager */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startRoutine(final com.mn.myroutines.Routine r23) {
        /*
        // Method dump skipped, instructions count: 4727
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mn.myroutines.RoutineActionManager.startRoutine(com.mn.myroutines.Routine):void");
    }

    public void startCoundown(final Routine routine) {
        new CountDownTimer(this.routineSettingsManager.getAppTime(), 1000) {
            /* class com.mn.myroutines.RoutineActionManager.AnonymousClass11 */

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                cancel();
                try {
                    RoutineActionManager.this.mainActivity.startActivity(RoutineActionManager.this.mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot1()));
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
