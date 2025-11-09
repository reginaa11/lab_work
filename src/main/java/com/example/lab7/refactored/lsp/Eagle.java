package com.example.lab7.refactored.lsp;

/**
 * Орел - летающая птица (LSP)
 */
public class Eagle extends FlyingBird {

    public Eagle(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void fly() {
        System.out.println(name + " парит высоко в небе, высматривая добычу");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " издает клич: Kreee-eee!");
    }

    public void hunt() {
        System.out.println(name + " охотится на мелких животных");
    }
}