package com.example.lab3;

import java.util.*;

public class MapUtils {

    /**
     * Меняет местами ключи и значения в Map
     * Если значения не уникальны, объединяет ключи в список
     *
     * @param originalMap исходная Map
     * @return новая Map с поменянными ключами и значениями
     * @throws IllegalArgumentException если значения не могут быть ключами
     */
    public static <K, V> Map<V, List<K>> swapMap(Map<K, V> originalMap) {
        if (originalMap == null) {
            throw new IllegalArgumentException("Исходная Map не может быть null");
        }

        Map<V, List<K>> swappedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            K originalKey = entry.getKey();
            V originalValue = entry.getValue();

            // Проверяем, что значение может быть ключом
            if (originalValue == null) {
                throw new IllegalArgumentException("Значения не могут быть null");
            }

            // Добавляем исходный ключ в список для этого значения
            swappedMap.computeIfAbsent(originalValue, k -> new ArrayList<>())
                    .add(originalKey);
        }

        return swappedMap;
    }

    public void demonstrateMapSwapping() {
        System.out.println("\n=== ЗАДАНИЕ 5: ОБРАЩЕНИЕ MAP ===\n");

        // Пример 1: Map с уникальными значениями
        System.out.println("Пример 1: Map с уникальными значениями");
        Map<String, Integer> uniqueMap = Map.of(
                "Яблоко", 1,
                "Банан", 2,
                "Апельсин", 3
        );
        System.out.println("Исходная Map: " + uniqueMap);

        Map<Integer, List<String>> swappedUnique = swapMap(uniqueMap);
        System.out.println("Обращенная Map: " + swappedUnique);

        // Пример 2: Map с дублирующимися значениями
        System.out.println("\nПример 2: Map с дублирующимися значениями");
        Map<String, String> duplicateMap = new HashMap<>();
        duplicateMap.put("Иванов", "Инженер");
        duplicateMap.put("Петров", "Программист");
        duplicateMap.put("Сидоров", "Инженер");
        duplicateMap.put("Кузнецов", "Менеджер");

        System.out.println("Исходная Map: " + duplicateMap);

        Map<String, List<String>> swappedDuplicate = swapMap(duplicateMap);
        System.out.println("Обращенная Map: " + swappedDuplicate);

        // Пример 3: Map с числами
        System.out.println("\nПример 3: Map с числовыми значениями");
        Map<Integer, Double> numberMap = Map.of(
                1, 10.5,
                2, 20.3,
                3, 10.5,
                4, 30.7
        );
        System.out.println("Исходная Map: " + numberMap);

        Map<Double, List<Integer>> swappedNumber = swapMap(numberMap);
        System.out.println("Обращенная Map: " + swappedNumber);
    }
}