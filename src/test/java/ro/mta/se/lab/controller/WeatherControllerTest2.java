package ro.mta.se.lab.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import ro.mta.se.lab.model.City;

import java.awt.*;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author Teo Cristescu
 * Clasa aceasta realizeaza testarea din punct de vedere mock a clasei WeatherController
 *
 */
public class WeatherControllerTest2 {
    /**
     * membriul CityX reprezinta obiectul de tip City pe care se va face mock
     * membrul country este un string pe care il vom folosi sa comparam
     */
    private City CityX;
    private String Country ;

    /**
     * initializarea obiectului City
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
         CityX=new City("Pitesti","RO");


       CityX=mock(City.class);
    }

    /**
     * testarea acestuia cu ajutorul unui obiect mock
     */
    @Test
    public void get_countries() {
        when(CityX.get_country()).thenReturn("Cod_Tara");


       Country=CityX.get_country();
        System.out.println(Country);

       assertEquals(Country, CityX.get_country());
       assertNotNull(Country);
    }
    }