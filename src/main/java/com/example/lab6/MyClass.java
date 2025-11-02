package com.example.lab6;

public class MyClass {

    // Публичные методы
    public void publicMethod1() {
        System.out.println("Вызван публичный метод 1");
    }

    public String publicMethod2(String name) {
        String result = "Привет, " + name + "! (публичный метод 2)";
        System.out.println(result);
        return result;
    }

    // Защищенные методы
    @Repeat(times = 2)
    protected void protectedMethod1() {
        System.out.println("Вызван защищенный метод 1");
    }

    protected int protectedMethod2(int a, int b) {
        int sum = a + b;
        System.out.println("Защищенный метод 2: " + a + " + " + b + " = " + sum);
        return sum;
    }

    // Приватные методы
    @Repeat(times = 3)
    private void privateMethod1() {
        System.out.println("Вызван приватный метод 1");
    }

    @Repeat(times = 2)
    private String privateMethod2(String text, int count) {
        String result = "Приватный метод 2: " + text.repeat(count);
        System.out.println(result);
        return result;
    }

    private double privateMethod3(double x, double y) {
        double product = x * y;
        System.out.println("Приватный метод 3: " + x + " * " + y + " = " + product);
        return product;
    }

    // Еще один публичный метод без аннотации
    public void publicMethodWithoutAnnotation() {
        System.out.println("Публичный метод без аннотации");
    }
}