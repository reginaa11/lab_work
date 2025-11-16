package com.example.lab3;

import java.util.Iterator;

public class PrimesGenerator implements Iterable<Integer> {
    private final int count;

    public PrimesGenerator(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Количество должно быть положительным");
        }
        this.count = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new PrimesIterator();
    }

    private class PrimesIterator implements Iterator<Integer> {
        private int generatedCount = 0;
        private int currentNumber = 2;

        @Override
        public boolean hasNext() {
            return generatedCount < count;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }

            while (!isPrime(currentNumber)) {
                currentNumber++;
            }

            int prime = currentNumber;
            currentNumber++;
            generatedCount++;
            return prime;
        }

        private boolean isPrime(int number) {
            if (number < 2) return false;
            if (number == 2) return true;
            if (number % 2 == 0) return false;

            for (int i = 3; i * i <= number; i += 2) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}