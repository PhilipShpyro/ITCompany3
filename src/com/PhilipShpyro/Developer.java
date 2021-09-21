package com.PhilipShpyro;

import java.util.Comparator;

public class Developer implements Comparator<Developer> {
    private int speed;
    private Team team;

    public Developer(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setTeam(Team team) {
        if (this.team == null) {
            this.team = team;
        }
    }

    public Team getTeam() {
        return team;
    }

    public int compare(Developer d1, Developer d2) {
        if (d1.getSpeed() == d2.getSpeed()) {
            return 0;
        }

        return d1.getSpeed() > d2.getSpeed() ? 1 : -1;
    }
}
