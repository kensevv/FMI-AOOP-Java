package person;

public class StaffAppointEventArgs {
    private Staff staff;
    private double newSalary;

    public StaffAppointEventArgs(Staff staff, double newSalary) {
        this.staff = staff;
        this.newSalary = newSalary;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public double getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(double newSalary) {
        this.newSalary = newSalary;
    }
}
