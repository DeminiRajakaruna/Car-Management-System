package cw.admin;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Map;


public class TestRides {
    private SimpleStringProperty Make;
    private SimpleStringProperty Name;
    private SimpleStringProperty Telephone;
    private SimpleStringProperty Model;
    private SimpleStringProperty Appointment;

    private SimpleIntegerProperty Mileage;
    private SimpleIntegerProperty Year;
    private SimpleIntegerProperty Price;





    public TestRides(String Make, String Model ,Integer Year,Integer Mileage,
                   Integer Price,String Name,String Telephone,String Appointment) {
        this.Make = new SimpleStringProperty(Make);
        this.Model = new SimpleStringProperty(Model);
        this.Appointment = new SimpleStringProperty(Appointment);
        this.Year = new SimpleIntegerProperty(Year);
        this.Mileage = new SimpleIntegerProperty(Mileage);
        this.Price = new SimpleIntegerProperty(Price);
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

    public Integer getPrice() {
        return Price.get();
    }

    public SimpleIntegerProperty PriceProperty() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = new SimpleIntegerProperty();
    }

    public String getMake() {
        return Make.get();
    }

    public SimpleStringProperty MakeProperty() {
        return Make;
    }

    public void setMake(String Make) {
        this.Make = new SimpleStringProperty();
    }

    public String getModel() {
        return Model.get();
    }

    public SimpleStringProperty ModelProperty() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = new SimpleStringProperty();
    }

    public String getAppointment() {
        return Appointment.get();
    }

    public SimpleStringProperty AppointmentProperty() {
        return Appointment;
    }

    public void setAppointment(String Appointment) {
        this.Appointment = new SimpleStringProperty();
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


