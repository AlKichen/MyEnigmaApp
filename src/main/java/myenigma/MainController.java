package myenigma;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem AboutButton;

    @FXML
    private Button ButtonFileInput;

    @FXML
    private Button ButtonFileOutput;

    @FXML
    private Button StartButton;

    @FXML
    private MenuItem HelpButton;

    @FXML
    private ProgressBar ProgressField;

    @FXML
    private MenuItem QuitButton;

    @FXML
    private MenuItem MenuButtonFileInput;

    @FXML
    private MenuItem MenuButtonFileOutput;

    @FXML
    private Label StatusField;

    @FXML
    private ChoiceBox<String> ChoiceBox;

    @FXML
    void initialize() {
        String[] args = new String[3];
        ArrayList<String> value0 = new ArrayList<>();
        ChoiceBox.setItems(FXCollections.observableArrayList("Зашифровать", "Расшифровать"));            //инициализируем choose box
        ChoiceBox.setOnAction(actionEvent -> {
            value0.add(ChoiceBox.getValue());
        });

        ButtonFileInput.setOnAction(actionEvent -> {                                                        //обрабатываем нажатие на кнопку выбора входящего файла
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File inputFile = fileChooser.showOpenDialog(new Stage());
            System.out.println("Вы нажали на кнопку выбора inputFile");
            String inputFileName = inputFile.getAbsolutePath();
            System.out.println(inputFile.getAbsolutePath());
        });
        MenuButtonFileInput.setOnAction(actionEvent -> {                                                        //обрабатываем нажатие на кнопку выбора входящего файла
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File inputFile = fileChooser.showOpenDialog(new Stage());
            System.out.println("Вы нажали на кнопку выбора inputFile");
            if (inputFile != null) {
                String inputFileName = inputFile.getAbsolutePath();
                System.out.println(inputFile.getAbsolutePath());
            }
        });
        ButtonFileOutput.setOnAction(actionEvent -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File outputFile = directoryChooser.showDialog(new Stage());
            System.out.println("Вы нажали на кнопку выбора OutputFile");
            if (outputFile != null) {
                String outputFileName = outputFile.getAbsolutePath();
                System.out.println(outputFile.getAbsolutePath());
            }
        });
        MenuButtonFileOutput.setOnAction(actionEvent -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File outputFile = directoryChooser.showDialog(new Stage());
            System.out.println("Вы нажали на кнопку выбора OutputFile");
            if (outputFile != null) {
                String outputFileName = outputFile.getAbsolutePath();
                System.out.println(outputFile.getAbsolutePath());
            }
        });


    }

}
