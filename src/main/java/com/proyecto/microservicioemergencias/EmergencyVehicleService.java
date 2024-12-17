package com.proyecto.microservicioemergencias;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class EmergencyVehicleService {
    private List<EmergencyVehicle> vehicles;

    public EmergencyVehicleService() {
        vehicles = new ArrayList<>();
        vehicles.add(new EmergencyVehicle("vehicle1", 19.432608, -99.133209, "ambulancia"));
        vehicles.add(new EmergencyVehicle("vehicle2", 19.432608, -99.133209, "bomberos"));
        vehicles.add(new EmergencyVehicle("vehicle3", 19.432608, -99.133209, "policía"));
    }

    public List<EmergencyVehicle> getVehicles() {
        return vehicles;
    }

    public void moveVehicles() {
        Random random = new Random();
        for (EmergencyVehicle vehicle : vehicles) {
            vehicle.setLatitude(vehicle.getLatitude() + (random.nextDouble() - 0.5) * 0.01);
            vehicle.setLongitude(vehicle.getLongitude() + (random.nextDouble() - 0.5) * 0.01);
        }
    }
}