package ro.mta.se.lab.model;
import javafx.beans.property.*;

/**
 * Aceasta clasa este o clasa specifica unui oras ce va fi citit din fisier
 * @author Teo Cristescu
 *
 */
public  class City {
    /**
     * membrul name reprezinta numele orasului
     * membrul country_code reprezinta prescurtarea tarii din care face parte orasul
     */
    StringProperty name;
    StringProperty country_code;


    /**
     *
     * @param name reprezinta numele orasului
     * @param country_code reprezinta prescurtarea numelui tarii
     */
    public City(String name, String country_code )
    {
        this.name= new SimpleStringProperty(name);
        this.country_code= new SimpleStringProperty(country_code);
    }

    /**
     *
     * @return getter pentru numele orasului
     */
    public String getName() {
        return name.get();
    }

    /**
     *
     * @return getter pentru codul tarii
     */
    public  String get_country() {
        return country_code.get();
    }
}
