package com.PhilipShpyro.Company;

import com.PhilipShpyro.Company.Technologies.TechnologyType;
import com.PhilipShpyro.Company.Employees.Team;
import com.PhilipShpyro.Company.Employees.Employee;
import com.PhilipShpyro.Company.Employees.EmployeeType;
import com.PhilipShpyro.Company.Programs.Program;
import com.PhilipShpyro.Company.Programs.ProgramStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Company {
    private TreeSet<Employee> employees;
    private ArrayList<Program> projects;
    private ArrayList<Team> teams;
    private String name;


    public Company(String name) {
        this.name = name;

        employees = new TreeSet<>((o1, o2) -> {
            if (o1.getSpeed() == o2.getSpeed()) {
                return 0;
            }
            return o1.getSpeed() < o2.getSpeed() ? 1 : -1;
        });

        projects = new ArrayList<>();
    }

    public String getName() {
        return name;
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
            Program tmpProject = projects.get(i);
            teams.add(new Team(tmpProject, tmpProject.getTechnologyType()));
        }
    }

    public void allocateProjects() {
        for (TechnologyType technology : TechnologyType.values()) {
            allocateProjects(technology);
        }
    }

    public void allocateProjects(TechnologyType technology) {

        int i = 0;
        List<Team> tmpTeams = teams.stream().filter(o -> o.getTechnologyType() == technology).collect(Collectors.toList());

        for (EmployeeType employeeType : EmployeeType.values()) {
            for (Employee employee : employees.stream().filter(
                    o -> o.getCurrentTeam() == null
                            && o.getEmployeeType() == employeeType
            ).collect(Collectors.toList())) {
                Team tmpTeam = tmpTeams.get(i % projects.size());
                tmpTeam.addEmployee(employee);
                employee.setCurrentTeam(tmpTeam);
                i++;
            }
        }
    }

    public void makeTeamsAndAllocateProjects() {
        int i = 0;

        makeTeams();
        allocateProjects();
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

        i = 1;
        for (Team team : teams) {
            team.writeToXML("Team " + i + ".xml");
            i++;
        }
        disbandTeams();
    }
}
