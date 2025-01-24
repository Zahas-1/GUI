package Joke;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Joke extends Application {

    public static void main(String[] args) {
        launch(Joke.class);
    }
    @Override
    public void start(Stage window){
        //1. Create a main layout
        BorderPane layout = new BorderPane();

        //1.1 Create menu for main layout
        HBox menu = new HBox();
        menu.setPadding(new Insets(20,20,20,20));
        menu.setSpacing(10);

        //1.2 Create buttons for menu
        Button joke = new Button("The Joke");
        Button punchline = new Button("The Punchline");
        Button explanation = new Button("The Explanation");

        //1.3 Add buttons to menu
        menu.getChildren().addAll(joke, punchline, explanation);

        layout.setTop(menu);

        //2. Add subviews and add them to the menu buttons
        //2.1 Create a subview layout
        StackPane jokeLayout = createView("What do you call a bear with no teeth?");
        StackPane punchLayout = createView("A gummy bear");
        StackPane explLayout = createView("No teeth means you presumably only have gums");

        //2.2 Add subviews to button. Pressing the buttons will change the view
        joke.setOnAction((event) -> layout.setCenter(jokeLayout));
        punchline.setOnAction((event) -> layout.setCenter(punchLayout));
        explanation.setOnAction((event) -> layout.setCenter(explLayout));

        //2.3 Set initial view
        layout.setCenter(jokeLayout);

        //3 Create a main scene with layout
        Scene scene = new Scene(layout);

        //4 Show the main scene
        window.setScene(scene);
        window.show();

    }
    private StackPane createView(String text){
        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
}
