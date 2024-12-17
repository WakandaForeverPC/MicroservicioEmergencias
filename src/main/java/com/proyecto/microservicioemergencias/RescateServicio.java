package com.proyecto.microservicioemergencias;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class RescateServicio {
    private final List<Rescate> rescates = List.of(
            new Rescate("Rescate en edificio colapsado", 19.432608, -99.133209, "drones"),
            new Rescate("Rescate en incendio forestal", 19.432608, -99.133209, "vehículos autónomos")
    );

    public Flux<Rescate> getRescates() {
        return Flux.fromIterable(rescates);
    }
}