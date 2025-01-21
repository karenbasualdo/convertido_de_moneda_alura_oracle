package com.converter.service;

import com.converter.utils.TimestampUtil;

import java.util.ArrayList;
import java.util.List;

public class HistoryService {
    private final List<String> history = new ArrayList<>();

    public void addConversion(String baseCurrency, String targetCurrency, double amount, double result) {
        String timestamp = TimestampUtil.getCurrentTimestamp();
        String record = String.format("%s: %.2f %s -> %.2f %s", timestamp, amount, baseCurrency, result, targetCurrency);
        history.add(record);
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No hay conversiones registradas.");
        } else {
            System.out.println("Historial de Conversiones:");
            for (String record : history) {
                System.out.println(record);
            }
        }
    }
}

