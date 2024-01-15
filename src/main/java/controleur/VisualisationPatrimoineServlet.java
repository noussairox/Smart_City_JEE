package controleur;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Patrimoine;
import dao.PatrimoineDAO;
import smartcity.ConnectionSingleton;

@WebServlet("/visualisation-patrimoine")
public class VisualisationPatrimoineServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PatrimoineDAO patrimoineDAO = new PatrimoineDAO(ConnectionSingleton.getConnection());

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récupérer tous les patrimoines
        try {
            List<Patrimoine> patrimoines = patrimoineDAO.getAllPatrimoines();

            // Mettre les patrimoines dans les attributs de la requête
            request.setAttribute("patrimoines", patrimoines);

            // Dispatch vers la page de visualisation des patrimoines
            RequestDispatcher dispatcher = request.getRequestDispatcher("visualisationPatrimoine.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'erreur selon vos besoins
        }
    }
}
