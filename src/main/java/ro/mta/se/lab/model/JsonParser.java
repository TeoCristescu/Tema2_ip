package ro.mta.se.lab.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Teo Cristescu
 * Aceasta clasa implementeaza parsarea json-ului primit ca raspunde de la API
 */
public class JsonParser {
    /**
     * membrul json reprezinta jsonul care va fi parsat
     */
    StringBuffer json;

    /**
     * Contrustor pentru clasa
     * @param JSON
     */
    public JsonParser(StringBuffer JSON )
    {
       this.json=JSON;
    }

    /**
     * Functia va parsa json-ul si va intoarce un string ce contine descrierea main a vremii
     * @return
     * @throws ParseException
     */
    public String get_main() throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject json2 = (JSONObject) parser.parse(String.valueOf(this.json));

        JSONArray weatherArr= (JSONArray) json2.get("weather");
        JSONObject weatherob= (JSONObject) weatherArr.get(0);
        String main_desc= (String) weatherob.get("main");
        return main_desc;
    }

    /**
     * Functia va parsa json-ul si va intoarce icon-ul pentru imaginea descriptiva a vremii
     * @return
     * @throws ParseException
     */
    public String get_icon() throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject json2 = (JSONObject) parser.parse(String.valueOf(this.json));

        JSONArray weatherArr= (JSONArray) json2.get("weather");
        JSONObject weatherob= (JSONObject) weatherArr.get(0);
        String icon= (String) weatherob.get("icon");
        return icon;
    }

    /**
     * Functia va parsa json-ul si va intoarce temperatura in grade K
     * @return
     * @throws ParseException
     */
    public Double get_temp_f() throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject json2 = (JSONObject) parser.parse(String.valueOf(this.json));

        JSONObject mainOb= (JSONObject) json2.get("main");
        var temperatura= (double) mainOb.get("temp");
        return temperatura;

    }

    /**
     * Functia va parsa json-ul si va intoarce umiditatea
     * @return
     * @throws ParseException
     */
    public Long get_humidity() throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json2 = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject mainOb= (JSONObject) json2.get("main");
        var humidity=  mainOb.get("humidity");
        return (Long) humidity;
    }

    /**
     * Functia va parsa json-ul si va intoarce vizibilitatea
     * @return
     * @throws ParseException
     */
    public Long get_visibility() throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject json2 = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject mainOb= (JSONObject) json2.get("main");
        var visib = json2.get("visibility");
       return (Long) visib;
    }

}
