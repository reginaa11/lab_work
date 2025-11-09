package com.example.lab7.refactored.ocp;

import java.util.List;

/**
 * Калькулятор площадей - закрыт для изменений, открыт для расширения
 * Не требует изменений при добавлении новых фигур
 */
public class AreaCalculator {

    public double calculateTotalArea(List<Shape> shapes) {
        double totalArea = 0;

        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
            System.out.println("Площадь " + shape.getName() + ": " + shape.calculateArea());
        }

        return totalArea;
    }
}