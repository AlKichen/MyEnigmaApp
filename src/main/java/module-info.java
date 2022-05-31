module com.example.myenigma3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.datatransfer;


    opens myenigma to javafx.fxml;
    exports myenigma;
}