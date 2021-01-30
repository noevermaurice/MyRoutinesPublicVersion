package com.mn.myroutines;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
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
    Activity activity = (Activity) context;


    public RoutineSlotManager(Context context, ListView listView, ListviewAdapterRoutine listviewAdapterRoutine, String ArrayListSlotDefault, String newActionString,String noActionString, String bluetoothOffString,  int listviewItemPosition, int routinelistPositionSlot1, int routinelistPositionSlot2, int routinelistPositionSlot3, int routinelistPositionSlot4,int routinelistPositionSlot5,int routinelistPositionSlot6, int routinelistPositionSlot7, int routinelistPositionSlot8,int routinelistPositionSlot9,int routinelistPositionSlot10, int whichSlotPosition) {
        //
        this.context = context;
        this.listView = listView;
        this.listviewAdapterRoutine = listviewAdapterRoutine;
        this.ArrayListSlotDefault = ArrayListSlotDefault;
        this.newActionString = newActionString;
        this.noActionString = noActionString;
        this.bluetoothOffString = bluetoothOffString;
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
        }

        listView.setAdapter(listviewAdapterRoutine);
        listviewAdapterRoutine.arrayListSlots.set(whichSlotPosition,newActionString);
    }


}
