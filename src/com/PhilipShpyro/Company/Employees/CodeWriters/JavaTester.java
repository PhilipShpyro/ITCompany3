package com.PhilipShpyro.Company.Employees.CodeWriters;

import com.PhilipShpyro.Company.Employees.EmployeeType;
import com.PhilipShpyro.Company.Technologies.TechnologyType;

public class JavaTester extends Tester {
    public JavaTester(String firstName, String lastName, int speed) {
        super(firstName, lastName, speed);
    }

    @Override
    public TechnologyType getTechnologyType() {
        return TechnologyType.JAVA;
    }

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.TESTER;
    }
}
