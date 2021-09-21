package com.PhilipShpyro;

import java.util.Comparator;

public abstract class Developer extends Employee {
    private int speed;
    private Team team;

    public Developer(String firstName, String lastName, int speed) {
        super(firstName, lastName, speed);
    }
}
