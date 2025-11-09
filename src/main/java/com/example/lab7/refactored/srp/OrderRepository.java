package com.example.lab7.refactored.srp;

/**
 * Отвечает только за сохранение заказов
 */
public class OrderRepository {
    public void save(String orderData) {
        System.out.println("Сохраняю в базу данных: " + orderData);
        // Логика сохранения в БД
    }
}