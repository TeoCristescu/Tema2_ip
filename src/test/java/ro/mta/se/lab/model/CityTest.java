package ro.mta.se.lab.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Teo Cristescu
 * Aceasta clasa va testa constructorul si getterele calsei City
 */
public class CityTest {
    /**
     * membrul city1 va fi obiectul de tip City ceva fi testat
     */
    private City city1;

    /**
     * aici se apeleaza constructorul clasei City
     */
    @Before
    public void setUp() {
      city1=new City("Pitesti","RO");
    }

    /**
     * Aici se testeaza getName()
     */
    @Test
    public void getName() {
   assertEquals("Pitesti",city1.getName());
    }

    /**
     * Aici se testeaza get_country()
     */
    @Test
    public void get_country() {
        assertNotNull(city1.get_country());
    }

}