package com.mn.myroutines;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

public class SettingsFragment extends PreferenceFragment {
    DarkModeManager darkModeManager;
    RoutineSettingsManager routineSettingsManager;

    public void onCreate(Bundle savedInstanceState) {
        this.darkModeManager = new DarkModeManager(getContext());
        this.routineSettingsManager = new RoutineSettingsManager(getContext());
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        getPreferenceScreen().findPreference("changeDarkMode").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {

            public boolean onPreferenceChange(Preference preference, Object newValue) {

                switch (newValue.toString()){
                    case "System settings":
                        darkModeManager.setMode(DarkModeManager.DAY_NIGHT);
                        preference.setSummary((CharSequence) newValue);
                        refershSettings();
                        break;

                    case "Light":
                        darkModeManager.setMode(DarkModeManager.DAY);
                        preference.setSummary((CharSequence) newValue);
                        refershSettings();
                        break;

                    case "Dark":
                        darkModeManager.setMode(DarkModeManager.NIGHT);
                        preference.setSummary((CharSequence) newValue);
                        refershSettings();



                }


                return true;
            }
        });
        getPreferenceScreen().findPreference("changeAppTime").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            /* class com.mn.myroutines.SettingsFragment.AnonymousClass2 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                char c;
                String obj = newValue.toString();
                switch (obj.hashCode()) {
                    case 46319594:
                        if (obj.equals("1 sek")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 47243115:
                        if (obj.equals("2 sek")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 48166636:
                        if (obj.equals("3 sek")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 49090157:
                        if (obj.equals("4 sek")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 50013678:
                        if (obj.equals("5 sek")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 50937199:
                        if (obj.equals("6 sek")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 51860720:
                        if (obj.equals("7 sek")) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case 52784241:
                        if (obj.equals("8 sek")) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case 53707762:
                        if (obj.equals("9 sek")) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case 1448224472:
                        if (obj.equals("10 sek")) {
                            c = '\t';
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        SettingsFragment.this.routineSettingsManager.setAppTime(1000);
                        preference.setSummary((CharSequence) newValue);
                        SettingsFragment.this.refershSettings();
                        break;
                    case 1:
                        SettingsFragment.this.routineSettingsManager.setAppTime(2000);
                        preference.setSummary((CharSequence) newValue);
                        SettingsFragment.this.refershSettings();
                        break;
                    case 2:
                        SettingsFragment.this.routineSettingsManager.setAppTime(3000);
                        preference.setSummary((CharSequence) newValue);
                        SettingsFragment.this.refershSettings();
                        break;
                    case 3:
                        SettingsFragment.this.routineSettingsManager.setAppTime(4000);
                        preference.setSummary((CharSequence) newValue);
                        SettingsFragment.this.refershSettings();
                        break;
                    case 4:
                        SettingsFragment.this.routineSettingsManager.setAppTime(5000);
                        preference.setSummary((CharSequence) newValue);
                        SettingsFragment.this.refershSettings();
                        break;
                    case 5:
                        SettingsFragment.this.routineSettingsManager.setAppTime(6000);
                        preference.setSummary((CharSequence) newValue);
                        SettingsFragment.this.refershSettings();
                        break;
                    case 6:
                        SettingsFragment.this.routineSettingsManager.setAppTime(7000);
                        preference.setSummary((CharSequence) newValue);
                        SettingsFragment.this.refershSettings();
                        break;
                    case 7:
                        SettingsFragment.this.routineSettingsManager.setAppTime(8000);
                        preference.setSummary((CharSequence) newValue);
                        SettingsFragment.this.refershSettings();
                        break;
                    case 8:
                        SettingsFragment.this.routineSettingsManager.setAppTime(9000);
                        preference.setSummary((CharSequence) newValue);
                        SettingsFragment.this.refershSettings();
                        break;
                    case 9:
                        SettingsFragment.this.routineSettingsManager.setAppTime(10000);
                        preference.setSummary((CharSequence) newValue);
                        SettingsFragment.this.refershSettings();
                        break;
                }
                return true;
            }
        });
        getPreferenceScreen().findPreference("TutorialKey").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            /* class com.mn.myroutines.SettingsFragment.AnonymousClass3 */

            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(SettingsFragment.this.getActivity(), TutorialActivity.class);
                SettingsFragment.this.getActivity().finish();
                SettingsFragment.this.getActivity().startActivity(intent);
                return true;
            }
        });

        getPreferenceScreen().findPreference("MyRoutinesProKey").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(SettingsFragment.this.getActivity(), LoginScreen.class);
                SettingsFragment.this.getActivity().startActivity(intent);
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void refershSettings() {
        getActivity().recreate();
        this.darkModeManager.getMode();
    }
}
