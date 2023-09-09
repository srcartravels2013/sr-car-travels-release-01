package com.sr.travels.controller;

import com.sr.travels.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MyService myService;

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

    @GetMapping("/placesList")
    public List<String> getPlaces() {

        String url = "https://www.mapquestapi.com/search/v3/prediction?limit=5&collection=poi%2Cairport%2Caddress%2CadminArea&undefined=undefined&q=vij&key=ck2OXUAJsF0iz999XGQ62jyXo8AXOVp7";
        String url1 = "https://api.cabbazar.com/place/autocomplete?input=vijaya";
        String res= myService.makeRestCall(url);

        return null;
    }
}
