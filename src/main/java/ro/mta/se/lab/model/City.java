package ro.mta.se.lab.model;
import javafx.beans.property.*;

public class City {
    StringProperty name;
    StringProperty country_code;
    public City(String name, String country_code )
    {
        this.name= new SimpleStringProperty(name);
        this.country_code= new SimpleStringProperty(country_code);
    }
    public String getName() {
        return name.get();
    }
    public String get_country() {
        return country_code.get();
    }
}
