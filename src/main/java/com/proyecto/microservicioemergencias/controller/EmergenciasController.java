package com.proyecto.microservicioemergencias.controller;

import com.proyecto.microservicioemergencias.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class EmergenciasController {

    @Autowired
    private UnidadServicio unidadServicio;

    @Autowired
    private AlertaServicio alertaServicio;

    @Autowired
    private RescateServicio rescateServicio;

    @GetMapping("/salud")
    public String showEmergencies() {
        return "board-emergencias";
    }

    @GetMapping("/emergencias/unidades")
    public Flux<Unidad> getUnidades() {
        return unidadServicio.getUnits();
    }

    @GetMapping("/emergencias/alertas")
    public Flux<Alerta> getAlertas() {
        return alertaServicio.getAlertas();
    }

    @GetMapping("/emergencias/rescates")
    public Flux<Rescate> getRescates() {
        return rescateServicio.getRescates();
    }
}