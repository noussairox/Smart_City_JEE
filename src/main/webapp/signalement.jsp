<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire de Réclamation</title>
    <link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css" />
</head>
<body>
    <h2>Formulaire de Réclamation</h2>
    <form method="POST" action="Signalement" enctype="multipart/form-data">
        <table>
            <tr>
                <td>Description</td>
                <td><textarea name="description" rows="4" cols="50" required></textarea></td>
            </tr>
            <tr>
                <td>Latitude</td>
                <td><input type="text" name="latitude" id="latitude" required></td>
            </tr>
            <tr>
                <td>Longitude</td>
                <td><input type="text" name="longitude" id="longitude" required></td>
            </tr>
            <tr>
                <td>Localisation</td>
                <td><input type="text" name="localisation" id="localisation" required></td>
            </tr>
            <tr>
                <td>Type de Réclamation</td>
                <td>
                    <select name="typeReclamation" required>
                        <option value="probleme_routier">Problème Routier</option>
                        <option value="dechet_abandonne">Déchet Abandonné</option>
                        <!-- Ajoutez d'autres types de réclamation au besoin -->
                    </select>
                </td>
            </tr>
            <tr>
                <td>Photo</td>
                <td><input type="file" name="photo" accept="image/*" required></td>
            </tr>
            <!-- Ajoutez un conteneur pour la carte -->
            <tr>
                <td>Choisir sur la carte</td>
                <td>
                    <div id="map" style="height: 300px;"></div>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Soumettre Réclamation"></td>
            </tr>
        </table>
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
