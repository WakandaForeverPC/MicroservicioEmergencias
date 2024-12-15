package com.proyecto.microservicioemergencias.controller;

import com.proyecto.microservicioemergencias.Unidad;
import com.proyecto.microservicioemergencias.UnidadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/emergencias")
public class EmergenciasController {

    @Autowired
    private UnidadServicio unidadServicio;

    @GetMapping("/unidades")
    public Flux<Unidad> obtenerUnidadesCercanas() {
        return unidadServicio.getUnits();
    }

    @PostMapping
    public String crearEmergencia(@RequestBody String nuevaEmergencia) {
        // Lógica para manejar la emergencia (simulación)
        return "Nueva emergencia creada: " + nuevaEmergencia;
    }

    @PostMapping("/alerta")
    public String enviarAlerta(@RequestBody String alerta) {
        // Lógica para manejar la alerta (simulación)
        return "Alerta enviada: " + alerta;
    }

    @PostMapping("/rescatar")
    public String iniciarRescate(@RequestBody String ubicacion) {
        // Lógica para simular rescate
        return "Dron desplegado hacia la ubicación: " + ubicacion;
    }
}
