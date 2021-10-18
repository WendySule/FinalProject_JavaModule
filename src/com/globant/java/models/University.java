package com.globant.java.models;

import java.util.List;

public abstract class University {

    protected List<Student> lsStudent;
    protected List<Course> lsCourse;
    protected List<Teacher> lsTeacher;

    public University() {};

    public University(List<Student> lsStudent, List<Teacher> lsTeacher) {
        this.lsStudent = lsStudent;
       // this.lsCourse = lsCourse;
        this.lsTeacher = lsTeacher;
    }

    public List<Student> getLsStudent() {
        return lsStudent;
    }

    public void setLsStudent(List<Student> lsStudent) {
        this.lsStudent = lsStudent;
    }

    public List<Course> getLsCourse() {
        return lsCourse;
    }

    public void setLsCourse(List<Course> lsCourse) {
        this.lsCourse = lsCourse;
    }

    public List<Teacher> getLsTeacher() {
        return lsTeacher;
    }

    public void setLsTeacher(List<Teacher> lsTeacher) {
        this.lsTeacher = lsTeacher;
    }

    public abstract double getSalary();
}