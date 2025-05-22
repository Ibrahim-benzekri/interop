package fr.ensim.interop.introrest.model;

import java.util.List;

public class OpenWeather {

    private List<Weather> weather;
    private Main main;
    private String dt_txt; // ➕ Ajoute ce champ ici

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
