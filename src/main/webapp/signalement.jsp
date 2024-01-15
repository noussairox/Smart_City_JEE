<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire de Réclamation</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
    <link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css" />
    <style>
        #map {
            height: 300px;
        }
    </style>
</head>

<body class="bg-gray-100 p-8">
    <h2 class="text-4xl font-bold mb-8 text-purple-700 text-center">Formulaire de Réclamation</h2>
    <form method="POST" action="Signalement" enctype="multipart/form-data" class="max-w-2xl mx-auto bg-white p-8 rounded-md shadow-2xl">
        <div class="mb-4">
            <label for="description" class="block text-sm font-medium text-gray-600">Description:</label>
            <textarea name="description" rows="4" cols="50" required class="mt-1 p-2 border border-gray-300 rounded-md w-full"></textarea>
        </div>

        <div class="grid grid-cols-2 gap-4">
            <div class="mb-4">
                <label for="latitude" class="block text-sm font-medium text-gray-600">Latitude:</label>
                <input type="text" name="latitude" id="latitude" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
            </div>

            <div class="mb-4">
                <label for="longitude" class="block text-sm font-medium text-gray-600">Longitude:</label>
                <input type="text" name="longitude" id="longitude" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
            </div>
        </div>

        <div class="mb-4">
            <label for="localisation" class="block text-sm font-medium text-gray-600">Localisation:</label>
            <input type="text" name="localisation" id="localisation" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
        </div>

        <div class="mb-4">
            <label for="typeReclamation" class="block text-sm font-medium text-gray-600">Type de Réclamation:</label>
            <select name="typeReclamation" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
                <option value="probleme_routier">Problème Routier</option>
                <option value="dechet_abandonne">Déchet Abandonné</option>
                <!-- Ajoutez d'autres types de réclamation au besoin -->
            </select>
        </div>

        <div class="mb-4">
            <label for="photo" class="block text-sm font-medium text-gray-600">Photo:</label>
            <input type="file" name="photo" accept="image/*" required class="mt-1 p-2 border border-gray-300 rounded-md w-full">
        </div>

        <!-- Carte -->
        <div class="mb-4">
            <label class="block text-sm font-medium text-gray-600">Choisir sur la carte:</label>
            <div id="map"></div>
        </div>

        <button type="submit" class="bg-purple-500 text-white p-2 rounded-md shadow-2xl w-full">Soumettre Réclamation</button>
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
            // Mettez à jour les champs de latitude, longitude et localisation dans le formulaire
            document.getElementById('latitude').value = e.latlng.lat;
            document.getElementById('longitude').value = e.latlng.lng;
            document.getElementById('localisation').value = e.latlng.lat + ', ' + e.latlng.lng;
        });
    </script>
</body>
</html>
<%@ include file="/WEB-INF/footer.jsp" %>
