package com.mn.myroutines;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

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
    int routineListPosition;


    private ListView listViewForApps;
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
    private TextView headerText;
    private Toolbar toolbar;
    public SearchView searchView;

    private PackageManager packageManager;
    private ArrayAdapter<ApplicationInfo> adapter;
    private ArrayList<ApplicationInfo> applicationInfos;
    private ProgressDialog progressDialog;

    public  List<ApplicationInfo> launchableInstalledApps;
    public  List<ApplicationInfo> installedApps;

   public AlertDialog dialog;
   public AllAppsAdapter allAppsAdapter;
   public MenuItem item1;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_routine);
        context = getApplicationContext();
        applicationInfos = new ArrayList<>();
        launchableInstalledApps = new ArrayList<>();
        installedApps = context.getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);

       allAppsAdapter = new AllAppsAdapter(AddAndEditRoutineActivity.this, 0, installedApps, appName, appPackageName);

        initViews();

        initManagers();
        initClickListener();
        setDefaultSlots();

        if (getIntent().hasExtra("routine")) {
            Routine oldroutine = (Routine) getIntent().getSerializableExtra("routine");
            routineSlotManager.getRoutineSlotActions(oldroutine);

        }

        routineListPosition = getIntent().getIntExtra("routinePosition", 0);


    }


    private void initViews() {
        // serach for Views with id
        editTextRoutineName = findViewById(R.id.EditTextRoutineName);
        saveButton = findViewById(R.id.saveRoutineButton);
        listViewForApps = findViewById(R.id.listViewForApps);
        listView = findViewById(R.id.listviewAddAction);
        listViewForApps.setVisibility(View.INVISIBLE);
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
                if (getIntent().hasExtra("routine")) {
                    routineSlotManager.updateRoutine(routine, editTextRoutineName, routineManager, routineListPosition);
                } else {
                    routineSlotManager.createRoutine(routine, editTextRoutineName, routineManager);
                }


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
        String[] actions = {noActionString, bluetoothOff, bluetoothOn, mediaVolumeMute, mediaVolumeMax, speakerVolumeMute, speakerVolumeVibration, speakerVolumeMax, runApp, runTimer};
        // set on click listener
        builder.setItems(actions, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                routineSlotManager.setRoutineSlots(which);

                if (which == 8) {
                    listView.setVisibility(View.INVISIBLE);
                    //ShowAllAppsDialog();
                    listViewForApps.setVisibility(View.VISIBLE);
                    listViewForApps.setAdapter(allAppsAdapter);
                    item1.setVisible(true);
                }

                if (which == 9) {

                    // if Action = 9 than show timer Dialog
                    SetTimerDialog setTimerDialog = new SetTimerDialog();
                    setTimerDialog.show(getSupportFragmentManager(), "dialog");
                    routineSlotManager.getTimerSettings(timerSeconds, timerMinutes, timerHours, timerName);
                    // set timer settings in slotmanager

                }

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater infalter = getMenuInflater();
        infalter.inflate(R.menu.menu_add_edit_activity,menu );
      item1 = menu.findItem(R.id.serachForApps).setVisible(false);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item1);
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportActionBar().setDisplayShowTitleEnabled(false);
            }
        });



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //filter adapter and update ListView
                allAppsAdapter.getFilter().filter(newText);
                return false;
            }
        });
       return  true;


    }



    public List<ApplicationInfo> getAllInstalledApplications(Context context) {



        for(int i =0; i<installedApps.size(); i++){
            if(context.getPackageManager().getLaunchIntentForPackage(installedApps.get(i).packageName) != null){
                //If you're here, then this is a launch-able app
                launchableInstalledApps.add(installedApps.get(i));
            }
        }
        return launchableInstalledApps;
    }

    private void ShowAllAppsDialog() {
        // if normal listview Visible than it in



        List<ApplicationInfo> pkgAppsList = context.getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
        AlertDialog.Builder builderApps = new AlertDialog.Builder(this);
        builderApps.setTitle("choose App");
        final AllAppsAdapter allAppsAdapter = new AllAppsAdapter(this, R.layout.app_item_row, pkgAppsList, appName, appPackageName);
        appPackageName = allAppsAdapter.getAppPackageName();
        appName = allAppsAdapter.getAppNameString();
        Log.d("s", "Name =" +appName);


        //get a list of installed apps.
        // the getLaunchIntentForPackage returns an intent that you can use with startActivity()
        builderApps.setAdapter(allAppsAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                allAppsAdapter.onClickListener(which);

                appName = allAppsAdapter.getAppNameString();

            }
        });

        dialog = builderApps.create();
        dialog.show();



    }

    public void getAppName(){
        // app Dialog invible
//        dialog.dismiss();
        listViewForApps.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
        item1.setVisible(false);

        // put appNme and PackageName in RoutineSlotManager
        if (routineSlotManager.whichSlotPosition == 0){
            appName1 = appName;
            appPackageName1 = appPackageName;
            routineSlotManager.getAppNameAndPackage(appName1, appPackageName1);
            Log.d("runApp", "wich " + routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name1" +appName1);
            routineSlotManager.setNewAction();

        } else if (routineSlotManager.whichSlotPosition == 1) {
            appName2 = appName;
            appPackageName2 = appPackageName;
            routineSlotManager.getAppNameAndPackage(appName2, appPackageName2);
            Log.d("runApp", "wich " + routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name2" + appName2);
            routineSlotManager.setNewAction();
        } else if (routineSlotManager.whichSlotPosition == 2){
            appName3 = appName;
            appPackageName3 = appPackageName;
            routineSlotManager.getAppNameAndPackage(appName3, appPackageName3);
            Log.d("runApp", "wich " + routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name3" + appName3);
            routineSlotManager.setNewAction();

        } else if (routineSlotManager.whichSlotPosition == 3){
            appName4 = appName;
            appPackageName4 = appPackageName;
            routineSlotManager.getAppNameAndPackage(appName4, appPackageName4);
            Log.d("runApp", "wich " + routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name4" +appName4);
            routineSlotManager.setNewAction();

        } else if (routineSlotManager.whichSlotPosition == 4){
            appName5 = appName;
            appPackageName5 = appPackageName;
            routineSlotManager.getAppNameAndPackage(appName5, appPackageName5);
            Log.d("runApp", "wich " + routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name5" +appName5);
            routineSlotManager.setNewAction();
        } else if (routineSlotManager.whichSlotPosition == 5){
            appName6 = appName;
            appPackageName6 = appPackageName;
            routineSlotManager.getAppNameAndPackage(appName6, appPackageName6);
            Log.d("runApp", "wich " + routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name6" +appName6);
            routineSlotManager.setNewAction();

        } else if (routineSlotManager.whichSlotPosition == 6){
            appName7 = appName;
            appPackageName7 = appPackageName;
            routineSlotManager.getAppNameAndPackage(appName7, appPackageName7);
            Log.d("runApp", "wich " + routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name7" +appName7);
            routineSlotManager.setNewAction();

        } else if (routineSlotManager.whichSlotPosition == 7){
            appName8 = appName;
            appPackageName8 = appPackageName;
            routineSlotManager.getAppNameAndPackage(appName8, appPackageName8);
            Log.d("runApp", "wich " + routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name8" +appName8);
            routineSlotManager.setNewAction();

        } else if (routineSlotManager.whichSlotPosition == 8){
            appName9 = appName;
            appPackageName9 = appPackageName;
            routineSlotManager.getAppNameAndPackage(appName9, appPackageName9);
            Log.d("runApp", "wich " + routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name9" +appName9);
            routineSlotManager.setNewAction();

        } else if (routineSlotManager.whichSlotPosition == 9){
            appName10 = appName;
            appPackageName10 = appPackageName;
            routineSlotManager.getAppNameAndPackage(appName10, appPackageName10);
            Log.d("runApp", "wich " + routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name10" +appName10);
            routineSlotManager.setNewAction();

        }




    }


    private void initManagers() {
        // inisalraztion for all Mangers in the App
        // init RoutineManger
        routineManager = new RoutineManager(context);
        // int listviewAdapterRoutine
        listviewAdapterRoutine = new ListviewAdapterRoutine(context, arrayList);
        //init RoutineSlotManger
        routineSlotManager = new RoutineSlotManager(context, listView, listviewAdapterRoutine, ArrayListSlotDefault, newActionString, noActionString, bluetoothOff, bluetoothOn, mediaVolumeMute, mediaVolumeMax, speakerVolumeMute, speakerVolumeVibration, speakerVolumeMax, runApp, runTimer, listViewItemPosition, routinelistPositionSlot1, routinelistPositionSlot2, routinelistPositionSlot3, routinelistPositionSlot4, routinelistPositionSlot5, routinelistPositionSlot6, routinelistPositionSlot7, routinelistPositionSlot8, routinelistPositionSlot9, routinelistPositionSlot10, whichSlotPosition, timerSeconds, timerMinutes, timerHours, timerName, editTextRoutineName);
    }

    public void setDefaultSlots() {
        routineSlotManager.setDefaultSlots();

    }


    @Override
    public void onBackPressed() {
        // if listview Apps Visble make the listview for Apps invisble

        if (listViewForApps.getVisibility() == View.VISIBLE){
            listViewForApps.setVisibility(View.INVISIBLE);
            listviewAdapterRoutine.arrayListSlots.set(routineSlotManager.whichSlotPosition, noActionString);
            listviewAdapterRoutine.notifyDataSetChanged();
            listView.setVisibility(View.VISIBLE);
            item1.setVisible(false);



        } else if (listViewForApps.getVisibility() == View.INVISIBLE ){
            // start MainActivity and close these Acivity
            // create new Intent
            Intent intent = new Intent(AddAndEditRoutineActivity.this, MainActivity.class);
            // finish Acivity
            finish();
            // start new Activity
            startActivity(intent);
        }

    }


    @Override
    public void setTimerSettings(int seconds, int minutes, int hour, String TimerName) {
        this.timerSeconds = seconds;
        Log.d("AddAcivity", "seconds in der Activity vom Interface " + timerSeconds);
        this.timerMinutes = minutes;
        this.timerHours = hour;
        this.timerName = TimerName;
    }



    public void callBackDataFromAsynctask(List<ApplicationInfo> list) {

    }

    public void updateUILayout(String content) {

    }
}











