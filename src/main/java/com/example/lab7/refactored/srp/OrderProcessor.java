package com.example.lab7.refactored.srp;

/**
 * Класс отвечает только за обработку заказа
 * Координирует работу специализированных сервисов
 */
public class OrderProcessor {
    private final OrderValidator validator;
    private final OrderRepository repository;
    private final NotificationService notificationService;
    private final ReportService reportService;

    public OrderProcessor(OrderValidator validator,
                          OrderRepository repository,
                          NotificationService notificationService,
                          ReportService reportService) {
        this.validator = validator;
        this.repository = repository;
        this.notificationService = notificationService;
        this.reportService = reportService;
    }

    public void processOrder(String orderId) {
        // Валидация
        if (!validator.validate(orderId)) {
            return;
        }

        String orderData = "Данные заказа " + orderId;
        System.out.println("Обрабатываю заказ: " + orderId);

        // Сохранение
        repository.save(orderData);

        // Уведомления
        notificationService.sendEmailNotification(orderData);
        notificationService.sendSmsNotification(orderData);

        // Отчет
        reportService.generateReport(orderData);
    }
}