package cw.admin;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
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

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.stream.Collectors;


public class Appointments implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public  TableView<TestRides> tableView;
    public TableColumn<TestRides,String> colMake;
    public TableColumn<TestRides,String> colModel;
    public TableColumn<TestRides,String> colName;
    public TableColumn<TestRides,String> colTelephone;
    public  TableColumn<TestRides,Integer> colMileage;
    public  TableColumn<TestRides,Integer> colYear;
    public  TableColumn<TestRides,Integer> colPrice;
    public TableColumn<TestRides,String> colAppointment;

    public  TableView<SoldCars> tableView1;
    public TableColumn<SoldCars,String> colMake1;
    public TableColumn<SoldCars,String> colModel1;
    public TableColumn<SoldCars,String> colSoldDate;
    public  TableColumn<SoldCars,Integer> colMileage1;
    public  TableColumn<SoldCars,Integer> colYear1;
    public  TableColumn<SoldCars,String> colName1;
    public TableColumn<SoldCars,String> colTelephone1;
    public  TableColumn<SoldCars,Integer> colPrice1;


    public TextField textfieldMake;
    public TextField textfieldModel;
    public TextField textfieldMileage;
    public TextField textfieldYear;
    public TextField textfieldPrice;
    public DatePicker textfieldAppointment;
    public TextField textfieldName;
    public TextField textfieldTelephone;
    public Label msg;
    public Appointments() throws IOException {
    }

    @Override

    public void initialize(URL location,ResourceBundle resources){
        colMake.setCellValueFactory(new PropertyValueFactory<>("Make"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("Model"));
        colAppointment.setCellValueFactory(new PropertyValueFactory<>("Appointment"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("Year"));
        colMileage.setCellValueFactory(new PropertyValueFactory<>("Mileage"));
        colTelephone.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colMake1.setCellValueFactory(new PropertyValueFactory<>("Make"));
        colModel1.setCellValueFactory(new PropertyValueFactory<>("Model"));
        colYear1.setCellValueFactory(new PropertyValueFactory<>("Year"));
        colMileage1.setCellValueFactory(new PropertyValueFactory<>("Mileage"));
        colTelephone1.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        colPrice1.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colSoldDate.setCellValueFactory(new PropertyValueFactory<>("SoldDate"));
        colName1.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tableView.setEditable(false);
        tableView1.setEditable(false);
        colMake.setCellFactory(TextFieldTableCell.forTableColumn());
        colModel.setCellFactory(TextFieldTableCell.forTableColumn());
        colAppointment.setCellFactory(TextFieldTableCell.forTableColumn());
        colMileage.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colYear.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colPrice.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colTelephone.setCellFactory(TextFieldTableCell.forTableColumn());
        colName.setCellFactory(TextFieldTableCell.forTableColumn());
        colMake1.setCellFactory(TextFieldTableCell.forTableColumn());
        colName1.setCellFactory(TextFieldTableCell.forTableColumn());
        colModel1.setCellFactory(TextFieldTableCell.forTableColumn());
        colMileage1.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colYear1.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colPrice1.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colSoldDate.setCellFactory(TextFieldTableCell.forTableColumn());
        textfieldName.setEditable(false);
        textfieldMileage.setEditable(false);
        textfieldYear.setEditable(false);
        textfieldMake.setEditable(false);
        textfieldModel.setEditable(false);
        textfieldTelephone.setEditable(false);
        textfieldPrice.setEditable(false);

        try {
            Collection<TestRides> list = Files.readAllLines(new File("ReservedTestDrives.txt").toPath())
                    .stream()
                    .map(line -> {
                        String[] details = line.split("#");

                        TestRides testRides =new TestRides(details[0],details[1], Integer.parseInt(details[2]),Integer.parseInt(details[3]),
                                Integer.parseInt(details[4]),details[5],details[6], details[7]);
                        System.out.println("");
                        tableView.getItems().add(testRides);
                        return testRides;
                    })
                    .collect(Collectors.toList());
            Collection<SoldCars> list1 = Files.readAllLines(new File("SoldCars.txt").toPath())
                    .stream()
                    .map(line -> {
                        String[] details = line.split("#");
                        SoldCars soldCars =new SoldCars(details[0],details[1], Integer.parseInt(details[2]),Integer.parseInt(details[3]),
                                Integer.parseInt(details[4]),details[5],details[6], details[7]);
                        System.out.println("");
                        tableView1.getItems().add(soldCars);
                        return soldCars;
                    })
                    .collect(Collectors.toList());}catch (IOException E){}

    }
    ObservableList<Service> observableList= FXCollections.observableArrayList(
    );
    ObservableList<Service> observableList1= FXCollections.observableArrayList(
    );
    public void AddAppointment(ActionEvent actionEvent) throws IOException{
        if (!textfieldAppointment.getEditor().getText().isBlank()){
            TestRides product1 =new TestRides(textfieldMake.getText(),textfieldModel.getText(),
                    Integer.parseInt(textfieldYear.getText()),Integer.parseInt(textfieldMileage.getText()),
                    Integer.parseInt(textfieldPrice.getText()),textfieldName.getText(), textfieldTelephone.getText(),textfieldAppointment.getEditor().getText());
            tableView.getItems().add(product1);
            textfieldAppointment.getEditor().clear();
            textfieldName.clear();
            textfieldTelephone.clear();
            textfieldName.clear();
            textfieldModel.clear();
            textfieldMake.clear();
            textfieldPrice.clear();
            textfieldYear.clear();
            textfieldMileage.clear();
        }
        else {

        }

    }

    public void Back(ActionEvent actionEvent) throws IOException{
        BufferedWriter myWriter = null;
        try {
            myWriter =  new BufferedWriter(new FileWriter("ReservedTestDrives1.txt"));
            Admin x = new Admin();
            for (int i = 0; i < tableView.getItems().size(); i++)
                myWriter.write(colTelephone.getCellData(i)+"#"+"Make -"+colMake.getCellData(i)+":"+"Model -"+colModel.getCellData(i)+": "
                        +"Year -"+colYear.getCellData(i)+":"+"Mileage -"+colMileage.getCellData(i)+":"+"Price -"+colPrice.getCellData(i)+":"+
                        "Name -"+colName.getCellData(i)+":"+"Appointment Date -"+colAppointment.getCellData(i)+"\r\n");
            myWriter.close();}
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            myWriter =  new BufferedWriter(new FileWriter("ReservedTestDrives.txt"));
            Admin x = new Admin();
            for (int i = 0; i < tableView.getItems().size(); i++)
                myWriter.write(colMake.getCellData(i)+"#"+colModel.getCellData(i)+"#"
                        +colYear.getCellData(i)+"#"+colMileage.getCellData(i)+"#"+colPrice.getCellData(i)+"#"+
                        colName.getCellData(i)+"#"+colTelephone.getCellData(i)+"#"+colAppointment.getCellData(i)+"\r\n");
            myWriter.close();}
        catch (IOException e) {
            throw new RuntimeException(e);

        }
        finally {
            Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Inventory");
            stage.show();
        }

    }
    public void Remove(ActionEvent actionEvent) throws IOException{

    }
    public void SelectAppointment(ActionEvent actionEvent) throws IOException{
        if (tableView.getSelectionModel().getSelectedItem().AppointmentProperty().get().equals("Requested")){
        try {
            ObservableList<TestRides> allProduct,SingleProduct;
            allProduct = tableView.getItems();
            String x ;String y;String z;String a;String b;String c;String d;
            x = tableView.getSelectionModel().getSelectedItem().MakeProperty().get();
            textfieldMake.setText(x);
            y = tableView.getSelectionModel().getSelectedItem().ModelProperty().get();
            textfieldModel.setText(y);
            z = String.valueOf(tableView.getSelectionModel().getSelectedItem().yearProperty().get());
            textfieldYear.setText(z);
            a = String.valueOf(tableView.getSelectionModel().getSelectedItem().mileageProperty().get());
            textfieldMileage.setText(a);
            b = String.valueOf(tableView.getSelectionModel().getSelectedItem().PriceProperty().get());
            textfieldPrice.setText(b);
            c = String.valueOf(tableView.getSelectionModel().getSelectedItem().nameProperty().get());
            textfieldName.setText(c);
            d = tableView.getSelectionModel().getSelectedItem().telephoneProperty().get();
            textfieldTelephone.setText(d);
            allProduct = tableView.getItems();
            SingleProduct = tableView.getSelectionModel().getSelectedItems();
            SingleProduct.forEach(allProduct::remove);
        }
        finally {

        }
        }
        else {msg.setText("Already added");}

    }




}
