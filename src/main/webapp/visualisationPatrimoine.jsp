<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Patrimoine" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Visualisation des Patrimoines</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="bg-gray-100 p-8">

    <h1 class="text-4xl font-bold mb-8 text-purple-700 text-center">Visualisation des Patrimoines</h1>

    <div class="grid grid-cols-2 gap-8">
        <% for (Patrimoine patrimoine : (List<Patrimoine>) request.getAttribute("patrimoines")) { %>
            <div class="bg-white p-4 rounded-lg shadow-md h-full flex flex-col">
                <h2 class="text-2xl font-mono text-purple-700 mb-4"><%= patrimoine.getNomPatrimoine() %></h2>
                <img src="<%= request.getContextPath() + patrimoine.getImagePatrimoine() %>" alt="Image du Patrimoine" class="w-full h-auto mb-4 rounded-md">
                <div class="flex flex-col">
                    <p class="text-gray-700 mb-2"><%= patrimoine.getDescription() %></p>
                    <p class="text-purple-700 font-bold text-lg"><%= patrimoine.getPrixEstime() %></p>
                </div>
            </div>
        <% } %>
    </div>

</body>
</html>
<%@ include file="/WEB-INF/footer.jsp" %>
