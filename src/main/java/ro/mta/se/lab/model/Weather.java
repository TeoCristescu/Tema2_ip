package ro.mta.se.lab.model;

/**
 * @author Teo Cristescu
 * Clasa Weather va tine evidenta vremii intr un anume oras
 */
public class Weather {

    /**
     * membrul temperature_f reprezinta temperatura in grade K
     * membrul temperature_c reprezinta temperatura in grade C
     * membrul main_weather reprezinta descrierea main a vremii
     * membrul visibility reprezinta vizibilitatea
     * membrul humidity reprezinta umiditatea
     */
     Double temperature_f;
    Double temperature_c;
    String main_weather;
    Long visibility;
     Long humidity;

    /**
     * cu ajutorul acestei functii se vor da valori atributelor clasei
     * @param temp_f
     * @param temp_c
     * @param main
     * @param vis
     * @param hum
     */
    public void set_attr(Double temp_f,Double temp_c, String main,Long vis,Long hum )
    {
        this.temperature_f=temp_f;
        this.main_weather=main;
        this.visibility=vis;
        this.humidity=hum;
        this.temperature_c=temp_c;
    }

    /**
     * getter pentru temperatura in grade K
     * @return
     */
    public Double get_temp_f() {
        return temperature_f;
    }

    /**
     * getter peentru temperatura in grade C
     * @return
     */
    public Double get_temp_c() {
        return temperature_c;
    }

    /**
     * getter pentru descrierea main a vremii
     * @return
     */
    public String get_main() {
        return main_weather;
    }

    /**
     * getter pentru vizibilitate
     * @return
     */
    public Long get_visibility() {
        return visibility;
    }

    /**
     * getter pentru umiditate
     * @return
     */
    public Long get_humidity() {
        return humidity;
    }

}
