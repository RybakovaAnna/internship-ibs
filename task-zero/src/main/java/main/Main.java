package main;


import model.Developer;
import model.Employee;
import model.TeamLeader;
import model.Trainee;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Employee empl = new Employee() {
            private String email;
            private int phone;
            private LocalDate birthday;

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public int getPhone() {
                return phone;
            }

            public void setPhone(int phone) {
                this.phone = phone;
            }

            public LocalDate getBirthday() {
                return birthday;
            }

            public void setBirthday(LocalDate birthday) {
                this.birthday = birthday;
            }

            public long getAge() {
                return birthday.until(LocalDate.now(), ChronoUnit.YEARS);
            }
        };


        List<Employee> listEmployees = new ArrayList<>();
        listEmployees.add(new Developer(
                "Василий",
                "Иванов",
                6,
                "Java",
                4.5));
        listEmployees.add(new Trainee(
                "Кирилл",
                "Абросимов",
                0,
                LocalDate.of(2021, 10, 14),
                LocalDate.of(2021, 12, 5)));
        listEmployees.add(new TeamLeader(
                "Руслан",
                "Титов",
                10,
                5,
                2));
        listEmployees.add(new TeamLeader(
                "Тарас",
                "Куртушин",
                9,
                4,
                1));
        listEmployees.add(new Trainee(
                "Андрей",
                "Зимерев",
                0,
                LocalDate.of(2021, 10, 14),
                LocalDate.of(2021, 12, 10)));
        listEmployees.add(new Developer(
                "Михаил",
                "Холопов",
                7,
                "Java",
                5));
        listEmployees.add(new Developer(
                "Тимур",
                "Лебедев",
                4,
                "Java",
                2.5));


        List<Employee> list = listEmployees.stream()
                .filter(employee -> employee.getGrade() > 0)
                .collect(Collectors.toList());

        listEmployees.stream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }
}
