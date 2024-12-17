package com.proyecto.microservicioemergencias;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EmergencyWebSocketService {

    private final SimpMessagingTemplate template;
    private final EmergencyVehicleService vehicleService;

    public EmergencyWebSocketService(SimpMessagingTemplate template, EmergencyVehicleService vehicleService) {
        this.template = template;
        this.vehicleService = vehicleService;
    }

    @Scheduled(fixedRate = 2000)
    public void sendUpdates() {
        template.convertAndSend("/topic/updates", vehicleService.getVehicles());
    }
}