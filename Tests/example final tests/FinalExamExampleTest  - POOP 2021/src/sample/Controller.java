package sample;

import java.net.URL;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import person.*;

public class Controller {

    private ArrayList<Person> people;
    private static int current = -1;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblName;

    @FXML
    private TextField txtName;

    @FXML
    private Label lblAge;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtTA;

    @FXML
    private Button btnAddStudent;

    @FXML
    private Button btnAddTeacher;

    @FXML
    private Button btnPrintCurrent;

    @FXML
    private Button btnPrintAll;

    @FXML
    private Button btnCalculate;

    @FXML
    private TextArea txaCourses;

    @FXML
    private TextArea txaPrint;

    @FXML
    private Button btnCourses;

    @FXML
    private TextField txtGrades;

    @FXML
    private Button btnExit;

    @FXML
    void btnAddStudentOnAction(ActionEvent event) {
        String[] gradesString = txtGrades.getText().split(" ");
        int[] grades = new int[gradesString.length];
        for (int i = 0; i < gradesString.length; i++) {
            grades[i] = Integer.parseInt(gradesString[i]);
        }
        people.add(new Student(txtName.getText(),
                Integer.parseInt(txtAge.getText()), grades));
        current++;
    }

    @FXML
    void btnAddTeacherOnAction(ActionEvent event) {
        boolean isTA = false;
        if(txtTA.getText().equals("Y")){
            isTA = true;
        }
        people.add(new Teacher(txtName.getText(),
                Integer.parseInt(txtAge.getText()), isTA));
        current++;
    }

    @FXML
    void btnCalculateOnAction(ActionEvent event) {
        if (people.get(current) instanceof Student){
            Student s = (Student) people.get(current);
            double average = s.average();
            txaPrint.appendText(
                    String.format("Average of student: %.3f\n", average));
        }

        //additional problem - count frequency of random grades
        Random random = new Random();
        txaPrint.appendText(String.format("%-10s%-14s\n", "grade", "gradeFrequency"));
        IntStream.rangeClosed(1, 10)
                .mapToObj(grade -> random.nextInt(5) + 2) //2 i 6
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()))
                .forEach((grade, gradeFrequency) ->
                        txaPrint.appendText(
                                String.format("%-10d%-14d\n", grade, gradeFrequency)));
    }

    @FXML
    void btnCoursesOnAction(ActionEvent event) {
        String[] courses = txaCourses.getText().split(" ");
        if(people.get(current) instanceof Teacher) {
            Teacher t = (Teacher) people.get(current);
            t.hasCourses(courses);
        }
        if(people.get(current) instanceof Student) {
            Student s = (Student) people.get(current);
            s.hasCourses(courses);
        }
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnPrintAllOnAction(ActionEvent event) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < people.size(); i++) {
            sb.append(people.get(i).toString()).append("\n");
        }
        txaPrint.setText(sb.toString());
    }

    @FXML
    void btnPrintCurrentOnAction(ActionEvent event) {
        //txaPrint.appendText(people.get(current).toString());



        Map<Integer, String> map = new HashMap<>();
        map.put(4, "Text");
        map.put(2, "String");
        map.put(1, "Names");
        map.put(3, "Apple");

        //test sort map by value;
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(integerStringEntry -> txaPrint.appendText(
                        String.format("%-4d%-14s\n", integerStringEntry.getKey(),
                                integerStringEntry.getValue())));

        //test sort map by key;
        map.entrySet().stream()
                .sorted((o1, o2) -> o2.getKey() - o1.getKey())
                .forEach(integerStringEntry -> txaPrint.appendText(
                        String.format("%-4d%-14s\n", integerStringEntry.getKey(),
                                integerStringEntry.getValue())));
    }

    @FXML
    void initialize() {
        people = new ArrayList<>();

        assert lblName != null : "fx:id=\"lblName\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblAge != null : "fx:id=\"lblAge\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtAge != null : "fx:id=\"txtAge\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtTA != null : "fx:id=\"txtTA\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnAddStudent != null : "fx:id=\"btnAddStudent\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnAddTeacher != null : "fx:id=\"btnAddTeacher\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnPrintCurrent != null : "fx:id=\"btnPrintCurrent\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnPrintAll != null : "fx:id=\"btnPrintAll\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnCalculate != null : "fx:id=\"btnCalculate\" was not injected: check your FXML file 'sample.fxml'.";
        assert txaCourses != null : "fx:id=\"txaCourses\" was not injected: check your FXML file 'sample.fxml'.";
        assert txaPrint != null : "fx:id=\"txaPrint\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnCourses != null : "fx:id=\"btnCourses\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtGrades != null : "fx:id=\"txtGrades\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
