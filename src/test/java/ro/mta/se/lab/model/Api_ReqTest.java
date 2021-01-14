package ro.mta.se.lab.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class Api_ReqTest {
    Api_Req request=new Api_Req("Pitesti");

    @Before
    public void setUp() throws Exception {
        StringBuffer JSON=request.get_JSON();
    }



    @Test
    public void get_JSON() throws IOException {
        assertNotNull(request.get_JSON());
    }
}