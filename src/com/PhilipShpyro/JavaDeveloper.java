package com.PhilipShpyro;

public class JavaDeveloper extends Developer {

    public JavaDeveloper(String firstName, String lastName, int speed) {
        super(firstName, lastName, speed);
    }

    @Override
    public TechnologyType getTechnologyType() {
        return TechnologyType.JAVA;
    }

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.DEVELOPER;
    }
}
