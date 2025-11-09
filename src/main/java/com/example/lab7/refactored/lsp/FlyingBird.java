package com.example.lab7.refactored.lsp;


public abstract class FlyingBird extends Bird {

    public FlyingBird(String name, double weight) {
        super(name, weight);
    }

    // Метод fly теперь есть только у летающих птиц
    public abstract void fly();

    public void fly(int distance) {
        System.out.println(name + " летит на расстояние " + distance + " км");
        if (distance > 10) {
            weight -= 0.05; // Тратит энергию на длительные перелеты
        }
    }
}