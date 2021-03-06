package com.mn.myroutines;

import android.bluetooth.BluetoothAdapter;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.audiofx.Equalizer;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.util.Log;

public class RoutineActionManager {
    Context context;
    MainActivity mainActivity;
    RoutineSettingsManager routineSettingsManager;

    public RoutineActionManager(Context context2, MainActivity mainActivity2) {
        this.context = context2;
        this.mainActivity = mainActivity2;
        this.routineSettingsManager = new RoutineSettingsManager(context2);
    }



    public void startRoutine(final Routine routine) {

        AudioManager am = (AudioManager) this.context.getSystemService(Context.AUDIO_SERVICE);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        WifiManager wifiManager = (WifiManager) this.context.getSystemService(Context.WIFI_SERVICE);


        if (routine.getRoutineSlot1() == 0) {




        } else if (routine.getRoutineSlot1() == 1) {

            setBluetoothStateOn(bluetoothAdapter);

        } else if (routine.getRoutineSlot1() == 2) {

            setBluetoothStateOff(bluetoothAdapter);
        } else if (routine.getRoutineSlot1() == 3) {
            setMediaVolumeMute(am);

        } else if (routine.getRoutineSlot1() == 4) {

            setMediaVolumeMax(am);

        } else if (routine.getRoutineSlot1() == 5) {

            setVolumeMute(am);

        } else if (routine.getRoutineSlot1() == 6) {
            setVolumeVibration(am);

        } else if (routine.getRoutineSlot1() == 7) {
            setVolumeMax(am);

        } else if (routine.getRoutineSlot1() == 8) {

            new CountDownTimer(this.routineSettingsManager.getAppTime(), 1000) {
                /* class com.mn.myroutines.RoutineActionManager.AnonymousClass1 */

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

        } else {

            if (routine.getRoutineSlot1() == 9) {
                Intent intent = new Intent("android.intent.action.SET_TIMER");
                intent.putExtra("android.intent.extra.alarm.MESSAGE", routine.getTimerName());
                intent.putExtra("android.intent.extra.alarm.LENGTH", routine.getTimerSeconds() + (routine.getTimerMinutes() * 60) + (routine.getTimerHours() * 3600));
                this.context.startActivity(intent);

            } else if (routine.getRoutineSlot1() == 10) {

                setWifiOff();
            } else if (routine.getRoutineSlot1() != 11) {


            } else if (Build.VERSION.SDK_INT >= 29) {
                Intent panelIntent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                mainActivity.startActivityForResult(panelIntent, 1);

            } else {

                ((WifiManager) this.context.getSystemService(Context.WIFI_SERVICE)).setWifiEnabled(true);
            }
        }
        if (routine.getRoutineSlot2() != 0) {
            if (routine.getRoutineSlot2() == 1) {
               setBluetoothStateOff(bluetoothAdapter);
            } else if (routine.getRoutineSlot2() == 2) {
                setBluetoothStateOn(bluetoothAdapter);
            } else if (routine.getRoutineSlot2() == 3) {
                setMediaVolumeMute(am);
            }

                if (routine.getRoutineSlot2() == 4) {
                    setMediaVolumeMax(am);
                } else if (routine.getRoutineSlot2() == 5) {
                   setVolumeMax(am);
                } else if (routine.getRoutineSlot2() == 6) {
                    setVolumeVibration(am);
                } else if (routine.getRoutineSlot2() == 7) {
                   setVolumeMax(am);
                } else if (routine.getRoutineSlot2() == 8) {
                    new CountDownTimer(this.routineSettingsManager.getAppTime(), 1000) {
                        /* class com.mn.myroutines.RoutineActionManager.AnonymousClass2 */

                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            cancel();
                            try {
                                RoutineActionManager.this.mainActivity.startActivity(RoutineActionManager.this.mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot2()));
                            } catch (ActivityNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();

                } else if (routine.getRoutineSlot2() == 9) {
                    Intent intent2 = new Intent("android.intent.action.SET_TIMER");
                    intent2.putExtra("android.intent.extra.alarm.MESSAGE", routine.getTimerName());
                    intent2.putExtra("android.intent.extra.alarm.LENGTH", routine.getTimerSeconds() + (routine.getTimerMinutes() * 60) + (routine.getTimerHours() * 3600));
                    this.context.startActivity(intent2);

                } else if (routine.getRoutineSlot2() == 10) {
                    setWifiOff();
                } else if (routine.getRoutineSlot2() != 11) {

                } else if (Build.VERSION.SDK_INT >= 29) {
                    Intent panelIntent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                    mainActivity.startActivityForResult(panelIntent, 1);

                } else {

                    ((WifiManager) this.context.getSystemService(Context.WIFI_SERVICE)).setWifiEnabled(false);
                }
            }


        if (routine.getRoutineSlot3() != 0) {


            if (routine.getRoutineSlot3() == 1) {
                setBluetoothStateOff(bluetoothAdapter);
            } else if (routine.getRoutineSlot3() == 2) {
                setBluetoothStateOn(bluetoothAdapter);
            } else if (routine.getRoutineSlot3() == 3) {

                setMediaVolumeMute(am);
                if (routine.getRoutineSlot3() == 4) {
                    setMediaVolumeMax(am);
                } else if (routine.getRoutineSlot3() == 5) {
                    setVolumeMute(am);
                } else if (routine.getRoutineSlot3() == 6) {
                   setVolumeVibration(am);
                } else if (routine.getRoutineSlot3() == 7) {
                   setVolumeMax(am);
                } else if (routine.getRoutineSlot3() == 8) {
                    new CountDownTimer(this.routineSettingsManager.getAppTime(), 1000) {
                        /* class com.mn.myroutines.RoutineActionManager.AnonymousClass3 */

                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            cancel();
                            try {
                                RoutineActionManager.this.mainActivity.startActivity(RoutineActionManager.this.mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot3()));
                            } catch (ActivityNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();

                } else if (routine.getRoutineSlot3() == 9) {
                    Intent intent3 = new Intent("android.intent.action.SET_TIMER");
                    intent3.putExtra("android.intent.extra.alarm.MESSAGE", routine.getTimerName());
                    intent3.putExtra("android.intent.extra.alarm.LENGTH", routine.getTimerSeconds() + (routine.getTimerMinutes() * 60) + (routine.getTimerHours() * 3600));
                    this.context.startActivity(intent3);

                } else if (routine.getRoutineSlot3() == 10) {
                    setWifiOff();
                } else if (routine.getRoutineSlot3() != 11) {

                } else if (Build.VERSION.SDK_INT >= 29) {
                    Intent panelIntent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                    mainActivity.startActivityForResult(panelIntent, 1);

                } else {

                    ((WifiManager) this.context.getSystemService(Context.WIFI_SERVICE)).setWifiEnabled(true);
                }
            } else if (Build.VERSION.SDK_INT >= 28) {

                am.setStreamVolume(3, am.getStreamMinVolume(3), 1);
            } else {

                //am.adjustStreamVolume(3, am.getStreamMaxVolume(3), r14);
            }
        }
        if (routine.getRoutineSlot4() != 0) {
            if (routine.getRoutineSlot4() == 1) {
                setBluetoothStateOff(bluetoothAdapter);
            } else if (routine.getRoutineSlot4() == 2) {
                setBluetoothStateOn(bluetoothAdapter);
            } else if (routine.getRoutineSlot4() != 3) {
                setMediaVolumeMute(am);
                if (routine.getRoutineSlot4() == 4) {
                    setVolumeMax(am);
                } else if (routine.getRoutineSlot4() == 5) {
                    setVolumeMute(am);
                } else if (routine.getRoutineSlot4() == 6) {
                    setVolumeVibration(am);
                } else if (routine.getRoutineSlot4() == 7) {
                    setVolumeMax(am);
                } else if (routine.getRoutineSlot4() == 8) {
                    new CountDownTimer(this.routineSettingsManager.getAppTime(), 1000) {
                        /* class com.mn.myroutines.RoutineActionManager.AnonymousClass4 */

                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            cancel();
                            try {
                                RoutineActionManager.this.mainActivity.startActivity(RoutineActionManager.this.mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot4()));
                            } catch (ActivityNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();

                } else if (routine.getRoutineSlot4() == 9) {
                    Intent intent4 = new Intent("android.intent.action.SET_TIMER");
                    intent4.putExtra("android.intent.extra.alarm.MESSAGE", routine.getTimerName());
                    intent4.putExtra("android.intent.extra.alarm.LENGTH", routine.getTimerSeconds() + (routine.getTimerMinutes() * 60) + (routine.getTimerHours() * 3600));
                    this.context.startActivity(intent4);

                } else if (routine.getRoutineSlot4() == 10) {
                   setWifiOff();
                } else if (routine.getRoutineSlot4() != 11) {

                } else if (Build.VERSION.SDK_INT >= 29) {
                    Intent panelIntent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                    mainActivity.startActivityForResult(panelIntent, 1);

                } else {

                    ((WifiManager) this.context.getSystemService(Context.WIFI_SERVICE)).setWifiEnabled(false);
                }
            } else if (Build.VERSION.SDK_INT >= 28) {

                am.setStreamVolume(3, am.getStreamMinVolume(3), 1);
            } else {

                //am.adjustStreamVolume(3, am.getStreamMaxVolume(3), r14);
            }
        }
        if (routine.getRoutineSlot5() != 0) {
            if (routine.getRoutineSlot5() == 1) {
                setBluetoothStateOff(bluetoothAdapter);
            } else if (routine.getRoutineSlot5() == 2) {
                setBluetoothStateOn(bluetoothAdapter);
            } else if (routine.getRoutineSlot5() == 3) {
                setMediaVolumeMute(am);
                if (routine.getRoutineSlot5() == 4) {
                   setMediaVolumeMax(am);
                } else if (routine.getRoutineSlot5() == 5) {
                    setVolumeMute(am);
                } else if (routine.getRoutineSlot5() == 6) {
                    setVolumeVibration(am);
                } else if (routine.getRoutineSlot5() == 7) {
                    setVolumeMax(am);
                } else if (routine.getRoutineSlot5() == 8) {
                    new CountDownTimer(this.routineSettingsManager.getAppTime(), 1000) {
                        /* class com.mn.myroutines.RoutineActionManager.AnonymousClass5 */

                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            cancel();
                            try {
                                RoutineActionManager.this.mainActivity.startActivity(RoutineActionManager.this.mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot5()));
                            } catch (ActivityNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();

                } else if (routine.getRoutineSlot5() == 9) {
                    Intent intent5 = new Intent("android.intent.action.SET_TIMER");
                    intent5.putExtra("android.intent.extra.alarm.MESSAGE", routine.getTimerName());
                    intent5.putExtra("android.intent.extra.alarm.LENGTH", routine.getTimerSeconds() + (routine.getTimerMinutes() * 60) + (routine.getTimerHours() * 3600));
                    this.context.startActivity(intent5);

                } else if (routine.getRoutineSlot5() == 10) {
                    setWifiOff();
                } else if (routine.getRoutineSlot5() != 11) {

                } else if (Build.VERSION.SDK_INT >= 29) {
                    Intent panelIntent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                    mainActivity.startActivityForResult(panelIntent, 1);

                } else {

                    ((WifiManager) this.context.getSystemService(Context.WIFI_SERVICE)).setWifiEnabled(false);
                }
            } else if (Build.VERSION.SDK_INT >= 28) {

                am.setStreamVolume(3, am.getStreamMinVolume(3), 1);
            } else {

               // am.adjustStreamVolume(3, am.getStreamMaxVolume(3), r14);
            }
        }
        if (routine.getRoutineSlot6() != 0) {
            if (routine.getRoutineSlot6() == 1) {
                setBluetoothStateOff(bluetoothAdapter);
            } else if (routine.getRoutineSlot6() == 2) {
               setBluetoothStateOn(bluetoothAdapter);
            } else if (routine.getRoutineSlot6() == 3) {
                setMediaVolumeMute(am);
                if (routine.getRoutineSlot6() == 4) {
                    setMediaVolumeMax(am);
                } else if (routine.getRoutineSlot6() == 5) {
                    setVolumeMute(am);
                } else if (routine.getRoutineSlot6() == 6) {
                  setVolumeVibration(am);
                } else if (routine.getRoutineSlot6() == 7) {

                    setMediaVolumeMax(am);
                } else if (routine.getRoutineSlot6() == 8) {
                    new CountDownTimer(this.routineSettingsManager.getAppTime(), 1000) {
                        /* class com.mn.myroutines.RoutineActionManager.AnonymousClass6 */

                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            cancel();
                            try {
                                RoutineActionManager.this.mainActivity.startActivity(RoutineActionManager.this.mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot6()));
                            } catch (ActivityNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();

                } else if (routine.getRoutineSlot6() == 9) {
                    Intent intent6 = new Intent("android.intent.action.SET_TIMER");
                    intent6.putExtra("android.intent.extra.alarm.MESSAGE", routine.getTimerName());
                    intent6.putExtra("android.intent.extra.alarm.LENGTH", routine.getTimerSeconds() + (routine.getTimerMinutes() * 60) + (routine.getTimerHours() * 3600));
                    this.context.startActivity(intent6);

                } else if (routine.getRoutineSlot6() == 10) {
                   setWifiOff();
                } else if (routine.getRoutineSlot6() != 11) {

                } else if (Build.VERSION.SDK_INT >= 29) {
                    Intent panelIntent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                    mainActivity.startActivityForResult(panelIntent, 1);

                } else {

                    ((WifiManager) this.context.getSystemService(Context.WIFI_SERVICE)).setWifiEnabled(false);
                }
            } else if (Build.VERSION.SDK_INT >= 28) {

                am.setStreamVolume(3, am.getStreamMinVolume(3), 1);
            } else {

               // am.adjustStreamVolume(3, am.getStreamMaxVolume(3), r14);
            }
        }
        if (routine.getRoutineSlot7() != 0) {
            if (routine.getRoutineSlot7() == 1) {
                setBluetoothStateOff(bluetoothAdapter);
            } else if (routine.getRoutineSlot7() == 2) {
               setBluetoothStateOn(bluetoothAdapter);
            } else if (routine.getRoutineSlot7() == 3) {
                setMediaVolumeMute(am);
                if (routine.getRoutineSlot7() == 4) {
                    setMediaVolumeMax(am);
                } else if (routine.getRoutineSlot7() == 5) {
                    setVolumeMute(am);
                } else if (routine.getRoutineSlot7() == 6) {
                   setVolumeVibration(am);
                } else if (routine.getRoutineSlot7() == 7) {
                    setVolumeMax(am);
                } else if (routine.getRoutineSlot7() == 8) {
                    new CountDownTimer(this.routineSettingsManager.getAppTime(), 1000) {
                        /* class com.mn.myroutines.RoutineActionManager.AnonymousClass7 */

                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            cancel();
                            try {
                                RoutineActionManager.this.mainActivity.startActivity(RoutineActionManager.this.mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot7()));
                            } catch (ActivityNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();

                } else if (routine.getRoutineSlot7() == 9) {
                    Intent intent7 = new Intent("android.intent.action.SET_TIMER");
                    intent7.putExtra("android.intent.extra.alarm.MESSAGE", routine.getTimerName());
                    intent7.putExtra("android.intent.extra.alarm.LENGTH", routine.getTimerSeconds() + (routine.getTimerMinutes() * 60) + (routine.getTimerHours() * 3600));
                    this.context.startActivity(intent7);

                } else if (routine.getRoutineSlot6() == 10) {
                   setWifiOff();
                } else if (routine.getRoutineSlot7() != 11) {

                } else if (Build.VERSION.SDK_INT >= 29) {
                    Intent panelIntent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                    mainActivity.startActivityForResult(panelIntent, 1);

                } else {

                    ((WifiManager) this.context.getSystemService(Context.WIFI_SERVICE)).setWifiEnabled(false);
                }
            } else if (Build.VERSION.SDK_INT >= 28) {

                am.setStreamVolume(3, am.getStreamMinVolume(3), 1);
            } else {

               // am.adjustStreamVolume(3, am.getStreamMaxVolume(3), r14);
            }
        }
        if (routine.getRoutineSlot8() != 0) {
            if (routine.getRoutineSlot8() == 1) {
                setBluetoothStateOff(bluetoothAdapter);
            } else if (routine.getRoutineSlot8() == 2) {
               setBluetoothStateOn(bluetoothAdapter);
            } else if (routine.getRoutineSlot8() == 3) {

                setMediaVolumeMute(am);
                if (routine.getRoutineSlot8() == 4) {
                    setMediaVolumeMax(am);
                } else if (routine.getRoutineSlot8() == 5) {
                    setVolumeMute(am);
                } else if (routine.getRoutineSlot8() == 6) {
                    setVolumeVibration(am);
                } else if (routine.getRoutineSlot8() == 7) {
                   setVolumeMax(am);
                } else if (routine.getRoutineSlot8() == 8) {
                    new CountDownTimer(this.routineSettingsManager.getAppTime(), 1000) {
                        /* class com.mn.myroutines.RoutineActionManager.AnonymousClass8 */

                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            cancel();
                            try {
                                RoutineActionManager.this.mainActivity.startActivity(RoutineActionManager.this.mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot8()));
                            } catch (ActivityNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();

                } else if (routine.getRoutineSlot8() == 9) {
                    Intent intent8 = new Intent("android.intent.action.SET_TIMER");
                    intent8.putExtra("android.intent.extra.alarm.MESSAGE", routine.getTimerName());
                    intent8.putExtra("android.intent.extra.alarm.LENGTH", routine.getTimerSeconds() + (routine.getTimerMinutes() * 60) + (routine.getTimerHours() * 3600));
                    this.context.startActivity(intent8);

                } else if (routine.getRoutineSlot8() == 10) {
                    setWifiOff();
                } else if (routine.getRoutineSlot8() != 11) {

                } else if (Build.VERSION.SDK_INT >= 29) {
                    Intent panelIntent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                    mainActivity.startActivityForResult(panelIntent, 1);

                } else {

                    ((WifiManager) this.context.getSystemService(Context.WIFI_SERVICE)).setWifiEnabled(false);
                }
            } else if (Build.VERSION.SDK_INT >= 28) {

                am.setStreamVolume(3, am.getStreamMinVolume(3), 1);
            } else {

               // am.adjustStreamVolume(3, am.getStreamMaxVolume(3), r14);
            }
        }
        if (routine.getRoutineSlot9() != 0) {
            if (routine.getRoutineSlot9() == 1) {
                setBluetoothStateOff(bluetoothAdapter);
            } else if (routine.getRoutineSlot9() == 2) {
                setBluetoothStateOn(bluetoothAdapter);
            } else if (routine.getRoutineSlot9() == 3) {

                setMediaVolumeMute(am);
                if (routine.getRoutineSlot9() == 4) {
                   setMediaVolumeMax(am);
                } else if (routine.getRoutineSlot9() == 5) {
                   setVolumeMute(am);
                } else if (routine.getRoutineSlot9() == 6) {
                    setVolumeVibration(am);
                } else if (routine.getRoutineSlot9() == 7) {
                   setVolumeMax(am);
                } else if (routine.getRoutineSlot9() == 8) {
                    new CountDownTimer(this.routineSettingsManager.getAppTime(), 1000) {
                        /* class com.mn.myroutines.RoutineActionManager.AnonymousClass9 */

                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            cancel();
                            try {
                                RoutineActionManager.this.mainActivity.startActivity(RoutineActionManager.this.mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot9()));
                            } catch (ActivityNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();

                } else if (routine.getRoutineSlot9() == 9) {
                    Intent intent9 = new Intent("android.intent.action.SET_TIMER");
                    intent9.putExtra("android.intent.extra.alarm.MESSAGE", routine.getTimerName());
                    intent9.putExtra("android.intent.extra.alarm.LENGTH", routine.getTimerSeconds() + (routine.getTimerMinutes() * 60) + (routine.getTimerHours() * 3600));
                    this.context.startActivity(intent9);

                } else if (routine.getRoutineSlot9() == 10) {
                   setWifiOff();
                } else if (routine.getRoutineSlot9() != 11) {

                } else if (Build.VERSION.SDK_INT >= 29) {
                    Intent panelIntent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                    mainActivity.startActivityForResult(panelIntent, 1);

                } else {

                    ((WifiManager) this.context.getSystemService(Context.WIFI_SERVICE)).setWifiEnabled(false);
                }
            } else if (Build.VERSION.SDK_INT >= 28) {

                am.setStreamVolume(3, am.getStreamMinVolume(3), 1);
            } else {

               // am.adjustStreamVolume(3, am.getStreamMaxVolume(3), r14);
            }
        }
        if (routine.getRoutineSlot10() != 0) {
            if (routine.getRoutineSlot10() == 1) {
               setBluetoothStateOff(bluetoothAdapter);
            } else if (routine.getRoutineSlot10() == 2) {
                setBluetoothStateOn(bluetoothAdapter);
            } else if (routine.getRoutineSlot10() == 3) {
                setMediaVolumeMute(am);
            } else if (routine.getRoutineSlot10() == 4) {
                setMediaVolumeMax(am);
            } else if (routine.getRoutineSlot10() == 5) {
               setVolumeMute(am);
            } else if (routine.getRoutineSlot10() == 6) {
               setVolumeVibration(am);
            } else if (routine.getRoutineSlot10() == 7) {
                setVolumeMax(am);
            } else if (routine.getRoutineSlot10() == 8) {
                new CountDownTimer(this.routineSettingsManager.getAppTime(), 1000) {
                    /* class com.mn.myroutines.RoutineActionManager.AnonymousClass10 */

                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        cancel();
                        try {
                            RoutineActionManager.this.mainActivity.startActivity(RoutineActionManager.this.mainActivity.getPackageManager().getLaunchIntentForPackage(routine.getAppPackageNameSlot10()));
                        } catch (ActivityNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            } else if (routine.getRoutineSlot10() == 9) {
                Intent intent10 = new Intent("android.intent.action.SET_TIMER");
                intent10.putExtra("android.intent.extra.alarm.MESSAGE", routine.getTimerName());
                intent10.putExtra("android.intent.extra.alarm.LENGTH", routine.getTimerSeconds() + (routine.getTimerMinutes() * 60) + (routine.getTimerHours() * 3600));
                this.context.startActivity(intent10);
            } else if (routine.getRoutineSlot10() == 10) {
                setWifiOff();
            } else if (routine.getRoutineSlot10() != 11) {
            } else {
                if (Build.VERSION.SDK_INT >= 29) {
                    Intent panelIntent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                    mainActivity.startActivityForResult(panelIntent, 1);
                    return;
                }
                ((WifiManager) this.context.getSystemService(Context.WIFI_SERVICE)).setWifiEnabled(false);
            }
        }
    }

    private  void setBluetoothStateOn(BluetoothAdapter bluetoothAdapter){
        if (bluetoothAdapter.isEnabled()) {
            bluetoothAdapter.disable();



        }
    }

    private void setBluetoothStateOff(BluetoothAdapter bluetoothAdapter){
        if (!bluetoothAdapter.isEnabled()) {
            bluetoothAdapter.enable();

        }
    }

    private void setMediaVolumeMute(AudioManager am){
        if (Build.VERSION.SDK_INT >= 28) {
            am.setStreamVolume(3, am.getStreamMinVolume(3), 1);

        } else {
            am.adjustStreamVolume(3, am.getStreamMaxVolume(3), 0);


        }
    }

    private void setMediaVolumeMax(AudioManager am){
        am.setStreamVolume(3, am.getStreamMaxVolume(3), 1);
    }

    private void setVolumeMute(AudioManager am){
        if (Build.VERSION.SDK_INT >= 28) {
            am.setStreamVolume(3, am.getStreamMinVolume(3), 1);
            am.setStreamVolume(1, am.getStreamMinVolume(1), 1);
            am.setStreamVolume(4, am.getStreamMinVolume(4), 1);
            am.setStreamVolume(5, am.getStreamMinVolume(5), 1);

        } else {
            am.setStreamVolume(3, -100, 0);
            am.adjustStreamVolume(1, -100, 0);
            am.adjustStreamVolume(4, -100, 0);
            am.adjustStreamVolume(5, -100, 0);

        }
    }

    private void setVolumeVibration(AudioManager am){
        if (Build.VERSION.SDK_INT >= 28) {
            am.setStreamVolume(3, am.getStreamMinVolume(3), 1);
            am.setStreamVolume(1, am.getStreamMinVolume(1), 1);
            am.setStreamVolume(4, am.getStreamMinVolume(4), 1);
            am.setStreamVolume(5, am.getStreamMinVolume(5), 1);

        } else {
            am.setStreamVolume(3, -100, 0);
            am.adjustStreamVolume(1, -100, 0);
            am.adjustStreamVolume(4, -100, 0);
            am.adjustStreamVolume(5, -100, 0);

        }
    }

    private void setVolumeMax(AudioManager am){
        if (Build.VERSION.SDK_INT >= 28) {
            am.setStreamVolume(3, am.getStreamMaxVolume(3), 1);
            am.setStreamVolume(1, am.getStreamMaxVolume(1), 1);
            am.setStreamVolume(4, am.getStreamMaxVolume(4), 1);
            am.setStreamVolume(5, am.getStreamMaxVolume(5), 1);

        } else {
            am.setStreamVolume(3, am.getStreamMaxVolume(3), 1);
            am.setStreamVolume(3, am.getStreamMaxVolume(3), 1);
            am.setStreamVolume(1, am.getStreamMaxVolume(1), 1);
            am.setStreamVolume(5, am.getStreamMaxVolume(5), 1);

        }
    }

    private void setWifiOff(){
        if (Build.VERSION.SDK_INT >= 29) {
            Intent panelIntent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

            mainActivity.startActivityForResult(panelIntent, 1);

        } else {
            ((WifiManager) this.context.getSystemService(Context.WIFI_SERVICE)).setWifiEnabled(false);

        }
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
