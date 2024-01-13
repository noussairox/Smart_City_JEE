package util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Adresse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class NominatimGeoCoder {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Adresse getFullAddress(String lat, String lon) throws IOException {
        String url = String.format("https://nominatim.openstreetmap.org/reverse?format=json&lat=%s&lon=%s", lat, lon);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream(), StandardCharsets.UTF_8))) {
            StringBuilder result = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            // Utiliser Jackson pour traiter la réponse JSON
            JsonNode rootNode = objectMapper.readTree(result.toString());

            JsonNode addressNode = rootNode.path("address");

            // Construire et retourner l'objet Adresse à partir de la réponse JSON
            Adresse adresse = new Adresse();
            adresse.setAmenity(addressNode.path("amenity").asText());
            adresse.setRoad(addressNode.path("road").asText());
            adresse.setSuburb(addressNode.path("suburb").asText());
            adresse.setCity(addressNode.path("city").asText());
            return adresse;
        }
    }
}
