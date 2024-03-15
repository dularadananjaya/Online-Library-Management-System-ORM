package lk.ijse;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class launcher {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/user_login_form.fxml"))));
        stage.setTitle("Login");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }
}
