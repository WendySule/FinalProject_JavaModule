package com.globant.java.dataModels;

import com.globant.java.interfaces.DataModelInterface;
import com.globant.java.models.Course;
import com.globant.java.models.Student;
import com.globant.java.models.Teacher;
import com.globant.java.models.University;

import java.util.ArrayList;
import java.util.List;

public class DataModel implements DataModelInterface {

    @Override
    public List<Teacher> initializeTeachers() {
        List<Teacher> dataTeacher = new ArrayList<>();
        Teacher teacher01 = new Teacher("Carol", "FullTime",1000,3,3300);
        Teacher teacher02 = new Teacher("Felipe", "FullTime",1500,5,8250);
        Teacher teacher03 = new Teacher("Juan", "PartTime",1000,20,20000);
        Teacher teacher04 = new Teacher("Pablo", "PartTime",1200,10,12000);
        dataTeacher.add(teacher01);
        dataTeacher.add(teacher02);
        dataTeacher.add(teacher03);
        dataTeacher.add(teacher04);
        return dataTeacher;
    }

    @Override
    public List<Student> initializeStudent() {
        List<Student> dataStudent = new ArrayList<>();
        Student student01 = new Student("MisaePhoenix", 1, 23);
        Student student02 = new Student("AlexTurner", 2, 35);
        Student student03 = new Student("WendyHachilla", 3, 26);
        Student student04 = new Student("AmelieAquise", 4, 32);
        Student student05 = new Student("MadisonCasablancas", 5, 28);
        Student student06 = new Student("DavinoMercury", 6, 24);
        dataStudent.add(student01);
        dataStudent.add(student02);
        dataStudent.add(student03);
        dataStudent.add(student04);
        dataStudent.add(student05);
        dataStudent.add(student06);
        return dataStudent;
    }

    @Override
    public List<Course> initializeCourse(){

        List<Course> dataCourse = new ArrayList<>();

        List<Teacher> getTeacher = initializeTeachers();
        List<Student> getStudent = initializeStudent();

        List<Student> studentsCourse01 = new ArrayList<>();
        studentsCourse01.add(getStudent.get(0));
        studentsCourse01.add(getStudent.get(1));
        studentsCourse01.add(getStudent.get(2));
        List<Student> studentsCourse02 = new ArrayList<>();
        studentsCourse02.add(getStudent.get(0));
        studentsCourse02.add(getStudent.get(1));
        studentsCourse02.add(getStudent.get(2));
        List<Student> studentsCourse03 = new ArrayList<>();
        studentsCourse03.add(getStudent.get(3));
        studentsCourse03.add(getStudent.get(4));
        studentsCourse03.add(getStudent.get(5));
        List<Student> studentsCourse04 = new ArrayList<>();
        studentsCourse04.add(getStudent.get(4));
        studentsCourse04.add(getStudent.get(5));
        studentsCourse04.add(getStudent.get(3));

        List<Teacher> teacherCourse01 = new ArrayList<>();
        teacherCourse01.add(getTeacher.get(0));
        List<Teacher> teacherCourse02 = new ArrayList<>();
        teacherCourse02.add(getTeacher.get(1));
        List<Teacher> teacherCourse03 = new ArrayList<>();
        teacherCourse03.add(getTeacher.get(2));
        List<Teacher> teacherCourse04 = new ArrayList<>();
        teacherCourse04.add(getTeacher.get(3));

        Course course01 = new Course("JavaBasic", "201", studentsCourse01, teacherCourse01);
        Course course02 = new Course("JavaIntermediate", "202", studentsCourse02, teacherCourse02);
        Course course03 = new Course("JavaAdvance", "203", studentsCourse03, teacherCourse03);
        Course course04 = new Course("JavaSenior", "204", studentsCourse04, teacherCourse04);

        dataCourse.add(course01);
        dataCourse.add(course02);
        dataCourse.add(course03);
        dataCourse.add(course04);

        return dataCourse;
    }

}
