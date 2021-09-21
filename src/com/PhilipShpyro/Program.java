package com.PhilipShpyro;

public class Program {
    private int size;
    private ProgramStatus status;
    private String name;

    public Program(int size) {
        this.size = size;
        status = ProgramStatus.NOT_STARTED;
    }

    public Program(int size, String name) {
        this(size);
        this.name = name;
    }

    public void setName(String name) {
        if (this.name == null) {
            this.name = name;
        }
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
}
