package person;

public class Teacher extends Person implements Courses{

    private boolean isTA;

    public Teacher(String name, int age, boolean isTA) {
        super(name, age);
        this.isTA = isTA;
    }

    public Teacher() {
        this("Unknown Teacher", 30, true);
    }

    public boolean isTA() {
        return isTA;
    }

    public void setTA(boolean TA) {
        isTA = TA;
    }

    @Override
    public String toString() {
        return String.format("Teacher: %s that %s a TA\n",
                super.toString(), isTA? "is" : "isn't");
    }

    @Override
    public void hasCourses(String[] courses) {
        System.out.print("Teacher has to give courses: ");
        if(courses == null || isTA){
            System.out.print("None");
            return;
        }
        for (int i = 0; i < courses.length; i++) {
            System.out.print(courses[i] + " ");
        }
    }
}
