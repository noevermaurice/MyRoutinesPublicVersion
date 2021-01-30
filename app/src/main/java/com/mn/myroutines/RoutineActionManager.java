package com.mn.myroutines;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.media.AudioManager;

public class RoutineActionManager {
    Context context;

    public RoutineActionManager(Context context) {
        this.context = context;
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


            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);

        } else if (routine.getRoutineSlot1() == 4) {

            am.setStreamVolume(

                    AudioManager.STREAM_MUSIC,
                    am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
                    0);
        } else if (routine.getRoutineSlot1() == 5) {


            am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        }  else if (routine.getRoutineSlot1() == 6){

            am.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.RINGER_MODE_VIBRATE, 0);
        }


        else if (routine.getRoutineSlot1() == 7) {
            am.setStreamVolume(

                    AudioManager.STREAM_RING,
                    am.getStreamMaxVolume(AudioManager.STREAM_RING),
                    0);
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


            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_TOGGLE_MUTE, 0);

        } else if (routine.getRoutineSlot2() == 4) {

            am.setStreamVolume(

                    AudioManager.STREAM_MUSIC,
                    am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
                    0);
        } else if (routine.getRoutineSlot2() == 5) {
            am.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
        } else if (routine.getRoutineSlot2() == 6) {
            am.setStreamVolume(

                    AudioManager.USE_DEFAULT_STREAM_TYPE,
                    am.getStreamMaxVolume(AudioManager.USE_DEFAULT_STREAM_TYPE),
                    0);
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


            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_TOGGLE_MUTE, 0);

        } else if (routine.getRoutineSlot3() == 4) {

            am.setStreamVolume(

                    AudioManager.STREAM_MUSIC,
                    am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
                    0);
        } else if (routine.getRoutineSlot3() == 5) {
            am.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
        } else if (routine.getRoutineSlot3() == 6) {
            am.setStreamVolume(

                    AudioManager.USE_DEFAULT_STREAM_TYPE,
                    am.getStreamMaxVolume(AudioManager.USE_DEFAULT_STREAM_TYPE),
                    0);
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


            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_TOGGLE_MUTE, 0);

        } else if (routine.getRoutineSlot4() == 4) {

            am.setStreamVolume(

                    AudioManager.STREAM_MUSIC,
                    am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
                    0);
        } else if (routine.getRoutineSlot4() == 5) {
            am.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
        } else if (routine.getRoutineSlot4() == 6) {
            am.setStreamVolume(

                    AudioManager.USE_DEFAULT_STREAM_TYPE,
                    am.getStreamMaxVolume(AudioManager.USE_DEFAULT_STREAM_TYPE),
                    0);
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

        } else if (routine.getRoutineSlot5() == 3) {


            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_TOGGLE_MUTE, 0);

        } else if (routine.getRoutineSlot5() == 4) {

            am.setStreamVolume(

                    AudioManager.STREAM_MUSIC,
                    am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
                    0);
        } else if (routine.getRoutineSlot5() == 5){
            am.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
        }
        else if (routine.getRoutineSlot5() == 6){
            am.setStreamVolume(

                    AudioManager.USE_DEFAULT_STREAM_TYPE,
                    am.getStreamMaxVolume(AudioManager.USE_DEFAULT_STREAM_TYPE),
                    0);
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


            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_TOGGLE_MUTE, 0);

        } else if (routine.getRoutineSlot6() == 4) {

            am.setStreamVolume(

                    AudioManager.STREAM_MUSIC,
                    am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
                    0);
        } else if (routine.getRoutineSlot6() == 5){
            am.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
        }
        else if (routine.getRoutineSlot6() == 6){
            am.setStreamVolume(

                    AudioManager.USE_DEFAULT_STREAM_TYPE,
                    am.getStreamMaxVolume(AudioManager.USE_DEFAULT_STREAM_TYPE),
                    0);
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


            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_TOGGLE_MUTE, 0);

        } else if (routine.getRoutineSlot7() == 4) {

            am.setStreamVolume(

                    AudioManager.STREAM_MUSIC,
                    am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
                    0);
        } else if (routine.getRoutineSlot7() == 5){
            am.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
        }
        else if (routine.getRoutineSlot7() == 6){
            am.setStreamVolume(

                    AudioManager.USE_DEFAULT_STREAM_TYPE,
                    am.getStreamMaxVolume(AudioManager.USE_DEFAULT_STREAM_TYPE),
                    0);
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

        } else if (routine.getRoutineSlot8() == 3) {


            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_TOGGLE_MUTE, 0);

        } else if (routine.getRoutineSlot8() == 4) {

            am.setStreamVolume(

                    AudioManager.STREAM_MUSIC,
                    am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
                    0);
        } else if (routine.getRoutineSlot8() == 5){
            am.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
        }
        else if (routine.getRoutineSlot8() == 6){
            am.setStreamVolume(

                    AudioManager.USE_DEFAULT_STREAM_TYPE,
                    am.getStreamMaxVolume(AudioManager.USE_DEFAULT_STREAM_TYPE),
                    0);
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


            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_TOGGLE_MUTE, 0);

        } else if (routine.getRoutineSlot9() == 4) {

            am.setStreamVolume(

                    AudioManager.STREAM_MUSIC,
                    am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
                    0);
        } else if (routine.getRoutineSlot9() == 5) {
            am.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_MUTE, 0);
            am.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
        }
        else if (routine.getRoutineSlot9() == 6){
            am.setStreamVolume(

                    AudioManager.USE_DEFAULT_STREAM_TYPE,
                    am.getStreamMaxVolume(AudioManager.USE_DEFAULT_STREAM_TYPE),
                    0);
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


            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_TOGGLE_MUTE, 0);

        } else if (routine.getRoutineSlot10() == 4) {

            am.setStreamVolume(

                    AudioManager.STREAM_MUSIC,
                    am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
                    0);
        } else if (routine.getRoutineSlot10() == 5){

        }
        else if (routine.getRoutineSlot10() == 6){
            am.setStreamVolume(

                    AudioManager.USE_DEFAULT_STREAM_TYPE,
                    am.getStreamMaxVolume(AudioManager.USE_DEFAULT_STREAM_TYPE),
                    0);
        }
    }
    }

















