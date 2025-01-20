package Greeter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Greeter extends Application {

    @Override
    public void start(Stage window) {

        // Set up input view elements
        Label instructionText = new Label("Enter your name and start"); // Label for instructions
        TextField textField = new TextField(); // TextField for user to input their name
        Button startButton = new Button("Start"); // Button to proceed to the welcome view

        // Layout for the initial view (input view)
        GridPane inputLayout = new GridPane();
        inputLayout.add(instructionText, 0, 0);
        inputLayout.add(textField, 0, 1);
        inputLayout.add(startButton, 0, 2);
        styleLayout(inputLayout);

        // Set up welcome view elements
        GridPane welcomeLayout = new GridPane();
        Label welcomeText = new Label(); // Label to display the welcome message
        welcomeLayout.add(welcomeText, 0, 1);
        styleLayout(welcomeLayout);

        // Create scenes for both views
        Scene textView = new Scene(inputLayout);
        Scene welcomeView = new Scene(welcomeLayout);

        // Set action for start button: display welcome message and switch scene
        startButton.setOnAction((actionEvent -> {
            welcomeText.setText("Welcome " + textField.getText() + "!");
            window.setScene(welcomeView);
        }));

        // Initialize the window with the input view scene and display it
        window.setScene(textView);
        window.show();
    }

    /**
     * Helper method to style a GridPane layout consistently.
     *
     * @param layout The layout to be styled.
     */
    private void styleLayout(GridPane layout) {
        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
    }
}
