package com.proyecto.microservicioemergencias.service;

import com.proyecto.microservicioemergencias.model.Alerta;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class AlertaServicio {
    private final List<Alerta> alertas = List.of(
            new Alerta("Terremoto", 0, 0),
            new Alerta("Incendio", 2, 0)
    );

    public Flux<Alerta> getAlertas() {
        return Flux.fromIterable(alertas);
    }
}