package com.mangroo.utils;

public class TemperatureConverter {
    public static float toCentegrade(float temperature) {
        return  ((temperature - 32)*5)/9;
    }

    public static float toFahrenheit(float temperature) {
        return temperature * 5/9 + 32;
    }





}
