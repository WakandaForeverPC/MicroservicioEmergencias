package com.proyecto.microservicioemergencias.controller;

import com.proyecto.microservicioemergencias.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmergenciasController {

    private final EmergencyVehicleService vehicleService;
    private final AlertaServicio alertaServicio;
    private final RescateServicio rescateServicio;

    public EmergenciasController(EmergencyVehicleService vehicleService, AlertaServicio alertaServicio, RescateServicio rescateServicio) {
        this.vehicleService = vehicleService;
        this.alertaServicio = alertaServicio;
        this.rescateServicio = rescateServicio;
    }

    @GetMapping("/emergencias/vehiculos")
    public List<EmergencyVehicle> getVehicles() {
        vehicleService.moveVehicles();
        return vehicleService.getVehicles();
    }

    @GetMapping("/emergencias/alertas")
    public List<Alerta> getAlertas() {
        return alertaServicio.getAlertas().collectList().block();
    }

    @GetMapping("/emergencias/rescates")
    public List<Rescate> getRescates() {
        return rescateServicio.getRescates().collectList().block();
    }

    @RequestMapping("/emergencias")
    public String getEmergenciasPage() {
        return "board-emergencias";
    }
}