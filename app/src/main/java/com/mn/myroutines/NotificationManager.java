package com.mn.myroutines;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.format.DateFormat;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

public class NotificationManager {
    Context context;
    Intent intent;
    private String monthly;
    public int monthplus1;
    public int monthplus10;
    public int monthplus11;
    public int monthplus12;
    public int monthplus13;
    public int monthplus14;
    public int monthplus15;
    public int monthplus16;
    public int monthplus17;
    public int monthplus18;
    public int monthplus19;
    public int monthplus2;
    public int monthplus20;
    public int monthplus21;
    public int monthplus22;
    public int monthplus23;
    public int monthplus24;
    public int monthplus25;
    public int monthplus26;
    public int monthplus27;
    public int monthplus28;
    public int monthplus29;
    public int monthplus3;
    public int monthplus30;
    public int monthplus4;
    public int monthplus5;
    public int monthplus6;
    public int monthplus7;
    public int monthplus8;
    public int monthplus9;
    public int myDay;
    public int myHour;
    public int myMinute;
    public int myMonth;
    public int myYear;
    public int position;
    int randomReqestCode;
    public Routine routine;
    RoutineManager routineManager;
    public String taskAlarmDate;
    public int taskPosition;
    public int taskbiggerThanMonth;

    public NotificationManager(Context context2, RoutineManager routineManager2, Intent intent2) {
        this.context = context2;
        this.routineManager = routineManager2;
    }

    public void cancelAlarm(Routine routine2) {
        AlarmManager alarmManager = (AlarmManager) this.context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent2 = new Intent(this.context, AlertReceiver.class);
        int reqestcodeint = routine2.getroutineRendemRequestCode();
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.context, reqestcodeint, intent2, 0);
        Log.d("cal", "die zahl ist " + reqestcodeint);
        if (!routine2.isCancel) {
            alarmManager.cancel(pendingIntent);
            this.routineManager.saveRoutineList();
        }
    }

    public void startAlarm(Routine routine2, int randomReqestCode2, int myYear2, int myMonth2, int myDay2, int myHour2, int myMinute2, String routineAlarmDate) {
        String routineAlarmDate2;
        AlarmManager alarmManager;
        String routineAlarmDate3;
        Intent intent2;
        String routineAlarmDate4;
        int randomReqestCode3;
        String routineAlarmDate5;
        AlarmManager alarmManager2;
        int i;
        int i2;
        int i3;
        Random random = new Random();
        this.routineManager.saveRoutineList();
        String daily = this.context.getString(R.string.notification_daily);
        String monthly2 = this.context.getString(R.string.notification_montly);
        String weekly = this.context.getString(R.string.notification_weekly);
        Calendar cal = Calendar.getInstance();
        cal.set(1, myYear2);
        cal.set(2, myMonth2);
        cal.set(5, myDay2);
        cal.set(11, myHour2);
        cal.set(12, myMinute2);
        cal.set(13, 0);
        cal.set(14, 0);
        cal.get(2);
        routine2.setRoutineMills(cal.getTimeInMillis());
        routine2.setRoutineDay(myDay2);
        routine2.setRoutineNext(myDay2);
        routine2.setRoutineHour(myHour2);
        routine2.setRoutineMinute(myMinute2);
        Log.d("cal", "das datum ist " + routine2.getRoutineMills());
        int randomReqestCode4 = random.nextInt(this.routineManager.getRoutineCount() + 7759);
        AlarmManager alarmManager3 = (AlarmManager) this.context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent3 = new Intent(this.context, AlertReceiver.class);
        intent3.putExtra("taskgetName", routine2.getRoutineName());
        intent3.putExtra("routinePosition", routine2.getRoutinePosition());
        intent3.putExtra("taskgetIsNoVibration", routine2.getIsVibrationNo());
        intent3.putExtra("taskgetIsShortVibration", routine2.getIsVibrationShort());
        intent3.putExtra("taskgetIsMediumVibration", routine2.getIsVibrationMedium());
        intent3.putExtra("taskgetIsLongVibration", routine2.getIsVibrationLong());
        intent3.putExtra("randemAlarmReqest", randomReqestCode4);
        intent3.putExtra("taskisEveryDay", routine2.isEveryDay);
        intent3.putExtra("myYear", myYear2);
        intent3.putExtra("myMinute", myMinute2);
        intent3.putExtra("myDay", myDay2);
        intent3.putExtra("myHour", myHour2);
        intent3.putExtra("myMonth", myMonth2);
        intent3.putExtra("taskAlarmDate", routineAlarmDate);
        if (!DateFormat.is24HourFormat(this.context) && !routine2.getIsEveryDay() && !routine2.isEveryMonth && !routine2.isEveryWeek) {
            routineAlarmDate2 = new SimpleDateFormat("EEE MMM dd hh:mm yyyy").format(cal.getTime());
            Log.d("Notification", "test ist aus");
            Log.d("Notification", "Alarm datum" + routineAlarmDate2);
        } else if (Locale.getDefault().getISO3Language().equals("de") || routine2.isEveryDay || routine2.isEveryMonth || routine2.isEveryWeek) {
            routineAlarmDate2 = routineAlarmDate;
        } else {
            routineAlarmDate2 = new SimpleDateFormat("EEE MMM dd hh:mm yyyy").format(cal.getTime());
            Log.d("Notification", "test ist aus");
            Log.d("Notification", "Alarm datum" + routineAlarmDate2);
        }
        if (!DateFormat.is24HourFormat(this.context) || routine2.isEveryDay || routine2.isEveryMonth || routine2.isEveryWeek) {
            alarmManager = alarmManager3;
            routineAlarmDate3 = routineAlarmDate2;
        } else {
            alarmManager = alarmManager3;
            routineAlarmDate3 = new SimpleDateFormat("EEE dd MMM HH:mm yyyy").format(cal.getTime());
            Log.d("Notification", "test ist aus");
            Log.d("Notification", "Alarm datum" + routineAlarmDate3);
        }
        if (DateFormat.is24HourFormat(this.context) || !routine2.isEveryDay) {
            intent2 = intent3;
            if (Locale.getDefault().getISO3Language().equals("de") || !routine2.isEveryDay) {
                routineAlarmDate4 = routineAlarmDate3;
            } else {
                routineAlarmDate4 = new SimpleDateFormat("EEE MMM dd hh:mm yyyy").format(cal.getTime());
                Log.d("Notification", "test ist daily");
            }
        } else {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm yyyy");
            StringBuilder sb = new StringBuilder();
            intent2 = intent3;
            sb.append(format.format(cal.getTime()));
            sb.append(", ");
            sb.append(daily);
            routineAlarmDate4 = sb.toString();
            Log.d("Notification", "test ist daily");
        }
        if (!DateFormat.is24HourFormat(this.context) || !routine2.isEveryDay) {
            randomReqestCode3 = randomReqestCode4;
            routineAlarmDate5 = routineAlarmDate4;
        } else {
            SimpleDateFormat format2 = new SimpleDateFormat("EEE dd MMM  HH:mm yyyy");
            StringBuilder sb2 = new StringBuilder();
            randomReqestCode3 = randomReqestCode4;
            sb2.append(format2.format(cal.getTime()));
            sb2.append(", ");
            sb2.append(daily);
            routineAlarmDate5 = sb2.toString();
            Log.d("Notification", "test ist daily");
        }
        if (!DateFormat.is24HourFormat(this.context) && routine2.isEveryMonth) {
            SimpleDateFormat format3 = new SimpleDateFormat("EEE MMM dd hh:mm yyyy");
            routineAlarmDate5 = format3.format(cal.getTime()) + ", " + monthly2;
            Log.d("Notification", "test ist montly");
        } else if (!Locale.getDefault().getISO3Language().equals("de") && routine2.isEveryMonth) {
            routineAlarmDate5 = new SimpleDateFormat("EEE MMM dd hh:mm yyyy").format(cal.getTime());
            Log.d("Notification", "test ist mothly");
        }
        if (DateFormat.is24HourFormat(this.context) && routine2.isEveryMonth) {
            SimpleDateFormat format4 = new SimpleDateFormat("EEE dd MMM  HH:mm yyyy");
            routineAlarmDate5 = format4.format(cal.getTime()) + ", " + monthly2;
            Log.d("Notification", "test ist montly");
        }
        if (!DateFormat.is24HourFormat(this.context) && routine2.isEveryWeek) {
            SimpleDateFormat format5 = new SimpleDateFormat("EEE MMM dd hh:mm yyyy");
            routineAlarmDate5 = format5.format(cal.getTime()) + ", " + weekly;
            Log.d("Notification", "test ist weekly");
        } else if (!Locale.getDefault().getISO3Language().equals("de") && routine2.isEveryWeek) {
            routineAlarmDate5 = new SimpleDateFormat("EEE MMM dd hh:mm yyyy").format(cal.getTime());
            Log.d("Notification", "test ist weekly");
        }
        if (DateFormat.is24HourFormat(this.context) && routine2.isEveryWeek) {
            SimpleDateFormat format6 = new SimpleDateFormat("EEE dd MMM HH:mm yyyy");
            routineAlarmDate5 = format6.format(cal.getTime()) + ", " + weekly;
            Log.d("Notification", "test ist weekly");
        }
        routine2.setRoutineAlarmDate(routineAlarmDate5);
        routine2.setRendemReqestCodeint(randomReqestCode3);
        this.routineManager.saveRoutineList();
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.context, randomReqestCode3, intent2, 0);
        if (routine2.isEveryDay) {
            if (Build.VERSION.SDK_INT >= 23) {
                alarmManager2 = alarmManager;
                i3 = 0;
                alarmManager2.setExactAndAllowWhileIdle(0, routine2.getRoutineMills(), pendingIntent);
            } else {
                alarmManager2 = alarmManager;
                i3 = 0;
            }
            alarmManager2.setExact(i3, routine2.getRoutineMills(), pendingIntent);
            alarmManager2.setRepeating(0, routine2.getRoutineMills(), 86400000, pendingIntent);
            Log.d("t", "wiederhlung ist jede Tag");
        } else {
            alarmManager2 = alarmManager;
            if (routine2.getIsEveryWeek()) {
                if (Build.VERSION.SDK_INT >= 23) {
                    i2 = 0;
                    alarmManager2.setExactAndAllowWhileIdle(0, routine2.getRoutineMills(), pendingIntent);
                } else {
                    i2 = 0;
                }
                alarmManager2.setExact(i2, routine2.getRoutineMills(), pendingIntent);
                alarmManager2.setRepeating(0, routine2.getRoutineMills(), 604800000, pendingIntent);
                Log.d("t", "wiederhlung ist jede Woche");
            } else {
                boolean z = routine2.isEveryMonth;
            }
        }
        if (!routine2.isEveryDay && !routine2.isEveryWeek && !routine2.isEveryMonth) {
            if (Build.VERSION.SDK_INT >= 23) {
                i = 0;
                alarmManager2.setExactAndAllowWhileIdle(0, routine2.getRoutineMills(), pendingIntent);
            } else {
                i = 0;
            }
            alarmManager2.setExact(i, routine2.getRoutineMills(), pendingIntent);
            Log.d("t", "wiederhlung ist jede Tag");
        }
        this.routineManager.saveRoutineList();
    }

    /* JADX INFO: Multiple debug info for r8v4 int: [D('weeklyPlus5' int), D('weekly' java.lang.String)] */
    /* JADX INFO: Multiple debug info for r7v4 int: [D('monthly' java.lang.String), D('weeklyPlus6' int)] */
    /* JADX INFO: Multiple debug info for r6v442 int: [D('monthplus12' int), D('taskbiggerThanMonth' int)] */
    /* JADX INFO: Multiple debug info for r6v542 'taskbiggerThanMonth'  int: [D('monthplus11' int), D('taskbiggerThanMonth' int)] */
    /* JADX INFO: Multiple debug info for r6v685 int: [D('monthplus6' int), D('taskbiggerThanMonth' int)] */
    /* JADX INFO: Multiple debug info for r6v785 'taskbiggerThanMonth'  int: [D('monthplus5' int), D('taskbiggerThanMonth' int)] */
    /* JADX INFO: Multiple debug info for r6v907 int: [D('monthplus1' int), D('taskbiggerThanMonth' int)] */
    /* JADX INFO: Multiple debug info for r6v1682 int: [D('currentMonth' int), D('mills' long)] */
    /* JADX INFO: Multiple debug info for r6v1851 int: [D('currentMonth' int), D('taskbiggerThanMonth' int)] */
    /* JADX WARNING: Code restructure failed: missing block: B:2321:0x3f71, code lost:
        if (r10 == 1) goto L_0x3f73;
     */
    /* JADX WARNING: Removed duplicated region for block: B:2414:0x41ce  */
    /* JADX WARNING: Removed duplicated region for block: B:2415:0x41dd  */
    /* JADX WARNING: Removed duplicated region for block: B:2418:0x41ee  */
    /* JADX WARNING: Removed duplicated region for block: B:2658:0x4723  */
    /* JADX WARNING: Removed duplicated region for block: B:2813:0x49d4  */
    /* JADX WARNING: Removed duplicated region for block: B:2968:0x4c85  */
    /* JADX WARNING: Removed duplicated region for block: B:3122:0x4f30  */
    /* JADX WARNING: Removed duplicated region for block: B:3242:0x507f  */
    /* JADX WARNING: Removed duplicated region for block: B:3278:0x51e9  */
    /* JADX WARNING: Removed duplicated region for block: B:3398:0x5338  */
    /* JADX WARNING: Removed duplicated region for block: B:3435:0x54a8  */
    /* JADX WARNING: Removed duplicated region for block: B:3590:0x575f  */
    /* JADX WARNING: Removed duplicated region for block: B:3745:0x5a10  */
    /* JADX WARNING: Removed duplicated region for block: B:3900:0x5cc2  */
    /* JADX WARNING: Removed duplicated region for block: B:4054:0x5f6e  */
    /* JADX WARNING: Removed duplicated region for block: B:4174:0x60bd  */
    /* JADX WARNING: Removed duplicated region for block: B:4210:0x6228  */
    /* JADX WARNING: Removed duplicated region for block: B:4330:0x6377  */
    /* JADX WARNING: Removed duplicated region for block: B:4367:0x64e8  */
    /* JADX WARNING: Removed duplicated region for block: B:4522:0x679a  */
    /* JADX WARNING: Removed duplicated region for block: B:4677:0x6a4b  */
    /* JADX WARNING: Removed duplicated region for block: B:4832:0x6cfc  */
    /* JADX WARNING: Removed duplicated region for block: B:4987:0x6fad  */
    /* JADX WARNING: Removed duplicated region for block: B:5142:0x725e  */
    /* JADX WARNING: Removed duplicated region for block: B:5297:0x750f  */
    /* JADX WARNING: Removed duplicated region for block: B:5452:0x77c0  */
    /* JADX WARNING: Removed duplicated region for block: B:5607:0x7a71  */
    /* JADX WARNING: Removed duplicated region for block: B:5762:0x7d22  */
    /* JADX WARNING: Removed duplicated region for block: B:5917:0x7fd3  */
    /* JADX WARNING: Removed duplicated region for block: B:6072:0x8285  */
    /* JADX WARNING: Removed duplicated region for block: B:6227:0x8536  */
    /* JADX WARNING: Removed duplicated region for block: B:6382:0x87e7  */
    /* JADX WARNING: Removed duplicated region for block: B:6537:0x8a98  */
    /* JADX WARNING: Removed duplicated region for block: B:6692:0x8d49  */
    /* JADX WARNING: Removed duplicated region for block: B:6847:0x8ffb  */
    /* JADX WARNING: Removed duplicated region for block: B:7002:0x92ad  */
    /* JADX WARNING: Removed duplicated region for block: B:7156:0x95d2  */
    /* JADX WARNING: Removed duplicated region for block: B:7165:0x961d  */
    /* JADX WARNING: Removed duplicated region for block: B:7184:0x96a0  */
    /* JADX WARNING: Removed duplicated region for block: B:7199:0x973b  */
    /* JADX WARNING: Removed duplicated region for block: B:7214:0x97d6  */
    /* JADX WARNING: Removed duplicated region for block: B:7229:0x989d  */
    /* JADX WARNING: Removed duplicated region for block: B:7234:0x98d5  */
    /* JADX WARNING: Removed duplicated region for block: B:7252:0x993c  */
    /* JADX WARNING: Removed duplicated region for block: B:7253:0x9945  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateStartAlarm(java.lang.String r47, int r48, com.mn.myroutines.Routine r49, int r50, int r51, int r52, int r53, int r54, int r55, int r56, int r57, int r58, int r59, int r60, int r61, int r62, int r63, int r64, int r65, int r66, int r67, int r68, int r69, int r70, int r71, int r72, int r73, int r74, int r75, int r76, int r77, int r78, int r79, int r80, int r81, int r82, int r83, int r84, int r85) {
        /*
        // Method dump skipped, instructions count: 39305
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mn.myroutines.NotificationManager.updateStartAlarm(java.lang.String, int, com.mn.myroutines.Routine, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int):void");
    }

    public void setMyMonth(Routine routine2, int currentMonth, AlarmManager alarmManager, long mills, PendingIntent pendingIntent, Calendar cal) {
        if (routine2.isEveryMonth) {
            if (currentMonth == 0 || currentMonth == 2 || currentMonth == 4 || currentMonth == 6 || currentMonth == 7 || currentMonth == 9 || currentMonth == 11) {
                if (Build.VERSION.SDK_INT >= 23) {
                    alarmManager.setExactAndAllowWhileIdle(0, routine2.getRoutineMills(), pendingIntent);
                }
                alarmManager.setExact(0, routine2.getRoutineMills(), pendingIntent);
                alarmManager.setRepeating(0, routine2.getRoutineMills(), 2678400000L, pendingIntent);
            } else if (currentMonth == 3 || currentMonth == 5 || currentMonth == 8 || currentMonth == 10) {
                if (Build.VERSION.SDK_INT >= 23) {
                    alarmManager.setExactAndAllowWhileIdle(0, routine2.getRoutineMills(), pendingIntent);
                }
                alarmManager.setExact(0, routine2.getRoutineMills(), pendingIntent);
                alarmManager.setRepeating(0, routine2.getRoutineMills(), 2592000000L, pendingIntent);
            } else if (currentMonth == 1 && ((GregorianCalendar) GregorianCalendar.getInstance()).isLeapYear(cal.get(1))) {
                if (Build.VERSION.SDK_INT >= 23) {
                    alarmManager.setExactAndAllowWhileIdle(0, routine2.getRoutineMills(), pendingIntent);
                }
                alarmManager.setExact(0, routine2.getRoutineMills(), pendingIntent);
                alarmManager.setRepeating(0, routine2.getRoutineMills(), 2505600000L, pendingIntent);
            }
            if (currentMonth == 1 && !((GregorianCalendar) GregorianCalendar.getInstance()).isLeapYear(cal.get(1))) {
                if (Build.VERSION.SDK_INT >= 23) {
                    alarmManager.setExactAndAllowWhileIdle(0, routine2.getRoutineMills(), pendingIntent);
                }
                alarmManager.setExact(0, routine2.getRoutineMills(), pendingIntent);
                alarmManager.setRepeating(0, routine2.getRoutineMills(), 2419200000L, pendingIntent);
            }
        }
    }
}
