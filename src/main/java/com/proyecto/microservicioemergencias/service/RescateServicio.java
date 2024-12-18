package com.proyecto.microservicioemergencias.service;

import com.proyecto.microservicioemergencias.model.Rescate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class RescateServicio {
    private final List<Rescate> rescates = List.of(
            new Rescate("Rescate en edificio colapsado", 4, 4, "drones"),
            new Rescate("Rescate en incendio forestal", 6, 6, "vehículos autónomos")
    );

    public Flux<Rescate> getRescates() {
        return Flux.fromIterable(rescates);
    }
}