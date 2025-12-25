package com.isitcom.travelhub.hotel;

import java.io.Serializable;

public class Chambre implements Serializable {
    private int id;
    private String nomHotel;
    private String ville;
    private double prixNuit;
    private int estDisponible; // 1 ou 0 (comme dans MySQL)

    public Chambre() {}

    public Chambre(int id, String nomHotel, String ville, double prixNuit, int estDisponible) {
        this.id = id;
        this.nomHotel = nomHotel;
        this.ville = ville;
        this.prixNuit = prixNuit;
        this.estDisponible = estDisponible;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNomHotel() { return nomHotel; }
    public void setNomHotel(String nomHotel) { this.nomHotel = nomHotel; }

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }

    public double getPrixNuit() { return prixNuit; }
    public void setPrixNuit(double prixNuit) { this.prixNuit = prixNuit; }

    public int getEstDisponible() { return estDisponible; }
    public void setEstDisponible(int estDisponible) { this.estDisponible = estDisponible; }
}
