package controleur;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.CollecteDechets;
import dao.CollecteDechetsDao;
import util.NominatimGeoCoder;
import models.Adresse; // Ajoutez cet import

@WebServlet("/SuiviDechets")
public class SuiviDechetsServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CollecteDechetsDao collecteDechetsDao = new CollecteDechetsDao();
        List<CollecteDechets> collecteDechets = collecteDechetsDao.getAllCollecteDechets();

        for (CollecteDechets collecte : collecteDechets) {
            String latitude = collecte.getLatitude();
            String longitude = collecte.getLongitude();

            try {
                Adresse adresse = NominatimGeoCoder.getFullAddress(latitude, longitude);
                collecte.setAdresse(adresse);
            } catch (IOException e) {
                e.printStackTrace();
                // Gérer l'erreur, par exemple, en ajoutant un message d'erreur à la requête
                request.setAttribute("error", "Erreur lors de la récupération de l'adresse.");
            }
        }

        request.setAttribute("collecteDechets", collecteDechets);
        request.getRequestDispatcher("suiviDechets.jsp").forward(request, response);
    }
}
