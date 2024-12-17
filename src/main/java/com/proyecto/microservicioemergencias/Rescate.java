package com.proyecto.microservicioemergencias;

public class Rescate {
    private String descripcion;
    private double latitude;
    private double longitude;

    public Rescate(String descripcion, double latitude, double longitude) {
        this.descripcion = descripcion;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
}