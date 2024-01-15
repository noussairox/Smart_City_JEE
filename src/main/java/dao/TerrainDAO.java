package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Terrain;

public class TerrainDAO {
    private Connection connection;

    public TerrainDAO(Connection connection) {
        this.connection = connection;
    }

    public void ajouterTerrain(Terrain terrain) throws SQLException {
        String query = "INSERT INTO terrain (nom, description, image_terrain, disponibilite) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, terrain.getNom());
            preparedStatement.setString(2, terrain.getDescription());
            preparedStatement.setString(3, terrain.getImageTerrain());
            preparedStatement.setBoolean(4, terrain.isDisponibilite());
            preparedStatement.executeUpdate();
        }
    }

    public Terrain obtenirTerrainParId(int terrainId) throws SQLException {
        Terrain terrain = null;
        String query = "SELECT * FROM terrain WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, terrainId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    terrain = mapperTerrain(resultSet);
                }
            }
        }
        return terrain;
    }

    public List<Terrain> obtenirTousLesTerrains() throws SQLException {
        List<Terrain> terrains = new ArrayList<>();
        String query = "SELECT * FROM terrain";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Terrain terrain = mapperTerrain(resultSet);
                terrains.add(terrain);
            }
        }
        return terrains;
    }

    private Terrain mapperTerrain(ResultSet resultSet) throws SQLException {
        Terrain terrain = new Terrain();
        terrain.setId(resultSet.getInt("id"));
        terrain.setNom(resultSet.getString("nom"));
        terrain.setDescription(resultSet.getString("description"));
        terrain.setImageTerrain(resultSet.getString("image_terrain"));
        terrain.setDisponibilite(resultSet.getBoolean("disponibilite"));
        return terrain;
    }
}
