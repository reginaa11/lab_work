package com.example.lab3;

import java.util.Comparator;

public class HumanComparatorSimonenko implements Comparator<Human> {

    @Override
    public int compare(Human h1, Human h2) {
        return h1.getLastName().compareTo(h2.getLastName());
    }
}