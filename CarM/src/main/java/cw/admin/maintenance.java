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

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.stream.Collectors;


public class maintenance implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public  TableView<Service> tableView;
    public TableColumn<Service,String> colMake;
    public TableColumn<Service,String> colModel;
    public TableColumn<Service,String> colReport;
    public TableColumn<Service,String> colCustomerName;
    public TableColumn<Service,String> colTelephone;
    public  TableColumn<Service,Integer> colMileage;
    public  TableColumn<Service,Integer> colYear;
    public  TableColumn<Service,Integer> colCost;
    public TableColumn<Service,String> ColMaintenance;

    public  TableView<Service> tableView1;
    public TableColumn<Service,String> colMake1;
    public TableColumn<Service,String> colModel1;
    public TableColumn<Service,String> ColMaintenance1;
    public  TableColumn<Service,Integer> colMileage1;
    public  TableColumn<Service,Integer> colYear1;
    public  TableColumn<Service,String> ColName;
    public TableColumn<Service,String> ColTelephone;
    public  TableColumn<Service,Integer> colCost1;
    public TableColumn<Service,String> colReport1;

    public TextField textfieldMake;
    public TextField textfieldModel;
    public TextField textfieldMileage;
    public TextField textfieldYear;
    public TextField textfieldCost;
    public TextField textfieldAddReport;
    public TextField textfieldName;
    public TextField textfieldTelephone;
    public Label msg;
    @FXML
    public ComboBox MonthMenu;
    public maintenance() throws IOException {
    }

    @Override

    public void initialize(URL location,ResourceBundle resources){
        colMake1.setCellValueFactory(new PropertyValueFactory<>("VehicleMake"));
        colModel1.setCellValueFactory(new PropertyValueFactory<>("VehicleModel"));
        ColMaintenance.setCellValueFactory(new PropertyValueFactory<>("Maintenance"));
        ColMaintenance1.setCellValueFactory(new PropertyValueFactory<>("Maintenance"));
        colYear1.setCellValueFactory(new PropertyValueFactory<>("Year"));
        colMileage1.setCellValueFactory(new PropertyValueFactory<>("Mileage"));
        ColTelephone.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        ColName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colMake.setCellValueFactory(new PropertyValueFactory<>("VehicleMake"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("VehicleModel"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("Year"));
        colMileage.setCellValueFactory(new PropertyValueFactory<>("Mileage"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colTelephone.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        colCost.setCellValueFactory(new PropertyValueFactory<>("ServiceCost"));
        colCost1.setCellValueFactory(new PropertyValueFactory<>("ServiceCost"));
        colReport.setCellValueFactory(new PropertyValueFactory<>("Report"));
        colReport1.setCellValueFactory(new PropertyValueFactory<>("Report"));
        tableView.setEditable(false);
        tableView1.setEditable(false);
        colMake1.setCellFactory(TextFieldTableCell.forTableColumn());
        colModel1.setCellFactory(TextFieldTableCell.forTableColumn());
        ColMaintenance.setCellFactory(TextFieldTableCell.forTableColumn());
        colMileage1.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colYear1.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        ColTelephone.setCellFactory(TextFieldTableCell.forTableColumn());
        colTelephone.setCellFactory(TextFieldTableCell.forTableColumn());
        ColName.setCellFactory(TextFieldTableCell.forTableColumn());
        colModel.setCellFactory(TextFieldTableCell.forTableColumn());
        colMileage.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colYear.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colCustomerName.setCellFactory(TextFieldTableCell.forTableColumn());
        colCost.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colReport.setCellFactory(TextFieldTableCell.forTableColumn());
        colCost1.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colReport1.setCellFactory(TextFieldTableCell.forTableColumn());
        ColMaintenance1.setCellFactory(TextFieldTableCell.forTableColumn());
        textfieldName.setEditable(false);
        textfieldMileage.setEditable(false);
        textfieldYear.setEditable(false);
        textfieldMake.setEditable(false);
        textfieldModel.setEditable(false);
        textfieldTelephone.setEditable(false);
        MonthMenu.setItems(FXCollections.observableArrayList("January","February","March","April","May","June",
                "July","August","September","October","November","December"));


        try {
            Collection<Service> list = Files.readAllLines(new File("AddForServices.txt").toPath())
                    .stream()
                    .map(line -> {
                        String[] details = line.split("#");
                        //String VehicleMake, String VehicleModel, String Maintenance ,Integer Year,Integer Mileage,
                        //    Integer ServiceCost,String Name,String Telephone,String Report
                        Service service =new Service(details[0],details[1], details[2],Integer.parseInt(details[3]),
                                Integer.parseInt(details[4]),Integer.parseInt(details[5]),details[6], details[7],
                                (details[8]));
                        System.out.println("");
                        tableView1.getItems().add(service);
                        return service;
                    })
                    .collect(Collectors.toList());
            Collection<Service> list1 = Files.readAllLines(new File("CompletedServices.txt").toPath())
                    .stream()
                    .map(line -> {
                        String[] details = line.split("#");
                        Service service =new Service(details[0],details[1], details[2],Integer.parseInt(details[3]),
                                Integer.parseInt(details[4]),Integer.parseInt(details[5]),details[6], details[7],
                                (details[8]));
                        System.out.println("");
                        tableView.getItems().add(service);
                        return service;
                    })
                    .collect(Collectors.toList());}catch (IOException E){}

    }
    ObservableList<Service> observableList= FXCollections.observableArrayList(
    );
    ObservableList<Service> observableList1= FXCollections.observableArrayList(
    );
    public void AddReport(ActionEvent actionEvent) throws IOException{
        if (!textfieldCost.getText().isBlank()&&!textfieldAddReport.getText().isBlank()){
            try {
                Collection<ProfitByMonth> list = Files.readAllLines(new File("ServiceProfit.txt").toPath())
                        .stream()
                        .map(line -> {
                            String[] details = line.split("#");
                            ProfitByMonth product =new ProfitByMonth(details[0],details[1] ,details[2] ,details[3] ,details[4] ,details[5] ,details[6] ,
                                    details[7] ,details[8] ,details[9] ,details[10] ,details[11] );
                            Integer Profit;
                            Profit = Integer.valueOf(textfieldCost.getText());
                            String month = MonthMenu.getValue().toString();
                            switch (month) {
                                case "January":
                                    product.setJAN(String.valueOf(Integer.parseInt(product.getJAN())+Profit));
                                    break;
                                case "February":
                                    product.setFEB(String.valueOf(Integer.parseInt(product.getFEB())+Profit));
                                    break;
                                case "March":
                                    product.setMAR(String.valueOf(Integer.parseInt(product.getMAR())+Profit));
                                    break;
                                case "April":
                                    product.setAPR(String.valueOf(Integer.parseInt(product.getAPR())+Profit));
                                    break;
                                case "May":
                                    product.setMAY(String.valueOf(Integer.parseInt(product.getMAY())+Profit));
                                    break;
                                case "June":
                                    product.setJUN(String.valueOf(Integer.parseInt(product.getJUN())+Profit));
                                    break;
                                case "July":
                                    product.setJULY(String.valueOf(Integer.parseInt(product.getJULY())+Profit));
                                    break;
                                case "August":
                                    product.setAUG(String.valueOf(Integer.parseInt(product.getAUG())+Profit));
                                    break;
                                case "September":
                                    product.setSEP(String.valueOf(Integer.parseInt(product.getSEP())+Profit));
                                    break;
                                case "October":
                                    product.setOCT(String.valueOf(Integer.parseInt(product.getOCT())+Profit));
                                    break;
                                case "November":
                                    product.setNOV(String.valueOf(Integer.parseInt(product.getNOV())+Profit));
                                    break;
                                case "December":
                                    product.setDEC(String.valueOf(Integer.parseInt(product.getDEC())+Profit));
                                    break;
                            }
                            System.out.println(product.getJAN());
                            try {
                                FileWriter X = new FileWriter("ServiceProfit.txt");
                                X.write(product.getJAN()+"#"+product.getFEB()+"#"+product.getMAR()+"#"+product.getAPR()+"#"
                                        +product.getMAY()+"#"+product.getJUN()+"#"+product.getJULY()+"#"+product.getAUG()+"#"+
                                        product.getSEP()+"#"+product.getOCT()+"#"+product.getNOV()+"#"+product.getDEC());
                                X.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            return product;
                        })
                        .collect(Collectors.toList());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                Collection<ProfitByMonth> list = Files.readAllLines(new File("TotalIncome.txt").toPath())
                        .stream()
                        .map(line -> {
                            String[] details = line.split("#");
                            ProfitByMonth product =new ProfitByMonth(details[0],details[1] ,details[2] ,details[3] ,details[4] ,details[5] ,details[6] ,
                                    details[7] ,details[8] ,details[9] ,details[10] ,details[11] );
                            Integer Profit;
                            Profit = Integer.valueOf(textfieldCost.getText());
                            String month = MonthMenu.getValue().toString();
                            switch (month) {
                                case "January":
                                    product.setJAN(String.valueOf(Integer.parseInt(product.getJAN())+Profit));
                                    break;
                                case "February":
                                    product.setFEB(String.valueOf(Integer.parseInt(product.getFEB())+Profit));
                                    break;
                                case "March":
                                    product.setMAR(String.valueOf(Integer.parseInt(product.getMAR())+Profit));
                                    break;
                                case "April":
                                    product.setAPR(String.valueOf(Integer.parseInt(product.getAPR())+Profit));
                                    break;
                                case "May":
                                    product.setMAY(String.valueOf(Integer.parseInt(product.getMAY())+Profit));
                                    break;
                                case "June":
                                    product.setJUN(String.valueOf(Integer.parseInt(product.getJUN())+Profit));
                                    break;
                                case "July":
                                    product.setJULY(String.valueOf(Integer.parseInt(product.getJULY())+Profit));
                                    break;
                                case "August":
                                    product.setAUG(String.valueOf(Integer.parseInt(product.getAUG())+Profit));
                                    break;
                                case "September":
                                    product.setSEP(String.valueOf(Integer.parseInt(product.getSEP())+Profit));
                                    break;
                                case "October":
                                    product.setOCT(String.valueOf(Integer.parseInt(product.getOCT())+Profit));
                                    break;
                                case "November":
                                    product.setNOV(String.valueOf(Integer.parseInt(product.getNOV())+Profit));
                                    break;
                                case "December":
                                    product.setDEC(String.valueOf(Integer.parseInt(product.getDEC())+Profit));
                                    break;
                            }
                            System.out.println(product.getJAN());
                            try {
                                FileWriter X = new FileWriter("TotalIncome.txt");
                                X.write(product.getJAN()+"#"+product.getFEB()+"#"+product.getMAR()+"#"+product.getAPR()+"#"
                                        +product.getMAY()+"#"+product.getJUN()+"#"+product.getJULY()+"#"+product.getAUG()+"#"+
                                        product.getSEP()+"#"+product.getOCT()+"#"+product.getNOV()+"#"+product.getDEC());
                                X.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            return product;
                        })
                        .collect(Collectors.toList());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                FileWriter writer = new FileWriter("KeyDataMaintain.txt", true);
                BufferedWriter out = new BufferedWriter(writer);
                out.write(textfieldTelephone.getText()+ "#" + "Name -"+textfieldName.getText()+":"+"Car Make -"
                        +textfieldMake.getText()+":"+"Car Model -"+textfieldModel.getText()+":"+"Year -"+
                        textfieldYear.getText()+":"+"Mileage -"+textfieldMileage.getText()+":"+"Sold Price -"+
                        textfieldCost.getText()+":"+"Report -"+textfieldAddReport.getText()+"\r\n" );
                out.close();}catch (IOException ioException){}
            msg.setText("Report Added");
            }
        else {msg.setText("Please Enter Vaild Information");}
            Service product1 =new Service(textfieldMake.getText(),textfieldModel.getText(),"done",
                    Integer.parseInt(textfieldYear.getText()),Integer.parseInt(textfieldMileage.getText()),
                    Integer.parseInt(textfieldCost.getText()),textfieldName.getText(), textfieldTelephone.getText(),textfieldAddReport.getText());
            tableView.getItems().add(product1);
            textfieldAddReport.clear();
            textfieldName.clear();
            textfieldTelephone.clear();
            textfieldName.clear();
            textfieldModel.clear();
            textfieldMake.clear();
            textfieldAddReport.clear();
            textfieldCost.clear();
            textfieldYear.clear();
            textfieldMileage.clear();
            ObservableList<Service> allProduct,SingleProduct;
            allProduct = tableView1.getItems();
            SingleProduct = tableView1.getSelectionModel().getSelectedItems();
            SingleProduct.forEach(allProduct::remove);

    }

    public void AddToReport(ActionEvent actionEvent)throws IOException {
        try {
            String x;
            String y;
            String z;
            String a;
            String b;
            String c;
            x = tableView1.getSelectionModel().getSelectedItem().vehicleMakeProperty().get();
            textfieldMake.setText(x);
            y = tableView1.getSelectionModel().getSelectedItem().vehicleModelProperty().get();
            textfieldModel.setText(y);
            z = String.valueOf(tableView1.getSelectionModel().getSelectedItem().yearProperty().get());
            textfieldYear.setText(z);
            a = String.valueOf(tableView1.getSelectionModel().getSelectedItem().mileageProperty().get());
            textfieldMileage.setText(a);
            b = String.valueOf(tableView1.getSelectionModel().getSelectedItem().telephoneProperty().get());
            textfieldTelephone.setText(b);
            c = tableView1.getSelectionModel().getSelectedItem().nameProperty().get();
            textfieldName.setText(c);
        }finally {

        }
    }

    public void Back (ActionEvent actionEvent) throws IOException{
        BufferedWriter myWriter = null;
            try {
                myWriter =  new BufferedWriter(new FileWriter("AddForServices.txt"));
                Admin x = new Admin();
                for (int i = 0; i < tableView1.getItems().size(); i++)
                    myWriter.write(colMake1.getCellData(i)+"#"+colModel1.getCellData(i)+"#"+ColMaintenance1.getCellData(i)+"#"
                            +colYear1.getCellData(i)+"#"+colMileage1.getCellData(i)+"#"+colCost1.getCellData(i) +"#"+
                            ColName.getCellData(i)+"#"+ColTelephone.getCellData(i)+"#"+colReport1.getCellData(i)+"\r\n");
                myWriter.close();
                myWriter =  new BufferedWriter(new FileWriter("CompletedServices.txt"));
                for (int i = 0; i < tableView.getItems().size(); i++)
                    myWriter.write(colMake.getCellData(i)+"#"+colModel.getCellData(i)+"#"+ColMaintenance.getCellData(i)+"#"
                            +colYear.getCellData(i)+"#"+colMileage.getCellData(i)+"#"+colCost.getCellData(i) +"#"+
                            colCustomerName.getCellData(i)+"#"+colTelephone.getCellData(i)+"#"+colReport.getCellData(i)+"\r\n");
                myWriter.close();
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

}