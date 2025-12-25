package com.isitcom.travelhub.hotel;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public interface HotelService {

    @WebMethod
    List<Chambre> getHotelsByVille(String ville);

    @WebMethod
    boolean reserverChambre(int idChambre);
}
