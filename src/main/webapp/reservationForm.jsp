<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/header.jsp" %>

<!DOCTYPE html>
<html class="h-full">
<head>
    <title>Reservation Form</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="flex flex-col h-full justify-between bg-gray-100">
    <div class="container mx-auto mt-8">
        <h1 class="text-4xl font-bold mb-4 text-purple-700 text-center">Reservation Form</h1>
        <form action="Reservation" method="post" class="max-w-md mx-auto bg-white p-6 rounded-md shadow-md">
            <!-- Input fields for reservation details -->
            <div class="mb-4">
                <label for="idTerrain" class="block text-sm font-medium text-gray-600">Terrain ID:</label>
                <input type="text" id="idTerrain" name="idTerrain" value="<%= request.getAttribute("idTerrain") %>" required
                 class="mt-1 p-2 border border-gray-300 rounded-md w-full">
            </div>

            <div class="mb-4">
                <label for="nomTerrain" class="block text-sm font-medium text-gray-600">Terrain Name:</label>
                <select id="nomTerrain" name="nomTerrain" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
                    <option value="Terrain Mabrouka">Terrain Mabrouka</option>
                    <option value="Terrain Moulay Abdellah">Terrain Moulay Abdellah</option>
                    <option value="Grand Terrain Casablanca">Grand Terrain Casablanca</option>
                    <option value="Terrain Olympique Asfi">Terrain Olympique Asfi</option>
                    <!-- Ajoutez d'autres options selon vos besoins -->
                </select>
            </div>

            <div class="mb-4">
                <label for="dateDebut" class="block text-sm font-medium text-gray-600">Start Date:</label>
                <input type="datetime-local" id="dateDebut" name="dateDebut" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
            </div>

            <div class="mb-4">
                <label for="dateFin" class="block text-sm font-medium text-gray-600">End Date:</label>
                <input type="datetime-local" id="dateFin" name="dateFin" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
            </div>

            <div class="mb-4">
                <label for="nomReservant" class="block text-sm font-medium text-gray-600">Reservant Name:</label>
                <input type="text" id="nomReservant" name="nomReservant" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
            </div>

            <div class="mb-4">
                <label for="numeroTel" class="block text-sm font-medium text-gray-600">Phone Number:</label>
                <input type="text" id="numeroTel" name="numeroTel" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
            </div>

            <!-- Ajoutez d'autres champs selon vos besoins -->

            <!-- Submit button -->
            <div class="flex justify-center text-center space-x-4 mt-4">
                <button type="submit" class="bg-purple-500 text-white p-2 rounded-md shadow-2xl w-1/3">Réserver</button>
                <a href="./" class="text-white bg-red-500 hover:bg-red-600 px-4 py-2 rounded-md transition-colors w-1/3 ">Annuler</a>
            </div>
        </form>
    </div>
</body>
</html>
<%@ include file="/WEB-INF/footer.jsp" %>
