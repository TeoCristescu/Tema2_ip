package ro.mta.se.lab.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Teo Cristescu
 * Clasa realizeaza testarea clasei Api_Req
 *
 */
public class Api_ReqTest {
    /**
     * membrul request va realiza requestul catre api si se va verifica daca se primeste un raspuns
     */
    Api_Req request=new Api_Req("Pitesti");

    /**
     * membrul JSON va stoca raspunsul de la API
     * va fi initializat cu raspunsul requestului
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        StringBuffer JSON=request.get_JSON();
    }


    /**
     * Aici se verifica daca raspunsul de la API nu este null
     * @throws IOException
     */
    @Test
    public void get_JSON() throws IOException {
        assertNotNull(request.get_JSON());
    }
}