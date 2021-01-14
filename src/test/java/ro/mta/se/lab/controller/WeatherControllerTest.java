package ro.mta.se.lab.controller;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class WeatherControllerTest {

    @Before
    public void setUp() {
        System.out.println("Before test");
    }

    @After
    public void tearDown(){
        System.out.println("After test");
    }

    @Test
    public void calculateC() {
        assertEquals("M", 26.85, WeatherController.calculateC(300.00), 2);

    }
}

