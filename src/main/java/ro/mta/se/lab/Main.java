package ro.mta.se.lab;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ro.mta.se.lab.controller.WeatherController;
import ro.mta.se.lab.model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class Main extends Application {
    private ObservableList<City> CityData = FXCollections.observableArrayList();
    public static void main(String[] args)
    {
        launch(args);
    }
    public void initCity()
    {
        try {
            File obj = new File("src/main/resources/input.txt");
            Scanner scan = new Scanner(obj);
            String data = scan.nextLine();
            while (scan.hasNextLine()) {
                data = scan.nextLine();

                String[] array = data.split(" +");
                City x = new City(array[0], array[1]);
                CityData.add(x);
            }
            for (City X : CityData) {
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void start(Stage primaryStage) {
        initCity();
        FXMLLoader loader = new FXMLLoader();

        try {
            loader.setLocation(this.getClass().getResource("/view/WeatherView.fxml"));
            loader.setController(new WeatherController(CityData));
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}