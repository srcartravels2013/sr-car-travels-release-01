package com.sr.travels.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomePage() {

        return "home";
    }

    @GetMapping("/home")
    public String redirectHomePage() {

        return "home";
    }

    @GetMapping("/tariffs")
    public String redirectTariffsPage() {

        return "tariffs";
    }

    @GetMapping("/vijayawada-city-tour")
    public String redirectCityTourPage() {

        return "vijayawada-city-tour";
    }

    @GetMapping("/pancharama-kshetras")
    public String redirectKshetrasPage() {

        return "pancharama-kshetras";
    }
}
