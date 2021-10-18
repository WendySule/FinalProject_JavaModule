package com.globant.java.main;

import com.globant.java.dataModels.DataModel;
import com.globant.java.models.Course;
import com.globant.java.models.Student;
import com.globant.java.models.Teacher;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static DataModel dataModel = new DataModel();
    private static List<Teacher> lsTeacher = dataModel.initializeTeachers();
    private static List<Student> lsStudent = dataModel.initializeStudent();
    private static List<Course> lsCourse = dataModel.initializeCourse();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("***********************************");
        System.out.println("************ Menu *****************");
        System.out.println("a. Show all teachers with their data");
        System.out.println("b. Show all courses and selects a course");
        System.out.println("c. Create a new student and add it to a course");
        System.out.println("d. Create a new course (add teacher, students and their data)");
        System.out.println("e. List of all courses by student");
        System.out.println("f. Exit");
        chooseOption();
    }

    //variable global
    public static Scanner scan = new Scanner(System.in);

    public static void chooseOption() {

        System.out.println("*Select an option from the Menu*");
        String option = scan.next();

        switch (option) {
            case "a":
                printListTeacher();
            case "b":
                printListCourse();
            case "c":
                createStudent();
            case "d":
                createCourse();
            case "e":
                totalCoursesOfAStudent();
            case "f":
                System.out.println("Exited the program");
            default:
                break;
        }
    }

    public static void printListTeacher() {
        for (Teacher item : lsTeacher) {
            System.out.println(
                        " Name:  " + item.getNameTeacher() + "\n" +
                        " Workday:  " + item.getWorkday() + "\n" +
                        " BaseSalary:  " + item.getBaseSalary() + "\n" +
                        " WorkingTime:  " + item.getWorkingTime() + "\n" +
                        " TotalSalary:  " + item.getTotalSalary() + "\n"
            );
        }
        menu();
    }

    public static void printListCourse() {
        int index = 0;
        for (Course item : lsCourse) {
            System.out.println(
                        "Course: " + item.getCourseName() + "\n" +
                        "Classroom: " + item.getClassroom() + "\n"
            );
        }
        System.out.println("*Select a course by classroom*");
        String classroom = scan.next();

        String listStudent = "";
        for (Course itemClassroom : lsCourse) {
            if (itemClassroom.getClassroom().equals(classroom)) {
                for (Student itemStudent : itemClassroom.getLsStudent()) {
                    listStudent += " NameStudent: " + itemStudent.getNameStudent() +
                            ", Id: " + itemStudent.getId() +
                            ", Age: " + itemStudent.getAge() + "\n";
                }
                System.out.println(
                            "Course: " + itemClassroom.getCourseName() + "\n" +
                            "Classroom: " + itemClassroom.getClassroom() + "\n" +
                            "Students: " + "\n" +
                            listStudent + "\n" +
                            "Teacher: " + itemClassroom.getLsTeacher().get(0).getNameTeacher() + "\n"
                );
            }

        }

        menu();
    }

    public static void printListStudent() {
        System.out.println(lsStudent.toString());
        menu();
    }

    public static void createStudent() {
        System.out.println("Create a new student");
        System.out.println("*Adds the name of the new student*");
        String nameStudent = scan.next();
        System.out.println("*Adds the Id of the new student*");
        int idStudent = scan.nextInt();
        System.out.println("*Adds the age of the new student*");
        int ageStudent = scan.nextInt();

        Student newStudent = new Student(nameStudent, idStudent, ageStudent);

        System.out.println("List of courses");
        for (Course item:  lsCourse) {
            System.out.println(
                    "Course: " + item.getCourseName() + "\n" +
                    "Classroom: " + item.getClassroom() + "\n"
            );
        }

        System.out.println("*Select the course where the student will enter*");
        String classroom = scan.next();

        String listStudent = "";
        for (Course itemClassroom : lsCourse) {
            if (itemClassroom.getClassroom().equals(classroom)) {
                itemClassroom.getLsStudent().add(newStudent);
                for (Student itemStudent : itemClassroom.getLsStudent()) {
                    listStudent += " id= " + itemStudent.getId() +
                    " nameStudent= " + itemStudent.getNameStudent() + "\n" +
                    " age=" + itemStudent.getAge() + "\n";
                }
                System.out.println(
                        "Course: " + itemClassroom.getCourseName() + "\n" +
                        "Classroom: " + itemClassroom.getClassroom() + "\n" +
                        "Student: " + "\n" +
                        listStudent + "\n" +
                        "Teacher: " + itemClassroom.getLsTeacher().get(0).getNameTeacher() + "\n"
                );
            }
        }
        menu();
    }

    public static void createCourse() {
        System.out.println("Create a new course");
        System.out.println("*Enter the name of the course*");
        String addNameCourse = scan.next();
        System.out.println("*Enter the classroom of the course*");
        String addClassroomCourse = scan.next();
        System.out.println("List of teachers");
        System.out.println(lsTeacher);
        System.out.println("*Choose the teacher by name*");
        String chooseTeacher = scan.next().toUpperCase();

        List<Teacher> listTeacherCourse = new ArrayList<>();
        String teacherCapitalLetter = chooseTeacher.charAt(0) + chooseTeacher.substring(1).toLowerCase();
        for (Teacher itemTeacher: lsTeacher ) {
            System.out.println(itemTeacher);
            if(itemTeacher.getNameTeacher().equals(teacherCapitalLetter)) {
                System.out.println("1");

                Teacher assignedTeacher = new Teacher(
                        itemTeacher.getNameTeacher(),
                        itemTeacher.getWorkday(),
                        itemTeacher.getBaseSalary(),
                        itemTeacher.getWorkingTime(),
                        itemTeacher.getTotalSalary()
                );
                listTeacherCourse.add(assignedTeacher);
            }
        }
        System.out.println("List of students");
        System.out.println(lsStudent);

        boolean addMoreStudents = true;
        List<Student> listStudentCourse = new ArrayList<>();
        while (addMoreStudents) {
            System.out.println("*Adds the student by Id*");
            int chooseStudent = scan.nextInt();
            for (Student itemStudent: lsStudent) {
                if (itemStudent.getId()==chooseStudent){
                    Student addTheStudents = new Student(
                            itemStudent.getNameStudent(),
                            itemStudent.getId(),
                            itemStudent.getAge()
                    );
                    listStudentCourse.add(addTheStudents);
                }
            }
            System.out.println("*Do you want to add more students? write yes/no*");
            String continueAdding = scan.next();

            if (!continueAdding.equals("yes")) {
                addMoreStudents = false;
            }
        }
        Course addCreateCourse = new Course(addNameCourse, addClassroomCourse, listStudentCourse, listTeacherCourse);
        lsCourse.add(addCreateCourse);

        String listStudentsNewCourse = "";
        for (Student itemStudent : listStudentCourse) {
             listStudentsNewCourse +=  " Id: " + itemStudent.getId() +
                    " NameStudent: " + itemStudent.getNameStudent() +
                    " Age:" + itemStudent.getAge() + "\n";
        }

        System.out.println("Name of the new course: " + addNameCourse+ "\n" +
                                            "Classroom : " + addClassroomCourse  + "\n" +
                                            "Teacher : " +listTeacherCourse.get(0).getNameTeacher() + " " +
                                            ", Workday: "  + listTeacherCourse.get(0).getWorkday() + "\n" +
                                            "List of students : " + "\n" +
                                             listStudentsNewCourse);

        menu();
    }

        public static void  totalCoursesOfAStudent () {
            System.out.println("List of all courses of a student");
            System.out.println("*Enter the Id of the student*");

            int idStudent = scan.nextInt();
            List<Course> listCourseStudent = new ArrayList<>();
            System.out.println("List of student courses");
            for (Course elementCourse: lsCourse ) {
                for (Student elementStudent: elementCourse.getLsStudent()) {
                    if (elementStudent.getId() == idStudent) {
                        System.out.println(elementCourse.getCourseName());
                    }

                }
            }
        menu();
    }
}
