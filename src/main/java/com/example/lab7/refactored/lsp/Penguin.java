package com.example.lab7.refactored.lsp;

/**
 * Пингвин - нелетающая птица (LSP)
 */
public class Penguin extends NonFlyingBird {

    public Penguin(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void move() {
        System.out.println(name + " переваливается при ходьбе");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " издает звук: Гром-гром!");
    }

    public void swim() {
        System.out.println(name + " плавает в холодной воде");
    }

    public void slideOnBelly() {
        System.out.println(name + " скользит на брюхе по льду");
    }
}