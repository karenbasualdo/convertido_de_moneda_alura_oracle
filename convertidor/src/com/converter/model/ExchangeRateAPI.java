package com.converter.model;

import com.converter.utils.JsonParserUtil;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ExchangeRateAPI {
    private static final String API_KEY = "23cfb2051a096d681aca7036"; // Tu clave de API
    private static final String API_URL = "https://open.er-api.com/v6/latest/";

    // Método para obtener la tasa de cambio
    public static double getExchangeRate(String baseCurrency, String targetCurrency) {
        try {
            // Conecta a la API utilizando la clave API
            String urlWithKey = API_URL + baseCurrency + "?apikey=" + API_KEY;
            URL url = new URL(urlWithKey);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            // Verifica el código de respuesta
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Error en la conexión: Código " + responseCode);
            }

            // Lee la respuesta
            Scanner scanner = new Scanner(connection.getInputStream());
            StringBuilder jsonResponse = new StringBuilder();
            while (scanner.hasNext()) {
                jsonResponse.append(scanner.nextLine());
            }
            scanner.close();

            // Analiza el JSON para obtener la tasa de cambio
            return JsonParserUtil.parseExchangeRate(jsonResponse.toString(), targetCurrency);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la tasa de cambio: " + e.getMessage());
        }
    }
}
