package gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.util.StringConverter;
import model.Department;
import model.Manager;
import model.Staff;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Staff> cboStaffMembers;

    @FXML
    private Slider sldrIncreasment;

    @FXML
    private Label lblName;

    @FXML
    private Label lblNameResult;

    @FXML
    private Label lblWorksAt;

    @FXML
    private Label lblWorksAtResult;

    @FXML
    private Label lblSalary;

    @FXML
    private Label lblSalaryResult;

    @FXML
    private Label lblIncrease;

    @FXML
    private Label lblIncreaseResult;

    @FXML
    private Label lblHiredAt;

    @FXML
    private Label lblHiredAtResult;

    @FXML
    void cboStaffMembersOnAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert cboStaffMembers != null : "fx:id=\"cboStaffMembers\" was not injected: check your FXML file 'Sample.fxml'.";
        assert sldrIncreasment != null : "fx:id=\"sldrIncreasment\" was not injected: check your FXML file 'Sample.fxml'.";
        assert lblName != null : "fx:id=\"lblName\" was not injected: check your FXML file 'Sample.fxml'.";
        assert lblNameResult != null : "fx:id=\"lblNameResult\" was not injected: check your FXML file 'Sample.fxml'.";
        assert lblWorksAt != null : "fx:id=\"lblWorksAt\" was not injected: check your FXML file 'Sample.fxml'.";
        assert lblWorksAtResult != null : "fx:id=\"lblWorksAtResult\" was not injected: check your FXML file 'Sample.fxml'.";
        assert lblSalary != null : "fx:id=\"lblSalary\" was not injected: check your FXML file 'Sample.fxml'.";
        assert lblSalaryResult != null : "fx:id=\"lblSalaryResult\" was not injected: check your FXML file 'Sample.fxml'.";
        assert lblIncrease != null : "fx:id=\"lblIncrease\" was not injected: check your FXML file 'Sample.fxml'.";
        assert lblIncreaseResult != null : "fx:id=\"lblIncreaseResult\" was not injected: check your FXML file 'Sample.fxml'.";
        assert lblHiredAt != null : "fx:id=\"lblHiredAt\" was not injected: check your FXML file 'Sample.fxml'.";
        assert lblHiredAtResult != null : "fx:id=\"lblHiredAtResult\" was not injected: check your FXML file 'Sample.fxml'.";

        ArrayList<Staff> candidates = new ArrayList<>();
        LocalDate date = LocalDate.of(2000,8,2);

        candidates.add(new Staff("pesho",0,"Home",LocalDate.of(2000,8,2)));
        candidates.add(new Staff("gosho",0,"Home",LocalDate.of(2000,6,2)));
        candidates.add(new Staff("tasho",0,"Home",LocalDate.of(2000,8,29)));
        candidates.add(new Staff("stavri",0,"Home",LocalDate.of(1999,8,2)));
        candidates.add(new Staff("dancho",0,"Home",LocalDate.of(2001,8,2)));

        Manager manager = new Manager("shefa",10000);
        Department department = new Department(manager,"theGudDept");
        manager.setAppointRule(department.appointmentHandler);

        Random rand = new Random();
        for (Staff candidate : candidates) {
            manager.onStaffAppointment(candidate, rand.nextDouble() * 1000 + 1000);
        }

        ObservableList<Staff> observableList = FXCollections.observableArrayList(department.getStaff());
        cboStaffMembers.setItems(observableList);
        cboStaffMembers.setConverter(new StringConverter<Staff>() {
            @Override
            public String toString(Staff staff) {
                return String.format("%s: %s", staff.ID, staff.getName());
            }

            @Override
            public Staff fromString(String s) {
                return null;
            }
        });


    }
}
