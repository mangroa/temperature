package com.mangroo.temperature.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TemperatureRepositoryTest {

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Test
    public void findsByName() {
        Temperature temperature = Temperature.builder()
                .id(100L)
                .name("Bedroom")
                .temperature(25)
                .build();
        temperatureRepository.save(temperature);
        List<Temperature> foundTemperature = temperatureRepository.findByName("Bedroom");
        assertThat(foundTemperature).hasSize(1);
        assertThat(foundTemperature.get(0).getName()).isEqualTo("Bedroom");
        assertThat(foundTemperature.get(0).getTemperature()).isEqualTo(25);

    }
}
