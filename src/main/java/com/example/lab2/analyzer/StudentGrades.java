package com.example.lab2.analyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Анализатор оценок студентов
 * Задание 8
 */
public class StudentGrades {

    public static class StudentResult {
        private final String name;
        private final double averageGrade;
        private final List<Integer> grades;

        public StudentResult(String name, List<Integer> grades) {
            this.name = name;
            this.grades = new ArrayList<>(grades);
            this.averageGrade = calculateAverage(grades);
        }

        public String getName() { return name; }
        public double getAverageGrade() { return averageGrade; }
        public List<Integer> getGrades() { return new ArrayList<>(grades); }

        private double calculateAverage(List<Integer> grades) {
            if (grades.isEmpty()) {
                return 0.0;
            }
            int sum = 0;
            for (int grade : grades) {
                sum += grade;
            }
            return (double) sum / grades.size();
        }

        @Override
        public String toString() {
            return String.format("%s: %.2f", name, averageGrade);
        }
    }

    public List<StudentResult> analyze(String filename) {
        Map<String, List<Integer>> students = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processStudentLine(line, students);
            }
        } catch (IOException e) {
            System.out.println("Файл не найден!");
            return new ArrayList<>();
        }

        return calculateResults(students);
    }

    private void processStudentLine(String line, Map<String, List<Integer>> students) {
        String[] parts = line.split("\\s+");
        if (parts.length < 2) {
            return;
        }

        String name = parts[0];
        List<Integer> grades = new ArrayList<>();

        for (int i = 1; i < parts.length; i++) {
            try {
                int grade = Integer.parseInt(parts[i]);
                if (grade >= 1 && grade <= 5) {
                    grades.add(grade);
                }
            } catch (NumberFormatException e) {
                // Пропускаем некорректные оценки
            }
        }

        if (!grades.isEmpty()) {
            students.put(name, grades);
        }
    }

    private List<StudentResult> calculateResults(Map<String, List<Integer>> students) {
        List<StudentResult> results = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : students.entrySet()) {
            results.add(new StudentResult(entry.getKey(), entry.getValue()));
        }
        return results;
    }

    public String bestStudent(List<StudentResult> results) {
        if (results.isEmpty()) {
            return "Нет студентов";
        }

        StudentResult best = results.get(0);
        for (StudentResult result : results) {
            if (result.getAverageGrade() > best.getAverageGrade()) {
                best = result;
            }
        }
        return best.getName();
    }

    public String worstStudent(List<StudentResult> results) {
        if (results.isEmpty()) {
            return "Нет студентов";
        }

        StudentResult worst = results.get(0);
        for (StudentResult result : results) {
            if (result.getAverageGrade() < worst.getAverageGrade()) {
                worst = result;
            }
        }
        return worst.getName();
    }
}