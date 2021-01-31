package com.mn.myroutines;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;


public class SetTimerDialog extends AppCompatDialogFragment {
    private TimerDialogInterface listener;
    public EditText editTextTimerName;
    public EditText editTextSeconds;
    public EditText editTextMinutes;
    public EditText editTextHour;

    public int seconds;
    public int minutes;
    public int hour;
    String valueSeconds;
    String valueMinutes;
    String valueHour;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.set_timer, null);
        editTextTimerName = view.findViewById(R.id.edittTextTimerName);
        editTextSeconds = view.findViewById(R.id.edittextSecond);
        editTextMinutes = view.findViewById(R.id.edittextMinute);
        editTextHour = view.findViewById(R.id.edittextHour);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // make a string and past the text from edittext
                valueSeconds= editTextSeconds.getText().toString();
                valueMinutes = editTextMinutes.getText().toString();
                valueHour = editTextHour.getText().toString();
                // convertiere the string in a int
                if (!(editTextSeconds.getText().length() == 00))
                {
                    seconds =Integer.parseInt(valueSeconds);
                    Log.d("SetTimerDialog" , "seconds " + seconds);
                } else {
                    seconds =0;
                }

                if ( editTextMinutes.length() == 0){
                    minutes =0;
                } else {
                    minutes = Integer.parseInt(valueMinutes);
                    Log.d("SetTimerDialog" , "minutes " + minutes);
                }

                if (editTextHour.length() == 0){
                    hour = 0;
                } else {
                    hour = Integer.parseInt(valueHour);
                    Log.d("SetTimerDialog" , "hour " + hour);
                }

            }
        });
        builder.setNegativeButton(getString(R.string.NegativeButton), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });
        builder.setView(view);

        return builder.create();
    }

    public interface  TimerDialogInterface{
        void setTimer(int seconds, int minutes, int hour);
    }


}
