package com.proyecto.microservicioemergencias.controller;

import com.proyecto.microservicioemergencias.Unidad;
import com.proyecto.microservicioemergencias.UnidadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmergenciasController {

    @GetMapping("/emergencias")
    public String showEmergencies() {
        return "board-emergencias";
    }

    @Autowired
    private UnidadServicio unidadServicio;

    @GetMapping("/emergencias/unidades")
    @ResponseBody
    public List<Unidad> getUnidades() {
        return unidadServicio.getUnits().collectList().block();
    }
}