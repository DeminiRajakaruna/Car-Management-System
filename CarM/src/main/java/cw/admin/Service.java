package cw.admin;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Map;


public class Service {
    private SimpleStringProperty VehicleMake;
    private SimpleStringProperty Name;
    private SimpleStringProperty Telephone;
    private SimpleStringProperty VehicleModel;
    private SimpleStringProperty Maintenance;
    private SimpleStringProperty Report;
    private SimpleIntegerProperty Mileage;
    private SimpleIntegerProperty Year;

    private SimpleIntegerProperty ServiceCost;



    public Service(String VehicleMake, String VehicleModel, String Maintenance ,Integer Year,Integer Mileage,
                  Integer ServiceCost,String Name,String Telephone,String Report) {
        this.VehicleMake = new SimpleStringProperty(VehicleMake);
        this.VehicleModel = new SimpleStringProperty(VehicleModel);
        this.Maintenance = new SimpleStringProperty(Maintenance);
        this.Year = new SimpleIntegerProperty(Year);
        this.Mileage = new SimpleIntegerProperty(Mileage);
        this.ServiceCost = new SimpleIntegerProperty(ServiceCost);
        this.Report = new SimpleStringProperty(Report);
        this.Name = new SimpleStringProperty(Name);
        this.Telephone = new SimpleStringProperty(Telephone);
    }

    public Integer getMileage() {
        return Mileage.get();
    }

    public SimpleIntegerProperty mileageProperty() {
        return Mileage;
    }

    public void setMileage(int mileage) {
        this.Mileage = new SimpleIntegerProperty();
    }

    public Integer getYear() {
        return Year.get();
    }

    public SimpleIntegerProperty yearProperty() {
        return Year;
    }

    public void setYear(int year) {
        this.Year = new SimpleIntegerProperty();
    }

    public Integer getServiceCost() {
        return ServiceCost.get();
    }

    public SimpleIntegerProperty ServiceCostProperty() {
        return ServiceCost;
    }

    public void setServiceCost(int ServiceCost) {
        this.ServiceCost = new SimpleIntegerProperty();
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


    public String getReport() {
        return Report.get();
    }

    public SimpleStringProperty ReportProperty() {
        return Report;
    }

    public void setReport(String Report) {
        this.Report = new SimpleStringProperty();
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

    public void setTelephone(String telephone) {
        this.Telephone = new SimpleStringProperty();
    }
}

