package com.example.lab2.geometry.geometry2d;

import com.example.lab2.geometry.exceptions.GeometryException;

/**
 * Класс прямоугольника
 * Задание 6
 */
public class Rectangle implements Figure {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new GeometryException(
                    String.format("Ширина и высота должны быть положительными: width=%.2f, height=%.2f",
                            width, height)
            );
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return String.format("Rectangle[width=%.2f, height=%.2f, area=%.2f, perimeter=%.2f]",
                width, height, area(), perimeter());
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}