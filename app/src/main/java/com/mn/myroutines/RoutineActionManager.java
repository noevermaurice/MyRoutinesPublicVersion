package com.mn.myroutines;

import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.AlarmClock;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import java.time.Clock;

public class RoutineActionManager {
    Context context;
    MainActivity mainActivity;

    public RoutineActionManager(Context context,MainActivity mainActivity ) {
        this.context = context;
        this.mainActivity = mainActivity;
    }

    public void startRoutine(Routine routine) {
        AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


        if (routine.getRoutineSlot1() == 0) {
            // do notthing

        } else if (routine.getRoutineSlot1() == 1) {
            if (bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.disable();
            }

        } else if (routine.getRoutineSlot1() == 2) {
            if (!bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.enable();
            }

        } else if (routine.getRoutineSlot1() == 3) {


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
            } else {
                am.adjustStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
            }

        } else if (routine.getRoutineSlot1() == 4) {

            am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);

        } else if (routine.getRoutineSlot1() == 5) {
            // ADJUST_Mute = Mutes the device, FLAG_SHOW_UI = show changes made to volume bar

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMinVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMinVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMinVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);


            }


        }  else if (routine.getRoutineSlot1() == 6){

        }


        else if (routine.getRoutineSlot1() == 7) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMaxVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_SYSTEM, am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);


            }

        } else if (routine.getRoutineSlot1() == 8){
            try {
                Intent intent = mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot1());
                mainActivity.startActivity(intent);

            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }

        } else if (routine.getRoutineSlot1() == 9){
            // start Timer and sert time
            Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER);
            // set Timer Name with routine Timer name
            intent.putExtra(AlarmClock.EXTRA_MESSAGE, routine.getTimerName());
            // set seconds of the Timer
            int seconds = routine.getTimerSeconds();
            // set Minutes of the Timer
            int minutes = routine.getTimerMinutes() * 60;
            // set Hour of timer
            int hour = routine.getTimerHours()*3600;
            // all together is the real time
            int allTime = seconds+minutes +hour;
            intent.putExtra(AlarmClock.EXTRA_LENGTH, allTime);
            context.startActivity(intent);
        } else if (routine.getRoutineSlot1() == 10){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
              Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

              context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(false);
            }
        } else if (routine.getRoutineSlot1() == 11){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(true);
            }
        }

        if (routine.getRoutineSlot2() == 0) {
            // do notthing

        } else if (routine.getRoutineSlot2() == 1) {
            if (bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.disable();
            }

        } else if (routine.getRoutineSlot2() == 2) {
            if (!bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.enable();
            }

        } else if (routine.getRoutineSlot2() == 3) {


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
            } else {
                am.adjustStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
            }

        } else if (routine.getRoutineSlot2() == 4) {

            am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);

        } else if (routine.getRoutineSlot2() == 5) {
            // ADJUST_Mute = Mutes the device, FLAG_SHOW_UI = show changes made to volume bar

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMinVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMinVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMinVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);


            }


        }  else if (routine.getRoutineSlot2() == 6){

        }


        else if (routine.getRoutineSlot2() == 7) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMaxVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_SYSTEM, am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);


            }

        }else if (routine.getRoutineSlot2() == 8){
            try {
                Intent intent = mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot2());
                mainActivity.startActivity(intent);

            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }

        } else if (routine.getRoutineSlot2() == 9){
            // start Timer and sert time
            Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER);
            // set Timer Name with routine Timer name
            intent.putExtra(AlarmClock.EXTRA_MESSAGE, routine.getTimerName());
            // set seconds of the Timer
            int seconds = routine.getTimerSeconds();
            // set Minutes of the Timer
            int minutes = routine.getTimerMinutes() * 60;
            // set Hour of timer
            int hour = routine.getTimerHours()*3600;
            // all together is the real time
            int allTime = seconds+minutes +hour;
            intent.putExtra(AlarmClock.EXTRA_LENGTH, allTime);
            context.startActivity(intent);
        } else if (routine.getRoutineSlot2() == 10){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(false);
            }
        } else if (routine.getRoutineSlot2() == 11){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(true);
            }
        }



        if (routine.getRoutineSlot3() == 0) {
            // do notthing

        } else if (routine.getRoutineSlot3() == 1) {
            if (bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.disable();
            }

        } else if (routine.getRoutineSlot3() == 2) {
            if (!bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.enable();
            }

        } else if (routine.getRoutineSlot3() == 3) {


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
            } else {
                am.adjustStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
            }

        } else if (routine.getRoutineSlot3() == 4) {

            am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);

        } else if (routine.getRoutineSlot3() == 5) {
            // ADJUST_Mute = Mutes the device, FLAG_SHOW_UI = show changes made to volume bar

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMinVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMinVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMinVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);


            }


        }  else if (routine.getRoutineSlot3() == 6){

        }


        else if (routine.getRoutineSlot3() == 7) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMaxVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_SYSTEM, am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);


            }


        }else if (routine.getRoutineSlot3() == 8){
            try {
                Intent intent = mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot3());
                mainActivity.startActivity(intent);

            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }

        } else if (routine.getRoutineSlot3() == 9){
            // start Timer and sert time
            Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER);
            // set Timer Name with routine Timer name
            intent.putExtra(AlarmClock.EXTRA_MESSAGE, routine.getTimerName());
            // set seconds of the Timer
            int seconds = routine.getTimerSeconds();
            // set Minutes of the Timer
            int minutes = routine.getTimerMinutes() * 60;
            // set Hour of timer
            int hour = routine.getTimerHours()*3600;
            // all together is the real time
            int allTime = seconds+minutes +hour;
            intent.putExtra(AlarmClock.EXTRA_LENGTH, allTime);
            context.startActivity(intent);
        }else if (routine.getRoutineSlot3() == 10){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(false);
            }
        } else if (routine.getRoutineSlot3() == 11){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(true);
            }
        }


        if (routine.getRoutineSlot4() == 0) {
            // do notthing

        } else if (routine.getRoutineSlot4() == 1) {
            if (bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.disable();
            }

        } else if (routine.getRoutineSlot4() == 2) {
            if (!bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.enable();
            }

        } else if (routine.getRoutineSlot4() == 3) {


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
            } else {
                am.adjustStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
            }

        } else if (routine.getRoutineSlot4() == 4) {

            am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);

        } else if (routine.getRoutineSlot4() == 5) {
            // ADJUST_Mute = Mutes the device, FLAG_SHOW_UI = show changes made to volume bar

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMinVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMinVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMinVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);


            }


        }  else if (routine.getRoutineSlot4() == 6){

        }


        else if (routine.getRoutineSlot4() == 7) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMaxVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_SYSTEM, am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);


            }

        } else if (routine.getRoutineSlot4() == 8){
            try {
                Intent intent = mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot4());
                mainActivity.startActivity(intent);

            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }

        } else if (routine.getRoutineSlot4() == 9){
            // start Timer and sert time
            Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER);
            // set Timer Name with routine Timer name
            intent.putExtra(AlarmClock.EXTRA_MESSAGE, routine.getTimerName());
            // set seconds of the Timer
            int seconds = routine.getTimerSeconds();
            // set Minutes of the Timer
            int minutes = routine.getTimerMinutes() * 60;
            // set Hour of timer
            int hour = routine.getTimerHours()*3600;
            // all together is the real time
            int allTime = seconds+minutes +hour;
            intent.putExtra(AlarmClock.EXTRA_LENGTH, allTime);
            context.startActivity(intent);
        }else if (routine.getRoutineSlot4() == 10){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(false);
            }
        } else if (routine.getRoutineSlot4() == 11){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(true);
            }
        }

        if (routine.getRoutineSlot5() == 0) {
            // do notthing

        } else if (routine.getRoutineSlot5() == 1) {
            if (bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.disable();
            }

        } else if (routine.getRoutineSlot5() == 2) {
            if (!bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.enable();
            }

        }else if (routine.getRoutineSlot5() == 3) {


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
            } else {
                am.adjustStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
            }

        } else if (routine.getRoutineSlot5() == 4) {

            am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);

        } else if (routine.getRoutineSlot5() == 5) {
            // ADJUST_Mute = Mutes the device, FLAG_SHOW_UI = show changes made to volume bar

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMinVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMinVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMinVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);


            }


        }  else if (routine.getRoutineSlot5() == 6){

        }


        else if (routine.getRoutineSlot5() == 7) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMaxVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_SYSTEM, am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);


            }

        } else if (routine.getRoutineSlot5() == 8){
            try {
                Intent intent = mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot5());
                mainActivity.startActivity(intent);

            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }

        } else if (routine.getRoutineSlot5() == 9){
            // start Timer and sert time
            Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER);
            // set Timer Name with routine Timer name
            intent.putExtra(AlarmClock.EXTRA_MESSAGE, routine.getTimerName());
            // set seconds of the Timer
            int seconds = routine.getTimerSeconds();
            // set Minutes of the Timer
            int minutes = routine.getTimerMinutes() * 60;
            // set Hour of timer
            int hour = routine.getTimerHours()*3600;
            // all together is the real time
            int allTime = seconds+minutes +hour;
            intent.putExtra(AlarmClock.EXTRA_LENGTH, allTime);
            context.startActivity(intent);
        }else if (routine.getRoutineSlot5() == 10){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(false);
            }
        } else if (routine.getRoutineSlot5() == 11){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(true);
            }
        }

        if (routine.getRoutineSlot6() == 0) {
            // do notthing

        } else if (routine.getRoutineSlot6() == 1) {
            if (bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.disable();
            }

        } else if (routine.getRoutineSlot6() == 2) {
            if (!bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.enable();
            }

        } else if (routine.getRoutineSlot6() == 3) {


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
            } else {
                am.adjustStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
            }

        } else if (routine.getRoutineSlot6() == 4) {

            am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);

        } else if (routine.getRoutineSlot6() == 5) {
            // ADJUST_Mute = Mutes the device, FLAG_SHOW_UI = show changes made to volume bar

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMinVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMinVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMinVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);


            }


        }  else if (routine.getRoutineSlot6() == 6){

        }


        else if (routine.getRoutineSlot6() == 7) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMaxVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_SYSTEM, am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);


            }

        } else if (routine.getRoutineSlot6() == 8){
            try {
                Intent intent = mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot6());
                mainActivity.startActivity(intent);

            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }

        } else if (routine.getRoutineSlot6() == 9){
            // start Timer and sert time
            Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER);
            // set Timer Name with routine Timer name
            intent.putExtra(AlarmClock.EXTRA_MESSAGE, routine.getTimerName());
            // set seconds of the Timer
            int seconds = routine.getTimerSeconds();
            // set Minutes of the Timer
            int minutes = routine.getTimerMinutes() * 60;
            // set Hour of timer
            int hour = routine.getTimerHours()*3600;
            // all together is the real time
            int allTime = seconds+minutes +hour;
            intent.putExtra(AlarmClock.EXTRA_LENGTH, allTime);
            context.startActivity(intent);
        }else if (routine.getRoutineSlot6() == 10){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(false);
            }
        } else if (routine.getRoutineSlot6() == 11){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(true);
            }
        }


        if (routine.getRoutineSlot7() == 0) {
            // do notthing

        } else if (routine.getRoutineSlot7() == 1) {
            if (bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.disable();
            }

        } else if (routine.getRoutineSlot7() == 2) {
            if (!bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.enable();
            }

        } else if (routine.getRoutineSlot7() == 3) {


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
            } else {
                am.adjustStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
            }

        } else if (routine.getRoutineSlot7() == 4) {

            am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);

        } else if (routine.getRoutineSlot7() == 5) {
            // ADJUST_Mute = Mutes the device, FLAG_SHOW_UI = show changes made to volume bar

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMinVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMinVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMinVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);


            }


        }  else if (routine.getRoutineSlot7() == 6){

        }


        else if (routine.getRoutineSlot7() == 7) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMaxVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_SYSTEM, am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);


            }

        }else if (routine.getRoutineSlot7() == 8){
            try {
                Intent intent = mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot7());
                mainActivity.startActivity(intent);

            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }

        } else if (routine.getRoutineSlot7() == 9){
            // start Timer and sert time
            Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER);
            // set Timer Name with routine Timer name
            intent.putExtra(AlarmClock.EXTRA_MESSAGE, routine.getTimerName());
            // set seconds of the Timer
            int seconds = routine.getTimerSeconds();
            // set Minutes of the Timer
            int minutes = routine.getTimerMinutes() * 60;
            // set Hour of timer
            int hour = routine.getTimerHours()*3600;
            // all together is the real time
            int allTime = seconds+minutes +hour;
            intent.putExtra(AlarmClock.EXTRA_LENGTH, allTime);
            context.startActivity(intent);
        } else if (routine.getRoutineSlot6() == 10){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(false);
            }
        } else if (routine.getRoutineSlot6() == 11){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(true);
            }
        }


        if (routine.getRoutineSlot8() == 0) {
            // do notthing

        } else if (routine.getRoutineSlot8() == 1) {
            if (bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.disable();
            }

        } else if (routine.getRoutineSlot8() == 2) {
            if (!bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.enable();
            }

        }else if (routine.getRoutineSlot8() == 3) {


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
            } else {
                am.adjustStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
            }

        } else if (routine.getRoutineSlot8() == 4) {

            am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);

        } else if (routine.getRoutineSlot8() == 5) {
            // ADJUST_Mute = Mutes the device, FLAG_SHOW_UI = show changes made to volume bar

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMinVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMinVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMinVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);


            }


        }  else if (routine.getRoutineSlot8() == 6){

        }


        else if (routine.getRoutineSlot8() == 7) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMaxVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_SYSTEM, am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);


            }

        }else if (routine.getRoutineSlot8() == 8){
            try {
                Intent intent = mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot8());
                mainActivity.startActivity(intent);

            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }

        } else if (routine.getRoutineSlot8() == 9){
            // start Timer and sert time
            Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER);
            // set Timer Name with routine Timer name
            intent.putExtra(AlarmClock.EXTRA_MESSAGE, routine.getTimerName());
            // set seconds of the Timer
            int seconds = routine.getTimerSeconds();
            // set Minutes of the Timer
            int minutes = routine.getTimerMinutes() * 60;
            // set Hour of timer
            int hour = routine.getTimerHours()*3600;
            // all together is the real time
            int allTime = seconds+minutes +hour;
            intent.putExtra(AlarmClock.EXTRA_LENGTH, allTime);
            context.startActivity(intent);
        } else if (routine.getRoutineSlot8() == 10){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(false);
            }
        } else if (routine.getRoutineSlot8() == 11){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(true);
            }
        }

        if (routine.getRoutineSlot9() == 0) {
            // do notthing

        } else if (routine.getRoutineSlot9() == 1) {
            if (bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.disable();
            }

        } else if (routine.getRoutineSlot9() == 2) {
            if (!bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.enable();
            }

        } else if (routine.getRoutineSlot9() == 3) {


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
            } else {
                am.adjustStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
            }

        } else if (routine.getRoutineSlot9() == 4) {

            am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);

        } else if (routine.getRoutineSlot9() == 5) {
            // ADJUST_Mute = Mutes the device, FLAG_SHOW_UI = show changes made to volume bar

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMinVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMinVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMinVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);


            }


        }  else if (routine.getRoutineSlot9() == 6){

        }


        else if (routine.getRoutineSlot9() == 7) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMaxVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_SYSTEM, am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);


            }

        }else if (routine.getRoutineSlot9() == 8){
            try {
                Intent intent = mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot9());
                mainActivity.startActivity(intent);

            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }

        } else if (routine.getRoutineSlot9() == 9){
            // start Timer and sert time
            Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER);
            // set Timer Name with routine Timer name
            intent.putExtra(AlarmClock.EXTRA_MESSAGE, routine.getTimerName());
            // set seconds of the Timer
            int seconds = routine.getTimerSeconds();
            // set Minutes of the Timer
            int minutes = routine.getTimerMinutes() * 60;
            // set Hour of timer
            int hour = routine.getTimerHours()*3600;
            // all together is the real time
            int allTime = seconds+minutes +hour;
            intent.putExtra(AlarmClock.EXTRA_LENGTH, allTime);
            context.startActivity(intent);
        }else if (routine.getRoutineSlot9() == 10){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(false);
            }
        } else if (routine.getRoutineSlot9() == 11){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(true);
            }
        }

        if (routine.getRoutineSlot10() == 0) {
            // do notthing

        } else if (routine.getRoutineSlot10() == 1) {
            if (bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.disable();
            }

        } else if (routine.getRoutineSlot10() == 2) {
            if (!bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.enable();
            }

        } else if (routine.getRoutineSlot10() == 3) {


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
            } else {
                am.adjustStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
            }

        } else if (routine.getRoutineSlot10() == 4) {

            am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);

        } else if (routine.getRoutineSlot10() == 5) {
            // ADJUST_Mute = Mutes the device, FLAG_SHOW_UI = show changes made to volume bar

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMinVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMinVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMinVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMinVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
                am.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);


            }


        }  else if (routine.getRoutineSlot10() == 6){

        }


        else if (routine.getRoutineSlot10() == 7) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_SYSTEM,  am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_ALARM, am.getStreamMaxVolume(AudioManager.STREAM_ALARM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);
            } else {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume( AudioManager.STREAM_MUSIC), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume( AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_SYSTEM, am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM), AudioManager.FLAG_SHOW_UI);
                am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_SHOW_UI);


            }

        }else if (routine.getRoutineSlot10() == 8){
            try {
                Intent intent = mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot10());
                mainActivity.startActivity(intent);

            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }

        } else if (routine.getRoutineSlot10() == 9){
            // start Timer and sert time
            Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER);
            // set Timer Name with routine Timer name
            intent.putExtra(AlarmClock.EXTRA_MESSAGE, routine.getTimerName());
            // set seconds of the Timer
            int seconds = routine.getTimerSeconds();
            // set Minutes of the Timer
            int minutes = routine.getTimerMinutes() * 60;
            // set Hour of timer
            int hour = routine.getTimerHours()*3600;
            // all together is the real time
            int allTime = seconds+minutes +hour;
            intent.putExtra(AlarmClock.EXTRA_LENGTH, allTime);
            context.startActivity(intent);
        } else if (routine.getRoutineSlot10() == 10){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(false);
            }
        } else if (routine.getRoutineSlot10() == 11){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Intent intent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                context.startActivity(intent);
            } else {
                WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(true);
            }
        }
    }
    }

















