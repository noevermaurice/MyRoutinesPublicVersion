package com.mn.myroutines;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
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

    int listViewItemPosition;


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

    }

    private void initClickListener() {
        // listnen for Clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int ListItemposition, long id) {
                ListItemposition = listViewItemPosition;
                routineSlotManager.setRoutineSlots();
            }
        });

    }

    private void initManagers() {
        // inisalraztion for all Mangers in the App
        // init RoutineManger
        routineManager = new RoutineManager(context);
        // int listviewAdapterRoutine
        listviewAdapterRoutine = new ListviewAdapterRoutine(context, arrayList);
        //init RoutineSlotManger
        routineSlotManager = new RoutineSlotManager(context,listView, listviewAdapterRoutine, ArrayListSlotDefault,listViewItemPosition);





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
