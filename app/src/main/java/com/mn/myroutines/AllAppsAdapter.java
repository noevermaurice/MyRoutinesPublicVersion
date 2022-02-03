package com.mn.myroutines;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class AllAppsAdapter extends ArrayAdapter<ApplicationInfo> {
    private AddAndEditRoutineActivity activity;
    public String appNameString = new String();
    public String appPackageName;
    private List<ApplicationInfo> appsList;
    private AppsFilter filter;
    ViewHolder holder;
    private List<ApplicationInfo> originalList;
    private PackageManager packageManager;

    public AllAppsAdapter(AddAndEditRoutineActivity activity2, int textViewResourceId, List<ApplicationInfo> appsList2, String appNameString2, String appPackageName2) {
        super(activity2, textViewResourceId, appsList2);
        this.activity = activity2;
        this.appsList = appsList2;
        this.originalList = appsList2;
        this.appNameString = appNameString2;
        this.appPackageName = appPackageName2;
        this.packageManager = activity2.getPackageManager();
    }

    public int getCount() {
        return this.appsList.size();
    }

    @Override // android.widget.ArrayAdapter
    public ApplicationInfo getItem(int position) {
        return this.appsList.get(position);
    }

    public long getItemId(int position) {
        return (long) this.appsList.indexOf(getItem(position));
    }

    public Filter getFilter() {
        if (this.filter == null) {
            this.filter = new AppsFilter();
        }
        return this.filter;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder2;
        LayoutInflater inflater = (LayoutInflater) this.activity.getSystemService("layout_inflater");
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.app_item_row, parent, false);
            holder2 = new ViewHolder(convertView);
            convertView.setTag(holder2);
        } else {
            holder2 = (ViewHolder) convertView.getTag();
        }
        holder2.appName.setText(getItem(position).loadLabel(this.packageManager));
        holder2.appPackage.setText(getItem(position).packageName);
        holder2.icon.setImageDrawable(getItem(position).loadIcon(this.packageManager));
        convertView.setOnClickListener(onClickListener(position));
        return convertView;
    }

    public View.OnClickListener onClickListener(final int position) {
        return new View.OnClickListener() {
            /* class com.mn.myroutines.AllAppsAdapter.AnonymousClass1 */

            public void onClick(View v) {
                ApplicationInfo app = (ApplicationInfo) AllAppsAdapter.this.appsList.get(position);
                AllAppsAdapter.this.setAppPackageName(app.packageName);
                AllAppsAdapter.this.setAppNameString((String) app.loadLabel(AllAppsAdapter.this.packageManager));
                AllAppsAdapter.this.activity.getAppName();
            }
        };
    }

    public void setAppNameString(String appNameString2) {
        this.appNameString = appNameString2;
        this.activity.appName = appNameString2;
        Log.d("AllAppsAdapter", " App Name " + this.activity.appName);
    }

    public String getAppNameString() {
        return this.appNameString;
    }

    public void setAppPackageName(String appPackageName2) {
        this.appPackageName = appPackageName2;
        this.activity.appPackageName = appPackageName2;
        Log.d("AllAppsAdapter", " Package Name " + this.activity.appPackageName);
    }

    public String getAppPackageName() {
        return this.appPackageName;
    }

    public class ViewHolder {
        public TextView appName;
        public TextView appPackage;
        public ImageView icon;

        public ViewHolder(View v) {
            this.icon = (ImageView) v.findViewById(R.id.icon);
            this.appName = (TextView) v.findViewById(R.id.name);
            this.appPackage = (TextView) v.findViewById(R.id.app_package);
        }
    }

    private class AppsFilter extends Filter {
        private AppsFilter() {
        }

        /* access modifiers changed from: protected */
        public Filter.FilterResults performFiltering(CharSequence constraint) {
            Filter.FilterResults results = new Filter.FilterResults();
            if (constraint == null || constraint.length() <= 0) {
                results.count = AllAppsAdapter.this.originalList.size();
                results.values = AllAppsAdapter.this.originalList;
            } else {
                ArrayList<ApplicationInfo> filterList = new ArrayList<>();
                for (int i = 0; i < AllAppsAdapter.this.originalList.size(); i++) {
                    if (((ApplicationInfo) AllAppsAdapter.this.originalList.get(i)).loadLabel(AllAppsAdapter.this.packageManager).toString().toUpperCase().contains(constraint.toString().toUpperCase())) {
                        filterList.add((ApplicationInfo) AllAppsAdapter.this.originalList.get(i));
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            }
            return results;
        }

        /* access modifiers changed from: protected */
        public void publishResults(CharSequence constraint, Filter.FilterResults results) {
            AllAppsAdapter.this.appsList = (ArrayList) results.values;
            AllAppsAdapter.this.notifyDataSetChanged();
            if (AllAppsAdapter.this.appsList.size() == AllAppsAdapter.this.originalList.size()) {
                AddAndEditRoutineActivity addAndEditRoutineActivity = AllAppsAdapter.this.activity;
                addAndEditRoutineActivity.updateUILayout("All apps (" + AllAppsAdapter.this.appsList.size() + ")");
                return;
            }
            AddAndEditRoutineActivity addAndEditRoutineActivity2 = AllAppsAdapter.this.activity;
            addAndEditRoutineActivity2.updateUILayout("Filtered apps (" + AllAppsAdapter.this.appsList.size() + ")");
        }
    }
}
