package com.mn.myroutines;

import com.google.gson.internal.$Gson$Preconditions;

import java.io.Serializable;
import java.util.ArrayList;

public class Routine implements Serializable {


    public String routineName;
    public String timerName;
    public int routineSlotEins = 0;
    public int routineSlot1;
    public int routineSlotZwei = 1;
    public int routineSlot2;
    public int routineSlotDrei = 2;
    public int routineSlot3;
    public  int routineSlotVier = 3;
    public int routineSlot4;
    public  int routineSlotFünf = 4;
    public int routineSlot5;
    public  int routineSlotSechs = 5;
    public int routineSlot6;
    public int routineSlotSieben = 6;
    public int routineSlot7;
    public int routineSlot8;
    public int routineSlotAcht = 7;
    public int routineSlot9;
    public int routineSlotNeun = 8;
    public int routineSlot10;
    public int routineSlotZehn = 9;
    public int timerSeconds;
    public int timerMinutes;
    public int timerHours;



    public void setRoutineName(String routineName) {
        this.routineName = routineName;
    }

    public String getRoutineName() {
        return routineName;
    }

    public void setRoutineSlot1(int routineSlot1) {
        this.routineSlot1 = routineSlot1;
    }

    public int getRoutineSlot1() {
        return routineSlot1;
    }

    public void setRoutineSlot2(int routineSlot2) {
        this.routineSlot2 = routineSlot2;
    }

    public int getRoutineSlot2() {
        return routineSlot2;
    }

    public void setRoutineSlot3(int routineSlot3) {
        this.routineSlot3 = routineSlot3;
    }

    public int getRoutineSlot3() {
        return routineSlot3;
    }

    public void setRoutineSlot4(int routineSlot4) {
        this.routineSlot4 = routineSlot4;
    }

    public int getRoutineSlot4() {
        return routineSlot4;
    }

    public void setRoutineSlot5(int routineSlot5) {
        this.routineSlot5 = routineSlot5;
    }

    public int getRoutineSlot5() {
        return routineSlot5;
    }


    public void setRoutineSlot6(int routineSlot6) {
        this.routineSlot6 = routineSlot6;
    }

    public int getRoutineSlot6() {
        return routineSlot6;
    }

    public void setRoutineSlot7(int routineSlot7) {
        this.routineSlot7 = routineSlot7;
    }

    public int getRoutineSlot7() {
        return routineSlot7;
    }

    public void setRoutineSlot8(int routineSlot8) {
        this.routineSlot8 = routineSlot8;
    }

    public int getRoutineSlot8() {
        return routineSlot8;
    }

    public void setRoutineSlot9(int routineSlot9) {
        this.routineSlot9 = routineSlot9;
    }

    public int getRoutineSlot9() {
        return routineSlot9;

    }

    public void setRoutineSlot10(int routineSlot10){
        this.routineSlot10 = routineSlot10;
    }

    public int getRoutineSlot10() {
        return routineSlot10;
    }

    public void setTimerSeconds(int timerSeconds){
        this.timerSeconds = timerSeconds;

    }
    public int getTimerSeconds(){
        return  timerSeconds;
    }

    public void setTimerMinutes(int timerMinutes){
        this.timerMinutes = timerMinutes;
    }

    public int getTimerMinutes(){
        return  timerMinutes;
    }

    public void setTimerHours(int hours){
        this.timerHours = hours;
    }

    public int getTimerHours(){
        return  timerHours;
    }

    public void setTimerName(String timerName){
        this.timerName = timerName;
    }

    public String getTimerName(){
        return  timerName;
    }
}
