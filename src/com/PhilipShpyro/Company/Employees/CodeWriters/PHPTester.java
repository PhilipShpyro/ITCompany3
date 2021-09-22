package com.PhilipShpyro.Company.Employees.CodeWriters;

import com.PhilipShpyro.Company.Employees.EmployeeType;
import com.PhilipShpyro.Company.Technologies.TechnologyType;

public class PHPTester extends Tester {
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
