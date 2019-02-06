package com.mangroo.temperature.data.repo;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException;
import com.mangroo.Application;
import com.mangroo.temperature.TemperatureConfiguration;
import com.mangroo.temperature.data.Temperature;
import com.mangroo.temperature.data.repo.TemperatureRepository;
import com.mangroo.temperature.integration.CucumberBase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TemperatureConfiguration.class)
@ActiveProfiles("INTEGRATION_TEST")
public class TemperatureRepositoryIT {

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Before
    public void before() {
        try {
            CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Temperature.class);

            tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

            amazonDynamoDB.createTable(tableRequest);
        } catch (ResourceInUseException e) {
            // Do nothing, table already created
            e.printStackTrace();
        }
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
