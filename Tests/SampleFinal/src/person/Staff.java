package person;

public class Staff extends Employee {
    private String workAt;

    public Staff() {
        super();
        this.workAt = "Candidate";
    }

    public Staff(String name, double salary, String workAt) {
        super(name, salary);
        this.workAt = workAt;
    }

    public String getWorkAt() {
        return new String(workAt);
    }

    public void setWorkAt(String workAt) {
        if(workAt != null && workAt.length() > 0){
            this.workAt = workAt;
        }
        else {
            this.workAt = "Candidate";
        }
    }

    @Override
    public String toString() {

        return String.format("%s\nStaff: %s", super.toString(), this.workAt);
    }
}
