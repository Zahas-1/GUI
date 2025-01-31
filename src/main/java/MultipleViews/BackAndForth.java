package MultipleViews;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BackAndForth extends Application {
    @Override
    public void start(Stage window) {

        // Creating buttons to switch between scenes
        Button back = new Button("Back ..");
        Button forth = new Button(".. forth.");

        // Creating two scenes, each containing one of the buttons
        Scene first = new Scene(back);   // Scene with "Back" button
        Scene second = new Scene(forth); // Scene with "Forth" button

        // Setting the action for the "Back" button to switch to the second scene
        back.setOnAction((event) -> {
            window.setScene(second);  // Switch to second scene
        });

        // Setting the action for the "Forth" button to switch back to the first scene
        forth.setOnAction((event) -> {
            window.setScene(first);   // Switch back to first scene
        });

        // Setting the initial scene to the first view
        window.setScene(first);
        window.show();  // Display the window with the first scene
    }

    public static void main(String[] args) {
        launch(BackAndForth.class);  // Launch the JavaFX application
    }
}
