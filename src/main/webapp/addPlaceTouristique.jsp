<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/headerAdmin.jsp" %>

<!DOCTYPE html>
<html class="h-full">
<head>
    <title>Ajouter une Place Touristique</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="flex flex-col h-full justify-between bg-gray-100">
	
    <div class="container mx-auto mt-8">
        <h1 class="text-4xl font-bold mb-4 text-purple-700 text-center">Ajouter une Place Touristique</h1>
        <form action="AddPlaceTouristique" method="post" enctype="multipart/form-data" class="max-w-md mx-auto bg-white p-6 rounded-md shadow-md">

            <div class="mb-4">
                <label for="nom" class="block text-sm font-medium text-gray-600">Nom:</label>
                <input type="text" id="nom" name="nom" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
            </div>

            <div class="mb-4">
                <label for="description" class="block text-sm font-medium text-gray-600">Description:</label>
                <textarea id="description" name="description" required class="mt-1 p-2 border border-gray-300 rounded-md w-full"></textarea>
            </div>

            <div class="mb-4">
                <label for="ville" class="block text-sm font-medium text-gray-600">Ville:</label>
                <select id="ville" name="ville" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
                    <option value="Marrakech">Marrakech</option>
                    <option value="Essaouira">Essaouira</option>
                    <option value="Casablanca">Casablanca</option>
                    <option value="Fes">Fes</option>
                    <option value="Rabat">Rabat</option>
                    <option value="Agadir">Agadir</option>
                    <option value="Tanger">Tanger</option>
                    <option value="Chefchaouen">Chefchaouen</option>
                    <option value="Ouarzazate">Ouarzazate</option>
                    <!-- Ajoutez d'autres options selon vos besoins -->
                </select>
            </div>

            <div class="mb-4">
                <label for="image" class="block text-sm font-medium text-gray-600">Image:</label>
                <input type="file" id="image" name="image" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
            </div>

            <div class="flex items-center justify-center mt-6">
                <button type="submit" class="bg-purple-500 text-white p-2 rounded-md shadow-2xl w-1/3">Ajouter</button>
            </div>

        </form>
    </div>
    <br> <br>
</body>
</html>
<%@ include file="/WEB-INF/footerAdmin.jsp" %>
