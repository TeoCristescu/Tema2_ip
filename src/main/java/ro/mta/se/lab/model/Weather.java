package ro.mta.se.lab.model;

public class Weather {


    Double temperature_f;
    Double temperature_c;
    String main_weather;
    Long visibility;
    Long humidity;
    public void set_attr(Double temp_f, String main,Long vis,Long hum )
    {
        this.temperature_f=temp_f;
        this.main_weather=main;
        this.visibility=vis;
        this.humidity=hum;
        this.temperature_c=temp_f-273.15;
    }
    public Double get_temp_f() {
        return temperature_f;
    }
    public Double get_temp_c() {
        return temperature_c;
    }
    public String get_main() {
        return main_weather;
    }
    public Long get_visibility() {
        return visibility;
    }
    public Long get_humidity() {
        return humidity;
    }

}
