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

import java.util.Date;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;


public class Admin implements Initializable {
    Map<String, String> appointment = new HashMap<String, String>();
    private Stage stage;
    private Scene scene;
    private Parent root;
    //naming  column fxid,table,fx id and text field fx id
    public  TableView<Product> tableView;
    public TableColumn<Product,String> colMake;
    public TableColumn<Product,String> colModel;
    public TableColumn<Product,String> colOldOwner;
    public TableColumn<Product,String> colAvailability;
    public  TableColumn<Product,Integer> colMileage;
    public  TableColumn<Product,Integer> colYear;
    public  TableColumn<Product,Integer> colAskPrice;
    public  TableColumn<Product,Integer> colSellPrice;
    public  TableView<Orders> tableView1;
    public TableColumn<Orders,String> colMake1;
    public TableColumn<Orders,String> colModel1;
    public TableColumn<Orders,String> colOldOwner1;
    public TableColumn<Orders,String> colAvailbility1;
    public  TableColumn<Orders,Integer> colMileage1;
    public  TableColumn<Orders,Integer> colYear1;
    public  TableColumn<Orders,Integer> colSellPrice1;
    public  TableColumn<Orders,String> ColName;
    public TableColumn<Orders,String> ColTelephone;
    public TableColumn<Orders,Integer> colProfit;
    public  TableColumn<Orders,String> ColMaintenance;

    public TextField textfieldMake;
    public TextField textfieldModel;
    public TextField textfieldOldOwner;
    public TextField textfieldMileage;
    public TextField textfieldYear;
    public TextField textfieldAskPrice;
    public TextField textfieldSellPrice;
    public Label msg;

    @FXML
    ComboBox textfieldAvailability;
    @FXML
    ComboBox MonthMenu;


    public Admin() throws IOException {
    }

    @Override

    public void initialize(URL location,ResourceBundle resources){
        //naming columns
        colMake.setCellValueFactory(new PropertyValueFactory<>("VehicleMake"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("VehicleModel"));
        colOldOwner.setCellValueFactory(new PropertyValueFactory<>("OldOwner"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("Year"));
        colMileage.setCellValueFactory(new PropertyValueFactory<>("Mileage"));
        colAskPrice.setCellValueFactory(new PropertyValueFactory<>("AskPrice"));
        colSellPrice.setCellValueFactory(new PropertyValueFactory<>("SellPrice"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("Availability"));
        colMake1.setCellValueFactory(new PropertyValueFactory<>("VehicleMake"));
        colModel1.setCellValueFactory(new PropertyValueFactory<>("VehicleModel"));
        colOldOwner1.setCellValueFactory(new PropertyValueFactory<>("OldOwner"));
        colYear1.setCellValueFactory(new PropertyValueFactory<>("Year"));
        colMileage1.setCellValueFactory(new PropertyValueFactory<>("Mileage"));
        colSellPrice1.setCellValueFactory(new PropertyValueFactory<>("SellPrice"));
        colAvailbility1.setCellValueFactory(new PropertyValueFactory<>("Availability"));
        colProfit.setCellValueFactory(new PropertyValueFactory<>("Profit"));
        ColName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        ColTelephone.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        ColMaintenance.setCellValueFactory(new PropertyValueFactory<>("Maintenance"));
        //set tables as uneditable
        tableView.setEditable(false);
        tableView1.setEditable(false);
        colMake.setCellFactory(TextFieldTableCell.forTableColumn());
        colModel.setCellFactory(TextFieldTableCell.forTableColumn());
        colMileage.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colYear.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colAskPrice.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colSellPrice.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colAvailability.setCellFactory(TextFieldTableCell.forTableColumn());
        colOldOwner.setCellFactory(TextFieldTableCell.forTableColumn());
        //setting dropdown menus
        textfieldAvailability.setItems(FXCollections.observableArrayList("On Sale","Sold","Reserved"));
        MonthMenu.setItems(FXCollections.observableArrayList("January","February","March","April","May","June",
                "July","August","September","October","November","December"));

        try {//adding data to tables
            Collection<Product> list = Files.readAllLines(new File("MainRecord.txt").toPath())
                    .stream()
                    .map(line -> {
                        String[] details = line.split("#");
                        Product product =new Product(details[0],details[1], details[2],Integer.parseInt(details[3]),
                                Integer.parseInt(details[4]),Integer.parseInt(details[5]),Integer.parseInt(details[6]),
                                (details[7]));
                        tableView.getItems().add(product);
                        return product;
                    })
                    .collect(Collectors.toList());
            Collection<Orders> list1 = Files.readAllLines(new File("ReservedCars.txt").toPath())
                    .stream()
                    .map(line -> {
                        String[] details = line.split("#");
                        Orders order =new Orders(details[0],details[1], details[2],Integer.parseInt(details[3]),
                                Integer.parseInt(details[4]),Integer.parseInt(details[5]),Integer.parseInt(details[6]),details[7],details[8],details[9],
                                (details[10]));
                        System.out.println("");
                        tableView1.getItems().add(order);
                        return order;
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
        }

    }
    ObservableList<Product> observableList= FXCollections.observableArrayList(
    );
    ObservableList<Orders> observableList1= FXCollections.observableArrayList(
    );
    public void buttonAdd (ActionEvent actionEvent){
        try {//adding data to table
        Product product1 =new Product(textfieldMake.getText(),textfieldModel.getText(),textfieldOldOwner.getText(),
                Integer.parseInt(textfieldYear.getText()),Integer.parseInt(textfieldMileage.getText()),
                Integer.parseInt(textfieldAskPrice.getText()),Integer.parseInt(textfieldSellPrice.getText()),
                textfieldAvailability.getValue().toString());
        tableView.getItems().add(product1);
        textfieldMake.clear();
        textfieldModel.clear();
        textfieldYear.clear();
        textfieldMileage.clear();
        textfieldOldOwner.clear();
        textfieldAskPrice.clear();
        textfieldSellPrice.clear();
        textfieldMake.getText();
            }
        catch (Exception e) {
            msg.setText("plz add correct information");
        }
    }
    public void Back (ActionEvent actionEvent) throws IOException {
     //back to main menu
        BufferedWriter myWriter = null;
        try {
            myWriter =  new BufferedWriter(new FileWriter("MainRecord.txt"));
            Admin x = new Admin();
            for (int i = 0; i < tableView.getItems().size(); i++)
            myWriter.write(colMake.getCellData(i)+"#"+colModel.getCellData(i)+"#"+colOldOwner.getCellData(i)+"#"
                    +colYear.getCellData(i)+"#"+colMileage.getCellData(i)+"#"+colAskPrice.getCellData(i)+"#"+
                    colSellPrice.getCellData(i)+"#"+colAvailability.getCellData(i)+"\r\n");
            myWriter.close();
            myWriter =  new BufferedWriter(new FileWriter("ReservedCars.txt"));
            for (int i = 0; i < tableView1.getItems().size(); i++)
            myWriter.write(colMake1.getCellData(i) + "#" + colModel1.getCellData(i) + "#"+ColMaintenance.getCellData(i)+"#"+ colYear1.getCellData(i) + "#"
                    + colMileage1.getCellData(i) + "#" +colProfit.getCellData(i)+"#"+ colSellPrice1.getCellData(i)+"#" + colAvailbility1.getCellData(i)+ "#" + ColName.getCellData(i) + "#" +
                    ColTelephone.getCellData(i) +"#"+colOldOwner1.getCellData(i)+"\r\n");
            myWriter.close();
            BufferedReader myReader =new BufferedReader((new FileReader("MainRecord.txt")));
            System.out.println(myReader.readLine());
            System.out.println("Successfully wrote to the file.");}
            catch (IOException e) {
            throw new RuntimeException(e);

    }
        finally {//changing scene
            Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("LogIn");
            stage.show();

        }
        }
    public void Remove(ActionEvent actionEvent)throws IOException{
        //removing element
        ObservableList<Product> allProduct,SingleProduct;
        allProduct = tableView.getItems();
        SingleProduct = tableView.getSelectionModel().getSelectedItems();
        SingleProduct.forEach(allProduct::remove);
        msg.setText("Successfully removed");
    }
    public void Edit(TableColumn.CellEditEvent<Product,String> productStringCellEditEvent){
        //editing car data
        Product product = tableView.getSelectionModel().getSelectedItem();
        product.setVehicleMake(productStringCellEditEvent.getNewValue());
    }
    public void RejectDeal(ActionEvent actionEvent){
        //rejecting deal
        try {
            String MAKE = tableView1.getSelectionModel().getSelectedItem().vehicleMakeProperty().get();
            String PROFIT = String.valueOf(tableView1.getSelectionModel().getSelectedItem().profitProperty().get());
            String MODEL = tableView1.getSelectionModel().getSelectedItem().vehicleModelProperty().get() ;
            String PRICE = String.valueOf(tableView1.getSelectionModel().getSelectedItem().sellPriceProperty().get());
            String MAINTENANCE = tableView1.getSelectionModel().getSelectedItem().MaintenanceProperty().get();
            String YEAR = String.valueOf(tableView1.getSelectionModel().getSelectedItem().yearProperty().get());
            String NAME = tableView1.getSelectionModel().getSelectedItem().nameProperty().get();
            String MILEAGE = String.valueOf(tableView1.getSelectionModel().getSelectedItem().mileageProperty().get());
            String TELEPHONE = tableView1.getSelectionModel().getSelectedItem().telephoneProperty().get();
            String OLDOWNER = tableView1.getSelectionModel().getSelectedItem().oldOwnerProperty().get();
            Integer ASkPRICE = tableView1.getSelectionModel().getSelectedItem().sellPriceProperty().get()
                    -tableView1.getSelectionModel().getSelectedItem().profitProperty().get();
            Product product1 =new Product(MAKE,MODEL,OLDOWNER,
                    Integer.parseInt(YEAR),Integer.parseInt(MILEAGE),
                    ASkPRICE,Integer.parseInt(PRICE),
                    "On Sale");
            tableView.getItems().add(product1);
            msg.setText("Deal Rejected");
        }finally {

        }

    }
    public void ConfirmDeal(ActionEvent actionEvent){
        //confirming deal
        String MAKE = tableView1.getSelectionModel().getSelectedItem().vehicleMakeProperty().get();
        String PROFIT = String.valueOf(tableView1.getSelectionModel().getSelectedItem().profitProperty().get());
        String MODEL = tableView1.getSelectionModel().getSelectedItem().vehicleModelProperty().get() ;
        String PRICE = String.valueOf(tableView1.getSelectionModel().getSelectedItem().sellPriceProperty().get());
        String MAINTENANCE = tableView1.getSelectionModel().getSelectedItem().MaintenanceProperty().get();
        String YEAR = String.valueOf(tableView1.getSelectionModel().getSelectedItem().yearProperty().get());
        String NAME = tableView1.getSelectionModel().getSelectedItem().nameProperty().get();
        String MILEAGE = String.valueOf(tableView1.getSelectionModel().getSelectedItem().mileageProperty().get());
        String TELEPHONE = tableView1.getSelectionModel().getSelectedItem().telephoneProperty().get();
        String OLDOWNER = tableView1.getSelectionModel().getSelectedItem().oldOwnerProperty().get();
        String equal = "Service Requested";
        String equal1 = "Not Requested";
        ArrayList<String> customername = new ArrayList<String>();
        Date date = new Date();
        try{
            customername.add(NAME +""+(TELEPHONE));
            System.out.println(customername);

        }finally {

        }
        BufferedWriter myWriter = null;
        try {
            Collection<ProfitByMonth> list = Files.readAllLines(new File("SaleProfit.txt").toPath())
                    .stream()
                    .map(line -> {//writing profit data to file
                        String[] details = line.split("#");
                        ProfitByMonth product =new ProfitByMonth(details[0],details[1] ,details[2] ,details[3] ,details[4] ,details[5] ,details[6] ,
                                details[7] ,details[8] ,details[9] ,details[10] ,details[11] );
                        Integer Profit;
                        Profit = tableView1.getSelectionModel().getSelectedItem().profitProperty().get();
                        String month = MonthMenu.getValue().toString();
                        switch (month) {//getting profit month
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
                            FileWriter X = new FileWriter("SaleProfit.txt");
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
            Collection<ProfitByMonth> list = Files.readAllLines(new File("NumberOfCarsSold.txt").toPath())
                    .stream()
                    .map(line -> {//add +1 to car number list
                        String[] details = line.split("#");
                        ProfitByMonth product =new ProfitByMonth(details[0],details[1] ,details[2] ,details[3] ,details[4] ,details[5] ,details[6] ,
                                details[7] ,details[8] ,details[9] ,details[10] ,details[11] );
                        Integer Profit;
                        Profit = tableView1.getSelectionModel().getSelectedItem().profitProperty().get();
                        String month = MonthMenu.getValue().toString();
                        switch (month) {
                            case "January":
                                product.setJAN(String.valueOf(Integer.parseInt(product.getJAN())+1));
                                break;
                            case "February":
                                product.setFEB(String.valueOf(Integer.parseInt(product.getFEB())+1));
                                break;
                            case "March":
                                product.setMAR(String.valueOf(Integer.parseInt(product.getMAR())+1));
                                break;
                            case "April":
                                product.setAPR(String.valueOf(Integer.parseInt(product.getAPR())+1));
                                break;
                            case "May":
                                product.setMAY(String.valueOf(Integer.parseInt(product.getMAY())+1));
                                break;
                            case "June":
                                product.setJUN(String.valueOf(Integer.parseInt(product.getJUN())+1));
                                break;
                            case "July":
                                product.setJULY(String.valueOf(Integer.parseInt(product.getJULY())+1));
                                break;
                            case "August":
                                product.setAUG(String.valueOf(Integer.parseInt(product.getAUG())+1));
                                break;
                            case "September":
                                product.setSEP(String.valueOf(Integer.parseInt(product.getSEP())+1));
                                break;
                            case "October":
                                product.setOCT(String.valueOf(Integer.parseInt(product.getOCT())+1));
                                break;
                            case "November":
                                product.setNOV(String.valueOf(Integer.parseInt(product.getNOV())+1));
                                break;
                            case "December":
                                product.setDEC(String.valueOf(Integer.parseInt(product.getDEC())+1));
                                break;
                        }
                        System.out.println(product.getJAN());
                        try {
                            FileWriter X = new FileWriter("NumberOfCarsSold.txt");
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
                    .map(line -> {//getting total income
                        String[] details = line.split("#");
                        ProfitByMonth product =new ProfitByMonth(details[0],details[1] ,details[2] ,details[3] ,details[4] ,details[5] ,details[6] ,
                                details[7] ,details[8] ,details[9] ,details[10] ,details[11] );
                        Integer Profit;
                        Profit = tableView1.getSelectionModel().getSelectedItem().profitProperty().get();
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
        try {//getting sale income
            Collection<ProfitByMonth> list = Files.readAllLines(new File("SaleIncome.txt").toPath())
                    .stream()
                    .map(line -> {
                        String[] details = line.split("#");
                        ProfitByMonth product =new ProfitByMonth(details[0],details[1] ,details[2] ,details[3] ,details[4] ,details[5] ,details[6] ,
                                details[7] ,details[8] ,details[9] ,details[10] ,details[11] );
                        Integer Income;
                        Income = tableView1.getSelectionModel().getSelectedItem().sellPriceProperty().get();
                        String month = MonthMenu.getValue().toString();
                        switch (month) {
                            case "January":
                                product.setJAN(String.valueOf(Integer.parseInt(product.getJAN())+Income));
                                break;
                            case "February":
                                product.setFEB(String.valueOf(Integer.parseInt(product.getFEB())+Income));
                                break;
                            case "March":
                                product.setMAR(String.valueOf(Integer.parseInt(product.getMAR())+Income));
                                break;
                            case "April":
                                product.setAPR(String.valueOf(Integer.parseInt(product.getAPR())+Income));
                                break;
                            case "May":
                                product.setMAY(String.valueOf(Integer.parseInt(product.getMAY())+Income));
                                break;
                            case "June":
                                product.setJUN(String.valueOf(Integer.parseInt(product.getJUN())+Income));
                                break;
                            case "July":
                                product.setJULY(String.valueOf(Integer.parseInt(product.getJULY())+Income));
                                break;
                            case "August":
                                product.setAUG(String.valueOf(Integer.parseInt(product.getAUG())+Income));
                                break;
                            case "September":
                                product.setSEP(String.valueOf(Integer.parseInt(product.getSEP())+Income));
                                break;
                            case "October":
                                product.setOCT(String.valueOf(Integer.parseInt(product.getOCT())+Income));
                                break;
                            case "November":
                                product.setNOV(String.valueOf(Integer.parseInt(product.getNOV())+Income));
                                break;
                            case "December":
                                product.setDEC(String.valueOf(Integer.parseInt(product.getDEC())+Income));
                                break;
                        }
                        System.out.println(product.getJAN());
                        try {
                            FileWriter X = new FileWriter("SaleIncome.txt");
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
        if(MAINTENANCE.equals(equal)){ try {
            FileWriter writer = null;
            writer = new FileWriter("DoneDealsWithService.txt", true);
            BufferedWriter out = new BufferedWriter(writer);
            out.write(MAKE+ "#" + MODEL + "#"+MAINTENANCE+"#"+ YEAR + "#"
                    + MILEAGE + "#" +PROFIT+"#"+ PRICE+"#" + "Sold-Add To Services"+ "#" + NAME + "#" +
                    TELEPHONE +"#"+OLDOWNER+"\r\n");
            out.close();
            writer = new FileWriter("KeyDataSold.txt", true);
            out = new BufferedWriter(writer);
            out.write(TELEPHONE+ "#" + "Name -"+NAME+":"+"Car Make -"+MAKE+":"+"Car Model -"+MODEL+":"+"Year -"+YEAR+":"+"Mileage -"+MILEAGE+":"+"Sold Price -"+PRICE+"\r\n" );
            out.close();
            writer = null;
            writer = new FileWriter("AddForStats.txt", true);
            out = new BufferedWriter(writer);
            out.write(MAKE+ "#" + MODEL + "#" +PROFIT+"#"+ PRICE + "#" + NAME + "#" +
                    TELEPHONE +"#"+date.getMonth()+"\r\n");
            out.close();
            writer = null;
            writer = new FileWriter("AddForServices.txt", true);
            out = new BufferedWriter(writer);
            out.write(MAKE+ "#" + MODEL + "#" +"Sold-Add To Services"+"#"+YEAR+"#"+MILEAGE+"#"+0+ "#" + NAME + "#" +
                    TELEPHONE +"#"+"No Report"+"\r\n");
            out.close();
            writer = null;
            writer = new FileWriter("SoldCars.txt", true);
            out = new BufferedWriter(writer);
            out.write(MAKE+ "#" + MODEL + "#" +YEAR+"#"+MILEAGE+"#"+PRICE+ "#" + NAME + "#" +
                    TELEPHONE +"#"+(date.getYear()+1900)+"/"+(date.getMonth()+1)+"/"+date.getDate()+"\r\n");
            out.close();
            ObservableList<Orders> allProduct,SingleProduct;
            allProduct = tableView1.getItems();
            SingleProduct = tableView1.getSelectionModel().getSelectedItems();
            SingleProduct.forEach(allProduct::remove);}
        catch (Exception e) {
            throw new RuntimeException(e);}}
        if(MAINTENANCE.equals(equal1)){ try {
            FileWriter writer = null;
            writer = new FileWriter("DoneDealsWithoutService.txt", true);
            BufferedWriter out = new BufferedWriter(writer);
            out.write(MAKE+ "#" + MODEL + "#"+MAINTENANCE+"#"+ YEAR + "#"
                    + MILEAGE + "#" +PROFIT+"#"+ PRICE+"#" + "Sold"+ "#" + NAME + "#" +
                    TELEPHONE +"#"+OLDOWNER+"\r\n");
            out.close();
            writer = null;
            writer = new FileWriter("FinalReceipt.txt", true);
            out = new BufferedWriter(writer);
            out.write(MAKE+ "#" + MODEL + "#" +"Sold"+"#"+YEAR+"#"+MILEAGE+"#"+PRICE+ "#" + NAME + "#" +
                    TELEPHONE +"#"+"No Report"+"\r\n");
            out.close();
            writer = null;
            writer = new FileWriter("AddForStats.txt", true);
            out = new BufferedWriter(writer);
            out.write(MAKE+ "#" + MODEL + "#" +PROFIT+"#"+ PRICE + "#" + NAME + "#" +
                    TELEPHONE +"#"+ date.getMonth()+"\r\n" );
            out.close();
            writer = new FileWriter("KeyDataSold.txt", true);
            out = new BufferedWriter(writer);
            out.write(TELEPHONE+ "#" + "Name -"+NAME+":"+"Car Make -"+MAKE+":"+"Car Model -"+MODEL+":"+"Year -"+YEAR+":"+"Mileage -"+MILEAGE+":"+"Sold Price -"+PRICE+"\r\n" );
            out.close();
            writer = null;
            writer = new FileWriter("SoldCars.txt", true);
            out = new BufferedWriter(writer);
            out.write(MAKE+ "#" + MODEL + "#" +YEAR+"#"+MILEAGE+"#"+PRICE+ "#" + NAME + "#" +
                    TELEPHONE +"#"+(date.getYear()+1900)+"/"+(date.getMonth()+1)+"/"+date.getDate()+"\r\n");
            out.close();
            ObservableList<Orders> allProduct,SingleProduct;
            allProduct = tableView1.getItems();
            SingleProduct = tableView1.getSelectionModel().getSelectedItems();
            SingleProduct.forEach(allProduct::remove);}
        catch (Exception e) {
            throw new RuntimeException(e);}}
        msg.setText("Deal Confirmed");

    }
    public void EditCar(ActionEvent actionEvent){
        ObservableList<Product> allProduct,SingleProduct;
        allProduct = tableView.getItems();
        String x ;String y;String z;String a;String b;String c;String A;String B;
        x = tableView.getSelectionModel().getSelectedItem().vehicleMakeProperty().get();
        textfieldMake.setText(x);
        y = tableView.getSelectionModel().getSelectedItem().vehicleModelProperty().get();
        textfieldModel.setText(y);
        z = String.valueOf(tableView.getSelectionModel().getSelectedItem().yearProperty().get());
        textfieldYear.setText(z);
        a = String.valueOf(tableView.getSelectionModel().getSelectedItem().mileageProperty().get());
        textfieldMileage.setText(a);
        b = String.valueOf(tableView.getSelectionModel().getSelectedItem().sellPriceProperty().get());
        textfieldSellPrice.setText(b);
        c = String.valueOf(tableView.getSelectionModel().getSelectedItem().askPriceProperty().get());
        textfieldAskPrice.setText(c);
        A = tableView.getSelectionModel().getSelectedItem().oldOwnerProperty().get();
        textfieldOldOwner.setText(A);
        B = tableView.getSelectionModel().getSelectedItem().availabilityProperty().get();
        textfieldAvailability.setValue(B);
        SingleProduct = tableView.getSelectionModel().getSelectedItems();
        SingleProduct.forEach(allProduct::remove);
    }
    public void Test (ActionEvent actionEvent) throws IOException {
        try {
            Collection<ProfitByMonth> list = Files.readAllLines(new File("SaleIncome.txt").toPath())
                    .stream()
                    .map(line -> {
                        String[] details = line.split("#");
                        ProfitByMonth product =new ProfitByMonth(details[0],details[1] ,details[2] ,details[3] ,details[4] ,details[5] ,details[6] ,
                                details[7] ,details[8] ,details[9] ,details[10] ,details[11] );
                        Integer Income;
                        Income = tableView1.getSelectionModel().getSelectedItem().sellPriceProperty().get();
                        String month = MonthMenu.getValue().toString();
                        switch (month) {
                            case "January":
                                product.setJAN(String.valueOf(Integer.parseInt(product.getJAN())+Income));
                                break;
                            case "February":
                                product.setFEB(String.valueOf(Integer.parseInt(product.getFEB())+Income));
                                break;
                            case "March":
                                product.setMAR(String.valueOf(Integer.parseInt(product.getMAR())+Income));
                                break;
                            case "April":
                                product.setAPR(String.valueOf(Integer.parseInt(product.getAPR())+Income));
                                break;
                            case "May":
                                product.setMAY(String.valueOf(Integer.parseInt(product.getMAY())+Income));
                                break;
                            case "June":
                                product.setJUN(String.valueOf(Integer.parseInt(product.getJUN())+Income));
                                break;
                            case "July":
                                product.setJULY(String.valueOf(Integer.parseInt(product.getJULY())+Income));
                                break;
                            case "August":
                                product.setAUG(String.valueOf(Integer.parseInt(product.getAUG())+Income));
                                break;
                            case "September":
                                product.setSEP(String.valueOf(Integer.parseInt(product.getSEP())+Income));
                                break;
                            case "October":
                                product.setOCT(String.valueOf(Integer.parseInt(product.getOCT())+Income));
                                break;
                            case "November":
                                product.setNOV(String.valueOf(Integer.parseInt(product.getNOV())+Income));
                                break;
                            case "December":
                                product.setDEC(String.valueOf(Integer.parseInt(product.getDEC())+Income));
                                break;
                        }
                        System.out.println(product.getJAN());
                        try {
                            FileWriter X = new FileWriter("SaleIncome.txt");
                            X.write(product.getJAN()+"#"+product.getFEB()+"#"+product.getMAR()+"#"+product.getAPR()+"#"
                                    +product.getMAY()+"#"+product.getJUN()+"#"+product.getJULY()+"#"+product.getAUG()+"#"+
                                    product.getSEP()+"#"+product.getOCT()+"#"+product.getNOV()+"#"+product.getDEC());
                            X.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        return product;
                    })
                    .collect(Collectors.toList());}catch (IOException ioException){}



    }

}
