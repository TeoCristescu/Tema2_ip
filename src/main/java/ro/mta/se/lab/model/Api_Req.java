package ro.mta.se.lab.model;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Teo Cristescu
 * Aceasta clasa este implementata pentru a realiza conexiunea cu Api-ul Weather pentru a obtine datele de care avem nevoie
 *
 */
public class Api_Req {
    /**
     * membrul json reprezinta stringul ce va fi primit ca raspuns de la API
     * membrul city reprezinta orasul pentru care se va face request-ul
     */
    public static StringBuffer json;
    String city;

    /**
     * contrustor pentru clasa Api_req
     * @param city reprezinta orasul pentru care se va face request-ul
     */
    public Api_Req( String city)
    {
       this.city=city;
    }

    /**
     * Aceasta functie va face request-ul catre APi
     * De asemenea va returna jsonul primit
     * @return
     * @throws IOException
     */
    public StringBuffer get_JSON() throws IOException {
        URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=14a0d1ff361c469075a692aa39f96e6d\n");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(connection.getInputStream()));


         this.json = new StringBuffer(1024);
        String tmp = "";

        while((tmp = reader.readLine()) != null)
            this.json.append(tmp).append("\n");
        reader.close();

        return json;
    }

}
