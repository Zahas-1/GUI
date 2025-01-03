package Dictionary;

import TextStatistics.TextStatistics;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * A UI component for adding word-translation pairs to a dictionary.
 * Allows the user to input a word and its translation and add it to the dictionary.
 */
public class InputView {
    private Dictionary dictionary; // Reference to the dictionary for storing word pairs

    /**
     * Constructor for the InputView class.
     * Associates the InputView with a specific dictionary instance.
     *
     * @param dictionary The dictionary to which word-translation pairs will be added.
     */
    public InputView(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    /**
     * Creates and returns the user interface (UI) for the input view.
     *
     * @return A Parent node containing the layout for the input view.
     */
    public Parent getView() {
        // Create a grid layout for arranging UI elements
        GridPane layout = new GridPane();

        // Instructions and input fields for the word and its translation
        Label wordInstruction = new Label("Word"); // Label for the word input field
        TextField wordField = new TextField(); // Text field for entering a word
        Label translationInstruction = new Label("Translation"); // Label for the translation input field
        TextField translationField = new TextField(); // Text field for entering the translation

        // Configure grid layout properties
        layout.setAlignment(Pos.CENTER); // Center the layout
        layout.setVgap(10); // Set vertical spacing between rows
        layout.setHgap(10); // Set horizontal spacing between columns
        layout.setPadding(new Insets(10, 10, 10, 10)); // Add padding around the grid

        // Button to add the entered word-translation pair to the dictionary
        Button addButton = new Button("Add the word pair");

        // Add UI components to the grid
        layout.add(wordInstruction, 0, 0); // Add word label at row 0, column 0
        layout.add(wordField, 0, 1); // Add word input field at row 1, column 0
        layout.add(translationInstruction, 0, 2); // Add translation label at row 2, column 0
        layout.add(translationField, 0, 3); // Add translation input field at row 3, column 0
        layout.add(addButton, 0, 4); // Add button at row 4, column 0

        // Event handler for the add button
        addButton.setOnMouseClicked((event) -> {
            String word = wordField.getText(); // Get the text entered in the word field
            String translation = translationField.getText(); // Get the text entered in the translation field

            dictionary.add(word, translation); // Add the word-translation pair to the dictionary

            wordField.clear(); // Clear the word input field
            translationField.clear(); // Clear the translation input field
        });

        return layout; // Return the completed layout as a Parent node
    }
}
