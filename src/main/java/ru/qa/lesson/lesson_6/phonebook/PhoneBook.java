package ru.qa.lesson.lesson_6.phonebook;

import java.util.*;

public class PhoneBook {
    private final Map<String, List<String>> records = new HashMap<>();

    public void add(String surname, String phone) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Фамилия не может быть пустой");
        }
        if (phone == null || phone.isEmpty()) {
            throw new IllegalArgumentException("Телефон не может быть пустым");
        }
        records.computeIfAbsent(surname, k -> new ArrayList<>()).add(phone);
    }

    public List<String> get(String surname) {
        if (surname == null) return Collections.emptyList();
        return records.getOrDefault(surname, Collections.emptyList());
    }
}