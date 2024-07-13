package cw.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class adminlogin {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public TextField input;
    @FXML
    public void enter(ActionEvent actionEvent){
        if (Objects.equals(input.getText(), "123")){
            try {
                root = FXMLLoader.load(getClass().getResource("AdminSubmenu.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else {
            try {
                root = FXMLLoader.load(getClass().getResource("page6invalid.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}