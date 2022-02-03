package com.mn.myroutines;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;

public class TimePickerFragmentNotification extends DialogFragment {
    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        return new TimePickerDialog(getContext(), (TimePickerDialog.OnTimeSetListener) getActivity(), calendar.get(11), calendar.get(12), DateFormat.is24HourFormat(getActivity()));
    }
}
