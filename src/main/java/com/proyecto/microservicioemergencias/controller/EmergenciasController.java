package com.proyecto.microservicioemergencias.controller;

import com.proyecto.microservicioemergencias.model.Alerta;
import com.proyecto.microservicioemergencias.model.EmergencyVehicle;
import com.proyecto.microservicioemergencias.model.Rescate;
import com.proyecto.microservicioemergencias.service.AlertaServicio;
import com.proyecto.microservicioemergencias.service.EmergencyVehicleService;
import com.proyecto.microservicioemergencias.service.RescateServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emergencias")
public class EmergenciasController {

    private final EmergencyVehicleService vehicleService;
    private final AlertaServicio alertaServicio;
    private final RescateServicio rescateServicio;

    public EmergenciasController(EmergencyVehicleService vehicleService, AlertaServicio alertaServicio, RescateServicio rescateServicio) {
        this.vehicleService = vehicleService;
        this.alertaServicio = alertaServicio;
        this.rescateServicio = rescateServicio;
    }

    @GetMapping("/vehiculos")
    @ResponseBody
    public List<EmergencyVehicle> getVehicles() {
        vehicleService.moveVehicles();
        return vehicleService.getVehicles();
    }

    @GetMapping("/alertas")
    @ResponseBody
    public List<Alerta> getAlertas() {
        return alertaServicio.getAlertas().collectList().block();
    }

    @GetMapping("/rescates")
    @ResponseBody
    public List<Rescate> getRescates() {
        return rescateServicio.getRescates().collectList().block();
    }
}