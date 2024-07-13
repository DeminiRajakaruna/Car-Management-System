package cw.admin;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.util.converter.IntegerStringConverter;

import java.time.Month;
import java.util.Date;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.stream.Collectors;


public class Status implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    public TextField SearchBar;
    public TextField SearchBar1;
    public TextArea textline;
    public TextArea textline1;
    Map<String, String> soldstatus = new HashMap<String, String>();
    Map<String, String> servicestatus = new HashMap<String, String>();

    public Status() throws IOException {
    }

    @Override

    public void initialize(URL location,ResourceBundle resources){
        try {
            FileReader csv = new FileReader("KeyDataSold.txt");
            BufferedReader csvbuffer = new BufferedReader(csv);
            String i;
            while((i=csvbuffer.readLine())!=null){
                String data[]=i.split("#");
                List<String> datalist=new ArrayList<String>();
                String data2[]=data[1].split(":");
                soldstatus.put(data[0],data2[0]+"" +
                        ""+data2[1]+"\n"+data2[2]+"\n"+data2[3]+"\n"+data2[4]+"\n"+data2[5]);
            }
        }catch (IOException ioException){
        }
        try{
            FileReader csv = new FileReader("KeyDataMaintain.txt");
            BufferedReader csvbuffer = new BufferedReader(csv);
            String i;
            while((i=csvbuffer.readLine())!=null){
                String data[]=i.split("#");
                List<String> datalist=new ArrayList<String>();
                String data2[]=data[1].split(":");
                servicestatus.put(data[0],data2[0]+"" +
                        ""+data2[1]+"\n"+data2[2]+"\n"+data2[3]+"\n"+data2[4]+"\n"+data2[5]+"\n"+data2[6]);}
        }catch (IOException ioException){

        }
    }


    public void Back(ActionEvent actionEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("LogIn");
        stage.show();

    }
    public void Search(ActionEvent actionEvent) throws IOException{
        FileReader csv = new FileReader("KeyDataSold.txt");
        BufferedReader csvbuffer = new BufferedReader(csv);
        String i;
        while((i=csvbuffer.readLine())!=null){
            String data[]=i.split("#");
            List<String> datalist=new ArrayList<String>();
            String data2[]=data[1].split(":");
            soldstatus.put(data[0],data2[0]+"" +"\n"+
                    ""+data2[1]+"\n"+data2[2]+"\n"+data2[3]+"\n"+data2[4]+"\n"+data2[5]);
        }
        String telephone = SearchBar.getText();
        if(soldstatus.get(telephone) == null){
            textline.setText("Not Found!");}
        else {
            textline.setText(soldstatus.get(telephone));}

    }
    public void Search1(ActionEvent actionEvent) throws IOException{
        FileReader csv = new FileReader("KeyDataMaintain.txt");
        BufferedReader csvbuffer = new BufferedReader(csv);
        String i;
        while((i=csvbuffer.readLine())!=null){
            String data[]=i.split("#");
            List<String> datalist=new ArrayList<String>();
            String data2[]=data[1].split(":");
            servicestatus.put(data[0],data2[0]+"" +"\n"+
                    ""+data2[1]+"\n"+data2[2]+"\n"+data2[3]+"\n"+data2[4]+"\n"+data2[5]+"\n"+data2[6]);
        }
        String telephone = SearchBar1.getText();
        if(servicestatus.get(telephone) == null){
            textline1.setText("Not Found!");}
        else {
            try {
                textline1.setText(servicestatus.get(telephone));
            } finally {

            }
        }

    }
}