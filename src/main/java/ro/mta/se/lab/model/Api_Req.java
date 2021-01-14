package ro.mta.se.lab.model;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Api_Req {
    public static StringBuffer json;
    String city;


    public Api_Req( String city)
    {
       this.city=city;
    }

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
