package com.example.telco;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endpoint")
public class Endpoint {

    @Value("${endpoint.value}")
    String envValue;

    @RequestMapping
    public String getValue() throws Exception {
        return envValue;
    }
}
