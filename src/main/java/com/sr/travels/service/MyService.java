package com.sr.travels.service;

import com.sr.travels.models.EmailRequest;
import com.sr.travels.models.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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

    public Price getPrice(EmailRequest request) {

        Price price = new Price();
        price.setdPrice(5000);
        price.setePrice(5500);
        price.setiPrice(6000);

        return price;
    }

    public Map<String, Integer> getMaxKms() {

        Map<String, Integer> maxKmMap = new HashMap<>();

        maxKmMap.put("dMaxKm", 250);
        maxKmMap.put("eMaxKm", 300);
        maxKmMap.put("iMaxKm", 350);

        return maxKmMap;
    }
}
