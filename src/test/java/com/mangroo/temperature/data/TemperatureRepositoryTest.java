package com.mangroo.temperature.data;

import com.mangroo.temperature.TemperatureConfiguration;
import com.mangroo.temperature.data.repo.TemperatureRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TemperatureConfiguration.class)
public class TemperatureRepositoryTest {

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Before
    public void before() {
        temperatureRepository.deleteAll();
    }

    @Test
    public void findsByName() {
        Temperature temperature = Temperature.builder()
                .name("Bedroom")
                .temperatureReading(25.5f)
                .timestamp(new Date())
                .build();
        temperatureRepository.save(temperature);
        List<Temperature> foundTemperature = temperatureRepository.findByName("Bedroom");
        assertThat(foundTemperature).hasSize(1);
        assertThat(foundTemperature.get(0).getName()).isEqualTo("Bedroom");
        assertThat(foundTemperature.get(0).getTemperatureReading()).isEqualTo(25.5f);
    }
}
