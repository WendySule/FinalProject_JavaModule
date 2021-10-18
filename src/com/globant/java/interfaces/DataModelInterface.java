package com.globant.java.interfaces;

import com.globant.java.models.Course;
import com.globant.java.models.Student;
import com.globant.java.models.Teacher;

import java.util.List;

public interface DataModelInterface {

    public List<Teacher> initializeTeachers();
    public List<Student> initializeStudent();
    public List<Course> initializeCourse();

}