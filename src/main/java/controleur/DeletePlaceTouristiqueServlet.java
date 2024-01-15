package controleur;

import java.io.IOException;

import dao.DaoPlaceTouristique;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import smartcity.ConnectionSingleton;

@WebServlet("/DeletePlaceTouristique")
public class DeletePlaceTouristiqueServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DaoPlaceTouristique daoPlaceTouristique = new DaoPlaceTouristique(ConnectionSingleton.getConnection());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int placeId = Integer.parseInt(request.getParameter("placeId"));
        boolean success = daoPlaceTouristique.deletePlaceTouristique(placeId);

        if (success) {
            response.sendRedirect("successDeletePlaceTouristique.jsp");
        } else {
            response.sendRedirect("errorDeletePlaceTouristique.jsp");
        }
    }
}
