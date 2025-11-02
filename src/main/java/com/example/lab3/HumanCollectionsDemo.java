package com.example.lab3;

import java.util.*;

public class HumanCollectionsDemo {

    public void demonstrateHumanCollections() {
        System.out.println("\n=== ЗАДАНИЕ 3: РАБОТА С COLLECTIONS ДЛЯ HUMAN ===\n");

        // Создаем список объектов Human
        List<Human> humans = Arrays.asList(
                new Human("Анна", "Иванова", 25),
                new Human("Петр", "Петров", 30),
                new Human("Мария", "Сидорова", 22),
                new Human("Алексей", "Иванов", 25),
                new Human("Ольга", "Петрова", 28)
        );

        System.out.println("Исходный список:");
        humans.forEach(System.out::println);

        // 1. HashSet - не сохраняет порядок, использует hashCode()
        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("\n1. HashSet (порядок не гарантирован):");
        hashSet.forEach(System.out::println);

        // 2. LinkedHashSet - сохраняет порядок вставки
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("\n2. LinkedHashSet (порядок вставки):");
        linkedHashSet.forEach(System.out::println);

        // 3. TreeSet с natural ordering (Comparable)
        Set<Human> treeSetNatural = new TreeSet<>(humans);
        System.out.println("\n3. TreeSet (natural ordering - по фамилии, имени, возрасту):");
        treeSetNatural.forEach(System.out::println);

        // 4. TreeSet с компаратором по фамилии
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorSimonenko());
        treeSetByLastName.addAll(humans);
        System.out.println("\n4. TreeSet (компаратор по фамилии):");
        treeSetByLastName.forEach(System.out::println);

        // 5. TreeSet с анонимным компаратором по возрасту
        Set<Human> treeSetByAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        treeSetByAge.addAll(humans);
        System.out.println("\n5. TreeSet (анонимный компаратор по возрасту):");
        treeSetByAge.forEach(System.out::println);

        // Объяснение различий
        System.out.println("\n=== ОБЪЯСНЕНИЕ РАЗЛИЧИЙ ===");
        System.out.println("• HashSet: порядок не гарантирован, основан на hashCode()");
        System.out.println("• LinkedHashSet: сохраняет порядок добавления элементов");
        System.out.println("• TreeSet (natural): сортировка по compareTo() - фамилия, имя, возраст");
        System.out.println("• TreeSet (по фамилии): сортировка только по фамилии");
        System.out.println("• TreeSet (по возрасту): сортировка только по возрасту");
    }
}