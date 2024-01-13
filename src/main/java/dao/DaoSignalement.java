package dao;

import smartcity.ConnectionSingleton;
import models.Signalement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoSignalement {

    public boolean ajouterSignalement(Signalement signalement) {
        try (Connection connection = ConnectionSingleton.getConnection()) {
            String query = "INSERT INTO signalements (description, latitude, longitude, localisation, type_reclamation, photo_path) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, signalement.getDescription());
                preparedStatement.setDouble(2, signalement.getLatitude());
                preparedStatement.setDouble(3, signalement.getLongitude());
                preparedStatement.setString(4, signalement.getLocalisation());
                preparedStatement.setString(5, signalement.getTypeReclamation());
                preparedStatement.setString(6, signalement.getPhotoPath());

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur dans l'insertion");
            return false;
        }
    }
}
