package com.mn.myroutines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends  AppCompatActivity {
    // Objects Deklartation
   RecyclerView recyclerView;
    FloatingActionButton addNewRoutine;
    RoutineListAdapter routineListAdapter;
    RoutineManager routineManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initClickListener();
    }


    private void initViews(){
        // serach views with id
        routineManager = new RoutineManager(this);
        routineListAdapter = new RoutineListAdapter(routineManager, this);
        recyclerView = findViewById(R.id.routinesList);
        addNewRoutine = findViewById(R.id.addRoutine);

        recyclerView = findViewById(R.id.routinesList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(routineListAdapter);
        routineListAdapter.notifyDataSetChanged();

        routineListAdapter.SetOnItemclickListener(new RoutineListAdapter.onitemclickListener() {
            @Override
            public void onitemclick(int position,Routine routine) {
                Intent intent = new Intent(MainActivity.this, AddAndEditRoutineActivity.class);
                intent.putExtra("routine", routine);
                intent.putExtra("position", position);
                finish();
                startActivity(intent);
            }
        });
    }

    private void initClickListener() {
        // lisener for click
        addNewRoutine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // start new Activity to create a Routine and finish the old
                // create new Intent
                Intent intent = new Intent(MainActivity.this, AddAndEditRoutineActivity.class);
                // finish Acivity
                finish();
                // start new Activity
                startActivity(intent);
            }
        });
    }


}