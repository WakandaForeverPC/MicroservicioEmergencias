package com.proyecto.microservicioemergencias;

public class EmergencyVehicle {
    private String id;
    private double latitude;
    private double longitude;
    private String type; // Tipo de vehículo (ambulancia, bomberos, policía)

    public EmergencyVehicle(String id, double latitude, double longitude, String type) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}