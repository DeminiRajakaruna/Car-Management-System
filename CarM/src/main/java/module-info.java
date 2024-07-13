module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens cw.admin to javafx.fxml;
    exports cw.admin;
}