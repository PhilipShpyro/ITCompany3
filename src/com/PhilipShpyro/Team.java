package com.PhilipShpyro;

import java.util.ArrayList;

public class Team {
    private Company company;
    private ArrayList<Employee> employees = new ArrayList<>();
    private int teamSpeed;
    private Program project;

    public void addEmployee(Employee employee) {
        employees.add(employee);
        teamSpeed += employee.getSpeed();
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        teamSpeed -= employee.getSpeed();
    }

    public Team(Program project) {
        this.project = project;
    }


    public int getTeamSpeed() {
        return teamSpeed;
    }

    public synchronized Program makeProject() {
        project.setStatus(ProgramStatus.IN_PROCESS);
        System.out.println("Project " + project.getName() + " started. We need to wait " + (project.getSize() / teamSpeed) + " seconds...");

        try {
            Thread.sleep(project.getSize() * 1000 / teamSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Project " + project.getName() + " completed...");

        project.setStatus(ProgramStatus.FINISHED);

        return project;
    }
}
