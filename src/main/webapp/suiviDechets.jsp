<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.CollecteDechets" %>
<%@ page import="dao.CollecteDechetsDao" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Suivi des Déchets</title>
</head>
<body>
    <h2>Suivi des Déchets</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Latitude</th>
                <th>Longitude</th>
                <th>Date et Heure Prévues</th>
                <th>Statut</th>
                <th>Amenity</th>
                <th>Road</th>
                <th>Suburb</th>
                <th>City</th>
                <!-- Ajoutez d'autres colonnes si nécessaire -->
            </tr>
        </thead>
        <tbody>
            <% 
                List<CollecteDechets> collecteDechets = new CollecteDechetsDao().getAllCollecteDechets();
                for (CollecteDechets collecte : collecteDechets) { 
            %>
                <tr>
                    <td><%= collecte.getId() %></td>
                    <td><%= collecte.getLatitude() %></td>
                    <td><%= collecte.getLongitude() %></td>
                    <td><%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(collecte.getHeurePrevue()) %></td>
                    <td><%= collecte.getStatut() %></td>
                    <td><%= collecte.getAdresse().getAmenity() %></td>
                    <td><%= collecte.getAdresse().getRoad() %></td>
                    <td><%= collecte.getAdresse().getSuburb() %></td>
                    <td><%= collecte.getAdresse().getCity() %></td>
                    
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
