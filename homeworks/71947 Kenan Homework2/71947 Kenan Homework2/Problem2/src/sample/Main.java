package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group group = new Group(); // Create a layout Panel
        Scene scene = new Scene(group, 600, 600); // solves rectangles too

        // add content to the Layout panel

        double widthCenter = scene.getWidth() / 2; // getting the center of the scene by X
        double heightCenter = scene.getHeight() / 2; // getting the center of the scene by Y

        // Setting the number of spiral squares we want to fit in the given Scene size
        int numberOfSpiralSquares = 6; // counted 6 from the given picture in the task, can be changed here.

        // Calculating the space between each line to reproduce the drawing with 6 spiral squares fitting the current SCene!
        double spaceBetweenLines = widthCenter / numberOfSpiralSquares;

        for (int i = 0; i < numberOfSpiralSquares - 1; i++) // without the last cycle (wont draw in scene borders)
        {
            Line line1 = new Line(widthCenter + (spaceBetweenLines * i),
                    heightCenter - (spaceBetweenLines * i),
                    widthCenter + (spaceBetweenLines * i),
                    heightCenter + spaceBetweenLines + (spaceBetweenLines * i));

            Line line2 = new Line(widthCenter + (spaceBetweenLines * i),
                    heightCenter + spaceBetweenLines + (spaceBetweenLines * i),
                    widthCenter - spaceBetweenLines - (spaceBetweenLines * i),
                    heightCenter + spaceBetweenLines + (spaceBetweenLines * i));

            Line line3 = new Line(widthCenter - spaceBetweenLines - (spaceBetweenLines * i),
                    heightCenter + spaceBetweenLines + (spaceBetweenLines * i),
                    widthCenter - spaceBetweenLines - (spaceBetweenLines * i),
                    heightCenter - spaceBetweenLines - (spaceBetweenLines * i));

            Line line4 = new Line(widthCenter - spaceBetweenLines - (spaceBetweenLines * i),
                    heightCenter - spaceBetweenLines - (spaceBetweenLines * i),
                    widthCenter + spaceBetweenLines + (spaceBetweenLines * i),
                    heightCenter - spaceBetweenLines - (spaceBetweenLines * i));

            // Using different colors to better show the solution and what each line draws
            line1.setStroke(Color.RED);
            line2.setStroke(Color.GREEN);
            line3.setStroke(Color.BLUE);
            line4.setStroke(Color.BROWN);
            // Adding the lines to the layout panel
            group.getChildren().add(line1);
            group.getChildren().add(line2);
            group.getChildren().add(line3);
            group.getChildren().add(line4);
        }
        // setting the scene and showing it.
        primaryStage.setTitle("Drawing square spiral");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
