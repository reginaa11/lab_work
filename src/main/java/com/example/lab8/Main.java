import com.example.lab7.dip.NotificationService;
import com.example.lab7.isp.Machine;
import com.example.lab7.isp.OldPrinter;
import com.example.lab7.lsp.Bird;
import com.example.lab7.lsp.Penguin;
import com.example.lab7.lsp.Sparrow;
import com.example.lab7.ocp.DiscountCalculator;
import com.example.lab7.srp.ReportManager;

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
        displayBird(new Penguin());     // Здесь будет исключение

        // ---------- I ----------
        Machine printer = new OldPrinter();
        printer.print("Отчёт за неделю");

        // ---------- D ----------
        NotificationService service = new NotificationService();
        service.send("Ваш заказ готов к выдаче!");
    }

    public static void displayBird(Bird bird) {
        bird.eat();
        bird.fly();
    }
}