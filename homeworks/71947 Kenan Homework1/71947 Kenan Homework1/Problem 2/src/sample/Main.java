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
        Scene scene = new Scene(group, 600, 600);// SOLVES BOTH RECTANGLE AND SQUARE SCENES

        // add content to the Layout panel
        double width = scene.getWidth(); // getting the scene's width
        double height = scene.getHeight(); // getting the scene's height

        // getting the space between each line both when moving in width and height
        double spaceBetweenLinesInWidth = width / 20;
        double spaceBetweenLinesInHeight = height / 20;

        // Solution : Dividing the figure to 4 subFigures -> each corner
        int linesCount = 0; // counting lines drawed, should be 20 starting from each corner
        double byX = 0; // the value that will move by width by space between lines in width
        double byY = 0; // the value that will move by height by space between lines in height

        // Using diffirent colors for lines for each corner to see better what each loop does

        // drawing the bottom left corner
        while (linesCount < 21)
        {
            Line line = new Line(byY / width, byY, byX, height);
            line.setStroke(Color.RED);
            group.getChildren().add(line);
            // updating variables
            linesCount++;
            byX += spaceBetweenLinesInWidth;
            byY += spaceBetweenLinesInHeight;
        }
        //drawing top right corner
        linesCount = 0;
        byX = 0;
        byY = 0;
        while (linesCount < 21)
        {
            Line line = new Line(byX, byY / height, width, byY);
            line.setStroke(Color.GREEN);
            group.getChildren().add(line);
            // updating variables
            linesCount++;
            byX += spaceBetweenLinesInWidth;
            byY += spaceBetweenLinesInHeight;
        }
        //drawing top left corner
        linesCount = 0;
        byX = 0;
        byY = 0;
        while(linesCount < 21)
        {
            Line line = new Line(byX / width,height-byY,byX,0);
            line.setStroke(Color.BLUE);
            group.getChildren().add(line);
            // updating variables
            linesCount++;
            byX += spaceBetweenLinesInWidth;
            byY += spaceBetweenLinesInHeight;
        }
        //drawing bottom right corner
        linesCount = 0;
        byX = 0;
        byY = 0;
        while(linesCount < 21)
        {
            Line line = new Line(byX,height-(byY/height),width,height-byY);
            line.setStroke(Color.BLACK);
            group.getChildren().add(line);
            // updating variables
            linesCount++;
            byX += spaceBetweenLinesInWidth;
            byY += spaceBetweenLinesInHeight;
        }

        // setting the scene and showing it.
        primaryStage.setTitle("HW Problem2 Drawing");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
