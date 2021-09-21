package com.PhilipShpyro;

public class Seniority {
    int level;

    public Seniority(int level) {
        if (level < 1 || level > 1000) {
            throw new IllegalArgumentException("Seniority level must be in range from 1 to 1000.");
        }

        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
