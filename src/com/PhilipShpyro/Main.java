package com.PhilipShpyro;

public class Main {

    public static void main(String[] args) {
        Company company = new Company();

        for (int i = 0; i < 100; i++) {
            company.hireDeveloper(new Developer(getRandomInt()));
        }

        company.startProject(new JavaProgram(10000, "biggest"));
        company.startProject(new JavaProgram(2222, "smallest"));
        company.startProject(new JavaProgram(2435, "almost smallest"));

        company.makeTeamsAndAllocateProjects();

        company.startCurrentProjects();

        company.printDevelopers();
    }

    public static int getRandomInt() {
        return (int)(Math.random() * 100 + 1);
    }
}
