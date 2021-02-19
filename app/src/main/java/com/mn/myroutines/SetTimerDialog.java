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

    public EditText editTextTimerName;
    public EditText editTextSeconds;
    public EditText editTextMinutes;
    public EditText editTextHour;
    public setTimerInterface listener;

    public int seconds;
    public int minutes;
    public int hour;



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.set_timer, null);
        editTextTimerName = view.findViewById(R.id.edittTextTimerName);
        editTextSeconds = view.findViewById(R.id.edittextSecond);
        editTextMinutes = view.findViewById(R.id.edittextMinute);
        editTextHour = view.findViewById(R.id.edittextHour);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // make a string and past the text from edittext

                // convertiere the string in a int

                if (editTextSeconds.length() == 0){
                    editTextSeconds.setText("00");

                }

                if (editTextMinutes.length() == 0){
                    editTextMinutes.setText("00");
                }

                if (editTextHour.length() == 00){
                    editTextHour.setText("00");
                }

                seconds = Integer.parseInt(editTextSeconds.getText().toString());
                Log.d("SetTimerDialog", "seconds " + seconds);
                minutes =Integer.parseInt(editTextMinutes.getText().toString());
                Log.d("SetTimerDialog", "minutes " + minutes);
                hour = Integer.parseInt(editTextHour.getText().toString());
                Log.d("SetTimerDialog", "hour " +hour);
                listener.setTimerSettings(seconds,minutes, hour, editTextTimerName.getText().toString());

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

    public interface setTimerInterface{
        void setTimerSettings(int seconds,int minutes, int hour, String TimerName);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (setTimerInterface) context;
        } catch (ClassCastException e) {
            throw  new ClassCastException(context.toString()+ "  must implement Dialog");
        }
    }





}
