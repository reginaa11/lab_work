package com.example.lab7;

/**
 * Главный класс для демонстрации лабораторной работы 7
 * Принципы SOLID: SRP, OCP, LSP
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("Лабораторная работа 7: Принципы SOLID");
        System.out.println("SRP, OCP, LSP");
        System.out.println("=========================================\n");

        // Демонстрация SRP
        System.out.println("1. ПРИНЦИП ЕДИНСТВЕННОЙ ОТВЕТСТВЕННОСТИ (SRP)");
        System.out.println("=================================================");
        SRPDemo.demonstrateBefore();
        SRPDemo.demonstrateAfter();

        // Демонстрация OCP
        System.out.println("\n\n2. ПРИНЦИП ОТКРЫТОСТИ/ЗАКРЫТОСТИ (OCP)");
        System.out.println("===========================================");
        OCPDemo.demonstrateBefore();
        OCPDemo.demonstrateAfter();

        // Демонстрация LSP
        System.out.println("\n\n3. ПРИНЦИП ПОДСТАНОВКИ ЛИСКОВ (LSP)");
        System.out.println("=======================================");
        LSPDemo.demonstrateBefore();
        LSPDemo.demonstrateAfter();

        System.out.println("\n\n=========================================");
        System.out.println("Демонстрация завершена!");
        System.out.println("Все принципы SOLID успешно применены");
        System.out.println("=========================================");
    }
}