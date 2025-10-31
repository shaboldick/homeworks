package ru.qa.lesson.lesson_6.students;

import java.util.Set;

public class StudentManager {

    public static void removeWeakStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3.0);
    }

    public static void printStudentsByCourse(Set<Student> students, int course) {
        System.out.println("Студенты на курсе " + course + ":");
        students.stream()
                .filter(student -> student.getCourse() == course)
                .map(Student::getName)
                .sorted()
                .forEach(name -> System.out.println("- " + name));
    }
}