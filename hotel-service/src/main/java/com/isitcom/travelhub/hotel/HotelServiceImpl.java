package com.isitcom.travelhub.hotel;

import jakarta.jws.WebService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "com.isitcom.travelhub.hotel.HotelService")
public class HotelServiceImpl implements HotelService {

    @Override
    public List<Chambre> getHotelsByVille(String ville) {
        List<Chambre> chambres = new ArrayList<>();

        String sql = "SELECT * FROM CHAMBRES WHERE VILLE = ? AND EST_DISPONIBLE = 1";

        try (Connection conn = HotelDb.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ville);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Chambre c = new Chambre(
                            rs.getInt("ID"),
                            rs.getString("NOM_HOTEL"),
                            rs.getString("VILLE"),
                            rs.getDouble("PRIX_NUIT"),
                            rs.getInt("EST_DISPONIBLE")
                    );
                    chambres.add(c);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return chambres;
    }

    @Override
    public boolean reserverChambre(int idChambre) {
        String checkSql = "SELECT EST_DISPONIBLE FROM CHAMBRES WHERE ID = ?";
        String updateSql = "UPDATE CHAMBRES SET EST_DISPONIBLE = 0 WHERE ID = ? AND EST_DISPONIBLE = 1";

        try (Connection conn = HotelDb.getConnection()) {
            conn.setAutoCommit(false);

            int dispo;
            try (PreparedStatement check = conn.prepareStatement(checkSql)) {
                check.setInt(1, idChambre);
                try (ResultSet rs = check.executeQuery()) {
                    if (!rs.next()) { conn.rollback(); return false; }
                    dispo = rs.getInt(1);
                }
            }

            if (dispo == 0) { conn.rollback(); return false; }

            try (PreparedStatement upd = conn.prepareStatement(updateSql)) {
                upd.setInt(1, idChambre);
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
