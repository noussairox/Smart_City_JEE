package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Patrimoine;

public class PatrimoineDAO {
    private Connection connection;

    public PatrimoineDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Patrimoine> getAllPatrimoines() throws SQLException {
        List<Patrimoine> patrimoines = new ArrayList<>();

        String query = "SELECT * FROM patrimoine";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Patrimoine patrimoine = new Patrimoine();
                patrimoine.setId(resultSet.getInt("id"));
                patrimoine.setNomPatrimoine(resultSet.getString("nom_patrimoine"));
                patrimoine.setDescription(resultSet.getString("description"));
                patrimoine.setImagePatrimoine(resultSet.getString("image_patrimoine"));
                patrimoine.setPrixEstime(resultSet.getString("prix_estime"));

                patrimoines.add(patrimoine);
            }
        }

        return patrimoines;
    }

    public void addPatrimoine(Patrimoine patrimoine) throws SQLException {
        String query = "INSERT INTO patrimoine (nom_patrimoine, description, image_patrimoine, prix_estime) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, patrimoine.getNomPatrimoine());
            preparedStatement.setString(2, patrimoine.getDescription());
            preparedStatement.setString(3, patrimoine.getImagePatrimoine());
            preparedStatement.setString(4, patrimoine.getPrixEstime());

            preparedStatement.executeUpdate();
        }
    }
}
