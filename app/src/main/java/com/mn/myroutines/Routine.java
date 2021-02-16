package com.mn.myroutines;

import com.google.gson.internal.$Gson$Preconditions;

import java.io.Serializable;
import java.util.ArrayList;

public class Routine implements Serializable {


    public String routineName;
    public String timerName;
    public String descriptionText;
    public String appNameSlot1;
    public String appNameSlot2;
    public String appNameSlot3;
    public String appNameSlot4;
    public String appNameSlot5;
    public String appNameSlot6;
    public String appNameSlot7;
    public String appNameSlot8;
    public String appNameSlot9;
    public String appnameSlot10;



    public String appPackageNameSlot1;
    public String appPackageNameSlot2;
    public String appPackageNameSlot3;
    public String appPackageNameSlot4;
    public String appPackageNameSlot5;
    public String appPackageNameSlot6;
    public String appPackageNameSlot7;
    public String appPackageNameSlot8;
    public String appPackageNameSlot9;
    public String appPackageNameSlot10;

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

    public String getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    public void setAppNameSlot1(String appNameSlot1){
        this.appNameSlot1 = appNameSlot1;
    }
    public String getAppNameSlot1(){
        return  appNameSlot1;
    }
    public void setAppNameSlot2(String appNameSlot2){
        this.appNameSlot2 = appNameSlot2;
    }
    public String getAppNameSlot2(){
        return  appNameSlot2;
    }
    public void setAppNameSlot3 (String appNameSlot3){
        this.appNameSlot3 = appNameSlot3;
    }
    public String getAppNameSlot3(){
        return  appNameSlot3;
    }
    public void setAppNameSlot4(String appNameSlot4){
        this.appNameSlot4 = appNameSlot4;
    }
    public String getAppNameSlot4(){
        return appNameSlot4;
    }
    public void setAppNameSlot5(String appNameSlot5){
        this.appNameSlot5 = appNameSlot5;
    }
    public String getAppNameSlot5(){
        return  appNameSlot5;
    }
    public void setAppNameSlot6(String appNameSlot6){
        this.appNameSlot6 = appNameSlot6;
    }

    public String getAppNameSlot6(){
        return  appNameSlot6;
    }

    public void setAppNameSlot7(String appNameSlot7){
        this.appNameSlot7 = appNameSlot7;
    }
    public String getAppNameSlot7(){
        return  appNameSlot7;
    }
    public void setAppNameSlot8(String appNameSlot8){
        this.appNameSlot8 = appNameSlot8;
    }
    public String getAppNameSlot8(){
        return appNameSlot8;
    }
    public void setAppNameSlot9(String appNameSlot9){
        this.appNameSlot9 = appNameSlot9;
    }
    public String getAppNameSlot9(){
        return  appNameSlot9;
    }

    public void setAppnameSlot10(String appnameSlot10){
        this.appnameSlot10 = appnameSlot10;
    }
    public String getAppnameSlot10(){
        return  appnameSlot10;
    }

    public String getAppPackageNameSlot1() {
        return appPackageNameSlot1;
    }

    public void setAppPackageNameSlot1(String appPackageNameSlot1) {
        this.appPackageNameSlot1 = appPackageNameSlot1;
    }

    public String getAppPackageNameSlot2() {
        return appPackageNameSlot2;
    }

    public void setAppPackageNameSlot2(String appPackageNameSlot2) {
        this.appPackageNameSlot2 = appPackageNameSlot2;
    }

    public String getAppPackageNameSlot3() {
        return appPackageNameSlot3;
    }

    public void setAppPackageNameSlot3(String appPackageNameSlot3) {
        this.appPackageNameSlot3 = appPackageNameSlot3;
    }

    public String getAppPackageNameSlot4() {
        return appPackageNameSlot4;
    }

    public void setAppPackageNameSlot4(String appPackageNameSlot4) {
        this.appPackageNameSlot4 = appPackageNameSlot4;
    }

    public void setAppPackageNameSlot5(String appPackageNameSlot5){
        this.appPackageNameSlot5 = appPackageNameSlot5;
    }

    public String getAppPackageNameSlot5(){
        return  appPackageNameSlot5;
    }

    public String getAppPackageNameSlot6() {
        return appPackageNameSlot6;
    }

    public void setAppPackageNameSlot6(String appPackageNameSlot6) {
        this.appPackageNameSlot6 = appPackageNameSlot6;
    }

    public String getAppPackageNameSlot7() {
        return appPackageNameSlot7;
    }

    public void setAppPackageNameSlot7(String appPackageNameSlot7) {
        this.appPackageNameSlot7 = appPackageNameSlot7;
    }

    public String getAppPackageNameSlot8() {
        return appPackageNameSlot8;
    }

    public void setAppPackageNameSlot8(String appPackageNameSlot8) {
        this.appPackageNameSlot8 = appPackageNameSlot8;
    }

    public String getAppPackageNameSlot9() {
        return appPackageNameSlot9;
    }

    public void setAppPackageNameSlot9(String appPackageNameSlot9) {
        this.appPackageNameSlot9 = appPackageNameSlot9;
    }

    public String getAppPackageNameSlot10() {
        return appPackageNameSlot10;
    }

    public void setAppPackageNameSlot10(String appPackageNameSlot10) {
        this.appPackageNameSlot10 = appPackageNameSlot10;
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
