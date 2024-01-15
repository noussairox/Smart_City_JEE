package dao;

import smartcity.ConnectionSingleton;
import models.ReservationTerrain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoReservation {

    public boolean addReservation(ReservationTerrain reservation) {
        try (Connection connection = ConnectionSingleton.getConnection()) {
            String query = "INSERT INTO reservationterrain (idTerrain, nomTerrain, dateDebut, dateFin, nomReservant, numeroTel) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, reservation.getIdTerrain());
                preparedStatement.setString(2, reservation.getNomTerrain());
                preparedStatement.setTimestamp(3, reservation.getDateDebut());
                preparedStatement.setTimestamp(4, reservation.getDateFin());
                preparedStatement.setString(5, reservation.getNomReservant());
                preparedStatement.setString(6, reservation.getNumeroTel());

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error in reservation insertion");
            return false;
        }
    }
}
