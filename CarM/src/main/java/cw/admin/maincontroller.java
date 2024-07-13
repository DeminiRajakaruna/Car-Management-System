package cw.admin;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class maincontroller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private void Admin(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("adminlogin.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Admin");
            stage.show();
        }
        finally {

        }
    }
    public void Customer(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CustomerSubmenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void Maintaince (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("techlogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void Owner(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ownerlogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}

