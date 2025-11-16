package com.example.lab8;

import com.example.lab8.dip.EmailSender;
import com.example.lab8.dip.NotificationService;
import com.example.lab8.dip.SmsSender;
import com.example.lab8.isp.OldPrinter;
import com.example.lab8.isp.Printer;
import com.example.lab8.lsp.Bird;
import com.example.lab8.lsp.Penguin;
import com.example.lab8.lsp.Sparrow;
import com.example.lab8.ocp.DiscountCalculator;
import com.example.lab8.srp.ReportManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ---------- S ----------
        ReportManager manager = new ReportManager(List.of(5, 10, 15, 20));
        manager.generateReport();

        // ---------- O ----------
        DiscountCalculator calculator = new DiscountCalculator();
        System.out.println("Regular: " + calculator.calculateDiscount("regular", 1000));
        System.out.println("VIP: " + calculator.calculateDiscount("vip", 1000));
        System.out.println("Super VIP: " + calculator.calculateDiscount("super_vip", 1000));

        // ---------- L ----------
        displayBird(new Sparrow());
        // displayBird(new Penguin());     // Здесь будет исключение(закоментил чтобы не блокировал код ниже)

        // ---------- I ----------
        Printer printer = new OldPrinter();
        printer.print("Отчёт за неделю");

        // ---------- D ----------
        NotificationService emailService = new NotificationService(new EmailSender());
        emailService.send("Ваш заказ готов к выдаче!");
        // Проверка SmsSender
        NotificationService smsService = new NotificationService(new SmsSender());
        smsService.send("Ваш заказ готов к выдаче!");
    }

    public static void displayBird(Bird bird) {
        bird.eat();
        bird.fly();
    }
}