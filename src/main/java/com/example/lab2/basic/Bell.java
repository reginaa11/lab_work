package com.example.lab2.basic;

public class Bell {
    private boolean isDing = true;

    public void sound() {
        if (isDing) {
            System.out.println("ding");
        } else {
            System.out.println("dong");
        }
        isDing = !isDing;
    }
}