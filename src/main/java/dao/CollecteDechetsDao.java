package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import models.CollecteDechets;
import models.Adresse; // Ajoutez cet import
import smartcity.ConnectionSingleton;
import util.NominatimGeoCoder;

public class CollecteDechetsDao {
    private static final String SELECT_ALL_COLLECTIONS = "SELECT * FROM collecte_dechets";

    public List<CollecteDechets> getAllCollecteDechets() {
        List<CollecteDechets> collecteDechets = new ArrayList<>();

        try (Connection connection = ConnectionSingleton.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COLLECTIONS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                CollecteDechets collecte = new CollecteDechets();
                collecte.setId(resultSet.getInt("id"));
                collecte.setLatitude(resultSet.getString("latitude"));
                collecte.setLongitude(resultSet.getString("longitude"));
                collecte.setHeurePrevue(resultSet.getTimestamp("heurePrevue"));
                collecte.setStatut(resultSet.getString("status"));

                try {
                    Adresse adresse = NominatimGeoCoder.getFullAddress(collecte.getLatitude(), collecte.getLongitude());
                    collecte.setAdresse(adresse);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                collecteDechets.add(collecte);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return collecteDechets;
    }
    
    private static final String INSERT_COLLECTE = "INSERT INTO collecte_dechets (latitude, longitude, heurePrevue, status) VALUES (?, ?, ?, ?)";
    private static final String DELETE_COLLECTE = "DELETE FROM collecte_dechets WHERE id = ?";

    public void addCollecteDechets(CollecteDechets collecte) {
        try (Connection connection = ConnectionSingleton.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COLLECTE, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, collecte.getLatitude());
            preparedStatement.setString(2, collecte.getLongitude());
            preparedStatement.setTimestamp(3, collecte.getHeurePrevue());
            preparedStatement.setString(4, collecte.getStatut());

            preparedStatement.executeUpdate();

            // Récupérez l'ID généré pour la collecte ajoutée
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    collecte.setId(generatedKeys.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCollecteDechets(int id) {
        try (Connection connection = ConnectionSingleton.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COLLECTE)) {

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
