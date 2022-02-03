package com.mn.myroutines;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;
import java.util.Date;

public class DatePickerFragmentNotification extends DialogFragment {
    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), (DatePickerDialog.OnDateSetListener) getActivity(), calendar.get(1), calendar.get(2), calendar.get(5));
        calendar.add(5, 0);
        Date newdate = calendar.getTime();
        datePickerDialog.getDatePicker().setMinDate(newdate.getTime() - (newdate.getTime() % 86400000));
        return datePickerDialog;
    }
}
