package com.example.lab2.basic;

import java.util.ArrayList;
import java.util.List;


public class OddEvenSeparator {
    private final List<Integer> numbers;

    public OddEvenSeparator() {
        this.numbers = new ArrayList<>();
    }

    public void addNumber(int number) {
        numbers.add(number);
    }

    public void even() {
        System.out.print("Четные числа: ");
        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    public void odd() {
        System.out.print("Нечетные числа: ");
        for (int number : numbers) {
            if (number % 2 != 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }
}