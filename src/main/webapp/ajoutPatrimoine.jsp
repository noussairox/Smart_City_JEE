<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/headerAdmin.jsp" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Ajout de Patrimoine</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="bg-gray-100 p-8 ">
    <h1 class="text-4xl font-bold mb-8 text-purple-700 text-center">Ajout de Patrimoine</h1>

    <!-- Formulaire pour l'ajout de patrimoine -->
    <form action="ajout-patrimoine" method="post" enctype="multipart/form-data" class="max-w-2xl mx-auto bg-white p-8 rounded-md shadow-2xl">
        <div class="mb-4">
            <label for="nomPatrimoine" class="block text-sm font-medium text-gray-600">Nom du Patrimoine:</label>
            <input type="text" name="nomPatrimoine" id="nomPatrimoine" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
        </div>

        <div class="mb-4">
            <label for="description" class="block text-sm font-medium text-gray-600">Description:</label>
            <textarea name="description" id="description" required class="mt-1 p-2 border border-gray-300 rounded-md w-full"></textarea>
        </div>

        <div class="mb-4">
            <label for="prixEstime" class="block text-sm font-medium text-gray-600">Prix Estimé:</label>
            <input type="text" name="prixEstime" id="prixEstime" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
        </div>

        <div class="mb-4">
            <label for="imagePatrimoine" class="block text-sm font-medium text-gray-600">Image du Patrimoine:</label>
            <input type="file" name="imagePatrimoine" id="imagePatrimoine" accept="image/*" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
        </div>

        <button type="submit" class="bg-purple-500 text-white p-2 rounded-md shadow-2xl w-full">Ajouter</button>
    </form>
    <br>

</body>
</html>
<%@ include file="/WEB-INF/footerAdmin.jsp" %>
