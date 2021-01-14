package ro.mta.se.lab.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {
    StringBuffer json;

    public JsonParser(StringBuffer JSON )
    {
       this.json=JSON;
    }

    public String get_main() throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject json2 = (JSONObject) parser.parse(String.valueOf(this.json));

        JSONArray weatherArr= (JSONArray) json2.get("weather");
        JSONObject weatherob= (JSONObject) weatherArr.get(0);
        String main_desc= (String) weatherob.get("main");
        return main_desc;
    }
    public String get_icon() throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject json2 = (JSONObject) parser.parse(String.valueOf(this.json));

        JSONArray weatherArr= (JSONArray) json2.get("weather");
        JSONObject weatherob= (JSONObject) weatherArr.get(0);
        String icon= (String) weatherob.get("icon");
        return icon;
    }
    public Double get_temp_f() throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject json2 = (JSONObject) parser.parse(String.valueOf(this.json));

        JSONObject mainOb= (JSONObject) json2.get("main");
        var temperatura= (double) mainOb.get("temp");
        return temperatura;

    }
    public Long get_humidity() throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json2 = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject mainOb= (JSONObject) json2.get("main");
        var humidity=  mainOb.get("humidity");
        return (Long) humidity;
    }
    public Long get_visibility() throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject json2 = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject mainOb= (JSONObject) json2.get("main");
        var visib = json2.get("visibility");
       return (Long) visib;
    }

}
