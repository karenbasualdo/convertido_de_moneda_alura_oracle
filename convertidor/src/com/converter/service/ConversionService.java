package com.converter.service;

import com.converter.model.Currency;
import com.converter.model.ExchangeRateAPI;

import java.util.Scanner;

public class ConversionService {
    public void handleConversion(Scanner scanner, HistoryService historyService) {
        try {
            // Mostrar monedas disponibles
            System.out.println("\nMonedas disponibles para convertir:");
            Currency.printSupportedCurrencies();

            // Solicitar moneda base
            System.out.print("\nIngresa la moneda base (ej. USD): ");
            String baseCurrency = scanner.next().toUpperCase();

            if (!Currency.isValidCurrency(baseCurrency)) {
                System.out.println("Moneda base no válida. Intenta de nuevo.");
                return; // Salimos del método si la moneda no es válida
            }

            // Solicitar moneda destino
            System.out.print("Ingresa la moneda destino (ej. EUR): ");
            String targetCurrency = scanner.next().toUpperCase();

            if (!Currency.isValidCurrency(targetCurrency)) {
                System.out.println("Moneda destino no válida. Intenta de nuevo.");
                return; // Salimos del método si la moneda no es válida
            }

            // Solicitar cantidad
            System.out.print("Ingresa la cantidad a convertir: ");
            double amount = scanner.nextDouble();

            // Calcular y mostrar el resultado
            double rate = ExchangeRateAPI.getExchangeRate(baseCurrency, targetCurrency);
            double convertedAmount = amount * rate;

            System.out.printf("Resultado: %.2f %s = %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);
            historyService.addConversion(baseCurrency, targetCurrency, amount, convertedAmount);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

