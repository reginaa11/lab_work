package com.example.lab3;

import java.util.*;

public class CollectionsDemo{

    public void demonstrateCollectionsMethods() {
        System.out.println("=== ЗАДАНИЕ 1: РАБОТА С COLLECTIONS ===\n");

        // 1. Создаем массив из N случайных чисел от 0 до 100
        int n = 15;
        int[] randomArray = createRandomArray(n);
        System.out.println("1. Исходный массив: " + Arrays.toString(randomArray));

        // 2. На основе массива создаем список List
        List<Integer> numbers = new ArrayList<>();
        for (int num : randomArray) {
            numbers.add(num);
        }
        System.out.println("2. Список из массива: " + numbers);

        // 3. Отсортируем список по возрастанию
        Collections.sort(numbers);
        System.out.println("3. Отсортированный по возрастанию: " + numbers);

        // 4. Отсортируем список в обратном порядке
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("4. В обратном порядке: " + numbers);

        // 5. Перемешаем список
        Collections.shuffle(numbers);
        System.out.println("5. Перемешанный список: " + numbers);

        // 6. Выполним циклический сдвиг на 1 элемент
        Collections.rotate(numbers, 1);
        System.out.println("6. Циклический сдвиг вправо: " + numbers);

        // 7. Оставим в списке только уникальные элементы
        Set<Integer> uniqueSet = new LinkedHashSet<>(numbers);
        List<Integer> uniqueNumbers = new ArrayList<>(uniqueSet);
        System.out.println("7. Только уникальные элементы: " + uniqueNumbers);

        // 8. Оставим в списке только дублирующиеся элементы
        List<Integer> duplicates = findDuplicates(numbers);
        System.out.println("8. Только дублирующиеся элементы: " + duplicates);

        // 9. Из списка получим массив
        Integer[] numbersArray = numbers.toArray(new Integer[0]);
        System.out.println("9. Массив из списка: " + Arrays.toString(numbersArray));

        // 10. Подсчитаем количество вхождений каждого числа
        Map<Integer, Integer> frequencyMap = countFrequency(numbers);
        System.out.println("10. Частота вхождений:");
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("   " + entry.getKey() + " -> " + entry.getValue() + " раз(а)");
        }
    }

    private int[] createRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(101); // 0-100
        }
        return array;
    }

    private List<Integer> findDuplicates(List<Integer> list) {
        Map<Integer, Integer> frequency = countFrequency(list);
        List<Integer> duplicates = new ArrayList<>();
        for (Integer num : list) {
            if (frequency.get(num) > 1 && !duplicates.contains(num)) {
                duplicates.add(num);
            }
        }
        return duplicates;
    }

    private Map<Integer, Integer> countFrequency(List<Integer> list) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer num : list) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }
        }
        return frequencyMap;
    }
}