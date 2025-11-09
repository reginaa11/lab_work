package com.example.lab7.refactored.lsp;


public abstract class NonFlyingBird extends Bird {

    public NonFlyingBird(String name, double weight) {
        super(name, weight);
    }

    // Нелетающие птицы имеют свои уникальные методы
    public abstract void move();
}