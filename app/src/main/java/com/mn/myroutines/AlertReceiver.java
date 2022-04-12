package com.mn.myroutines;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlertReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        int randemAlarmReqestint = intent.getIntExtra("randemAlarmReqest", 7759);
        int routinePosition = intent.getIntExtra("routinePosition", 0);
        Log.d("AlertReceiver", "position" + routinePosition);
        boolean notSwipping = intent.getBooleanExtra("NotSwipping", false);
        boolean isNoVibration = intent.getBooleanExtra("routineGetIsNoVibration", false);
        boolean isShortVibration = intent.getBooleanExtra("routineGetIsShortVibration", false);
        boolean isMediumVibration = intent.getBooleanExtra("routineGetIsMediumVibration", false);
        boolean isLongVibration = intent.getBooleanExtra("routineGetIsLongVibration", false);
       String routineName= intent.getStringExtra("routineGetName");
        RoutineManager routineManager = new RoutineManager(context);
        RoutineActionManager routineActionManager = new RoutineActionManager(context, new MainActivity());
        if (!isNoVibration && !isShortVibration && !isMediumVibration && !isLongVibration && !notSwipping) {
            NotificationHelper notifactionHelper = new NotificationHelper(context, intent);
            notifactionHelper.getManager().notify(randemAlarmReqestint, notifactionHelper.getChannelNotfaction(intent).build());
            routineActionManager.startRoutine(routineManager.getRoutineList().get(routinePosition));
        }
        if (isNoVibration) {
            NotificationHelper notifactionHelper2 = new NotificationHelper(context, intent);
            notifactionHelper2.getManager().notify(randemAlarmReqestint, notifactionHelper2.getChannelNotfactionOreoNo(intent).build());
        } else if (isShortVibration) {
            NotificationHelper notifactionHelper3 = new NotificationHelper(context, intent);
            notifactionHelper3.getManager().notify(randemAlarmReqestint, notifactionHelper3.getChannelNotfactionOreoShort(intent).build());
        } else if (isMediumVibration) {
            NotificationHelper notifactionHelper4 = new NotificationHelper(context, intent);
            notifactionHelper4.getManager().notify(randemAlarmReqestint, notifactionHelper4.getChannelNotfactionOreoMedium(intent).build());
        } else if (isLongVibration) {
            NotificationHelper notifactionHelper5 = new NotificationHelper(context, intent);
            notifactionHelper5.getManager().notify(randemAlarmReqestint, notifactionHelper5.getChannelNotfactionOreoLong(intent).build());
        }
    }
}
