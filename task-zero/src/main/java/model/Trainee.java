package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Trainee extends Employee {
    private LocalDate startOfInternship;
    private LocalDate endOfInternship;

    public Trainee(String firstName, String lastName, int grade, LocalDate startOfInternship, LocalDate endOfInternship) {
        super(firstName, lastName, grade);
        this.startOfInternship = startOfInternship;
        this.endOfInternship = endOfInternship;
    }

    public LocalDate getStartOfInternship() {
        return startOfInternship;
    }

    public void setStartOfInternship(LocalDate startOfInternship) {
        this.startOfInternship = startOfInternship;
    }

    public LocalDate getEndOfInternship() {
        return endOfInternship;
    }

    public void setEndOfInternship(LocalDate endOfInternship) {
        this.endOfInternship = endOfInternship;
    }

    public String getDurationOfInternship() {
        return startOfInternship.until(endOfInternship, ChronoUnit.DAYS) + " days";
    }

    @Override
    public String getFullInformation() {
        return "Должность: Стажер \n" +
                super.getFullInformation() +
                "\nНачало стажировки: " + startOfInternship +
                "\nКонец стажировки: " + endOfInternship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Trainee trainee = (Trainee) o;
        return Objects.equals(startOfInternship, trainee.startOfInternship) && Objects.equals(endOfInternship, trainee.endOfInternship);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), startOfInternship, endOfInternship);
    }
}
