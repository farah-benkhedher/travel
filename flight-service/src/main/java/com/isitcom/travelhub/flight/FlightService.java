package com.isitcom.travelhub.flight;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public interface FlightService {

    @WebMethod
    List<Vol> getVolsByDest(String destination);

    @WebMethod
    boolean reserverVol(int idVol);
}
