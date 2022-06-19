package model;

import java.util.function.BiConsumer;

public class Manager extends Employee {

    private BiConsumer<Staff, Double> appointRule;

    public Manager(String name, double salary) {
        super(name, salary);
    }

    public void setAppointRule(BiConsumer<Staff, Double> appointRule) {
        this.appointRule = appointRule;
    }

    public void onStaffAppointment(Staff member, Double newStaffMemberSalary) {

        appointRule.accept(member, newStaffMemberSalary);
    }
}
