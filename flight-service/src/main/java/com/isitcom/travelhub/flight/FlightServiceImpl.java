package com.isitcom.travelhub.flight;

import jakarta.jws.WebService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "com.isitcom.travelhub.flight.FlightService")
public class FlightServiceImpl implements FlightService {

    @Override
    public List<Vol> getVolsByDest(String destination) {
        List<Vol> vols = new ArrayList<>();
        String sql = "SELECT * FROM VOLS WHERE DESTINATION = ?";

        try (Connection conn = AirDb.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, destination);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Vol v = new Vol(
                            rs.getInt("ID"),
                            rs.getString("DESTINATION"),
                            rs.getDate("DATE_DEPART").toString(),
                            rs.getDouble("PRIX"),
                            rs.getInt("PLACES_DISPONIBLES")
                    );
                    vols.add(v);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return vols;
    }

    @Override
    public boolean reserverVol(int idVol) {
        String checkSql = "SELECT PLACES_DISPONIBLES FROM VOLS WHERE ID = ?";
        String updateSql = "UPDATE VOLS SET PLACES_DISPONIBLES = PLACES_DISPONIBLES - 1 WHERE ID = ?";

        try (Connection conn = AirDb.getConnection()) {
            conn.setAutoCommit(false);

            int places;
            try (PreparedStatement check = conn.prepareStatement(checkSql)) {
                check.setInt(1, idVol);
                try (ResultSet rs = check.executeQuery()) {
                    if (!rs.next()) { conn.rollback(); return false; }
                    places = rs.getInt(1);
                }
            }

            if (places <= 0) { conn.rollback(); return false; }

            try (PreparedStatement upd = conn.prepareStatement(updateSql)) {
                upd.setInt(1, idVol);
                int updated = upd.executeUpdate();
                conn.commit();
                return updated == 1;
            } catch (Exception e) {
                conn.rollback();
                throw e;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
