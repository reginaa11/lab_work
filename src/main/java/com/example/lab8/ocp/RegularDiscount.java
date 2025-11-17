package com.example.lab8.ocp;

public class RegularDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.05;
    }
}