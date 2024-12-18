package com.proyecto.microservicioemergencias.model;

public class Rescate {
    private String descripcion;
    private int x;
    private int y;
    private String tecnologia; // Tecnología utilizada (drones, vehículos autónomos, sensores)

    public Rescate(String descripcion, int x, int y, String tecnologia) {
        this.descripcion = descripcion;
        this.x = x;
        this.y = y;
        this.tecnologia = tecnologia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }
}

