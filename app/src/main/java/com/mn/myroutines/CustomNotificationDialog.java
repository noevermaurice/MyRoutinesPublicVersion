package com.mn.myroutines;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class CustomNotificationDialog extends AppCompatDialogFragment {
    private CheckBox checkBoxEveryDay;
    private CheckBox checkBoxEveryMonth;
    private CheckBox checkBoxEveryWeek;
    private CheckBox checkBoxVibrationLong;
    private CheckBox checkBoxVibrationMedium;
    private CheckBox checkBoxVibrationNo;
    private CheckBox checkBoxVibrationShort;
    private boolean isEveryDay;
    private boolean isEveryMonth;
    private boolean isEveryWeek;
    private boolean isVibrationLong;
    private boolean isVibrationMedium;
    private boolean isVibrationNo;
    private boolean isVibrationShort;
    private CustomNotficationDialogListener listener;

    public interface CustomNotficationDialogListener {
        void applayNotfication(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7);
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.custom_notification_dialog, (ViewGroup) null);
        builder.setView(view).setTitle(R.string.NotificationDialogSettings).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            /* class com.mn.myroutines.CustomNotificationDialog.AnonymousClass1 */

            public void onClick(DialogInterface dialogInterface, int i) {
                if (CustomNotificationDialog.this.checkBoxEveryDay.isChecked()) {
                    CustomNotificationDialog.this.isEveryDay = true;
                } else {
                    CustomNotificationDialog.this.isEveryDay = false;
                }
                if (CustomNotificationDialog.this.checkBoxEveryMonth.isChecked()) {
                    CustomNotificationDialog.this.isEveryMonth = true;
                } else {
                    CustomNotificationDialog.this.isEveryMonth = false;
                }
                if (CustomNotificationDialog.this.checkBoxEveryWeek.isChecked()) {
                    CustomNotificationDialog.this.isEveryWeek = true;
                } else {
                    CustomNotificationDialog.this.isEveryWeek = false;
                }
                if (CustomNotificationDialog.this.checkBoxVibrationNo.isChecked()) {
                    CustomNotificationDialog.this.isVibrationNo = true;
                } else {
                    CustomNotificationDialog.this.isVibrationNo = false;
                }
                if (CustomNotificationDialog.this.checkBoxVibrationShort.isChecked()) {
                    CustomNotificationDialog.this.isVibrationShort = true;
                } else {
                    CustomNotificationDialog.this.isVibrationShort = false;
                }
                if (CustomNotificationDialog.this.checkBoxVibrationMedium.isChecked()) {
                    CustomNotificationDialog.this.isVibrationMedium = true;
                } else {
                    CustomNotificationDialog.this.isVibrationMedium = false;
                }
                if (CustomNotificationDialog.this.checkBoxVibrationLong.isChecked()) {
                    CustomNotificationDialog.this.isVibrationLong = true;
                } else {
                    CustomNotificationDialog.this.isVibrationLong = false;
                }
                CustomNotificationDialog.this.listener.applayNotfication(CustomNotificationDialog.this.isEveryDay, CustomNotificationDialog.this.isEveryMonth, CustomNotificationDialog.this.isEveryWeek, CustomNotificationDialog.this.isVibrationNo, CustomNotificationDialog.this.isVibrationShort, CustomNotificationDialog.this.isVibrationMedium, CustomNotificationDialog.this.isVibrationLong);
            }
        });
        this.checkBoxEveryDay = (CheckBox) view.findViewById(R.id.CheckboxEveryDay);
        this.checkBoxEveryMonth = (CheckBox) view.findViewById(R.id.CheckboxEveryMonth);
        this.checkBoxEveryWeek = (CheckBox) view.findViewById(R.id.CheckboxEveryWeek);
        this.checkBoxVibrationNo = (CheckBox) view.findViewById(R.id.CheckboxNonVibtation);
        this.checkBoxVibrationShort = (CheckBox) view.findViewById(R.id.CheckboxVibrationShort);
        this.checkBoxVibrationMedium = (CheckBox) view.findViewById(R.id.CheckboxVirbrationMedium);
        this.checkBoxVibrationLong = (CheckBox) view.findViewById(R.id.CheckboxVibrationLong);
        return builder.create();
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.DialogFragment
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.listener = (CustomNotficationDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement Dialog");
        }
    }
}
