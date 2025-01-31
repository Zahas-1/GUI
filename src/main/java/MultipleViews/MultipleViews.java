package MultipleViews;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {
    @Override
    public void start(Stage window) {
        // Creating layout containers for each view
        BorderPane first = new BorderPane();  // Layout for the first view
        VBox second = new VBox();  // Layout for the second view
        GridPane third = new GridPane();  // Layout for the third view

        // Creating scenes for each layout
        Scene viewFirst = new Scene(first);
        Scene viewSecond = new Scene(second);
        Scene viewThird = new Scene(third);

        // Creating buttons to navigate between views
        Button toFirst = new Button("To the first view!");
        Button toSecond = new Button("To the second view!");
        Button toThird = new Button("To the third view!");

        // Setting up the first view layout
        first.setTop(new Label("First view!"));  // Adding label at the top
        first.setCenter(toSecond);  // Adding button to the center
        toSecond.setOnAction((actionEvent -> window.setScene(viewSecond)));  // Switch to second view on button click

        // Setting up the second view layout
        second.setSpacing(10);  // Adds spacing between elements
        second.getChildren().addAll(toThird, new Label("Second View!"));  // Adding button and label to VBox
        toThird.setOnAction((actionEvent -> window.setScene(viewThird)));  // Switch to third view on button click

        // Setting up the third view layout
        third.add(new Label("Third view"), 0, 0);  // Adding label to (0, 0) position in GridPane
        third.add(toFirst, 1, 1);  // Adding button to (1, 1) position in GridPane
        toFirst.setOnAction((actionEvent -> window.setScene(viewFirst)));  // Switch to first view on button click

        // Setting the initial scene to the first view
        window.setScene(viewFirst);
        window.show();  // Display the window
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);  // Launch the JavaFX application
    }
}
