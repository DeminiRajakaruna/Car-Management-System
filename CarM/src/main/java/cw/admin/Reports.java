package cw.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Reports implements Initializable {
    @FXML
    public TextField january;
    public TextField february;
    public TextField march;
    public TextField april;
    public TextField may;
    public TextField june;
    public TextField july;
    public TextField august;
    public TextField september;
    public TextField october;
    public TextField november;
    public TextField december;
    public TextField january1;
    public TextField february1;
    public TextField march1;
    public TextField april1;
    public TextField may1;
    public TextField june1;
    public TextField july1;
    public TextField august1;
    public TextField september1;
    public TextField october1;
    public TextField november1;
    public TextField december1;
    public TextField total;

    public TextField total11;
    public TextField january11;
    public TextField february11;
    public TextField march11;
    public TextField april11;
    public TextField may11;
    public TextField june11;
    public TextField july11;
    public TextField august11;
    public TextField september11;
    public TextField october11;
    public TextField november11;
    public TextField december11;

    public TextField total1;



    public void initialize(URL location, ResourceBundle resources){
        try {
            Collection<ProfitByMonth> list = Files.readAllLines(new File("TotalIncome.txt").toPath())
                    .stream()
                    .map(line -> {
                        String[] details = line.split("#");
                        ProfitByMonth product =new ProfitByMonth(details[0],details[1] ,details[2] ,details[3] ,details[4] ,details[5] ,details[6] ,
                                details[7] ,details[8] ,details[9] ,details[10] ,details[11] );
                        january.setText(product.JAN);
                        february.setText(product.FEB);
                        march.setText(product.MAR);
                        april.setText(product.APR);
                        may.setText(product.MAY);
                        june.setText(product.JUN);
                        july.setText(product.JULY);
                        august.setText(product.AUG);
                        september.setText(product.SEP);
                        october.setText(product.OCT);
                        november.setText(product.NOV);
                        december.setText(product.DEC);
                        total.setText(String.valueOf(Integer.parseInt(product.JAN)+Integer.parseInt(product.FEB)+Integer.parseInt(product.MAR)
                                +Integer.parseInt(product.APR)+Integer.parseInt(product.MAY)+Integer.parseInt(product.JUN)
                                +Integer.parseInt(product.JULY)+Integer.parseInt(product.AUG)+Integer.parseInt(product.SEP)+
                                Integer.parseInt(product.OCT)+Integer.parseInt(product.NOV)+Integer.parseInt(product.DEC)));
                        return product;
                    })
                    .collect(Collectors.toList());
            Collection<ProfitByMonth> list1 = Files.readAllLines(new File("SaleProfit.txt").toPath())
                    .stream()
                    .map(line -> {
                        String[] details = line.split("#");
                        ProfitByMonth product =new ProfitByMonth(details[0],details[1] ,details[2] ,details[3] ,details[4] ,details[5] ,details[6] ,
                                details[7] ,details[8] ,details[9] ,details[10] ,details[11] );
                        january1.setText(product.JAN);
                        february1.setText(product.FEB);
                        march1.setText(product.MAR);
                        april1.setText(product.APR);
                        may1.setText(product.MAY);
                        june1.setText(product.JUN);
                        july1.setText(product.JULY);
                        august1.setText(product.AUG);
                        september1.setText(product.SEP);
                        october1.setText(product.OCT);
                        november1.setText(product.NOV);
                        december1.setText(product.DEC);
                        total1.setText(String.valueOf(Integer.parseInt(product.JAN)+Integer.parseInt(product.FEB)+Integer.parseInt(product.MAR)
                                +Integer.parseInt(product.APR)+Integer.parseInt(product.MAY)+Integer.parseInt(product.JUN)
                                +Integer.parseInt(product.JULY)+Integer.parseInt(product.AUG)+Integer.parseInt(product.SEP)+
                                Integer.parseInt(product.OCT)+Integer.parseInt(product.NOV)+Integer.parseInt(product.DEC)));
                        return product;
                    })
                    .collect(Collectors.toList());
            Collection<ProfitByMonth> list3 = Files.readAllLines(new File("ServiceProfit.txt").toPath())
                    .stream()
                    .map(line -> {
                        String[] details = line.split("#");
                        ProfitByMonth product =new ProfitByMonth(details[0],details[1] ,details[2] ,details[3] ,details[4] ,details[5] ,details[6] ,
                                details[7] ,details[8] ,details[9] ,details[10] ,details[11] );
                        january11.setText(product.JAN);
                        february11.setText(product.FEB);
                        march11.setText(product.MAR);
                        april11.setText(product.APR);
                        may11.setText(product.MAY);
                        june11.setText(product.JUN);
                        july11.setText(product.JULY);
                        august11.setText(product.AUG);
                        september11.setText(product.SEP);
                        october11.setText(product.OCT);
                        november11.setText(product.NOV);
                        december11.setText(product.DEC);
                        total11.setText(String.valueOf(Integer.parseInt(product.JAN)+Integer.parseInt(product.FEB)+Integer.parseInt(product.MAR)
                                +Integer.parseInt(product.APR)+Integer.parseInt(product.MAY)+Integer.parseInt(product.JUN)
                                +Integer.parseInt(product.JULY)+Integer.parseInt(product.AUG)+Integer.parseInt(product.SEP)+
                                Integer.parseInt(product.OCT)+Integer.parseInt(product.NOV)+Integer.parseInt(product.DEC)));
                        return product;
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void bestcustomer(ActionEvent actionEvent){
        
    }
    public void bestsellmodel(ActionEvent actionEvent){

    }
    public void back(ActionEvent actionEvent){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Inventory");
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
        }

    }
    
}
