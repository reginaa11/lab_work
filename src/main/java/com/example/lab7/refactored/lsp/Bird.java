package com.example.lab7.refactored.lsp;

public abstract class Bird {
    protected String name;
    protected double weight;

    public Bird(String name, double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Вес должен быть положительным");
        }
        this.name = name;
        this.weight = weight;
    }

    // Общие методы для всех птиц
    public void eat() {
        System.out.println(name + " ест");
        weight += 0.1;
    }

    public void sleep() {
        System.out.println(name + " спит");
    }

    public void makeSound() {
        System.out.println(name + " издает звук");
    }

    // Геттеры
    public String getName() { return name; }
    public double getWeight() { return weight; }

    @Override
    public String toString() {
        return String.format("Bird{name='%s', weight=%.2f}", name, weight);
    }
}