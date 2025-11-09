package com.example.lab;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос имени
        System.out.println("What is your name?");
        System.out.print("> ");

        // Чтение ввода
        String name = scanner.nextLine().trim();

        // Вывод приветствия
        System.out.println("Hello, " + name + "!");

        scanner.close();
    }
}