package com.isitcom.travelhub.clientapp;

import java.util.List;
import java.util.Scanner;

// Classes générées automatiquement par wsimport
import com.isitcom.travelhub.client.FlightServiceImplService;
import com.isitcom.travelhub.client.FlightService;
import com.isitcom.travelhub.client.Vol;

import com.isitcom.travelhub.client.HotelServiceImplService;
import com.isitcom.travelhub.client.HotelService;
import com.isitcom.travelhub.client.Chambre;

public class AgencyClient {

    public static void main(String[] args) {

        // Connexion aux services SOAP
        FlightServiceImplService flightWs = new FlightServiceImplService();
        FlightService flight = flightWs.getFlightServiceImplPort();

        HotelServiceImplService hotelWs = new HotelServiceImplService();
        HotelService hotel = hotelWs.getHotelServiceImplPort();

        Scanner sc = new Scanner(System.in);

        System.out.print("Ville / Destination : ");
        String dest = sc.nextLine();

        List<Vol> vols = flight.getVolsByDest(dest);
        List<Chambre> chambres = hotel.getHotelsByVille(dest);

        System.out.println("\n=== Vols ===");
        for (Vol v : vols) {
            System.out.println(
                    "ID=" + v.getId()
                            + " | " + v.getDestination()
                            + " | " + v.getDateDepart()
                            + " | Prix=" + v.getPrix()
                            + " | Places=" + v.getPlacesDisponibles()
            );
        }

        System.out.println("\n=== Chambres ===");
        for (Chambre c : chambres) {
            System.out.println(
                    "ID=" + c.getId()
                            + " | " + c.getNomHotel()
                            + " | " + c.getVille()
                            + " | Prix/nuit=" + c.getPrixNuit()
                            + " | Dispo=" + c.getEstDisponible()
            );
        }

        System.out.print("\nID du vol à réserver : ");
        int idVol = Integer.parseInt(sc.nextLine());

        System.out.print("ID de la chambre à réserver : ");
        int idChambre = Integer.parseInt(sc.nextLine());

        boolean okVol = flight.reserverVol(idVol);
        boolean okChambre = hotel.reserverChambre(idChambre);

        System.out.println("\n=== Résultat ===");
        System.out.println("Vol : " + (okVol ? "OK" : "ECHEC"));
        System.out.println("Chambre : " + (okChambre ? "OK" : "ECHEC"));
    }
}
