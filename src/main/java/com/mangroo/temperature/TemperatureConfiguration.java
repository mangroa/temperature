package com.mangroo.temperature;

import com.mangroo.temperature.business.TemperatureService;
import com.mangroo.temperature.data.TemperatureRepository;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
public class TemperatureConfiguration {

    @Bean
    public TemperatureService temperatureService(
            TemperatureRepository temperatureRepository) {
        return new TemperatureService(temperatureRepository);
    }

}
