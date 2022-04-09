package com.mn.myroutines;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.Toolbar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mn.myroutines.CustomListViewAdapterAlertDialog.onitemclickListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddAndEditRoutineActivity extends AppCompatActivity implements SetTimerDialog.setTimerInterface, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener, CustomNotificationDialog.CustomNotficationDialogListener {
    TextView AllRoutinesActionText;
    public String ArrayListSlotDefault;
    public int MyDayOld;
    public int MyHourOld;
    public int MyMinuteOld;
    public int MyMonthOld;
    public int MyYearOld;
    public int RoutinePositionInList;
    private ArrayAdapter<ApplicationInfo> adapter;
    public AllAppsAdapter allAppsAdapter;
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
    private ArrayList<ApplicationInfo> applicationInfos;
    ArrayList<String> arrayList;
    public String bluetoothOff;
    public String bluetoothOn;
    TextView chooseAppText;
    Context context;
    DarkModeManager darkModeManager;
    public AlertDialog dialog;
    EditText editTextRoutineName;
    private TextView headerText;
    public List<ApplicationInfo> installedApps;
    public boolean isAddToHomeScreen;
    public boolean isEverDay;
    public boolean isEverMonth;
    public boolean isEverWeek;
    public boolean isEveryDayOld;
    public boolean isEveryMonthOld;
    public boolean isEveryWeekOld;
    public boolean isNotification;
    private boolean isNotificationUpdate;
    public boolean isOldRoutine;
    public boolean isSave;
    public boolean isVibrationLomg;
    public boolean isVibrationMedium;
    public boolean isVibrationNo;
    public boolean isVibrationShort;
    public MenuItem item1;
    public MenuItem itemAddToHomeScreen;
    public MenuItem itemNotification;
    public MenuItem itemNotificationSwitch;
    public List<ApplicationInfo> launchableInstalledApps;
    ListView listView;
   
    private ListView listViewForApps;
    int listViewItemPosition;
    CustomListViewAdapter customListViewAdapter;
    public String mediaVolumeMax;
    public String mediaVolumeMute;
    public int myDay;
    public int myHour;
    public int myMinute;
    public int myMonth;
    public int myYear;
    public String newActionString;
    public String noActionString;
    public Routine oldroutine;
    private PackageManager packageManager;
    private ProgressDialog progressDialog;
    public Routine routine;
    int routineListPosition;
    RoutineManager routineManager;
    RoutineSlotManager routineSlotManager;
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
    public String runApp;
    public String runTimer;
    FloatingActionButton saveButton;
    public SearchView searchView;
    public SetTimerDialog setTimerDialog;
    ShortcutManager shortcutManager;
    public String speakerVolumeMax;
    public String speakerVolumeMute;
    public String speakerVolumeVibration;
    public Switch switchNotification;
    public Bundle timerBundle = new Bundle();
    int timerHours;
    int timerMinutes;
    public String timerName;
    int timerSeconds;
    private Toolbar toolbar;
    int whichSlotPosition;
    public String wifiOff;
    public String wifiOn;


    ArrayList<SingleAlertDialogRow> stringArrayList;


    public ArrayList<String> actionDescription = new ArrayList<>();
        int actionImages []= {R.drawable.ic_baseline_not_interested_24, R.drawable.ic_baseline_bluetooth_disabled_24, R.drawable.ic_baseline_bluetooth_24, R.drawable.ic_baseline_volume_mute_24, R.drawable.ic_baseline_volume_up_24, R.drawable.ic_baseline_volume_mute_24, R.drawable.ic_baseline_vibration_24, R.drawable.ic_baseline_volume_up_24, R.drawable.ic_baseline_apps_24, R.drawable.ic_baseline_timer_24, R.drawable.ic_baseline_wifi_off_24, R.drawable.ic_baseline_wifi_24};
        CustomListViewAdapterAlertDialog customListViewAdapterAlertDialog; 

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getApplicationContext();
        this.darkModeManager = new DarkModeManager(this.context);
        setContentView(R.layout.activity_add_routine);
        this.applicationInfos = new ArrayList<>();
        this.launchableInstalledApps = new ArrayList();
        this.installedApps = this.context.getPackageManager().getInstalledApplications(128);
        this.allAppsAdapter = new AllAppsAdapter(this, 0, this.installedApps, this.appName, this.appPackageName);

        stringArrayList = new ArrayList<>();


        String [] names = context.getResources().getStringArray(R.array.alertDialogActions);
        for (int i = 0; i<names.length; i++){
            stringArrayList.add(new SingleAlertDialogRow(names[i], actionImages[i]));

        }


        initViews();
        initManagers();
        initClickListener();
        initCalender();
        setDefaultSlots();
        if (getIntent().hasExtra("routine")) {
            Routine routine2 = (Routine) getIntent().getSerializableExtra("routine");
            this.oldroutine = routine2;
            this.routineSlotManager.getRoutineSlotActions(routine2);
            this.isNotificationUpdate = this.oldroutine.getIsNotification();
            this.MyYearOld = this.oldroutine.getRoutineYear();
            this.MyMonthOld = this.oldroutine.getRoutineMonth();
            this.MyDayOld = this.oldroutine.getRoutineDay();
            this.MyHourOld = this.oldroutine.getRoutineHour();
            this.MyMinuteOld = this.oldroutine.getRoutineMinute();
            this.isEveryDayOld = this.oldroutine.getIsEveryDay();
            this.isEveryWeekOld = this.oldroutine.getIsEveryWeek();
            this.isEveryMonthOld = this.oldroutine.getIsEveryMonth();
            this.isOldRoutine = true;
        }
        this.routineListPosition = getIntent().getIntExtra("routinePosition", 0);
        this.RoutinePositionInList = getIntent().getIntExtra("routinePosition", 0);
    }

    private void initCalender() {
        Calendar calendar = Calendar.getInstance();
        this.myYear = calendar.get(1);
        this.myMonth = calendar.get(2);
        this.myDay = calendar.get(5);
        this.myHour = calendar.get(11);
        this.myMinute = calendar.get(12);
    }

    private void initViews() {
        this.editTextRoutineName = (EditText) findViewById(R.id.EditTextRoutineName);
        this.saveButton = (FloatingActionButton) findViewById(R.id.saveRoutineButton);
        this.listViewForApps = (ListView) findViewById(R.id.listViewForApps);
      
        this.listView = (ListView) findViewById(R.id.listviewAddAction);


        this.listViewForApps.setVisibility(4);


        actionDescription.add("NoAction");

        customListViewAdapterAlertDialog = new CustomListViewAdapterAlertDialog(context, stringArrayList);



        this.arrayList = new ArrayList<>();
        this.ArrayListSlotDefault = getString(R.string.NoAction);
        this.noActionString = getString(R.string.NoAction);
        this.bluetoothOff = getString(R.string.BluetoothOFF);
        this.bluetoothOn = getString(R.string.BluetoothOn);
        this.mediaVolumeMute = getString(R.string.MediaSpeakerVolumeMute);
        this.mediaVolumeMax = getString(R.string.MediaSpeakerVolumeMax);
        this.speakerVolumeMute = getString(R.string.SpeakerVolumeMute);
        this.speakerVolumeVibration = getString(R.string.SpeakerVolumeVibration);
        this.speakerVolumeMax = getString(R.string.SpeakerVolumeMax);
        this.runApp = getString(R.string.runApp);
        this.runTimer = getString(R.string.runTimer);
        this.wifiOff = getString(R.string.WifiOff);
        this.wifiOn = getString(R.string.WifiOn);
        TextView textView = (TextView) findViewById(R.id.chooseAppText);
        this.chooseAppText = textView;
        textView.setVisibility(4);
        this.AllRoutinesActionText = (TextView) findViewById(R.id.textViewAllRoutinesActions);

    }

    private void initClickListener() {
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.mn.myroutines.AddAndEditRoutineActivity.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                AddAndEditRoutineActivity.this.ShowDialog();
                 AddAndEditRoutineActivity.this.routineSlotManager.setWhichSlotPosition(position);
            }
        });
        this.saveButton.setOnClickListener(new View.OnClickListener() {
            /* class com.mn.myroutines.AddAndEditRoutineActivity.AnonymousClass2 */

            public void onClick(View v) {
                AddAndEditRoutineActivity.this.routine = new Routine();
                if (AddAndEditRoutineActivity.this.editTextRoutineName.length() == 0) {
                    Toast.makeText(AddAndEditRoutineActivity.this.context, (int) R.string.RoutineNameIsEmpty, 0).show();
                } else if (AddAndEditRoutineActivity.this.getIntent().hasExtra("routine")) {
                    AddAndEditRoutineActivity.this.routineSlotManager.updateRoutine(AddAndEditRoutineActivity.this.routine, AddAndEditRoutineActivity.this.editTextRoutineName, AddAndEditRoutineActivity.this.routineManager, AddAndEditRoutineActivity.this.RoutinePositionInList, AddAndEditRoutineActivity.this.isAddToHomeScreen, AddAndEditRoutineActivity.this.isNotificationUpdate, AddAndEditRoutineActivity.this.MyYearOld, AddAndEditRoutineActivity.this.MyMonthOld, AddAndEditRoutineActivity.this.MyDayOld, AddAndEditRoutineActivity.this.MyHourOld, AddAndEditRoutineActivity.this.MyMinuteOld, 2, "", AddAndEditRoutineActivity.this.isEveryDayOld, AddAndEditRoutineActivity.this.isEveryWeekOld, AddAndEditRoutineActivity.this.isEveryMonthOld);
                } else {
                    AddAndEditRoutineActivity.this.routineSlotManager.createRoutine(AddAndEditRoutineActivity.this.routine, AddAndEditRoutineActivity.this.editTextRoutineName, AddAndEditRoutineActivity.this.routineManager, AddAndEditRoutineActivity.this.isAddToHomeScreen, AddAndEditRoutineActivity.this.isNotification, AddAndEditRoutineActivity.this.myYear, AddAndEditRoutineActivity.this.myMonth, AddAndEditRoutineActivity.this.myDay, AddAndEditRoutineActivity.this.myHour, AddAndEditRoutineActivity.this.myMinute, 2, "", AddAndEditRoutineActivity.this.isEverDay, AddAndEditRoutineActivity.this.isEverWeek, AddAndEditRoutineActivity.this.isEverMonth);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void ShowDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogPrefercesOrangeListView);
        builder.setTitle(getString(R.string.Action));
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.alert_dialog_listview, null);
        RecyclerView alertDialogListView = (RecyclerView) view.findViewById(R.id.alertDialogListView);
        alertDialogListView.setLayoutManager(new LinearLayoutManager(this));
       alertDialogListView.setAdapter(customListViewAdapterAlertDialog);


       customListViewAdapterAlertDialog.SetOnItemclickListener(new onitemclickListener() {


           @Override
           public void onitemclick(SingleAlertDialogRow arrayList, int i ) {
               Log.d("t", "test" + arrayList.string);
               Log.d("t", "test slot position " + i);

               AddAndEditRoutineActivity.this.routineSlotManager.setRoutineSlots(i);
               if (i == 8) {

                   alertDialogListView.setVisibility(View.INVISIBLE);
                   listView.setVisibility(View.INVISIBLE);

                   AddAndEditRoutineActivity.this.listViewForApps.setVisibility(View.VISIBLE);
                   AddAndEditRoutineActivity.this.listViewForApps.setAdapter((ListAdapter) AddAndEditRoutineActivity.this.allAppsAdapter);
                   AddAndEditRoutineActivity.this.item1.setVisible(true);
                   AddAndEditRoutineActivity.this.itemAddToHomeScreen.setVisible(false);
                   AddAndEditRoutineActivity.this.chooseAppText.setVisibility(0);
                   AddAndEditRoutineActivity.this.AllRoutinesActionText.setVisibility(4);
               }
               if (i == 9) {
                   AddAndEditRoutineActivity.this.setTimerDialog = new SetTimerDialog();
                   if (AddAndEditRoutineActivity.this.getIntent().hasExtra("routine")) {
                       AddAndEditRoutineActivity addAndEditRoutineActivity = AddAndEditRoutineActivity.this;
                       addAndEditRoutineActivity.oldroutine = (Routine) addAndEditRoutineActivity.getIntent().getSerializableExtra("routine");
                       AddAndEditRoutineActivity.this.timerBundle.putString("timerName", AddAndEditRoutineActivity.this.oldroutine.timerName);
                       AddAndEditRoutineActivity.this.timerBundle.putInt("timerSeconds", AddAndEditRoutineActivity.this.oldroutine.timerSeconds);
                       AddAndEditRoutineActivity.this.timerBundle.putInt("timerMinutes", AddAndEditRoutineActivity.this.oldroutine.timerMinutes);
                       AddAndEditRoutineActivity.this.timerBundle.putInt("timerHours", AddAndEditRoutineActivity.this.oldroutine.timerHours);
                       AddAndEditRoutineActivity.this.setTimerDialog.setArguments(AddAndEditRoutineActivity.this.timerBundle);
                       AddAndEditRoutineActivity.this.setTimerDialog.show(AddAndEditRoutineActivity.this.getSupportFragmentManager(), "dialog");
                       return;
                   }
                   AddAndEditRoutineActivity.this.timerBundle.putString("timerName", AddAndEditRoutineActivity.this.timerName);
                   AddAndEditRoutineActivity.this.timerBundle.putInt("timerSeconds", AddAndEditRoutineActivity.this.timerSeconds);
                   AddAndEditRoutineActivity.this.timerBundle.putInt("timerMinutes", AddAndEditRoutineActivity.this.timerMinutes);
                   AddAndEditRoutineActivity.this.timerBundle.putInt("timerHours", AddAndEditRoutineActivity.this.timerHours);
                   AddAndEditRoutineActivity.this.setTimerDialog.setArguments(AddAndEditRoutineActivity.this.timerBundle);
                   AddAndEditRoutineActivity.this.setTimerDialog.setArguments(AddAndEditRoutineActivity.this.timerBundle);
                   AddAndEditRoutineActivity.this.setTimerDialog.show(AddAndEditRoutineActivity.this.getSupportFragmentManager(), "dialog");
               }
           }

       });








       

        builder.setView(view);




         
         




        builder.create().show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_edit_activity, menu);
        this.item1 = menu.findItem(R.id.serachForApps).setVisible(false);
        this.itemAddToHomeScreen = menu.findItem(R.id.addRoutineToHomeScreen).setVisible(true);
        this.itemNotification = menu.findItem(R.id.notification_icon).setVisible(true);
        MenuItem visible = menu.findItem(R.id.notificationSwitchItem).setVisible(true);
        this.itemNotificationSwitch = visible;
        this.switchNotification = (Switch) MenuItemCompat.getActionView(visible);
        SearchView searchView2 = (SearchView) MenuItemCompat.getActionView(this.item1);
        if (this.isOldRoutine) {
            loadSwitchState();
        } else {
            this.switchNotification.setChecked(false);
            this.switchNotification.setEnabled(false);
        }
        searchView2.setOnSearchClickListener(new View.OnClickListener() {
            /* class com.mn.myroutines.AddAndEditRoutineActivity.AnonymousClass4 */

            public void onClick(View v) {
                AddAndEditRoutineActivity.this.getSupportActionBar().setDisplayShowTitleEnabled(false);
            }
        });
        searchView2.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            /* class com.mn.myroutines.AddAndEditRoutineActivity.AnonymousClass5 */

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String newText) {
                AddAndEditRoutineActivity.this.allAppsAdapter.getFilter().filter(newText);
                return false;
            }
        });
        this.switchNotification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.mn.myroutines.AddAndEditRoutineActivity.AnonymousClass6 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    AddAndEditRoutineActivity.this.isNotification = true;
                    AddAndEditRoutineActivity.this.routineManager.saveRoutineList();
                    return;
                }
                AddAndEditRoutineActivity.this.isNotification = false;
                AddAndEditRoutineActivity.this.switchNotification.setChecked(false);
                AddAndEditRoutineActivity.this.switchNotification.setEnabled(false);
                AddAndEditRoutineActivity.this.routineManager.saveRoutineList();
            }
        });
        return true;
    }

    private void loadSwitchState() {
        this.switchNotification.setChecked(this.oldroutine.getIsNotification());
        if (!this.oldroutine.getIsNotification()) {
            this.switchNotification.setChecked(false);
            this.switchNotification.setEnabled(false);
            return;
        }
        this.switchNotification.setChecked(true);
        this.switchNotification.setEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.addRoutineToHomeScreen) {
            this.isAddToHomeScreen = true;
            Toast.makeText(this.context, (int) R.string.ToAddThisShortcut, 0).show();
        } else if (itemId == R.id.notification_icon) {
            new DatePickerFragmentNotification().show(getSupportFragmentManager(), "date time picker");
        }
        return super.onOptionsItemSelected(item);
    }

    private void ShowAllAppsDialog() {
        List<ApplicationInfo> pkgAppsList = this.context.getPackageManager().getInstalledApplications(128);
        AlertDialog.Builder builderApps = new AlertDialog.Builder(this);
        builderApps.setTitle("choose App");
        final AllAppsAdapter allAppsAdapter2 = new AllAppsAdapter(this, R.layout.app_item_row, pkgAppsList, this.appName, this.appPackageName);
        this.appPackageName = allAppsAdapter2.getAppPackageName();
        this.appName = allAppsAdapter2.getAppNameString();
        Log.d("s", "Name =" + this.appName);
        builderApps.setAdapter(allAppsAdapter2, new DialogInterface.OnClickListener() {
            /* class com.mn.myroutines.AddAndEditRoutineActivity.AnonymousClass7 */

            public void onClick(DialogInterface dialog, int which) {
                allAppsAdapter2.onClickListener(which);
                AddAndEditRoutineActivity.this.appName = allAppsAdapter2.getAppNameString();
            }
        });
        AlertDialog create = builderApps.create();
        this.dialog = create;
        create.show();
    }

    public void getAppName() {
        this.listViewForApps.setVisibility(4);
        this.listView.setVisibility(0);
        this.itemAddToHomeScreen.setVisible(true);
        this.item1.setVisible(false);
        this.chooseAppText.setVisibility(4);
        this.AllRoutinesActionText.setVisibility(0);
        if (this.routineSlotManager.whichSlotPosition == 0) {
            String str = this.appName;
            this.appName1 = str;
            String str2 = this.appPackageName;
            this.appPackageName1 = str2;
            this.routineSlotManager.getAppNameAndPackage(str, str2);
            Log.d("runApp", "wich " + this.routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name1" + this.appName1);
            this.routineSlotManager.setNewAction();
        } else if (this.routineSlotManager.whichSlotPosition == 1) {
            String str3 = this.appName;
            this.appName2 = str3;
            String str4 = this.appPackageName;
            this.appPackageName2 = str4;
            this.routineSlotManager.getAppNameAndPackage(str3, str4);
            Log.d("runApp", "wich " + this.routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name2" + this.appName2);
            this.routineSlotManager.setNewAction();
        } else if (this.routineSlotManager.whichSlotPosition == 2) {
            String str5 = this.appName;
            this.appName3 = str5;
            String str6 = this.appPackageName;
            this.appPackageName3 = str6;
            this.routineSlotManager.getAppNameAndPackage(str5, str6);
            Log.d("runApp", "wich " + this.routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name3" + this.appName3);
            this.routineSlotManager.setNewAction();
        } else if (this.routineSlotManager.whichSlotPosition == 3) {
            String str7 = this.appName;
            this.appName4 = str7;
            String str8 = this.appPackageName;
            this.appPackageName4 = str8;
            this.routineSlotManager.getAppNameAndPackage(str7, str8);
            Log.d("runApp", "wich " + this.routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name4" + this.appName4);
            this.routineSlotManager.setNewAction();
        } else if (this.routineSlotManager.whichSlotPosition == 4) {
            String str9 = this.appName;
            this.appName5 = str9;
            String str10 = this.appPackageName;
            this.appPackageName5 = str10;
            this.routineSlotManager.getAppNameAndPackage(str9, str10);
            Log.d("runApp", "wich " + this.routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name5" + this.appName5);
            this.routineSlotManager.setNewAction();
        } else if (this.routineSlotManager.whichSlotPosition == 5) {
            String str11 = this.appName;
            this.appName6 = str11;
            String str12 = this.appPackageName;
            this.appPackageName6 = str12;
            this.routineSlotManager.getAppNameAndPackage(str11, str12);
            Log.d("runApp", "wich " + this.routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name6" + this.appName6);
            this.routineSlotManager.setNewAction();
        } else if (this.routineSlotManager.whichSlotPosition == 6) {
            String str13 = this.appName;
            this.appName7 = str13;
            String str14 = this.appPackageName;
            this.appPackageName7 = str14;
            this.routineSlotManager.getAppNameAndPackage(str13, str14);
            Log.d("runApp", "wich " + this.routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name7" + this.appName7);
            this.routineSlotManager.setNewAction();
        } else if (this.routineSlotManager.whichSlotPosition == 7) {
            String str15 = this.appName;
            this.appName8 = str15;
            String str16 = this.appPackageName;
            this.appPackageName8 = str16;
            this.routineSlotManager.getAppNameAndPackage(str15, str16);
            Log.d("runApp", "wich " + this.routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name8" + this.appName8);
            this.routineSlotManager.setNewAction();
        } else if (this.routineSlotManager.whichSlotPosition == 8) {
            String str17 = this.appName;
            this.appName9 = str17;
            String str18 = this.appPackageName;
            this.appPackageName9 = str18;
            this.routineSlotManager.getAppNameAndPackage(str17, str18);
            Log.d("runApp", "wich " + this.routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name9" + this.appName9);
            this.routineSlotManager.setNewAction();
        } else if (this.routineSlotManager.whichSlotPosition == 9) {
            String str19 = this.appName;
            this.appName10 = str19;
            String str20 = this.appPackageName;
            this.appPackageName10 = str20;
            this.routineSlotManager.getAppNameAndPackage(str19, str20);
            Log.d("runApp", "wich " + this.routineSlotManager.whichSlotPosition);
            Log.d("runApp", "name10" + this.appName10);
            this.routineSlotManager.setNewAction();
        }
    }

    private void initManagers() {
        this.routineManager = new RoutineManager(this.context);
        this.customListViewAdapter = new CustomListViewAdapter(context, arrayList, actionImages);
        this.routineSlotManager = new RoutineSlotManager(this.context, this, this.listView, customListViewAdapter, this.ArrayListSlotDefault, this.newActionString, this.noActionString, this.bluetoothOff, this.bluetoothOn, this.mediaVolumeMute, this.mediaVolumeMax, this.speakerVolumeMute, this.speakerVolumeVibration, this.speakerVolumeMax, this.runApp, this.runTimer, this.wifiOff, this.wifiOn, this.listViewItemPosition, this.routinelistPositionSlot1, this.routinelistPositionSlot2, this.routinelistPositionSlot3, this.routinelistPositionSlot4, this.routinelistPositionSlot5, this.routinelistPositionSlot6, this.routinelistPositionSlot7, this.routinelistPositionSlot8, this.routinelistPositionSlot9, this.routinelistPositionSlot10, this.whichSlotPosition, this.editTextRoutineName);
        this.shortcutManager = new ShortcutManager(this.context, this);
        new NotificationManager(this.context, this.routineManager, new Intent());
    }

    public void setDefaultSlots() {
        this.routineSlotManager.setDefaultSlots();
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (this.listViewForApps.getVisibility() == 0) {
            this.listViewForApps.setVisibility(4);
            this.customListViewAdapter.stringArrayList.set(this.routineSlotManager.whichSlotPosition, this.noActionString);
            this.customListViewAdapter.notifyDataSetChanged();
            this.listView.setVisibility(0);
            this.item1.setVisible(false);
            this.itemAddToHomeScreen.setVisible(true);
            this.chooseAppText.setVisibility(4);
            this.AllRoutinesActionText.setVisibility(0);
        } else if (this.listViewForApps.getVisibility() == 4) {
            Intent intent = new Intent(this, MainActivity.class);
            finish();
            startActivity(intent);
        }
    }

    @Override // com.mn.myroutines.SetTimerDialog.setTimerInterface
    public void setTimerSettings(int seconds, int minutes, int hour, String TimerName) {
        this.timerSeconds = seconds;
        Log.d("AddAcivity", "seconds in der Activity vom Interface " + this.timerSeconds);
        this.timerMinutes = minutes;
        Log.d("AddAcivity", "minutes in der Activity vom Interface " + this.timerMinutes);
        this.timerHours = hour;
        Log.d("AddAcivity", "hour in der Activity vom Interface " + this.timerHours);
        this.timerName = TimerName;
        this.timerBundle.putString("timerName", TimerName);
        this.timerBundle.putInt("timerSeconds", this.timerSeconds);
        this.timerBundle.putInt("timerMinutes", this.timerMinutes);
        this.timerBundle.putInt("timerHours", this.timerHours);
        Log.d("AddAcivity", "Name in der Activity vom Interface " + this.timerBundle.get("timerName"));
        this.routineSlotManager.getTimerSettings(this.timerSeconds, this.timerMinutes, this.timerHours, this.timerName);
    }

    public void callBackDataFromAsynctask(List<ApplicationInfo> list) {
    }

    public void updateUILayout(String content) {
    }

    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        this.myYear = year;
        this.myMonth = month;
        this.myDay = dayOfMonth;
        Log.d("Notification", "cal year =" + this.myYear);
        Log.d("Notification", "cal day =" + this.myDay);
        Log.d("Notification", "cal next =" + this.myDay);
        Log.d("Notification", "cal month = " + this.myMonth);
        new TimePickerFragmentNotification().show(getSupportFragmentManager(), "dialog time");
    }

    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        this.myHour = hour;
        this.myMinute = minute;
        Log.d("Notification", "cal hour =" + this.myHour);
        Log.d("Notification", "cal minute =" + this.myMinute);
        new CustomNotificationDialog().show(getSupportFragmentManager(), "notification options");
    }

    @Override // com.mn.myroutines.CustomNotificationDialog.CustomNotficationDialogListener
    public void applayNotfication(boolean isEverDay2, boolean isEverMonth2, boolean isEverWeek2, boolean isVibrationNo2, boolean isVibrationShort2, boolean isVibrationMedium2, boolean isVibrationLomg2) {
        this.isEverDay = isEverDay2;
        this.isEverMonth = isEverMonth2;
        this.isEverWeek = isEverWeek2;
        this.isVibrationNo = isVibrationNo2;
        this.isVibrationShort = isVibrationShort2;
        this.isVibrationMedium = isVibrationMedium2;
        this.isVibrationLomg = isVibrationLomg2;
        Log.d("Notification", "cal isEveryDay =" + isEverDay2);
        Log.d("Notification", "cal isEveryMonth =" + isEverMonth2);
        Log.d("Notification", "cal isEveryWeek =" + isEverWeek2);
        Log.d("Notification", "cal isVibrationNo =" + isVibrationNo2);
        Log.d("Notification", "cal isVibrationShort =" + isVibrationShort2);
        Log.d("Notification", "cal isVibrationMedium =" + isVibrationMedium2);
        Log.d("Notification", "cal isVibrationLong =" + isVibrationLomg2);
        this.isNotification = true;
        this.switchNotification.setChecked(true);
        this.switchNotification.setEnabled(true);
    }


}
