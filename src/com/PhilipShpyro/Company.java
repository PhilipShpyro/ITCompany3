package com.PhilipShpyro;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Company {
    private TreeSet<Employee> employees;
    private ArrayList<Program> projects;
    private ArrayList<Team> teams;


    public Company() {
        employees = new TreeSet<>((o1, o2) -> {
            if (o1.getSpeed() == o2.getSpeed()) {
                return 0;
            }
            return o1.getSpeed() < o2.getSpeed() ? 1 : -1;
        });

        projects = new ArrayList<>();
    }

    public void hireEmployee(Employee employee) {
        employees.add(employee);
    }

    public void startProject(Program program) {
        projects.add(program);
    }

    public void printEmployees() {
        for (Employee e : employees) {
            System.out.println(e.getSpeed() + " " + e.getCurrentTeam());
        }
    }

    public void disbandTeams() {
        for (Employee employee : employees) {
            employee.setCurrentTeam(null);
        }
        teams = null;
    }

    private void makeTeams() {
        teams = new ArrayList<>((int)projects.stream().filter(o -> o.getStatus() == ProgramStatus.NOT_STARTED).count());
        for (int i = 0; i < projects.size(); i++) {
            teams.add(new Team(projects.get(i)));
        }
    }

    public void allocateProject() {
        int i = 0;

        for (EmployeeType type : EmployeeType.values()) {
            for (Employee employee : employees.stream().filter(
                    o -> o.getCurrentTeam() == null
                    && o.getEmployeeType() == type
            ).collect(Collectors.toList())) {
                Team tmpTeam = teams.get(i % projects.size());

                tmpTeam.addEmployee(employee);
                employee.setCurrentTeam(tmpTeam);
                i++;
            }
        }
    }

    public void makeTeamsAndAllocateProjects() {
        int i = 0;

        makeTeams();
        allocateProject();
    }

    public void makeAllCurrentProjects() {
        Thread[] threads = new Thread[teams.size()];

        int i = 0;
        for (Team team : teams) {
            threads[i] = new Thread(() -> team.makeProject());
            threads[i].start();
            i++;
        }

        for (i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        disbandTeams();
    }
}
