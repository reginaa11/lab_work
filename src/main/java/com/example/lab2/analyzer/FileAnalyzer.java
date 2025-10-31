package com.example.lab2.analyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Анализатор текстовых файлов
 * Задание 7
 */
public class FileAnalyzer {

    public static class AnalysisResult {
        private final int lines;
        private final int words;
        private final int characters;

        public AnalysisResult(int lines, int words, int characters) {
            this.lines = lines;
            this.words = words;
            this.characters = characters;
        }

        public int getLines() { return lines; }
        public int getWords() { return words; }
        public int getCharacters() { return characters; }

        @Override
        public String toString() {
            return String.format("Строк: %d\nСлов: %d\nСимволов: %d", lines, words, characters);
        }
    }

    public AnalysisResult analyze(String filename) {
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                wordCount += countWords(line);
                charCount += countCharacters(line);
            }

            return new AnalysisResult(lineCount, wordCount, charCount);

        } catch (IOException e) {
            System.out.println("Файл не найден!");
            return null;
        }
    }

    private int countWords(String line) {
        if (line == null || line.trim().isEmpty()) {
            return 0;
        }
        String trimmedLine = line.trim();
        return trimmedLine.split("\\s+").length;
    }

    private int countCharacters(String line) {
        if (line == null) {
            return 0;
        }
        return line.replaceAll("\\s", "").length();
    }
}