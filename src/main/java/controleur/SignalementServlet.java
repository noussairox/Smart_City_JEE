package controleur;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import dao.DaoSignalement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import models.Signalement;

@WebServlet("/Signalement")
@MultipartConfig
public class SignalementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        double latitude = Double.parseDouble(request.getParameter("latitude"));
        double longitude = Double.parseDouble(request.getParameter("longitude"));
        String localisation = request.getParameter("localisation");
        String typeReclamation = request.getParameter("typeReclamation");
        
        // Gestion de la photo
        Part filePart = request.getPart("photo");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = filePart.getInputStream();
        
        // Création du dossier "uploads" s'il n'existe pas
        Path uploadsDirectory = Paths.get(getServletContext().getRealPath("/uploads"));
        if (!Files.exists(uploadsDirectory)) {
            Files.createDirectories(uploadsDirectory);
        }

        // Sauvegarde de la photo dans le dossier "uploads"
        Path filePath = uploadsDirectory.resolve(fileName);
        Files.copy(fileContent, filePath, StandardCopyOption.REPLACE_EXISTING);
        String photoPath = "/uploads/" + fileName;

        Signalement signalement = new Signalement();
        signalement.setDescription(description);
        signalement.setLatitude(latitude);
        signalement.setLongitude(longitude);
        signalement.setLocalisation(localisation);
        signalement.setTypeReclamation(typeReclamation);
        signalement.setPhotoPath(photoPath);

        DaoSignalement daoSignalement = new DaoSignalement();
        boolean success = daoSignalement.ajouterSignalement(signalement);

        if (success) {
            response.sendRedirect("successSignalement.jsp");
        } else {
            response.sendRedirect("errorSignalement.jsp");
        }
    }
}
