package com.mn.myroutines;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.List;

public class GetAllAppsTask extends AsyncTask<Void, Void, List<ApplicationInfo>> {
    private AddAndEditRoutineActivity activity;
    private List<ApplicationInfo> apps;
    private PackageManager packageManager;

    public GetAllAppsTask(AddAndEditRoutineActivity activity2, List<ApplicationInfo> apps2, PackageManager pm) {
        this.activity = activity2;
        this.apps = apps2;
        this.packageManager = pm;
    }

    /* access modifiers changed from: protected */
    public List<ApplicationInfo> doInBackground(Void... params) {
        List<ApplicationInfo> checkForLaunchIntent = checkForLaunchIntent(this.packageManager.getInstalledApplications(128));
        this.apps = checkForLaunchIntent;
        return checkForLaunchIntent;
    }

    private List<ApplicationInfo> checkForLaunchIntent(List<ApplicationInfo> list) {
        ArrayList<ApplicationInfo> applist = new ArrayList<>();
        for (ApplicationInfo applicationInfo : list) {
            try {
                if (this.packageManager.getLaunchIntentForPackage(applicationInfo.packageName) != null) {
                    applist.add(applicationInfo);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return applist;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(List<ApplicationInfo> list) {
        super.onPostExecute((List<ApplicationInfo>) list);
        this.activity.callBackDataFromAsynctask(list);
    }
}
