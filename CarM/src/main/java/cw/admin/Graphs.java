package cw.admin;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Graphs implements Initializable {
    @FXML
    Label barcharthead;
    @FXML
    Label piecharthead;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private BarChart <? ,?> chart;
    @FXML
    private PieChart chart2;
    public void initialize(URL location, ResourceBundle resources){
        try {
            Collection<ProfitByMonth> list = Files.readAllLines(new File("TotalIncome.txt").toPath())
                    .stream()
                    .map(line -> {
                        String[] details = line.split("#");
                        ProfitByMonth product =new ProfitByMonth(details[0],details[1] ,details[2] ,details[3] ,details[4] ,details[5] ,details[6] ,
                                details[7] ,details[8] ,details[9] ,details[10] ,details[11] );

                        XYChart.Series TotalProfit = new XYChart.Series();
                        TotalProfit.setName("Total Profit");
                        TotalProfit.getData().add(new XYChart.Data("January", Integer.parseInt(product.getJAN())));
                        TotalProfit.getData().add(new XYChart.Data("February",Integer.parseInt(product.getFEB())));
                        TotalProfit.getData().add(new XYChart.Data("March", Integer.parseInt(product.getMAR())));
                        TotalProfit.getData().add(new XYChart.Data("April", Integer.parseInt(product.getAPR())));
                        TotalProfit.getData().add(new XYChart.Data("May", Integer.parseInt(product.getMAY())));
                        TotalProfit.getData().add(new XYChart.Data("June", Integer.parseInt(product.getJUN())));
                        TotalProfit.getData().add(new XYChart.Data("July", Integer.parseInt(product.getJULY())));
                        TotalProfit.getData().add(new XYChart.Data("August", Integer.parseInt(product.getAUG())));
                        TotalProfit.getData().add(new XYChart.Data("September", Integer.parseInt(product.getSEP())));
                        TotalProfit.getData().add(new XYChart.Data("October", Integer.parseInt(product.getOCT())));
                        TotalProfit.getData().add(new XYChart.Data("November", Integer.parseInt(product.getNOV())));
                        TotalProfit.getData().add(new XYChart.Data("December", Integer.parseInt(product.getDEC())));
                        chart.getData().addAll(TotalProfit);
                        ObservableList<PieChart.Data> xx =
                                FXCollections.observableArrayList(
                                        new PieChart.Data("January",Integer.parseInt(product.getJAN())),
                                        new PieChart.Data("February",Integer.parseInt(product.getFEB())),
                                        new PieChart.Data("March", Integer.parseInt(product.getMAR())),
                                        new PieChart.Data("April", Integer.parseInt(product.getAPR())),
                                        new PieChart.Data("May",Integer.parseInt(product.getMAY())),
                                        new PieChart.Data("June",Integer.parseInt(product.getJUN())),
                                        new PieChart.Data("July",Integer.parseInt(product.getJULY())),
                                        new PieChart.Data("August",Integer.parseInt(product.getAUG())),
                                        new PieChart.Data("September",Integer.parseInt(product.getSEP())),
                                        new PieChart.Data("October",Integer.parseInt(product.getOCT())),
                                        new PieChart.Data("November",Integer.parseInt(product.getNOV())),
                                        new PieChart.Data("December",Integer.parseInt(product.getDEC())));
                        chart2.getData().addAll(xx);
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
    }
    public void getSaleIncomeOnly(ActionEvent actionEvent){
        try {
            Collection<ProfitByMonth> list = Files.readAllLines(new File("SaleIncome.txt").toPath())
                    .stream()
                    .map(line -> {
                        String[] details = line.split("#");
                        ProfitByMonth product =new ProfitByMonth(details[0],details[1] ,details[2] ,details[3] ,details[4] ,details[5] ,details[6] ,
                                details[7] ,details[8] ,details[9] ,details[10] ,details[11] );
                        chart.getData().clear();
                        barcharthead.setText("Income By Sales");
                        XYChart.Series TotalProfit = new XYChart.Series();
                        TotalProfit.setName("Total Profit");
                        TotalProfit.getData().add(new XYChart.Data("January", Integer.parseInt(product.getJAN())));
                        TotalProfit.getData().add(new XYChart.Data("February",Integer.parseInt(product.getFEB())));
                        TotalProfit.getData().add(new XYChart.Data("March", Integer.parseInt(product.getMAR())));
                        TotalProfit.getData().add(new XYChart.Data("April", Integer.parseInt(product.getAPR())));
                        TotalProfit.getData().add(new XYChart.Data("May", Integer.parseInt(product.getMAY())));
                        TotalProfit.getData().add(new XYChart.Data("June", Integer.parseInt(product.getJUN())));
                        TotalProfit.getData().add(new XYChart.Data("July", Integer.parseInt(product.getJULY())));
                        TotalProfit.getData().add(new XYChart.Data("August", Integer.parseInt(product.getAUG())));
                        TotalProfit.getData().add(new XYChart.Data("September", Integer.parseInt(product.getSEP())));
                        TotalProfit.getData().add(new XYChart.Data("October", Integer.parseInt(product.getOCT())));
                        TotalProfit.getData().add(new XYChart.Data("November", Integer.parseInt(product.getNOV())));
                        TotalProfit.getData().add(new XYChart.Data("December", Integer.parseInt(product.getDEC())));
                        chart.getData().addAll(TotalProfit);
                        chart2.getData().clear();
                        piecharthead.setText("Income By Sales");
                        ObservableList<PieChart.Data> xx =
                                FXCollections.observableArrayList(
                                        new PieChart.Data("January",Integer.parseInt(product.getJAN())),
                                        new PieChart.Data("February",Integer.parseInt(product.getFEB())),
                                        new PieChart.Data("March", Integer.parseInt(product.getMAR())),
                                        new PieChart.Data("April", Integer.parseInt(product.getAPR())),
                                        new PieChart.Data("May",Integer.parseInt(product.getMAY())),
                                        new PieChart.Data("June",Integer.parseInt(product.getJUN())),
                                        new PieChart.Data("July",Integer.parseInt(product.getJULY())),
                                        new PieChart.Data("August",Integer.parseInt(product.getAUG())),
                                        new PieChart.Data("September",Integer.parseInt(product.getSEP())),
                                        new PieChart.Data("October",Integer.parseInt(product.getOCT())),
                                        new PieChart.Data("November",Integer.parseInt(product.getNOV())),
                                        new PieChart.Data("December",Integer.parseInt(product.getDEC())));
                        chart2.getData().addAll(xx);
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

    }

    public void getServiceIncomeOnly(ActionEvent actionEvent){
        try {
            Collection<ProfitByMonth> list = Files.readAllLines(new File("ServiceProfit.txt").toPath())
                    .stream()
                    .map(line -> {
                        String[] details = line.split("#");
                        ProfitByMonth product =new ProfitByMonth(details[0],details[1] ,details[2] ,details[3] ,details[4] ,details[5] ,details[6] ,
                                details[7] ,details[8] ,details[9] ,details[10] ,details[11] );
                        chart.getData().clear();
                        barcharthead.setText("Income By Services");
                        XYChart.Series TotalProfit = new XYChart.Series();
                        TotalProfit.setName("Total Profit");
                        TotalProfit.getData().add(new XYChart.Data("January", Integer.parseInt(product.getJAN())));
                        TotalProfit.getData().add(new XYChart.Data("February",Integer.parseInt(product.getFEB())));
                        TotalProfit.getData().add(new XYChart.Data("March", Integer.parseInt(product.getMAR())));
                        TotalProfit.getData().add(new XYChart.Data("April", Integer.parseInt(product.getAPR())));
                        TotalProfit.getData().add(new XYChart.Data("May", Integer.parseInt(product.getMAY())));
                        TotalProfit.getData().add(new XYChart.Data("June", Integer.parseInt(product.getJUN())));
                        TotalProfit.getData().add(new XYChart.Data("July", Integer.parseInt(product.getJULY())));
                        TotalProfit.getData().add(new XYChart.Data("August", Integer.parseInt(product.getAUG())));
                        TotalProfit.getData().add(new XYChart.Data("September", Integer.parseInt(product.getSEP())));
                        TotalProfit.getData().add(new XYChart.Data("October", Integer.parseInt(product.getOCT())));
                        TotalProfit.getData().add(new XYChart.Data("November", Integer.parseInt(product.getNOV())));
                        TotalProfit.getData().add(new XYChart.Data("December", Integer.parseInt(product.getDEC())));
                        chart.getData().addAll(TotalProfit);
                        chart2.getData().clear();
                        piecharthead.setText("Income By Services");
                        ObservableList<PieChart.Data> xx =
                                FXCollections.observableArrayList(
                                        new PieChart.Data("January",Integer.parseInt(product.getJAN())),
                                        new PieChart.Data("February",Integer.parseInt(product.getFEB())),
                                        new PieChart.Data("March", Integer.parseInt(product.getMAR())),
                                        new PieChart.Data("April", Integer.parseInt(product.getAPR())),
                                        new PieChart.Data("May",Integer.parseInt(product.getMAY())),
                                        new PieChart.Data("June",Integer.parseInt(product.getJUN())),
                                        new PieChart.Data("July",Integer.parseInt(product.getJULY())),
                                        new PieChart.Data("August",Integer.parseInt(product.getAUG())),
                                        new PieChart.Data("September",Integer.parseInt(product.getSEP())),
                                        new PieChart.Data("October",Integer.parseInt(product.getOCT())),
                                        new PieChart.Data("November",Integer.parseInt(product.getNOV())),
                                        new PieChart.Data("December",Integer.parseInt(product.getDEC())));
                        chart2.getData().addAll(xx);
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
    }
   public void getSaleProfit(ActionEvent actionEvent){
       try {
           Collection<ProfitByMonth> list = Files.readAllLines(new File("SaleProfit.txt").toPath())
                   .stream()
                   .map(line -> {
                       String[] details = line.split("#");
                       ProfitByMonth product =new ProfitByMonth(details[0],details[1] ,details[2] ,details[3] ,details[4] ,details[5] ,details[6] ,
                               details[7] ,details[8] ,details[9] ,details[10] ,details[11] );
                       chart.getData().clear();
                       barcharthead.setText("Profit By Sales");
                       XYChart.Series TotalProfit = new XYChart.Series();
                       TotalProfit.setName("Total Profit");
                       TotalProfit.getData().add(new XYChart.Data("January", Integer.parseInt(product.getJAN())));
                       TotalProfit.getData().add(new XYChart.Data("February",Integer.parseInt(product.getFEB())));
                       TotalProfit.getData().add(new XYChart.Data("March", Integer.parseInt(product.getMAR())));
                       TotalProfit.getData().add(new XYChart.Data("April", Integer.parseInt(product.getAPR())));
                       TotalProfit.getData().add(new XYChart.Data("May", Integer.parseInt(product.getMAY())));
                       TotalProfit.getData().add(new XYChart.Data("June", Integer.parseInt(product.getJUN())));
                       TotalProfit.getData().add(new XYChart.Data("July", Integer.parseInt(product.getJULY())));
                       TotalProfit.getData().add(new XYChart.Data("August", Integer.parseInt(product.getAUG())));
                       TotalProfit.getData().add(new XYChart.Data("September", Integer.parseInt(product.getSEP())));
                       TotalProfit.getData().add(new XYChart.Data("October", Integer.parseInt(product.getOCT())));
                       TotalProfit.getData().add(new XYChart.Data("November", Integer.parseInt(product.getNOV())));
                       TotalProfit.getData().add(new XYChart.Data("December", Integer.parseInt(product.getDEC())));
                       chart.getData().addAll(TotalProfit);
                       chart2.getData().clear();
                       piecharthead.setText("Profit By Sales");
                       ObservableList<PieChart.Data> xx =
                               FXCollections.observableArrayList(
                                       new PieChart.Data("January",Integer.parseInt(product.getJAN())),
                                       new PieChart.Data("February",Integer.parseInt(product.getFEB())),
                                       new PieChart.Data("March", Integer.parseInt(product.getMAR())),
                                       new PieChart.Data("April", Integer.parseInt(product.getAPR())),
                                       new PieChart.Data("May",Integer.parseInt(product.getMAY())),
                                       new PieChart.Data("June",Integer.parseInt(product.getJUN())),
                                       new PieChart.Data("July",Integer.parseInt(product.getJULY())),
                                       new PieChart.Data("August",Integer.parseInt(product.getAUG())),
                                       new PieChart.Data("September",Integer.parseInt(product.getSEP())),
                                       new PieChart.Data("October",Integer.parseInt(product.getOCT())),
                                       new PieChart.Data("November",Integer.parseInt(product.getNOV())),
                                       new PieChart.Data("December",Integer.parseInt(product.getDEC())));
                       chart2.getData().addAll(xx);
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
   }
    public void getTotalCarsSold(ActionEvent actionEvent){
        try {
            Collection<ProfitByMonth> list = Files.readAllLines(new File("NumberOfCarsSold.txt").toPath())
                    .stream()
                    .map(line -> {
                        String[] details = line.split("#");
                        ProfitByMonth product =new ProfitByMonth(details[0],details[1] ,details[2] ,details[3] ,details[4] ,details[5] ,details[6] ,
                                details[7] ,details[8] ,details[9] ,details[10] ,details[11] );
                        chart.getData().clear();
                        barcharthead.setText("Total Cars Sold");
                        XYChart.Series TotalProfit = new XYChart.Series();
                        TotalProfit.setName("Total Profit");
                        TotalProfit.getData().add(new XYChart.Data("January", Integer.parseInt(product.getJAN())));
                        TotalProfit.getData().add(new XYChart.Data("February",Integer.parseInt(product.getFEB())));
                        TotalProfit.getData().add(new XYChart.Data("March", Integer.parseInt(product.getMAR())));
                        TotalProfit.getData().add(new XYChart.Data("April", Integer.parseInt(product.getAPR())));
                        TotalProfit.getData().add(new XYChart.Data("May", Integer.parseInt(product.getMAY())));
                        TotalProfit.getData().add(new XYChart.Data("June", Integer.parseInt(product.getJUN())));
                        TotalProfit.getData().add(new XYChart.Data("July", Integer.parseInt(product.getJULY())));
                        TotalProfit.getData().add(new XYChart.Data("August", Integer.parseInt(product.getAUG())));
                        TotalProfit.getData().add(new XYChart.Data("September", Integer.parseInt(product.getSEP())));
                        TotalProfit.getData().add(new XYChart.Data("October", Integer.parseInt(product.getOCT())));
                        TotalProfit.getData().add(new XYChart.Data("November", Integer.parseInt(product.getNOV())));
                        TotalProfit.getData().add(new XYChart.Data("December", Integer.parseInt(product.getDEC())));
                        chart.getData().addAll(TotalProfit);
                        chart2.getData().clear();
                        piecharthead.setText("Total Cars Sold");
                        ObservableList<PieChart.Data> xx =
                                FXCollections.observableArrayList(
                                        new PieChart.Data("January",Integer.parseInt(product.getJAN())),
                                        new PieChart.Data("February",Integer.parseInt(product.getFEB())),
                                        new PieChart.Data("March", Integer.parseInt(product.getMAR())),
                                        new PieChart.Data("April", Integer.parseInt(product.getAPR())),
                                        new PieChart.Data("May",Integer.parseInt(product.getMAY())),
                                        new PieChart.Data("June",Integer.parseInt(product.getJUN())),
                                        new PieChart.Data("July",Integer.parseInt(product.getJULY())),
                                        new PieChart.Data("August",Integer.parseInt(product.getAUG())),
                                        new PieChart.Data("September",Integer.parseInt(product.getSEP())),
                                        new PieChart.Data("October",Integer.parseInt(product.getOCT())),
                                        new PieChart.Data("November",Integer.parseInt(product.getNOV())),
                                        new PieChart.Data("December",Integer.parseInt(product.getDEC())));
                        chart2.getData().addAll(xx);
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
    }
    public void back(ActionEvent actionEvent)throws IOException{
      try {
          Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
          stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
          scene = new Scene(root);
          stage.setScene(scene);
          stage.setTitle("Inventory");
          stage.show();

      }finally {
      }
    }

}
