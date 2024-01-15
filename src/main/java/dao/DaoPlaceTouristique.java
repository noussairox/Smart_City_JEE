package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.PlaceTouristique;

public class DaoPlaceTouristique {
    private Connection connection;

    public DaoPlaceTouristique(Connection connection) {
        this.connection = connection;
    }

    public boolean addPlaceTouristique(PlaceTouristique placeTouristique) {
        String query = "INSERT INTO places_touristiques (nom, description, ville, image) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, placeTouristique.getNom());
            preparedStatement.setString(2, placeTouristique.getDescription());
            preparedStatement.setString(3, placeTouristique.getVille());
            preparedStatement.setString(4, placeTouristique.getImage());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error in place touristique insertion");
            return false;
        }
    }

    public List<PlaceTouristique> getAllPlacesTouristiques() {
        List<PlaceTouristique> placesTouristiques = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM places_touristiques");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                PlaceTouristique placeTouristique = new PlaceTouristique();
                placeTouristique.setId(resultSet.getInt("id"));
                placeTouristique.setNom(resultSet.getString("nom"));
                placeTouristique.setDescription(resultSet.getString("description"));
                placeTouristique.setVille(resultSet.getString("ville"));
                placeTouristique.setImage(resultSet.getString("image"));
                placesTouristiques.add(placeTouristique);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error fetching places touristiques");
        }
        return placesTouristiques;
    }
    
    public boolean deletePlaceTouristique(int placeId) {
        String query = "DELETE FROM places_touristiques WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, placeId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error in place touristique deletion");
            return false;
        }
    }

}
