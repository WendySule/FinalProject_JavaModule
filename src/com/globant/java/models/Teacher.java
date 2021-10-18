package com.globant.java.models;

public class Teacher extends University {
    private String nameTeacher;
    private String workday;
    private float baseSalary;
    private float workingTime;
    private double totalSalary;

    public Teacher() {}

    public Teacher(String nameTeacher, String workday, float baseSalary, float workingTime, double totalSalary) {
        this.nameTeacher = nameTeacher;
        this.workday = workday;
        this.baseSalary = baseSalary;
        this.workingTime = workingTime;
        this.totalSalary = totalSalary;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public String getWorkday() {
        return workday;
    }

    public void setWorkday(String workday) {
        this.workday = workday;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }

    public float getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(float workingTime) {
        this.workingTime = workingTime;
    }

    @Override
    public double getSalary() {
        double salary = (this.workday == "FullTime" )
                ? this.baseSalary * 1.10 * workingTime
                :  this.baseSalary *  workingTime;

        return salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
        "nameTeacher='" + nameTeacher + '\'' +
        ", workday='" + workday + '\'' +
        ", baseSalary=" + baseSalary +
        ", workingTime=" + workingTime +
        ", totalSalary=" + totalSalary +
        "}\n";
    }
}