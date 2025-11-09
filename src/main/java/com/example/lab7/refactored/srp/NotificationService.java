package com.example.lab7.refactored.srp;

/**
 * Отвечает только за отправку уведомлений
 */
public class NotificationService {
    public void sendEmailNotification(String orderData) {
        System.out.println("Отправляю email уведомление: " + orderData);
        // Логика отправки email
    }

    public void sendSmsNotification(String orderData) {
        System.out.println("Отправляю SMS уведомление: " + orderData);
        // Логика отправки SMS
    }
}