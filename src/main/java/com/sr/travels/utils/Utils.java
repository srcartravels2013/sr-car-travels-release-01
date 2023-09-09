package com.sr.travels.utils;

public class Utils {

    public static void main(String[] args) {

        // Coordinates of two points in decimal degrees
        double latitude1 = 16.50256; // Latitude of Point 1 Vijayawada
        double longitude1 = 80.63975; // Longitude of Point 1 Vijayawada
        double latitude2 = 17.3949; // Latitude of Point 2 Hyderabad
        double longitude2 = 78.47073; // Longitude of Point 2 Hyderabad

        // Calculate the distance in kilometers
        double distance = calculateDistance(latitude1, longitude1, latitude2, longitude2);

        System.out.println("The distance between the two points is: " + distance + " kilometers.");
    }

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the Earth (in kilometers)

        // Convert latitude and longitude from degrees to radians
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Haversine formula
        double dlon = lon2Rad - lon1Rad;
        double dlat = lat2Rad - lat1Rad;
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Calculate the distance
        double distance = R * c;
        return distance;
    }
}
