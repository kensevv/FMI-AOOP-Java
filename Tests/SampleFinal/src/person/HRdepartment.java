package person;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.function.BiConsumer;

public class HRdepartment {
    private Manager manager;
    private ArrayList<Staff> staff;

    private class Anon implements StaffAppointHandler {
        private String appointDepartment;

        public Anon(String appointDepartment) {
            this.setAppointDepartment(appointDepartment);
        }

        public String getAppointDepartment() {
            return appointDepartment;
        }

        public void setAppointDepartment(String appointDepartment) {
            if (appointDepartment !=null){
                this.appointDepartment = appointDepartment;
            }
            else throw new InvalidParameterException();
        }

        @Override
        public void addStaff(StaffAppointEventArgs eventArgs) {
            staff.add(new Staff(eventArgs.getStaff().getName(), eventArgs.getNewSalary(), this.appointDepartment));
        }
    }

    public StaffAppointHandler getAppointHandler(){
        return new Anon(manager.getManageDeptName());
    }

    public HRdepartment() {
        this.manager = new Manager();
        this.staff = new ArrayList<>(10);
    }

    public HRdepartment(Manager manager, ArrayList<Staff> staff) {
        this.manager = manager;
        this.staff = staff;
    }

    public Manager getManager() {
        return new Manager(manager);
    }

    public void setManager(Manager manager) {
        if(manager != null) {
            this.manager = manager;
        }
        else {
            throw new InvalidParameterException("Manager is NULL");
        }
    }

    public ArrayList<Staff> getStaff() {
        return new ArrayList<Staff>(this.staff);
    }

    public void setStaff(ArrayList<Staff> staff) {
        if(staff != null) {
            this.staff = staff;
        }
        else {
            this.staff.clear();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(100);
        builder.append(String.format("HRdepartment:\nManager: %s", manager.toString()));
        builder.append("Staff List:\n");
        staff.stream().forEach(staff -> {
            builder.append(staff.toString());
            builder.append("\n");
        });
        return builder.toString();
    }
}
