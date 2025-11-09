package com.example.lab7.before;

import java.util.List;

/**
 * Класс с нарушением OCP - для добавления новой фигуры нужно изменять код
 */
public class OCPViolation {

    /**
     * Метод нарушает OCP - при добавлении новой фигуры нужно изменять этот метод
     */
    public double calculateTotalArea(List<Object> shapes) {
        double totalArea = 0;

        for (Object shape : shapes) {
            if (shape instanceof Rectangle) {
                Rectangle rect = (Rectangle) shape;
                totalArea += rect.getWidth() * rect.getHeight();
            } else if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                totalArea += Math.PI * circle.getRadius() * circle.getRadius();
            }
            // Проблема: для добавления Triangle нужно добавить еще один if
        }

        return totalArea;
    }

    /**
     * Еще один метод с нарушением OCP
     */
    public void drawShape(String shapeType) {
        if ("circle".equals(shapeType)) {
            drawCircle();
        } else if ("square".equals(shapeType)) {
            drawSquare();
        } else if ("rectangle".equals(shapeType)) {
            drawRectangle();
        }
        // Для новой фигуры нужно добавлять новый condition
    }

    private void drawCircle() {
        System.out.println("Рисую круг");
    }

    private void drawSquare() {
        System.out.println("Рисую квадрат");
    }

    private void drawRectangle() {
        System.out.println("Рисую прямоугольник");
    }

    // Классы фигур
    public static class Rectangle {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getWidth() { return width; }
        public double getHeight() { return height; }
    }

    public static class Circle {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() { return radius; }
    }
}