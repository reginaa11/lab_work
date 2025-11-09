package com.example.lab7.refactored.ocp;

/**
 * Интерфейс для всех фигур
 * Открыт для расширения новыми фигурами
 */
public interface Shape {
    double calculateArea();
    String getName();
}