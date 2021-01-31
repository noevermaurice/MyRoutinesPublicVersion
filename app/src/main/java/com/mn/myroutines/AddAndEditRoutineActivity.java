package com.mn.myroutines;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddAndEditRoutineActivity extends AppCompatActivity implements SetTimerDialog.setTimerInterface {

    // Object Deklartion
    EditText editTextRoutineName;
    FloatingActionButton saveButton;
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
    public String bluetoothOn;
    public String mediaVolumeMute;
    public String mediaVolumeMax;
    public String speakerVolumeMute;
    public String speakerVolumeVibration;
    public String speakerVolumeMax;
    public String runApp;
    public String runTimer;
    public String timerName;

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
    int timerSeconds;
    int timerMinutes;
    int timerHours;



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
        saveButton = findViewById(R.id.saveRoutineButton);
        listView = findViewById(R.id.listviewAddAction);
        listView.setAdapter(listviewAdapterRoutine);
        arrayList = new ArrayList<>();
        ArrayListSlotDefault = getString(R.string.NoAction);
        noActionString = getString(R.string.NoAction);
        bluetoothOff = getString(R.string.BluetoothOFF);
        bluetoothOn = getString(R.string.BluetoothOn);
        mediaVolumeMute = getString(R.string.MediaSpeakerVolumeMute);
        mediaVolumeMax = getString(R.string.MediaSpeakerVolumeMax);
        speakerVolumeMute = getString(R.string.SpeakerVolumeMute);
        speakerVolumeVibration = getString(R.string.SpeakerVolumeVibration);
        speakerVolumeMax = getString(R.string.MediaSpeakerVolumeMax);
        runApp = getString(R.string.runApp);
        runTimer = getString(R.string.runTimer);


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

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Routine routine = new Routine();
                routineSlotManager.createRoutine(routine, editTextRoutineName, routineManager);
                onBackPressed();
            }
        });


    }

    private void ShowDialog() {
            // create Alert Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // set title
        builder.setTitle(getString(R.string.Action));
        // set String
        String[] actions = {noActionString, bluetoothOff, bluetoothOn,mediaVolumeMute,mediaVolumeMax, speakerVolumeMute, speakerVolumeVibration, speakerVolumeMax, runApp, runTimer};
        // set on click listener
        builder.setItems(actions, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                routineSlotManager.setRoutineSlots(which);

                if (which == 9){
                    // if Action = 9 than show timer Dialog
                    SetTimerDialog setTimerDialog = new SetTimerDialog();
                    setTimerDialog.show(getSupportFragmentManager(), "dialog");
                    // set timer settings in slotmanager
                    routineSlotManager.getTimerSettings(timerSeconds, timerMinutes, timerHours, timerName);
                }

            }
        });
         AlertDialog dialog = builder.create();
        dialog.show();


        }

    private void ShowAllAppsDialog() {
        AlertDialog.Builder builderApps = new AlertDialog.Builder(this);
        builderApps.setTitle("choose App");

        AlertDialog dialog = builderApps.create();
        dialog.show();

    }


    private void initManagers() {
        // inisalraztion for all Mangers in the App
        // init RoutineManger
        routineManager = new RoutineManager(context);
        // int listviewAdapterRoutine
        listviewAdapterRoutine = new ListviewAdapterRoutine(context, arrayList);
        //init RoutineSlotManger
        routineSlotManager = new RoutineSlotManager(context,listView, listviewAdapterRoutine, ArrayListSlotDefault, newActionString, noActionString, bluetoothOff, bluetoothOn, mediaVolumeMute,mediaVolumeMax, speakerVolumeMute, speakerVolumeVibration, speakerVolumeMax, runApp, runTimer,listViewItemPosition, routinelistPositionSlot1, routinelistPositionSlot2, routinelistPositionSlot3, routinelistPositionSlot4, routinelistPositionSlot5, routinelistPositionSlot6, routinelistPositionSlot7, routinelistPositionSlot8, routinelistPositionSlot9, routinelistPositionSlot10, whichSlotPosition);
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


    @Override
    public void setTimerSettings(int seconds, int minutes, int hour, String TimerName) {
       this.timerSeconds = seconds;
        Log.d("AddAcivity", "seconds in der Activity vom Interface " + timerSeconds);

       this.timerMinutes = minutes;
       this.timerHours = hour;
       this.timerName = TimerName;
    }
}
