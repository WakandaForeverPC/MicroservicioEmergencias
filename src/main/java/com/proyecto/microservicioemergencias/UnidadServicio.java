package com.proyecto.microservicioemergencias;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Service
public class UnidadServicio {
    private final List<Unidad> units = List.of(
            new Unidad("Ambulancia 1", 19.432608, -99.133209),
            new Unidad("Bomberos 1", 19.432608, -99.133209),
            new Unidad("Policía 1", 19.432608, -99.133209)
    );

    public Flux<Unidad> getUnits() {
        return Flux.fromIterable(units)
                .delayElements(Duration.ofSeconds(2));
    }
}