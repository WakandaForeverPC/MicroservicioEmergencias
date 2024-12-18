package com.proyecto.microservicioemergencias.model;

public class EmergencyVehicle {
    private String id;
    private int x;
    private int y;
    private String type; // Tipo de vehículo (ambulancia, bomberos, policía)

    public EmergencyVehicle(String id,  int x, int y, String type) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}