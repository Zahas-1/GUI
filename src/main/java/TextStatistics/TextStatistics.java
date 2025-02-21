package TextStatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatistics extends Application {
    @Override
    public void start(Stage window) {
        // Create a BorderPane layout to organize elements in different areas
        BorderPane layout = new BorderPane();

        // Create an HBox to hold the labels for text statistics
        HBox textComponents = new HBox();
        textComponents.setSpacing(10); // Set spacing between labels

        // Add labels to display initial text statistics: letters count, words count, and longest word
        textComponents.getChildren().add(new Label("Letters: 0"));
        textComponents.getChildren().add(new Label("Words: 0"));
        textComponents.getChildren().add(new Label("The longest word is:"));

        // Add a TextArea to the center of the layout for user input
        layout.setCenter(new TextArea(""));

        // Place the HBox with labels at the bottom of the BorderPane
        layout.setBottom(textComponents);

        // Create a scene containing the BorderPane layout
        Scene view = new Scene(layout);

        // Set up and display the stage with the created scene
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(TextStatistics.class);
    }
}
