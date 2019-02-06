package com.mangroo.temperature.business;

import com.mangroo.temperature.data.Temperature;
import com.mangroo.temperature.data.repo.TemperatureRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TemperatureServiceTest {

    private TemperatureRepository temperatureRepository = Mockito.mock(TemperatureRepository.class);

    private TemperatureService temperatureService;

    @Before
    public void setup() {this.temperatureService = new TemperatureService(temperatureRepository);}

    @Test
    public void createTemperature() {
        Temperature temperatureToSave = temperatures().get(0);
        when(temperatureRepository.save(any())).thenReturn(temperatureToSave);
        Temperature saved = temperatureService.save(temperatureToSave);
        assertThat(saved.getName()).isEqualTo("Kitchen");
        verify(temperatureRepository).save(temperatureToSave);
    }

    private List<Temperature> temperatures() {
        ArrayList<Temperature> temperatureArrayList = new ArrayList<>();
        Temperature s = Temperature.builder()
                .name("Kitchen")
                .temperatureReading(10)
                .timestamp(new Date())
                .build();
        temperatureArrayList.add(s);
        return temperatureArrayList;
    }
}
