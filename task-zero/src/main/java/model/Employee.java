package model;

import java.util.Objects;

public abstract class Employee {
    private String firstName;
    private String lastName;
    private int grade;

    public Employee(){}

    public Employee(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getFullInformation() {
        return "Имя: " + firstName +
                "\nФамилия: " + lastName +
                "\nГрейд: " + grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return grade == employee.grade && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, grade);
    }

    @Override
    public String toString() {
        return firstName +" " + lastName;
    }
}
