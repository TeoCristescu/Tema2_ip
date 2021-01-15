package ro.mta.se.lab.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Teo Cristescu
 * Aceasta clasa realizeaza testarea constructorului si a getterelor pentru clasa Weather
 */
public class WeatherTest {
    /**
     * membrul vreme1 este obiectul ce va fi testat
     */
    Weather vreme1=new Weather();

    /**
     * Apelarea constructorului
     */
    @Before
    public void setUp() {

        vreme1.set_attr(300.00,26.85,"Clear", (long) 10000, (long) 85);
    }

    /**
     * Verificarea getterului pentru temperatura in grade K
     */
    @Test
    public void get_temp_f() {
        assertEquals((Double)300.00,vreme1.get_temp_f());
    }

    /**
     * verificarea getterului pentru temperatura in grade C
     */
    @Test
    public void get_temp_c() {
        assertEquals((Double)26.85,vreme1.get_temp_c());
    }

    /**
     * verificarea getterului pentru descrierea vremii
     */
    @Test
    public void get_main() {
        assertEquals("Clear",vreme1.get_main());
    }



}