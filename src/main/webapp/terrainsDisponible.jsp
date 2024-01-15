<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.Terrain" %>
<%@ include file="/WEB-INF/header.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Terrains Disponibles</title>
    <!-- Inclure le lien vers le fichier Tailwind CSS -->
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="font-sans bg-gray-100">

    <div class="container mx-auto p-4">
        <h1 class="text-4xl font-bold mb-8">Terrains Disponibles</h1>

        <% List<Terrain> terrainsDisponibles = (List<Terrain>) request.getAttribute("terrainsDisponibles"); %>
        <% if (terrainsDisponibles != null && !terrainsDisponibles.isEmpty()) { %>
            <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4 justify-center items-center">
                <% for (Terrain terrain : terrainsDisponibles) { %>
                    <div class="bg-white rounded-lg overflow-hidden shadow-lg mb-4">
                        <img src="<%= request.getContextPath() + terrain.getImageTerrain() %>"
                             alt="Image du terrain"
                             class="w-full h-40 object-cover object-center">
                        <div class="p-4">
                            <h2 class="text-lg font-bold mb-2"><%= terrain.getNom() %></h2>
                            <p class="text-gray-700 mb-2"><strong>Description:</strong> <%= terrain.getDescription() %></p>
                            <p class="text-gray-700 mb-2"><strong>Disponibilité:</strong> <%= terrain.isDisponibilite() ? "Disponible" : "Indisponible" %></p>
                            <!-- Ajoutez d'autres champs du terrain selon vos besoins -->

                            <!-- Bouton de réservation -->
                            <a href="Reservation?idTerrain=<%= terrain.getId() %>"
                               class="bg-purple-500 text-white p-2 rounded-md shadow-2xl inline-block">Réserver</a></div>
                    </div>
                <% } %>
            </div>
        <% } else { %>
            <p class="text-gray-700">Aucun terrain disponible pour le moment.</p>
        <% } %>
    </div>

</body>
</html>
<%@ include file="/WEB-INF/footer.jsp" %>

