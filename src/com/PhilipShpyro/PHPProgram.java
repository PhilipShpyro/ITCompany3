package com.PhilipShpyro;

public class PHPProgram extends Program{

    public PHPProgram(int size, String name) {
        super(size, name);
    }

    @Override
    public TechnologyType getTechnologyType() {
        return TechnologyType.JAVA;
    }
}
