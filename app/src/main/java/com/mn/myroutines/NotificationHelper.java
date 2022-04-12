package com.mn.myroutines;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {
    public static final String channelId = "channelId";
    public static final String channelIdLong = "channelIdLong";
    public static final String channelIdMedium = "channelIdMedium";
    public static final String channelIdNo = "channelIdNO";
    public static final String channelIdNotSwiping = "channelIdNotSwipping";
    public static final String channelIdShort = "channelIdShort";
    public String TaskReminder = getString(R.string.NotificationSmallText);
    public String chnnelName = getString(R.string.TaskNotificationChannelName);
    public String getChannelIdNo = getString(R.string.TaskNotificationChannelNameNo);
    public String getChannelIdShort = getString(R.string.TaskNotificationChannelNameShort);
    public String getChannelIdMedium = getString(R.string.TaskNotificationChannelNameMedium);
    public String getChannelIdLong = getString(R.string.TaskNotificationChannelNameLong);
    private NotificationManager mManger;
    public long vibrationTime;

    public NotificationHelper(Context base, Intent intent) {
        super(base);
        if (Build.VERSION.SDK_INT >= 26) {
            String taskMessage = intent.getStringExtra("routineGetName");
            boolean isLongVibration = intent.getBooleanExtra("routineGetIsLongVibration", false);
            boolean isNoVibration = intent.getBooleanExtra("routineGetIsNoVibration", false);
            boolean notSwipping = intent.getBooleanExtra("NotSwipping", false);
            intent.getIntExtra("ScrollToTask", 0);
            boolean isShortVibration = intent.getBooleanExtra("routineGetIsShortVibration", false);
            boolean isMediumVibration = intent.getBooleanExtra("routineGetIsMediumVibration", false);
            if (isNoVibration) {
                createChannelNO();
            }
            if (!isNoVibration && !isShortVibration && !isMediumVibration && !isLongVibration && !notSwipping) {
                createChannel();
            }
            if (isShortVibration) {
                createChannelShort();
            }
            if (isMediumVibration) {
                createChannelMedium();
            }
            if (isLongVibration) {
                createChannelLong();
            }
        }
    }

    public NotificationManager getManager() {
        if (this.mManger == null) {
            this.mManger = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return this.mManger;
    }

    public NotificationCompat.Builder getChannelNotfaction(Intent intent) {
        String taskMessage = intent.getStringExtra("routineGetName");
        int randemAlarmReqestInt = intent.getIntExtra("randemAlarmReqest", 7759);
        int position = intent.getIntExtra("routinePosition", 0);
        boolean isLongVibration = intent.getBooleanExtra("routineGetIsLongVibration", false);
        boolean isNoVibration = intent.getBooleanExtra("routineGetIsNoVibration", false);
        boolean isShortVibration = intent.getBooleanExtra("routineGetIsShortVibration", false);
        boolean isMediumVibration = intent.getBooleanExtra("routineGetIsMediumVibration", false);
        if (isNoVibration) {
            this.vibrationTime = 0;
        } else if (isShortVibration) {
            this.vibrationTime = 50;
        } else if (isMediumVibration) {
            this.vibrationTime = 250;
        } else if (isLongVibration) {
            this.vibrationTime = 1000;
        } else if (!isNoVibration && !isShortVibration && !isMediumVibration && !isLongVibration) {
            this.vibrationTime = 150;
        }
        Intent resultIntent = new Intent(this, MainActivity.class);
        resultIntent.putExtra("CategoryPosition", 0);
        resultIntent.putExtra("notificationText", taskMessage);
        resultIntent.putExtra("notificationSerach", true);
        resultIntent.putExtra("routinePosition", position);
        resultIntent.putExtra("Notification", 1);
        return new NotificationCompat.Builder(getApplicationContext(), channelId).setContentTitle(taskMessage).setContentText(this.TaskReminder).setVibrate(new long[]{0, this.vibrationTime, 0, 0, 0}).setPriority(2).setSmallIcon(R.drawable.ic_baseline_play_arrow_24).setAutoCancel(true).setContentIntent(PendingIntent.getActivity(this, randemAlarmReqestInt, resultIntent, PendingIntent.FLAG_CANCEL_CURRENT));
    }

    public NotificationCompat.Builder getChannelNotfactionOreoNo(Intent intent) {
        String taskMessage = intent.getStringExtra("routineGetName");
        int randemAlarmReqestInt = intent.getIntExtra("randemAlarmReqest", 7759);
        int position = intent.getIntExtra("routinePosition", 0);
        boolean isLongVibration = intent.getBooleanExtra("routineGetIsLongVibration", false);
        boolean isNoVibration = intent.getBooleanExtra("routineGetIsNoVibration", false);
        boolean isShortVibration = intent.getBooleanExtra("routineGetIsShortVibration", false);
        boolean isMediumVibration = intent.getBooleanExtra("routineGetIsMediumVibration", false);
        if (isNoVibration) {
            this.vibrationTime = 0;
        } else if (isShortVibration) {
            this.vibrationTime = 50;
        } else if (isMediumVibration) {
            this.vibrationTime = 250;
        } else if (isLongVibration) {
            this.vibrationTime = 1000;
        } else if (!isNoVibration && !isShortVibration && !isMediumVibration && !isLongVibration) {
            this.vibrationTime = 150;
        }
        Intent resultIntent = new Intent(this, MainActivity.class);
        resultIntent.putExtra("CategoryPosition", 0);
        resultIntent.putExtra("notificationText", taskMessage);
        resultIntent.putExtra("notificationSerach", true);
        resultIntent.putExtra("routinePosition", position);
        resultIntent.putExtra("Notification", 1);
        return new NotificationCompat.Builder(getApplicationContext(), channelIdNo).setStyle(new NotificationCompat.DecoratedCustomViewStyle()).setVibrate(new long[]{0, this.vibrationTime, 0, 0, 0}).setPriority(2).setSmallIcon(R.drawable.ic_baseline_play_arrow_24).setAutoCancel(true).setContentIntent(PendingIntent.getActivity(this, randemAlarmReqestInt, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT));
    }

    public NotificationCompat.Builder getChannelNotfactionOreoShort(Intent intent) {
        String taskMessage = intent.getStringExtra("routineGetName");
        int randemAlarmReqestInt = intent.getIntExtra("randemAlarmReqest", 7759);
        int position = intent.getIntExtra("routinePosition", 0);
        boolean isLongVibration = intent.getBooleanExtra("routineGetIsLongVibration", false);
        boolean isNoVibration = intent.getBooleanExtra("routineGetIsNoVibration", false);
        boolean isShortVibration = intent.getBooleanExtra("routineGetIsShortVibration", false);
        boolean isMediumVibration = intent.getBooleanExtra("routineGetIsMediumVibration", false);
        if (isNoVibration) {
            this.vibrationTime = 0;
        } else if (isShortVibration) {
            this.vibrationTime = 50;
        } else if (isMediumVibration) {
            this.vibrationTime = 250;
        } else if (isLongVibration) {
            this.vibrationTime = 1000;
        } else if (!isNoVibration && !isShortVibration && !isMediumVibration && !isLongVibration) {
            this.vibrationTime = 150;
        }
        Intent resultIntent = new Intent(this, MainActivity.class);
        resultIntent.putExtra("CategoryPosition", 0);
        resultIntent.putExtra("notificationText", taskMessage);
        resultIntent.putExtra("notificationSerach", true);
        resultIntent.putExtra("routinePosition", position);
        resultIntent.putExtra("Notification", 1);
        return new NotificationCompat.Builder(getApplicationContext(), channelIdShort).setStyle(new NotificationCompat.DecoratedCustomViewStyle()).setVibrate(new long[]{0, this.vibrationTime, 0, 0, 0}).setPriority(2).setSmallIcon(R.drawable.ic_baseline_play_arrow_24).setAutoCancel(true).setContentIntent(PendingIntent.getActivity(this, randemAlarmReqestInt, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT));
    }

    public NotificationCompat.Builder getChannelNotfactionOreoMedium(Intent intent) {
        String taskMessage = intent.getStringExtra("routineGetName");
        int randemAlarmReqestInt = intent.getIntExtra("randemAlarmReqest", 7759);
        int position = intent.getIntExtra("routinePosition", 0);
        boolean isLongVibration = intent.getBooleanExtra("routineGetIsLongVibration", false);
        boolean isNoVibration = intent.getBooleanExtra("routineGetIsNoVibration", false);
        boolean isShortVibration = intent.getBooleanExtra("routineGetIsShortVibration", false);
        boolean isMediumVibration = intent.getBooleanExtra("routineGetIsMediumVibration", false);
        if (isNoVibration) {
            this.vibrationTime = 0;
        } else if (isShortVibration) {
            this.vibrationTime = 50;
        } else if (isMediumVibration) {
            this.vibrationTime = 250;
        } else if (isLongVibration) {
            this.vibrationTime = 1000;
        } else if (!isNoVibration && !isShortVibration && !isMediumVibration && !isLongVibration) {
            this.vibrationTime = 150;
        }
        Intent resultIntent = new Intent(this, MainActivity.class);
        resultIntent.putExtra("CategoryPosition", 0);
        resultIntent.putExtra("notificationText", taskMessage);
        resultIntent.putExtra("notificationSerach", true);
        resultIntent.putExtra("routinePosition", position);
        resultIntent.putExtra("Notification", 1);
        return new NotificationCompat.Builder(getApplicationContext(), channelIdMedium).setStyle(new NotificationCompat.DecoratedCustomViewStyle()).setVibrate(new long[]{0, this.vibrationTime, 0, 0, 0}).setPriority(2).setSmallIcon(R.drawable.ic_baseline_play_arrow_24).setAutoCancel(true).setContentIntent(PendingIntent.getActivity(this, randemAlarmReqestInt, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT));
    }

    public NotificationCompat.Builder getChannelNotfactionOreoNotSwipping(Intent intent) {
        String taskMessage = intent.getStringExtra("routineGetName");
        int randemAlarmReqestInt = intent.getIntExtra("randemAlarmReqest", 7759);
        int position = intent.getIntExtra("routinePosition", 0);
        boolean isLongVibration = intent.getBooleanExtra("routineGetIsLongVibration", false);
        boolean isNoVibration = intent.getBooleanExtra("routineGetIsNoVibration", false);
        boolean isShortVibration = intent.getBooleanExtra("routineGetIsShortVibration", false);
        boolean isMediumVibration = intent.getBooleanExtra("routineGetIsMediumVibration", false);
        if (isNoVibration) {
            this.vibrationTime = 0;
        } else if (isShortVibration) {
            this.vibrationTime = 75;
        } else if (isMediumVibration) {
            this.vibrationTime = 250;
        } else if (isLongVibration) {
            this.vibrationTime = 1000;
        } else if (!isNoVibration && !isShortVibration && !isMediumVibration && !isLongVibration) {
            this.vibrationTime = 150;
        }
        Intent resultIntent = new Intent(this, MainActivity.class);
        resultIntent.putExtra("CategoryPosition", 0);
        resultIntent.putExtra("notificationText", taskMessage);
        resultIntent.putExtra("notificationSerach", true);
        resultIntent.putExtra("routinePosition", position);
        resultIntent.putExtra("Notification", 1);
        return new NotificationCompat.Builder(getApplicationContext(), channelIdNotSwiping).setStyle(new NotificationCompat.DecoratedCustomViewStyle()).setVibrate(new long[]{0, this.vibrationTime, 0, 0, 0}).setPriority(2).setOngoing(true).setSmallIcon(R.drawable.ic_baseline_play_arrow_24).setAutoCancel(true).setContentIntent(PendingIntent.getActivity(this, randemAlarmReqestInt, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT));
    }

    public NotificationCompat.Builder getChannelNotfactionOreoLong(Intent intent) {
        String taskMessage = intent.getStringExtra("routineGetName");
        int randemAlarmReqestInt = intent.getIntExtra("randemAlarmReqest", 7759);
        int position = intent.getIntExtra("routinePosition", 0);
        boolean isLongVibration = intent.getBooleanExtra("routineGetIsLongVibration", false);
        boolean isNoVibration = intent.getBooleanExtra("routineGetIsNoVibration", false);
        boolean isShortVibration = intent.getBooleanExtra("routineGetIsShortVibration", false);
        boolean isMediumVibration = intent.getBooleanExtra("routineGetIsMediumVibration", false);
        if (isNoVibration) {
            this.vibrationTime = 0;
        } else if (isShortVibration) {
            this.vibrationTime = 75;
        } else if (isMediumVibration) {
            this.vibrationTime = 250;
        } else if (isLongVibration) {
            this.vibrationTime = 1000;
        } else if (!isNoVibration && !isShortVibration && !isMediumVibration && !isLongVibration) {
            this.vibrationTime = 150;
        }
        Intent resultIntent = new Intent(this, MainActivity.class);
        resultIntent.putExtra("CategoryPosition", 0);
        resultIntent.putExtra("notificationText", taskMessage);
        resultIntent.putExtra("notificationSerach", true);
        resultIntent.putExtra("routinePosition", position);
        resultIntent.putExtra("Notification", 1);
        return new NotificationCompat.Builder(getApplicationContext(), channelIdLong).setStyle(new NotificationCompat.DecoratedCustomViewStyle()).setVibrate(new long[]{0, this.vibrationTime, 0, 0, 0}).setPriority(2).setSmallIcon(R.drawable.ic_baseline_play_arrow_24).setAutoCancel(true).setContentIntent(PendingIntent.getActivity(this, randemAlarmReqestInt, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT));
    }

    private void createChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(channelId, this.chnnelName, NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{0, 150, 0, 0, 0});
            notificationChannel.setLightColor(R.color.colorPrimary);
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            notificationChannel.setImportance(NotificationManager.IMPORTANCE_HIGH);
            getManager().createNotificationChannel(notificationChannel);
        }
    }

    private void createChannelNO() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannelNo = new NotificationChannel(channelIdNo, this.getChannelIdNo, NotificationManager.IMPORTANCE_HIGH);
            notificationChannelNo.enableLights(true);
            notificationChannelNo.enableVibration(true);
            notificationChannelNo.setVibrationPattern(new long[]{0, 0, 0, 0, 0});
            notificationChannelNo.setLightColor(R.color.colorPrimary);
            notificationChannelNo.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            notificationChannelNo.setImportance(NotificationManager.IMPORTANCE_HIGH);
            getManager().createNotificationChannel(notificationChannelNo);
        }
    }

    private void createChannelShort() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannelShort = new NotificationChannel(channelIdShort, this.getChannelIdShort, NotificationManager.IMPORTANCE_HIGH);
            notificationChannelShort.enableLights(true);
            notificationChannelShort.enableVibration(true);
            notificationChannelShort.setVibrationPattern(new long[]{0, 75, 0, 0, 0});
            notificationChannelShort.setLightColor(R.color.colorPrimary);
            notificationChannelShort.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            notificationChannelShort.setImportance(NotificationManager.IMPORTANCE_HIGH);
            getManager().createNotificationChannel(notificationChannelShort);
        }
    }

    private void createChannelMedium() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannelMedium = new NotificationChannel(channelIdMedium, this.getChannelIdMedium, NotificationManager.IMPORTANCE_HIGH);
            notificationChannelMedium.enableLights(true);
            notificationChannelMedium.enableVibration(true);
            notificationChannelMedium.setVibrationPattern(new long[]{0, 250, 0, 0, 0});
            notificationChannelMedium.setLightColor(R.color.colorPrimary);
            notificationChannelMedium.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            notificationChannelMedium.setImportance(NotificationManager.IMPORTANCE_HIGH);
            getManager().createNotificationChannel(notificationChannelMedium);
        }
    }

    private void createChannelLong() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannelLong = new NotificationChannel(channelIdLong, this.getChannelIdLong, NotificationManager.IMPORTANCE_HIGH);
            notificationChannelLong.enableLights(true);
            notificationChannelLong.enableVibration(true);
            notificationChannelLong.setVibrationPattern(new long[]{0, 1000, 0, 0, 0});
            notificationChannelLong.setLightColor(R.color.colorPrimary);
            notificationChannelLong.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            notificationChannelLong.setImportance(NotificationManager.IMPORTANCE_HIGH);
            getManager().createNotificationChannel(notificationChannelLong);
        }
    }
}
