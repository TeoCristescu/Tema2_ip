package ro.mta.se.lab.controller;
import java.awt.*;
import java.io.*;
import java.lang.module.Configuration;
import java.net.HttpURLConnection;
import java.net.URL;

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


    public WeatherController (ObservableList<City> CityData)

    {
        this.CityData = CityData;
    }


    @FXML
    private ComboBox countries_fxml;
    @FXML
    private ComboBox cities_fxml;
    @FXML
    private Button show;

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
    private void oras_selectat()
    {
        this.selected_city=(String) cities_fxml.getValue();
    }

    @FXML
    public void handler_buton() throws IOException, ParseException {
        Api_Req request=new Api_Req(selected_city);
        StringBuffer JSON=request.get_JSON();
        JsonParser y=new JsonParser(JSON);
        x.set_attr(y.get_temp_f(),y.get_main(),y.get_visibility(),y.get_humidity());
        System.out.println(x.get_main());
        System.out.println(x.get_temp_f());
        System.out.println(x.get_humidity());
        System.out.println(x.get_visibility());


    }
}
