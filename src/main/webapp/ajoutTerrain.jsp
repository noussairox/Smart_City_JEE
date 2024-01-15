<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/headerAdmin.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajout de Terrain</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="font-sans bg-gray-100">

    <div class="container mx-auto p-4">
        <h1 class="text-4xl font-bold mb-8 text-purple-700 text-center">Ajout de Terrain</h1>
        <form action="ajout-terrain" method="post" enctype="multipart/form-data" class="max-w-md mx-auto bg-white p-6 rounded-md shadow-md">

            <div class="mb-4">
                <label for="nom" class="block text-sm font-medium text-gray-600">Nom du terrain:</label>
                <select id="nom" name="nom" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
                    <option value="Terrain Mabrouka">Terrain Mabrouka</option>
                    <option value="Terrain Marrakech">Terrain Marrakech</option>
                    <!-- Ajoutez d'autres options selon vos besoins -->
                    <option value="Terrain Casablanca">Terrain Casablanca</option>
                    <option value="Terrain Fes">Terrain Fes</option>
                    <option value="Terrain Agadir">Terrain Agadir</option>
                    <option value="Terrain Tanger">Terrain Tanger</option>
                    <option value="Terrain Rabat">Terrain Rabat</option>
                    <option value="Terrain Ouarzazat">Terrain Ouarzazat</option>
                    <!-- Ajoutez d'autres options selon vos besoins -->
                </select>
            </div>

            <div class="mb-4">
                <label for="description" class="block text-sm font-medium text-gray-600">Description:</label>
                <textarea id="description" name="description" required class="mt-1 p-2 border border-gray-300 rounded-md w-full"></textarea>
            </div>

            <div class="mb-4">
                <label for="imageTerrain" class="block text-sm font-medium text-gray-600">Image du terrain:</label>
                <input type="file" id="imageTerrain" name="imageTerrain" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
            </div>

            <div class="mb-4">
                <label for="disponibilite" class="flex items-center">
                    <input type="checkbox" id="disponibilite" name="disponibilite" class="form-checkbox">
                    <span class="ml-2 text-sm">Disponibilité</span>
                </label>
            </div>

            <div class="flex items-center justify-center mt-6">
                <button type="submit" class="bg-purple-500 text-white p-2 rounded-md shadow-2xl w-1/3">Ajouter</button>
            </div>

        </form>
    </div>

</body><br><br>
</html>
<%@ include file="/WEB-INF/footerAdmin.jsp" %>
