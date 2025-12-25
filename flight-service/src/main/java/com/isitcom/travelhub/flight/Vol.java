package com.isitcom.travelhub.flight;

import java.io.Serializable;

public class Vol implements Serializable {
    private int id;
    private String destination;
    private String dateDepart;
    private double prix;
    private int placesDisponibles;

    public Vol() {}

    public Vol(int id, String destination, String dateDepart, double prix, int placesDisponibles) {
        this.id = id;
        this.destination = destination;
        this.dateDepart = dateDepart;
        this.prix = prix;
        this.placesDisponibles = placesDisponibles;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public String getDateDepart() { return dateDepart; }
    public void setDateDepart(String dateDepart) { this.dateDepart = dateDepart; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public int getPlacesDisponibles() { return placesDisponibles; }
    public void setPlacesDisponibles(int placesDisponibles) { this.placesDisponibles = placesDisponibles; }
}
