package com.example.lab7.before;

/**
 * Класс с нарушением SRP - слишком много ответственностей
 */
public class OrderProcessor {
    private String orderId;
    private double amount;
    private String customerEmail;

    public OrderProcessor(String orderId, double amount, String customerEmail) {
        this.orderId = orderId;
        this.amount = amount;
        this.customerEmail = customerEmail;
    }

    // Нарушение SRP: обработка заказа
    public void processOrder() {
        validateOrder();
        calculateTax();
        applyDiscount();
        saveToDatabase();
        generateInvoice();
        sendNotification();
        updateInventory();
        System.out.println("Заказ " + orderId + " обработан");
    }

    private void validateOrder() {
        System.out.println("Валидация заказа " + orderId);
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма заказа должна быть положительной");
        }
    }

    private void calculateTax() {
        double tax = amount * 0.2;
        System.out.println("Налог рассчитан: " + tax);
    }

    private void applyDiscount() {
        if (amount > 1000) {
            amount *= 0.9;
            System.out.println("Применена скидка 10%");
        }
    }

    private void saveToDatabase() {
        System.out.println("Сохранение заказа " + orderId + " в базу данных");
    }

    private void generateInvoice() {
        System.out.println("Генерация счета для заказа " + orderId);
    }

    private void sendNotification() {
        System.out.println("Отправка уведомления на email: " + customerEmail);
    }

    private void updateInventory() {
        System.out.println("Обновление инвентаря для заказа " + orderId);
    }

    // Геттеры
    public String getOrderId() { return orderId; }
    public double getAmount() { return amount; }
    public String getCustomerEmail() { return customerEmail; }
}