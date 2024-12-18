package com.proyecto.microservicioemergencias.service;

import com.proyecto.microservicioemergencias.model.EmergencyVehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class EmergencyVehicleService {
    private List<EmergencyVehicle> vehicles;

    public EmergencyVehicleService() {
        vehicles = new ArrayList<>();
        vehicles.add(new EmergencyVehicle("vehicle1", 6, 6, "ambulancia"));
        vehicles.add(new EmergencyVehicle("vehicle2", 2, 4, "bomberos"));
    }

    public List<EmergencyVehicle> getVehicles() {
        return vehicles;
    }

    public void moveVehicles() {
        Random rd = new Random();
        for (EmergencyVehicle vehicle : vehicles) {
            int direction = rd.nextInt(4);
            switch (direction) {
                case 0: // Move up
                    vehicle.setY(vehicle.getY() - 1);
                    break;
                case 1: // Move down
                    vehicle.setY(vehicle.getY() + 1);
                    break;
                case 2: // Move left
                    vehicle.setX(vehicle.getX() - 1);
                    break;
                case 3: // Move right
                    vehicle.setX(vehicle.getX() + 1);
                    break;
            }
            // Ensure the vehicle stays within the grid bounds
            vehicle.setX(Math.max(0, Math.min(vehicle.getX(), 8)));
            vehicle.setY(Math.max(0, Math.min(vehicle.getY(), 6)));
        }
    }
}