package com.mangroo.temperature.integration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {
                "json:target/temperature.json",
                "html:target/temperature.html",
                "pretty"
        },
        tags = {"~@ignored"},
        features = {"src/test/resources/features"}
)
public class TemperatureIT {
}
