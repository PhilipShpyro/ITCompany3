package com.PhilipShpyro;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Team implements ITechnology {
    private Company company;
    private ArrayList<Employee> employees = new ArrayList<>();
    private int teamSpeed;
    private Program project;
    private TechnologyType technology;

    public void addEmployee(Employee employee) {
        employees.add(employee);
        teamSpeed += employee.getSpeed();
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        teamSpeed -= employee.getSpeed();
    }

    public Team(Program project, TechnologyType technology) {
        this.project = project;
        this.technology = technology;
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

    @Override
    public TechnologyType getTechnologyType() {
        return technology;
    }



    public void writeToXML(String xmlPath) {
        Document dom;
        Element element = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            dom = builder.newDocument();
            Element rootElement = dom.createElement("Team");

            element = dom.createElement("project");
            element.appendChild(dom.createTextNode(project.getName()));
            rootElement.appendChild(element);

            element = dom.createElement("project-cost");
            element.appendChild(dom.createTextNode(String.valueOf(project.getCost())));
            rootElement.appendChild(element);

            element = dom.createElement("technology");
            element.appendChild(dom.createTextNode(technology.name()));
            rootElement.appendChild(element);

            element = dom.createElement("team-speed");
            element.appendChild(dom.createTextNode(String.valueOf(teamSpeed)));
            rootElement.appendChild(element);

            dom.appendChild(rootElement);

            for (Employee employee : employees) {
                element = dom.createElement("employee");
                element.appendChild(dom.createTextNode(employee.getFirstName() + " " + employee.getLastName()));
                rootElement.appendChild(element);
            }

            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                tr.transform(new DOMSource(dom),
                        new StreamResult(new FileOutputStream(xmlPath)));

            } catch (TransformerException te) {
                System.out.println(te.getMessage());
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        }
    }
}
