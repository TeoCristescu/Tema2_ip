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


public class WeatherController {
    private  Weather x=new Weather();
    private String selected_city;
    private String selected_country;
    private ObservableList<City> CityData;
    private ObservableList<String> Countries = FXCollections.observableArrayList();

    Integer veriff=0;
    public WeatherController (ObservableList<City> CityData)

    {
        this.CityData = CityData;
    }


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

    @FXML
    private void init_tari() {
        countries_fxml.getItems().clear();
        cities_fxml.getItems().clear();
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
        countries_fxml.getItems().addAll(Countries);
    }

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

    @FXML
    private void tara_selectata()
    {
        this.selected_country=(String) countries_fxml.getValue();
    }
    @FXML
    private void oras_selectat() throws IOException, ParseException {
        this.selected_city=(String) cities_fxml.getValue();
        if(this.selected_city!=null) {
            show();
        }
    }
    public static Double calculateC(Double temp_f)
    {
     var temp_c=temp_f-273.15;
     return temp_c;
    }

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
        switch(x.get_main()) {
            case "Snow":
                image = new Image("snow.jpg");
                break;
            case "Clear":
                image = new Image("sun.png");
            case "Rain":
                image = new Image("rain.png");
            case "Clouds":
                image = new Image("clouds.jpg");
                break;
            default:
                image = new Image("sun.png");;
        }
        poza_fxml.setImage(image);



       String history= dtf.format(now) + " City: "+ selected_city + " " +x.get_main()+ " Temp F.:"+ x.get_temp_f() +" "+ "Temp C.: "+x.get_temp_c()+" Humidity: "+ x.get_humidity()+" Visibility: "+x.get_visibility() ;

        FileWriter fileWriter = new FileWriter("history.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(history);  //New line
        printWriter.close();

    }
}
