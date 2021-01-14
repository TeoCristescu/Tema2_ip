package ro.mta.se.lab.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CityTest {
    private City city1;
    @Before
    public void setUp() {
      city1=new City("Pitesti","RO");
    }
    @Test
    public void getName() {
   assertEquals("Pitesti",city1.getName());
    }

    @Test
    public void get_country() {
        assertNotNull(city1.get_country());
    }

}