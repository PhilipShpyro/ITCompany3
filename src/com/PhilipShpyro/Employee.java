package com.PhilipShpyro;

public abstract class Employee implements ITechnology {
    private String firstName, lastName;
    private Seniority seniority;

    public Employee(String firstName, String lastName, int seniorityLevel) {
        if (seniorityLevel < 1 || seniorityLevel > 1000) {
            throw new IllegalArgumentException("Seniority level must be in range from 1 to 1000.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        seniority = new Seniority(seniorityLevel);
    }

    public abstract TechnologyType getTechnologyType();
}
