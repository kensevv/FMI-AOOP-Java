package person;

import java.security.InvalidParameterException;

public class Manager extends Employee{
    private String manageDeptName;

    private StaffAppointHandler staffAppoint;

    public void addStaffAppointHandler(StaffAppointHandler staffAppoint){
        this.staffAppoint = staffAppoint;
    }

    public void onStaffAppoint (Staff member, double newStaffMemberSalary){
        staffAppoint.addStaff(new StaffAppointEventArgs(member, newStaffMemberSalary));
    }

    public Manager() {
        super();
    }

    public Manager(String name, double salary) {
        super(name, salary);
    }

    public Manager(String manageDeptName) {
        this.manageDeptName = manageDeptName;
    }

    public Manager(String name, double salary, String manageDeptName) {
        super(name, salary);
        this.manageDeptName = manageDeptName;
    }

    public Manager(Manager manager){
        super(manager.getName(), manager.getSalary());
        this.manageDeptName = manager.getManageDeptName();
    }

    public String getManageDeptName() {
        return manageDeptName;
    }

    public void setManageDeptName(String manageDeptName) {
        if(manageDeptName != null){
            this.manageDeptName = manageDeptName;
        }
        else {
            throw new InvalidParameterException("manageDeptName is NULL");
        }
    }

    @Override
    public String toString() {
        return String.format("%s\nManager: %s", super.toString(), this.manageDeptName);
    }
}
