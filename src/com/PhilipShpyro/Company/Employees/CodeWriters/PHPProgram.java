package com.PhilipShpyro.Company.Employees.CodeWriters;

import com.PhilipShpyro.Company.Programs.Program;
import com.PhilipShpyro.Company.Technologies.TechnologyType;

public class PHPProgram extends Program {

    public PHPProgram(int size, String name) {
        super(size, name);
    }

    @Override
    public TechnologyType getTechnologyType() {
        return TechnologyType.JAVA;
    }
}
