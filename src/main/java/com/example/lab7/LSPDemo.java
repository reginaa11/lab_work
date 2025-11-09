package com.example.lab7;

import com.example.lab7.before.LSPViolation;
import com.example.lab7.refactored.lsp.*;
import java.util.Arrays;
import java.util.List;

/**
 * Демонстрация принципа LSP
 */
public class LSPDemo {

    public static void demonstrateBefore() {
        System.out.println("=== ДО рефакторинга (нарушение LSP) ===");

        LSPViolation.Rectangle rect = new LSPViolation.Rectangle(5, 10);
        System.out.println("Прямоугольник площадь: " + rect.getArea());

        // Проблема: квадрат не может быть заменой прямоугольника
        LSPViolation.Rectangle squareAsRect = new LSPViolation.Square(5);
        squareAsRect.setWidth(10); // Неожиданно меняется и высота!
        System.out.println("Квадрат как прямоугольник площадь: " + squareAsRect.getArea());

        // Проблема с пингвином
        try {
            LSPViolation.Penguin penguin = new LSPViolation.Penguin();
            penguin.fly(); // Выбросит исключение!
        } catch (UnsupportedOperationException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static void demonstrateAfter() {
        System.out.println("\n=== ПОСЛЕ рефакторинга (соблюдение LSP) ===");

        // Теперь фигуры взаимозаменяемы через интерфейс Shape
        List<Shape> shapes = Arrays.asList(
                new Rectangle(5, 10),
                new Square(7)
        );

        for (Shape shape : shapes) {
            System.out.println("Площадь " + shape.getType() + ": " + shape.getArea());
        }

        // Птицы используются корректно
        System.out.println("\n--- Птицы ---");
        FlyingBird sparrow = new Sparrow();
        sparrow.fly(); // Корректно
        sparrow.eat();

        Bird penguin = new Penguin();
        penguin.eat(); // Корректно
        ((Penguin) penguin).swim(); // Специфическое поведение
    }
}