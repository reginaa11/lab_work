package com.example.lab7.refactored.lsp;

/**
 * Воробей - летающая птица
 */
public class Sparrow implements FlyingBird {
    @Override
    public void fly() {
        System.out.println("Воробей летит");
    }

    @Override
    public void eat() {
        System.out.println("Воробей ест");
    }

    @Override
    public String getName() {
        return "Sparrow";
    }
}
