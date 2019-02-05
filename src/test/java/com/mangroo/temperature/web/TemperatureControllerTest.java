package com.mangroo.temperature.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Autowired
//    private TemperatureService temperatureService;
//
//    @Before
//    public void printApplicationContext() {
//        Arrays.stream(applicationContext.getBeanDefinitionNames())
//                .map(name -> applicationContext.getBean(name).getClass().getName())
//                .sorted()
//                .forEach(System.out::println);
//    }
//
//    @Test
//    public void saveStaffReturnsHttpStatusCreated() throws Exception {
//        TemperatureReading temperatureReadingToSave = createTemperatureReading();
//        when(staffService.save(any())).thenReturn(temperatureReadingToSave);
//
//        mockMvc.perform(post("/temperature/TemperatureReadings")
//                .content(asJsonString(temperatureReadingToSave))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated());
//    }
//
//    private TemperatureReading createTemperatureReading() {
//        return TemperatureReading.builder()
//                .id(100L)
//                .name("Bedroom")
//                .temperature(25)
//                .timestamp(new Date())
//                .build();
//    }
//
//    private static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
