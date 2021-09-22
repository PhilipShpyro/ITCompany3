package com.PhilipShpyro.Company.Programs;

import com.PhilipShpyro.Company.Technologies.ITechnology;

public abstract class Program implements ITechnology {
    private int size;
    private ProgramStatus status;
    private String name;

    public Program(int size, String name) {
        this.size = size;
        status = ProgramStatus.NOT_STARTED;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatus(ProgramStatus status) {
        this.status = status;
    }

    public ProgramStatus getStatus() {
        return status;
    }

    public int getSize() {
        return size;
    }

    public int getCost() {
        return getSize() / 2;
    }
}
