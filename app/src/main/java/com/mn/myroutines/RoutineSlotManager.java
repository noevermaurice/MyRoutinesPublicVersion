package com.mn.myroutines;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

public class RoutineSlotManager {
    public String ArrayListSlotDefault;
    public String DescriptionText1;
    public String DescriptionText10;
    public String DescriptionText2;
    public String DescriptionText3;
    public String DescriptionText4;
    public String DescriptionText5;
    public String DescriptionText6;
    public String DescriptionText7;
    public String DescriptionText8;
    public String DescriptionText9;
    public String DescriptionTextComplete;
    Activity activity;
    public String appName;
    public String appName1;
    public String appName10;
    public String appName2;
    public String appName3;
    public String appName4;
    public String appName5;
    public String appName6;
    public String appName7;
    public String appName8;
    public String appName9;
    public String appPackageName;
    public String appPackageName1;
    public String appPackageName10;
    public String appPackageName2;
    public String appPackageName3;
    public String appPackageName4;
    public String appPackageName5;
    public String appPackageName6;
    public String appPackageName7;
    public String appPackageName8;
    public String appPackageName9;
    public String bluetoothOffString;
    private String bluetothOnString;
    Context context;
    EditText editText;
    public boolean isEverDay;
    public boolean isEverMonth;
    public boolean isEverWeek;
    ListView listView;
    ListviewAdapterRoutine listviewAdapterRoutine;
    int listviewItemPosition;
    private String mediaVolumeMaxString;
    private String mediaVolumeMuteString;
    public int monthplus1;
    public int monthplus10;
    public int monthplus11;
    public int monthplus12;
    public int monthplus13;
    public int monthplus14;
    public int monthplus15;
    public int monthplus16;
    public int monthplus17;
    public int monthplus18;
    public int monthplus19;
    public int monthplus2;
    public int monthplus20;
    public int monthplus21;
    public int monthplus22;
    public int monthplus23;
    public int monthplus24;
    public int monthplus25;
    public int monthplus26;
    public int monthplus27;
    public int monthplus28;
    public int monthplus29;
    public int monthplus3;
    public int monthplus30;
    public int monthplus31;
    public int monthplus4;
    public int monthplus5;
    public int monthplus6;
    public int monthplus7;
    public int monthplus8;
    public int monthplus9;
    public int myDay;
    public int myHour;
    public int myMinute;
    public int myMonth;
    public int myYear;
    public String newActionString;
    public String noActionString;
    Routine oldRoutine;
    public int randemQuestCode;
    public String routineAlarmDate;
    public RoutineManager routineManager;
    public int routinebiggerThanMonth;
    int routinelistPositionSlot1;
    int routinelistPositionSlot10;
    int routinelistPositionSlot2;
    int routinelistPositionSlot3;
    int routinelistPositionSlot4;
    int routinelistPositionSlot5;
    int routinelistPositionSlot6;
    int routinelistPositionSlot7;
    int routinelistPositionSlot8;
    int routinelistPositionSlot9;
    private String runApp;
    private String runTimer;
    public ShortcutManager shortcutManager;
    private String speakerVolumeMax;
    private String speakerVolumeMute;
    private String speakerVolumeVibration;
    int timerHours;
    int timerMinutes;
    private String timerName;
    int timerSeconds;
    public int whichSlotPosition;
    private String wifiOff;
    private String wifiOn;

    public RoutineSlotManager(Context context2, Activity activity2, ListView listView2, ListviewAdapterRoutine listviewAdapterRoutine2, String ArrayListSlotDefault2, String newActionString2, String noActionString2, String bluetoothOffString2, String bluetothOnString2, String mediaVolumeMuteString2, String mediaVolumeMaxString2, String speakerVolumeMute2, String speakerVolumeVibration2, String speakerVolumeMax2, String runApp2, String runTimer2, String wifiOff2, String wifiOn2, int listviewItemPosition2, int routinelistPositionSlot12, int routinelistPositionSlot22, int routinelistPositionSlot32, int routinelistPositionSlot42, int routinelistPositionSlot52, int routinelistPositionSlot62, int routinelistPositionSlot72, int routinelistPositionSlot82, int routinelistPositionSlot92, int routinelistPositionSlot102, int whichSlotPosition2, EditText editText2) {
        this.activity = activity2;
        this.context = context2;
        this.shortcutManager = new ShortcutManager(context2, activity2);
        this.listView = listView2;
        this.listviewAdapterRoutine = listviewAdapterRoutine2;
        this.ArrayListSlotDefault = ArrayListSlotDefault2;
        this.newActionString = newActionString2;
        this.noActionString = noActionString2;
        this.bluetoothOffString = bluetoothOffString2;
        this.bluetothOnString = bluetothOnString2;
        this.mediaVolumeMuteString = mediaVolumeMuteString2;
        this.speakerVolumeVibration = speakerVolumeVibration2;
        this.mediaVolumeMaxString = mediaVolumeMaxString2;
        this.speakerVolumeMute = speakerVolumeMute2;
        this.speakerVolumeMax = speakerVolumeMax2;
        this.runApp = runApp2;
        this.runTimer = runTimer2;
        this.wifiOff = wifiOff2;
        this.wifiOn = wifiOn2;
        this.listviewItemPosition = listviewItemPosition2;
        this.routinelistPositionSlot1 = routinelistPositionSlot12;
        this.routinelistPositionSlot2 = routinelistPositionSlot22;
        this.routinelistPositionSlot3 = routinelistPositionSlot32;
        this.routinelistPositionSlot4 = routinelistPositionSlot42;
        this.routinelistPositionSlot5 = routinelistPositionSlot52;
        this.routinelistPositionSlot6 = routinelistPositionSlot62;
        this.routinelistPositionSlot7 = routinelistPositionSlot72;
        this.routinelistPositionSlot8 = routinelistPositionSlot82;
        this.routinelistPositionSlot9 = routinelistPositionSlot92;
        this.routinelistPositionSlot10 = routinelistPositionSlot102;
        this.whichSlotPosition = whichSlotPosition2;
        this.editText = editText2;
    }

    public void setDefaultSlots() {

        for (int i = 0;  i<10; i++){
            this.listviewAdapterRoutine.arrayListSlots.add(this.ArrayListSlotDefault);
        }


        this.listView.setAdapter((ListAdapter) this.listviewAdapterRoutine);
    }

    public void getRoutineSlotActions(Routine oldRoutine2) {
        this.oldRoutine = oldRoutine2;
        this.editText.setText(oldRoutine2.getRoutineName());
        for (int casesSlot1 = 0; casesSlot1 < 10; casesSlot1++) {
            setWhichSlotPosition(oldRoutine2.routineSlotEins);
            setRoutineSlots(oldRoutine2.getRoutineSlot1());
        }
        for (int casesSlot2 = 0; casesSlot2 < 10; casesSlot2++) {
            setWhichSlotPosition(oldRoutine2.routineSlotZwei);
            setRoutineSlots(oldRoutine2.getRoutineSlot2());
        }
        for (int casesSlot3 = 0; casesSlot3 < 10; casesSlot3++) {
            setWhichSlotPosition(oldRoutine2.routineSlotDrei);
            setRoutineSlots(oldRoutine2.getRoutineSlot3());
        }
        for (int casesSlot4 = 0; casesSlot4 < 10; casesSlot4++) {
            setWhichSlotPosition(oldRoutine2.routineSlotVier);
            setRoutineSlots(oldRoutine2.getRoutineSlot4());
        }
        for (int casesSlot5 = 0; casesSlot5 < 10; casesSlot5++) {
            setWhichSlotPosition(oldRoutine2.f0routineSlotFnf);
            setRoutineSlots(oldRoutine2.getRoutineSlot5());
        }
        for (int casesSlot6 = 0; casesSlot6 < 10; casesSlot6++) {
            setWhichSlotPosition(oldRoutine2.routineSlotSechs);
            setRoutineSlots(oldRoutine2.getRoutineSlot6());
        }
        for (int casesSlot7 = 0; casesSlot7 < 10; casesSlot7++) {
            setWhichSlotPosition(oldRoutine2.routineSlotSieben);
            setRoutineSlots(oldRoutine2.getRoutineSlot7());
        }
        for (int casesSlot8 = 0; casesSlot8 < 10; casesSlot8++) {
            setWhichSlotPosition(oldRoutine2.routineSlotAcht);
            setRoutineSlots(oldRoutine2.getRoutineSlot8());
        }
        for (int casesSlot9 = 0; casesSlot9 < 10; casesSlot9++) {
            setWhichSlotPosition(oldRoutine2.routineSlotNeun);
            setRoutineSlots(oldRoutine2.getRoutineSlot9());
        }
        for (int casesSlot10 = 0; casesSlot10 < 10; casesSlot10++) {
            setWhichSlotPosition(oldRoutine2.routineSlotZehn);
            setRoutineSlots(oldRoutine2.getRoutineSlot10());
        }
    }

    public void setRoutineSlots(int selectActionPosition) {
        switch (selectActionPosition) {
            case 0:
                int i = this.whichSlotPosition;
                if (i == 0) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + this.routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i == 1) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + this.routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i == 2) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + this.routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i == 3) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + this.routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i == 4) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + this.routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i == 5) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + this.routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i == 6) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + this.routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i == 7) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + this.routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i == 8) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + this.routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i == 9) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + this.routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else {
                    return;
                }
            case 1:
                int i2 = this.whichSlotPosition;
                if (i2 == 0) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + this.routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i2 == 1) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + this.routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i2 == 2) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + this.routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i2 == 3) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + this.routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i2 == 4) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + this.routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i2 == 5) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + this.routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i2 == 6) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + this.routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i2 == 7) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + this.routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i2 == 8) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + this.routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i2 == 9) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + this.routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else {
                    return;
                }
            case 2:
                int i3 = this.whichSlotPosition;
                if (i3 == 0) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + this.routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i3 == 1) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + this.routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i3 == 2) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + this.routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i3 == 3) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + this.routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i3 == 4) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + this.routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i3 == 5) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + this.routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i3 == 6) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + this.routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i3 == 7) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + this.routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i3 == 8) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + this.routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i3 == 9) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + this.routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else {
                    return;
                }
            case 3:
                int i4 = this.whichSlotPosition;
                if (i4 == 0) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + this.routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i4 == 1) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + this.routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i4 == 2) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + this.routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i4 == 3) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + this.routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i4 == 4) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + this.routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i4 == 5) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + this.routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i4 == 6) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + this.routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i4 == 7) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + this.routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i4 == 8) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + this.routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i4 == 9) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + this.routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else {
                    return;
                }
            case 4:
                int i5 = this.whichSlotPosition;
                if (i5 == 0) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + this.routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i5 == 1) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + this.routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i5 == 2) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + this.routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i5 == 3) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + this.routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i5 == 4) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + this.routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i5 == 5) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + this.routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i5 == 6) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + this.routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i5 == 7) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + this.routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i5 == 8) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + this.routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i5 == 9) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + this.routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else {
                    return;
                }
            case 5:
                int i6 = this.whichSlotPosition;
                if (i6 == 0) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + this.routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i6 == 1) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + this.routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i6 == 2) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + this.routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i6 == 3) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + this.routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i6 == 4) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + this.routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i6 == 5) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + this.routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i6 == 6) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + this.routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i6 == 7) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + this.routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i6 == 8) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + this.routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i6 == 9) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + this.routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else {
                    return;
                }
            case 6:
                int i7 = this.whichSlotPosition;
                if (i7 == 0) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + this.routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i7 == 1) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + this.routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i7 == 2) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + this.routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i7 == 3) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + this.routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i7 == 4) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + this.routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i7 == 5) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + this.routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i7 == 6) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + this.routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i7 == 7) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + this.routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i7 == 8) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + this.routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i7 == 9) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + this.routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else {
                    return;
                }
            case 7:
                int i8 = this.whichSlotPosition;
                if (i8 == 0) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + this.routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i8 == 1) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + this.routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i8 == 2) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + this.routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i8 == 3) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + this.routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i8 == 4) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + this.routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i8 == 5) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + this.routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i8 == 6) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + this.routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i8 == 7) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + this.routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i8 == 8) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + this.routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i8 == 9) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + this.routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else {
                    return;
                }
            case 8:
                int i9 = this.whichSlotPosition;
                if (i9 == 0) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + this.routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i9 == 1) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + this.routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i9 == 2) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + this.routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i9 == 3) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + this.routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i9 == 4) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + this.routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i9 == 5) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + this.routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i9 == 6) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + this.routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i9 == 7) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + this.routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i9 == 8) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + this.routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i9 == 9) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + this.routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else {
                    return;
                }
            case 9:
                int i10 = this.whichSlotPosition;
                if (i10 == 0) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + this.routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i10 == 1) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + this.routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i10 == 2) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + this.routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i10 == 3) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + this.routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i10 == 4) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + this.routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i10 == 5) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + this.routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i10 == 6) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + this.routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i10 == 7) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + this.routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i10 == 8) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + this.routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i10 == 9) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + this.routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else {
                    return;
                }
            case 10:
                int i11 = this.whichSlotPosition;
                if (i11 == 0) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + this.routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i11 == 1) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + this.routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i11 == 2) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + this.routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i11 == 3) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + this.routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i11 == 4) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + this.routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i11 == 5) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + this.routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i11 == 6) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + this.routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i11 == 7) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + this.routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i11 == 8) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + this.routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i11 == 9) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + this.routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else {
                    return;
                }
            case 11:
                int i12 = this.whichSlotPosition;
                if (i12 == 0) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + this.routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i12 == 1) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + this.routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i12 == 2) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + this.routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i12 == 3) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + this.routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i12 == 4) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + this.routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i12 == 5) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + this.routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i12 == 6) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + this.routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i12 == 7) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + this.routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i12 == 8) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + this.routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else if (i12 == 9) {
                    this.listviewItemPosition = selectActionPosition;
                    this.routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + this.routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + this.listviewItemPosition);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void setWhichSlotPosition(int position) {
        switch (position) {
            case 0:
                this.whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot  " + this.whichSlotPosition + "  wurde gerdückt");
                return;
            case 1:
                this.whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot " + this.whichSlotPosition + "  wurde gerdückt");
                return;
            case 2:
                this.whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot " + this.whichSlotPosition + "wurde gerdückt");
                return;
            case 3:
                this.whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot " + this.whichSlotPosition + "wurde gerdückt");
                return;
            case 4:
                this.whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot " + this.whichSlotPosition + "wurde gerdückt");
                return;
            case 5:
                this.whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot " + this.whichSlotPosition + "wurde gerdückt");
                return;
            case 6:
                this.whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot " + this.whichSlotPosition + "wurde gerdückt");
                return;
            case 7:
                this.whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot " + this.whichSlotPosition + "wurde gerdückt");
                return;
            case 8:
                this.whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot " + this.whichSlotPosition + "wurde gerdückt");
                return;
            case 9:
                this.whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot " + this.whichSlotPosition + "wurde gerdückt");
                return;
            default:
                return;
        }
    }

    public void setNewAction() {
        switch (this.listviewItemPosition) {
            case 0:
                this.newActionString = this.noActionString;
                break;
            case 1:
                this.newActionString = this.bluetoothOffString;
                break;
            case 2:
                this.newActionString = this.bluetothOnString;
                break;
            case 3:
                this.newActionString = this.mediaVolumeMuteString;
                break;
            case 4:
                this.newActionString = this.mediaVolumeMaxString;
                break;
            case 5:
                this.newActionString = this.speakerVolumeMute;
                break;
            case 6:
                this.newActionString = this.speakerVolumeVibration;
                break;
            case 7:
                this.newActionString = this.speakerVolumeMax;
                break;
            case 8:
                setAppSlotName();
                if (this.oldRoutine != null) {
                    getAppSlotName();
                    break;
                }
                break;
            case 9:
                this.newActionString = this.runTimer;
                if (this.oldRoutine != null) {
                    getTimerTime();
                    break;
                }
                break;
            case 10:
                this.newActionString = this.wifiOff;
                break;
            case 11:
                this.newActionString = this.wifiOn;
                break;
        }
        this.listView.setAdapter((ListAdapter) this.listviewAdapterRoutine);
        this.listviewAdapterRoutine.arrayListSlots.set(this.whichSlotPosition, this.newActionString);
    }

    private void getAppSlotName() {
        getTimerTime();
        switch (this.whichSlotPosition) {
            case 0:
                if (this.oldRoutine.getAppNameSlot1() != null) {
                    this.newActionString = this.oldRoutine.getAppNameSlot1();
                    this.appName1 = this.oldRoutine.getAppNameSlot1();
                    this.appPackageName1 = this.oldRoutine.getAppPackageNameSlot1();
                    return;
                }
                return;
            case 1:
                if (this.oldRoutine.getAppNameSlot2() != null) {
                    this.newActionString = this.oldRoutine.getAppNameSlot2();
                    this.appName2 = this.oldRoutine.getAppNameSlot2();
                    this.appPackageName2 = this.oldRoutine.getAppPackageNameSlot2();
                    return;
                }
                return;
            case 2:
                if (this.oldRoutine.getAppNameSlot3() != null) {
                    this.newActionString = this.oldRoutine.getAppNameSlot3();
                    this.appName3 = this.oldRoutine.getAppNameSlot3();
                    this.appPackageName3 = this.oldRoutine.getAppPackageNameSlot3();
                    return;
                }
                return;
            case 3:
                if (this.oldRoutine.getAppNameSlot4() != null) {
                    this.newActionString = this.oldRoutine.getAppNameSlot4();
                    this.appName4 = this.oldRoutine.getAppNameSlot4();
                    this.appPackageName4 = this.oldRoutine.getAppPackageNameSlot4();
                    return;
                }
                return;
            case 4:
                if (this.oldRoutine.getAppNameSlot5() != null) {
                    this.newActionString = this.oldRoutine.getAppNameSlot5();
                    this.appName5 = this.oldRoutine.getAppNameSlot5();
                    this.appPackageName5 = this.oldRoutine.getAppPackageNameSlot5();
                    return;
                }
                return;
            case 5:
                if (this.oldRoutine.getAppNameSlot6() != null) {
                    this.newActionString = this.oldRoutine.getAppNameSlot6();
                    this.appName6 = this.oldRoutine.getAppNameSlot6();
                    this.appPackageName6 = this.oldRoutine.getAppPackageNameSlot6();
                    return;
                }
                return;
            case 6:
                if (this.oldRoutine.getAppNameSlot7() != null) {
                    this.newActionString = this.oldRoutine.getAppNameSlot7();
                    this.appName7 = this.oldRoutine.getAppNameSlot7();
                    this.appPackageName7 = this.oldRoutine.getAppPackageNameSlot7();
                    return;
                }
                return;
            case 7:
                if (this.oldRoutine.getAppNameSlot8() != null) {
                    this.newActionString = this.oldRoutine.getAppNameSlot8();
                    this.appName8 = this.oldRoutine.getAppNameSlot8();
                    this.appPackageName8 = this.oldRoutine.getAppPackageNameSlot8();
                    return;
                }
                return;
            case 8:
                if (this.oldRoutine.getAppNameSlot9() != null) {
                    this.newActionString = this.oldRoutine.getAppNameSlot9();
                    this.appName9 = this.oldRoutine.getAppNameSlot9();
                    this.appPackageName9 = this.oldRoutine.getAppPackageNameSlot9();
                    return;
                }
                return;
            case 9:
                if (this.oldRoutine.getAppnameSlot10() != null) {
                    this.newActionString = this.oldRoutine.getAppnameSlot10();
                    this.appName10 = this.oldRoutine.getAppnameSlot10();
                    this.appPackageName10 = this.oldRoutine.getAppPackageNameSlot10();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void setAppSlotName() {
        switch (this.whichSlotPosition) {
            case 0:
                String str = this.appName1;
                if (str != null) {
                    this.newActionString = str;
                    Log.d("runApp", "Slot Name =" + this.appName1);
                    return;
                }
                return;
            case 1:
                String str2 = this.appName2;
                if (str2 != null) {
                    this.newActionString = str2;
                    Log.d("runApp", "Slot Name =" + this.appName2);
                    return;
                }
                return;
            case 2:
                String str3 = this.appName3;
                if (str3 != null) {
                    this.newActionString = str3;
                    Log.d("runApp", "Slot Name =" + this.appName3);
                    return;
                }
                return;
            case 3:
                String str4 = this.appName4;
                if (str4 != null) {
                    this.newActionString = str4;
                    Log.d("runApp", "Slot Name =" + this.appName4);
                    return;
                }
                return;
            case 4:
                String str5 = this.appName5;
                if (str5 != null) {
                    this.newActionString = str5;
                    Log.d("runApp", "Slot Name =" + this.appName5);
                    return;
                }
                return;
            case 5:
                String str6 = this.appName6;
                if (str6 != null) {
                    this.newActionString = str6;
                    Log.d("runApp", "Slot Name =" + this.appName6);
                    return;
                }
                return;
            case 6:
                String str7 = this.appName7;
                if (str7 != null) {
                    this.newActionString = str7;
                    Log.d("runApp", "Slot Name =" + this.appName7);
                    return;
                }
                return;
            case 7:
                String str8 = this.appName8;
                if (str8 != null) {
                    this.newActionString = str8;
                    Log.d("runApp", "Slot Name =" + this.appName8);
                    return;
                }
                return;
            case 8:
                String str9 = this.appName9;
                if (str9 != null) {
                    this.newActionString = str9;
                    Log.d("runApp", "Slot Name =" + this.appName9);
                    return;
                }
                return;
            case 9:
                String str10 = this.appName10;
                if (str10 != null) {
                    this.newActionString = str10;
                    Log.d("runApp", "Slot Name =" + this.appName10);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void getAppNameAndPackage(String appName11, String appPackageName11) {
        int i = this.whichSlotPosition;
        if (i == 0) {
            this.appName1 = appName11;
            Log.d("runApp", "Name " + this.appName1);
            this.appPackageName1 = appPackageName11;
            Log.d("runApp", "NP" + this.appPackageName1);
        } else if (i == 1) {
            this.appName2 = appName11;
            Log.d("runApp", "Name" + this.appName2);
            this.appPackageName2 = appPackageName11;
            Log.d("runApp", "NP" + this.appPackageName2);
        } else if (i == 2) {
            this.appName3 = appName11;
            Log.d("runApp", "name" + this.appName3);
            this.appPackageName3 = appPackageName11;
            Log.d("runApp", "NP" + this.appPackageName3);
        } else if (i == 3) {
            this.appName4 = appName11;
            Log.d("runApp", "name" + this.appName4);
            this.appPackageName4 = appPackageName11;
            Log.d("runApp", "NP" + this.appPackageName4);
        } else if (i == 4) {
            this.appName5 = appName11;
            Log.d("runApp", "name" + this.appName5);
            this.appPackageName5 = appPackageName11;
            Log.d("runApp", "NP" + this.appPackageName5);
        } else if (i == 5) {
            this.appName6 = appName11;
            Log.d("runApp", "name" + this.appName6);
            this.appPackageName6 = appPackageName11;
            Log.d("runApp", "NP" + this.appPackageName6);
        } else if (i == 6) {
            this.appName7 = appName11;
            Log.d("runApp", "name" + this.appName7);
            this.appPackageName7 = appPackageName11;
            Log.d("runApp", "NP" + this.appPackageName7);
        } else if (i == 7) {
            this.appName8 = appName11;
            Log.d("runApp", "name" + this.appName8);
            this.appPackageName8 = appPackageName11;
            Log.d("runApp", "NP" + this.appPackageName8);
        } else if (i == 8) {
            this.appName9 = appName11;
            Log.d("runApp", "name" + this.appName9);
            this.appPackageName9 = appPackageName11;
            Log.d("runApp", "NP" + this.appPackageName9);
        } else if (i == 9) {
            this.appName10 = appName11;
            Log.d("runApp", "name" + this.appName10);
            this.appPackageName10 = appPackageName11;
            Log.d("runApp", "NP" + this.appPackageName10);
        }
    }

    public void getTimerTime() {
        this.timerName = this.oldRoutine.timerName;
        this.timerMinutes = this.oldRoutine.timerMinutes;
        this.timerHours = this.oldRoutine.timerHours;
        this.timerSeconds = this.oldRoutine.timerSeconds;
        Log.d("x", "x" + this.timerSeconds);
    }

    public void createRoutine(Routine routine, EditText editText2, RoutineManager routineManager2, boolean isShortcut, boolean isNotification, int myYear2, int myMonth2, int myDay2, int myHour2, int myMinute2, int randemCode, String RoutineAlarmDate, boolean isEverDay2, boolean isEverWeek2, boolean isEverMonth2) {
        this.activity = this.activity;
        this.myYear = myYear2;
        this.myMonth = myMonth2;
        this.myDay = myDay2;
        this.myHour = myHour2;
        this.myMinute = myMinute2;
        this.randemQuestCode = randemCode;
        this.routineAlarmDate = this.routineAlarmDate;
        this.isEverDay = isEverDay2;
        this.isEverWeek = isEverWeek2;
        this.isEverMonth = isEverMonth2;
        String newRoutineName = editText2.getText().toString();
        if (newRoutineName.length() > 0) {
            routine.setRoutineName(newRoutineName);
            Log.d("AddRoutineActivity", "Routine Name" + routine.getRoutineName());
            routine.setRoutineSlot1(this.routinelistPositionSlot1);
            Log.d("AddRoutineActivity", "Solt 1 hat den wert = " + routine.getRoutineSlot1());
            routine.setRoutineSlot2(this.routinelistPositionSlot2);
            Log.d("AddRoutineActivity", "Solt 2 hat den wert = " + routine.getRoutineSlot2());
            routine.setRoutineSlot3(this.routinelistPositionSlot3);
            Log.d("AddRoutineActivity", "Solt 3 hat den wert =" + routine.getRoutineSlot3());
            routine.setRoutineSlot4(this.routinelistPositionSlot4);
            Log.d("AddRoutineActivity", "Solt 4 hat den wert =" + routine.getRoutineSlot4());
            routine.setRoutineSlot5(this.routinelistPositionSlot5);
            Log.d("AddRoutineActivity", "Solt 5 hat den wert =" + routine.getRoutineSlot5());
            routine.setRoutineSlot6(this.routinelistPositionSlot6);
            Log.d("AddRoutineActivity", "Solt 6 hat den wert =" + routine.getRoutineSlot6());
            routine.setRoutineSlot7(this.routinelistPositionSlot7);
            Log.d("AddRoutineActivity", "Solt 7 hat den wert =" + routine.getRoutineSlot7());
            routine.setRoutineSlot8(this.routinelistPositionSlot8);
            Log.d("AddRoutineActivity", "Solt 8 hat den wert =" + routine.getRoutineSlot8());
            routine.setRoutineSlot9(this.routinelistPositionSlot9);
            Log.d("AddRoutineActivity", "Solt 9 hat den wert =" + routine.getRoutineSlot9());
            routine.setRoutineSlot10(this.routinelistPositionSlot10);
            Log.d("AddRoutineActivity", "Solt 10 hat den wert =" + routine.getRoutineSlot10());
            routine.setTimerName(this.timerName);
            Log.d("AddRoutineActivity", "Timer Name  =" + routine.getTimerName());
            routine.setTimerSeconds(this.timerSeconds);
            Log.d("AddRoutineActivity", "Timer Seconds  =" + routine.getTimerSeconds());
            routine.setTimerMinutes(this.timerMinutes);
            Log.d("AddRoutineActivity", "Timer Minutes  =" + routine.getTimerMinutes());
            routine.setTimerHours(this.timerHours);
            Log.d("AddRoutineActivity", "Timer Hour  =" + routine.getTimerHours());
            routine.setAppNameSlot1(this.appName1);
            Log.d("AddRoutineActivity", "App Name 1" + routine.getAppNameSlot1());
            routine.setAppPackageNameSlot1(this.appPackageName1);
            Log.d("AddRoutineActivity", "App Package Name 1" + routine.getAppPackageNameSlot1());
            routine.setAppNameSlot2(this.appName2);
            Log.d("AddRoutineActivity", "App Name 2" + routine.getAppNameSlot2());
            routine.setAppPackageNameSlot2(this.appPackageName2);
            Log.d("AddRoutineActivity", "App Package  Name 2" + routine.getAppPackageNameSlot2());
            routine.setAppNameSlot3(this.appName3);
            Log.d("AddRoutineActivity", "App Name 3" + routine.getAppNameSlot3());
            routine.setAppPackageNameSlot3(this.appPackageName3);
            Log.d("AddRoutineActivity", "App Package Name" + routine.getAppPackageNameSlot3());
            routine.setAppNameSlot4(this.appName4);
            Log.d("AddRoutineActivity", "App Name 4" + routine.getAppNameSlot4());
            routine.setAppPackageNameSlot4(this.appPackageName4);
            Log.d("AddRoutineActivity", "App Package Name " + routine.getAppPackageNameSlot4());
            routine.setAppNameSlot5(this.appName5);
            Log.d("AddRoutineActivity", "App Name 5" + routine.getAppNameSlot5());
            routine.setAppPackageNameSlot5(this.appPackageName5);
            Log.d("AddRoutineActivity", "App  Package Name" + routine.getAppPackageNameSlot5());
            routine.setAppNameSlot6(this.appName6);
            Log.d("AddRoutineActivity", "App Name 6" + routine.getAppNameSlot6());
            routine.setAppNameSlot6(this.appPackageName6);
            Log.d("AddRoutineActivity", "App Package  Name 6" + routine.getAppPackageNameSlot6());
            routine.setAppNameSlot7(this.appName7);
            Log.d("AddRoutineActivity", "App Name 7" + routine.getAppNameSlot7());
            routine.setAppNameSlot7(this.appPackageName7);
            Log.d("AddRoutineActivity", "App Package Name 7" + routine.getAppPackageNameSlot7());
            routine.setAppNameSlot8(this.appName8);
            Log.d("AddRoutineActivity", "App Name 8" + routine.getAppNameSlot8());
            routine.setAppPackageNameSlot8(this.appPackageName8);
            Log.d("AddRoutineActivity", "App Package Name 8" + routine.getAppPackageNameSlot8());
            routine.setAppNameSlot9(this.appName9);
            Log.d("AddRoutineActivity", "App Name 9" + routine.getAppNameSlot9());
            routine.setAppPackageNameSlot9(this.appPackageName9);
            Log.d("AddRoutineActivity", "App Package Name 9" + routine.getAppPackageNameSlot9());
            routine.setAppnameSlot10(this.appName10);
            Log.d("AddRoutineActivity", "App Name 10" + routine.getAppnameSlot10());
            routine.setAppPackageNameSlot10(this.appPackageName10);
            Log.d("AddRoutineActivity", "App Package Name 10" + routine.getAppPackageNameSlot10());
            setDescriptionsRoutineText(routine);
            Log.d("AddRoutineActivity", "DescriptionText " + routine.getDescriptionText());
            routine.setNotfaction(isNotification);
            routine.setRoutinePosition(routineManager2.getRoutineCount());
            Log.d("RoutineSlotManager", "isNotification" + isNotification);
            Log.d("RoutineSlotManager", "routinePosition" + routine.getRoutinePosition());
            closeApp(isShortcut);
            if (isShortcut) {
                this.shortcutManager.AddShotcut(editText2.getText().toString(), routine);
                routine.setRoutineIsShortcut(true);
                routineManager2.saveRoutineList();
            }
            if (isNotification) {
                StartNotification(routine, routine.getRoutinePosition(), this.routineAlarmDate, isEverDay2, isEverWeek2, isEverMonth2, false);
                return;
            }
            routineManager2.addRoutine(routine);
            routineManager2.saveRoutineList();
        }
    }

    private void setDescriptionsRoutineText(Routine routine) {
        switch (routine.getRoutineSlot1()) {
            case 0:
                this.DescriptionText1 = "";
                break;
            case 1:
                this.DescriptionText1 = this.bluetoothOffString;
                break;
            case 2:
                this.DescriptionText1 = this.bluetothOnString;
                break;
            case 3:
                this.DescriptionText1 = this.mediaVolumeMuteString;
                break;
            case 4:
                this.DescriptionText1 = this.mediaVolumeMaxString;
                break;
            case 5:
                this.DescriptionText1 = this.speakerVolumeMute;
                break;
            case 6:
                this.DescriptionText1 = this.speakerVolumeVibration;
                break;
            case 7:
                this.DescriptionText1 = this.speakerVolumeMax;
                break;
            case 8:
                this.DescriptionText1 = this.appName1;
                break;
            case 9:
                this.DescriptionText1 = this.runTimer;
                break;
            case 10:
                this.DescriptionText1 = this.wifiOff;
                break;
            case 11:
                this.DescriptionText1 = this.wifiOn;
                break;
        }
        switch (routine.getRoutineSlot2()) {
            case 0:
                this.DescriptionText2 = "";
                break;
            case 1:
                this.DescriptionText2 = this.bluetoothOffString;
                break;
            case 2:
                this.DescriptionText2 = this.bluetothOnString;
                break;
            case 3:
                this.DescriptionText2 = this.mediaVolumeMuteString;
                break;
            case 4:
                this.DescriptionText2 = this.mediaVolumeMaxString;
                break;
            case 5:
                this.DescriptionText2 = this.speakerVolumeMute;
                break;
            case 6:
                this.DescriptionText2 = this.speakerVolumeVibration;
                break;
            case 7:
                this.DescriptionText2 = this.speakerVolumeMax;
                break;
            case 8:
                this.DescriptionText2 = this.appName2;
                break;
            case 9:
                this.DescriptionText2 = this.runTimer;
                break;
            case 10:
                this.DescriptionText2 = this.wifiOff;
                break;
            case 11:
                this.DescriptionText2 = this.wifiOn;
                break;
        }
        switch (routine.getRoutineSlot3()) {
            case 0:
                this.DescriptionText3 = "";
                break;
            case 1:
                this.DescriptionText3 = this.bluetoothOffString;
                break;
            case 2:
                this.DescriptionText3 = this.bluetothOnString;
                break;
            case 3:
                this.DescriptionText3 = this.mediaVolumeMuteString;
                break;
            case 4:
                this.DescriptionText3 = this.mediaVolumeMaxString;
                break;
            case 5:
                this.DescriptionText3 = this.speakerVolumeMute;
                break;
            case 6:
                this.DescriptionText3 = this.speakerVolumeVibration;
                break;
            case 7:
                this.DescriptionText3 = this.speakerVolumeMax;
                break;
            case 8:
                this.DescriptionText3 = this.appName3;
                break;
            case 9:
                this.DescriptionText3 = this.runTimer;
                break;
            case 10:
                this.DescriptionText3 = this.wifiOff;
                break;
            case 11:
                this.DescriptionText3 = this.wifiOn;
                break;
        }
        switch (routine.getRoutineSlot4()) {
            case 0:
                this.DescriptionText4 = "";
                break;
            case 1:
                this.DescriptionText4 = this.bluetoothOffString;
                break;
            case 2:
                this.DescriptionText4 = this.bluetothOnString;
                break;
            case 3:
                this.DescriptionText4 = this.mediaVolumeMuteString;
                break;
            case 4:
                this.DescriptionText4 = this.mediaVolumeMaxString;
                break;
            case 5:
                this.DescriptionText4 = this.speakerVolumeMute;
                break;
            case 6:
                this.DescriptionText4 = this.speakerVolumeVibration;
                break;
            case 7:
                this.DescriptionText4 = this.speakerVolumeMax;
                break;
            case 8:
                this.DescriptionText4 = this.appName4;
                break;
            case 9:
                this.DescriptionText4 = this.runTimer;
                break;
            case 10:
                this.DescriptionText4 = this.wifiOff;
                break;
            case 11:
                this.DescriptionText4 = this.wifiOn;
                break;
        }
        switch (routine.getRoutineSlot5()) {
            case 0:
                this.DescriptionText5 = "";
                break;
            case 1:
                this.DescriptionText5 = this.bluetoothOffString;
                break;
            case 2:
                this.DescriptionText5 = this.bluetothOnString;
                break;
            case 3:
                this.DescriptionText5 = this.mediaVolumeMuteString;
                break;
            case 4:
                this.DescriptionText5 = this.mediaVolumeMaxString;
                break;
            case 5:
                this.DescriptionText5 = this.speakerVolumeMute;
                break;
            case 6:
                this.DescriptionText5 = this.speakerVolumeVibration;
                break;
            case 7:
                this.DescriptionText5 = this.speakerVolumeMax;
                break;
            case 8:
                this.DescriptionText5 = this.appName5;
                break;
            case 9:
                this.DescriptionText5 = this.runTimer;
                break;
            case 10:
                this.DescriptionText5 = this.wifiOff;
                break;
            case 11:
                this.DescriptionText5 = this.wifiOn;
                break;
        }
        switch (routine.getRoutineSlot6()) {
            case 0:
                this.DescriptionText6 = "";
                break;
            case 1:
                this.DescriptionText6 = this.bluetoothOffString;
                break;
            case 2:
                this.DescriptionText6 = this.bluetothOnString;
                break;
            case 3:
                this.DescriptionText6 = this.mediaVolumeMuteString;
                break;
            case 4:
                this.DescriptionText6 = this.mediaVolumeMaxString;
                break;
            case 5:
                this.DescriptionText6 = this.speakerVolumeMute;
                break;
            case 6:
                this.DescriptionText6 = this.speakerVolumeVibration;
                break;
            case 7:
                this.DescriptionText6 = this.speakerVolumeMax;
                break;
            case 8:
                this.DescriptionText6 = this.appName6;
                break;
            case 9:
                this.DescriptionText6 = this.runTimer;
                break;
            case 10:
                this.DescriptionText6 = this.wifiOff;
                break;
            case 11:
                this.DescriptionText6 = this.wifiOn;
                break;
        }
        switch (routine.getRoutineSlot7()) {
            case 0:
                this.DescriptionText7 = "";
                break;
            case 1:
                this.DescriptionText7 = this.bluetoothOffString;
                break;
            case 2:
                this.DescriptionText7 = this.bluetothOnString;
                break;
            case 3:
                this.DescriptionText7 = this.mediaVolumeMuteString;
                break;
            case 4:
                this.DescriptionText7 = this.mediaVolumeMaxString;
                break;
            case 5:
                this.DescriptionText7 = this.speakerVolumeMute;
                break;
            case 6:
                this.DescriptionText7 = this.speakerVolumeVibration;
                break;
            case 7:
                this.DescriptionText7 = this.speakerVolumeMax;
                break;
            case 8:
                this.DescriptionText7 = this.appName7;
                break;
            case 9:
                this.DescriptionText7 = this.runTimer;
                break;
            case 10:
                this.DescriptionText7 = this.wifiOff;
                break;
            case 11:
                this.DescriptionText7 = this.wifiOn;
                break;
        }
        switch (routine.getRoutineSlot8()) {
            case 0:
                this.DescriptionText8 = "";
                break;
            case 1:
                this.DescriptionText8 = this.bluetoothOffString;
                break;
            case 2:
                this.DescriptionText8 = this.bluetothOnString;
                break;
            case 3:
                this.DescriptionText8 = this.mediaVolumeMuteString;
                break;
            case 4:
                this.DescriptionText8 = this.mediaVolumeMaxString;
                break;
            case 5:
                this.DescriptionText8 = this.speakerVolumeMute;
                break;
            case 6:
                this.DescriptionText8 = this.speakerVolumeVibration;
                break;
            case 7:
                this.DescriptionText8 = this.speakerVolumeMax;
                break;
            case 8:
                this.DescriptionText8 = this.appName8;
                break;
            case 9:
                this.DescriptionText8 = this.runTimer;
                break;
            case 10:
                this.DescriptionText8 = this.wifiOff;
                break;
            case 11:
                this.DescriptionText8 = this.wifiOn;
                break;
        }
        switch (routine.getRoutineSlot9()) {
            case 0:
                this.DescriptionText9 = "";
                break;
            case 1:
                this.DescriptionText9 = this.bluetoothOffString;
                break;
            case 2:
                this.DescriptionText9 = this.bluetothOnString;
                break;
            case 3:
                this.DescriptionText9 = this.mediaVolumeMuteString;
                break;
            case 4:
                this.DescriptionText9 = this.mediaVolumeMaxString;
                break;
            case 5:
                this.DescriptionText9 = this.speakerVolumeMute;
                break;
            case 6:
                this.DescriptionText9 = this.speakerVolumeVibration;
                break;
            case 7:
                this.DescriptionText9 = this.speakerVolumeMax;
                break;
            case 8:
                this.DescriptionText9 = this.appName9;
                break;
            case 9:
                this.DescriptionText9 = this.runTimer;
                break;
            case 10:
                this.DescriptionText9 = this.wifiOff;
                break;
            case 11:
                this.DescriptionText9 = this.wifiOn;
                break;
        }
        switch (routine.getRoutineSlot10()) {
            case 0:
                this.DescriptionText10 = "";
                break;
            case 1:
                this.DescriptionText10 = this.bluetoothOffString;
                break;
            case 2:
                this.DescriptionText10 = this.bluetothOnString;
                break;
            case 3:
                this.DescriptionText10 = this.mediaVolumeMuteString;
                break;
            case 4:
                this.DescriptionText10 = this.mediaVolumeMaxString;
                break;
            case 5:
                this.DescriptionText10 = this.speakerVolumeMute;
                break;
            case 6:
                this.DescriptionText10 = this.speakerVolumeVibration;
                break;
            case 7:
                this.DescriptionText10 = this.speakerVolumeMax;
                break;
            case 8:
                this.DescriptionText10 = this.appName10;
                break;
            case 9:
                this.DescriptionText10 = this.runTimer;
                break;
            case 10:
                this.DescriptionText10 = this.wifiOff;
                break;
            case 11:
                this.DescriptionText10 = this.wifiOn;
                break;
        }
        String str = this.DescriptionText1 + " " + this.DescriptionText2 + " " + this.DescriptionText3 + "" + this.DescriptionText4 + " " + this.DescriptionText5 + "" + this.DescriptionText6 + " " + this.DescriptionText7 + " " + this.DescriptionText8 + " " + this.DescriptionText9 + " " + this.DescriptionText10;
        this.DescriptionTextComplete = str;
        routine.setDescriptionText(str);
    }

    public void updateRoutine(Routine routine, EditText editText2, RoutineManager routineManager2, int position, boolean isShortcut, boolean isNotification, int myYear2, int myMonth2, int myDay2, int myHour2, int myMinute2, int randemCode, String RoutineAlarmDate, boolean isEverDay2, boolean isEverWeek2, boolean isEverMonth2) {
        this.myYear = myYear2;
        this.myMonth = myMonth2;
        this.myDay = myDay2;
        this.myHour = myHour2;
        this.myMinute = myMinute2;
        this.randemQuestCode = randemCode;
        this.routineAlarmDate = this.routineAlarmDate;
        this.isEverDay = isEverDay2;
        this.isEverWeek = isEverWeek2;
        this.isEverMonth = isEverMonth2;
        String newRoutineName = editText2.getText().toString();
        if (newRoutineName.length() > 0) {
            routine.setRoutineName(newRoutineName);
            Log.d("AddRoutineActivity", "Routine Name" + routine.getRoutineName());
            routine.setRoutineSlot1(this.routinelistPositionSlot1);
            Log.d("AddRoutineActivity", "Solt 1 hat den wert = " + routine.getRoutineSlot1());
            routine.setRoutineSlot2(this.routinelistPositionSlot2);
            Log.d("AddRoutineActivity", "Solt 2 hat den wert = " + routine.getRoutineSlot2());
            routine.setRoutineSlot3(this.routinelistPositionSlot3);
            Log.d("AddRoutineActivity", "Solt 3 hat den wert =" + routine.getRoutineSlot3());
            routine.setRoutineSlot4(this.routinelistPositionSlot4);
            Log.d("AddRoutineActivity", "Solt 4 hat den wert =" + routine.getRoutineSlot4());
            routine.setRoutineSlot5(this.routinelistPositionSlot5);
            Log.d("AddRoutineActivity", "Solt 5 hat den wert =" + routine.getRoutineSlot5());
            routine.setRoutineSlot6(this.routinelistPositionSlot6);
            Log.d("AddRoutineActivity", "Solt 6 hat den wert =" + routine.getRoutineSlot6());
            routine.setRoutineSlot7(this.routinelistPositionSlot7);
            Log.d("AddRoutineActivity", "Solt 7 hat den wert =" + routine.getRoutineSlot7());
            routine.setRoutineSlot8(this.routinelistPositionSlot8);
            Log.d("AddRoutineActivity", "Solt 8 hat den wert =" + routine.getRoutineSlot8());
            routine.setRoutineSlot9(this.routinelistPositionSlot9);
            Log.d("AddRoutineActivity", "Solt 9 hat den wert =" + routine.getRoutineSlot9());
            routine.setRoutineSlot10(this.routinelistPositionSlot10);
            Log.d("AddRoutineActivity", "Solt 10 hat den wert =" + routine.getRoutineSlot10());
            routine.setTimerName(this.timerName);
            Log.d("AddRoutineActivity", "Timer Name  =" + routine.getTimerName());
            routine.setTimerSeconds(this.timerSeconds);
            Log.d("AddRoutineActivity", "Timer Seconds  =" + routine.getTimerSeconds());
            routine.setTimerMinutes(this.timerMinutes);
            Log.d("AddRoutineActivity", "Timer Minutes  =" + routine.getTimerMinutes());
            routine.setTimerHours(this.timerHours);
            Log.d("AddRoutineActivity", "Timer Hour  =" + routine.getTimerHours());
            routine.setAppNameSlot1(this.appName1);
            Log.d("AddRoutineActivity", "App Name 1" + routine.getAppNameSlot1());
            routine.setAppPackageNameSlot1(this.appPackageName1);
            Log.d("AddRoutineActivity", "App Package Name 1" + routine.getAppPackageNameSlot1());
            routine.setAppNameSlot2(this.appName2);
            Log.d("AddRoutineActivity", "App Name 2" + routine.getAppNameSlot2());
            routine.setAppPackageNameSlot2(this.appPackageName2);
            Log.d("AddRoutineActivity", "App Package  Name 2" + routine.getAppPackageNameSlot2());
            routine.setAppNameSlot3(this.appName3);
            Log.d("AddRoutineActivity", "App Name 3" + routine.getAppNameSlot3());
            routine.setAppPackageNameSlot3(this.appPackageName3);
            Log.d("AddRoutineActivity", "App Package Name" + routine.getAppPackageNameSlot3());
            routine.setAppNameSlot4(this.appName4);
            Log.d("AddRoutineActivity", "App Name 4" + routine.getAppNameSlot4());
            routine.setAppPackageNameSlot4(this.appPackageName4);
            Log.d("AddRoutineActivity", "App Package Name " + routine.getAppPackageNameSlot4());
            routine.setAppNameSlot5(this.appName5);
            Log.d("AddRoutineActivity", "App Name 5" + routine.getAppNameSlot5());
            routine.setAppPackageNameSlot5(this.appPackageName5);
            Log.d("AddRoutineActivity", "App  Package Name" + routine.getAppPackageNameSlot5());
            routine.setAppNameSlot6(this.appName6);
            Log.d("AddRoutineActivity", "App Name 6" + routine.getAppNameSlot6());
            routine.setAppNameSlot6(this.appPackageName6);
            Log.d("AddRoutineActivity", "App Package  Name 6" + routine.getAppPackageNameSlot6());
            routine.setAppNameSlot7(this.appName7);
            Log.d("AddRoutineActivity", "App Name 7" + routine.getAppNameSlot7());
            routine.setAppNameSlot7(this.appPackageName7);
            Log.d("AddRoutineActivity", "App Package Name 7" + routine.getAppPackageNameSlot7());
            routine.setAppNameSlot8(this.appName8);
            Log.d("AddRoutineActivity", "App Name 8" + routine.getAppNameSlot8());
            routine.setAppPackageNameSlot8(this.appPackageName8);
            Log.d("AddRoutineActivity", "App Package Name 8" + routine.getAppPackageNameSlot8());
            routine.setAppNameSlot9(this.appName9);
            Log.d("AddRoutineActivity", "App Name 9" + routine.getAppNameSlot9());
            routine.setAppPackageNameSlot9(this.appPackageName9);
            Log.d("AddRoutineActivity", "App Package Name 9" + routine.getAppPackageNameSlot9());
            routine.setAppnameSlot10(this.appName10);
            Log.d("AddRoutineActivity", "App Name 10" + routine.getAppnameSlot10());
            routine.setAppPackageNameSlot10(this.appPackageName10);
            Log.d("AddRoutineActivity", "App Package Name 10" + routine.getAppPackageNameSlot10());
            setDescriptionsRoutineText(routine);
            Log.d("AddRoutineActivity", "DescriptionText " + routine.getDescriptionText());
            routineManager2.routineList.set(position, routine);
            routine.setRoutinePosition(position);
            routine.setNotfaction(this.oldRoutine.getIsNotification());
            Log.d("routineManagerM", "position" + position);
            routineManager2.saveRoutineList();
            closeApp(isShortcut);
            if (!routine.getRoutineIsShortcut() && isShortcut) {
                this.shortcutManager.AddShotcut(editText2.getText().toString(), routine);
            }
            if (isNotification && 1 != 0) {
                StartNotification(routine, routine.getRoutinePosition(), this.routineAlarmDate, isEverDay2, isEverWeek2, isEverMonth2, true);
            }
        }
    }

    public void getTimerSettings(int timerSeconds2, int timerMinutes2, int timerHours2, String timerName2) {
        this.timerSeconds = timerSeconds2;
        this.timerMinutes = timerMinutes2;
        this.timerHours = timerHours2;
        this.timerName = timerName2;
        Log.d("AddAcivity", "seconds im RoutineSlotManger  " + this.timerSeconds);
        Log.d("AddAcivity", "minutes  im RoutineSlotManger " + this.timerMinutes);
        Log.d("AddAcivity", "hour in  RoutineSlotManger " + this.timerHours);
        Log.d("AddAcivity", "name im RoutineSlotManger" + this.timerName);
    }

    private void closeApp(boolean isShortcut) {
        this.activity.finish();
        this.activity.startActivity(new Intent(this.context.getApplicationContext(), MainActivity.class));
    }

    public void StartNotification(Routine routine, int position, String routineAlarmDate2, boolean isEverDay2, boolean isEverWeek2, boolean isEverMonth2, boolean update) {
        this.routineManager = new RoutineManager(this.context);
        Log.d("RoutineSlotManager", "Notification gestarttet");
        routine.setNotfaction(true);
        routine.setRoutineAlarmDate(routineAlarmDate2);
        routine.setIsEveryDay(isEverDay2);
        routine.setIsEveryWeek(isEverWeek2);
        routine.setIsEveryMonth(isEverMonth2);
        this.routineManager.saveRoutineList();
        Intent intent = new Intent();
        Log.d("RoutineSlotManager", "Day" + this.myDay);
      com.mn.myroutines.NotificationManager notificationManager = new NotificationManager(context, routineManager, intent);
        notificationManager.startAlarm(routine, this.randemQuestCode, this.myYear, this.myMonth, this.myDay, this.myHour, this.myMinute, routineAlarmDate2);

        if(routine.isNotfaction){
            notificationManager.cancelAlarm(routine);
            Log.d("RoutineSlotManager", "position notification" + routine.getRoutinePosition());
            notificationManager.updateStartAlarm(routine.routinePosition, routine, this.myYear, this.myMonth, this.myDay, this.myHour, this.myMinute, this.routinebiggerThanMonth,  this.monthplus1, this.monthplus2, this.monthplus3, this.monthplus4, this.monthplus5, this.monthplus6, this.monthplus7, this.monthplus8, this.monthplus9, this.monthplus10, this.monthplus11, this.monthplus12, this.monthplus13, this.monthplus14, this.monthplus15, this.monthplus16, this.monthplus17, this.monthplus18, this.monthplus19, this.monthplus20,this.monthplus21, this.monthplus22, this.monthplus23, this.monthplus24, this.monthplus25, this.monthplus26, this.monthplus27, this.monthplus28,this.monthplus29, this.monthplus30);
            new NotificationHelper(this.context, intent);
            if (!update) {
                this.routineManager.addRoutine(routine);
                routine.setRoutinePosition(this.routineManager.getRoutineCount());
                this.routineManager.saveRoutineList();
                return;
            }
            this.routineManager.routineList.set(position, routine);
            this.routineManager.saveRoutineList();
        }
        }


}
