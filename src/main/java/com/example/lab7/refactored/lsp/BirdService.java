package com.example.lab7.refactored.lsp;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервис для работы с птицами после рефакторинга LSP
 * Теперь можно безопасно использовать подклассы вместо базовых классов
 */
public class BirdService {

    public void careForAllBirds(List<Bird> birds) {
        System.out.println("\n=== УХОД ЗА ВСЕМИ ПТИЦАМИ ===");
        for (Bird bird : birds) {
            System.out.println("\nЗабота о " + bird.getName() + ":");
            bird.eat();
            bird.makeSound();
            bird.sleep();
        }
    }

    public void letFlyingBirdsFly(List<FlyingBird> flyingBirds) {
        System.out.println("\n=== ПОЛЕТ ЛЕТАЮЩИХ ПТИЦ ===");
        for (FlyingBird bird : flyingBirds) {
            System.out.println("\n" + bird.getName() + " готовится к полету:");
            bird.fly();
            bird.fly(15); // Полет на 15 км
        }
    }

    public void letNonFlyingBirdsMove(List<NonFlyingBird> nonFlyingBirds) {
        System.out.println("\n=== ПЕРЕДВИЖЕНИЕ НЕЛЕТАЮЩИХ ПТИЦ ===");
        for (NonFlyingBird bird : nonFlyingBirds) {
            System.out.println("\n" + bird.getName() + " передвигается:");
            bird.move();

            // Используем специфические методы для каждого типа
            if (bird instanceof Ostrich) {
                ((Ostrich) bird).run(60);
            } else if (bird instanceof Penguin) {
                ((Penguin) bird).swim();
            }
        }
    }

    // Демонстрация принципа LSP - можем передавать любых птиц
    public void demonstrateLSP() {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ LSP ===");

        List<Bird> allBirds = new ArrayList<>();
        allBirds.add(new Sparrow("Воробей Вася", 0.03));
        allBirds.add(new Eagle("Орел Степан", 5.0));
        allBirds.add(new Ostrich("Страус Олег", 120.0));
        allBirds.add(new Penguin("Пингвин Петя", 25.0));

        // Все птицы могут есть, спать и издавать звуки (LSP)
        careForAllBirds(allBirds);

        // Только летающие птицы могут летать
        List<FlyingBird> flyingBirds = new ArrayList<>();
        flyingBirds.add(new Sparrow("Воробей Коля", 0.035));
        flyingBirds.add(new Eagle("Орел Михаил", 4.5));

        letFlyingBirdsFly(flyingBirds);

        // Только нелетающие птицы используют свои методы передвижения
        List<NonFlyingBird> nonFlyingBirds = new ArrayList<>();
        nonFlyingBirds.add(new Ostrich("Страус Геннадий", 110.0));
        nonFlyingBirds.add(new Penguin("Пингвин Семен", 28.0));

        letNonFlyingBirdsMove(nonFlyingBirds);
    }
}