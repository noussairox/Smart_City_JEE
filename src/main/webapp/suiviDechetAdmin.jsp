<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/headerAdmin.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="models.CollecteDechets" %>
<%@ page import="dao.CollecteDechetsDao" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.io.IOException" %>
<%@ page import="models.Adresse" %>
<%@ page import="util.NominatimGeoCoder" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Suivi Des Déchets - Admin</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
    <link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css" />
    <style>
        #map {
            height: 300px;
        }
    </style>
</head>
<body class="bg-gray-100 p-8">
    <h1 class="text-4xl font-bold mb-8 text-purple-700 text-center">Suivi Des Déchets - Admin</h1>

    <!-- Tableau pour afficher les champs existants -->
    <table class="border-collapse w-full mb-8">
        <thead>
            <tr class="bg-gray-200">
                <th class="border p-2">ID</th>
                <th class="border p-2">Latitude</th>
                <th class="border p-2">Longitude</th>
                <th class="border p-2">Date et Heure Prévues</th>
                <th class="border p-2">Statut</th>
                <th class="border p-2">Action</th>
            </tr>
        </thead>
        <tbody>
            <% 
                CollecteDechetsDao collecteDechetsDao = new CollecteDechetsDao();
                List<CollecteDechets> collecteDechets = collecteDechetsDao.getAllCollecteDechets();

                for (CollecteDechets collecte : collecteDechets) { 
            %>
                <tr>
                    <td class="border p-2"><%= collecte.getId() %></td>
                    <td class="border p-2"><%= collecte.getLatitude() %></td>
                    <td class="border p-2"><%= collecte.getLongitude() %></td>
                    <td class="border p-2"><%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(collecte.getHeurePrevue()) %></td>
                    <td class="border p-2"><%= collecte.getStatut() %></td>
                    <td class="border p-2">
                        <form action="SuiviDechetAdmin?action=suppression" method="post">
                            <input type="hidden" name="idSuivi" value="<%= collecte.getId() %>">
                            <button type="submit" class="bg-red-500 text-white p-2 rounded-md">Supprimer</button>
                        </form>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>

    <!-- Formulaire pour l'ajout -->
<h2 class="text-2xl font-bold mb-4 text-green-700 text-center ">Ajouter un Suivi</h2>
<form action="SuiviDechetAdmin?action=ajout" method="post" class="max-w-2xl mx-auto bg-white p-8 rounded-md shadow-2xl">
    <div class="mb-4">
        <label for="latitude" class="block text-sm font-medium text-gray-600">Latitude:</label>
        <input type="text" name="latitude" id="latitude" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
    </div>

    <div class="mb-4">
        <label for="longitude" class="block text-sm font-medium text-gray-600">Longitude:</label>
        <input type="text" name="longitude" id="longitude" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
    </div>

    <div class="mb-4">
        <label for="statut" class="block text-sm font-medium text-gray-600">Statut:</label>
    <select id="statut" name="statut" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
                    <option value="Camion1">Camion 1</option>
                    <option value="Camion2">Camion 2</option>
                    <option value="Camion3">Camion 3</option>
                    <option value="Camion4">Camion 4</option>
                    <option value="Camion5">Camion 5</option>
                
                </select>
    </div>

    <div class="mb-4">
        <label for="dateHeurePrevue" class="block text-sm font-medium text-gray-600">Date et Heure Prévues:</label>
        <input type="datetime-local" name="dateHeurePrevue" id="dateHeurePrevue" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
    </div>

    <!-- Carte -->
    <div class="mb-4">
        <label class="block text-sm font-medium text-gray-600 mb-2">Choisir sur la carte:</label>
        <div id="map" class="border p-2 h-64"></div>
    </div>

    <button type="submit" class="bg-purple-500 text-white p-2 rounded-md shadow-2xl w-full">Ajouter</button>
</form>

    <script src="https://unpkg.com/leaflet/dist/leaflet.js"></script>
    <script>
        var map = L.map('map').setView([51.505, -0.09], 13);

        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: '© OpenStreetMap contributors'
        }).addTo(map);

        var marker;

        map.on('click', function (e) {
            if (marker) {
                map.removeLayer(marker);
            }
            marker = L.marker(e.latlng).addTo(map);
            document.getElementById('latitude').value = e.latlng.lat;
            document.getElementById('longitude').value = e.latlng.lng;
        });
    </script>
</body>
</html>
<%@ include file="/WEB-INF/footerAdmin.jsp" %>
