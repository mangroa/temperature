package com.mangroo.temperature.integration;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class GetHealthSteps extends CucumberBase {
    private ResponseEntity<String> response; // output

    @When("^the client checks the health of the application$")
    public void the_client_issues_GET_health() throws Throwable {
        response = template.getForEntity("/actuator/health", String.class);
    }

    @Then("^the application is up$")
    public void the_client_receives_status_code_of() throws Throwable {
        HttpStatus currentStatusCode = response.getStatusCode();
        assertThat("status code is incorrect : " +
                response.getBody(), currentStatusCode.value(), is(HttpStatus.OK.value()));
    }

}