package com.converter;

import com.converter.model.Currency;
import com.converter.service.ConversionService;
import com.converter.service.HistoryService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ConversionService conversionService = new ConversionService();
        HistoryService historyService = new HistoryService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al Convertidor de Monedas!");
        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Ver historial de conversiones");
            System.out.println("3. Ver monedas disponibles");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    conversionService.handleConversion(scanner, historyService);
                    break;
                case 2:
                    historyService.showHistory();
                    break;
                case 3:
                    Currency.printSupportedCurrencies();
                    break;
                case 4:
                    System.out.println("¡Gracias por usar el convertidor de monedas!");
                    return;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
}

