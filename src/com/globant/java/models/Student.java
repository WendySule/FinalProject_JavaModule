package com.globant.java.models;

public class Student {
    private String nameStudent;
    private int id;
    private int age;

    public Student () {}

    public Student(String nameStudent, int id, int age) {
        this.nameStudent = nameStudent;
        this.id = id;
        this.age = age;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "id=" + id + "\n" +
                "nameStudent= " + nameStudent + "\n" +
                "age=" + age + "\n";
    }
}