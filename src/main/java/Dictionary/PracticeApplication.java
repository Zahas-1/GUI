package Dictionary;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Main application class for the dictionary practice application.
 * Combines an input view for adding words and a practice view for practicing translations.
 */
public class PracticeApplication extends Application {

    private Dictionary dictionary; // The dictionary used by the application to store and retrieve word pairs

    /**
     * Initializes the application by creating a dictionary instance.
     * This method is called before the `start` method.
     */
    public void init() throws Exception {
        // 1. Create the dictionary that the application uses
        this.dictionary = new Dictionary();
    }

    /**
     * Starts the application and sets up the user interface.
     *
     * @param stage The main window (stage) for the application.
     */
    @Override
    public void start(Stage stage) throws Exception {
        // 2. Create the views ("subviews") for the application
        PracticeView practiceView = new PracticeView(dictionary); // View for practicing word translations
        InputView inputView = new InputView(dictionary); // View for entering new word pairs

        // 3. Create the main layout for the application
        BorderPane layout = new BorderPane();

        // 3.1 Create the menu for the top of the application layout
        HBox menu = new HBox(); // A horizontal box to hold menu buttons
        menu.setPadding(new Insets(20, 20, 20, 20)); // Add padding around the menu
        menu.setSpacing(10); // Set spacing between menu buttons

        // 3.2 Create the menu buttons
        Button enterButton = new Button("Enter new words"); // Button to switch to the input view
        Button practiceButton = new Button("Practice"); // Button to switch to the practice view

        // 3.3 Add the buttons to the menu
        menu.getChildren().addAll(enterButton, practiceButton); // Add the buttons to the menu layout
        layout.setTop(menu); // Set the menu at the top of the BorderPane layout

        // 4. Connect the menu buttons to the subviews
        // Clicking the "Enter new words" button switches the center view to the input view
        enterButton.setOnAction((event) -> layout.setCenter(inputView.getView()));
        // Clicking the "Practice" button switches the center view to the practice view
        practiceButton.setOnAction((event) -> layout.setCenter(practiceView.getview()));

        // 5. Show the input view as the initial view
        layout.setCenter(inputView.getView());

        // 6. Create the main scene with the layout and set its dimensions
        Scene view = new Scene(layout, 400, 300);

        // 7. Show the application by setting the scene on the stage and displaying it
        stage.setScene(view);
        stage.show();
    }

    /**
     * Main entry point for launching the application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        launch(PracticeApplication.class);
    }
}
