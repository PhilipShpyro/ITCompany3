package com.PhilipShpyro;

import sun.security.ec.point.ProjectivePoint;

import java.util.ArrayList;
import java.util.TreeSet;

public class Company {
    private TreeSet<Developer> developers;
    private ArrayList<Program> projects;
    private ArrayList<Team> teams;


    public Company() {
        developers = new TreeSet<>((o1, o2) -> {
            if (o1.getSpeed() == o2.getSpeed()) {
                return 0;
            }
            return o1.getSpeed() < o2.getSpeed() ? 1 : -1;
        });

        projects = new ArrayList<>();
    }

    public void hireDeveloper(Developer developer) {
        developers.add(developer);
    }

    public void startProject(Program program) {
        projects.add(program);
    }

    public void printDevelopers() {
        for (Developer d : developers) {
            System.out.println(d.getSpeed() + " " + d.getTeam());
        }
    }

    private void makeTeams() {
        teams = new ArrayList<>(projects.size());
        for (int i = 0; i < projects.size(); i++) {
            teams.add(new Team(projects.get(i)));
        }
    }

    public void makeTeamsAndAllocateProjects() {
        int i = 0;

        makeTeams();
        for (Developer developer : developers) {
            Team tmpTeam = teams.get(i % projects.size());

            tmpTeam.addDeveloper(developer);
            developer.setTeam(tmpTeam);
            i++;
        }
    }

    public void startCurrentProjects() {
        Thread[] threads = new Thread[teams.size()];

        int i = 0;
        for (Team team : teams) {
            threads[i] = new Thread(() -> team.work());
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
    }
}
