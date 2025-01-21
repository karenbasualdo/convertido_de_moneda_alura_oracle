package com.converter.model;

public class Currency {
    private String code;
    private String name;

    // Constructor
    public Currency(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return code + " - " + name;
    }

    // Lista estática de monedas soportadas
    public static final Currency[] SUPPORTED_CURRENCIES = {
            new Currency("ARS", "Peso argentino"),
            new Currency("BOB", "Boliviano"),
            new Currency("BRL", "Real brasileño"),
            new Currency("CLP", "Peso chileno"),
            new Currency("COP", "Peso colombiano"),
            new Currency("USD", "Dólar estadounidense")
    };

    // Método para validar si una moneda está soportada
    public static boolean isValidCurrency(String code) {
        for (Currency currency : SUPPORTED_CURRENCIES) {
            if (currency.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    // Método para imprimir las monedas soportadas
    public static void printSupportedCurrencies() {
        System.out.println("Monedas disponibles:");
        for (Currency currency : SUPPORTED_CURRENCIES) {
            System.out.println(currency);
        }
    }
}
