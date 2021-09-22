package com.PhilipShpyro.Company.Employees;

public class Seniority {
    private int speed;

    public Seniority(int speed) {
        if (speed < 1 || speed > 1000) {
            throw new IllegalArgumentException("Work speed must be in range from 1 to 1000.");
        }

        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
