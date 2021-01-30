package com.mn.myroutines;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddAndEditRoutineActivity extends AppCompatActivity {

    // Object Deklartion
    EditText editTextRoutineName;
    ListView listView;
    RoutineManager routineManager;
    RoutineSlotManager routineSlotManager;
    ListviewAdapterRoutine listviewAdapterRoutine;
    Context context;
    ArrayList<String> arrayList;
    public String ArrayListSlotDefault;
    public String newActionString;
    public String noActionString;
    public String bluetoothOff;

    int listViewItemPosition;
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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_routine);
        context = getApplicationContext();

        initViews();
        initManagers();
        initClickListener();
        setDefaultSlots();

    }

    private void initViews() {
        // serach for Views with id
        editTextRoutineName = findViewById(R.id.EditTextRoutineName);
        listView = findViewById(R.id.listviewAddAction);
        listView.setAdapter(listviewAdapterRoutine);
        arrayList = new ArrayList<>();
        ArrayListSlotDefault = getString(R.string.NoAction);
        noActionString = getString(R.string.NoAction);
        bluetoothOff = getString(R.string.BluetoothOFF);

    }

    private void initClickListener() {
        // listnen for Clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShowDialog();
                routineSlotManager.setWhichSlotPosition(position);
            }
        });
    }

    private void ShowDialog() {
            // create Alert Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // set title
        builder.setTitle(getString(R.string.Action));
        // set String
        String[] actions = {getString(R.string.NoAction), getString(R.string.BluetoothOFF)};
        // set on click listener
        builder.setItems(actions, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            routineSlotManager.setRoutineSlots(which);

            }
        });
         AlertDialog dialog = builder.create();
        dialog.show();


        }


    private void initManagers() {
        // inisalraztion for all Mangers in the App
        // init RoutineManger
        routineManager = new RoutineManager(context);
        // int listviewAdapterRoutine
        listviewAdapterRoutine = new ListviewAdapterRoutine(context, arrayList);
        //init RoutineSlotManger
        routineSlotManager = new RoutineSlotManager(context,listView, listviewAdapterRoutine, ArrayListSlotDefault, newActionString, noActionString, bluetoothOff,listViewItemPosition, routinelistPositionSlot1, routinelistPositionSlot2, routinelistPositionSlot3, routinelistPositionSlot4, routinelistPositionSlot5, routinelistPositionSlot6, routinelistPositionSlot7, routinelistPositionSlot8, routinelistPositionSlot9, routinelistPositionSlot10, whichSlotPosition);
    }

    public void setDefaultSlots(){
            routineSlotManager.setDefaultSlots();

        }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // start MainActivity and close these Acivity
        // create new Intent
        Intent intent = new Intent(AddAndEditRoutineActivity.this, MainActivity.class);
        // finish Acivity
        finish();
        // start new Activity
        startActivity(intent);
    }
}
