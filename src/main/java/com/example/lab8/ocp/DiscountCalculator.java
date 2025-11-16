package com.example.lab7.ocp;

/**
 * Подсказка:
 * Каждый раз, когда появляется новый тип пользователя (например, student или employee),
 * придётся лезть в код метода и добавлять новое условие if.
 * Вспомните задание из предыдущих лабораторных с фигурами.
 */
public class DiscountCalculator {
    public double calculateDiscount(String userType, double price) {
        switch (userType) {
            case "regular":
                return price * 0.05;
            case "vip":
                return price * 0.1;
            case "super_vip":
                return price * 0.2;
            default:
                return 0.0;
        }
    }
}