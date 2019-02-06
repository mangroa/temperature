package com.mangroo.temperature.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mangroo.temperature.business.TemperatureService;
import com.mangroo.temperature.data.Temperature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TemperatureController.class)
public class TemperatureControllerTest {

    Logger logger = LoggerFactory.getLogger(TemperatureControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApplicationContext applicationContext;

    @MockBean
    private TemperatureService temperatureService;

    @Before
    public void printApplicationContext() {
        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .map(name -> applicationContext.getBean(name).getClass().getName())
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void saveTemperatureReturnsHttpStatusCreated() throws Exception {
        Temperature temperatureToSave = createTemperature();
        when(temperatureService.save(any())).thenReturn(temperatureToSave);

        String jsonString = asJsonString(temperatureToSave);
        logger.info("JSON to save: {}", jsonString);
        mockMvc.perform(post("/temperatureReading/temperatures")
                .content(jsonString)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    private Temperature createTemperature() {
        return Temperature.builder()
                .name("ControllerTest")
                .temperatureReading(25)
                .timestamp(new Date())
                .build();
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
