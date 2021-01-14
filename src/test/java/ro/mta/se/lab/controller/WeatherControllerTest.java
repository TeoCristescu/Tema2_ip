package ro.mta.se.lab.controller;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;;



import static org.junit.Assert.*;

public class WeatherControllerTest {

WeatherController x= new WeatherController();

    @Test
    public void calculateC() {
        assertEquals("M", 26.85,x.calculateC(300.00), 2);

    }
}

