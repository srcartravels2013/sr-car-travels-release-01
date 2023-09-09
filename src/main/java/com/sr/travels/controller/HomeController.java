package com.sr.travels.controller;

import com.sr.travels.models.EmailRequest;
import com.sr.travels.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private EmailController emailController;

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
    @RequestMapping("/submittedData")
    public double getPrice(@RequestParam("fromCity") String fromCity, @RequestParam("toCity") String toCity,
    @RequestParam("pickUpDate") String pickUpDate, @RequestParam("pickUpTime") String pickUpTime, @RequestParam("mobNumber") String mobNumber, @RequestParam("email") String email) {

        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setFromCity(fromCity);
        emailRequest.setToCity(toCity);
        emailRequest.setPickUpDate(pickUpDate);
        emailRequest.setPickUpTime(pickUpTime);
        emailRequest.setMobNumber(mobNumber);
        emailRequest.setEmail(email);

        //String mailResponse = emailController.sendEmail(emailRequest);

        return myService.getPrice(emailRequest);
    }
}
