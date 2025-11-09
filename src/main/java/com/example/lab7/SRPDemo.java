package com.example.lab7;

import com.example.lab7.before.SRPViolation;
import com.example.lab7.refactored.srp.*;

/**
 * Демонстрация принципа SRP
 */
public class SRPDemo {

    public static void demonstrateBefore() {
        System.out.println("=== ДО рефакторинга (нарушение SRP) ===");
        SRPViolation badProcessor = new SRPViolation();
        badProcessor.processOrder("ORDER-123");
    }

    public static void demonstrateAfter() {
        System.out.println("\n=== ПОСЛЕ рефакторинга (соблюдение SRP) ===");

        OrderProcessor goodProcessor = new OrderProcessor(
                new OrderValidator(),
                new OrderRepository(),
                new NotificationService(),
                new ReportService()
        );

        goodProcessor.processOrder("ORDER-456");
    }
}