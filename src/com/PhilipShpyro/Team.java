package com.PhilipShpyro;

import java.util.ArrayList;

public class Team {
    private Company company;
    private ArrayList<Developer> developers = new ArrayList<>();
    private int teamSpeed;
    private Program project;

    public void addDeveloper(Developer developer) {
        developers.add(developer);
        teamSpeed += developer.getSpeed();
    }

    public Team(Program project) {
        this.project = project;
    }


    public int getTeamSpeed() {
        return teamSpeed;
    }

    public synchronized void work() {
        project.setStatus(ProgramStatus.IN_PROCESS);
        System.out.println("Project " + project.getName() + " started. We need to wait " + (project.getSize() / teamSpeed) + " seconds...");

        try {
            Thread.sleep(project.getSize() * 1000 / teamSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Project " + project.getName() + " created...");

        project.setStatus(ProgramStatus.FINISHED);
    }
}
