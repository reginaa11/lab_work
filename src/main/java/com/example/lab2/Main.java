package com.example.lab2;

import com.example.lab2.basic.*;
import com.example.lab2.geometry.geometry2d.Circle;
import com.example.lab2.geometry.geometry2d.Rectangle;
import com.example.lab2.geometry.geometry3d.Cylinder;
import com.example.lab2.analyzer.FileAnalyzer;
import com.example.lab2.analyzer.StudentGrades;

import java.util.List;

/**
 * Основной класс для тестирования Lab2
 * Симоненко Регина Фит241
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Лабораторная работа 2: Основы синтаксиса Java ===");
        System.out.println("Студент: Симоненко Регина");
        System.out.println("Группа: Фит241\n");

        // Тестирование задания 1
        testButton();

        // Тестирование задания 2
        testBalance();

        // Тестирование задания 3
        testBell();

        // Тестирование задания 4
        testOddEvenSeparator();

        // Тестирование задания 5
        testTable();

        // Тестирование задания 6
        testGeometry();

        // Тестирование задания 7
        testFileAnalyzer();

        // Тестирование задания 8
        testStudentGrades();

        System.out.println("\n=== Все задания Lab2 выполнены ===");
    }

    private static void testButton() {
        System.out.println("\n--- Задание 1: Button ---");
        Button button = new Button();
        System.out.println("Тестирование кнопки:");
        button.click();
        button.click();
        button.click();
    }

    private static void testBalance() {
        System.out.println("\n--- Задание 2: Balance ---");
        Balance balance = new Balance();
        balance.addLeft(10);
        balance.addRight(5);
        balance.addRight(5);
        System.out.println("Результат взвешивания: " + balance.result()); // =

        balance.addLeft(5);
        System.out.println("После добавления веса на левую чашу: " + balance.result()); // L
    }

    private static void testBell() {
        System.out.println("\n--- Задание 3: Bell ---");
        Bell bell = new Bell();
        System.out.println("Звонок колокольчика:");
        bell.sound(); // ding
        bell.sound(); // dong
        bell.sound(); // ding
        bell.sound(); // dong
    }

    private static void testOddEvenSeparator() {
        System.out.println("\n--- Задание 4: OddEvenSeparator ---");
        OddEvenSeparator separator = new OddEvenSeparator();
        separator.addNumber(1);
        separator.addNumber(2);
        separator.addNumber(3);
        separator.addNumber(4);
        separator.addNumber(5);
        separator.addNumber(6);

        separator.even();
        separator.odd();
    }

    private static void testTable() {
        System.out.println("\n--- Задание 5: Table ---");
        Table table = new Table(2, 3);
        table.setValue(0, 0, 1);
        table.setValue(0, 1, 2);
        table.setValue(0, 2, 3);
        table.setValue(1, 0, 4);
        table.setValue(1, 1, 5);
        table.setValue(1, 2, 6);

        System.out.println("Таблица 2x3:");
        System.out.println(table.toString());
        System.out.printf("Среднее значение: %.2f\n", table.average());
    }

    private static void testGeometry() {
        System.out.println("\n--- Задание 6: Geometry ---");

        try {
            Circle circle = new Circle(5.0);
            System.out.println("Круг: " + circle);

            Rectangle rectangle = new Rectangle(4.0, 6.0);
            System.out.println("Прямоугольник: " + rectangle);

            Cylinder cylinder = new Cylinder(circle, 10.0);
            System.out.println("Цилиндр: " + cylinder);

        } catch (Exception e) {
            System.out.println("Ошибка в геометрических фигурах: " + e.getMessage());
        }
    }

    private static void testFileAnalyzer() {
        System.out.println("\n--- Задание 7: FileAnalyzer ---");
        FileAnalyzer analyzer = new FileAnalyzer();

        // Создадим тестовый файл для демонстрации
        String testFilename = "test_file.txt";

        // В реальном проекте здесь был бы код создания тестового файла
        System.out.println("FileAnalyzer готов к работе");
        System.out.println("(Для тестирования нужен реальный текстовый файл)");
    }

    private static void testStudentGrades() {
        System.out.println("\n--- Задание 8: StudentGrades ---");
        StudentGrades gradesAnalyzer = new StudentGrades();

        // Создадим тестовые данные для демонстрации
        String testFilename = "students_grades.txt";

        // В реальном проекте здесь был бы код создания тестового файла
        System.out.println("StudentGrades готов к работе");
        System.out.println("(Для тестирования нужен файл с оценками студентов)");

        // Демонстрация работы с mock-данными
        System.out.println("Пример формата файла:");
        System.out.println("Иванов 5 4 3 5");
        System.out.println("Петров 4 4 4");
        System.out.println("Сидоров 5 5 5 5");
    }
}