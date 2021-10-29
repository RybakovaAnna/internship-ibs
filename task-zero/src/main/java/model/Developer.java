package model;

import java.util.Objects;

public class Developer extends Employee {
    private String programmingLanguage;
    private double developmentExperience;

    public Developer(String firstName, String lastName, int grade, String programmingLanguage, double developmentExperience) {
        super(firstName, lastName, grade);
        this.programmingLanguage = programmingLanguage;
        this.developmentExperience = developmentExperience;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public double getDevelopmentExperience() {
        return developmentExperience;
    }

    public void setDevelopmentExperience(double developmentExperience) {
        this.developmentExperience = developmentExperience;
    }

    public int getMonthsOfDevelopmentExperience() {
        return (int) developmentExperience * 12;
    }

    @Override
    public String getFullInformation() {
        return "Должность: Разработчик \n" +
                super.getFullInformation() +
                "\nЯзык программирования: " + programmingLanguage +
                "\nОпыт разработки: " + developmentExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Developer developer = (Developer) o;
        return Objects.equals(programmingLanguage, developer.programmingLanguage) && Objects.equals(developmentExperience, developer.developmentExperience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), programmingLanguage, developmentExperience);
    }
}