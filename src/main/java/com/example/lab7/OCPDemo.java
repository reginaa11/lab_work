package com.example.lab7;

import com.example.lab7.before.OCPViolation;
import com.example.lab7.refactored.ocp.*;
import java.util.Arrays;
import java.util.List;

/**
 * Демонстрация принципа OCP
 */
public class OCPDemo {

    public static void demonstrateBefore() {
        System.out.println("=== ДО рефакторинга (нарушение OCP) ===");

        OCPViolation badCalculator = new OCPViolation();
        List<Object> shapes = Arrays.asList(
                new OCPViolation.Rectangle(5, 10),
                new OCPViolation.Circle(7)
        );

        double area = badCalculator.calculateTotalArea(shapes);
        System.out.println("Общая площадь: " + area);
    }

    public static void demonstrateAfter() {
        System.out.println("\n=== ПОСЛЕ рефакторинга (соблюдение OCP) ===");

        AreaCalculator goodCalculator = new AreaCalculator();
        List<Shape> shapes = Arrays.asList(
                new Rectangle(5, 10),
                new Circle(7),
                new Triangle(6, 8)  // Легко добавить новую фигуру!
        );

        double totalArea = goodCalculator.calculateTotalArea(shapes);
        System.out.println("\nОбщая площадь всех фигур: " + totalArea);
    }
}
