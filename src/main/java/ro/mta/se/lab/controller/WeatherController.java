package ro.mta.se.lab.controller;
import java.awt.*;
import java.io.*;
import java.lang.module.Configuration;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import org.w3c.dom.Text;
import ro.mta.se.lab.model.Api_Req;
import ro.mta.se.lab.model.City;
import ro.mta.se.lab.model.JsonParser;
import ro.mta.se.lab.model.Weather;

/**
 * @author Teo Cristescu
 * Clasa WeatherController este un controller pentru modelul MVC si este practic legatura dintre model si view
 */
public class WeatherController {
    /**
     * membrul Weather x este folosit pentru a tine evidenta vremii intr un oras
     * membrul selected_city reprezinta orasul selectat de utilizator
     * membrul selected_country reprezinta tara selecata de utilizator
     * membrul CityData reprezinta orasele citite din fisier
     * membrul Countries reprezinta tarile oraselor citite din fisier
     * membrul countries_fxml este combobox-ul pentru alegerea tarii din interfata grafica
     * membrul cities_fxml este combobox-ul pentru alegerea orasului din interfata grafica
     * label-urile temp_f_fxml,temp_c_fxml,visibility_fxml,main_fxml,humidity_fxml,oras_fxml,data_ora_fxml sunt folosite pentru a afisa in ele detalii
     * label-ul image este folosit pentru a afisa poza sugestiva vremii din orasul selectat
     */
    private  Weather x=new Weather();
    private String selected_city;
    private String selected_country;
    private ObservableList<City> CityData;
    private ObservableList<String> Countries = FXCollections.observableArrayList();
    @FXML
    private ComboBox countries_fxml;
    @FXML
    private ComboBox cities_fxml;
    @FXML
    private Label temp_f_fxml;
    @FXML
    private Label visibility_fxml;
    @FXML
    private Label main_fxml;
    @FXML
    private Label humidity_fxml;
    @FXML
    private Label temp_c_fxml;
    @FXML
    private Label oras_fxml;
    @FXML
    private Label data_ora_fxml;

    @FXML
    private ImageView poza_fxml;

    /**
     * constructor pentur clasa WeatherController
     * @param CityData reprezinta orasele citite din fisier si transmise mai departe pentru a fi prelucrate
     */
    public WeatherController (ObservableList<City> CityData)

    {
        this.CityData = CityData;
    }


    /**
     * constructor pentru clasa WeatherController
     */
    public WeatherController() {

    }

    /**
     * Functia care va afisa tarile in GUI
     */
    @FXML
    private void init_tari() {
        countries_fxml.getItems().clear();
        cities_fxml.getItems().clear();
        get_countries();
        countries_fxml.getItems().addAll(Countries);
    }

    /**
     * Functia care va afisa orasele in GUI
     */
    @FXML
    private void init_orase() {
        cities_fxml.getItems().clear();
        for (City X : CityData) {
            if(X.get_country().equals(selected_country))
            {
                cities_fxml.getItems().add(X.getName());
            }
        }
    }

    /**
     * functie care va pune in selected_country valoarea selectata de utilizator in GUI
     */
    @FXML
    private void tara_selectata()
    {
        this.selected_country=(String) countries_fxml.getValue();
    }

    /**
     *     functie care va pune in selected_city valoarea selectata de utilizator in GUI
     */
    @FXML
    private void oras_selectat() throws IOException, ParseException {
        this.selected_city=(String) cities_fxml.getValue();
        if(this.selected_city!=null) {
            show();
        }
    }

    /**
     * Functie care va face conversia din grade K in grade C
     * @param temp_f reprezinta temperatura in grade K
     * @return
     */
    public Double calculateC(Double temp_f)
    {
     var temp_c=temp_f-273.15;
     return temp_c;
    }

    /**
     * Functia care va popula lista de tari pe baza oraselor din fisier, fiecare tara va fi introdusa o singura data
     */
    public void get_countries() {
        for (City X : CityData) {
            var ok = 1;
            for (String count : Countries) {
                if (count.equals(X.get_country())) {
                    ok = 0;
                }
            }

            if (ok == 1) {
                Countries.add(X.get_country());
            }
        }
    }

    /**
     * Aceasta functie este apelata dupa ce tara si orasul au fost selectate
     * Functia populeaza interfata grafica cu detalii despre orasul selectat in functie de vremea de acolo
     * Mai intai se va crea un request catrea Weather API
     * Raspunsul va fi parsat
     * Obiectul de tip Weather va fi initializat
     * Din acest obiect se vor afisa apoi detaliile despre vreme
     * De asemenea, imaginea folosita pentru a ilustra vremea este tot de la API
     * In continuare, sunt scrise in fisier detaliile despre vremea din orasul ales
     * @throws IOException
     * @throws ParseException
     */
    public void show() throws IOException, ParseException {
        Api_Req request=new Api_Req(selected_city);
        StringBuffer JSON=request.get_JSON();
        JsonParser y=new JsonParser(JSON);
        x.set_attr(y.get_temp_f(),calculateC(y.get_temp_f()),y.get_main(),y.get_visibility(),y.get_humidity());

        main_fxml.setText(x.get_main());
        temp_f_fxml.setText(x.get_temp_f().toString());
        visibility_fxml.setText(x.get_visibility().toString());
        humidity_fxml.setText(x.get_humidity().toString());
        temp_c_fxml.setText(x.get_temp_c().toString());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        data_ora_fxml.setText(dtf.format(now));
        oras_fxml.setText(selected_city);
        Image image;
        System.out.println(x.get_main());

        image = new Image("https://openweathermap.org/img/wn/"+y.get_icon()+"@2x.png");

        poza_fxml.setImage(image);



       String history= dtf.format(now) + " City: "+ selected_city + " " +x.get_main()+ " Temp F.:"+ x.get_temp_f() +" "+ "Temp C.: "+x.get_temp_c()+" Humidity: "+ x.get_humidity()+" Visibility: "+x.get_visibility() ;

        FileWriter fileWriter = new FileWriter("history.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(history);  //New line
        printWriter.close();

    }
}
