package com.proyecto.microservicioemergencias;

public class Alerta {
    private String mensaje;
    private double latitude;
    private double longitude;

    public Alerta(String mensaje, double latitude, double longitude) {
        this.mensaje = mensaje;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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