package person;

@FunctionalInterface
public interface StaffAppointHandler {
    void addStaff(StaffAppointEventArgs eventArgs);
}
