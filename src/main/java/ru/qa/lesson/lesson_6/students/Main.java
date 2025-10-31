package ru.qa.lesson.lesson_6.students;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Загружаем студентов через отдельный класс
        Set<Student> students = StudentDataLoader.loadSampleStudents();

        // Вывод до удаления
        System.out.println("Исходный список студентов:");
        students.forEach(System.out::println);

        // Удаляем слабых студентов
        StudentManager.removeWeakStudents(students);

        System.out.println("\nПосле удаления студентов со средним баллом < 3:");
        students.forEach(System.out::println);

        // Выводим студентов 3 курса
        System.out.println();
        StudentManager.printStudentsByCourse(students, 3);
    }
}