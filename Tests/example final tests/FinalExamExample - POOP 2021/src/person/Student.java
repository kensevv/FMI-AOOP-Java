package person;

public class Student extends Person implements Courses{
    private int[] grades;

    public Student(String name, int age, int[] grades) {
        super(name, age);
        setGrades(grades);
    }

    public Student() {
        this("Unknown Student", 15, new int[]{-1});
    }

    public int[] getGrades() {
        int[] copy = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            copy[i] = grades[i];
        }
        return copy;
    }

    public void setGrades(int[] grades) {
        if (grades == null || grades.length == 0) {
            this.grades = new int[]{-1};
        }
        else{
            this.grades = new int[grades.length];
            for (int i = 0; i < grades.length; i++) {
                if (grades[i] >= 2 && grades[i] <= 6){
                    this.grades[i] = grades[i];
                }
                else{
                    this.grades[i] = -1;
                }
            }
        }
    }

    public double average(){
        if (grades == null || grades.length == 0){
            return -1;
        }
        double average = 0;
        for (int i = 0; i < grades.length; i++) {
            average += grades[i];
        }

        return average / grades.length;
    }

    @Override
    public String toString() {
        String result = "";
        if (grades == null || grades.length == 0) {
            result += "No grades";
        }
        else{
            for (int i = 0; i < grades.length; i++) {

                if(i != 0 && i % 3 == 0){
                    result += "\n";
                }
                result += grades[i] + " ";
            }
        }
        return String.format("Student: %s with grades: %s\n", super.toString(),
                result);
    }

    @Override
    public void hasCourses(String[] courses) {
        System.out.print("Student has to take courses: ");
        if(courses == null){
            System.out.print("None");
        }else {
            for (int i = 0; i < courses.length; i++) {
                System.out.print(courses[i] + " ");
            }
        }
    }
}
