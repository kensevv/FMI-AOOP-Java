package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Calendar extends Application {
    private Scene scene;
    private TextInputDialog inputDlg;
    private LocalDate date;
    private VBox vbox;

    private void readInput() // reading user input data
    {
        int year, month;
        inputDlg.setTitle("Input data");
        inputDlg.setHeaderText(null);
        inputDlg.setContentText("Enter year (1-...): ");
        do {
            year = Integer.parseInt(inputDlg.showAndWait().get());
        }while (year < 0); // validate year

        inputDlg.setContentText("Now enter month (1-12): ");
        do {
            month = Integer.parseInt(inputDlg.showAndWait().get());
        }while (month < 0 || month > 12); // validate month

        date = LocalDate.of(year, month, 1);
    }

    private boolean isLeap(int year) // return if a year is leap or not
    {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
            return true;
        return false;
    }

    private void labelWeekDayNames() // function prints weekday labels as first line.
    {
        HBox firstLine = new HBox(7);
        String[] dayNames = { "Mon","Tue  ", "Wed", " Thu ", "Fri    ", " Sat  ", "Sun" };
        for (int i = 0; i < 7; i++)
        {
            Label day = new Label(dayNames[i]);
            day.setTextFill(Color.ORANGE);
            firstLine.getChildren().add(day);
        }
        vbox.getChildren().add(firstLine);
    }

    private void drawCalendar()
    {
        LocalDate today = LocalDate.now(); // getting the current date (today)
        int numberDaysInMonth = date.getMonth().length(isLeap(date.getYear())); // saving number of days in the selected month
        int startDay = date.getDayOfWeek().getValue() -1; // finding the weeksDay of first of the month
        int currentDay = 1; // used to print days
        labelWeekDayNames(); // printing first line which are the labels of weekdays (a HBox is added to the vbox as first line)
        // Solving the calendar as a Matrix A6x7 - max of 6 lines and 7 elements in each
        for (int i = 0; i< 6; i++)
        {
            HBox newLine = new HBox(20); // each line is a organized HBox
            for (int j = 0; j< 7; j++ )
            {
                if (currentDay > numberDaysInMonth) // if we have printed all days we break the cycles.
                {
                    break;
                }
                if (j != startDay) // printing thee empty days until reaching the first weekday of the first of the month
                {
                    newLine.getChildren().add(new Label("    "));
                }
                else // after reaching the correct weekday, printing the rest in the matrix
                {
                    String labelToAdd = String.format("%d",currentDay);
                    if (currentDay < 10) // used to correctly format the spaces
                    {
                        labelToAdd = String.format("%d  ", currentDay);
                    }
                    Label day = new Label(labelToAdd);
                    day.setTextFill(Color.BLUE);
                    // setting red color if it equals to today's date
                    if (currentDay == today.getDayOfMonth() && date.getMonth().getValue() == today.getMonth().getValue())
                    {
                        day.setTextFill(Color.RED);
                    }
                    newLine.getChildren().add(day);
                    currentDay++;
                    if (startDay != 6)
                    {
                        startDay++;
                    }
                }
            }
            startDay = 0; // resetting the startday to correctly go trought the first IF elses.
            vbox.getChildren().add(newLine); // adding each line to vertically organized VBox
        }
    }

    @Override
    public void start(Stage stage) throws Exception{
        // initializing
        inputDlg = new TextInputDialog();
        vbox = new VBox();

        readInput(); // reading user-input data
        drawCalendar(); // drawing the calendar for the selected month

        // setting the scene
        vbox.setSpacing(5); // spacing between elements in the boxx
        vbox.setPadding(new Insets(25,35,25,35)); // padding distance from the scene itself
        scene = new Scene(vbox, 350, 200);

        stage.setTitle(String.format("Calendar for %s %d", date.getMonth(), date.getYear()));
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}