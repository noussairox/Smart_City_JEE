<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.CollecteDechets" %>
<%@ page import="dao.CollecteDechetsDao" %>
<%@ include file="/WEB-INF/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Suivi des Déchets</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="bg-gray-100 p-8">
    <h2 class="text-4xl font-bold mb-8 text-purple-700">Suivi des Déchets</h2>
    <table class="w-full border-collapse border border-gray-300">
        <thead>
            <tr class="bg-gray-200">
                <th class="p-2">ID</th>
                <th class="p-2">Latitude</th>
                <th class="p-2">Longitude</th>
                <th class="p-2">Date et Heure Prévues</th>
                <th class="p-2">Statut</th>
                <th class="p-2">Amenity</th>
                <th class="p-2">Road</th>
                <th class="p-2">Suburb</th>
                <th class="p-2">City</th>
                <!-- Ajoutez d'autres colonnes si nécessaire -->
            </tr>
        </thead>
        <tbody>
            <% 
                List<CollecteDechets> collecteDechets = new CollecteDechetsDao().getAllCollecteDechets();
                for (CollecteDechets collecte : collecteDechets) { 
            %>
                <tr class="border-t border-gray-300">
                    <td class="p-2"><%= collecte.getId() %></td>
                    <td class="p-2"><%= collecte.getLatitude() %></td>
                    <td class="p-2"><%= collecte.getLongitude() %></td>
                    <td class="p-2"><%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(collecte.getHeurePrevue()) %></td>
                    <td class="p-2"><%= collecte.getStatut() %></td>
                    <td class="p-2"><%= collecte.getAdresse().getAmenity() %></td>
                    <td class="p-2"><%= collecte.getAdresse().getRoad() %></td>
                    <td class="p-2"><%= collecte.getAdresse().getSuburb() %></td>
                    <td class="p-2"><%= collecte.getAdresse().getCity() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
    <div class="mt-8 flex items-center">
    <div class="w-1/2 flex-shrink-0">
        <img src="https://media.istockphoto.com/id/1029284106/vector/funny-garbage-truck-car-with-eyes-municipal-machinery.jpg?s=612x612&w=0&k=20&c=8JCcJqftesYB5DdkMArLnpMlVCPps3cvCfMlvwm5eLI=" class="rounded-2xl shadow-lg object-cover h-1/2">
    </div>
    <div class="w-1/2 ml-8 flex-1">
        <h3 class="text-2xl font-bold mb-4 text-purple-700 font-mono">À propos du Suivi des Déchets</h3>
        <p class="text-gray-700">
            Le suivi des déchets fournit des informations essentielles sur la collecte des déchets, y compris les détails sur la localisation,
            la date et l'heure prévues, le statut et d'autres informations pertinentes. Explorez les données pour une gestion efficace des déchets
            dans votre ville.
        </p>
    </div>
</div>

</body>
</html>
<%@ include file="/WEB-INF/footer.jsp" %>
