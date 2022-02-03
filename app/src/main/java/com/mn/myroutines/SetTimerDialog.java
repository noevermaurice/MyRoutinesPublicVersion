package com.mn.myroutines;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class SetTimerDialog extends AppCompatDialogFragment {
    public String TimerName;
    public EditText editTextHour;
    public EditText editTextMinutes;
    public EditText editTextSeconds;
    public EditText editTextTimerName;
    public int hour;
    public setTimerInterface listener;
    public int minutes;
    public int seconds;

    public interface setTimerInterface {
        void setTimerSettings(int i, int i2, int i3, String str);
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogPrefercesOrange);
        View view = getActivity().getLayoutInflater().inflate(R.layout.set_timer, (ViewGroup) null);
        this.editTextTimerName = (EditText) view.findViewById(R.id.edittTextTimerName);
        this.editTextSeconds = (EditText) view.findViewById(R.id.edittextSecond);
        this.editTextMinutes = (EditText) view.findViewById(R.id.edittextMinute);
        this.editTextHour = (EditText) view.findViewById(R.id.edittextHour);
        Bundle args = getArguments();
        String timerName = args.getString("timerName");
        int seconds2 = args.getInt("timerSeconds");
        int minutes2 = args.getInt("timerMinutes");
        int hours2 = args.getInt("timerHours");
        String MinutesString = String.valueOf(minutes2);
        String SecondsString = String.valueOf(seconds2);
        String HourString = String.valueOf(hours2);
        Log.d("TimerDialog", "args " + timerName);
        if (timerName != null) {
            this.editTextTimerName.setText(timerName);
        }
        this.editTextSeconds.setText(SecondsString);
        this.editTextMinutes.setText(MinutesString);
        this.editTextHour.setText(HourString);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            /* class com.mn.myroutines.SetTimerDialog.AnonymousClass1 */

            public void onClick(DialogInterface dialog, int which) {
                SetTimerDialog.this.setTimerTime();
            }
        });
        builder.setNegativeButton(getString(R.string.NegativeButton), new DialogInterface.OnClickListener() {
            /* class com.mn.myroutines.SetTimerDialog.AnonymousClass2 */

            public void onClick(DialogInterface dialog, int which) {
                SetTimerDialog.this.dismiss();
            }
        });
        builder.setView(view);
        return builder.create();
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.DialogFragment
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.listener = (setTimerInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "  must implement Dialog");
        }
    }

    public void setTimerTime() {
        if (this.editTextSeconds.length() == 0) {
            this.editTextSeconds.setText("00");
        }
        if (this.editTextMinutes.length() == 0) {
            this.editTextMinutes.setText("00");
        }
        if (this.editTextHour.length() == 0) {
            this.editTextHour.setText("00");
        }
        this.seconds = Integer.parseInt(this.editTextSeconds.getText().toString());
        Log.d("SetTimerDialog", "seconds " + this.seconds);
        this.minutes = Integer.parseInt(this.editTextMinutes.getText().toString());
        Log.d("SetTimerDialog", "minutes " + this.minutes);
        this.hour = Integer.parseInt(this.editTextHour.getText().toString());
        Log.d("SetTimerDialog", "hour " + this.hour);
        this.listener.setTimerSettings(this.seconds, this.minutes, this.hour, this.editTextTimerName.getText().toString());
    }
}
