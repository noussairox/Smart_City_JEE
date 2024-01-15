package controleur;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.net.URLEncoder;

import jakarta.annotation.security.RolesAllowed;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import models.Terrain;
import smartcity.ConnectionSingleton;
import dao.TerrainDAO;

import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/ajout-terrain")
@MultipartConfig
public class AjoutTerrainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TerrainDAO terrainDAO = new TerrainDAO(ConnectionSingleton.getConnection());

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ajoutTerrain.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les données du formulaire
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");

        // Gestion de la photo
        Part filePart = request.getPart("imageTerrain");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String encodedFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8);
        InputStream fileContent = filePart.getInputStream();

        // Utiliser le chemin absolu du répertoire "uploads" dans le répertoire de l'application
        String uploadsPath = request.getServletContext().getRealPath("/uploads");
        Path uploadsDirectory = Paths.get(uploadsPath);

        if (!Files.exists(uploadsDirectory)) {
            Files.createDirectories(uploadsDirectory);
        }

        // Sauvegarde de la photo dans le dossier "uploads"
        Path filePath = uploadsDirectory.resolve(encodedFileName);
        Files.copy(fileContent, filePath, StandardCopyOption.REPLACE_EXISTING);
        String imageTerrainPath = "/uploads/" + encodedFileName;

        System.out.println("la path de l'image : " + imageTerrainPath);

        boolean disponibilite = Boolean.parseBoolean(request.getParameter("disponibilite"));

        // Créer un objet Terrain avec les données
        Terrain terrain = new Terrain();
        terrain.setNom(nom);
        terrain.setDescription(description);
        terrain.setImageTerrain(imageTerrainPath);
        terrain.setDisponibilite(disponibilite);

        // Ajouter le terrain à la base de données
        try {
            terrainDAO.ajouterTerrain(terrain);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Rediriger vers la page de visualisation du terrain
        response.sendRedirect("visualisation-terrain?id=" + terrain.getId());
    }
}
