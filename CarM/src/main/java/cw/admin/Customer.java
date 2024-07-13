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
import javafx.scene.image.ImageView;
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


public class Customer implements Initializable {
    Map<String, String> appointment = new HashMap<String, String>();
    private Stage stage;
    private Scene scene;
    private Parent root;
    public  TableView<Product> tableView;
    public TableColumn<Product,String> colMake;
    public TableColumn<Product,String> colModel;
    public TableColumn<Product,String> colOldOwner;
    public TableColumn<Product,String> colAvailability;
    public  TableColumn<Product,Integer> colMileage;
    public  TableColumn<Product,Integer> colYear;
    public  TableColumn<Product,Integer> colAskPrice;
    public  TableColumn<Product,Integer> colSellPrice;
    public  TableView<TestRides> tableView1;
    @FXML
    TextField CartMake;
    @FXML
    TextField CartModel;
    @FXML
    TextField CartYear;
    @FXML
    TextField CartMileage;
    @FXML
    TextField CartPrice;
    @FXML
    TextField CartTelephone;
    @FXML
    TextField CartName;
    @FXML
    TextField SearchBar;
    @FXML
    TextArea textline;
    @FXML
    Label msg;
    @FXML
    CheckBox ServiceTick;




    @Override

    public void initialize(URL location,ResourceBundle resources){
        colMake.setCellValueFactory(new PropertyValueFactory<>("VehicleMake"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("VehicleModel"));
        colOldOwner.setCellValueFactory(new PropertyValueFactory<>("OldOwner"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("Year"));
        colMileage.setCellValueFactory(new PropertyValueFactory<>("Mileage"));
        colAskPrice.setCellValueFactory(new PropertyValueFactory<>("AskPrice"));
        colSellPrice.setCellValueFactory(new PropertyValueFactory<>("SellPrice"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("Availability"));
        tableView.setEditable(true);
        colMake.setCellFactory(TextFieldTableCell.forTableColumn());
        colModel.setCellFactory(TextFieldTableCell.forTableColumn());
        colMileage.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colYear.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colAskPrice.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colSellPrice.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colAvailability.setCellFactory(TextFieldTableCell.forTableColumn());
        colOldOwner.setCellFactory(TextFieldTableCell.forTableColumn());
        colAskPrice.setVisible(false);
        colOldOwner.setVisible(false);
        CartMake.setEditable(false);
        CartModel.setEditable(false);
        CartMileage.setEditable(false);
        CartYear.setEditable(false);
        CartPrice.setEditable(false);
        try {
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
                    .collect(Collectors.toList());} catch (IOException e) {
        }

    }
    ObservableList<Product> observableList= FXCollections.observableArrayList(
    );

    public void Back (ActionEvent actionEvent) throws IOException {

        BufferedWriter myWriter = null;
        try {
            myWriter =  new BufferedWriter(new FileWriter("MainRecord.txt"));
            Admin x = new Admin();
            for (int i = 0; i < tableView.getItems().size(); i++)
                myWriter.write(colMake.getCellData(i)+"#"+colModel.getCellData(i)+"#"+colOldOwner.getCellData(i)+"#"
                        +colYear.getCellData(i)+"#"+colMileage.getCellData(i)+"#"+colAskPrice.getCellData(i)+"#"+
                        colSellPrice.getCellData(i)+"#"+colAvailability.getCellData(i)+"\r\n");
            myWriter.close();
            BufferedReader myReader =new BufferedReader((new FileReader("MainRecord.txt")));
            System.out.println(myReader.readLine());
            System.out.println("Successfully wrote to the file.");}
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
    public void AddToCart(ActionEvent actionEvent)throws IOException{
        try {
        ObservableList<Product> allProduct,SingleProduct;
        allProduct = tableView.getItems();
        String x ;String y;String z;String a;String b;
        x = tableView.getSelectionModel().getSelectedItem().vehicleMakeProperty().get();
        CartMake.setText(x);
        y = tableView.getSelectionModel().getSelectedItem().vehicleModelProperty().get();
        CartModel.setText(y);
        z = String.valueOf(tableView.getSelectionModel().getSelectedItem().yearProperty().get());
        CartYear.setText(z);
        a = String.valueOf(tableView.getSelectionModel().getSelectedItem().mileageProperty().get());
        CartMileage.setText(a);
        b = String.valueOf(tableView.getSelectionModel().getSelectedItem().sellPriceProperty().get());
        CartPrice.setText(b);
        msg.setText("Car Added To Cart");
        }
        finally {

        }

    }
    public void GetTestDrive(ActionEvent actionEvent)throws IOException{
        String x;
        String y;
        String z;
        x = tableView.getSelectionModel().getSelectedItem().availabilityProperty().get();
        y = CartName.getText();
        z= CartTelephone.getText();
        if (!x.equals("Reserved")&&(!y.isBlank()&&!z.isBlank())){
            FileWriter writer = new FileWriter("ReservedTestDrives.txt", true);
            BufferedWriter out = new BufferedWriter(writer);
            out.write(CartMake.getText() + "#" + CartModel.getText() + "#" + CartYear.getText() + "#"
                    + CartMileage.getText() + "#" + CartPrice.getText() + "#" + CartName.getText() + "#" +
                    CartTelephone.getText() + "#"+"Requested" +"\r\n");
            out.close();
            msg.setText("Request Successful");
        }
        else {
            msg.setText("Request Unsuccessful");
        }
    }
    public void buy(ActionEvent actionEvent)throws IOException{
        String x;
        String y;
        String z;
        Integer a;
        Integer b;
        String c ;
        String k;
        x = tableView.getSelectionModel().getSelectedItem().availabilityProperty().get();
        a = tableView.getSelectionModel().getSelectedItem().askPriceProperty().get();
        c = tableView.getSelectionModel().getSelectedItem().oldOwnerProperty().get();
        y = CartName.getText();
        z= CartTelephone.getText();
        boolean checkT = ServiceTick.isSelected();


        b=  Integer.parseInt(CartPrice.getText())-a;
        if (ServiceTick.isSelected()&&(!y.isBlank()&&!z.isBlank())){
            FileWriter writer = new FileWriter("ReservedCars.txt", true);
            BufferedWriter out = new BufferedWriter(writer);
            out.write(CartMake.getText() + "#" + CartModel.getText() + "#"+"Service Requested"+"#"+ CartYear.getText() + "#"
                    + CartMileage.getText() + "#" +b+"#"+ CartPrice.getText()+"#" + "Reserved"+ "#" + CartName.getText() + "#" +
                    CartTelephone.getText() +"#"+c+"\r\n");
            out.close();
            CartPrice.clear();
            CartMake.clear();
            CartModel.clear();
            CartYear.clear();
            CartTelephone.clear();
            CartName.clear();
            CartMileage.clear();
            ObservableList<Product> allProduct,SingleProduct;
            allProduct = tableView.getItems();
            SingleProduct = tableView.getSelectionModel().getSelectedItems();
            SingleProduct.forEach(allProduct::remove);
            msg.setText("Purchase Unsuccessful");

        }
        else {
            msg.setText("Purchase Unsuccessful");
        }
        if (!ServiceTick.isSelected()&&(!y.isBlank()&&!z.isBlank())){
            FileWriter writer = new FileWriter("ReservedCars.txt", true);
            BufferedWriter out = new BufferedWriter(writer);
            out.write(CartMake.getText() + "#" + CartModel.getText() + "#"+"Not Requested"+"#"+ CartYear.getText() + "#"
                    + CartMileage.getText() + "#" +b+"#"+ CartPrice.getText()+"#" + "Reserved"+ "#" + CartName.getText() + "#" +
                    CartTelephone.getText() +"#"+c+"\r\n");
            out.close();
            CartPrice.clear();
            CartMake.clear();
            CartModel.clear();
            CartYear.clear();
            CartTelephone.clear();
            CartName.clear();
            CartMileage.clear();
            ObservableList<Product> allProduct,SingleProduct;
            allProduct = tableView.getItems();
            SingleProduct = tableView.getSelectionModel().getSelectedItems();
            SingleProduct.forEach(allProduct::remove);
            msg.setText("Purchase Successful");
        }
        else {
            msg.setText("Purchase Unsuccessful");
        }
    }
    public void Search(ActionEvent actionEvent)throws IOException{
        FileReader csv = new FileReader("ReservedTestDrives1.txt");
        BufferedReader csvbuffer = new BufferedReader(csv);
        String i;
        while((i=csvbuffer.readLine())!=null){
            String data[]=i.split("#");
            List<String> datalist=new ArrayList<String>();
            String data2[]=data[1].split(":");
            appointment.put(data[0],data2[0]+"" +"\n"+
                    ""+data2[1]+"\n"+data2[2]+"\n"+data2[3]+"\n"+data2[4]+"\n"+data2[5]+"\n"+data2[6]);
        }
        String telephone = SearchBar.getText();
        if(appointment.get(telephone) == null){
            textline.setText("Not Found!");}
        else {
        textline.setText(appointment.get(telephone));}
    }

    public void SortByPrice(ActionEvent actionEvent)throws  IOException{

    }
    public void SortByMileage(ActionEvent actionEvent)throws  IOException{

    }
}
