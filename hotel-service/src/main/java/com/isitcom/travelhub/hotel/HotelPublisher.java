package com.isitcom.travelhub.hotel;

import jakarta.xml.ws.Endpoint;

public class HotelPublisher {
    public static void main(String[] args) {
        String url = "http://localhost:8082/hotel";
        Endpoint.publish(url, new HotelServiceImpl());
        System.out.println("✅ HotelService running at: " + url + "?wsdl");
    }
}
