package com.proyecto.microservicioemergencias;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Service
public class AlertaServicio {
    private final List<Alerta> alertas = List.of(
            new Alerta("Terremoto", 19.432608, -99.133209),
            new Alerta("Incendio", 19.432608, -99.133209)
    );

    public Flux<Alerta> getAlertas() {
        return Flux.fromIterable(alertas)
                .delayElements(Duration.ofSeconds(2));
    }
}