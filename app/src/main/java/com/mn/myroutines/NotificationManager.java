package com.mn.myroutines;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.Toast;

import com.mn.myroutines.AlertReceiver;
import com.mn.myroutines.R;
import com.mn.myroutines.Routine;
import com.mn.myroutines.RoutineManager;
import com.mn.myroutines.RoutineSettingsManager;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

public class NotificationManager {
    Context context;
    RoutineManager routineManager;
    public int myYear, myMonth, myDay, myHour, myMinute, taskbiggerThanMonth, monthplus1, monthplus2, monthplus3, monthplus4, monthplus5, monthplus6, monthplus7, monthplus8, monthplus9, monthplus10, monthplus11, monthplus12, monthplus13, monthplus14, monthplus15, monthplus16, monthplus17, monthplus18, monthplus19, monthplus20, monthplus21, monthplus22, monthplus23, monthplus24, monthplus25, monthplus26, monthplus27, monthplus28, monthplus29, monthplus30;
    int randomReqestCode;
    public String taskAlarmDate;
    private String monthly;
    public Routine routine;
    public  int position;
    public int taskPosition;

    Intent intent;

    public NotificationManager(Context context, RoutineManager routineManager, Intent intent) {
        this.context = context;
        this.routineManager = routineManager;


    }

    public void cancelAlarm(Routine routine) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlertReceiver.class);
        int reqestcodeint = routine.getroutineRendemRequestCode();
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, reqestcodeint, intent, 0);
        Log.d("cal", "die zahl ist " + reqestcodeint);


        if (!routine.isCancel) {
            alarmManager.cancel(pendingIntent);
            routineManager.saveRoutineList();


        }
    }

    public void startAlarm(Routine routine, int randomReqestCode, int myYear, int myMonth, int myDay, int myHour, int myMinute, String routineAlarmDate) {
        Random random = new Random();
        routineManager.saveRoutineList();;
        String daily = context.getString(R.string.notification_daily);
        String monthly = context.getString(R.string.notification_montly);
        String weekly = context.getString(R.string.notification_weekly);


        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, myYear);
        cal.set(Calendar.MONTH, myMonth);
        cal.set(Calendar.DAY_OF_MONTH, myDay);
        cal.set(Calendar.HOUR_OF_DAY, myHour);
        cal.set(Calendar.MINUTE, myMinute);
        cal.set(Calendar.SECOND, 000);
        cal.set(Calendar.MILLISECOND, 000);
        int currentMonth = cal.get(Calendar.MONTH);
        long mills = cal.getTimeInMillis();
        routine.setRoutineMills(mills);
        routine.setRoutineYear(myYear);
        routine.setRoutineMonth(myMonth);
        routine.setRoutineDay(myDay);
        routine.setRoutineHour(myHour);
        routine.setRoutineMinute(myMinute);
        Log.d("cal", "das datum ist " + routine.getRoutineMills());

        randomReqestCode = random.nextInt(routineManager.getRoutineCount() + 7759);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, AlertReceiver.class);
        intent.putExtra("routineGetName", routine.getRoutineName());
        intent.putExtra("outineGetIsNoVibration", routine.getIsVibrationNo());
        intent.putExtra("routineGetIsShortVibration", routine.getIsVibrationShort());
        intent.putExtra("routineGetIsMediumVibration", routine.getIsVibrationMedium());
        intent.putExtra("routineGetIsLongVibration", routine.getIsVibrationLong());
        intent.putExtra("randemAlarmReqest", randomReqestCode);
        intent.putExtra("routineisEveryDay", routine.getIsEveryDay());
        intent.putExtra("routine", routine);
        intent.putExtra("myYear", myYear);
        intent.putExtra("myMinute", myMinute);
        intent.putExtra("myDay", myDay);
        intent.putExtra("myHour", myHour);
        intent.putExtra("myMonth", myMonth);
        intent.putExtra("routineAlarmDate", routineAlarmDate);



        if (!DateFormat.is24HourFormat(context) && !routine.getIsEveryDay() && !routine.getIsEveryMonth() && !routine.getIsEveryWeek()) {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm yyyy");
            taskAlarmDate = format.format(cal.getTime());
            Log.d("t", "test ist aus" + taskAlarmDate);
        } else if (!Locale.getDefault().getISO3Language().equals("de") && !routine.getIsEveryDay() && !routine.getIsEveryMonth() && !routine.getIsEveryWeek()) {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm yyyy");
            taskAlarmDate = format.format(cal.getTime());
            Log.d("t", "test ist aus" + taskAlarmDate);
        }

        if (DateFormat.is24HourFormat(context) && !routine.getIsEveryDay() && !routine.getIsEveryMonth() && !routine.getIsEveryWeek()) {
            SimpleDateFormat format = new SimpleDateFormat("EEE dd MMM HH:mm yyyy");
            taskAlarmDate = format.format(cal.getTime());
            Log.d("t", "test ist aus" + taskAlarmDate);
        }

        if (!DateFormat.is24HourFormat(context) && routine.getIsEveryDay()) {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm yyyy");
            taskAlarmDate = format.format(cal.getTime()) + ", " + daily;
            Log.d("t", "test ist daily" + taskAlarmDate);
        } else if (!Locale.getDefault().getISO3Language().equals("de") && routine.getIsEveryDay()) {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm yyyy");
            taskAlarmDate = format.format(cal.getTime());
            Log.d("t", "test ist daily" + taskAlarmDate);
        }

        if (DateFormat.is24HourFormat(context) && routine.getIsEveryDay()) {
            SimpleDateFormat format = new SimpleDateFormat("EEE dd MMM  HH:mm yyyy");
            taskAlarmDate = format.format(cal.getTime()) + ", " + daily;
            Log.d("t", "test ist daily" + taskAlarmDate);
        }

        if (!DateFormat.is24HourFormat(context) && routine.getIsEveryMonth()) {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm yyyy");
            taskAlarmDate = format.format(cal.getTime()) + ", " + monthly;
            Log.d("t", "test ist montly" + taskAlarmDate);
        } else if (!Locale.getDefault().getISO3Language().equals("de") && routine.getIsEveryMonth()) {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm yyyy");
            taskAlarmDate = format.format(cal.getTime());
            Log.d("t", "test ist mothly" + taskAlarmDate);
        }
        if (DateFormat.is24HourFormat(context) && routine.getIsEveryMonth()) {
            SimpleDateFormat format = new SimpleDateFormat("EEE dd MMM  HH:mm yyyy");
            taskAlarmDate = format.format(cal.getTime()) + ", " + monthly;
            Log.d("t", "test ist montly" + taskAlarmDate);
        }

        if (!DateFormat.is24HourFormat(context) && routine.getIsEveryWeek()) {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm yyyy");
            taskAlarmDate = format.format(cal.getTime()) + ", " + weekly;
            Log.d("t", "test ist weekly" + taskAlarmDate);
        } else if (!Locale.getDefault().getISO3Language().equals("de") && routine.getIsEveryWeek()) {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm yyyy");
            taskAlarmDate = format.format(cal.getTime());
            Log.d("t", "test ist weekly" + taskAlarmDate);
        }
        if (DateFormat.is24HourFormat(context) && routine.getIsEveryWeek()) {
            SimpleDateFormat format = new SimpleDateFormat("EEE dd MMM HH:mm yyyy");
            taskAlarmDate = format.format(cal.getTime()) + ", " + weekly;
            Log.d("t", "test ist weekly" + taskAlarmDate);
        }


        routine.setRoutineAlarmDate(taskAlarmDate);
        routine.setRendemReqestCodeint(randomReqestCode);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, randomReqestCode, intent, 0);

        RoutineSettingsManager routineSettingsManager = new RoutineSettingsManager(context);



        if (routine.getIsEveryDay()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);

            }
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), AlarmManager.INTERVAL_DAY, pendingIntent);
            Log.d("t", "wiederhlung ist jede Tag");
        } else if (routine.getIsEveryWeek()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);
            }
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), AlarmManager.INTERVAL_DAY * 7, pendingIntent);
            Log.d("t", "wiederhlung ist jede Woche");
        } else if (routine.getIsEveryMonth()) {
            setMyMonth(routine, currentMonth, alarmManager, routine.getRoutineMills(), pendingIntent, cal);
        }



        if (!routine.getIsEveryDay() && !routine.getIsEveryWeek() && !routine.getIsEveryMonth()){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);
            }
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);
            Log.d("t", "wiederhlung ist jede Tag");
        }



    }




    public void updateStartAlarm(int taskPosition, Routine routine, int myYear, int  myMonth, int myDay, int myHour, int myMinute, int taskbiggerThanMonth, int monthplus1, int  monthplus2, int monthplus3, int monthplus4, int monthplus5, int  monthplus6, int  monthplus7, int monthplus8, int monthplus9, int  monthplus10, int  monthplus11, int  monthplus12, int monthplus13, int  monthplus14, int monthplus15, int  monthplus16, int  monthplus17, int  monthplus18, int  monthplus19, int monthplus20, int  monthplus21, int  monthplus22, int monthplus23, int  monthplus24, int monthplus25, int monthplus26, int monthplus27, int monthplus28, int  monthplus29, int  monthplus30) {
        this.myYear = myYear;
        this.routine = routine;
        this.taskPosition = taskPosition;
        this.myMonth = myMonth;
        this.myDay = myDay;
        this.myHour = myHour;
        this.myMinute = myMinute;
        this.taskbiggerThanMonth = taskbiggerThanMonth;
        this.monthplus1 = monthplus1;
        this.monthplus2 = monthplus2;
        this.monthplus3 = monthplus3;
        this.monthplus4 = monthplus4;
        this.monthplus5 = monthplus5;
        this.monthplus6 = monthplus6;
        this.monthplus7 = monthplus7;
        this.monthplus8 = monthplus8;
        this.monthplus9 = monthplus9;
        this.monthplus10 = monthplus10;
        this.monthplus11 = monthplus11;
        this.monthplus12 = monthplus12;
        this.monthplus13 = monthplus13;
        this.monthplus14 = monthplus14;
        this.monthplus15 = monthplus15;
        this.monthplus16 = monthplus16;
        this.monthplus17 = monthplus17;
        this.monthplus18 = monthplus18;
        this.monthplus19 = monthplus19;
        this.monthplus20 = monthplus20;
        this.monthplus21 = monthplus21;
        this.monthplus22 = monthplus22;
        this.monthplus23 = monthplus23;
        this.monthplus24 = monthplus24;
        this.monthplus25 = monthplus25;
        this.monthplus26 = monthplus26;
        this.monthplus27 = monthplus27;
        this.monthplus28 = monthplus28;
        this.monthplus29 = monthplus29;
        this.monthplus30 = monthplus30;


        String daily = context.getString(R.string.notification_daily);
        String monthly = context.getString(R.string.notification_montly);
        String weekly = context.getString(R.string.notification_weekly);

        Calendar cal = Calendar.getInstance();


        int weeklyPlus0 = routine.getRoutineNext();
        int weeklyPlus1 = routine.getRoutineNext() + 1;
        int weeklyPlus2 = routine.getRoutineNext() + 2;
        int weeklyPlus3 = routine.getRoutineNext() + 3;
        int weeklyPlus4 = routine.getRoutineNext() + 4;
        int weeklyPlus5 = routine.getRoutineNext() + 5;
        int weeklyPlus6 = routine.getRoutineNext() + 6;




        Log.d("hallo", "update alarm run");
        Log.d("hallo", "day in update methode " + routine.getRoutineDay());
        Log.d("hallo", "minute in update methode " + routine.getRoutineMinute());
        Log.d("hallo", "hour in update methode " + routine.getRoutineHour());





        // calender system zeit kleiner
        if (cal.get(Calendar.DAY_OF_MONTH) >= routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && !routine.getIsEveryWeek() && !routine.getIsEveryDay() && !routine.getIsEveryMonth() || cal.get(Calendar.DAY_OF_MONTH) >= routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && !routine.getIsEveryWeek() && !routine.getIsEveryDay() && !routine.getIsEveryMonth() || cal.get(Calendar.DAY_OF_MONTH) >= routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && !routine.getIsEveryWeek() && !routine.getIsEveryDay() && !routine.getIsEveryMonth()  || cal.get(Calendar.MONTH) < routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) <= routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && !routine.getIsEveryWeek() && !routine.getIsEveryDay() && !routine.getIsEveryMonth() || cal.get(Calendar.MONTH) > routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && !routine.getIsEveryDay() && ! routine.getIsEveryWeek() && !routine.getIsEveryMonth() || cal.get(Calendar.MONTH) > routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour()  && !routine.getIsEveryDay() && ! routine.getIsEveryWeek() && !routine.getIsEveryMonth() || cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay() && !routine.getIsEveryDay() && !routine.getIsEveryWeek() && !routine.getIsEveryMonth()) {
            Log.d("hallo", "System zeit ist kleiner no");
            cal.set(Calendar.YEAR, myYear);
            cal.set(Calendar.MONTH, routine.getRoutineMonth());
            if (myDay < routine.getRoutineDay() && myMonth > routine.getRoutineMonth() ||myDay < routine.getRoutineDay() && myMonth < routine.getRoutineMonth() || myDay > routine.getRoutineDay() && myMonth == routine.getRoutineMonth() ){
                cal.set(Calendar.DAY_OF_MONTH, myDay);
            } else {
                cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            }

            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);
            int currentMonth = cal.get(Calendar.MONTH);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            if (myDay < routine.getRoutineDay() && myMonth > routine.getRoutineMonth() ||myDay < routine.getRoutineDay() && myMonth < routine.getRoutineMonth() || myDay > routine.getRoutineDay() && myMonth == routine.getRoutineMonth()  ){
                routine.setRoutineDay(myDay);
                routine.setRoutineWeek(myDay);
                routine.setRoutineMonth(myMonth);
            } else {
                routine.setRoutineDay(routine.getRoutineDay());
                routine.setRoutineWeek(routine.getRoutineDay());
                routine.setRoutineMonth(routine.getRoutineMonth());
            }



            Log.d("hallo", "day = " + routine.getRoutineDay());
            Log.d("hallo", "next = " + routine.getRoutineNext());
            Log.d("hallo", "month = "+ routine.getRoutineMonth());


        }


        //

        // calender kleiner 2

        if (cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && !routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth && cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay() || cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && !routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth && cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay() || cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && !routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth && cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay() || cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && !routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth && cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay() || cal.get(Calendar.MONTH) < routine.getRoutineMonth() && cal.get(Calendar.MONTH) < routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && !routine.isEveryDay && !routine.getIsEveryWeek && !routine.isEveryMonth) {
            Log.d("hallo", "System zeit ist kleiner 2 no");
            cal.set(Calendar.YEAR, myYear);
            cal.set(Calendar.MONTH, routine.getRoutineMonth());
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            routine.setRoutineDay(routine.getRoutineDay());
            routine.setRoutineWeek(routine.getRoutineDay());
            routine.setRoutineMonth(routine.getRoutineMonth());


            Log.d("hallo", "day = " + routine.getRoutineDay());
            Log.d("hallo", "next = " + routine.getRoutineNext());
            Log.d("hallo", "month = "+ routine.getRoutineMonth());
        }




        // calender größer

        if (cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && !routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && cal.get(Calendar.MINUTE) <= routine.getRoutineMinute() && !routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && cal.get(Calendar.MINUTE) >= routine.getRoutineMinute() && !routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth) {
            Log.d("hallo", "System zeit ist größer no");
            cal.set(Calendar.YEAR, myYear);
            cal.set(Calendar.MONTH, myMonth);
            if (myDay == 29 && myMonth ==1){
                routine.setRoutineDay(1);
                routine.setRoutineWeek(1);
            }

            if (myDay == 28 && myMonth == 1){
                routine.setRoutineDay(29);
                routine.setRoutineWeek(1);
            }

            cal.set(Calendar.DAY_OF_MONTH, myDay + 1);
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            if (myDay == 28 && myMonth >= 1){
                routine.setRoutineDay(29);
                routine.setRoutineWeek(1);
            }

            if (myDay == 30){
                routine.setRoutineDay(31);
                routine.setRoutineWeek(1);
            }

            if (myDay == 31){
                routine.setRoutineDay(1);
                routine.setRoutineWeek(1);
                if (myMonth ==11){
                    routine.setRoutineMonth(1);
                } else if (myMonth < 11){
                    routine.setRoutineMonth(myMonth+1);
                }

            }



            if (myDay == 29 && myMonth ==1){
                routine.setRoutineDay(1);
                routine.setRoutineWeek(1);
            } else {
                routine.setRoutineDay(myDay +1);
                routine.setRoutineWeek(myDay +1);
            }




            Log.d("hallo", "day = " + routine.getRoutineDay());
            Log.d("hallo", "next = " + routine.getRoutineNext());
            Log.d("hallo", "month = "+ routine.getRoutineMonth());


        }

        // calender Daily system zeit kleiner
        if (cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) <= routine.getRoutineMinute() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) >= routine.getRoutineMinute() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && routine.isEveryDay &&!routine.getIsEveryWeek && !routine.isEveryMonth ||cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour()&& !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth ||cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute()&& routine.isEveryDay &&!routine.getIsEveryWeek &&!routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && cal.get(Calendar.MINUTE) <= routine.getRoutineMinute()&& routine.isEveryDay &&!routine.getIsEveryWeek &&!routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) <= routine.getRoutineMinute()&& routine.isEveryDay &&!routine.getIsEveryWeek &&!routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) >= routine.getRoutineMinute()&& routine.isEveryDay &&!routine.getIsEveryWeek &&!routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay()&& routine.isEveryDay && !routine.getIsEveryWeek && !routine.isEveryMonth ) {
            Log.d("hallo", "System zeit ist kleiner daily");

            cal.set(Calendar.YEAR, myYear);
            cal.set(Calendar.MONTH, routine.getRoutineMonth());
            if (myDay < routine.getRoutineDay() && myMonth > routine.getRoutineMonth() ||myDay < routine.getRoutineDay() && myMonth < routine.getRoutineMonth() || myDay > routine.getRoutineDay() && myMonth == routine.getRoutineMonth() ){
                cal.set(Calendar.DAY_OF_MONTH, myDay);
            } else {
                cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            }
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);
            int currentMonth = cal.get(Calendar.MONTH);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            if (myDay < routine.getRoutineDay() && myMonth > routine.getRoutineMonth() ||myDay < routine.getRoutineDay() && myMonth < routine.getRoutineMonth() || myDay > routine.getRoutineDay() && myMonth == routine.getRoutineMonth() ){
                routine.setRoutineDay(myDay);
                routine.setRoutineWeek(myDay);
                routine.setRoutineMonth(myMonth);
            } else {
                routine.setRoutineDay(routine.getRoutineDay());
                routine.setRoutineWeek(routine.getRoutineDay());
                routine.setRoutineMonth(routine.getRoutineMonth());
            }


            Log.d("hallo", "day = " + routine.getRoutineDay());
            Log.d("hallo", "next = " + routine.getRoutineNext());
            Log.d("hallo", "month = "+ routine.getRoutineMonth());

        }





        //

        // calender kleiner 2 daily

        if (cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth && cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay() || cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth && cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay() || cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth && cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay() || cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth && cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay() || cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.MONTH) < routine.getRoutineMonth() && routine.isEveryDay && !routine.getIsEveryWeek && !routine.isEveryMonth) {
            Log.d("hallo", "System zeit ist kleiner 2 daily");
            cal.set(Calendar.YEAR, myYear);
            cal.set(Calendar.MONTH, routine.getRoutineMonth());
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            routine.setRoutineDay(routine.getRoutineDay());
            routine.setRoutineWeek(routine.getRoutineDay());
            routine.setRoutineMonth(routine.getRoutineMonth());


            Log.d("hallo", "month =" + routine.getRoutineMonth());
            Log.d("hallo", "day = " + routine.getRoutineDay());
        }




        // calender größer daily

        if (cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && cal.get(Calendar.MINUTE) <= routine.getRoutineMinute() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && cal.get(Calendar.MINUTE) >= routine.getRoutineMinute() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth) {
            Log.d("hallo", "System zeit ist größer daily");
            cal.set(Calendar.YEAR, myYear);
            cal.set(Calendar.MONTH, myMonth);
            if (myDay == 29 && myMonth ==1){
                routine.setRoutineDay(1);
                routine.setRoutineWeek(1);
            }

            if (myDay == 28 && myMonth == 1){
                routine.setRoutineDay(29);
                routine.setRoutineWeek(1);
            }
            cal.set(Calendar.DAY_OF_MONTH, myDay + 1);
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);



            if (myDay == 31) {
                routine.setRoutineDay(1);
                routine.setRoutineWeek(2);

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());

            }
            if (myDay == 30) {
                routine.setRoutineDay(31);
                routine.setRoutineWeek(1);

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 29 && myMonth ==1){
                routine.setRoutineDay(1);
                routine.setRoutineWeek(1);
            }

            if (myDay < 30){
                routine.setRoutineDay(myDay +1);
                routine.setRoutineWeek(myDay +1);
            }



            Log.d("hallo", "day = " + routine.getRoutineDay());
            Log.d("hallo", "next = " + routine.getRoutineNext());
            Log.d("hallo", "month = "+ routine.getRoutineMonth());


        }


        //
        int dailyplus0 = routine.getRoutineNext();


        if (cal.get(Calendar.DAY_OF_MONTH) >= dailyplus0 && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) >= dailyplus0 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) >= dailyplus0 && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.MONTH) > routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) >= routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.MONTH) > routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) >= routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.MONTH) > routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) >= routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.MONTH) < routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) <= routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.MONTH) < routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) <= routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.MONTH) < routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) <= routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.MONTH) > routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) < dailyplus0 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && routine.isEveryDay && ! routine.getIsEveryWeek && !routine.isEveryMonth || cal.get(Calendar.MONTH) > routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) < dailyplus0 && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour()  && routine.isEveryDay && ! routine.getIsEveryWeek && !routine.isEveryMonth) {

            Log.d("hallo", "System zeit ist größer daily plus 0 oder noch größer ");
            cal.set(Calendar.YEAR, myYear);
            cal.set(Calendar.MONTH, myMonth);
            if (myDay == 29 && myMonth ==1){
                routine.setRoutineDay(1);
                routine.setRoutineWeek(1);
            }

            if (myDay == 28 && myMonth == 1){
                routine.setRoutineDay(29);
                routine.setRoutineWeek(1);
            }
            cal.set(Calendar.DAY_OF_MONTH, myDay + 1);
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 1;
            if (myDay == 31) {
                routine.setRoutineDay(1);
                routine.setRoutineWeek(2);

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());

            }
            if (myDay == 30) {
                routine.setRoutineDay(31);
                routine.setRoutineWeek(1);

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay < 30) {
                routine.setRoutineDay(myDay + 1);
                routine.setRoutineWeek(myDay + 1);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

        }

        // calder month größer

        if (cal.get(Calendar.DAY_OF_MONTH) == dailyplus0 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == dailyplus0 && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) <= routine.getRoutineMinute() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == dailyplus0 && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) >= routine.getRoutineMinute() && !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) < dailyplus0 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && routine.isEveryDay &&!routine.getIsEveryWeek && !routine.isEveryMonth ||cal.get(Calendar.DAY_OF_MONTH) < dailyplus0 && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour()&& !routine.getIsEveryWeek && routine.isEveryDay && !routine.isEveryMonth ||cal.get(Calendar.DAY_OF_MONTH) > dailyplus0 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute()&& routine.isEveryDay &&!routine.getIsEveryWeek &&!routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) > dailyplus0 && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && cal.get(Calendar.MINUTE) <= routine.getRoutineMinute()&& routine.isEveryDay &&!routine.getIsEveryWeek &&!routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) > dailyplus0 && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) <= routine.getRoutineMinute()&& routine.isEveryDay &&!routine.getIsEveryWeek &&!routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) > dailyplus0 && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) >= routine.getRoutineMinute()&& routine.isEveryDay &&!routine.getIsEveryWeek &&!routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) < dailyplus0 && routine.isEveryDay && !routine.getIsEveryWeek && !routine.isEveryMonth){

            Log.d("hallo", "System zeit ist kleiner daily plus 0 oder noch größer ");
            cal.set(Calendar.YEAR, myYear);
            cal.set(Calendar.MONTH, myMonth);

            cal.set(Calendar.DAY_OF_MONTH, myDay);
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            if (myDay == 31) {
                routine.setRoutineDay(31);
                routine.setRoutineWeek(31);

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());

            }
            if (myDay == 30) {
                routine.setRoutineDay(30);
                routine.setRoutineWeek(30);

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay < 30) {
                routine.setRoutineDay(myDay);
                routine.setRoutineWeek(myDay);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }


        }

        // calender weekly system zeit kleiner
        if (cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) <= routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) >= routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && !routine.isEveryDay && routine.getIsEveryWeek && !routine.isEveryMonth ||cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour()&& routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth ||cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute()&& !routine.isEveryDay && routine.getIsEveryWeek &&!routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && cal.get(Calendar.MINUTE) <= routine.getRoutineMinute()&& !routine.isEveryDay && routine.getIsEveryWeek &&!routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) <= routine.getRoutineMinute()&& !routine.isEveryDay && routine.getIsEveryWeek &&!routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) >= routine.getRoutineMinute()&& !routine.isEveryDay && routine.getIsEveryWeek &&!routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay()&& !routine.isEveryDay && routine.getIsEveryWeek && !routine.isEveryMonth ) {
            Log.d("hallo", "System zeit ist kleiner weekly");
            cal.set(Calendar.YEAR, myYear);
            cal.set(Calendar.MONTH, myMonth);
            if (myDay < routine.getRoutineDay() && myMonth > routine.getRoutineMonth() ||myDay < routine.getRoutineDay() && myMonth < routine.getRoutineMonth() || myDay > routine.getRoutineDay() && myMonth == routine.getRoutineMonth()  ){
                cal.set(Calendar.DAY_OF_MONTH, myDay);
            } else {
                cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            }
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);
            int currentMonth = cal.get(Calendar.MONTH);

            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 7;

            if (taskbiggerThanMonth >= 24) {
                routine.setRoutineDay(myDay);
                routine.setRoutineWeek(myDay);
                routine.setRoutineMonth(myMonth);
            } else {
                routine.setRoutineWeek(routine.getRoutineDay());
                routine.setRoutineDay(routine.getRoutineDay());
                routine.setRoutineMonth(routine.getRoutineMonth());
            }

            if (myDay < routine.getRoutineDay() && myMonth > routine.getRoutineMonth() ||myDay < routine.getRoutineDay() && myMonth < routine.getRoutineMonth() || myDay > routine.getRoutineDay() && myMonth == routine.getRoutineMonth()  ){
                routine.setRoutineDay(myDay);
                routine.setRoutineWeek(myDay);
                routine.setRoutineMonth(myMonth);
            } else {
                routine.setRoutineDay(routine.getRoutineDay());
                routine.setRoutineWeek(routine.getRoutineDay());
                routine.setRoutineMonth(routine.getRoutineMonth());
            }




            Log.d("hallo", "day = " + routine.getRoutineDay());
            Log.d("hallo", "next = " + routine.getRoutineNext());
            Log.d("hallo", "month = "+ routine.getRoutineMonth());
        }

        //
        // calender kleiner 2 weekly

        if (cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth && cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineNext() || cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth && cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineNext() || cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth && cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineNext() || cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth && cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineNext() || cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && cal.get(Calendar.MONTH) < routine.getRoutineMonth() && !routine.isEveryDay && routine.getIsEveryWeek && !routine.isEveryMonth) {
            Log.d("hallo", "System zeit  2 weekly");
            cal.set(Calendar.YEAR, myYear);
            cal.set(Calendar.MONTH, routine.getRoutineMonth());
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay() + 7);
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            routine.setRoutineWeek(routine.getRoutineNext() + 7);
            routine.setRoutineDay(routine.getRoutineDay() + 7);
            routine.setRoutineMonth( routine.getRoutineMonth());

            Log.d("hallo", "next = " + routine.getRoutineNext());
            Log.d("hallo", "month =" + routine.getRoutineMonth());
            Log.d("hallo", "day = " + routine.getRoutineDay());
        }


        if (cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus0 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus0 && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && cal.get(Calendar.MINUTE) <= routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus0 && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && cal.get(Calendar.MINUTE) >= routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth) {
            Log.d("hallo", "System zeit ist größer und weekly plus 0 ist beides zusammen");
            cal.set(Calendar.YEAR, myYear);
            cal.set(Calendar.MONTH, myMonth);
            cal.set(Calendar.DAY_OF_MONTH, myDay + 7);
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 7;
            int currentMonth = cal.get(Calendar.MONTH) - 1;



            if (currentMonth == Calendar.FEBRUARY && myDay == 24) {
                routine.setRoutineDay(2);
                routine.setRoutineWeek(3);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 24) {
                routine.setRoutineDay(31);
                routine.setRoutineWeek(1);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 25) {
                routine.setRoutineDay(1);
                routine.setRoutineWeek(2);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (currentMonth == Calendar.FEBRUARY && myDay == 25) {
                routine.setRoutineDay(3);
                routine.setRoutineWeek(4);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }


            if (myDay == 26) {
                routine.setRoutineDay(2);
                routine.setRoutineWeek(3);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (currentMonth == Calendar.FEBRUARY && myDay == 26) {
                routine.setRoutineDay(4);
                routine.setRoutineWeek(5);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 27) {
                routine.setRoutineDay(3);
                routine.setRoutineWeek(4);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (currentMonth == Calendar.FEBRUARY && myDay == 27) {
                routine.setRoutineDay(5);
                routine.setRoutineWeek(6);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }


            if (myDay == 28) {
                routine.setRoutineDay(4);
                routine.setRoutineWeek(5);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (currentMonth == Calendar.FEBRUARY && myDay == 28) {
                routine.setRoutineDay(6);
                routine.setRoutineWeek(7);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (currentMonth == Calendar.FEBRUARY && myDay == 29) {
                routine.setRoutineDay(7);
                routine.setRoutineWeek(7);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 29) {
                routine.setRoutineDay(5);
                routine.setRoutineWeek(6);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }


            if (myDay == 30) {
                routine.setRoutineDay(6);
                routine.setRoutineWeek(7);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 31) {
                routine.setRoutineDay(6);
                routine.setRoutineWeek(7);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (taskbiggerThanMonth < 24 || myDay < 24) {
                routine.setRoutineDay(myDay + 7);
                routine.setRoutineWeek(myDay + 7);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());

            }



        }


        if (cal.get(Calendar.DAY_OF_MONTH) >= weeklyPlus0 && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) >= weeklyPlus0 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) >= weeklyPlus0 && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.MONTH) < routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) <= routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.MONTH) > routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) < weeklyPlus0 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && !routine.isEveryDay &&  routine.getIsEveryWeek && !routine.isEveryMonth || cal.get(Calendar.MONTH) > routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) < weeklyPlus0 && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour()  && !routine.isEveryDay &&  routine.getIsEveryWeek && !routine.isEveryMonth) {

            Log.d("hallo", "System zeit ist kleiner weekly plus 0 oder noch größer ");
            cal.set(Calendar.YEAR, myYear);
            cal.set(Calendar.MONTH, myMonth);

            cal.set(Calendar.DAY_OF_MONTH, myDay + 7);
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            if (myDay == 31) {
                routine.setRoutineDay(31);
                routine.setRoutineWeek(31);

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());

            }
            if (myDay == 30) {
                routine.setRoutineDay(30);
                routine.setRoutineWeek(30);

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay < 30) {
                routine.setRoutineDay(routine.getRoutineDay());
                routine.setRoutineWeek(routine.getRoutineDay());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }


        }



        // calnder 1größer wie nextweek weekly

        if (cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus1 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) <= routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus1 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus1 && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus1 && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth) {
            Log.d("hallo", "System zeit ist größer next plus 1 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, routine.getRoutineMonth());
            if (myDay == 1){
                cal.set(Calendar.DAY_OF_MONTH, myDay + 6);
            } else if (myDay == 2){
                cal.set(Calendar.DAY_OF_MONTH, myDay + 5);
            } else if (myDay == 3){
                cal.set(Calendar.DAY_OF_MONTH, myDay + 4);
            } else if (myDay == 4){
                cal.set(Calendar.DAY_OF_MONTH, myDay + 3);
            } else if (myDay == 5){
                cal.set(Calendar.DAY_OF_MONTH, myDay + 2);
            } else if (myDay == 6){
                cal.set(Calendar.DAY_OF_MONTH, myDay + 1);
            } else if (myDay == 7){
                cal.set(Calendar.DAY_OF_MONTH, myDay);
            }
            else {
                cal.set(Calendar.DAY_OF_MONTH, myDay + 6);
            }

            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 7;
            int currentMonth = cal.get(Calendar.MONTH) - 1;

            if (myDay == 1){
                routine.setRoutineDay(7);
                routine.setRoutineWeek(7);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 2){
                routine.setRoutineDay(7);
                routine.setRoutineWeek(7);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 3){
                routine.setRoutineDay(7);
                routine.setRoutineWeek(7);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 4){
                routine.setRoutineDay(7);
                routine.setRoutineWeek(7);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 5){
                routine.setRoutineDay(7);
                routine.setRoutineWeek(7);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 6){
                routine.setRoutineDay(7);
                routine.setRoutineWeek(7);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 7){
                routine.setRoutineDay(7);
                routine.setRoutineWeek(7);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }







            if (myDay == 24) {
                routine.setRoutineDay(30);
                routine.setRoutineWeek(29);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }


            if (currentMonth == Calendar.FEBRUARY && myDay == 24) {
                routine.setRoutineDay(1);
                routine.setRoutineWeek(2);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 25) {
                routine.setRoutineDay(31);
                routine.setRoutineWeek(30);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (currentMonth == Calendar.FEBRUARY && myDay == 25) {
                routine.setRoutineDay(2);
                routine.setRoutineWeek(3);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }


            if (myDay == 26) {
                routine.setRoutineDay(1);
                routine.setRoutineWeek(2);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (currentMonth == Calendar.FEBRUARY && myDay == 26) {
                routine.setRoutineDay(3);
                routine.setRoutineWeek(4);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }


            if (myDay == 27) {
                routine.setRoutineDay(2);
                routine.setRoutineWeek(3);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (currentMonth == Calendar.FEBRUARY && myDay == 27) {
                routine.setRoutineDay(4);
                routine.setRoutineWeek(5);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 28) {
                routine.setRoutineDay(3);
                routine.setRoutineWeek(4);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (currentMonth == Calendar.FEBRUARY && myDay == 28) {
                routine.setRoutineDay(5);
                routine.setRoutineWeek(6);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 29) {
                routine.setRoutineDay(4);
                routine.setRoutineWeek(5);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (currentMonth == Calendar.FEBRUARY && myDay == 29) {
                routine.setRoutineDay(5);
                routine.setRoutineWeek(5);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 30) {
                routine.setRoutineDay(5);
                routine.setRoutineWeek(6);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 31) {
                routine.setRoutineDay(6);
                routine.setRoutineWeek(7);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (taskbiggerThanMonth < 24 || myDay < 24) {
                routine.setRoutineDay(myDay + 6);
                routine.setRoutineWeek(myDay + 6);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());

            }
        }


        if (cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus2 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) <= routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus2 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus2 && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus2 && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth ) {
            Log.d("hallo", "System zeit ist größer next plus 2 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, routine.getRoutineMonth());
            cal.set(Calendar.DAY_OF_MONTH, myDay + 5);
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 7;
            int currentMonth = cal.get(Calendar.MONTH) - 1;

            if (myDay == 24) {
                routine.setRoutineDay(29);
                routine.setRoutineWeek(29);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (currentMonth == Calendar.FEBRUARY && myDay == 24) {
                routine.setRoutineDay(29);
                routine.setRoutineWeek(1);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 25) {
                routine.setRoutineDay(30);
                routine.setRoutineWeek(30);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (currentMonth == Calendar.FEBRUARY && myDay == 25) {
                routine.setRoutineDay(1);
                routine.setRoutineWeek(2);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 26) {
                routine.setRoutineDay(31);
                routine.setRoutineWeek(1);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (currentMonth == Calendar.FEBRUARY && myDay == 26) {
                routine.setRoutineDay(2);
                routine.setRoutineWeek(3);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 27) {
                routine.setRoutineDay(1);
                routine.setRoutineWeek(2);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (currentMonth == Calendar.FEBRUARY && myDay == 27) {
                routine.setRoutineDay(3);
                routine.setRoutineWeek(4);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 28) {
                routine.setRoutineDay(2);
                routine.setRoutineWeek(3);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (currentMonth == Calendar.FEBRUARY && myDay == 28) {
                routine.setRoutineDay(4);
                routine.setRoutineWeek(5);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (currentMonth == Calendar.FEBRUARY && myDay == 29) {
                routine.setRoutineDay(5);
                routine.setRoutineWeek(5);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 29) {
                routine.setRoutineDay(3);
                routine.setRoutineWeek(4);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 30) {
                routine.setRoutineDay(4);
                routine.setRoutineWeek(5);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 31) {
                routine.setRoutineDay(5);
                routine.setRoutineWeek(6);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (taskbiggerThanMonth < 24 || myDay < 24) {
                routine.setRoutineDay(myDay + 5);
                routine.setRoutineWeek(myDay + 5);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());

            }
        }


        if (cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus3 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) <= routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus3 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus3 && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus3 && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth) {
            Log.d("hallo", "System zeit ist größer next plus 3 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, routine.getRoutineMonth());
            cal.set(Calendar.DAY_OF_MONTH, myDay + 4);
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 7;
            int currentMonth = cal.get(Calendar.MONTH) - 1;

            if (myDay == 24) {
                routine.setRoutineDay(28);
                routine.setRoutineWeek(28);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }


            if (myDay == 25) {
                routine.setRoutineDay(29);
                routine.setRoutineWeek(29);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (currentMonth == Calendar.FEBRUARY && myDay == 25) {
                routine.setRoutineDay(29);
                routine.setRoutineWeek(1);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 26) {
                routine.setRoutineDay(30);
                routine.setRoutineWeek(30);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (currentMonth == Calendar.FEBRUARY && myDay == 26) {
                routine.setRoutineDay(1);
                routine.setRoutineWeek(2);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 27) {
                routine.setRoutineDay(31);
                routine.setRoutineWeek(1);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (currentMonth == Calendar.FEBRUARY && myDay == 27) {
                routine.setRoutineDay(2);
                routine.setRoutineWeek(3);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 28) {
                routine.setRoutineDay(1);
                routine.setRoutineWeek(2);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (currentMonth == Calendar.FEBRUARY && myDay == 28) {
                routine.setRoutineDay(3);
                routine.setRoutineWeek(4);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 29) {
                routine.setRoutineDay(2);
                routine.setRoutineWeek(3);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 30) {
                routine.setRoutineDay(3);
                routine.setRoutineWeek(4);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 31) {
                routine.setRoutineDay(4);
                routine.setRoutineWeek(5);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (taskbiggerThanMonth < 24 || myDay < 24) {
                routine.setRoutineDay(myDay + 4);
                routine.setRoutineWeek(myDay + 4);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());

            }
        }


        if (cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus4 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) <= routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus4 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus4 && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus4 && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth) {
            Log.d("hallo", "System zeit ist größer next plus 4 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, routine.getRoutineMonth());
            cal.set(Calendar.DAY_OF_MONTH, myDay + 3);
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 7;
            int currentMonth = cal.get(Calendar.MONTH) - 1;

            if (myDay == 24) {
                routine.setRoutineDay(27);
                routine.setRoutineWeek(27);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 25) {
                routine.setRoutineDay(28);
                routine.setRoutineWeek(28);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 26) {
                routine.setRoutineDay(29);
                routine.setRoutineWeek(29);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (currentMonth == Calendar.FEBRUARY && myDay == 26) {
                routine.setRoutineDay(29);
                routine.setRoutineWeek(1);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 27) {
                routine.setRoutineDay(30);
                routine.setRoutineWeek(30);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (currentMonth == Calendar.FEBRUARY && myDay == 27) {
                routine.setRoutineDay(1);
                routine.setRoutineWeek(2);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 28) {
                routine.setRoutineDay(31);
                routine.setRoutineWeek(1);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (currentMonth == Calendar.FEBRUARY && myDay == 28) {
                routine.setRoutineDay(2);
                routine.setRoutineWeek(3);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 29) {
                routine.setRoutineDay(1);
                routine.setRoutineWeek(2);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 30) {
                routine.setRoutineDay(2);
                routine.setRoutineWeek(3);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 31) {
                routine.setRoutineDay(3);
                routine.setRoutineWeek(4);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (taskbiggerThanMonth < 24 || myDay < 24) {
                routine.setRoutineDay(myDay + 3);
                routine.setRoutineWeek(myDay + 3);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());

            }


        }

        if (cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus5 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) <= routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus5 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus5 && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus5 && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth) {
            Log.d("hallo", "System zeit ist größer next plus 5 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, routine.getRoutineMonth());
            cal.set(Calendar.DAY_OF_MONTH, myDay + 2);
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 7;
            int currentMonth = cal.get(Calendar.MONTH) - 1;

            if (myDay == 24) {
                routine.setRoutineDay(26);
                routine.setRoutineWeek(26);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 25) {
                routine.setRoutineDay(27);
                routine.setRoutineWeek(27);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 26) {
                routine.setRoutineDay(28);
                routine.setRoutineWeek(28);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 27) {
                routine.setRoutineDay(29);
                routine.setRoutineWeek(29);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (currentMonth == Calendar.FEBRUARY && myDay == 27) {
                routine.setRoutineDay(29);
                routine.setRoutineWeek(1);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 28) {
                routine.setRoutineDay(30);
                routine.setRoutineWeek(30);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (currentMonth == Calendar.FEBRUARY && myDay == 28) {
                routine.setRoutineDay(1);
                routine.setRoutineWeek(2);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 29) {
                routine.setRoutineDay(31);
                routine.setRoutineWeek(1);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 30) {
                routine.setRoutineDay(1);
                routine.setRoutineWeek(2);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 31) {
                routine.setRoutineDay(2);
                routine.setRoutineWeek(3);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (taskbiggerThanMonth < 24 || myDay < 24) {
                routine.setRoutineDay(myDay + 2);
                routine.setRoutineWeek(myDay + 2);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());

            }
        }


        if (cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus6 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) <= routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus6 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus6 && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth || cal.get(Calendar.DAY_OF_MONTH) == weeklyPlus6 && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && routine.getIsEveryWeek && !routine.isEveryDay && !routine.isEveryMonth) {
            Log.d("hallo", "System zeit ist größer next plus 6 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, routine.getRoutineMonth());
            cal.set(Calendar.DAY_OF_MONTH, myDay + 1);
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 7;
            int currentMonth = cal.get(Calendar.MONTH) - 1;

            if (myDay == 24) {
                routine.setRoutineDay(25);
                routine.setRoutineWeek(25);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 25) {
                routine.setRoutineDay(26);
                routine.setRoutineWeek(26);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 26) {
                routine.setRoutineDay(27);
                routine.setRoutineWeek(27);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (myDay == 27) {
                routine.setRoutineDay(28);
                routine.setRoutineWeek(28);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 28) {
                routine.setRoutineDay(29);
                routine.setRoutineWeek(29);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (currentMonth == Calendar.FEBRUARY && myDay == 28) {
                routine.setRoutineDay(29);
                routine.setRoutineWeek(1);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 29) {
                routine.setRoutineDay(30);
                routine.setRoutineWeek(30);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 30) {
                routine.setRoutineDay(31);
                routine.setRoutineWeek(1);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }
            if (myDay == 31) {
                routine.setRoutineDay(1);
                routine.setRoutineWeek(2);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
            }

            if (taskbiggerThanMonth < 24 || myDay < 24) {
                routine.setRoutineDay(myDay + 1);
                routine.setRoutineWeek(myDay + 1);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());

            }
        }

        //
        int currentMonth = cal.get(Calendar.MONTH);
        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && currentMonth == Calendar.JANUARY || currentMonth == Calendar.MARCH && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.HOUR_OF_DAY) >= routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() || currentMonth == Calendar.MAY && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.HOUR_OF_DAY) >= routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() || currentMonth == Calendar.JULY && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.HOUR_OF_DAY) >= routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() || currentMonth == Calendar.AUGUST && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.HOUR_OF_DAY) >= routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && !routine.getIsEveryWeek && !routine.isEveryDay && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || currentMonth == Calendar.DECEMBER && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.HOUR_OF_DAY) >= routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() || currentMonth == Calendar.MARCH && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.HOUR_OF_DAY) >= routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() || currentMonth == Calendar.MAY && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.HOUR_OF_DAY) >= routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && !routine.getIsEveryWeek && !routine.isEveryDay && routine.isEveryMonth && currentMonth == Calendar.JULY || currentMonth == Calendar.AUGUST && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() || currentMonth == Calendar.OCTOBER && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.HOUR_OF_DAY) >= routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() || currentMonth == Calendar.DECEMBER && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.HOUR_OF_DAY) >= routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay()) {
            Log.d("hallo", "System zeit ist größer monthy 31");
            cal.set(Calendar.YEAR, myYear);
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, myDay);
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {
                routine.setRoutineDay(routine.getRoutineDay());
                routine.setRoutineWeek(0);
                routine.setRoutineWeek(myDay);
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "monthy " + routine.getRoutineMonth());
            } else {
                routine.setRoutineWeek(myDay + 31);
                routine.setRoutineDay(myDay + 31);
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "monthy " + routine.getRoutineMonth());
            }

            int nextmonth = myMonth + 1;

            if (routine.getRoutineDay() >= 30 && monthplus1 == 31) {
                routine.setRoutineDay(routine.getRoutineDay());
                routine.setRoutineWeek(0);
                routine.setRoutineWeek(myDay);

                monthplus1 = routine.getRoutineNext();
                Log.d("hallo", "tag = " + monthplus1);
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());

            }


            if (nextmonth == Calendar.APRIL && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && routine.getRoutineDay() >= 30 || nextmonth == Calendar.JUNE && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && routine.getRoutineDay() >= 30 || nextmonth == Calendar.SEPTEMBER && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && routine.getRoutineDay() >= 30 || nextmonth == Calendar.NOVEMBER && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && routine.getRoutineDay() >= 30) {

                routine.setRoutineWeek(1);
                routine.setRoutineDay(routine.getRoutineDay());

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "monthy " + routine.getRoutineMonth());

                Log.d("hallo", "tag ist größer 30");


            } else {
                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineDay(routine.getRoutineDay());
            }


        }


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && currentMonth == Calendar.APRIL || currentMonth == Calendar.JUNE && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.HOUR_OF_DAY) >= routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() || currentMonth == Calendar.SEPTEMBER && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.HOUR_OF_DAY) >= routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() || currentMonth == Calendar.NOVEMBER && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.HOUR_OF_DAY) >= routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() || currentMonth == Calendar.NOVEMBER && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.HOUR_OF_DAY) >= routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && !routine.getIsEveryWeek && !routine.isEveryDay && routine.isEveryMonth && currentMonth == Calendar.APRIL || currentMonth == Calendar.JUNE && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.HOUR_OF_DAY) >= routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() || currentMonth == Calendar.SEPTEMBER && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.HOUR_OF_DAY) >= routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() || currentMonth == Calendar.NOVEMBER && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.HOUR_OF_DAY) >= routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && !routine.getIsEveryWeek && !routine.isEveryDay && routine.isEveryMonth && currentMonth == Calendar.APRIL || currentMonth == Calendar.JUNE && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() || currentMonth == Calendar.SEPTEMBER && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.HOUR_OF_DAY) >= routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() || currentMonth == Calendar.NOVEMBER && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.HOUR_OF_DAY) >= routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay()) {
            Log.d("hallo", "System zeit ist größer monthy 30");
            cal.set(Calendar.YEAR, myYear);
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, myDay);
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 30;

            if (taskbiggerThanMonth >= 24) {
                routine.setRoutineDay(routine.getRoutineDay());
                routine.setRoutineWeek(0);
                routine.setRoutineWeek(myDay);
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "monthy " + routine.getRoutineMonth());
            } else {
                routine.setRoutineWeek(myDay + 30);
                routine.setRoutineDay(myDay + 30);
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "monthy " + routine.getRoutineMonth());

            }


        }


        if (cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && routine.isEveryMonth && !routine.isEveryDay && !routine.getIsEveryWeek && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && !routine.getIsEveryWeek && !routine.isEveryDay && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && !routine.getIsEveryWeek && !routine.isEveryDay && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY) {
            Log.d("hallo", "System zeit ist größer monthy 28");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, myDay);
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 28;
            if (taskbiggerThanMonth >= 24) {
                routine.setRoutineDay(routine.getRoutineDay());
                routine.setRoutineWeek(0);
                routine.setRoutineWeek(myDay);
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "monthy " + routine.getRoutineMonth());
            } else {
                routine.setRoutineWeek(myDay + 30);
                routine.setRoutineDay(myDay + 30);
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "monthy " + routine.getRoutineMonth());

            }

        }


        // calender monthly system zeit kleiner
        if (cal.get(Calendar.MONTH) == routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth || cal.get(Calendar.MONTH) < routine.getRoutineMonth() && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth || cal.get(Calendar.MONTH) == routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay() && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth ||cal.get(Calendar.DAY_OF_MONTH) < routine.getRoutineDay() && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && !routine.getIsEveryWeek && !routine.isEveryDay && routine.isEveryMonth ||cal.get(Calendar.DAY_OF_MONTH) > routine.getRoutineDay() && !routine.isEveryDay &&!routine.getIsEveryWeek && routine.isEveryMonth  ) {
            Log.d("hallo", "System zeit ist kleiner monthly");
            cal.set(Calendar.YEAR, myYear);
            cal.set(Calendar.MONTH, routine.getRoutineMonth());
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);


            if (myMonth == Calendar.JANUARY || myMonth == Calendar.MARCH || myMonth == Calendar.MAY || myMonth == Calendar.JULY || myMonth == Calendar.AUGUST || myMonth == Calendar.DECEMBER) {
                taskbiggerThanMonth = routine.getRoutineDay() + 31;
            } else if (myMonth == Calendar.APRIL || myMonth == Calendar.JUNE || myMonth == Calendar.SEPTEMBER || myMonth == Calendar.NOVEMBER) {
                taskbiggerThanMonth = routine.getRoutineDay() + 30;
            } else if (myMonth == Calendar.FEBRUARY) {
                taskbiggerThanMonth = routine.getRoutineDay() + 28;
            }

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());
                routine.setRoutineWeek(routine.getRoutineDay());
            } else {
                routine.setRoutineWeek(myDay);
                routine.setRoutineDay(myDay);
                routine.setRoutineMonth(myMonth);
            }

            if (routine.getRoutineMonth() > 11) {
                routine.setRoutineMonth(0);
            }

            Log.d("hallo", "day = " + routine.getRoutineDay());
            Log.d("hallo", "next = " + routine.getRoutineNext());
            Log.d("hallo", "monthly " + routine.getRoutineMonth());
        }


        //
        int monthnext0 = routine.getRoutineNext();

        if (cal.get(Calendar.MONTH) == routine.getRoutineMonth()  &&cal.get(Calendar.DAY_OF_MONTH) == monthnext0 && cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && !routine.getIsEveryWeek && !routine.isEveryDay && routine.isEveryMonth || cal.get(Calendar.MONTH) == routine.getRoutineMonth()  &&cal.get(Calendar.DAY_OF_MONTH) == monthnext0 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && !routine.getIsEveryWeek && !routine.isEveryDay && routine.isEveryMonth || cal.get(Calendar.MONTH) == routine.getRoutineMonth()  &&cal.get(Calendar.DAY_OF_MONTH) == monthnext0&& cal.get(Calendar.HOUR_OF_DAY) < routine.getRoutineHour() && cal.get(Calendar.MINUTE) > routine.getRoutineMinute() && !routine.getIsEveryWeek && !routine.isEveryDay && routine.isEveryMonth || cal.get(Calendar.MONTH) == routine.getRoutineMonth()  &&cal.get(Calendar.DAY_OF_MONTH) == monthnext0 && cal.get(Calendar.HOUR_OF_DAY) > routine.getRoutineHour() && !routine.getIsEveryWeek && !routine.isEveryDay && routine.isEveryMonth || cal.get(Calendar.MONTH) > routine.getRoutineMonth()  &&cal.get(Calendar.DAY_OF_MONTH) < monthnext0 && cal.get(Calendar.HOUR_OF_DAY) == routine.getRoutineHour() && cal.get(Calendar.MINUTE) < routine.getRoutineMinute() && !routine.isEveryDay &&  !routine.getIsEveryWeek && routine.isEveryMonth ) {

            Log.d("hallo", "System zeit ist größer month plus 0 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(monthnext0+ 31);
                routine.setRoutineWeek(myDay + 31);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }


        }

        monthplus1 = routine.getRoutineNext() + 1;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus1 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus1 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus1 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus1 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus1 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus1 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus1 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus1 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus1 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus1 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus1 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus1 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 1 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 30);
                routine.setRoutineWeek(myDay + 30);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }


        }

        monthplus2 = routine.getRoutineNext() + 2;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus2 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus2 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus2 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus2 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus2 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus2 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus2 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus2 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus2 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus2 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus2 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus2 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 2 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 29);
                routine.setRoutineWeek(myDay + 29);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }


        }


        monthplus3 = routine.getRoutineNext() + 3;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus3 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus3 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus3 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus3 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus3 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus3 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus3 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus3 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus3 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus3 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus3 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus3 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 3 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);
            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 28);
                routine.setRoutineWeek(myDay + 28);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }


        }

        monthplus4 = routine.getRoutineNext() + 4;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus4 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus4 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus4 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus4 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus4 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus4 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus4 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus4 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus4 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus4 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus4 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus4 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 4 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 27);
                routine.setRoutineWeek(myDay + 27);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }


        }


        monthplus5 = routine.getRoutineNext() + 5;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus5 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus5 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus5 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus5 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus5 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus5 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus5 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus5 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus5 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus5 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus5 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus5 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 5 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 26);
                routine.setRoutineWeek(myDay + 26);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }

        }

        monthplus6 = routine.getRoutineNext() + 6;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus6 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus6 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus6 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus6 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus6 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus6 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus6 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus6 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus4 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus6 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus6 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus6 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 6 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);
            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay+ 25);
                routine.setRoutineWeek(myDay + 25);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus7 = routine.getRoutineNext() + 7;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus7 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus7 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus7 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus7 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus7 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus7 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus7 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus7 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus7 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus7 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus7 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus7 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 7 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(routine.getRoutineDay() + 24);
                routine.setRoutineWeek(myDay + 24);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus8 = routine.getRoutineNext() + 8;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus8 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus8 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus8 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus8 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus8 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus8 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus8 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus8 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus8 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus8 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus8 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus8 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 8 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 23);
                routine.setRoutineWeek(myDay + 23);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus9 = routine.getRoutineNext() + 9;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus9 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus9 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus9 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus9 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus9 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus9 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus9 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus9 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus9 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus9 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus9 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus9 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 9 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 22);
                routine.setRoutineWeek(myDay + 22);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus10 = routine.getRoutineNext() + 10;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus10 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus10 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus10 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus10 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus10 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus10 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus10 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus10 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus10 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus10 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus10 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus10 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 10 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 21);
                routine.setRoutineWeek(myDay + 21);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus11 = routine.getRoutineNext() + 11;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus11 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus11 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus11 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus11 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus11 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus11 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus11 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus11 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus11 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus11 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus11 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus11 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 11 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 20);
                routine.setRoutineWeek(myDay + 20);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus12 = routine.getRoutineNext() + 12;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus12 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus12 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus12 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus12 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus12 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus12 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus12 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus12 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus12 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus12 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus12 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus10 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 12 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 19);
                routine.setRoutineWeek(myDay + 19);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus13 = routine.getRoutineNext() + 13;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus13 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus13 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus13 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus13 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus13 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus13 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus13 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus13 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus13 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus13 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus13 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus13 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 13 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 18);
                routine.setRoutineWeek(myDay + 18);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }
        monthplus14 = routine.getRoutineNext() + 14;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus14 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus14 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus14 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus14 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus14 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus14 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus14 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus14 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus14 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus14 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus14 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus14 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 14 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 17);
                routine.setRoutineWeek(myDay + 17);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }


        monthplus15 = routine.getRoutineNext() + 15;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus15 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus15 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus15 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus15 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus15 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus15 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus15 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus15 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus15 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus15 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus15 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus15 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 15 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 16);
                routine.setRoutineWeek(myDay + 16);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus16 = routine.getRoutineNext() + 16;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus16 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus16 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus16 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus16 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus16 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus16 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus16 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus16 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus16 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus16 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus16 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus16 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 16 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 15);
                routine.setRoutineWeek(myDay + 15);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus17 = routine.getRoutineNext() + 17;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus17 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus17 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus17 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus17 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus17 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus17 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus17 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus17 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus17 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus17 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus17 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus17 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 17 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);
            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 14);
                routine.setRoutineWeek(myDay + 14);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus18 = routine.getRoutineNext() + 18;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus18 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus18 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus18 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus18 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus18 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus18 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus18 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus18 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus18 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus18 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus18 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus18 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 18 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay+ 13);
                routine.setRoutineWeek(myDay + 13);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus19 = routine.getRoutineNext() + 19;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus19 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus19 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus19 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus19 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus19 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus19 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus19 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus19 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus19 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus19 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus19 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus19 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 19 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 12);
                routine.setRoutineWeek(myDay + 12);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus20 = routine.getRoutineNext() + 20;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus20 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus20 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus20 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus20 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus20 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus20 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus20 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus20 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus20 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus20 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus20 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus20 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 20 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay+ 11);
                routine.setRoutineWeek(myDay + 11);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus21 = routine.getRoutineNext() + 21;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus21 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus21 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus21 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus21 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus21 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus21 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus21 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus21 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus21 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus21 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus21 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus21 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 21 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 10);
                routine.setRoutineWeek(myDay + 10);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus22 = routine.getRoutineNext() + 22;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus22 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus22 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus22 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus22 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus22 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus22 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus22 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus22 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus22 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus22 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus22 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus22 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 22 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 9);
                routine.setRoutineWeek(myDay + 9);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus23 = routine.getRoutineNext() + 23;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus23 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus23 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus23 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus23 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus23 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus23 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus23 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus23 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus23 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus23 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus23 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus23 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 23 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 8);
                routine.setRoutineWeek(myDay + 8);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus24 = routine.getRoutineNext() + 24;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus24 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus24 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus24 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus24 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus24 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus24 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus24 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus24 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus24 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus24 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus24 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus24 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 24 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 7);
                routine.setRoutineWeek(myDay + 7);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus25 = routine.getRoutineNext() + 25;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus25 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus25 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus25 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus25 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus25 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus25 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus25 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus25 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus25 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus25 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus25 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus25 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 25 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 6);
                routine.setRoutineWeek(myDay + 6);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus26 = routine.getRoutineNext() + 26;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus26 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus26 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus26 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus26 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus26 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus26 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus26 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus26 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus26 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus26 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus26 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus26 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 26 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 5);
                routine.setRoutineWeek(myDay + 5);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus27 = routine.getRoutineNext() + 27;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus27 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus27 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus27 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus27 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus27 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus27 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus27 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus27 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus27 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus27 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus27 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus27 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 27 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 4);
                routine.setRoutineWeek(myDay + 4);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus28 = routine.getRoutineNext() + 28;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus28 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus28 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus28 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus28 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus28 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus28 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus28 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus28 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus28 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus28 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus28 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus28 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 28 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 3);
                routine.setRoutineWeek(myDay + 3);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus29 = routine.getRoutineNext() + 29;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus29 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus29 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus29 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus29 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus29 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus29 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus29 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus29 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus29 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus29 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus29 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus29 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 29 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 2);
                routine.setRoutineWeek(myDay + 2);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        monthplus30 = routine.getRoutineNext() + 30;


        if (cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus30 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JANUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus30 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.FEBRUARY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus30 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MARCH || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus30 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.APRIL || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus30 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.MAY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus30 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JUNE || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus30 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.JULY || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus30 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.AUGUST || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus30 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.SEPTEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus30 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.OCTOBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus30 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.NOVEMBER || cal.get(Calendar.MONTH) >= routine.getRoutineMonth() && cal.get(Calendar.DAY_OF_MONTH) == monthplus30 && !routine.isEveryDay && !routine.getIsEveryWeek && routine.isEveryMonth && currentMonth == Calendar.DECEMBER) {

            Log.d("hallo", "System zeit ist größer month plus 30 ");
            cal.set(Calendar.YEAR, routine.getRoutineYear());
            cal.set(Calendar.MONTH, myMonth + 1);
            cal.set(Calendar.DAY_OF_MONTH, routine.getRoutineDay());
            cal.set(Calendar.HOUR_OF_DAY, routine.getRoutineHour());
            cal.set(Calendar.MINUTE, routine.getRoutineMinute());
            cal.set(Calendar.SECOND, 000);
            cal.set(Calendar.MILLISECOND, 000);

            routine.setRoutineMills(cal.getTimeInMillis());
            cal.setTimeInMillis(routine.getRoutineMills());
            long mills = cal.getTimeInMillis();
            routine.setRoutineMills(mills);

            taskbiggerThanMonth = routine.getRoutineDay() + 31;

            if (taskbiggerThanMonth >= 24) {

                routine.setRoutineDay(routine.getRoutineDay());

                routine.setRoutineWeek(routine.getRoutineNext());
                routine.setRoutineMonth(myMonth + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }

                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "Month " + routine.getRoutineMonth());

            } else {

                routine.setRoutineDay(myDay + 1);
                routine.setRoutineWeek(myDay + 1);
                if (routine.getRoutineMonth() > 11) {
                    routine.setRoutineMonth(0);
                }
                Log.d("hallo", "next = " + routine.getRoutineNext());
                Log.d("hallo", "day = " + routine.getRoutineDay());
                Log.d("hallo", "Month " + routine.getRoutineMonth());
            }
        }

        randomReqestCode = routine.rendemReqestCodeint + 79879;
        routineManager.saveRoutineList();

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, AlertReceiver.class);
        intent.putExtra("routineGetName", routine.getRoutineName());
        intent.putExtra("routineGetIsNoVibration", routine.getIsVibrationNo());
        intent.putExtra("routineGetIsShortVibration", routine.getIsVibrationShort());
        intent.putExtra("routineGetIsMediumVibration", routine.getIsVibrationMedium());
        intent.putExtra("routineGetIsLongVibration", routine.getIsVibrationLong());
        intent.putExtra("randemAlarmReqest", randomReqestCode);
        intent.putExtra("routineisEveryDay", routine.getIsEveryDay());
        intent.putExtra("routine", routine);
        intent.putExtra("myYear", myYear);
        intent.putExtra("myMinute", myMinute);
        intent.putExtra("myDay", myDay);
        intent.putExtra("myHour", myHour);
        intent.putExtra("myMonth", myMonth);
        intent.putExtra("routineAlarmDate", taskAlarmDate);



        if (!DateFormat.is24HourFormat(context) && !routine.isEveryDay && !routine.isEveryMonth && !routine.getIsEveryWeek) {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm yyyy");
            taskAlarmDate = format.format(cal.getTime());

            Log.d("t", "test ist aus" + taskAlarmDate.toString());
        } else if (!Locale.getDefault().getISO3Language().equals("de") && !routine.isEveryDay && !routine.isEveryMonth && !routine.getIsEveryWeek) {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm yyyy");
            taskAlarmDate = format.format(cal.getTime());
            Log.d("t", "test ist aus" + taskAlarmDate.toString());
        }

        if (DateFormat.is24HourFormat(context) && !routine.isEveryDay && !routine.isEveryMonth && !routine.getIsEveryWeek) {
            SimpleDateFormat format = new SimpleDateFormat("EEE dd MMM HH:mm yyyy");
            taskAlarmDate = format.format(cal.getTime());
            Log.d("t", "test ist aus" + taskAlarmDate.toString());
        }

        if (!DateFormat.is24HourFormat(context) && routine.isEveryDay) {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm yyyy");
            taskAlarmDate = format.format(cal.getTime()) + ", " + daily;
            Log.d("t", "test ist daily" + taskAlarmDate.toString());
        } else if (!Locale.getDefault().getISO3Language().equals("de") && routine.isEveryDay) {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm yyyy");
            taskAlarmDate = format.format(cal.getTime());
            Log.d("t", "test ist daily" + taskAlarmDate.toString());
        }

        if (DateFormat.is24HourFormat(context) && routine.isEveryDay) {
            SimpleDateFormat format = new SimpleDateFormat("EEE dd MMM  HH:mm yyyy");
            taskAlarmDate = format.format(cal.getTime()) + ", " + daily;
            Log.d("t", "test ist daily" + taskAlarmDate.toString());
        }

        if (!DateFormat.is24HourFormat(context) && routine.isEveryMonth) {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm yyyy");
            taskAlarmDate = format.format(cal.getTime()) + ", " + monthly;
            Log.d("t", "test ist montly" + taskAlarmDate.toString());
        } else if (!Locale.getDefault().getISO3Language().equals("de") && routine.isEveryMonth) {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm yyyy");
            taskAlarmDate = format.format(cal.getTime());
            Log.d("t", "test ist mothly" + taskAlarmDate.toString());
        }
        if (DateFormat.is24HourFormat(context) && routine.isEveryMonth) {
            SimpleDateFormat format = new SimpleDateFormat("EEE dd MMM  HH:mm yyyy");
            taskAlarmDate = format.format(cal.getTime()) + ", " + monthly;
            Log.d("t", "test ist montly" + taskAlarmDate.toString());
        }

        if (!DateFormat.is24HourFormat(context) && routine.getIsEveryWeek) {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm yyyy");
            taskAlarmDate = format.format(cal.getTime()) + ", " + weekly;
            Log.d("t", "test ist weekly" + taskAlarmDate.toString());
        } else if (!Locale.getDefault().getISO3Language().equals("de") && routine.getIsEveryWeek) {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm yyyy");
            taskAlarmDate = format.format(cal.getTime());
            Log.d("t", "test ist weekly"+ taskAlarmDate.toString());
        }
        if (DateFormat.is24HourFormat(context) && routine.getIsEveryWeek) {
            SimpleDateFormat format = new SimpleDateFormat("EEE dd MMM HH:mm yyyy");
            taskAlarmDate = format.format(cal.getTime()) + ", " + weekly;
            Log.d("t", "test ist weekly" + taskAlarmDate.toString());
        }


        routine.setRoutineAlarmDate(taskAlarmDate);
        routine.setRendemReqestCodeint(randomReqestCode);
        Log.d("cal", "die zahl für Aufgabe  ist " + randomReqestCode);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, randomReqestCode, intent, 0);
       RoutineSettingsManager routineSettingsManager = new RoutineSettingsManager(context);


        if (routine.isEveryDay) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);
            }
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), AlarmManager.INTERVAL_DAY, pendingIntent);
            Log.d("t", "wiederhlung ist jede Tag" + taskAlarmDate.toString());


        } else if (routine.getIsEveryWeek()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);
            }
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), AlarmManager.INTERVAL_DAY * 7, pendingIntent);

            Log.d("t", "wiederhlung ist jede Woche" + taskAlarmDate.toString());

        } else if (routine.isEveryMonth) {
            setMyMonth(routine, currentMonth, alarmManager, routine.getRoutineMills(), pendingIntent, cal);
        }


        if (!routine.isEveryDay && !routine.getIsEveryWeek && !routine.isEveryMonth) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);
            }
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);
            Log.d("t", "wiederhlung ist jede Tag" + taskAlarmDate.toString());
        }


        Toast.makeText(context.getApplicationContext(), context.getString(R.string.NotficationStartToastPart1) + " " + routine.getRoutineAlarmDate(), Toast.LENGTH_LONG).show();
        routineManager.saveRoutineList();

    }


    public void setMyMonth(Routine routine, int currentMonth, AlarmManager alarmManager, long mills, PendingIntent pendingIntent, Calendar cal) {

        if (routine.isEveryMonth) {
            if (currentMonth == Calendar.JANUARY || currentMonth == Calendar.MARCH || currentMonth == Calendar.MAY || currentMonth == Calendar.JULY || currentMonth == Calendar.AUGUST || currentMonth == Calendar.OCTOBER || currentMonth == Calendar.DECEMBER) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);
                }
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), AlarmManager.INTERVAL_DAY * 31, pendingIntent);

            } else if (currentMonth == Calendar.APRIL || currentMonth == Calendar.JUNE || currentMonth == Calendar.SEPTEMBER || currentMonth == Calendar.NOVEMBER) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);
                }
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), AlarmManager.INTERVAL_DAY * 30, pendingIntent);

            } else if (currentMonth == Calendar.FEBRUARY) {//for february month)
                GregorianCalendar gregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
                if (gregorianCalendar.isLeapYear(cal.get(Calendar.YEAR))) {//for leap year february month
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);
                    }
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), AlarmManager.INTERVAL_DAY * 29, pendingIntent);

                }

            }
            if (currentMonth == Calendar.FEBRUARY) {//for february month)
                GregorianCalendar gregorianCalendar1 = (GregorianCalendar) GregorianCalendar.getInstance();
                if (!gregorianCalendar1.isLeapYear(cal.get(Calendar.YEAR))) {//for leap year february month
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);
                    }
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), pendingIntent);
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, routine.getRoutineMills(), AlarmManager.INTERVAL_DAY * 28, pendingIntent);

                }
            }
        }
    }



}









