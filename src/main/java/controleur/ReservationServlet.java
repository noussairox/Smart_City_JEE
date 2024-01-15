package controleur;

import java.io.IOException;
import java.sql.Timestamp;

import dao.DaoReservation;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.ReservationTerrain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/Reservation")
public class ReservationServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to the reservation form
        RequestDispatcher dispatcher = request.getRequestDispatcher("reservationForm.jsp");
        
        String idTerrain = request.getParameter("idTerrain");

        request.setAttribute("idTerrain", idTerrain);

        dispatcher.forward(request, response);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Retrieve data from the form
	    int idTerrain = Integer.parseInt(request.getParameter("idTerrain"));
	    String nomTerrain = request.getParameter("nomTerrain");

	    Timestamp dateDebut = null;
	    Timestamp dateFin = null;

	    // Parse dateDebut and dateFin using SimpleDateFormat
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

	    try {
	        Date parsedDateDebut = dateFormat.parse(request.getParameter("dateDebut"));
	        dateDebut = new Timestamp(parsedDateDebut.getTime());

	        Date parsedDateFin = dateFormat.parse(request.getParameter("dateFin"));
	        dateFin = new Timestamp(parsedDateFin.getTime());

	    } catch (ParseException e) {
	        e.printStackTrace();
	        // Handle parsing exception
	        response.sendRedirect("errorReservation.jsp");
	        return;
	    }

	    String nomReservant = request.getParameter("nomReservant");
	    String numeroTel = request.getParameter("numeroTel");

	    // Create ReservationTerrain object
	    ReservationTerrain reservation = new ReservationTerrain(idTerrain, nomTerrain, dateDebut, dateFin, nomReservant, numeroTel);

	    // Save reservation using DAO
	    DaoReservation daoReservation = new DaoReservation();
	    boolean success = daoReservation.addReservation(reservation);

	    if (success) {
	        response.sendRedirect("successReservation.jsp");
	    } else {
	        response.sendRedirect("errorReservation.jsp");
	    }
	}

}
