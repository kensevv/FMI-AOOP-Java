package person;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        setAge(age);
        setName(name);
    }

    public Person() {
        this("Unknown", 18);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            this.name = "Unknown";
        }
        else{
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 150){
            this.age = age;
        }else{
            this.age = 18;
        }
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d", name, age);
    }
}
