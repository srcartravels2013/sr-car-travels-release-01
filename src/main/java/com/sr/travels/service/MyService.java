package com.sr.travels.service;

import com.sr.travels.models.*;
import com.sr.travels.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyService {
    private final RestTemplate restTemplate;

    @Autowired
    public MyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GeoData makeRestCall(String restUrl) {
        // Define the URL and perform an HTTP GET request

        GeoData response = null;

        try {
            response = restTemplate.getForObject(restUrl, GeoData.class);
        } catch (Exception e){
            e.printStackTrace();
        }

        return response;
    }

    public Price getPrice(Double distance, String tripType) {

        Price price = null;

        if(tripType.equals("roundTrip")){
            price = getPriceForRoundTrip(distance);


        } else if (tripType.equals("oneWay")) {
            price = getPriceForOneWay(distance);
        }

        return price;
    }

    public Price getPriceForOneWay(double distance) {

        Price price = new Price();

        int km = (int) distance;

        int totalKm = km * 2;
        int baseFareCostD = totalKm * 10;
        int baseFareCostE = totalKm * 12;
        int baseFareCostI = totalKm * 13;
        int tollsCount = km/50;

        int tollPrice = tollsCount * 100;

        int reasonablePriceForDVehicles = baseFareCostD + tollPrice + 500 ;
        int reasonablePriceForEVehicles = baseFareCostE + tollPrice + 500 ;
        int reasonablePriceForIVehicles = baseFareCostI + tollPrice + 500 ;

        price.setdPrice(reasonablePriceForDVehicles);
        price.setePrice(reasonablePriceForEVehicles);
        price.setiPrice(reasonablePriceForIVehicles);

        return price;
    }

    public Price getPriceForRoundTrip(double distance) {

        Price price = new Price();

        int km = (int) distance;

        int totalKm = km * 2;
        int baseFareCostD = totalKm * 12;
        int baseFareCostE = totalKm * 15;
        int baseFareCostI = totalKm * 16;
        int tollsCount = totalKm/50;

        int tollPrice = tollsCount * 100;

        int reasonablePriceForDVehicles = baseFareCostD + tollPrice + 500 ;
        int reasonablePriceForEVehicles = baseFareCostE + tollPrice + 500 ;
        int reasonablePriceForIVehicles = baseFareCostI + tollPrice + 500 ;

        price.setdPrice(reasonablePriceForDVehicles);
        price.setePrice(reasonablePriceForEVehicles);
        price.setiPrice(reasonablePriceForIVehicles);

        return price;
    }

    public double getMaxKms(EmailRequest request) {

        Map<String, Double> maxKmMap = new HashMap<>();

        String restUrlFrom = "https://www.mapquestapi.com/geocoding/v1/address?key=Asdpi7LyAjPqmWkPFMmBraBkvXlBAeFy&inFormat=kvp&outFormat=json&location=" + request.getFromCity() + "&thumbMaps=false";
        String restUrlTo = "https://www.mapquestapi.com/geocoding/v1/address?key=Asdpi7LyAjPqmWkPFMmBraBkvXlBAeFy&inFormat=kvp&outFormat=json&location=" + request.getToCity() + "&thumbMaps=false";

        GeoData fromRawDataFrom = makeRestCall(restUrlFrom);
        GeoData fromRawDataTo = makeRestCall(restUrlTo);

        List<GeoResult> geoResFrom =  fromRawDataFrom.getResults();
        List<GeoResult> geoResTo =  fromRawDataTo.getResults();

        GeoLatLng geoLatLngFrom = getGeoLongLat(geoResFrom);
        GeoLatLng geoLatLngTo = getGeoLongLat(geoResTo);

        // Calculate the distance in kilometers
        double distance = Utils.calculateDistance(geoLatLngFrom.getLat(), geoLatLngFrom.getLng()
                , geoLatLngTo.getLat(), geoLatLngTo.getLng()) + 50;

        /*int tollsCount = (int) (distance/50);

        int tollPrice = tollsCount * 100;

        int fuelCostForDVehicles  = (int) (distance/18) * 112;
        int fuelCostForEVehicles  = (int) (distance/15) * 112;
        int fuelCostForIVehicles  = (int) (distance/11) * 100;

        int basePriceForDVehicles = fuelCostForDVehicles + tollPrice + 500 ;
        int basePriceForEVehicles = fuelCostForEVehicles + tollPrice + 500 ;
        int basePriceForIVehicles = fuelCostForIVehicles + tollPrice + 500 ;

        int reasonablePriceForDVehicles = 2 * basePriceForDVehicles ;
        int reasonablePriceForEVehicles = 2 * basePriceForEVehicles ;
        int reasonablePriceForIVehicles = 2 * basePriceForIVehicles ;


        maxKmMap.put("dMaxKm", distance);
        maxKmMap.put("eMaxKm", distance);
        maxKmMap.put("iMaxKm", distance);*/

        return distance;
    }

    private static GeoLatLng getGeoLongLat(List<GeoResult> geoRes) {

        GeoLatLng geoLatLng = null;
        double latitudeFrom;
        for (GeoResult geoResult: geoRes) {
            List<GeoLocation>  geoLocation = geoResult.getLocations();
            for (GeoLocation geoLoc: geoLocation) {

                geoLatLng = geoLoc.getLatLng();

                break;
            }

        }
        return geoLatLng;
    }
}
