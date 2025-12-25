package com.isitcom.travelhub.flight;

import jakarta.xml.ws.Endpoint;

public class FlightPublisher {
    public static void main(String[] args) {
        String url = "http://localhost:8081/flight";
        Endpoint.publish(url, new FlightServiceImpl());
        System.out.println("✅ FlightService running at: " + url + "?wsdl");
    }
}
