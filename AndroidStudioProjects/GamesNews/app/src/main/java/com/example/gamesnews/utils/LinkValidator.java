package com.example.gamesnews.utils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class LinkValidator {

    public static boolean isValidLink(String link) {
        if (link == null || link.isEmpty()) {
            return false;
        }

        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD"); // Apenas obter o cabeçalho
            connection.setConnectTimeout(3000); // Tempo limite de conexão
            connection.setReadTimeout(3000);    // Tempo limite de leitura
            int responseCode = connection.getResponseCode();
            return responseCode >= 200 && responseCode < 400; // Status HTTP de sucesso
        } catch (IOException e) {
            return false;
        }
    }
}
