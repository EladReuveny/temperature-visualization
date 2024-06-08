package q2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Elad Reuveny
 * Maman 11 - question 2
 * This class runs the FXML file.
 */
public class PressMe extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PressMe.class.getResource("PressMe.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 250,350);
        stage.setTitle("Temperatures");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}