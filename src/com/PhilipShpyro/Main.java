package com.PhilipShpyro;

public class Main {

    public static void main(String[] args) {
        Company company = new Company();

        for (int i = 0; i < 100; i++) {
            company.hireEmployee(new JavaDeveloper(String.valueOf(i), String.valueOf(i + 1), getRandomInt()));
            company.hireEmployee(new JavaTester(String.valueOf(i), String.valueOf(i + 1), getRandomInt()));
            //company.hireEmployee(new PHPDeveloper(String.valueOf(i), String.valueOf(i + 1), getRandomInt()));
            //company.hireEmployee(new PHPTester(String.valueOf(i), String.valueOf(i + 1), getRandomInt()));
        }

        company.startProject(new JavaProgram(10000, "project"));
        company.startProject(new JavaProgram(2222, "smallest"));
        company.startProject(new JavaProgram(2435, "almost smallest"));

        company.makeTeamsAndAllocateProjects();
        company.makeAllCurrentProjects();


    }

    public static int getRandomInt() {
        return (int)(Math.random() * 100 + 1);
    }
}
