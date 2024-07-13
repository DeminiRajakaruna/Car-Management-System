package cw.admin;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Map;


public class Product {
    private SimpleStringProperty VehicleMake;
    private SimpleStringProperty VehicleModel;
    private SimpleStringProperty OldOwner;
    private SimpleIntegerProperty Mileage;
    private SimpleIntegerProperty Year;
    private SimpleIntegerProperty AskPrice;
    private SimpleIntegerProperty SellPrice;
    private SimpleStringProperty Availability;


    public Product(String VehicleMake, String VehicleModel, String OldOwner,Integer Year,Integer Mileage,Integer AskPrice,Integer SellPrice, String Availability) {
        this.VehicleMake = new SimpleStringProperty(VehicleMake);
        this.VehicleModel = new SimpleStringProperty(VehicleModel);
        this.OldOwner = new SimpleStringProperty(OldOwner);
        this.Year = new SimpleIntegerProperty(Year);
        this.Mileage = new SimpleIntegerProperty(Mileage);
        this.AskPrice = new SimpleIntegerProperty(AskPrice);
        this.SellPrice = new SimpleIntegerProperty(SellPrice);
        this.Availability = new SimpleStringProperty(Availability);
    }

    public int getMileage() {
        return Mileage.get();
    }

    public SimpleIntegerProperty mileageProperty() {
        return Mileage;
    }

    public void setMileage(int mileage) {
        this.Mileage = new SimpleIntegerProperty();
    }

    public int getYear() {
        return Year.get();
    }

    public SimpleIntegerProperty yearProperty() {
        return Year;
    }

    public void setYear(int year) {
        this.Year = new SimpleIntegerProperty();
    }

    public int getAskPrice() {
        return AskPrice.get();
    }

    public SimpleIntegerProperty askPriceProperty() {
        return AskPrice;
    }

    public void setAskPrice(int askPrice) {
        this.AskPrice = new SimpleIntegerProperty();
    }

    public int getSellPrice() {
        return SellPrice.get();
    }

    public SimpleIntegerProperty sellPriceProperty() {
        return SellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.SellPrice = new SimpleIntegerProperty();
    }

    public String getVehicleMake() {
        return VehicleMake.get();
    }

    public SimpleStringProperty vehicleMakeProperty() {
        return VehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.VehicleMake = new SimpleStringProperty();
    }

    public String getVehicleModel() {
        return VehicleModel.get();
    }

    public SimpleStringProperty vehicleModelProperty() {
        return VehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.VehicleModel = new SimpleStringProperty();
    }

    public String getOldOwner() {
        return OldOwner.get();
    }

    public SimpleStringProperty oldOwnerProperty() {
        return OldOwner;
    }

    public void setOldOwner(String oldOwner) {
        this.OldOwner = new SimpleStringProperty();
    }


    public String getAvailability() {
        return Availability.get();
    }

    public SimpleStringProperty availabilityProperty() {
        return Availability;
    }

    public void setAvailability(String availability) {
        this.Availability = new SimpleStringProperty();
    }

}
