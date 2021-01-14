package ro.mta.se.lab.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeatherTest {

    Weather vreme1=new Weather();
    @Before
    public void setUp() {

        vreme1.set_attr(300.00,26.85,"Clear", (long) 10000, (long) 85);
    }
    @Test
    public void get_temp_f() {
        assertEquals((Double)300.00,vreme1.get_temp_f());
    }

    @Test
    public void get_temp_c() {
        assertEquals((Double)26.85,vreme1.get_temp_c());
    }

    @Test
    public void get_main() {
        assertEquals("Clear",vreme1.get_main());
    }



}