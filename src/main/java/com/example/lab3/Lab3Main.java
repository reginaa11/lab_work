package com.example.lab3;

/**
 * Основной класс для тестирования лабораторной работы 3
 * Симоненко Регина Фит241
 */
public class Lab3Main {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("Лабораторная работа 3");
        System.out.println("Коллекции и компараторы в Java");
        System.out.println("Студент: Симоненко Регина");
        System.out.println("Группа: Фит241");
        System.out.println("=========================================\n");

        // Задание 1: Работа с Collections
        executeTask1();

        // Задание 2: Генератор простых чисел
        executeTask2();

        // Задание 3: Класс Human и компараторы
        executeTask3();

        // Задание 4: Подсчет частоты слов
        executeTask4();

        // Задание 5: Обращение Map
        executeTask5();

        System.out.println("\n=========================================");
        System.out.println("Лабораторная работа 3 завершена!");
        System.out.println("=========================================");
    }

    private static void executeTask1() {
        CollectionsDemo collectionsDemo = new CollectionsDemo();
        collectionsDemo.demonstrateCollectionsMethods();
    }

    private static void executeTask2() {
        PrimesGeneratorTest primesTest = new PrimesGeneratorTest();
        primesTest.testPrimesGenerator();
    }

    private static void executeTask3() {
        HumanCollectionsDemo humanDemo = new HumanCollectionsDemo();
        humanDemo.demonstrateHumanCollections();
    }

    private static void executeTask4() {
        WordFrequencyAnalyzer analyzer = new WordFrequencyAnalyzer();
        String text = "The quick brown fox jumps over the lazy dog. " +
                "The dog was lazy but the fox was quick and brown. " +
                "Quick and brown fox jumps over lazy dog again.";
        analyzer.analyzeText(text);
    }

    private static void executeTask5() {
        MapUtils mapUtils = new MapUtils();
        mapUtils.demonstrateMapSwapping();
    }
}