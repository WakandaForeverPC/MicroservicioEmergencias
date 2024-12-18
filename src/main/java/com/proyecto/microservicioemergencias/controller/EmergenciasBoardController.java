package com.proyecto.microservicioemergencias.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmergenciasBoardController {

    @GetMapping("/emergencias")
    public String getEmergenciasPage() {
        return "board-emergencias";
    }
}
