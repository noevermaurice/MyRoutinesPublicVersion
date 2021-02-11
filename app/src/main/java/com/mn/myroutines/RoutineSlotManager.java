package com.mn.myroutines;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class RoutineSlotManager {
    // Objects Deklartation
    ListView listView;
    Context context;
    ListviewAdapterRoutine listviewAdapterRoutine;
    public String ArrayListSlotDefault;
    public String newActionString;
    public String noActionString;
    public String bluetoothOffString;
    private String bluetothOnString;
    private String mediaVolumeMuteString;
    private String mediaVolumeMaxString;
    private String speakerVolumeMute;
    private String speakerVolumeVibration;
    private String speakerVolumeMax;
    private String runApp;
    private String runTimer;
    private String timerName;
    public String appName;
    public String appName1;
    public String appName2;
    public String appName3;
    public String appName4;
    public String appName5;
    public String appName6;
    public String appName7;
    public String appName8;
    public String appName9;
    public String appName10;
    public String appPackageName;
    public String appPackageName1;
    public String appPackageName2;
    public String appPackageName3;
    public String appPackageName4;
    public String appPackageName5;
    public String appPackageName6;
    public String appPackageName7;
    public String appPackageName8;
    public String appPackageName9;
    public String appPackageName10;
    int listviewItemPosition;
    int routinelistPositionSlot1;
    int routinelistPositionSlot2;
    int routinelistPositionSlot3;
    int routinelistPositionSlot4;
    int routinelistPositionSlot5;
    int routinelistPositionSlot6;
    int routinelistPositionSlot7;
    int routinelistPositionSlot8;
    int routinelistPositionSlot9;
    int routinelistPositionSlot10;
    public int whichSlotPosition;
    int timerSeconds;
    int timerMinutes;
    int timerHours;
    EditText editText;
    Activity activity = (Activity) context;


    public RoutineSlotManager(Context context, ListView listView, ListviewAdapterRoutine listviewAdapterRoutine, String ArrayListSlotDefault, String newActionString, String noActionString, String bluetoothOffString, String bluetothOnString, String mediaVolumeMuteString, String mediaVolumeMaxString, String speakerVolumeMute, String speakerVolumeVibration, String speakerVolumeMax, String runApp, String runTimer, int listviewItemPosition, int routinelistPositionSlot1, int routinelistPositionSlot2, int routinelistPositionSlot3, int routinelistPositionSlot4, int routinelistPositionSlot5, int routinelistPositionSlot6, int routinelistPositionSlot7, int routinelistPositionSlot8, int routinelistPositionSlot9, int routinelistPositionSlot10, int whichSlotPosition, int timerSeconds, int timerMinutes, int timerHours, String timerName, EditText editText) {
        //
        this.context = context;
        this.listView = listView;
        this.listviewAdapterRoutine = listviewAdapterRoutine;
        this.ArrayListSlotDefault = ArrayListSlotDefault;
        this.newActionString = newActionString;
        this.noActionString = noActionString;
        this.bluetoothOffString = bluetoothOffString;
        this.bluetothOnString = bluetothOnString;
        this.mediaVolumeMuteString = mediaVolumeMuteString;
        this.speakerVolumeVibration = speakerVolumeVibration;
        this.mediaVolumeMaxString = mediaVolumeMaxString;
        this.speakerVolumeMute = speakerVolumeMute;
        this.speakerVolumeMax = speakerVolumeMax;
        this.runApp = runApp;
        this.runTimer = runTimer;
        this.listviewItemPosition = listviewItemPosition;
        this.routinelistPositionSlot1 = routinelistPositionSlot1;
        this.routinelistPositionSlot2 = routinelistPositionSlot2;
        this.routinelistPositionSlot3 = routinelistPositionSlot3;
        this.routinelistPositionSlot4 = routinelistPositionSlot4;
        this.routinelistPositionSlot5 = routinelistPositionSlot5;
        this.routinelistPositionSlot6 = routinelistPositionSlot6;
        this.routinelistPositionSlot7 = routinelistPositionSlot7;
        this.routinelistPositionSlot8 = routinelistPositionSlot8;
        this.routinelistPositionSlot9 = routinelistPositionSlot9;
        this.routinelistPositionSlot10 = routinelistPositionSlot10;
        this.whichSlotPosition = whichSlotPosition;
        this.timerSeconds = timerSeconds;
        this.timerMinutes = timerMinutes;
        this.timerHours = timerHours;
        this.timerName = timerName;
        this.editText = editText;

    }

    public void setDefaultSlots() {
        // add Dedault array list
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listviewAdapterRoutine.arrayListSlots.add(ArrayListSlotDefault);
        listView.setAdapter(listviewAdapterRoutine);
    }

    public void getRoutineSlotActions(Routine oldRoutine) {
        editText.setText(oldRoutine.getRoutineName());
// with swich check with number has oldroutine Slot and list update
        // for loop for oldRoutine1
        for (int casesSlot1 = 0; casesSlot1 < 10; casesSlot1++) {

            setWhichSlotPosition(oldRoutine.routineSlotEins);
            setRoutineSlots(oldRoutine.getRoutineSlot1());
        }
        // for loop for oldRoutine1
        for (int casesSlot2 = 0; casesSlot2 < 10; casesSlot2++) {
            setWhichSlotPosition(oldRoutine.routineSlotZwei);
            setRoutineSlots(oldRoutine.getRoutineSlot2());
        }

        // for loop for oldRoutine3
        for (int casesSlot3 = 0; casesSlot3 < 10; casesSlot3++) {
            setWhichSlotPosition(oldRoutine.routineSlotDrei);
            setRoutineSlots(oldRoutine.getRoutineSlot3());
        }

        // for loop for oldRoutine4
        for (int casesSlot4 = 0; casesSlot4 < 10; casesSlot4++) {
            setWhichSlotPosition(oldRoutine.routineSlotVier);
            setRoutineSlots(oldRoutine.getRoutineSlot4());
        }
        // for loop for oldRoutine5
        for (int casesSlot5 = 0; casesSlot5 < 10; casesSlot5++) {
            setWhichSlotPosition(oldRoutine.routineSlotFünf);
            setRoutineSlots(oldRoutine.getRoutineSlot5());
        }
        // for loop for oldRoutine6
        for (int casesSlot6 = 0; casesSlot6 < 10; casesSlot6++) {
            setWhichSlotPosition(oldRoutine.routineSlotSechs);
            setRoutineSlots(oldRoutine.getRoutineSlot6());
        }
        // for loop for oldRoutine7
        for (int casesSlot7 = 0; casesSlot7 < 10; casesSlot7++) {
            setWhichSlotPosition(oldRoutine.routineSlotSieben);
            setRoutineSlots(oldRoutine.getRoutineSlot7());
        }
        // for loop for oldRoutine8
        for (int casesSlot8 = 0; casesSlot8 < 10; casesSlot8++) {
            setWhichSlotPosition(oldRoutine.routineSlotAcht);
            setRoutineSlots(oldRoutine.getRoutineSlot8());
        }
        // for loop for oldRoutine9
        for (int casesSlot9 = 0; casesSlot9 < 10; casesSlot9++) {
            setWhichSlotPosition(oldRoutine.routineSlotNeun);
            setRoutineSlots(oldRoutine.getRoutineSlot9());
        }
        // for loop for oldRoutine10
        for (int casesSlot10 = 0; casesSlot10 < 10; casesSlot10++) {
            setWhichSlotPosition(oldRoutine.routineSlotZehn);
            setRoutineSlots(oldRoutine.getRoutineSlot10());
        }


    }

    public void setRoutineSlots(int selectActionPosition) {
        // check with selectActionPosition witch action was clicked
        switch (selectActionPosition) {
            case 0:
                // check with whichSlotposition witch slot was clicked
                if (whichSlotPosition == 0) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 1) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 2) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 3) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 4) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 5) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 6) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 7) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 8) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 9) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                }

                break;

            case 1:
                // check with whichSlotposition witch slot was clicked
                if (whichSlotPosition == 0) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 1) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 2) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 3) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 4) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 5) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 6) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 7) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 8) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 9) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                }

                break;

            case 2:
                // check with whichSlotposition witch slot was clicked
                if (whichSlotPosition == 0) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 1) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 2) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 3) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 4) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 5) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 6) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 7) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 8) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 9) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                }

                break;

            case 3:
                // check with whichSlotposition witch slot was clicked
                if (whichSlotPosition == 0) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 1) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 2) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 3) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 4) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 5) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 6) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 7) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 8) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 9) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                }

                break;


            case 4:
                // check with whichSlotposition witch slot was clicked
                if (whichSlotPosition == 0) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 1) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 2) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 3) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 4) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 5) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 6) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 7) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 8) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 9) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                }

                break;

            case 5:
                // check with whichSlotposition witch slot was clicked
                if (whichSlotPosition == 0) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 1) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 2) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 3) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 4) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 5) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 6) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 7) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 8) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 9) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                }

                break;

            case 6:
                // check with whichSlotposition witch slot was clicked
                if (whichSlotPosition == 0) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 1) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 2) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 3) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 4) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 5) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 6) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 7) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 8) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 9) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                }

                break;

            case 7:
                // check with whichSlotposition witch slot was clicked
                if (whichSlotPosition == 0) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 1) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 2) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 3) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 4) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 5) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 6) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 7) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 8) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 9) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                }

                break;

            case 8:
                // check with whichSlotposition witch slot was clicked
                if (whichSlotPosition == 0) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 1) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 2) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 3) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 4) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 5) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 6) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 7) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 8) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 9) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                }

                break;

            case 9:
                // check with whichSlotposition witch slot was clicked
                if (whichSlotPosition == 0) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot1 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 1) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot2 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 2) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot3 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 3) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot4 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 4) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot5 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 5) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot6 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 6) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot7 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 7) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot8 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 8) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot9 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                } else if (whichSlotPosition == 9) {
                    listviewItemPosition = selectActionPosition;
                    routinelistPositionSlot10 = selectActionPosition;
                    setNewAction();
                    Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                    Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
                }

                break;


        }


    }

    public void setWhichSlotPosition(int position) {

        // check  with swich which slot was click
        switch (position) {
            case 0:
                whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot  " + whichSlotPosition + "  wurde gerdückt");
                break;

            case 1:
                whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot " + whichSlotPosition + "  wurde gerdückt");
                break;

            case 2:
                whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot " + whichSlotPosition + "wurde gerdückt");
                break;

            case 3:
                whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot " + whichSlotPosition + "wurde gerdückt");
                break;

            case 4:
                whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot " + whichSlotPosition + "wurde gerdückt");
                break;

            case 5:
                whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot " + whichSlotPosition + "wurde gerdückt");
                break;

            case 6:
                whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot " + whichSlotPosition + "wurde gerdückt");
                break;
            case 7:
                whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot " + whichSlotPosition + "wurde gerdückt");
                break;

            case 8:
                whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot " + whichSlotPosition + "wurde gerdückt");
                break;

            case 9:
                whichSlotPosition = position;
                Log.d("RoutineSlotManager", "Slot " + whichSlotPosition + "wurde gerdückt");
                break;


        }

    }

    public void setNewAction() {
        switch (listviewItemPosition) {
            case 0:
                newActionString = noActionString;
                break;

            case 1:
                newActionString = bluetoothOffString;
                break;

            case 2:
                newActionString = bluetothOnString;
                break;

            case 3:
                newActionString = mediaVolumeMuteString;
                break;

            case 4:
                newActionString = mediaVolumeMaxString;
                break;

            case 5:
                newActionString = speakerVolumeMute;
                break;
            case 6:
                newActionString = speakerVolumeVibration;
                break;
            case 7:
                newActionString = speakerVolumeMax;
                break;
            case 8:
                setAppSlotName();
                break;
            case 9:
                newActionString = runTimer;
                break;

        }

        listView.setAdapter(listviewAdapterRoutine);
        listviewAdapterRoutine.arrayListSlots.set(whichSlotPosition, newActionString);
    }

    private void setAppSlotName() {
        if (appName1 != null){
            newActionString = appName1;
            Log.d("runApp","Slot Name =" + appName1);
        }

        if (appName2 != null){
            newActionString = appName2;
            Log.d("runApp","Slot Name " + appName2);
        }

        if (appName3 != null){
            newActionString = appName3;
            Log.d("runApp", "Slot Name" + appName3);
        }

        if (appName4 != null){
            Log.d("runApp","Slot Name" + appName4);
        }
        if (appName5 != null){
            Log.d("runApp", "Slot Name" + appName5);
        }

        if (appName6 != null){
            Log.d("runApp", "Slot Name" + appName6);
        }
        if (appName7 != null){
            Log.d("runApp", "Slot Name" + appName7);
        }
        if (appName8 != null){
            Log.d("runApp", "Slot Name" + appName8);
        }
        if (appName9 != null){
            Log.d("runApp", "Slot Name" + appName9);
        }
        if (appName10 != null){
            Log.d("runApp", "Slot Name" +appName10);
        }
    }

    public void createRoutine(Routine routine, EditText editText, RoutineManager routineManager) {


        String newRoutineName = editText.getText().toString();
        if (newRoutineName.length() > 0) {
            routine.setRoutineName(newRoutineName);
            Log.d("AddRoutineActivity", "Routine Name" + routine.getRoutineName());
            routine.setRoutineSlot1(routinelistPositionSlot1);
            Log.d("AddRoutineActivity", "Solt 1 hat den wert = " + routine.getRoutineSlot1());
            // set Slot position nummer2
            routine.setRoutineSlot2(routinelistPositionSlot2);
            Log.d("AddRoutineActivity", "Solt 2 hat den wert = " + routine.getRoutineSlot2());
            // set Slot position nummer3
            routine.setRoutineSlot3(routinelistPositionSlot3);
            Log.d("AddRoutineActivity", "Solt 3 hat den wert =" + routine.getRoutineSlot3());
            // set Slot position nummer4
            routine.setRoutineSlot4(routinelistPositionSlot4);
            Log.d("AddRoutineActivity", "Solt 4 hat den wert =" + routine.getRoutineSlot4());
            // set Slot position nummer5
            routine.setRoutineSlot5(routinelistPositionSlot5);
            Log.d("AddRoutineActivity", "Solt 5 hat den wert =" + routine.getRoutineSlot5());
            // set Slot position nummer6
            routine.setRoutineSlot6(routinelistPositionSlot6);
            Log.d("AddRoutineActivity", "Solt 6 hat den wert =" + routine.getRoutineSlot6());
            // set Slot position nummer7
            routine.setRoutineSlot7(routinelistPositionSlot7);
            Log.d("AddRoutineActivity", "Solt 7 hat den wert =" + routine.getRoutineSlot7());
            // set Slot position nummer8
            routine.setRoutineSlot8(routinelistPositionSlot8);
            Log.d("AddRoutineActivity", "Solt 8 hat den wert =" + routine.getRoutineSlot8());
            // set Slot position nummer9
            routine.setRoutineSlot9(routinelistPositionSlot9);
            Log.d("AddRoutineActivity", "Solt 9 hat den wert =" + routine.getRoutineSlot9());
            // set Slot position nummer9
            routine.setRoutineSlot10(routinelistPositionSlot10);
            Log.d("AddRoutineActivity", "Solt 10 hat den wert =" + routine.getRoutineSlot10());
            //set Timer Name
            routine.setTimerName(timerName);
            Log.d("AddRoutineActivity", "Timer Name  =" + routine.getTimerName());
            routine.setTimerSeconds(timerSeconds);
            Log.d("AddRoutineActivity", "Timer Seconds  =" + routine.getTimerSeconds());
            routine.setTimerMinutes(timerMinutes);
            Log.d("AddRoutineActivity", "Timer Minutes  =" + routine.getTimerMinutes());
            routine.setTimerHours(timerHours);
            Log.d("AddRoutineActivity", "Timer Hour  =" + routine.getTimerHours());
            routineManager.addRoutine(routine);
            // save changes into the list
            routineManager.saveRoutineList();
        }

    }

    public void updateRoutine(Routine routine, EditText editText, RoutineManager routineManager, int position) {
        String newRoutineName = editText.getText().toString();
        if (newRoutineName.length() > 0) {
            routine.setRoutineName(newRoutineName);
            Log.d("AddRoutineActivity", "Routine Name" + routine.getRoutineName());
            routine.setRoutineSlot1(routinelistPositionSlot1);
            Log.d("AddRoutineActivity", "Solt 1 hat den wert = " + routine.getRoutineSlot1());
            // set Slot position nummer2
            routine.setRoutineSlot2(routinelistPositionSlot2);
            Log.d("AddRoutineActivity", "Solt 2 hat den wert = " + routine.getRoutineSlot2());
            // set Slot position nummer3
            routine.setRoutineSlot3(routinelistPositionSlot3);
            Log.d("AddRoutineActivity", "Solt 3 hat den wert =" + routine.getRoutineSlot3());
            // set Slot position nummer4
            routine.setRoutineSlot4(routinelistPositionSlot4);
            Log.d("AddRoutineActivity", "Solt 4 hat den wert =" + routine.getRoutineSlot4());
            // set Slot position nummer5
            routine.setRoutineSlot5(routinelistPositionSlot5);
            Log.d("AddRoutineActivity", "Solt 5 hat den wert =" + routine.getRoutineSlot5());
            // set Slot position nummer6
            routine.setRoutineSlot6(routinelistPositionSlot6);
            Log.d("AddRoutineActivity", "Solt 6 hat den wert =" + routine.getRoutineSlot6());
            // set Slot position nummer7
            routine.setRoutineSlot7(routinelistPositionSlot7);
            Log.d("AddRoutineActivity", "Solt 7 hat den wert =" + routine.getRoutineSlot7());
            // set Slot position nummer8
            routine.setRoutineSlot8(routinelistPositionSlot8);
            Log.d("AddRoutineActivity", "Solt 8 hat den wert =" + routine.getRoutineSlot8());
            // set Slot position nummer9
            routine.setRoutineSlot9(routinelistPositionSlot9);
            Log.d("AddRoutineActivity", "Solt 9 hat den wert =" + routine.getRoutineSlot9());
            // set Slot position nummer9
            routine.setRoutineSlot10(routinelistPositionSlot10);
            Log.d("AddRoutineActivity", "Solt 10 hat den wert =" + routine.getRoutineSlot10());
            //set Timer Name
            routine.setTimerName(timerName);
            Log.d("AddRoutineActivity", "Timer Name  =" + routine.getTimerName());
            routine.setTimerSeconds(timerSeconds);
            Log.d("AddRoutineActivity", "Timer Seconds  =" + routine.getTimerSeconds());
            routine.setTimerMinutes(timerMinutes);
            Log.d("AddRoutineActivity", "Timer Minutes  =" + routine.getTimerMinutes());
            routine.setTimerHours(timerHours);
            Log.d("AddRoutineActivity", "Timer Hour  =" + routine.getTimerHours());
            // save changes into the list
            routineManager.routineList.set(position, routine);
            routineManager.saveRoutineList();

        }
    }


        public void getTimerSettings ( int timerSeconds, int timerMinutes, int timerHours, String
        timerName){
            this.timerSeconds = timerSeconds;
            Log.d("t", "s =" + timerSeconds);
            this.timerMinutes = timerMinutes;
            this.timerHours = timerHours;
            this.timerName = timerName;
        }

        public void getAppNameAndPackage(String appName, String appPackageName){

        if (whichSlotPosition == 0){
            this.appName1 = appName;
            Log.d("run App", "Name " + this.appName1);
            this.appPackageName1 = appPackageName;
            Log.d("run App", "NP" + this.appPackageName1);
        } else if (whichSlotPosition == 1){
            this.appName2 = appName;
            Log.d("run App", "Name" + this.appName2);
            this.appPackageName2 = appPackageName;
            Log.d("run App", "NP" + this.appPackageName2);
        } else if (whichSlotPosition == 2){
            this.appName3 = appName;
            Log.d("run App", "Name" + this.appName3);
            this.appPackageName3 = appPackageName;
            Log.d("run App", "NP" + this.appPackageName3);
        } else if (whichSlotPosition == 3){
            this.appName4 = appName;
            Log.d("run App", "Name" + this.appName4);
            this.appPackageName4 = appPackageName;
            Log.d("run App", "NP" + this.appPackageName4);
        } else if (whichSlotPosition == 4){
            this.appName5 = appName;
            Log.d("run App", "Name" + this.appName5);
            this.appPackageName5 = appPackageName;
            Log.d("run App", "NP" + this.appPackageName5);
        } else if (whichSlotPosition == 5){
            this.appName6 = appName;
            Log.d("run App", "Name" + this.appName6);
            this.appPackageName6 = appPackageName;
            Log.d("run App", "NP" + this.appPackageName6);
        } else if (whichSlotPosition == 6){
            this.appName7 = appName;
            Log.d("run App", "Name" + this.appName7);
            this.appPackageName7 = appPackageName;
            Log.d("run App", "NP" + this.appPackageName7);
        } else if (whichSlotPosition == 7){
            this.appName8 = appName;
            Log.d("run App", "Name" + this.appName8);
            this.appPackageName8 = appPackageName;
            Log.d("run App", "NP" + this.appPackageName8);
        } else if (whichSlotPosition == 8){
            this.appName9 = appName;
            Log.d("run App", "Name" + this.appName9);
            this.appPackageName9 = appPackageName;
            Log.d("run App", "NP" + this.appPackageName9);
        } else if (whichSlotPosition == 9){
            this.appName10 = appName;
            Log.d("run App", "Name" + this.appName10);
            this.appPackageName10 = appPackageName;
            Log.d("run App", "NP" + this.appPackageName10);
        }

        }


    }

