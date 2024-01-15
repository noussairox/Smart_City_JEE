<%@ page import="java.util.List" %>
<%@ page import="models.PlaceTouristique" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/header.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Places Touristiques</title>
    <!-- Inclure le lien vers le fichier Tailwind CSS -->
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="font-sans bg-gray-100 text-center">

    <div class="container mx-auto p-4 grid gap-4 grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4">
        <h1 class="text-4xl font-mono text-purple-600 mb-8 col-span-full text-center border-b-8 border-blue py-6">Liste des Places Touristiques</h1>

        <%-- Remplacez cette partie par votre code Java pour récupérer la liste des places touristiques --%>
        <%-- Assumez que vous avez une liste appelée "placesTouristiques" dans la requête --%>
        <%
            List<PlaceTouristique> placesTouristiques = (List<PlaceTouristique>) request.getAttribute("placesTouristiques");
            if (placesTouristiques != null && !placesTouristiques.isEmpty()) {
                for (PlaceTouristique placeTouristique : placesTouristiques) {
        %>
                    <div class="bg-white rounded-lg overflow-hidden shadow-lg mb-4">
                        <img src="<%= request.getContextPath() + placeTouristique.getImage() %>"
                             class="w-full h-40 object-cover object-center">
                        <div class="p-4">
                            <h2 class="text-xl font-bold mb-2"><%= placeTouristique.getNom() %></h2>
                            <p class="text-gray-700 mb-2"><strong>Ville:</strong> <%= placeTouristique.getVille() %></p>
                            <p class="text-gray-800"><%= placeTouristique.getDescription() %></p>
                        </div>
                    </div>
        <%
                }
            } else {
        %>
                <p class="text-gray-700 col-span-full">Aucune place touristique trouvée.</p>
        <%
            }
        %>
    </div>

</body>
</html>
<%@ include file="/WEB-INF/footer.jsp" %>
