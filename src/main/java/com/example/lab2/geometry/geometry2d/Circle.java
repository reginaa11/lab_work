package com.example.lab2.geometry.geometry2d;

import com.example.lab2.geometry.exceptions.GeometryException;

public class Circle implements Figure {
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new GeometryException("Радиус должен быть положительным числом: " + radius);
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return String.format("Circle[radius=%.2f, area=%.2f, perimeter=%.2f]",
                radius, area(), perimeter());
    }

    public double getRadius() {
        return radius;
    }
}