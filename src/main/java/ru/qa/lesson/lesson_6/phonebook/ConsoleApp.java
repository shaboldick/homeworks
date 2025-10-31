package ru.qa.lesson.lesson_6.phonebook;

import java.util.Scanner;

public class ConsoleApp {
    private final PhoneBook phoneBook = new PhoneBook();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        // Загружаем данные из файла
        PhoneBookFileLoader.loadFromFile(phoneBook, "phonebook.txt");

        System.out.println("\n Телефонный справочник (данные из phonebook.txt)");
        System.out.println("Введите фамилию для поиска (или 'exit' для выхода):");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("До свидания!");
                break;
            }

            if (input.isEmpty()) {
                System.out.println("Пожалуйста, введите фамилию.");
                continue;
            }

            var phones = phoneBook.get(input);
            if (phones.isEmpty()) {
                System.out.println(" Нет записей для фамилии: " + input);
            } else {
                System.out.println(" Найдено " + phones.size() + " телефон(ов) для '" + input + "':");
                for (String phone : phones) {
                    System.out.println("  → " + phone);
                }
            }
        }
    }
}