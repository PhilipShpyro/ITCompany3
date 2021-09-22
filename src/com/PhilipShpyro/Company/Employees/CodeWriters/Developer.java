package com.PhilipShpyro.Company.Employees.CodeWriters;

import com.PhilipShpyro.Company.Employees.Employee;
import com.PhilipShpyro.Company.Employees.Team;

public abstract class Developer extends Employee {
    private int speed;
    private Team team;

    public Developer(String firstName, String lastName, int speed) {
        super(firstName, lastName, speed);
    }
}
