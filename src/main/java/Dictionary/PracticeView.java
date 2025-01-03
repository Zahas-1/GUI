package Dictionary;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * The `PracticeView` class provides a user interface for practicing translations from the dictionary.
 * It presents a word to translate and allows the user to input a translation and receive feedback.
 */
public class PracticeView {
    private Dictionary dictionary; // The dictionary used for word translations
    private String word; // The current word for translation

    /**
     * Constructor for `PracticeView`.
     *
     * @param dictionary The dictionary used to retrieve words and translations.
     */
    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = dictionary.getRandomWord(); // Set the initial word to a random word from the dictionary
    }

    /**
     * Creates and returns the user interface (UI) layout for the practice view.
     *
     * @return A Parent node containing the layout of the practice view.
     */
    public Parent getview() {
        GridPane layout = new GridPane(); // Main layout for the practice view

        // Instruction label displaying the word to translate
        Label wordInstruction = new Label("Translate the word '" + this.word + "'");
        TextField translationField = new TextField(); // Input field for the user to enter their translation

        // Configure layout properties
        layout.setAlignment(Pos.CENTER); // Center align all elements
        layout.setVgap(10); // Vertical spacing between elements
        layout.setHgap(10); // Horizontal spacing between elements
        layout.setPadding(new Insets(10, 10, 10, 10)); // Padding around the layout

        // Button for checking the user's translation
        Button addButton = new Button("Check");

        // Label for displaying feedback on the user's translation
        Label feedback = new Label("");

        // Add components to the grid layout
        layout.add(wordInstruction, 0, 0); // Instruction label in row 0, column 0
        layout.add(translationField, 0, 1); // Text field in row 1, column 0
        layout.add(addButton, 0, 2); // Button in row 2, column 0
        layout.add(feedback, 0, 3); // Feedback label in row 3, column 0

        // Event handler for the "Check" button
        addButton.setOnMouseClicked((event) -> {
            String translation = translationField.getText(); // Get the user's input
            if (dictionary.get(word).equals(translation)) {
                // If the translation is correct
                feedback.setText("Correct!");
            } else {
                // If the translation is incorrect
                feedback.setText("Incorrect! The translation for the word '" + word + "' is '" + dictionary.get(word) + "'.");
            }
            // Update the current word to a new random word
            this.word = this.dictionary.getRandomWord();
            wordInstruction.setText("Translate the word '" + this.word + "'");
            translationField.clear(); // Clear the input field for the next attempt
        });

        return layout; // Return the constructed layout
    }
}
