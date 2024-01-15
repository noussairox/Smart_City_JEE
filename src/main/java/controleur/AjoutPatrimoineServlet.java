package controleur;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.net.URLEncoder;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import models.Patrimoine;
import smartcity.ConnectionSingleton;
import dao.PatrimoineDAO;

import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/ajout-patrimoine")
@MultipartConfig
public class AjoutPatrimoineServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PatrimoineDAO patrimoineDAO = new PatrimoineDAO(ConnectionSingleton.getConnection());

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ajoutPatrimoine.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les données du formulaire
        String nomPatrimoine = request.getParameter("nomPatrimoine");
        String description = request.getParameter("description");
        String prixEstime = request.getParameter("prixEstime");

        // Gestion de l'image
        Part filePart = request.getPart("imagePatrimoine");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String encodedFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8);
        InputStream fileContent = filePart.getInputStream();

        // Utiliser le chemin absolu du répertoire "uploads" dans le répertoire de l'application
        String uploadsPath = request.getServletContext().getRealPath("/uploads");
        Path uploadsDirectory = Paths.get(uploadsPath);

        if (!Files.exists(uploadsDirectory)) {
            Files.createDirectories(uploadsDirectory);
        }

        // Sauvegarde de l'image dans le dossier "uploads"
        Path filePath = uploadsDirectory.resolve(encodedFileName);
        Files.copy(fileContent, filePath, StandardCopyOption.REPLACE_EXISTING);
        String imagePatrimoinePath = "/uploads/" + encodedFileName;

        System.out.println("La path de l'image : " + imagePatrimoinePath);

        // Créer un objet Patrimoine avec les données
        Patrimoine patrimoine = new Patrimoine(nomPatrimoine, description, imagePatrimoinePath, prixEstime);

        // Ajouter le patrimoine à la base de données
        try {
            patrimoineDAO.addPatrimoine(patrimoine);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Rediriger vers la page de visualisation du patrimoine
        response.sendRedirect("visualisation-patrimoine");
    }
}
