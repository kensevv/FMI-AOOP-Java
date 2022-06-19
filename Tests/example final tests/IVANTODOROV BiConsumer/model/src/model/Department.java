package model;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.BiConsumer;

public class Department {
    private Manager manager;
    private String deptName;
    private ArrayList<Staff> staff;
    public BiConsumer<Staff,Double> appointmentHandler = (worker, workerSalary) ->{
        worker.setWorkAt(deptName);
        worker.setHireAt(LocalDate.now());
        worker.setSalary(workerSalary);
        staff.add(worker);
    };

    public void setManager(Manager manager) {
        if(manager == null) {
            throw new InvalidParameterException();
        }
        else {
            this.manager = manager;
        }
    }

    public void setDeptName(String deptName) {
        if(deptName == null) {
            throw new InvalidParameterException();
        }
        else {
        this.deptName = deptName;
        }
    }

    public ArrayList<Staff> getStaff() {
        return new ArrayList<>(staff);
    }

    public Department(Manager manager, String deptName) {
        setManager(manager);
        setDeptName(deptName);
        staff = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("Manager: %s  Department name: %s   Staff: %s%n", this.manager, this.deptName, this.staff);
    }
}
