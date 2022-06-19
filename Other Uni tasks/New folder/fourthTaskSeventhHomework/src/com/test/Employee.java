package com.test;

import java.rmi.MarshalledObject;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

class Employee {

    public static enum Gender {

        MALE, FEMALE
    }

    private String name;
    private Gender gender;
    private LocalDate dob;
    private double income;
    private UUID gfg1;

    private Employee(String name, Gender gender, LocalDate dob,
                     double income) {
        gfg1 = UUID.randomUUID();
        this.setName(name);
        this.setGender(gender);
        this.setDob(dob);
        this.setIncome(income);
    }

    public Employee() {
        gfg1 = UUID.randomUUID();
        this.name = "John";
        this.gender = Gender.MALE;
        this.dob =  LocalDate.of(1971, Month.JANUARY, 1);
        this.income = 10000;
    }

    public UUID getGfg1() {
        return gfg1;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income > 0 ? income : 0;
    }

    public static List<Employee> persons() {
        Employee p1 = new Employee( "Jake", Gender.MALE, LocalDate.of(1971,
                Month.JANUARY, 1), 2343.0);
        Employee p2 = new Employee("Jack", Gender.MALE, LocalDate.of(1972,
                Month.JULY, 21), 7100.0);
        Employee p3 = new Employee( "Jane", Gender.FEMALE, LocalDate.of(1973,
                Month.MAY, 29), 5455.0);
        Employee p4 = new Employee("Jode", Gender.MALE, LocalDate.of(1974,
                Month.OCTOBER, 16), 1800.0);
        Employee p5 = new Employee( "Jeny", Gender.FEMALE, LocalDate.of(1975,
                Month.DECEMBER, 13), 1234.0);
        Employee p6 = new Employee( "Jason", Gender.MALE, LocalDate.of(1976,
                Month.JUNE, 9), 3211.0);

        List<Employee> persons = Arrays.asList(p1, p2, p3, p4, p5, p6);

        return persons;
    }

    public static void statistics() {
        List<Employee> employeeList = persons();
        System.out.printf("%nEmployees by incomes:%n");
        employeeList.stream().map(Employee::getIncome).
                distinct().
                sorted().
                forEach(System.out::println);
    }

    public void personsStatsByGenderCount(){
        List<Employee> employeeList = persons();

        System.out.printf("%nEmployee by gender");

        Map<Gender, List<Employee>> groupByGender =
                employeeList.stream().
                        collect(Collectors.groupingBy(Employee::getGender));

        groupByGender.forEach(
                (gender, employeeListOne) ->
                {
                    System.out.println(gender);
                    long countOfEmployeesByGender =  employeeListOne.stream().count();

                    System.out.printf("    The count of gender=%s is %s", gender, countOfEmployeesByGender);
                }
        );

    }

    public void personsStatsByGenderList(){
        List<Employee> employeeList = persons();

        System.out.printf("%nEmployee by gender");

        Map<Gender, List<Employee>> groupByGender =
                employeeList.stream().
                        collect(Collectors.groupingBy(Employee::getGender));

        groupByGender.forEach(
                (gender, employeeListOne) ->
                {
                    System.out.println(gender);
                    employeeListOne.forEach(
                            employee -> System.out.printf("    %s$n", employee));
                }
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.income, income) == 0 &&
                Objects.equals(name, employee.name) &&
                gender == employee.gender &&
                Objects.equals(dob, employee.dob) &&
                Objects.equals(gfg1, employee.gfg1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, dob, income, gfg1);
    }

    @Override
    public String toString() {
        return String.format("Employee{uniqueId=%s, name='%s', gender= %s, dob=%s, income=%s}", getGfg1(), getName(),
                getGender(), getDob(), getIncome());
    }
}

