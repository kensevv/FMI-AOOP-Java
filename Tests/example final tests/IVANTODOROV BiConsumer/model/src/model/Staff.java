package model;

import java.time.LocalDate;

public class Staff extends Employee {

    private String workAt;
    private LocalDate hireAt;

    public Staff(String name, double salary) {
        super(name, salary);
    }

    public String getWorkAt() {
        return workAt;
    }

    public void setWorkAt(String workAt) {
        this.workAt = workAt == null ? "Candidate" : workAt;
    }

    public LocalDate getHireAt() {
        return hireAt;
    }

    public void setHireAt(LocalDate hireAt) {
        this.hireAt = hireAt == null ? LocalDate.now() : hireAt;
    }

    public Staff(String name, double salary, String workAt, LocalDate hireAt) {
        super(name, salary);
        setWorkAt(workAt);
        setHireAt(hireAt);
    }

    @Override
    public String toString() {
        return String.format("Works at: %s  Hire at: %s  %s%n",workAt,hireAt,super.toString());
    }
}
