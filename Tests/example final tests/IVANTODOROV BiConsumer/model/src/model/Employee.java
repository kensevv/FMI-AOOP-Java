package model;

public class Employee {
    public final String ID;
    private String name;
    private double salary;
    private static int cnt = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? "No Name" : name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary < 1000 ? 1000 : salary;
    }

    public Employee(String name, double salary) {
        setName(name);
        setSalary(salary);
        ID = String.format("E-%03d", cnt);
        cnt++;
    }

    @Override
    public String toString() {
        return String.format("ID: %s  Name: %s  Salary: %.2f%n",ID,name,salary);
    }
}
