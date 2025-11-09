package com.example.lab7.refactored.lsp;

/**
 * Страус - нелетающая птица (LSP)
 */
public class Ostrich extends NonFlyingBird {

    public Ostrich(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void move() {
        System.out.println(name + " быстро бежит по саванне");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " издает звук: Бум-бум!");
    }

    public void hideHead() {
        System.out.println(name + " прячет голову в песок");
    }

    public void run(int speed) {
        System.out.println(name + " бежит со скоростью " + speed + " км/ч");
    }
}