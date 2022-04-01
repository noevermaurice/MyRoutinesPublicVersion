package com.mn.myroutines;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class RoutineCreateListView extends AppCompatDialogFragment {
    DarkModeManager darkModeManager;

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogPrefercesOrange);
        getActivity().getLayoutInflater().inflate(R.layout.routine_create_listview, (ViewGroup) null);
        String[] strArr = {"hh"};
        builder.setTitle("Haalo");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.custom_list_view_row);
        arrayAdapter.add("Hardik");
        arrayAdapter.add("Archit");
        arrayAdapter.add("Jignesh");
        arrayAdapter.add("Umang");
        arrayAdapter.add("Gatti");
        builder.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            /* class com.mn.myroutines.RoutineCreateListView.AnonymousClass1 */

            public void onClick(DialogInterface dialog, int which) {
            }
        });
        return builder.create();
    }
}
