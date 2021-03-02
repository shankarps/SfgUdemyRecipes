package com.shankar.sfg.recipes.recipes.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

/**
 * @implNote This Integration Test class tests the IndexController with a Http request.
 * This is a slow test, since the full server is started for this test.
 * @see IndexController
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerHttpIT {
    //Get the port randomly assigned to start the web application
    @LocalServerPort
    private int port;

    //Spring Boot test has a Rest Template client
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testIndexUrl(){
        String response = this.restTemplate.getForObject("http://localhost:"+port+"/", String.class);
        assert (response.indexOf("My Recipes") > -1);
    }
}
