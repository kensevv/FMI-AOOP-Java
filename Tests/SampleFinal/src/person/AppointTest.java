package person;

public class AppointTest {
    public static void main(String[] args) {
        Manager boss = new Manager("kenan",1000, "DEPARTMENTNAME ");
        Staff candidate = new Staff("ILIANA", 1000, "B");

        HRdepartment department = new HRdepartment();
        department.setManager(boss);


        StaffAppointHandler sah = department.getAppointHandler();
        boss.addStaffAppointHandler(sah);
        boss.onStaffAppoint(candidate, 1300);

        department.getStaff().stream().forEach(staff -> System.out.println(staff.toString()));
    }
}
