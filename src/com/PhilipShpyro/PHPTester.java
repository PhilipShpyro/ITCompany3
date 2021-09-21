package com.PhilipShpyro;

public class PHPTester extends Tester{
    public PHPTester(String firstName, String lastName, int speed) {
        super(firstName, lastName, speed);
    }

    @Override
    public TechnologyType getTechnologyType() {
        return TechnologyType.PHP;
    }

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.TESTER;
    }
}
