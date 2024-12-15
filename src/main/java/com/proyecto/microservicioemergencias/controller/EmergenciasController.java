package com.proyecto.microservicioemergencias.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emergencias")
public class EmergenciasController {

    @GetMapping
    public String obtenerEmergencias() {
        // Lógica para obtener información de emergencias
        return "Información de emergencias";
    }

    @PostMapping
    public String crearEmergencia(@RequestBody String nuevaEmergencia) {
        // Lógica para crear nueva información de emergencias
        return "Nueva emergencia creada";
    }
}