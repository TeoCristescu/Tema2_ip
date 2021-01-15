package ro.mta.se.lab.controller;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;;



import static org.junit.Assert.*;

/**
 * @author Teo Cristescu
 * Clasa realizeaza testarea functionalitatii de conversie din grade K in grade C folosind testare unitara
 */
public class WeatherControllerTest {

WeatherController x= new WeatherController();

    @Test
    public void calculateC() {
        assertEquals("M", 26.85,x.calculateC(300.00), 2);

    }
}

