package cw.admin;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Map;


public class Orders {
    private SimpleStringProperty VehicleMake;
    private SimpleStringProperty OldOwner;
    private SimpleStringProperty Name;
    private SimpleStringProperty Telephone;
    private SimpleStringProperty VehicleModel;
    private SimpleStringProperty Maintenance;
    private SimpleIntegerProperty Mileage;
    private SimpleIntegerProperty Year;
    private SimpleIntegerProperty Profit;

    private SimpleIntegerProperty SellPrice;
    private SimpleStringProperty Availability;


    public Orders(String VehicleMake, String VehicleModel, String Maintenance ,Integer Year,Integer Mileage,
                  Integer Profit,Integer SellPrice, String Availability,String Name,String Telephone,String OldOwner) {
        this.VehicleMake = new SimpleStringProperty(VehicleMake);
        this.VehicleModel = new SimpleStringProperty(VehicleModel);
        this.Maintenance = new SimpleStringProperty(Maintenance);
        this.Year = new SimpleIntegerProperty(Year);
        this.Mileage = new SimpleIntegerProperty(Mileage);
        this.Profit = new SimpleIntegerProperty(Profit);
        this.SellPrice = new SimpleIntegerProperty(SellPrice);
        this.Availability = new SimpleStringProperty(Availability);
        this.Name = new SimpleStringProperty(Name);
        this.Telephone = new SimpleStringProperty(Telephone);
        this.OldOwner = new SimpleStringProperty(OldOwner);
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

    public int getProfit() {
        return Profit.get();
    }

    public SimpleIntegerProperty profitProperty() {
        return Profit;
    }

    public void setProfit(int profit) {
        this.Profit = new SimpleIntegerProperty();
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

    public String getMaintenance() {
        return Maintenance.get();
    }

    public SimpleStringProperty MaintenanceProperty() {
        return Maintenance;
    }

    public void setMaintenance(String Maintenance) {
        this.Maintenance = new SimpleStringProperty();
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

    public String getName() {
        return Name.get();
    }

    public SimpleStringProperty nameProperty() {
        return Name;
    }

    public void setName(String name) {
        this.Name = new SimpleStringProperty();
    }

    public String getTelephone() {
        return Telephone.get();
    }

    public SimpleStringProperty telephoneProperty() {
        return Telephone;
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

    public void setTelephone(String telephone) {
        this.Telephone = new SimpleStringProperty();
    }
}

