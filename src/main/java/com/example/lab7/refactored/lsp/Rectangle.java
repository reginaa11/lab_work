package com.example.lab7.refactored.lsp;

/**
 * Прямоугольник с независимыми шириной и высотой
 */
public class Rectangle implements Shape {
    protected double width;
    protected double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String getType() {
        return "Rectangle";
    }

    public double getWidth() { return width; }
    public double getHeight() { return height; }
}