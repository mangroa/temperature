package com.mangroo.temperature.web;

import com.mangroo.temperature.business.TemperatureService;
import com.mangroo.temperature.data.Temperature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {

    private Logger logger = LoggerFactory.getLogger(TemperatureController.class);

    private TemperatureService temperatureService;

    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @PostMapping(value = "/temperatures")
    public ResponseEntity<Temperature> saveTemperature(@RequestBody Temperature temperature) {
        logger.info("Received Temperature to save name [{}] temperature [{}] Timestamp[{}]", temperature.getName(), temperature.getTemperature(), temperature.getTimestamp());
        return new ResponseEntity<>(temperatureService.save(temperature), HttpStatus.CREATED);
    }

}
