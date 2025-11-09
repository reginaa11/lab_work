package com.example.lab7.refactored.lsp;

/**
 * Квадрат - не наследует прямоугольник, но реализует общий интерфейс
 * Теперь может использоваться взаимозаменяемо с другими фигурами
 */
public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String getType() {
        return "Square";
    }

    public double getSide() { return side; }
}