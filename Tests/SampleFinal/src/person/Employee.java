package person;

public class Employee {
    private String name;
    private double salary;

    public Employee() {
        this.name = "No name";
        this.salary = 1000;
    }

    public Employee(String name, double salary) {
        this.setName(name);
        this.setSalary(salary);
    }

    public String getName() {
        return new String(name);
    }

    public void setName(String name) {
        if(name != null && name.length() >0){
            this.name = name;
        }
        else{
            this.name = "No name";
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary > 0){
            this.salary = salary;
        }
        else {
            this.salary = 1000;
        }
    }

    @Override
    public String toString() {
        return String.format("Employee: %s , %.2f", name, salary);
    }
}
