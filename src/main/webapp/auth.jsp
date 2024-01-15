<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/header.jsp" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <!-- Mettez ici vos balises meta, liens vers des feuilles de style, etc. -->
</head>
<body class="flex h-screen bg-gradient-to-r from-green-500 via-green-500 to-purple-500">
<br>
<div class="w-full h-full bg-gradient-to-r from-green-500 via-green-500 to-purple-500 flex flex-col justify-center items-center text-white rounded-2xl">
   <br><br><br>
    <h3 class="text-center mt-4 text-3xl mb-8">Bienvenue Administrateur</h3>

    <div class="flex items-center justify-center">
        <div class="w-full h-1/2 bg-green-500"></div>
        <div class="w-full h-full bg-purple-500">
        </div>
        
    </div>
    <% if (request.getAttribute("error") != null) { %>
                <div style="color: red;"><%= request.getAttribute("error") %></div>
            <% } %>

            <form action="Login" method="post" class="bg-white p-8 rounded-lg shadow-lg">
                <!-- Vos champs de formulaire pour le login et le mot de passe -->
                <div class="mb-4">
                    <input type="text" name="login" placeholder="Nom d'utilisateur" required
                           class="w-full p-2 border-b-2 border-purple-500 focus:outline-none focus:border-purple-700 text-black">
                </div>
                <div class="mb-6">
                    <input type="password" name="pwd" placeholder="Mot de passe" required
                           class="w-full p-2 border-b-2 border-purple-500 focus:outline-none focus:border-purple-700 text-black">
                </div>
                <button type="submit"
                        class="bg-purple-500 text-white py-2 px-4 rounded-full hover:bg-purple-700 transition duration-300 ease-in-out">
                    Se connecter
                </button>
            </form>
            <br> <br><br>
</div>
<br><br><br>
</body>
</html>
<%@ include file="/WEB-INF/footer.jsp" %>
