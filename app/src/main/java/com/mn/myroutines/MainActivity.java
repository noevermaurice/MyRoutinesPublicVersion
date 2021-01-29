package com.mn.myroutines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    // Objects Deklartation
   RecyclerView recyclerView;
    FloatingActionButton addNewRoutine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initClickListener();
    }


    private void initViews(){
        // serach views with id
        recyclerView = findViewById(R.id.routinesList);
        addNewRoutine = findViewById(R.id.addRoutine);
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