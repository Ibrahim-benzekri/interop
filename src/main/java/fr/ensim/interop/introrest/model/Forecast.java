package fr.ensim.interop.introrest.model;

import java.util.List;

public class Forecast {
    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<OpenWeather> getList() {
        return list;
    }

    public void setList(List<OpenWeather> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    private String cod;
        private int message;
        private int cnt;
        private List<OpenWeather> list;
        private City city;


}
