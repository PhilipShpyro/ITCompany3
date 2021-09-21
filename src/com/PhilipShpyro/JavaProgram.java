package com.PhilipShpyro;

public class JavaProgram extends Program{

    public JavaProgram(int size, String name) {
        super(size, name);
    }

    @Override
    public TechnologyType getTechnologyType() {
        return TechnologyType.JAVA;
    }
}
