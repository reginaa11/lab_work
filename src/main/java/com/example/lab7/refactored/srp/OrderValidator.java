package com.example.lab7.refactored.srp;

/**
 * Отвечает только за валидацию заказов
 */
public class OrderValidator {
    public boolean validate(String orderId) {
        if (orderId == null || orderId.isEmpty()) {
            System.out.println("Ошибка: неверный ID заказа");
            return false;
        }
        System.out.println("Заказ прошел валидацию: " + orderId);
        return true;
    }
}