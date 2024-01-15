package controleur;

import dao.DaoPlaceTouristique;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.PlaceTouristique;
import smartcity.ConnectionSingleton;

import java.io.IOException;
import java.util.List;

@WebServlet("/PlacesTouristiques")
public class PlaceTouristiqueServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoPlaceTouristique daoPlaceTouristique = new DaoPlaceTouristique(ConnectionSingleton.getConnection());
        List<PlaceTouristique> placesTouristiques = daoPlaceTouristique.getAllPlacesTouristiques();
        request.setAttribute("placesTouristiques", placesTouristiques);
        RequestDispatcher dispatcher = request.getRequestDispatcher("displayPlacesTouristiques.jsp");
        dispatcher.forward(request, response);
    }
}