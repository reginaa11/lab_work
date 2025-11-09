package com.example.lab7.refactored.lsp;


public class Sparrow extends FlyingBird {

    public Sparrow(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void fly() {
        System.out.println(name + " быстро машет крыльями и взлетает");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " чирикает: Чик-чирик!");
    }

    public void buildNest() {
        System.out.println(name + " строит гнездо из веточек и травы");
    }
}