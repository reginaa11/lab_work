package com.example.lab7.before;

/**
 * Класс с нарушением SRP - выполняет слишком много обязанностей
 * Отвечает за обработку заказа, валидацию, сохранение, уведомления и отчеты
 */
public class SRPViolation {
    private String orderData;

    public void processOrder(String orderId) {
        // 1. Валидация заказа
        if (orderId == null || orderId.isEmpty()) {
            System.out.println("Ошибка: неверный ID заказа");
            return;
        }

        // 2. Бизнес-логика обработки
        System.out.println("Обрабатываю заказ: " + orderId);
        this.orderData = "Данные заказа " + orderId;

        // 3. Сохранение в базу данных
        saveToDatabase();

        // 4. Отправка уведомлений
        sendEmailNotification();
        sendSmsNotification();

        // 5. Генерация отчетов
        generateReport();

        // 6. Очистка данных
        cleanup();
    }

    private void saveToDatabase() {
        System.out.println("Сохраняю в базу данных: " + orderData);
        // Логика сохранения в БД
    }

    private void sendEmailNotification() {
        System.out.println("Отправляю email уведомление: " + orderData);
        // Логика отправки email
    }

    private void sendSmsNotification() {
        System.out.println("Отправляю SMS уведомление: " + orderData);
        // Логика отправки SMS
    }

    private void generateReport() {
        System.out.println("Генерирую отчет по заказу: " + orderData);
        // Логика генерации отчета
    }

    private void cleanup() {
        System.out.println("Выполняю очистку данных");
        this.orderData = null;
    }

    // Дополнительные методы, нарушающие SRP
    public void validateOrder(String orderId) {
        if (orderId == null) {
            throw new IllegalArgumentException("Order ID cannot be null");
        }
    }

    public void calculateShippingCosts() {
        System.out.println("Рассчитываю стоимость доставки");
        // Логика расчета доставки
    }
}