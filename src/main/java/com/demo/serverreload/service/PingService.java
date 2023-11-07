package com.demo.serverreload.service;

import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.Arrays;
import java.util.List;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class PingService {

    private static final List<String> URLs_TO_PING = Arrays.asList(
            "https://google.com",
            //"https://ping-server-reload.onrender.com",
            "https://project-nico.onrender.com"
    );

    @Scheduled(fixedRate = 240000) // 15000 milisegundos = 15 segundos
    public void enviarSolicitudesPeriodicas() {
        for (String url : URLs_TO_PING) {
            try {
                // Realiza una solicitud GET a la URL
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("GET");

                // Obtiene la respuesta del servidor (código de respuesta)
                int responseCode = connection.getResponseCode();
                System.out.println("Respuesta de " + url + ": " + responseCode);

                // Cierra la conexión
                connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace(); // Maneja cualquier excepción que pueda ocurrir durante la solicitud
            }
        }
    }
}
