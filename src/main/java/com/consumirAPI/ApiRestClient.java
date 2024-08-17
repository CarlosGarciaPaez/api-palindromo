package com.consumirAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiRestClient {
	public static void main(String[] args) {
        // a) Declarar una variable String con tu nombre
        String name = "Carlos";

        // b) Completar la URL con el parámetro name
        String urlString = "https://sisedevco.ikeasistencia.com/api-swagger/api/v1/controller/test?name=" + name;

        try {
            // c) Configurar la conexión y el método GET
            @SuppressWarnings("deprecation")
			URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // d) Validar el código de respuesta
            int responseCode = conn.getResponseCode();

            if (responseCode == 302) { // Código cuando encuentra coincidencia
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                // Extraer el nombre de la respuesta JSON
                String output = content.toString();
                // Parsear el nombre utilizando split
                String[] outputParts = output.split("\"nombre\":\"");
                if (outputParts.length > 1) {
                    String nombre = outputParts[1].split("\"")[0];
                    System.out.println("Nombre encontrado: " + nombre);
                }

            } else if (responseCode == 404) { // Código cuando no se encuentra la coincidencia
                System.out.println("Sin resultados.");
            } else {
                System.out.println("Código de respuesta no esperado: " + responseCode);
            }

        } catch (Exception e) {
            // f) Manejo de excepciones
            e.printStackTrace();
            System.out.println("Ocurrió una excepción: " + e.getMessage());
        }
    }
}
