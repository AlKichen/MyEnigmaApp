module com.example.myenigma3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens myenigma to javafx.fxml;
    exports myenigma;
}