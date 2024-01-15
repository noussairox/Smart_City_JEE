package controleur;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.CollecteDechets;
import dao.CollecteDechetsDao;

@WebServlet("/SuiviDechetAdmin")
public class SuiviDechetAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to the admin suivi page
        RequestDispatcher dispatcher = request.getRequestDispatcher("suiviDechetAdmin.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("ajout".equals(action)) {
            // Récupérez les données du formulaire d'ajout
            String latitude = request.getParameter("latitude");
            String longitude = request.getParameter("longitude");
            String statut = request.getParameter("statut");

            // Convertissez la date et l'heure prévues depuis la chaîne en objet Timestamp
            String dateHeurePrevueStr = request.getParameter("dateHeurePrevue");
            Timestamp dateHeurePrevue = null;

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                java.util.Date parsedDate = dateFormat.parse(dateHeurePrevueStr);
                dateHeurePrevue = new Timestamp(parsedDate.getTime());
            } catch (ParseException e) {
                e.printStackTrace(); // Gérer l'exception selon vos besoins
            }

            // Créez un objet CollecteDechets avec les données
            CollecteDechets collecte = new CollecteDechets(latitude, longitude, dateHeurePrevue, statut);

            // Ajoutez la nouvelle collecte en base de données
            CollecteDechetsDao collecteDechetsDao = new CollecteDechetsDao();
            collecteDechetsDao.addCollecteDechets(collecte);
        } else if ("suppression".equals(action)) {
            // Récupérez l'ID du suivi à supprimer depuis le formulaire
            int idSuivi = Integer.parseInt(request.getParameter("idSuivi"));

            // Supprimez le suivi de la base de données
            CollecteDechetsDao collecteDechetsDao = new CollecteDechetsDao();
            collecteDechetsDao.deleteCollecteDechets(idSuivi);
        }

        // Redirigez vers la page de suivi après l'ajout ou la suppression
        response.sendRedirect("SuiviDechetAdmin");
    }

}
