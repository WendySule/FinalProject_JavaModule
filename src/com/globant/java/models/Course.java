package com.globant.java.models;

import java.util.ArrayList;
import java.util.List;

public class Course extends University{
    private String courseName;
    private String classroom;

    public Course() { }

    @Override
    public double getSalary() {
        return 0;
    }

    public Course(String courseName, String classroom, List<Student> lsStudent, List<Teacher> lsTeacher) {
        super(lsStudent, lsTeacher);
        this.courseName = courseName;
        this.classroom = classroom;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", classroom='" + classroom + '\'' +
                '}';
    }
}