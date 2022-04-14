package com.mn.myroutines;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mn.myroutines.RoutineListAdapter;

public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";
    FloatingActionButton addNewRoutine;
    DarkModeManager darkModeManager;
    int isNotficationPolicy = 0;
    int isTutorial = 0;
    RecyclerView recyclerView;
    RoutineListAdapter routineListAdapter;
    RoutineManager routineManager;
    TextView textViewNoRoutinesAvabile;
    int routinePosition;
    String routineName;
    String routineNameInList;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.darkModeManager = new DarkModeManager(this);
        setContentView(R.layout.activity_main);
        loadTutorial();
        loadNotficationPolicy();
        initViews();
        initClickListener();
        NoRoutinesAvabilbe();
        checkIsShortCut();
        checkIsNotification();
    }

    private void checkIsNotification() {
        if (getIntent().hasExtra("routinePosition") && getIntent().hasExtra("notificationText")) {

            routinePosition = getIntent().getIntExtra("routinePosition", 0);
            routineName = getIntent().getStringExtra("notificationText");
            startRoutine(routinePosition, routineName);






        }
    }

    private void checkIsShortCut() {
        if (getIntent().hasExtra("isShortcut") && getIntent().hasExtra("routineGetName")) {
            routinePosition = getIntent().getIntExtra("ShortcutPosition", 0);
            routineName = getIntent().getStringExtra("routineGetName");
            startRoutine(routinePosition, routineName);


        }
    }

    private void startRoutine(int routinePosition, String routineName){

            Log.d("T", "Routine vorhanden");

            Log.d("Shortcuts", "position in shortcut " + routinePosition);
            Log.d("Shortcuts", "position in list  " + routineManager.routineList.get(routinePosition).getRoutineName());

            Log.d("Shortcuts", "Text in shortcut  " + routineName);
            Log.d("Shortcuts", "Text in list   " + routineManager.routineList.get(routinePosition).getRoutineName());



            // search in rountinelist for the right routine name and the right position in list
            for(Routine routine : routineManager.routineList) {
                if (routine.getRoutineName().equals(routineName)) {

                    Log.d("Shortcuts", "Shortcut gefunden");

                    int newPosition = routineManager.routineList.indexOf(routine);

                    Log.d("Shortcuts", "Position in list " + newPosition);

                    new RoutineActionManager(this, this).startRoutine(this.routineManager.routineList.get(newPosition));
                    Toast.makeText(this, getString(R.string.RoutineRun), Toast.LENGTH_SHORT).show();



                }
            }



        }



    @SuppressLint("WrongConstant")
    private void initPermissions() {
        if (((NotificationManager) getSystemService("notification")).isNotificationPolicyAccessGranted() || this.isNotficationPolicy != 0) {
            this.isNotficationPolicy = 1;
            return;
        }
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Information");
        alertDialog.setMessage(getString(R.string.InformationAboutSettings));
        alertDialog.setButton(-1, "OK", new DialogInterface.OnClickListener() {
            /* class com.mn.myroutines.MainActivity.AnonymousClass1 */

            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.isNotficationPolicy = 1;
                MainActivity.this.saveNotficationPolicy();
                MainActivity.this.startActivity(new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS"));
            }
        });
        alertDialog.setButton(-2, getString(R.string.cancel), new DialogInterface.OnClickListener() {
            /* class com.mn.myroutines.MainActivity.AnonymousClass2 */

            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.isNotficationPolicy = 1;
                MainActivity.this.saveNotficationPolicy();
            }
        });
        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.mn.myroutines.MainActivity.AnonymousClass3 */

            public void onCancel(DialogInterface dialog) {
                alertDialog.dismiss();
                MainActivity.this.isNotficationPolicy = 1;
                MainActivity.this.saveNotficationPolicy();
            }
        });
        alertDialog.show();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void saveNotficationPolicy() {
        SharedPreferences.Editor editor = getPreferences(0).edit();
        editor.putInt("NotificationPolicy", this.isNotficationPolicy);
        editor.apply();
    }

    private void loadNotficationPolicy() {
        this.isNotficationPolicy = getPreferences(0).getInt("NotificationPolicy", 0);
        Log.d("NotificationPolicy", "NotificationPolicy" + this.isNotficationPolicy);
        if (this.isNotficationPolicy == 0) {
            initPermissions();
        }
    }

    private void initPermissionsTutorial() {
        if (this.isTutorial == 0) {
            final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Tutorial");
            alertDialog.setMessage(getString(R.string.TutorialInformation));
            alertDialog.setButton(-1, "OK", new DialogInterface.OnClickListener() {
                /* class com.mn.myroutines.MainActivity.AnonymousClass4 */

                public void onClick(DialogInterface dialog, int which) {
                    MainActivity.this.isTutorial = 1;
                    MainActivity.this.saveTutorialState();
                    MainActivity.this.startActivity(new Intent(MainActivity.this, TutorialActivity.class));
                }
            });
            alertDialog.setButton(-2, getString(R.string.cancel), new DialogInterface.OnClickListener() {
                /* class com.mn.myroutines.MainActivity.AnonymousClass5 */

                public void onClick(DialogInterface dialog, int which) {
                    MainActivity.this.isTutorial = 1;
                    MainActivity.this.saveTutorialState();
                }
            });
            alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                /* class com.mn.myroutines.MainActivity.AnonymousClass6 */

                public void onCancel(DialogInterface dialog) {
                    alertDialog.dismiss();
                    MainActivity.this.isTutorial = 1;
                    MainActivity.this.saveTutorialState();
                }
            });
            alertDialog.show();
            return;
        }
        this.isTutorial = 1;
        saveTutorialState();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void saveTutorialState() {
        SharedPreferences.Editor editor = getPreferences(0).edit();
        editor.putInt("Tutorial", this.isTutorial);
        editor.apply();
        Log.d("Tutorial", "Tutorial" + this.isTutorial);
    }

    private void loadTutorial() {
        this.isTutorial = getPreferences(0).getInt("Tutorial", 0);
        Log.d("Tutorial", "Tutorial" + this.isTutorial);
        if (this.isTutorial == 0) {
            initPermissionsTutorial();
        }
    }

    private void initViews() {
        this.routineManager = new RoutineManager(this);
        this.routineListAdapter = new RoutineListAdapter(this.routineManager, this, this);
        this.recyclerView = (RecyclerView) findViewById(R.id.routinesList);
        this.addNewRoutine = (FloatingActionButton) findViewById(R.id.addRoutine);
        this.textViewNoRoutinesAvabile = (TextView) findViewById(R.id.noRoutinesAvabile);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.routinesList);
        this.recyclerView = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(this.routineListAdapter);
        this.routineListAdapter.notifyDataSetChanged();
        this.routineListAdapter.SetOnItemclickListener(new RoutineListAdapter.onitemclickListener() {
            /* class com.mn.myroutines.MainActivity.AnonymousClass7 */

            @Override // com.mn.myroutines.RoutineListAdapter.onitemclickListener
            public void onitemclick(int position, Routine routine) {
                Intent intent = new Intent(MainActivity.this, AddAndEditRoutineActivity.class);
                intent.putExtra("routine", routine);
                intent.putExtra("routinePosition", position);

                MainActivity.this.finish();
                MainActivity.this.startActivity(intent);
            }
        });
    }

    private void NoRoutinesAvabilbe() {
        if (this.routineManager.routineList.isEmpty()) {
            this.textViewNoRoutinesAvabile.setVisibility(View.VISIBLE);
        } else {
            this.textViewNoRoutinesAvabile.setVisibility(View.INVISIBLE);
        }
    }

    private void initClickListener() {
        this.addNewRoutine.setOnClickListener(new View.OnClickListener() {
            /* class com.mn.myroutines.MainActivity.AnonymousClass8 */

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddAndEditRoutineActivity.class);
                MainActivity.this.finish();
                MainActivity.this.startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.settingsItem) {
            Intent intent = new Intent(this, SettingsActivity.class);
            finish();
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        if (0 < 1) {
            finish();
        }
        super.onStop();
        Log.d(this.TAG, "Pause wurde gestoppt");
    }
}
