package com.example.retrofit;

public class Attendance {

    String className;
    int totalLectures;
    int present;
    int sick;
    int absent;
    int late;

    public Attendance(String className, int totalLectures, int present, int sick, int absent, int late) {
        this.className = className;
        this.totalLectures = totalLectures;
        this.present = present;
        this.sick = sick;
        this.absent = absent;
        this.late = late;
    }

    public String getClassName() {
        return className;
    }

    public int getTotalLectures() {
        return totalLectures;
    }

    public int getPresent() {
        return present;
    }

    public int getSick() {
        return sick;
    }

    public int getAbsent() {
        return absent;
    }

    public int getLate() {
        return late;
    }
}
