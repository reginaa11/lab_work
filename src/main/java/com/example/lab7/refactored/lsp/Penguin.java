package com.example.lab7.refactored.lsp;

/**
 * Пингвин - нелетающая птица, не реализует FlyingBird
 */
public class Penguin implements Bird {
    @Override
    public void eat() {
        System.out.println("Пингвин ест рыбу");
    }

    @Override
    public String getName() {
        return "Penguin";
    }

    public void swim() {
        System.out.println("Пингвин плавает");
    }
}