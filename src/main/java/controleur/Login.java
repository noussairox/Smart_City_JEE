package controleur;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import smartcity.ConnectionSingleton;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("auth.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("login");
        String password = request.getParameter("pwd");

        Connection connection = ConnectionSingleton.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = "SELECT * FROM users WHERE login=? AND password=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Utilisateur authentifié, enregistrez les informations de l'utilisateur dans la session
                HttpSession session = request.getSession();
                session.setAttribute("username", username);

                // Rediriger vers la page de succès
                response.sendRedirect("success.jsp");
            } else {
                // Authentification échouée, définissez un attribut d'erreur
                request.setAttribute("error", "Identifiants incorrects");
                // Rediriger vers la page d'authentification avec un message d'erreur
                RequestDispatcher dispatcher = request.getRequestDispatcher("auth.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
