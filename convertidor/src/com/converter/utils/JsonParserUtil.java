package com.converter.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonParserUtil {
    // Método para obtener la tasa de cambio desde la respuesta JSON
    public static double parseExchangeRate(String jsonResponse, String targetCurrency) {
        try {
            // Analiza la respuesta JSON
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            JsonObject rates = jsonObject.getAsJsonObject("rates");

            // Obtiene la tasa de la moneda deseada
            return rates.get(targetCurrency).getAsDouble();
        } catch (Exception e) {
            throw new RuntimeException("Error al analizar el JSON: " + e.getMessage());
        }
    }
}
