package Notifier;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Notifier extends Application {
    @Override
    public void start(Stage window) {
        // Creating UI components: a button, a text field, and a label
        Button button = new Button("Update");           // Button to update label with text field value
        TextField textField = new TextField();          // Text field for user input
        Label textLabel = new Label("");                // Label to display the text field's content

        // Setting up the button action to update the label with the text field's current content
        button.setOnAction((event) -> {
            textLabel.setText(textField.getText());     // Set label text to text field input on button click
        });

        // Adding a listener to observe changes in the text field
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> change, String oldValue, String newValue) {
                System.out.println(oldValue + " -> " + newValue);   // Log old and new values to console
                textField.setText(newValue);                        // Update the text field with new value
            }
        });

        // Arranging components vertically with spacing between them
        VBox textObjects = new VBox();
        textObjects.setSpacing(10);                                // Space between elements in VBox
        textObjects.getChildren().addAll(textField, button, textLabel); // Add text field, button, and label to VBox

        // Setting up the scene with the VBox containing all components
        Scene scene = new Scene(textObjects);

        // Configuring and displaying the window
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(Notifier.class);  // Launch the JavaFX application
    }
}
