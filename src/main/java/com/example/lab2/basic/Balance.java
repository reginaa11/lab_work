package com.example.lab2.basic;

public class Balance {
    private int leftWeight;
    private int rightWeight;

    public Balance() {
        this.leftWeight = 0;
        this.rightWeight = 0;
    }

    public void addLeft(int weight) {
        if (weight > 0) {
            leftWeight += weight;
        }
    }

    public void addRight(int weight) {
        if (weight > 0) {
            rightWeight += weight;
        }
    }

    public String result() {
        if (leftWeight > rightWeight) {
            return "L";
        } else if (rightWeight > leftWeight) {
            return "R";
        } else {
            return "=";
        }
    }

    public int getLeftWeight() {
        return leftWeight;
    }

    public int getRightWeight() {
        return rightWeight;
    }
}