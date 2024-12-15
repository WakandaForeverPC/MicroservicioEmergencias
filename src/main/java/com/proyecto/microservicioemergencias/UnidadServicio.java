package com.proyecto.microservicioemergencias;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Service
public class UnidadServicio {
    private final List<Unidad> units = List.of(
            new Unidad("Ambulancia 1", 19.432608, -99.133209),
            new Unidad("Camión de Bomberos 3", 19.437923, -99.142343),
            new Unidad("Patrulla 7", 19.428345, -99.127658),
            new Unidad("Ambulancia 2", 19.420645, -99.127541),
            new Unidad("Camión de Bomberos 1", 19.450072, -99.129532),
            new Unidad("Patrulla 5", 19.438763, -99.136565),
            new Unidad("Ambulancia 3", 19.415107, -99.131359),
            new Unidad("Camión de Bomberos 4", 19.422943, -99.124256),
            new Unidad("Patrulla 1", 19.446105, -99.141827),
            new Unidad("Ambulancia 4", 19.445078, -99.130513),
            new Unidad("Camión de Bomberos 2", 19.420297, -99.142541),
            new Unidad("Patrulla 8", 19.437601, -99.133829),
            new Unidad("Ambulancia 5", 19.419640, -99.138003),
            new Unidad("Camión de Bomberos 5", 19.438776, -99.125043),
            new Unidad("Patrulla 2", 19.451217, -99.134295),
            new Unidad("Ambulancia 6", 19.433592, -99.130848),
            new Unidad("Camión de Bomberos 6", 19.431768, -99.124356),
            new Unidad("Patrulla 4", 19.423580, -99.129312),
            new Unidad("Ambulancia 7", 19.429722, -99.124749),
            new Unidad("Camión de Bomberos 7", 19.436604, -99.139488),
            new Unidad("Patrulla 3", 19.440063, -99.131439),
            new Unidad("Ambulancia 8", 19.415292, -99.126295),
            new Unidad("Camión de Bomberos 8", 19.434903, -99.118944),
            new Unidad("Patrulla 6", 19.419530, -99.134167),
            new Unidad("Ambulancia 9", 19.430853, -99.119045),
            new Unidad("Camión de Bomberos 9", 19.422208, -99.140113),
            new Unidad("Patrulla 9", 19.429474, -99.135684),
            new Unidad("Ambulancia 10", 19.444015, -99.128246),
            new Unidad("Camión de Bomberos 10", 19.439032, -99.132956),
            new Unidad("Patrulla 10", 19.440674, -99.121972)

    );

    public Flux<Unidad> getUnits() {
        return Flux.fromIterable(units)
                .delayElements(Duration.ofSeconds(2));
    }
}
