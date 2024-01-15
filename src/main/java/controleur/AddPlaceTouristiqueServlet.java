package controleur;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import dao.DaoPlaceTouristique;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import models.PlaceTouristique;
import smartcity.ConnectionSingleton;

@WebServlet("/AddPlaceTouristique")
@MultipartConfig
public class AddPlaceTouristiqueServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DaoPlaceTouristique daoPlaceTouristique = new DaoPlaceTouristique(ConnectionSingleton.getConnection());
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addPlaceTouristique.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les données du formulaire
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        String ville = request.getParameter("ville");

        // Gestion de la photo
        Part filePart = request.getPart("image");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        // Utiliser le chemin absolu du répertoire "uploads" dans le répertoire de l'application
        String uploadsPath = request.getServletContext().getRealPath("/uploads");
        Path uploadsDirectory = Paths.get(uploadsPath);

        if (!Files.exists(uploadsDirectory)) {
            Files.createDirectories(uploadsDirectory);
        }

        // Sauvegarde de la photo dans le dossier "uploads"
        Path filePath = uploadsDirectory.resolve(fileName);
        try (InputStream fileContent = filePart.getInputStream()) {
            Files.copy(fileContent, filePath, StandardCopyOption.REPLACE_EXISTING);
        }
        String imagePlacePath = "/uploads/" + fileName;

        PlaceTouristique placeTouristique = new PlaceTouristique();
        placeTouristique.setNom(nom);
        placeTouristique.setDescription(description);
        placeTouristique.setVille(ville);
        placeTouristique.setImage(imagePlacePath);

        boolean success = daoPlaceTouristique.addPlaceTouristique(placeTouristique);

        if (success) {
            response.sendRedirect("successAddPlaceTouristique.jsp");
        } else {
            response.sendRedirect("errorAddPlaceTouristique.jsp");
        }
    }
}