package model;


import service.ManagerService;

import java.util.Objects;

public class TeamLeader extends Employee implements ManagerService {
    private int numberOfSubordinates;
    private int numberOfProjects;

    public TeamLeader(String firstName, String lastName, int grade, int numberOfSubordinates, int numberOfProjects) {
        super(firstName, lastName, grade);
        this.numberOfSubordinates = numberOfSubordinates;
        this.numberOfProjects = numberOfProjects;
    }

    public int getNumberOfSubordinates() {
        return numberOfSubordinates;
    }

    public void setNumberOfSubordinates(int numberOfSubordinates) {
        this.numberOfSubordinates = numberOfSubordinates;
    }

    public int getNumberOfProjects() {
        return numberOfProjects;
    }

    public void setNumberOfProjects(int numberOfProjects) {
        this.numberOfProjects = numberOfProjects;
    }

    public double getHoursSpentOnProjectInWeek() {
        if (numberOfProjects == 0) {
            return 0;
        }
        return 40.0 / numberOfProjects;
    }

    @Override
    public String getFullInformation() {
        return "Должность: Руководитель команды \n" +
                super.getFullInformation() +
                "\nКол-во подчиненных: " + numberOfSubordinates +
                "\nКол-во проектов: " + numberOfProjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TeamLeader that = (TeamLeader) o;
        return numberOfSubordinates == that.numberOfSubordinates && numberOfProjects == that.numberOfProjects;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfSubordinates, numberOfProjects);
    }

    @Override
    public void reviewCode(Employee employee) {
        System.out.println("Проверка кода пройдена: " + employee);
    }
}
