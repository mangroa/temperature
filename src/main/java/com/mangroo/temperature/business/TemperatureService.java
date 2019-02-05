package com.mangroo.temperature.business;

import com.mangroo.temperature.data.Temperature;
import com.mangroo.temperature.data.TemperatureRepository;

public class TemperatureService {

    private TemperatureRepository temperatureRepository;

    public TemperatureService(TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    public Temperature save(Temperature temperature) {
        return temperatureRepository.save(temperature);
    }

}
