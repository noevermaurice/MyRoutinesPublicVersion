package com.mn.myroutines;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class RoutineSlotManager  {
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
    int whichSlotPosition;
    int timerSeconds;
    int timerMinutes;
    int timerHours;
    Activity activity = (Activity) context;


    public RoutineSlotManager(Context context, ListView listView, ListviewAdapterRoutine listviewAdapterRoutine, String ArrayListSlotDefault, String newActionString,String noActionString, String bluetoothOffString,String bluetothOnString, String mediaVolumeMuteString, String mediaVolumeMaxString,String speakerVolumeMute, String speakerVolumeVibration,String speakerVolumeMax, String runApp, String runTimer,int listviewItemPosition, int routinelistPositionSlot1, int routinelistPositionSlot2, int routinelistPositionSlot3, int routinelistPositionSlot4,int routinelistPositionSlot5,int routinelistPositionSlot6, int routinelistPositionSlot7, int routinelistPositionSlot8,int routinelistPositionSlot9,int routinelistPositionSlot10, int whichSlotPosition, int timerSeconds,int timerMinutes, int timerHours, String timerName) {
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

    public void getRoutineSlotActions(Routine oldRoutine){

        switch (oldRoutine.getRoutineSlot1()){
            case 0:

        }

    }

    public void setRoutineSlots(int selectActionPosition) {
        // check with selectActionPosition witch action was clicked
    switch (selectActionPosition){
        case 0:
            // check with whichSlotposition witch slot was clicked
            if (whichSlotPosition == 0){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot1 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 1){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot2 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 2){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot3 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 3){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot4 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 4){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot5 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 5){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot6 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 6){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot7 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition ==7 ){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot8 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 8){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot9 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 9){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot10 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            }

            break;

        case 1:
            // check with whichSlotposition witch slot was clicked
            if (whichSlotPosition == 0){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot1 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 1){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot2 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 2){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot3 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 3){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot4 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 4){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot5 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 5){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot6 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 6){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot7 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition ==7 ){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot8 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 8){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot9 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 9){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot10 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            }

            break;

        case 2:
            // check with whichSlotposition witch slot was clicked
            if (whichSlotPosition == 0){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot1 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 1){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot2 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 2){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot3 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 3){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot4 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 4){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot5 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 5){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot6 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 6){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot7 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition ==7 ){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot8 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 8){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot9 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 9){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot10 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            }

            break;

        case 3:
            // check with whichSlotposition witch slot was clicked
            if (whichSlotPosition == 0){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot1 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 1){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot2 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 2){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot3 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 3){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot4 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 4){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot5 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 5){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot6 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 6){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot7 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition ==7 ){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot8 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 8){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot9 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 9){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot10 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            }

            break;


        case 4:
            // check with whichSlotposition witch slot was clicked
            if (whichSlotPosition == 0){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot1 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 1){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot2 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 2){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot3 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 3){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot4 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 4){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot5 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 5){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot6 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 6){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot7 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition ==7 ){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot8 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 8){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot9 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 9){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot10 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            }

            break;

        case 5:
            // check with whichSlotposition witch slot was clicked
            if (whichSlotPosition == 0){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot1 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 1){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot2 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 2){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot3 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 3){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot4 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 4){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot5 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 5){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot6 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 6){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot7 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition ==7 ){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot8 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 8){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot9 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 9){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot10 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            }

            break;

        case 6:
            // check with whichSlotposition witch slot was clicked
            if (whichSlotPosition == 0){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot1 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 1){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot2 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 2){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot3 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 3){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot4 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 4){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot5 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 5){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot6 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 6){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot7 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition ==7 ){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot8 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 8){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot9 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 9){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot10 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            }

            break;

        case 7:
            // check with whichSlotposition witch slot was clicked
            if (whichSlotPosition == 0){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot1 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 1){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot2 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 2){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot3 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 3){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot4 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 4){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot5 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 5){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot6 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 6){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot7 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition ==7 ){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot8 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 8){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot9 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 9){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot10 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            }

            break;

        case 8:
            // check with whichSlotposition witch slot was clicked
            if (whichSlotPosition == 0){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot1 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 1){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot2 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 2){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot3 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 3){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot4 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 4){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot5 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 5){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot6 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 6){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot7 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition ==7 ){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot8 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 8){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot9 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 9){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot10 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            }

            break;

        case 9:
            // check with whichSlotposition witch slot was clicked
            if (whichSlotPosition == 0){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot1 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot1  =" + routinelistPositionSlot1);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 1){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot2 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot2  =" + routinelistPositionSlot2);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 2){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot3 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot3  =" + routinelistPositionSlot3);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 3){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot4 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot4  =" + routinelistPositionSlot4);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 4){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot5 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot5  =" + routinelistPositionSlot5);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 5){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot6 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot6  =" + routinelistPositionSlot6);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 6){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot7 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot7  =" + routinelistPositionSlot7);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition ==7 ){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot8 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot8 =" + routinelistPositionSlot8);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 8){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot9 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot9  =" + routinelistPositionSlot9);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            } else if (whichSlotPosition == 9){
                listviewItemPosition = selectActionPosition;
                routinelistPositionSlot10 = selectActionPosition;
                setNewAction();
                Log.d("AddRoutineActivity", "routinelist positionslot10  =" + routinelistPositionSlot10);
                Log.d("AddRoutineActivity", " listposition  =" + listviewItemPosition);
            }

            break;










    }



    }

    public void setWhichSlotPosition(int position){

        // check  with swich which slot was click
        switch (position){
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
            case 7:whichSlotPosition = position;
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

    public void setNewAction(){
        switch (listviewItemPosition){
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
                break;
            case 9:
                newActionString = runTimer;
                break;

        }

        listView.setAdapter(listviewAdapterRoutine);
        listviewAdapterRoutine.arrayListSlots.set(whichSlotPosition,newActionString);
    }

    public void createRoutine(Routine routine, EditText editText, RoutineManager routineManager){
                getTimerSettings(timerSeconds, timerMinutes, timerHours, timerName);

        String newRoutineName = editText.getText().toString();
        if (newRoutineName.length() >0){
            routine.setRoutineName(newRoutineName);
            Log.d("AddRoutineActivity", "Routine Name"  + routine.getRoutineName());
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

    public void getTimerSettings(int timerSeconds, int timerMinutes, int timerHours,String timerName){
        this.timerSeconds = timerSeconds;
        Log.d("t", "s =" + timerSeconds);
        this.timerMinutes = timerMinutes;
        this.timerHours = timerHours;
        this.timerName= timerName;
    }






}
