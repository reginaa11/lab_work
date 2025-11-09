package com.example.lab7;

import com.example.lab7.before.*;
import com.example.lab7.refactored.srp.*;
import com.example.lab7.refactored.ocp.*;
import com.example.lab7.refactored.lsp.*;

import java.util.Arrays;
import java.util.List;

/**
 * Основной класс для демонстрации рефакторинга по принципам SOLID
 * Симоненко Регина Фит241
 */
public class Lab7Main {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("Лабораторная работа 7");
        System.out.println("Принципы SOLID: SRP, OCP, LSP");
        System.out.println("Студент: Симоненко Регина");
        System.out.println("Группа: Фит241");
        System.out.println("=========================================\n");

        // Демонстрация до рефакторинга
        demonstrateBeforeRefactoring();

        System.out.println("\n" + "=".repeat(60) + "\n");

        // Демонстрация после рефакторинга
        demonstrateAfterRefactoring();

        System.out.println("\n=========================================");
        System.out.println("Рефакторинг по SOLID принципам завершен!");
        System.out.println("=========================================");
    }

    private static void demonstrateBeforeRefactoring() {
        System.out.println("=== ДО РЕФАКТОРИНГА (НАРУШЕНИЯ SOLID) ===\n");

        // Нарушение SRP
        System.out.println("1. НАРУШЕНИЕ SRP:");
        OrderProcessor orderProcessor = new OrderProcessor("ORD-001", 1500.0, "client@mail.com");
        orderProcessor.processOrder();

        // Нарушение OCP
        System.out.println("\n2. НАРУШЕНИЕ OCP:");
        AreaCalculator areaCalculator = new AreaCalculator();
        areaCalculator.printArea("circle", 5.0);
        areaCalculator.printArea("rectangle", 4.0, 6.0);
        areaCalculator.printArea("triangle", 3.0, 4.0);

        // Нарушение LSP
        System.out.println("\n3. НАРУШЕНИЕ LSP:");
        BirdService birdService = new BirdService();
        List<Bird> birds = Arrays.asList(
                new Bird("Голубь", 0.3),
                new Ostrich("Страус", 120.0),
                new Penguin("Пингвин", 25.0)
        );
        birdService.makeBirdsFly(birds);
    }

    private static void demonstrateAfterRefactoring() {
        System.out.println("=== ПОСЛЕ РЕФАКТОРИНГА (СОБЛЮДЕНИЕ SOLID) ===\n");

        // SRP рефакторинг
        System.out.println("1. ПРИМЕНЕНИЕ SRP:");
        Order order = new Order("ORD-002", 1200.0, "customer@example.com");
        OrderProcessor processor = new OrderProcessor();
        processor.processOrder(order);

        // OCP рефакторинг
        System.out.println("\n2. ПРИМЕНЕНИЕ OCP:");
        List<Shape> shapes = Arrays.asList(
                new Circle(5.0),
                new Rectangle(4.0, 6.0),
                new Triangle(3.0, 4.0, 5.0),
                new Square(4.0) // Новая фигура без изменения кода!
        );

        AreaCalculator shapeCalculator = new AreaCalculator();
        shapeCalculator.printAllAreas(shapes);
        shapeCalculator.printAllPerimeters(shapes);
        shapeCalculator.drawAllShapes(shapes);

        // LSP рефакторинг
        System.out.println("\n3. ПРИМЕНЕНИЕ LSP:");
        BirdService refactoredBirdService = new BirdService();
        refactoredBirdService.demonstrateLSP();
    }
}