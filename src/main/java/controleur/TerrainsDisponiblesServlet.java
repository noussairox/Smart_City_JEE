package controleur;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Terrain;
import smartcity.ConnectionSingleton;
import dao.TerrainDAO;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/terrains-disponibles")
public class TerrainsDisponiblesServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TerrainDAO terrainDAO = new TerrainDAO(ConnectionSingleton.getConnection());

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Utilisez la classe TerrainDAO pour obtenir la liste des terrains disponibles
        List<Terrain> terrainsDisponibles = null;
        try {
            terrainsDisponibles = terrainDAO.obtenirTousLesTerrains();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Ajoutez la liste des terrains à l'objet de requête pour l'afficher dans la vue
        request.setAttribute("terrainsDisponibles", terrainsDisponibles);

        // Redirigez vers la vue des terrains disponibles
        RequestDispatcher dispatcher = request.getRequestDispatcher("terrainsDisponible.jsp");
        dispatcher.forward(request, response);
    }
}
