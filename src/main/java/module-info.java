module java.module {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.gui to javafx.fxml;
    exports org.example.gui;
    exports MyFirstApplication;
    exports TextStatistics;
    exports Notifier;
    exports UsersTitle;
    exports MultipleViews;
    exports Greeter;
    exports Joke;
    exports Dictionary;
    exports TicTacToe;

}
