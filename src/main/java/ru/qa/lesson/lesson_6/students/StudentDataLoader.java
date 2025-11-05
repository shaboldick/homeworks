package ru.qa.lesson.lesson_6.students;

import java.util.*;

public class StudentDataLoader {

    public static Set<Student> loadSampleStudents() {
        Set<Student> students = new HashSet<>();

        students.add(new Student("Анна Иванова", "Группа А", 2,
                Map.of("Математика", 4, "Физика", 5, "Химия", 3)));

        students.add(new Student("Борис Петров", "Группа Б", 3,
                Map.of("Математика", 2, "Физика", 1, "Химия", 2)));

        students.add(new Student("Светлана Сидорова", "Группа А", 3,
                Map.of("Математика", 5, "Физика", 4, "Химия", 5)));

        return students;
    }
}