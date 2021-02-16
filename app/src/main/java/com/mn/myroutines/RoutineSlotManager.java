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
    public String  DescriptionText1;
    public String DescriptionText2;
    public String DescriptionText3;
    public String DescriptionText4;
    public String DescriptionText5;
    public String  DescriptionText6;
    public String DescriptionText7;
    public String DescriptionText8;
    public String DescriptionText9;
    public String DescriptionText10;
    public String DescriptionTextComplete;
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
    Routine oldRoutine;


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
        this. oldRoutine = oldRoutine;
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
                if (oldRoutine != null){
                    getAppSlotName();
                }
                break;
            case 9:
                newActionString = runTimer;
                break;

        }

        listView.setAdapter(listviewAdapterRoutine);
        listviewAdapterRoutine.arrayListSlots.set(whichSlotPosition, newActionString);
    }

    private void getAppSlotName() {
        // get app name from routine and set the slot name
        switch (whichSlotPosition) {
            case 0:
                if (oldRoutine.getAppNameSlot1() != null) {
                    newActionString = oldRoutine.getAppNameSlot1();
                    appName1 = oldRoutine.getAppNameSlot1();
                }
                break;
            case 1:
                if (oldRoutine.getAppNameSlot2() != null) {
                    newActionString = oldRoutine.getAppNameSlot2();
                    appName2 = oldRoutine.getAppNameSlot2();
                }
                break;
            case 2:
                if (oldRoutine.getAppNameSlot3() != null) {
                    newActionString = oldRoutine.getAppNameSlot3();
                    appName3 = oldRoutine.getAppNameSlot3();
                }
                break;
            case 3:
                if (oldRoutine.getAppNameSlot4() != null) {
                    newActionString = oldRoutine.getAppNameSlot4();
                    appName4 = oldRoutine.getAppNameSlot4();
                }
                break;
            case 4:
            if (oldRoutine.getAppNameSlot5() != null) {
                newActionString = oldRoutine.getAppNameSlot5();
                appName5 = oldRoutine.getAppNameSlot5();
            }
            break;
            case 5:
                if (oldRoutine.getAppNameSlot6() != null) {
                    newActionString = oldRoutine.getAppNameSlot6();
                    appName6 = oldRoutine.getAppNameSlot6();
                }
                break;
            case 6:
                if (oldRoutine.getAppNameSlot7() != null) {
                    newActionString = oldRoutine.getAppNameSlot7();
                    appName7 = oldRoutine.getAppNameSlot7();
                }
                break;
            case 7:
                if (oldRoutine.getAppNameSlot8() != null) {
                    newActionString = oldRoutine.getAppNameSlot8();
                    appName8 = oldRoutine.getAppNameSlot8();
                }
                break;
            case 8:
                if (oldRoutine.getAppNameSlot9() != null) {
                    newActionString = oldRoutine.getAppNameSlot9();
                    appName9 = oldRoutine.getAppNameSlot9();
                }
                break;
            case 9:
            if (oldRoutine.getAppnameSlot10() != null) {
                newActionString = oldRoutine.getAppnameSlot10();
                appName10 = oldRoutine.getAppnameSlot10();
            }
           break;
        }
    }

    private void setAppSlotName() {


        switch (whichSlotPosition){
            case 0:
                if (appName1 != null){
                    newActionString = appName1;
                    Log.d("runApp","Slot Name =" + appName1);
                }
                break;

            case 1:
                if (appName2 != null){
                    newActionString = appName2;
                    Log.d("runApp","Slot Name =" + appName2);
                }
                break;

            case 2:
                if (appName3!= null){
                    newActionString = appName3;
                    Log.d("runApp","Slot Name =" + appName3);
                }
                break;

            case 3:
                if (appName4!= null){
                    newActionString = appName4;
                    Log.d("runApp","Slot Name =" + appName4);
                }
                break;

            case 4:
                if (appName5!= null){
                    newActionString = appName5;
                    Log.d("runApp","Slot Name =" + appName5);
                }
                break;

            case 5:
                if (appName6!= null){
                    newActionString = appName6;
                    Log.d("runApp","Slot Name =" + appName6);
                }
                break;

            case 6:
                if (appName7!= null){
                    newActionString = appName7;
                    Log.d("runApp","Slot Name =" + appName7);
                }
                break;
            case 7:
                if (appName8!= null){
                    newActionString = appName8;
                    Log.d("runApp","Slot Name =" + appName8);
                }
                break;

            case 8:
                if (appName9!= null){
                    newActionString = appName9;
                    Log.d("runApp","Slot Name =" + appName9);
                }
                break;

            case 9:
                if (appName10!= null){
                    newActionString = appName10;
                    Log.d("runApp","Slot Name =" + appName10);
                }
                break;

        }

    }

    public void getAppNameAndPackage(String appName, String appPackageName){

        if (whichSlotPosition == 0){
            this.appName1 = appName;
            Log.d("runApp", "Name " + this.appName1);
            this.appPackageName1 = appPackageName;
            Log.d("runApp", "NP" + this.appPackageName1);
        } else if (whichSlotPosition == 1){
            this.appName2 = appName;
            Log.d("runApp", "Name" + this.appName2);
            this.appPackageName2 = appPackageName;
            Log.d("runApp", "NP" + this.appPackageName2);
        } else if (whichSlotPosition == 2){
            this.appName3 = appName;
            Log.d("runApp", "name" + this.appName3);
            this.appPackageName3 = appPackageName;
            Log.d("runApp", "NP" + this.appPackageName3);
        } else if (whichSlotPosition == 3){
            this.appName4 = appName;
            Log.d("runApp", "name" + this.appName4);
            this.appPackageName4 = appPackageName;
            Log.d("runApp", "NP" + this.appPackageName4);
        } else if (whichSlotPosition == 4){
            this.appName5 = appName;
            Log.d("runApp", "name" + this.appName5);
            this.appPackageName5 = appPackageName;
            Log.d("runApp", "NP" + this.appPackageName5);
        } else if (whichSlotPosition == 5){
            this.appName6 = appName;
            Log.d("runApp", "name" + this.appName6);
            this.appPackageName6 = appPackageName;
            Log.d("runApp", "NP" + this.appPackageName6);
        } else if (whichSlotPosition == 6){
            this.appName7 = appName;
            Log.d("runApp", "name" + this.appName7);
            this.appPackageName7 = appPackageName;
            Log.d("runApp", "NP" + this.appPackageName7);
        } else if (whichSlotPosition == 7) {
            this.appName8 = appName;
            Log.d("runApp", "name" + this.appName8);
            this.appPackageName8 = appPackageName;
            Log.d("runApp", "NP" + this.appPackageName8);
        } else if (whichSlotPosition == 8){
            this.appName9 = appName;
            Log.d("runApp", "name" + this.appName9);
            this.appPackageName9 = appPackageName;
            Log.d("runApp", "NP" + this.appPackageName9);
        } else if (whichSlotPosition == 9){
            this.appName10 = appName;
            Log.d("runApp", "name" + this.appName10);
            this.appPackageName10 = appPackageName;
            Log.d("runApp", "NP" + this.appPackageName10);

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
            routine.setAppNameSlot1(appName1);
            Log.d("AddRoutineActivity", "App Name 1"+ routine.getAppNameSlot1());
            routine.setAppPackageNameSlot1(appPackageName1);
            Log.d("AddRoutineActivity", "App Package Name 1"+ routine.getAppPackageNameSlot1());
            routine.setAppNameSlot2(appName2);
            Log.d("AddRoutineActivity", "App Name 2"+ routine.getAppNameSlot2());
            routine.setAppPackageNameSlot2(appPackageName2);
            Log.d("AddRoutineActivity", "App Package  Name 2"+ routine.getAppPackageNameSlot2());
            routine.setAppNameSlot3(appName3);
            Log.d("AddRoutineActivity", "App Name 3"+ routine.getAppNameSlot3());
            routine.setAppPackageNameSlot3(appPackageName3);
            Log.d("AddRoutineActivity", "App Package Name"+ routine.getAppPackageNameSlot3());
            routine.setAppNameSlot4(appName4);
            Log.d("AddRoutineActivity", "App Name 4"+ routine.getAppNameSlot4());
            routine.setAppPackageNameSlot4(appPackageName4);
            Log.d("AddRoutineActivity", "App Package Name "+ routine.getAppPackageNameSlot4());
            routine.setAppNameSlot5(appName5);
            Log.d("AddRoutineActivity", "App Name 5"+ routine.getAppNameSlot5());
            routine.setAppPackageNameSlot5(appPackageName5);
            Log.d("AddRoutineActivity", "App  Package Name"+ routine.getAppPackageNameSlot5());
            routine.setAppNameSlot6(appName6);
            Log.d("AddRoutineActivity", "App Name 6"+ routine.getAppNameSlot6());
            routine.setAppNameSlot6(appPackageName6);
            Log.d("AddRoutineActivity", "App Package  Name 6"+ routine.getAppPackageNameSlot6());
            routine.setAppNameSlot7(appName7);
            Log.d("AddRoutineActivity", "App Name 7"+ routine.getAppNameSlot7());
            routine.setAppNameSlot7(appPackageName7);
            Log.d("AddRoutineActivity", "App Package Name 7"+ routine.getAppPackageNameSlot7());
            routine.setAppNameSlot8(appName8);
            Log.d("AddRoutineActivity", "App Name 8"+ routine.getAppNameSlot8());
            routine.setAppPackageNameSlot8(appPackageName8);
            Log.d("AddRoutineActivity", "App Package Name 8"+ routine.getAppPackageNameSlot8());
            routine.setAppNameSlot9(appName9);
            Log.d("AddRoutineActivity", "App Name 9"+ routine.getAppNameSlot9());
            routine.setAppPackageNameSlot9(appPackageName9);
            Log.d("AddRoutineActivity", "App Package Name 9"+ routine.getAppPackageNameSlot9());
            routine.setAppnameSlot10(appName10);
            Log.d("AddRoutineActivity", "App Name 10"+ routine.getAppnameSlot10());
            routine.setAppPackageNameSlot10(appPackageName10);
            Log.d("AddRoutineActivity", "App Package Name 10"+ routine.getAppPackageNameSlot10());
            setDescriptionsRoutineText(routine);
            Log.d("AddRoutineActivity", "DescriptionText "+ routine.getDescriptionText());


            routineManager.addRoutine(routine);
            // save changes into the list
            routineManager.saveRoutineList();
        }

    }

    private void setDescriptionsRoutineText(Routine routine) {

        // with the swichtes i set the Description text;
        switch (routine.getRoutineSlot1()){
            case 0:
                DescriptionText1 = "";
                break;
            case 1:
                DescriptionText1 = bluetoothOffString;
                break;
            case 2:
                DescriptionText1 = bluetothOnString;
                break;
            case 3:
                DescriptionText1 = mediaVolumeMuteString;
                break;
            case 4:
                DescriptionText1 = mediaVolumeMaxString;
                break;
            case 5:
                DescriptionText1 = speakerVolumeMute;
                break;
            case 6:
                DescriptionText1 = speakerVolumeVibration;
                break;
            case 7:
                DescriptionText1 = speakerVolumeMax;
                break;
            case 8:
                DescriptionText1 = appName1;
                break;
            case 9:
                DescriptionText1 = runTimer;
                break;
        }
        switch (routine.getRoutineSlot2()){
            case 0:
                DescriptionText2 = "";
                break;
            case 1:
                DescriptionText2 = bluetoothOffString;
                break;
            case 2:
                DescriptionText2 = bluetothOnString;
                break;
            case 3:
                DescriptionText2 = mediaVolumeMuteString;
                break;
            case 4:
                DescriptionText2 = mediaVolumeMaxString;
                break;
            case 5:
                DescriptionText2 = speakerVolumeMute;
                break;
            case 6:
                DescriptionText2 = speakerVolumeVibration;
                break;
            case 7:
                DescriptionText2 = speakerVolumeMax;
                break;
            case 8:
                DescriptionText2 = appName2;
                break;
            case 9:
                DescriptionText2 = runTimer;
                break;
        }

        switch (routine.getRoutineSlot3()){
            case 0:
                DescriptionText3 = "";
                break;
            case 1:
                DescriptionText3 = bluetoothOffString;
                break;
            case 2:
                DescriptionText3 = bluetothOnString;
                break;
            case 3:
                DescriptionText3 = mediaVolumeMuteString;
                break;
            case 4:
                DescriptionText3 = mediaVolumeMaxString;
                break;
            case 5:
                DescriptionText3 = speakerVolumeMute;
                break;
            case 6:
                DescriptionText3 = speakerVolumeVibration;
                break;
            case 7:
                DescriptionText3 = speakerVolumeMax;
                break;
            case 8:
                DescriptionText3 = appName3;
                break;
            case 9:
                DescriptionText3 = runTimer;
                break;
        }

        switch (routine.getRoutineSlot4()){
            case 0:
                DescriptionText4 = "";
                break;
            case 1:
                DescriptionText4 = bluetoothOffString;
                break;
            case 2:
                DescriptionText4 = bluetothOnString;
                break;
            case 3:
                DescriptionText4 = mediaVolumeMuteString;
                break;
            case 4:
                DescriptionText4 = mediaVolumeMaxString;
                break;
            case 5:
                DescriptionText4 = speakerVolumeMute;
                break;
            case 6:
                DescriptionText4 = speakerVolumeVibration;
                break;
            case 7:
                DescriptionText4 = speakerVolumeMax;
                break;
            case 8:
                DescriptionText4 = appName4;
                break;
            case 9:
                DescriptionText4 = runTimer;
                break;
        }

        switch (routine.getRoutineSlot5()){
            case 0:
                DescriptionText5 = "";
                break;
            case 1:
                DescriptionText5 = bluetoothOffString;
                break;
            case 2:
                DescriptionText5 = bluetothOnString;
                break;
            case 3:
                DescriptionText5 = mediaVolumeMuteString;
                break;
            case 4:
                DescriptionText5 = mediaVolumeMaxString;
                break;
            case 5:
                DescriptionText5 = speakerVolumeMute;
                break;
            case 6:
                DescriptionText5 = speakerVolumeVibration;
                break;
            case 7:
                DescriptionText5 = speakerVolumeMax;
                break;
            case 8:
                DescriptionText5 = appName5;
                break;
            case 9:
                DescriptionText5 = runTimer;
                break;
        }

        switch (routine.getRoutineSlot6()){
            case 0:
                DescriptionText6 = "";
                break;
            case 1:
                DescriptionText6 = bluetoothOffString;
                break;
            case 2:
                DescriptionText6= bluetothOnString;
                break;
            case 3:
                DescriptionText6 = mediaVolumeMuteString;
                break;
            case 4:
                DescriptionText6 = mediaVolumeMaxString;
                break;
            case 5:
                DescriptionText6 = speakerVolumeMute;
                break;
            case 6:
                DescriptionText6 = speakerVolumeVibration;
                break;
            case 7:
                DescriptionText6 = speakerVolumeMax;
                break;
            case 8:
                DescriptionText6 = appName6;
                break;
            case 9:
                DescriptionText6 = runTimer;
                break;
        }

        switch (routine.getRoutineSlot7()){
            case 0:
                DescriptionText7 = "";
                break;
            case 1:
                DescriptionText7 = bluetoothOffString;
                break;
            case 2:
                DescriptionText7= bluetothOnString;
                break;
            case 3:
                DescriptionText7 = mediaVolumeMuteString;
                break;
            case 4:
                DescriptionText7 = mediaVolumeMaxString;
                break;
            case 5:
                DescriptionText7 = speakerVolumeMute;
                break;
            case 6:
                DescriptionText7 = speakerVolumeVibration;
                break;
            case 7:
                DescriptionText7 = speakerVolumeMax;
                break;
            case 8:
                DescriptionText7 = appName7;
                break;
            case 9:
                DescriptionText7 = runTimer;
                break;
        }
        switch (routine.getRoutineSlot8()){
            case 0:
                DescriptionText8 = "";
                break;
            case 1:
                DescriptionText8 = bluetoothOffString;
                break;
            case 2:
                DescriptionText8= bluetothOnString;
                break;
            case 3:
                DescriptionText8 = mediaVolumeMuteString;
                break;
            case 4:
                DescriptionText8 = mediaVolumeMaxString;
                break;
            case 5:
                DescriptionText8 = speakerVolumeMute;
                break;
            case 6:
                DescriptionText8 = speakerVolumeVibration;
                break;
            case 7:
                DescriptionText8 = speakerVolumeMax;
                break;
            case 8:
                DescriptionText8 = appName8;
                break;
            case 9:
                DescriptionText8 = runTimer;
                break;
        }
        switch (routine.getRoutineSlot9()){
            case 0:
                DescriptionText9 = "";
                break;
            case 1:
                DescriptionText9 = bluetoothOffString;
                break;
            case 2:
                DescriptionText9= bluetothOnString;
                break;
            case 3:
                DescriptionText9 = mediaVolumeMuteString;
                break;
            case 4:
                DescriptionText9 = mediaVolumeMaxString;
                break;
            case 5:
                DescriptionText9 = speakerVolumeMute;
                break;
            case 6:
                DescriptionText9 = speakerVolumeVibration;
                break;
            case 7:
                DescriptionText9 = speakerVolumeMax;
                break;
            case 8:
                DescriptionText9 = appName9;
                break;
            case 9:
                DescriptionText9 = runTimer;
                break;
        }

        switch (routine.getRoutineSlot10()){
            case 0:
                DescriptionText10 = "";
                break;
            case 1:
                DescriptionText10 = bluetoothOffString;
                break;
            case 2:
                DescriptionText10= bluetothOnString;
                break;
            case 3:
                DescriptionText10 = mediaVolumeMuteString;
                break;
            case 4:
                DescriptionText10 = mediaVolumeMaxString;
                break;
            case 5:
                DescriptionText10 = speakerVolumeMute;
                break;
            case 6:
                DescriptionText10 = speakerVolumeVibration;
                break;
            case 7:
                DescriptionText10 = speakerVolumeMax;
                break;
            case 8:
                DescriptionText10 = appName10;
                break;
            case 9:
                DescriptionText10 = runTimer;
                break;
        }


        DescriptionTextComplete = DescriptionText1 +" "+ DescriptionText2 +" "+ DescriptionText3 +""+ DescriptionText4 +" " + DescriptionText5+ "" + DescriptionText6 +" " + DescriptionText7+ " "+ DescriptionText8 +" "+ DescriptionText9 +" "+ DescriptionText10;
        // set the Description text to the routine t
        routine.setDescriptionText(DescriptionTextComplete);

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

            routine.setAppNameSlot1(appName1);
            Log.d("AddRoutineActivity", "App Name 1"+ routine.getAppNameSlot1());
            routine.setAppPackageNameSlot1(appPackageName1);
            Log.d("AddRoutineActivity", "App Package Name 1"+ routine.getAppPackageNameSlot1());
            routine.setAppNameSlot2(appName2);
            Log.d("AddRoutineActivity", "App Name 2"+ routine.getAppNameSlot2());
            routine.setAppPackageNameSlot2(appPackageName2);
            Log.d("AddRoutineActivity", "App Package  Name 2"+ routine.getAppPackageNameSlot2());
            routine.setAppNameSlot3(appName3);
            Log.d("AddRoutineActivity", "App Name 3"+ routine.getAppNameSlot3());
            routine.setAppPackageNameSlot3(appPackageName3);
            Log.d("AddRoutineActivity", "App Package Name"+ routine.getAppPackageNameSlot3());
            routine.setAppNameSlot4(appName4);
            Log.d("AddRoutineActivity", "App Name 4"+ routine.getAppNameSlot4());
            routine.setAppPackageNameSlot4(appPackageName4);
            Log.d("AddRoutineActivity", "App Package Name "+ routine.getAppPackageNameSlot4());
            routine.setAppNameSlot5(appName5);
            Log.d("AddRoutineActivity", "App Name 5"+ routine.getAppNameSlot5());
            routine.setAppPackageNameSlot5(appPackageName5);
            Log.d("AddRoutineActivity", "App  Package Name"+ routine.getAppPackageNameSlot5());
            routine.setAppNameSlot6(appName6);
            Log.d("AddRoutineActivity", "App Name 6"+ routine.getAppNameSlot6());
            routine.setAppNameSlot6(appPackageName6);
            Log.d("AddRoutineActivity", "App Package  Name 6"+ routine.getAppPackageNameSlot6());
            routine.setAppNameSlot7(appName7);
            Log.d("AddRoutineActivity", "App Name 7"+ routine.getAppNameSlot7());
            routine.setAppNameSlot7(appPackageName7);
            Log.d("AddRoutineActivity", "App Package Name 7"+ routine.getAppPackageNameSlot7());
            routine.setAppNameSlot8(appName8);
            Log.d("AddRoutineActivity", "App Name 8"+ routine.getAppNameSlot8());
            routine.setAppPackageNameSlot8(appPackageName8);
            Log.d("AddRoutineActivity", "App Package Name 8"+ routine.getAppPackageNameSlot8());
            routine.setAppNameSlot9(appName9);
            Log.d("AddRoutineActivity", "App Name 9"+ routine.getAppNameSlot9());
            routine.setAppPackageNameSlot9(appPackageName9);
            Log.d("AddRoutineActivity", "App Package Name 9"+ routine.getAppPackageNameSlot9());
            routine.setAppnameSlot10(appName10);
            Log.d("AddRoutineActivity", "App Name 10"+ routine.getAppnameSlot10());
            routine.setAppPackageNameSlot10(appPackageName10);
            Log.d("AddRoutineActivity", "App Package Name 10"+ routine.getAppPackageNameSlot10());
            setDescriptionsRoutineText(routine);
            Log.d("AddRoutineActivity", "DescriptionText "+ routine.getDescriptionText());


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



    }

