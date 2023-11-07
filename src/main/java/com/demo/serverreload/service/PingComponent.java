package com.demo.serverreload.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class PingComponent {

    private static final List<String> URLs_TO_PING = Arrays.asList(
            "https://google.com",
            "https://project-nico.onrender.com",
            "https://server-reload.onrender.com/cargar"
            // Agrega todas las URLs que necesites aquí
    );

    @PostConstruct
    public void init() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Programa la tarea para ejecutarse cada 15 segundos
        scheduler.scheduleAtFixedRate(() -> {
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
        }, 0, 3, TimeUnit.MINUTES); // 0 segundos de demora inicial, luego ejecuta cada 15 segundos
    }
}
