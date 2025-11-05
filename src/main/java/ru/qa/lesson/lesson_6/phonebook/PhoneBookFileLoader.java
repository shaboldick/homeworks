package ru.qa.lesson.lesson_6.phonebook;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class PhoneBookFileLoader {

    /**
     * Загружает данные из файла в PhoneBook.
     *
     * @param phoneBook целевой справочник
     * @param filePath  путь к файлу (например, "phonebook.txt")
     */
    public static void loadFromFile(PhoneBook phoneBook, String filePath) {
        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            System.err.println("️ Файл не найден: " + filePath);
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue; // пропускаем пустые и комментарии

                String[] parts = line.split(";", 2);
                if (parts.length != 2) {
                    System.err.println(" Неверный формат в строке " + lineNumber + ": " + line);
                    continue;
                }

                String surname = parts[0].trim();
                String phone = parts[1].trim();
                phoneBook.add(surname, phone);
            }
            System.out.println(" Загружено из файла: " + filePath);
        } catch (IOException e) {
            System.err.println(" Ошибка чтения файла: " + e.getMessage());
        }
    }
}