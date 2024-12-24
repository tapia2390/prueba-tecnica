package com.example.appandroid.model;

import java.util.ArrayList;

public class Weathermap {

    private  String name;
    private Weather[] weather;

    private  wind wind;
private Coord coord;
    private Main main;

    public Weathermap(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public com.example.appandroid.model.wind getWind() {
        return wind;
    }

    public void setWind(com.example.appandroid.model.wind wind) {
        this.wind = wind;
    }
}
