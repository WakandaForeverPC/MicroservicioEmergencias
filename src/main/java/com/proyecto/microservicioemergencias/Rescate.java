package com.proyecto.microservicioemergencias;

public class Rescate {
    private String descripcion;
    private double latitude;
    private double longitude;
    private String tecnologia; // Tecnología utilizada (drones, vehículos autónomos, sensores)

    public Rescate(String descripcion, double latitude, double longitude, String tecnologia) {
        this.descripcion = descripcion;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tecnologia = tecnologia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }
}