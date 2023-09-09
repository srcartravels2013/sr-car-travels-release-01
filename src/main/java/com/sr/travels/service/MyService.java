package com.sr.travels.service;

import com.sr.travels.models.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyService {
    private final RestTemplate restTemplate;

    @Autowired
    public MyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String makeRestCall(String restUrl) {
        // Define the URL and perform an HTTP GET request

        String response = restTemplate.getForObject(restUrl, String.class);

        return response;
    }

    public double getPrice(EmailRequest request) {

        return 0.00;
    }
}
