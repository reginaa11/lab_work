package com.example.lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimesGeneratorTest {

    public void testPrimesGenerator() {
        System.out.println("\n=== ЗАДАНИЕ 2: ГЕНЕРАТОР ПРОСТЫХ ЧИСЕЛ ===\n");

        int n = 10;
        PrimesGenerator generator = new PrimesGenerator(n);

        // Вывод в прямом порядке
        List<Integer> primes = new ArrayList<>();
        for (int prime : generator) {
            primes.add(prime);
        }

        System.out.println("Первые " + n + " простых чисел (прямой порядок):");
        System.out.println(primes);

        // Вывод в обратном порядке
        List<Integer> reversedPrimes = new ArrayList<>(primes);
        Collections.reverse(reversedPrimes);

        System.out.println("Первые " + n + " простых чисел (обратный порядок):");
        System.out.println(reversedPrimes);
    }
}