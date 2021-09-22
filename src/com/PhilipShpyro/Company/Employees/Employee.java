package com.PhilipShpyro.Company.Employees;

import com.PhilipShpyro.Company.Technologies.ITechnology;

public abstract class Employee implements ITechnology, IEmployee {
    private String firstName, lastName;
    private Seniority seniority;
    private Team team;

    public Employee(String firstName, String lastName, int speed) {
        if (speed < 1 || speed > 1000) {
            throw new IllegalArgumentException("Seniority level must be in range from 1 to 1000.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        seniority = new Seniority(speed);
    }

    public int getSpeed() {
        return seniority.getSpeed();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setCurrentTeam(Team team) {
        this.team = team;
    }

    public Team getCurrentTeam() {
        return team;
    }
}
