package com.example.lab7.refactored.ocp;

/**
 * Новая фигура - можно добавить без изменения AreaCalculator
 */
public class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String getName() {
        return "Triangle";
    }

    public double getBase() { return base; }
    public double getHeight() { return height; }
}