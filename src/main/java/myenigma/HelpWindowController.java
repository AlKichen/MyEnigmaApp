package myenigma;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class HelpWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem AboutButton;

    @FXML
    private MenuItem HelpButton;

    @FXML
    private MenuItem MenuButtonFileInput;

    @FXML
    private MenuItem MenuButtonFileOutput;

    @FXML
    private MenuItem QuitButton;

    @FXML
    private Button returnButton;

    @FXML
    void initialize() {
        QuitButton.setOnAction(actionEvent -> {
            Platform.exit();
        });
        returnButton.setOnAction(actionEvent -> {
            returnButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FirstWindow.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("MyEnigma 3.0");
            stage.show();
        });
        AboutButton.setOnAction(actionEvent -> {
            Stage owner = (Stage) AboutButton.getParentPopup().getOwnerWindow();
            Scene scene = owner.getScene();
            scene.getWindow().hide();
            //System.out.println("Вы нажали О программе");

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("AboutWindow.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("О Программе");
            stage.show();
        });
    }

}
