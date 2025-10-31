package com.example.lab2.geometry.geometry3d;

import com.example.lab2.geometry.geometry2d.Figure;
import com.example.lab2.geometry.exceptions.InvalidDimensionException;

/**
 * Класс цилиндра
 * Задание 6
 */
public class Cylinder {
    private final Figure base;
    private final double height;

    public Cylinder(Figure base, double height) {
        if (height <= 0) {
            throw new InvalidDimensionException("Высота цилиндра должна быть положительной: " + height);
        }
        this.base = base;
        this.height = height;
    }

    public double volume() {
        return base.area() * height;
    }

    public double getHeight() {
        return height;
    }

    public Figure getBase() {
        return base;
    }

    @Override
    public String toString() {
        return String.format("Cylinder[base=%s, height=%.2f, volume=%.2f]",
                base, height, volume());
    }
}