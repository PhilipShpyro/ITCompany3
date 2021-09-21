package com.PhilipShpyro;

public class Main {

    public static void main(String[] args) {
        Company company = new Company("myCompany");

        for (int i = 0; i < 100; i++) {
            company.hireEmployee(new JavaDeveloper(String.valueOf(i), String.valueOf(i + 1), getRandomInt()));
            company.hireEmployee(new JavaTester(String.valueOf(i), String.valueOf(i + 1), getRandomInt()));
            company.hireEmployee(new PHPDeveloper(String.valueOf(i), String.valueOf(i + 1), getRandomInt()));
            company.hireEmployee(new PHPTester(String.valueOf(i), String.valueOf(i + 1), getRandomInt()));
        }

        company.startProject(new JavaProgram(10000, "JAVA biggest project"));
        company.startProject(new JavaProgram(1500, "JAVA smallest project"));
        company.startProject(new JavaProgram(5000, "JAVA almost smallest"));
        company.startProject(new PHPProgram(10000, "PHP biggest project"));
        company.startProject(new PHPProgram(2500, "PHP smallest project"));
        company.startProject(new PHPProgram(5000, "PHP average project"));

        company.makeTeamsAndAllocateProjects();
        company.makeAllCurrentProjects();



    }

    public static int getRandomInt() {
        return (int)(Math.random() * 100 + 1);
    }
}
