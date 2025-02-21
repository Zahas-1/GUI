package TextStatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class TextStatistics2 extends Application {
    @Override
    public void start(Stage window) {
        // Create the main layout for the application
        BorderPane layout = new BorderPane();

        // Create an HBox to display the text statistics (letters, words, longest word)
        HBox textComponents = new HBox();
        textComponents.setSpacing(10);  // Set spacing between labels

        // Create labels to display the number of letters, words, and longest word
        Label letters = new Label("Letters: ");
        Label words1 = new Label("Words: ");
        Label longestWord = new Label("The longest word is: ");

        // Add the labels to the HBox
        textComponents.getChildren().add(letters);
        textComponents.getChildren().add(words1);
        textComponents.getChildren().add(longestWord);

        // Create a TextArea in the center of the layout for user input
        TextArea textArea = new TextArea("");

        // Add a listener to the text area to respond when text is changed
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            // Calculate the number of characters in the new text
            int characters = newValue.length();

            // Split the text into words by spaces and calculate the word count
            String[] parts = newValue.split(" ");
            int words = parts.length;

            // Find the longest word by sorting words by length in descending order
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();

            // Update labels with the new statistics
            letters.setText("Letters " + characters);
            words1.setText("Words: " + words);
            longestWord.setText("The longest word is: " + longest);
        });

        // Add the TextArea to the center of the layout
        layout.setCenter(textArea);

        // Add the HBox with labels to the bottom of the layout
        layout.setBottom(textComponents);

        // Create a scene containing the layout and set it on the stage
        Scene view = new Scene(layout);
        window.setScene(view);

        // Show the stage
        window.show();
    }

    public static void main(String[] args) {
        // Launch the application
        launch(TextStatistics2.class);
    }
}
