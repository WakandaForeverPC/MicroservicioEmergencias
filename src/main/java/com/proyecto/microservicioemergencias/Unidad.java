package com.proyecto.microservicioemergencias;

public class Unidad {
    private String nombre;
    private double latitude;
    private double longitude;

    public Unidad(String nombre, double latitude, double longitude) {
        this.nombre = nombre;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNombre() {
        return nombre;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
