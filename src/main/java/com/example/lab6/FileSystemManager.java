package com.example.lab6;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;


public class FileSystemManager {

    private final String surname;
    private final String name;
    private Path baseDir;

    public FileSystemManager(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public void performFileOperations() {
        try {
            // 1. Создаем базовую директорию с фамилией
            createBaseDirectory();

            // 2. Создаем файл с именем
            createNameFile();

            // 3. Создаем вложенные директории и копируем файл
            createNestedDirectories();

            // 4. Создаем дополнительные файлы
            createAdditionalFiles();

            // 5. Рекурсивный обход и вывод структуры
            printDirectoryStructure();

            // 6. Удаляем директорию dir1
            deleteDir1();

            // 7. Выводим финальную структуру
            System.out.println("\n=== ФИНАЛЬНАЯ СТРУКТУРА ===");
            printDirectoryStructure();

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файловой системой: " + e.getMessage());
        }
    }

    private void createBaseDirectory() throws IOException {
        baseDir = Paths.get(surname);
        Files.createDirectories(baseDir);
        System.out.println(" Создана директория: " + baseDir.toAbsolutePath());
    }


    private void createNameFile() throws IOException {
        Path nameFile = baseDir.resolve(name + ".txt");
        if (!Files.exists(nameFile)) {
            Files.createFile(nameFile);
            // Записываем немного текста в файл
            Files.write(nameFile, Collections.singletonList("Файл студента: " + name),
                    StandardOpenOption.WRITE);
        }
        System.out.println("Создан файл: " + nameFile.getFileName());
    }

    private void createNestedDirectories() throws IOException {
        // Создаем цепочку вложенных директорий
        Path nestedDir = baseDir.resolve("dir1/dir2/dir3");
        Files.createDirectories(nestedDir);
        System.out.println("Созданы вложенные директории: dir1/dir2/dir3");

        // Копируем файл с именем во вложенную директорию
        Path sourceFile = baseDir.resolve(name + ".txt");
        Path targetFile = nestedDir.resolve(name + "_copy.txt");
        Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Файл скопирован в: " + targetFile);
    }

    private void createAdditionalFiles() throws IOException {
        // Файл в dir1
        Path file1 = baseDir.resolve("dir1/file1.txt");
        Files.createFile(file1);
        Files.write(file1, Collections.singletonList("Это file1 в dir1"));
        System.out.println("Создан файл: dir1/file1.txt");

        // Файл в dir2
        Path file2 = baseDir.resolve("dir1/dir2/file2.txt");
        Files.createFile(file2);
        Files.write(file2, Collections.singletonList("Это file2 в dir2"));
        System.out.println("Создан файл: dir1/dir2/file2.txt");
    }


    private void printDirectoryStructure() throws IOException {
        System.out.println("\n=== СТРУКТУРА ДИРЕКТОРИИ " + surname.toUpperCase() + " ===");

        Files.walk(baseDir)
                .sorted()
                .forEach(path -> {
                    try {
                        String prefix = Files.isDirectory(path) ? "D: " : "F: ";
                        String relativePath = baseDir.relativize(path).toString();
                        if (relativePath.isEmpty()) {
                            relativePath = baseDir.getFileName().toString();
                        }
                        System.out.println(prefix + relativePath);
                    } catch (Exception e) {
                        System.err.println("Ошибка при обработке пути: " + path);
                    }
                });
    }


    private void deleteDir1() throws IOException {
        Path dir1 = baseDir.resolve("dir1");
        if (Files.exists(dir1)) {
            // Рекурсивно удаляем директорию со всем содержимым
            Files.walk(dir1)
                    .sorted(Collections.reverseOrder())
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                            System.out.println("🗑️ Удален: " + baseDir.relativize(path));
                        } catch (IOException e) {
                            System.err.println("Ошибка при удалении: " + path);
                        }
                    });
            System.out.println(" Директория dir1 удалена со всем содержимым");
        }
    }
}
