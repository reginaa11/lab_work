package com.example.lab3;

import java.util.*;

public class WordFrequencyAnalyzer {

    public void analyzeText(String text) {
        System.out.println("\n=== ЗАДАНИЕ 4: ПОДСЧЕТ ЧАСТОТЫ СЛОВ ===\n");

        System.out.println("Исходный текст:");
        System.out.println(text);

        // Выделяем все различные слова (игнорируя регистр)
        Map<String, Integer> wordFrequency = countWordFrequency(text);

        System.out.println("\nРезультат анализа:");
        System.out.println("Всего различных слов: " + wordFrequency.size());

        // Выводим слова и их частоту в алфавитном порядке
        wordFrequency.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry ->
                        System.out.printf("'%s' -> %d раз(а)%n", entry.getKey(), entry.getValue())
                );
    }

    private Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        if (text == null || text.trim().isEmpty()) {
            return frequencyMap;
        }

        // Разбиваем текст на слова: учитываем только буквы и апострофы
        String[] words = text.toLowerCase().split("[^a-zA-Z']+");

        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        return frequencyMap;
    }
}