package com.mangroo.utils;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class TemperatureConverterTest {

    @Test
    public void shouldConverFToC() {
        assertThat(round(TemperatureConverter.toCentegrade(32f),2)).isEqualTo(0);
        assertThat(round(TemperatureConverter.toCentegrade(70f),2)).isEqualTo(21.11f);
        assertThat(round(TemperatureConverter.toCentegrade(0f),2)).isEqualTo(-17.78f);
    }

    @Test
    public void shouldConverCToF() {
        assertThat(round(TemperatureConverter.toFahrenheit(0f),2)).isEqualTo(32f);
        assertThat(round(TemperatureConverter.toFahrenheit(100f),2)).isEqualTo(87.56f);
        assertThat(round(TemperatureConverter.toFahrenheit(-10f),2)).isEqualTo(26.44f);
    }


    private static float round(float d, int decimalPlace) {
        return BigDecimal.valueOf(d).setScale(decimalPlace,BigDecimal.ROUND_HALF_UP).floatValue();
    }

}
