package ru.qa.lesson.lesson_6.students;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.Locale;

public class Student {
    private final String name;
    private final String group;
    private final int course;
    private final Map<String, Integer> grades;

    public Student(String name, String group, int course, Map<String, Integer> grades) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.group = Objects.requireNonNull(group, "Group cannot be null");
        this.course = course;
        this.grades = new HashMap<>(Objects.requireNonNull(grades, "Grades cannot be null"));
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public Map<String, Integer> getGrades() {
        return new HashMap<>(grades);
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        return grades.values().stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Student{name='%s', group='%s', course=%d, avgGrade=%.2f}",
                name, group, course, getAverageGrade());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return course == student.course &&
                Objects.equals(name, student.name) &&
                Objects.equals(group, student.group) &&
                Objects.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, course, grades);
    }
}